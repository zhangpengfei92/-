package com.jcl.dao;

import com.jcl.pojo.RiskSetting;
import com.jcl.pojo.RiskSettingExample;
import com.jcl.pojo.RiskSettingWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskSettingMapper {
    int countByExample(RiskSettingExample example);

    int deleteByExample(RiskSettingExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(RiskSettingWithBLOBs record);

    int insertSelective(RiskSettingWithBLOBs record);

    List<RiskSettingWithBLOBs> selectByExampleWithBLOBs(RiskSettingExample example);

    List<RiskSetting> selectByExample(RiskSettingExample example);

    RiskSettingWithBLOBs selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") RiskSettingWithBLOBs record, @Param("example") RiskSettingExample example);

    int updateByExampleWithBLOBs(@Param("record") RiskSettingWithBLOBs record, @Param("example") RiskSettingExample example);

    int updateByExample(@Param("record") RiskSetting record, @Param("example") RiskSettingExample example);

    int updateByPrimaryKeySelective(RiskSettingWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RiskSettingWithBLOBs record);

    int updateByPrimaryKey(RiskSetting record);
}