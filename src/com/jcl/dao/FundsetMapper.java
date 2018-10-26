package com.jcl.dao;

import com.jcl.pojo.Fundset;
import com.jcl.pojo.FundsetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundsetMapper {
    int countByExample(FundsetExample example);

    int deleteByExample(FundsetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fundset record);

    int insertSelective(Fundset record);

    List<Fundset> selectByExample(FundsetExample example);

    Fundset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fundset record, @Param("example") FundsetExample example);

    int updateByExample(@Param("record") Fundset record, @Param("example") FundsetExample example);

    int updateByPrimaryKeySelective(Fundset record);

    int updateByPrimaryKey(Fundset record);
}