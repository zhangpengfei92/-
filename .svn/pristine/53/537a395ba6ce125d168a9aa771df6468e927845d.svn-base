package com.jcl.dao;

import com.jcl.pojo.Feetemplate_menu;
import com.jcl.pojo.Feetemplate_menuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Feetemplate_menuMapper {
    int countByExample(Feetemplate_menuExample example);

    int deleteByExample(Feetemplate_menuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feetemplate_menu record);

    int insertSelective(Feetemplate_menu record);

    List<Feetemplate_menu> selectByExample(Feetemplate_menuExample example);

    Feetemplate_menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feetemplate_menu record, @Param("example") Feetemplate_menuExample example);

    int updateByExample(@Param("record") Feetemplate_menu record, @Param("example") Feetemplate_menuExample example);

    int updateByPrimaryKeySelective(Feetemplate_menu record);

    int updateByPrimaryKey(Feetemplate_menu record);
    
    @Select("SELECT * FROM feetemplate_menu ")
	List<Feetemplate_menu> selectAll();
}