package com.clz.FlowAikanRecords.dao;

import com.clz.FlowAikanRecords.bean.FlowAikanRecords;
import com.clz.FlowAikanRecords.bean.FlowAikanRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowAikanRecordsMapper {
    long countByExample(FlowAikanRecordsExample example);

    int deleteByExample(FlowAikanRecordsExample example);

    int insert(FlowAikanRecords record);

    int insertSelective(FlowAikanRecords record);

    List<FlowAikanRecords> selectByExample(FlowAikanRecordsExample example);

    int updateByExampleSelective(@Param("record") FlowAikanRecords record, @Param("example") FlowAikanRecordsExample example);

    int updateByExample(@Param("record") FlowAikanRecords record, @Param("example") FlowAikanRecordsExample example);
}