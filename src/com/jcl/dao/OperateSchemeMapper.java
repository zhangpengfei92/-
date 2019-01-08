package com.jcl.dao;

import com.jcl.pojo.OperateScheme;
import com.jcl.pojo.OperateSchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateSchemeMapper {
    int countByExample(OperateSchemeExample example);

    int deleteByExample(OperateSchemeExample example);

    int deleteByPrimaryKey(Integer osid);

    int insert(OperateScheme record);

    int insertSelective(OperateScheme record);

    List<OperateScheme> selectByExample(OperateSchemeExample example);

    OperateScheme selectByPrimaryKey(Integer osid);

    int updateByExampleSelective(@Param("record") OperateScheme record, @Param("example") OperateSchemeExample example);

    int updateByExample(@Param("record") OperateScheme record, @Param("example") OperateSchemeExample example);

    int updateByPrimaryKeySelective(OperateScheme record);

    int updateByPrimaryKey(OperateScheme record);

	List<OperateScheme> selectAll();

	OperateScheme selectByID(Integer id);

	void updateOsstate(Integer osid);

	List<OperateScheme> selectByName(String str);
}