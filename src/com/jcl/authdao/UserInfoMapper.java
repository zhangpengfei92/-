package com.jcl.authdao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jcl.pojo.UserInfo;
import com.jcl.pojo.UserInfoExample;

public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExampleWithBLOBs(UserInfoExample example);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKeyWithBLOBs(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

	List<UserInfo> selectAll();

	List<Map<String, Object>> selectByLike(String nickname, Integer usertype);

	int updateByid(String email, String phone, Integer id);

	List<UserInfo> isExist(String username);
}