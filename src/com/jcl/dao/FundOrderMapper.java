package com.jcl.dao;

import com.jcl.pojo.FundOrder;
import com.jcl.pojo.FundOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundOrderMapper {
    int countByExample(FundOrderExample example);

    int deleteByExample(FundOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(FundOrder record);

    int insertSelective(FundOrder record);

    List<FundOrder> selectByExample(FundOrderExample example);

    FundOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") FundOrder record, @Param("example") FundOrderExample example);

    int updateByExample(@Param("record") FundOrder record, @Param("example") FundOrderExample example);

    int updateByPrimaryKeySelective(FundOrder record);

    int updateByPrimaryKey(FundOrder record);
}