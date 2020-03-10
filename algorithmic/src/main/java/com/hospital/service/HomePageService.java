package com.hospital.service;

import com.hospital.pojo.Hospital;
import com.hospital.pojo.HospitalRanking;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxl
 */
public class HomePageService {

    private HospitalInfoService hospitalInfoService;
    private HospitalRankingService hospitalRankingService;
    //生产环境可以存储到redis
    Map<String, List<Hospital>> cacheRead = new HashMap<>();
    Map<String, List<Hospital>> cacheUpdate = new ConcurrentHashMap<>();
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public List<Hospital> get(String regionId) {
        //查询区域排名信息
        if (cacheUpdate.containsKey(regionId)) {
            cacheRead.put(regionId, cacheUpdate.get(regionId));
        }
        if (cacheRead.containsKey(regionId)) {
            return cacheRead.get(regionId);
        } else {
            service.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {

                    updateCache(regionId);
                }
            }, 1, 1, TimeUnit.SECONDS);
            return this.updateCache(regionId);
        }
    }

    //异步线程统一更新已经有的区域数据；
    private void asyUpdate() {
        //如果有所有区域，也可以用所有区域的列表更新
        if (cacheRead.size() > 0) {
            List<String> regionIds = new ArrayList<>(cacheRead.keySet());
            for (String regoinId : regionIds) {
                this.updateCache(regoinId);
            }
        }
    }

    private List<Hospital> updateCache(String regionId) {
        List<Hospital> hospitals = new ArrayList<>();
        Map<Long, Integer> currentScore = new HashMap<>();
        try {

            List<HospitalRanking> hospitalRankings = hospitalRankingService.getRanking(regionId);
            if (hospitalRankings != null && hospitalRankings.size() > 0) {
                for (HospitalRanking hospitalRanking : hospitalRankings) {
                    currentScore.put(hospitalRanking.getId(), hospitalRanking.getScore());
                }
            }

            if (currentScore != null && currentScore.size() > 0) {
                List<Long> ids = new ArrayList(currentScore.keySet());
                hospitals = hospitalInfoService.getHospitalSbyIds(ids);
                for (Hospital hospital : hospitals) {
                    hospital.setScore(currentScore.get(hospital.getId()));
                }
            }
            if (hospitals.size() > 0) {
                if (cacheUpdate.containsKey(regionId)) {

                } else {
                    cacheUpdate.put(regionId, hospitals);
                }
            }
            return hospitals;
        } catch (Exception e) {
            e.printStackTrace();
            return hospitals;
        }
    }
}
