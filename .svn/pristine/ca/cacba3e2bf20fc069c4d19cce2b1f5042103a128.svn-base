package com.jcl.dao;

import com.jcl.pojo.Spt;
import com.jcl.pojo.SptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SptMapper {
    int countByExample(SptExample example);

    int deleteByExample(SptExample example);

    int deleteByPrimaryKey(String merch);

    int insert(Spt record);

    int insertSelective(Spt record);

    List<Spt> selectByExample(SptExample example);

    Spt selectByPrimaryKey(String merch);

    int updateByExampleSelective(@Param("record") Spt record, @Param("example") SptExample example);

    int updateByExample(@Param("record") Spt record, @Param("example") SptExample example);

    int updateByPrimaryKeySelective(Spt record);

    int updateByPrimaryKey(Spt record);
}