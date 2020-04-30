package io.metersphere.base.mapper;

import io.metersphere.base.domain.LoadTestReportLog;
import io.metersphere.base.domain.LoadTestReportLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoadTestReportLogMapper {
    long countByExample(LoadTestReportLogExample example);

    int deleteByExample(LoadTestReportLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LoadTestReportLog record);

    int insertSelective(LoadTestReportLog record);

    List<LoadTestReportLog> selectByExampleWithBLOBs(LoadTestReportLogExample example);

    List<LoadTestReportLog> selectByExample(LoadTestReportLogExample example);

    LoadTestReportLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LoadTestReportLog record, @Param("example") LoadTestReportLogExample example);

    int updateByExampleWithBLOBs(@Param("record") LoadTestReportLog record, @Param("example") LoadTestReportLogExample example);

    int updateByExample(@Param("record") LoadTestReportLog record, @Param("example") LoadTestReportLogExample example);

    int updateByPrimaryKeySelective(LoadTestReportLog record);

    int updateByPrimaryKeyWithBLOBs(LoadTestReportLog record);

    int updateByPrimaryKey(LoadTestReportLog record);
}