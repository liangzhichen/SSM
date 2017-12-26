package com.clz.FlowAikanRecords.service;

import com.clz.FlowAikanRecords.bean.FlowAikanRecords;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
public interface FlowAikanRecordsService {
    public List<FlowAikanRecords> findById(String id);
}
