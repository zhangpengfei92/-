package com.jcl.dao;

import com.jcl.pojo.TradeHedging;
import com.jcl.pojo.TradeHedgingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeHedgingMapper {
    long countByExample(TradeHedgingExample example);

    int deleteByExample(TradeHedgingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeHedging record);

    int insertSelective(TradeHedging record);

    List<TradeHedging> selectByExample(TradeHedgingExample example);

    TradeHedging selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeHedging record, @Param("example") TradeHedgingExample example);

    int updateByExample(@Param("record") TradeHedging record, @Param("example") TradeHedgingExample example);

    int updateByPrimaryKeySelective(TradeHedging record);

    int updateByPrimaryKey(TradeHedging record);
    
    List<TradeHedging> selectAll();
	
	List<TradeHedging> isExist(@Param(value = "title")String title);
    
}