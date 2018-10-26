package com.jcl.dao;

import com.jcl.pojo.Coursetable;
import com.jcl.pojo.CoursetableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursetableMapper {
    int countByExample(CoursetableExample example);

    int deleteByExample(CoursetableExample example);

    int deleteByPrimaryKey(Integer id);
    
    int deleteByDate(String date);

    int insert(Coursetable record);

    int insertSelective(Coursetable record);
    
    //查询不重复的日期数量
    int selectCountByDate();

    List<Coursetable> selectByExample(CoursetableExample example);

    Coursetable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Coursetable record, @Param("example") CoursetableExample example);

    int updateByExample(@Param("record") Coursetable record, @Param("example") CoursetableExample example);

    int updateByPrimaryKeySelective(Coursetable record);

    int updateByPrimaryKey(Coursetable record);

	List<Coursetable> selectDate();
}