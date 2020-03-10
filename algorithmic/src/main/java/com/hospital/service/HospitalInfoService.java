package com.hospital.service;

import com.hospital.pojo.Hospital;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxl
 */
public class HospitalInfoService {
    public List<Hospital> getHospitalSbyIds(List<Long> ids) {
        //此处实际调用外部接口
        List<Hospital> hospitals = new ArrayList<>();
        return hospitals;
    }
}
