package com.jcl.dao;

import com.jcl.pojo.AppFile;
import com.jcl.pojo.AppFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppFileMapper {
    int countByExample(AppFileExample example);

    int deleteByExample(AppFileExample example);

    int deleteByPrimaryKey(Integer lsh);

    int insert(AppFile record);

    int insertSelective(AppFile record);

    List<AppFile> selectByExample(AppFileExample example);

    AppFile selectByPrimaryKey(Integer lsh);

    int updateByExampleSelective(@Param("record") AppFile record, @Param("example") AppFileExample example);

    int updateByExample(@Param("record") AppFile record, @Param("example") AppFileExample example);

    int updateByPrimaryKeySelective(AppFile record);

    int updateByPrimaryKey(AppFile record);
}