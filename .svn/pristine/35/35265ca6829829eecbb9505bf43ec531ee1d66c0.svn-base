package com.jcl.dao;

import com.jcl.pojo.RiskTemplate;
import com.jcl.pojo.RiskTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskTemplateMapper {
    int countByExample(RiskTemplateExample example);

    int deleteByExample(RiskTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskTemplate record);

    int insertSelective(RiskTemplate record);

    List<RiskTemplate> selectByExample(RiskTemplateExample example);

    RiskTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskTemplate record, @Param("example") RiskTemplateExample example);

    int updateByExample(@Param("record") RiskTemplate record, @Param("example") RiskTemplateExample example);

    int updateByPrimaryKeySelective(RiskTemplate record);

    int updateByPrimaryKey(RiskTemplate record);
}