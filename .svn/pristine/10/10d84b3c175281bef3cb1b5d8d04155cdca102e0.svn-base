package com.jcl.dao;

import com.jcl.pojo.StockPrincipal;
import com.jcl.pojo.StockPrincipalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockPrincipalMapper {
    int countByExample(StockPrincipalExample example);

    int deleteByExample(StockPrincipalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockPrincipal record);

    int insertSelective(StockPrincipal record);

    List<StockPrincipal> selectByExample(StockPrincipalExample example);

    StockPrincipal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockPrincipal record, @Param("example") StockPrincipalExample example);

    int updateByExample(@Param("record") StockPrincipal record, @Param("example") StockPrincipalExample example);

    int updateByPrimaryKeySelective(StockPrincipal record);

    int updateByPrimaryKey(StockPrincipal record);
}