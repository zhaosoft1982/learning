package com.hospital.service;

import com.hospital.pojo.HospitalRanking;

import java.util.ArrayList;
import java.util.List;
public class HospitalRankingService {
    public List<HospitalRanking> getRanking(String regionId) {
        //此处实际调用外部接口,只返回前十名数据
        List<HospitalRanking> hospitalRankings = new ArrayList<>();
        return hospitalRankings;
    }
}
