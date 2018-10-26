package com.jcl.dao;

import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubzhMapper {
    int countByExample(SubzhExample example);

    int deleteByExample(SubzhExample example);

    int deleteByPrimaryKey(SubzhKey key);

    int insert(Subzh record);

    int insertSelective(Subzh record);

    List<Subzh> selectByExample(SubzhExample example);

    Subzh selectByPrimaryKey(SubzhKey key);

    int updateByExampleSelective(@Param("record") Subzh record, @Param("example") SubzhExample example);

    int updateByExample(@Param("record") Subzh record, @Param("example") SubzhExample example);

    int updateByPrimaryKeySelective(Subzh record);

    int updateByPrimaryKey(Subzh record);
}