package com.tick.mapper;

import com.tick.pojo.mybatis.TickRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TickRecordMapper {
    List<TickRecord> getTickRecords(@Param("taskId") Long taskId);
    void removeTickRecord(@Param("taskId") Long taskId, @Param("date") String date);
    void addTickRecord(@Param("taskId") Long taskId, @Param("date") String date);
    void removeTaskTickRecord(@Param("taskId") Long taskId);
}
