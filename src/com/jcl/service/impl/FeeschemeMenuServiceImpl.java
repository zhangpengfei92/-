package com.jcl.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.FeeSchemeMapper;
import com.jcl.dao.FeeschemeMenuMapper;
import com.jcl.pojo.FeeScheme;
import com.jcl.pojo.FeeschemeMenu;
import com.jcl.pojo.FeeschemeMenuExample;
import com.jcl.service.FeeschemeMenuService;

@Service
public class FeeschemeMenuServiceImpl implements FeeschemeMenuService {

	@Autowired
	private FeeschemeMenuMapper feeschemeMenuMapper;
	
	@Autowired
	private FeeSchemeMapper feeSchemeMapper;
	
	@Override
	public List<FeeschemeMenu> selectAll() {
		return feeschemeMenuMapper.selectAll();
	}

	@Override
	public FeeschemeMenu selectByPrimaryKey(Integer id) {
		return feeschemeMenuMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<FeeschemeMenu> selectByExample(FeeschemeMenuExample example) {
		return feeschemeMenuMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return feeschemeMenuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(FeeschemeMenu record) {
		return feeschemeMenuMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(FeeschemeMenu record) {
		return feeschemeMenuMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return FeeschemeMenuMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(FeeschemeMenu record) throws Exception {
		int i = feeschemeMenuMapper.insertSelective(record);
		if(i > 0){
			FeeScheme schemeType1 = new FeeScheme();//创建一个1经纪商交易佣金类型的收费方案类型
			schemeType1.setSchemename(record.getSchemename());
			schemeType1.setSchemetype((byte)1);//收费方案类型,1经纪商交易佣金,2印花税,3过户费
			schemeType1.setDirection("0,1");
			schemeType1.setPercentage(new BigDecimal(0.3));
			schemeType1.setSchemename(record.getSchemename());
			schemeType1.setShowstatus((byte)1);//默认是显示（1显示，0隐藏）
			schemeType1.setFeeschemeid(record.getLsh());
			feeSchemeMapper.insertSelective(schemeType1);
			
			schemeType1 = new FeeScheme();
			schemeType1.setSchemetype((byte)2);//收费方案类型,1经纪商交易佣金,2印花税,3过户费
			schemeType1.setDirection("1");
			schemeType1.setPercentage(new BigDecimal(0.1));
			schemeType1.setSchemename(record.getSchemename());
			schemeType1.setShowstatus((byte)1);//默认是显示（1显示，0隐藏）
			schemeType1.setFeeschemeid(record.getLsh());
			feeSchemeMapper.insertSelective(schemeType1);
			
			schemeType1 = new FeeScheme();
			schemeType1.setSchemetype((byte)3);//收费方案类型,1经纪商交易佣金,2印花税,3过户费
			schemeType1.setDirection("0,1");
			schemeType1.setPercentage(new BigDecimal(0.1));
			schemeType1.setSchemename(record.getSchemename());
			schemeType1.setShowstatus((byte)1);//默认是显示（1显示，0隐藏）
			schemeType1.setFeeschemeid(record.getLsh());
			feeSchemeMapper.insertSelective(schemeType1);
			
			schemeType1 = new FeeScheme();
			schemeType1.setSchemetype((byte)5);//收费方案类型,1经纪商交易佣金,2印花税,3过户费
			schemeType1.setDirection("0");
			schemeType1.setPercentage(new BigDecimal(20.0));
			schemeType1.setSchemename(record.getSchemename());
			schemeType1.setShowstatus((byte)1);//默认是显示（1显示，0隐藏）
			schemeType1.setFeeschemeid(record.getLsh());
			feeSchemeMapper.insertSelective(schemeType1);
		}
		return i;
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByFeeschemeMenuAndAccount() {
		return FeeschemeMenuMapper.selectALlByFeeschemeMenuAndAccount();
	}*/
	
	@Override
	public List<FeeschemeMenu> isExist(String feeschemeMenu, Integer id) {
		return feeschemeMenuMapper.isExist(feeschemeMenu, id);
	}
	
}
