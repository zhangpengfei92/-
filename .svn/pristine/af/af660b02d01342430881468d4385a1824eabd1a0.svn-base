package com.jcl.dao;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.DocColumn;

public interface DocColumnMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(DocColumn record);

	int insertSelective(DocColumn record);

	DocColumn selectByPrimaryKey(Integer id);

	DocColumn selectByname(String name);

	int updateByPrimaryKeySelective(DocColumn record);

	int updateByPrimaryKey(DocColumn record);

	DocColumn selectByMap(Map<String, Object> map);

	// 查询社区文章分类
	List<DocColumn> selectByCommunityArticle();

	// 查询教育学院一级分类
	List<DocColumn> selectOne();

	// 查询教育学院二级分类
	List<DocColumn> selectTwo(Integer parentId);

	// 查询教育学院所有文章
	//List<EducationDocContent> selectEducationAll();

	/* 模糊查詢教育學院文章 */
	//List<EducationDocContent> selectEducationBytitle(String title);

	List<DocColumn> getDocColumnListByMap(Map<String, Object> map);
}