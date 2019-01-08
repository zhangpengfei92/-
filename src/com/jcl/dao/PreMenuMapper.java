package com.jcl.dao;

import com.jcl.pojo.PreMenu;
import com.jcl.pojo.PreMenuExample;
import com.jcl.pojo.PreMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PreMenuMapper {
    int countByExample(PreMenuExample example);

    int deleteByExample(PreMenuExample example);

    int deleteByPrimaryKey(PreMenuKey key);

    int insert(PreMenu record);

    int insertSelective(PreMenu record);

    List<PreMenu> selectByExample(PreMenuExample example);

    PreMenu selectByPrimaryKey(PreMenuKey key);

    int updateByExampleSelective(@Param("record") PreMenu record, @Param("example") PreMenuExample example);

    int updateByExample(@Param("record") PreMenu record, @Param("example") PreMenuExample example);

    int updateByPrimaryKeySelective(PreMenu record);

    int updateByPrimaryKey(PreMenu record);

	List<PreMenu> selectAll();
}