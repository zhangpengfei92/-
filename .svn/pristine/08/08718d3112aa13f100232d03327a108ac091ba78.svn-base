package com.jcl.dao;

import com.jcl.pojo.PremiumCycle;
import com.jcl.pojo.PremiumCycleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PremiumCycleMapper {
    int countByExample(PremiumCycleExample example);

    int deleteByExample(PremiumCycleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PremiumCycle record);

    int insertSelective(PremiumCycle record);

    List<PremiumCycle> selectByExample(PremiumCycleExample example);

    PremiumCycle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PremiumCycle record, @Param("example") PremiumCycleExample example);

    int updateByExample(@Param("record") PremiumCycle record, @Param("example") PremiumCycleExample example);

    int updateByPrimaryKeySelective(PremiumCycle record);

    int updateByPrimaryKey(PremiumCycle record);
}