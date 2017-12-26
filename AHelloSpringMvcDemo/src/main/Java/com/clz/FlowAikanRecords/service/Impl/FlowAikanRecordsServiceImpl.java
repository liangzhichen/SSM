package com.clz.FlowAikanRecords.service.Impl;

import com.clz.FlowAikanRecords.bean.FlowAikanRecords;
import com.clz.FlowAikanRecords.bean.FlowAikanRecordsExample;
import com.clz.FlowAikanRecords.dao.FlowAikanRecordsMapper;
import com.clz.FlowAikanRecords.service.FlowAikanRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
@Service
public class FlowAikanRecordsServiceImpl implements FlowAikanRecordsService{

    @Autowired
    private FlowAikanRecordsMapper flowAikanRecordsMapper;

    public List<FlowAikanRecords> findById(String id) {
        FlowAikanRecordsExample example = new FlowAikanRecordsExample();
        example.createCriteria().andNumLike("%"+id+"%");
        List<FlowAikanRecords> list = flowAikanRecordsMapper.selectByExample(example);
        return list;
    }
}
