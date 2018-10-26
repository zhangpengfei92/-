package com.jcl.dao;

import com.jcl.pojo.SubFeelog;
import com.jcl.pojo.SubFeelogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubFeelogMapper {
    int countByExample(SubFeelogExample example);

    int deleteByExample(SubFeelogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubFeelog record);

    int insertSelective(SubFeelog record);

    List<SubFeelog> selectByExample(SubFeelogExample example);

    SubFeelog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubFeelog record, @Param("example") SubFeelogExample example);

    int updateByExample(@Param("record") SubFeelog record, @Param("example") SubFeelogExample example);

    int updateByPrimaryKeySelective(SubFeelog record);

    int updateByPrimaryKey(SubFeelog record);
}