package com.jcl.dao;

import com.jcl.pojo.RiskLog;
import com.jcl.pojo.RiskLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskLogMapper {
    long countByExample(RiskLogExample example);

    int deleteByExample(RiskLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskLog record);

    int insertSelective(RiskLog record);

    List<RiskLog> selectByExample(RiskLogExample example);

    RiskLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskLog record, @Param("example") RiskLogExample example);

    int updateByExample(@Param("record") RiskLog record, @Param("example") RiskLogExample example);

    int updateByPrimaryKeySelective(RiskLog record);

    int updateByPrimaryKey(RiskLog record);
}