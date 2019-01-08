package com.jcl.dao;

import com.jcl.pojo.Sysuser;
import com.jcl.pojo.SysuserExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysuserMapper {
    int countByExample(SysuserExample example);

    int deleteByExample(SysuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);
    
    Sysuser selectByName(String username);

    List<Sysuser> selectByExample(SysuserExample example);
    
    List<Sysuser> selectAll();

    Sysuser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByExample(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);

	void deleteUserRoleByUserId(Integer sysuserId);

	void insertUserRole(@Param(value = "sysuserId") Integer sysuserId,@Param(value = "roleId")Integer roleId,@Param(value = "createTime") Date createTime);

	Sysuser  getlistByAdmin(Integer sysuserId);

	Sysuser selectByRoleAndPer(String username);

	List<Sysuser> getListByLikeName(@Param(value = "username")String username);

	List<Sysuser> isExist(@Param(value = "username")String username);
}