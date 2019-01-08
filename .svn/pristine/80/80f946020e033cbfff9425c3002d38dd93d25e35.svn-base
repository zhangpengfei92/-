package com.jcl.dao;

import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.CodefeesetMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodefeesetMenuMapper {
    long countByExample(CodefeesetMenuExample example);

    int deleteByExample(CodefeesetMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CodefeesetMenu record);

    int insertSelective(CodefeesetMenu record);

    List<CodefeesetMenu> selectByExample(CodefeesetMenuExample example);

    CodefeesetMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CodefeesetMenu record, @Param("example") CodefeesetMenuExample example);

    int updateByExample(@Param("record") CodefeesetMenu record, @Param("example") CodefeesetMenuExample example);

    int updateByPrimaryKeySelective(CodefeesetMenu record);

    int updateByPrimaryKey(CodefeesetMenu record);
    
    List<CodefeesetMenu> selectAll();
	
   	List<CodefeesetMenu> isExist(@Param(value = "subzhName")String subzh, @Param(value = "id")Integer id);
   	
}