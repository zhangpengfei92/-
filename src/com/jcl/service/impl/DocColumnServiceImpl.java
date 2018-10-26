package com.jcl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.DocColumnMapper;
import com.jcl.dao.DocContentMapper;
import com.jcl.pojo.DocColumn;
import com.jcl.pojo.DocContent;
import com.jcl.service.DocColumnService;

@Service
public class DocColumnServiceImpl implements DocColumnService {

	@Autowired
	private DocColumnMapper columnMapper;

	@Autowired
	private DocContentMapper contentMapper;

	@Override
	public DocColumn selectByPrimaryKey(Integer id) {
		return columnMapper.selectByPrimaryKey(id);
	}

	@Override
	public DocColumn selectByMap(Map<String, Object> map) {
		return columnMapper.selectByMap(map);
	}

	@Override
	public List<DocContent> getDocContentListByMap(Map<String, Object> map) {
		return contentMapper.getDocContentListByMap(map);
	}

	@Override
	public Integer deleteDocContentByPrimaryKey(Integer id) {
		return contentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertDocContent(DocContent record) {
		return contentMapper.insertSelective(record);
	}

	@Override
	public int updateDocContent(DocContent record) {
		return contentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DocColumn> getDocColumnListByMap(Map<String, Object> map) {
		return columnMapper.getDocColumnListByMap(map);
	}

	@Override
	public DocContent selectDocContentByPrimaryKey(Integer id) {
		return contentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DocColumn> selectByCommunityArticle() {
		return columnMapper.selectByCommunityArticle();
	}

	@Override
	public DocColumn selectByname(String name) {

		return columnMapper.selectByname(name);
	}

	@Override
	public List<DocColumn> selectOne() {
		return columnMapper.selectOne();
	}

	/*@Override
	public List<EducationDocContent> selectEducationAll() {

		return columnMapper.selectEducationAll();
	}

	@Override
	public List<EducationDocContent> selectEducationBytitle(String title) {

		return columnMapper.selectEducationBytitle(title);
	}*/

	@Override
	public List<DocColumn> selectTwo(Integer parentId) {
		return columnMapper.selectTwo(parentId);
	}

	@Override
	public int insert(DocColumn record) {
		int i = columnMapper.insert(record);

		return i;
	}
	@Override
	public Integer deleteByPrimaryKey(Integer id) {
		return columnMapper.deleteByPrimaryKey(id);
	}

}
