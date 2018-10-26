package com.jcl.dao;

import com.jcl.pojo.UserInfoData;
import com.jcl.pojo.UserInfoDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDataMapper {
    int countByExample(UserInfoDataExample example);

    int deleteByExample(UserInfoDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoData record);

    int insertSelective(UserInfoData record);

    List<UserInfoData> selectByExample(UserInfoDataExample example);

    UserInfoData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfoData record, @Param("example") UserInfoDataExample example);

    int updateByExample(@Param("record") UserInfoData record, @Param("example") UserInfoDataExample example);

    int updateByPrimaryKeySelective(UserInfoData record);

    int updateByPrimaryKey(UserInfoData record);
}