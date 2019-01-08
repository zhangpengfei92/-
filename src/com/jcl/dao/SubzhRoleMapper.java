package com.jcl.dao;

import com.jcl.pojo.SubzhRole;
import com.jcl.pojo.SubzhRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubzhRoleMapper {
    int countByExample(SubzhRoleExample example);

    int deleteByExample(SubzhRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubzhRole record);

    int insertSelective(SubzhRole record);

    List<SubzhRole> selectByExample(SubzhRoleExample example);

    SubzhRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubzhRole record, @Param("example") SubzhRoleExample example);

    int updateByExample(@Param("record") SubzhRole record, @Param("example") SubzhRoleExample example);

    int updateByPrimaryKeySelective(SubzhRole record);

    int updateByPrimaryKey(SubzhRole record);

	SubzhRole selectBySubzh(String subzh);
}