package com.jcl.dao;

import com.jcl.pojo.RightsRole;
import com.jcl.pojo.RightsRoleExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightsRoleMapper {
	
    long countByExample(RightsRoleExample example);

    int deleteByExample(RightsRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RightsRole record);

    int insertSelective(RightsRole record);
    
    void insertRightsRolePer(@Param(value = "roleId") Integer roleId, @Param(value = "perId") Integer perId,@Param(value = "createTime") Date createTime);
    
    void deleteRightsRolePerByRightsRoleId(Integer roleId);

    List<RightsRole> selectByExample(RightsRoleExample example);
    
    List<RightsRole> getListByLikeName(@Param(value = "name") String name);

    RightsRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RightsRole record, @Param("example") RightsRoleExample example);

    int updateByExample(@Param("record") RightsRole record, @Param("example") RightsRoleExample example);

    int updateByPrimaryKeySelective(RightsRole record);

    int updateByPrimaryKey(RightsRole record);
    
    List<RightsRole> selectById(Integer id);

	List<RightsRole> isExist(@Param(value = "name") String name);
    
}