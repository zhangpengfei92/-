package com.jcl.dao;

import com.jcl.pojo.AppHelp;
import com.jcl.pojo.AppHelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppHelpMapper {
    int countByExample(AppHelpExample example);

    int deleteByExample(AppHelpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppHelp record);

    int insertSelective(AppHelp record);

    List<AppHelp> selectByExample(AppHelpExample example);

    AppHelp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppHelp record, @Param("example") AppHelpExample example);

    int updateByExample(@Param("record") AppHelp record, @Param("example") AppHelpExample example);

    int updateByPrimaryKeySelective(AppHelp record);

    int updateByPrimaryKey(AppHelp record);
}