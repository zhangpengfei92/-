package com.jcl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcl.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

	void deleteRolePerByRoleId(Integer roleId);

	void insertRolePer(@Param(value = "roleId") Integer roleId,@Param(value = "perId") Integer perId,@Param(value = "createTime") Date createTime);

	List<Role> getListByLikeName(@Param(value = "name") String name);

	List<Role> select();

	Role selectById(Integer id);

	List<Role> isExist(@Param(value = "name") String name);
}