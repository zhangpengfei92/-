package com.jcl.dao;

import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.AgentzhfundLogExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AgentzhfundLogMapper {
	
	List<AgentzhfundLog> selectAll();
	
	List<AgentzhfundLog> isExist(@Param(value = "subzhName")String subzh);
	
    long countByExample(AgentzhfundLogExample example);

    int deleteByExample(AgentzhfundLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgentzhfundLog record);

    int insertSelective(AgentzhfundLog record);

    List<AgentzhfundLog> selectByExampleWithBLOBs(AgentzhfundLogExample example);

    List<AgentzhfundLog> selectByExample(AgentzhfundLogExample example);

    AgentzhfundLog selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") AgentzhfundLog record, @Param("example") AgentzhfundLogExample example);

    int updateByExampleWithBLOBs(@Param("record") AgentzhfundLog record, @Param("example") AgentzhfundLogExample example);

    int updateByExample(@Param("record") AgentzhfundLog record, @Param("example") AgentzhfundLogExample example);

    int updateByPrimaryKeySelective(AgentzhfundLog record);

    int updateByPrimaryKeyWithBLOBs(AgentzhfundLog record);

    int updateByPrimaryKey(AgentzhfundLog record);

	List<AgentzhfundLog> selectByorderno(@Param("orderno") String orderno);
}