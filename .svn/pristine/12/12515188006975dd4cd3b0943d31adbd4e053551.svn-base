package com.jcl.dao;

import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.BzjmbMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BzjmbMenuMapper {
    long countByExample(BzjmbMenuExample example);

    int deleteByExample(BzjmbMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BzjmbMenu record);

    int insertSelective(BzjmbMenu record);

    List<BzjmbMenu> selectByExample(BzjmbMenuExample example);

    BzjmbMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BzjmbMenu record, @Param("example") BzjmbMenuExample example);

    int updateByExample(@Param("record") BzjmbMenu record, @Param("example") BzjmbMenuExample example);

    int updateByPrimaryKeySelective(BzjmbMenu record);

    int updateByPrimaryKey(BzjmbMenu record);
    
    List<BzjmbMenu> selectAll();
	
	List<BzjmbMenu> isExist(@Param(value = "subzhName")String subzh, @Param(value = "id")Integer id);
	
}