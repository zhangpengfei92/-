package com.jcl.dao;

import com.jcl.pojo.RiskTemplateMenu;
import com.jcl.pojo.RiskTemplateMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskTemplateMenuMapper {
    int countByExample(RiskTemplateMenuExample example);

    int deleteByExample(RiskTemplateMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskTemplateMenu record);

    int insertSelective(RiskTemplateMenu record);

    List<RiskTemplateMenu> selectByExample(RiskTemplateMenuExample example);

    RiskTemplateMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskTemplateMenu record, @Param("example") RiskTemplateMenuExample example);

    int updateByExample(@Param("record") RiskTemplateMenu record, @Param("example") RiskTemplateMenuExample example);

    int updateByPrimaryKeySelective(RiskTemplateMenu record);

    int updateByPrimaryKey(RiskTemplateMenu record);

	List<RiskTemplateMenu> selectAll();
}