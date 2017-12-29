package com.clz.FlowAikanRecords.service.Impl;

import com.clz.FlowAikanRecords.bean.FlowAikanRecords;
import com.clz.FlowAikanRecords.bean.FlowAikanRecordsExample;
import com.clz.FlowAikanRecords.dao.FlowAikanRecordsMapper;
import com.clz.FlowAikanRecords.service.FlowAikanRecordsService;
import com.clz.FlowAikanRecords.vo.RequestVo;
import com.clz.FlowAikanRecords.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
@Service
public class FlowAikanRecordsServiceImpl implements FlowAikanRecordsService {

    @Autowired
    private FlowAikanRecordsMapper flowAikanRecordsMapper;

    public List<FlowAikanRecords> findById(String id) {
        FlowAikanRecordsExample example = new FlowAikanRecordsExample();
        example.createCriteria().andNumLike("%" + id + "%");
        List<FlowAikanRecords> list = flowAikanRecordsMapper.selectByExample(example);
        return list;
    }

    public List<FlowAikanRecords> listByPage(String pageSize, String pageNo) {
        FlowAikanRecordsExample example = new FlowAikanRecordsExample();
        PageHelper.startPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        List<FlowAikanRecords> lists = flowAikanRecordsMapper.selectByExample(example);
        return lists;
    }

    public List<ResponseVo> findByRequest(RequestVo requestVo) {
        List<ResponseVo> list = flowAikanRecordsMapper.findByRequest(requestVo);
        return list;
    }
}
