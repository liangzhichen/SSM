package com.clz.FlowAikanRecords.service;

import com.clz.FlowAikanRecords.bean.FlowAikanRecords;
import com.clz.FlowAikanRecords.vo.RequestVo;
import com.clz.FlowAikanRecords.vo.ResponseVo;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
public interface FlowAikanRecordsService {
    public List<FlowAikanRecords> findById(String id);

    List<FlowAikanRecords> listByPage(String pageSize, String pageNo);

    List<ResponseVo> findByRequest(RequestVo requestVo);
}
