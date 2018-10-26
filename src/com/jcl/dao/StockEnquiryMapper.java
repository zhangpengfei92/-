package com.jcl.dao;

import com.jcl.pojo.StockEnquiry;
import com.jcl.pojo.StockEnquiryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockEnquiryMapper {
    int countByExample(StockEnquiryExample example);

    int deleteByExample(StockEnquiryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockEnquiry record);

    int insertSelective(StockEnquiry record);

    List<StockEnquiry> selectByExample(StockEnquiryExample example);

    StockEnquiry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockEnquiry record, @Param("example") StockEnquiryExample example);

    int updateByExample(@Param("record") StockEnquiry record, @Param("example") StockEnquiryExample example);

    int updateByPrimaryKeySelective(StockEnquiry record);

    int updateByPrimaryKey(StockEnquiry record);
}