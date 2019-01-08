package com.jcl.dao;

import com.jcl.pojo.FeeScheme;
import com.jcl.pojo.FeeSchemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeSchemeMapper {
    long countByExample(FeeSchemeExample example);

    int deleteByExample(FeeSchemeExample example);

    int deleteByPrimaryKey(Integer lsh);

    int insert(FeeScheme record);

    int insertSelective(FeeScheme record);

    List<FeeScheme> selectByExample(FeeSchemeExample example);

    FeeScheme selectByPrimaryKey(Integer lsh);

    int updateByExampleSelective(@Param("record") FeeScheme record, @Param("example") FeeSchemeExample example);

    int updateByExample(@Param("record") FeeScheme record, @Param("example") FeeSchemeExample example);

    int updateByPrimaryKeySelective(FeeScheme record);

    int updateByPrimaryKey(FeeScheme record);
    
    List<FeeScheme> selectAll();
	
	List<FeeScheme> isExist(@Param(value = "subzhName")String subzh);
	
}