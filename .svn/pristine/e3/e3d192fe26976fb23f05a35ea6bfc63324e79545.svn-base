package com.jcl.dao;

import com.jcl.pojo.Agentzh;
import com.jcl.pojo.AgentzhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentzhMapper {
    int countByExample(AgentzhExample example);

    int deleteByExample(AgentzhExample example);

    int deleteByPrimaryKey(String agentzh);

    int insert(Agentzh record);

    int insertSelective(Agentzh record);

    List<Agentzh> selectByExample(AgentzhExample example);

    Agentzh selectByPrimaryKey(String agentzh);

    int updateByExampleSelective(@Param("record") Agentzh record, @Param("example") AgentzhExample example);

    int updateByExample(@Param("record") Agentzh record, @Param("example") AgentzhExample example);

    int updateByPrimaryKeySelective(Agentzh record);

    int updateByPrimaryKey(Agentzh record);
}