package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.DocColumn;
import com.jcl.pojo.DocContent;

public interface DocColumnService {

	DocColumn selectByPrimaryKey(Integer id);

	DocColumn selectByMap(Map<String, Object> map);

	List<DocContent> getDocContentListByMap(Map<String, Object> map);

	List<DocColumn> getDocColumnListByMap(Map<String, Object> map);

	Integer deleteDocContentByPrimaryKey(Integer id);

	int insertDocContent(DocContent record);

	int updateDocContent(DocContent record);

	int insert(DocColumn record);

	DocColumn selectByname(String name);

	// 查询教育学院一级分类
	List<DocColumn> selectOne();

	// 查询教育学院二级分类
	List<DocColumn> selectTwo(Integer parentId);

	// 查询教育学院所有文章
	//List<EducationDocContent> selectEducationAll();

	/* 模糊查詢教育學院文章 */
	//List<EducationDocContent> selectEducationBytitle(String title);

	// 查询社区分账分类
	List<DocColumn> selectByCommunityArticle();

	DocContent selectDocContentByPrimaryKey(Integer id);

	Integer deleteByPrimaryKey(Integer id);
}
