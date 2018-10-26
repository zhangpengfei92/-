package com.jcl.dao;

import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.FundPzlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundPzlogMapper {
	
	List<FundPzlog> selectAll();
	
	List<FundPzlog> isExist(@Param(value = "subzhName")String subzh);
	
    long countByExample(FundPzlogExample example);

    int deleteByExample(FundPzlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundPzlog record);

    int insertSelective(FundPzlog record);

    List<FundPzlog> selectByExample(FundPzlogExample example);

    FundPzlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundPzlog record, @Param("example") FundPzlogExample example);

    int updateByExample(@Param("record") FundPzlog record, @Param("example") FundPzlogExample example);

    int updateByPrimaryKeySelective(FundPzlog record);

    int updateByPrimaryKey(FundPzlog record);
}