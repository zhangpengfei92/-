package com.jcl.dao;

import com.jcl.pojo.FeeschemeMenu;
import com.jcl.pojo.FeeschemeMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeschemeMenuMapper {
    long countByExample(FeeschemeMenuExample example);

    int deleteByExample(FeeschemeMenuExample example);

    int deleteByPrimaryKey(Integer lsh);

    int insert(FeeschemeMenu record);

    int insertSelective(FeeschemeMenu record);

    List<FeeschemeMenu> selectByExample(FeeschemeMenuExample example);

    FeeschemeMenu selectByPrimaryKey(Integer lsh);

    int updateByExampleSelective(@Param("record") FeeschemeMenu record, @Param("example") FeeschemeMenuExample example);

    int updateByExample(@Param("record") FeeschemeMenu record, @Param("example") FeeschemeMenuExample example);

    int updateByPrimaryKeySelective(FeeschemeMenu record);

    int updateByPrimaryKey(FeeschemeMenu record);
    
    List<FeeschemeMenu> selectAll();
	
	List<FeeschemeMenu> isExist(@Param(value = "subzhName")String subzh, @Param(value = "id")Integer id);
	
}