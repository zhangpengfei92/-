package com.jcl.dao;

import com.jcl.pojo.UserRights;
import com.jcl.pojo.UserRightsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRightsMapper {
    long countByExample(UserRightsExample example);

    int deleteByExample(UserRightsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRights record);

    int insertSelective(UserRights record);

    List<UserRights> selectByExample(UserRightsExample example);

    UserRights selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRights record, @Param("example") UserRightsExample example);

    int updateByExample(@Param("record") UserRights record, @Param("example") UserRightsExample example);

    int updateByPrimaryKeySelective(UserRights record);

    int updateByPrimaryKey(UserRights record);
}