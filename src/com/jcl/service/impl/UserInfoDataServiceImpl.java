package com.jcl.service.impl;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jcl.dao.SubzhMapper;
import com.jcl.daoAuth.UserInfoMapper;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhExample.Criteria;
import com.jcl.pojo.auth.UserInfo;
import com.jcl.pojo.auth.UserInfoExample;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Constant;
import com.jcl.util.Util;


@Service
@Transactional(rollbackFor=Exception.class)  
public class UserInfoDataServiceImpl implements UserInfoDataService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private SubzhMapper subzhMapper;
	
	private static Logger log = Logger.getLogger(UserInfoDataServiceImpl.class);
	
	@Override
	public List<Subzh> userLogin(Map<String, Object> map) {
		SubzhExample example = new SubzhExample();
		Criteria criteria = example.createCriteria();
		if(map.get("username") != null && map.get("username") != ""){
			criteria.andPhoneEqualTo((String)map.get("username"));
		}
		if(map.get("subzh") != null && map.get("subzh") != ""){
			criteria.andSubzhEqualTo((String)map.get("subzh"));
		}
		if(map.get("password") != null && map.get("password") != ""){
			criteria.andPasswordEqualTo((String)map.get("password"));
		}
		if(map.get("isadmin") != null && map.get("isadmin") != ""){
			criteria.andIsadminEqualTo((Integer)map.get("isadmin"));
		}
		if(map.get("channel") != null && map.get("channel") != ""){
			criteria.andPagentzhEqualTo((String)map.get("channel"));
		}
		List<Subzh> list = subzhMapper.selectByExample(example);
		return list;
	}
	@Override
	public int regUserInfoData(Map<String, Object> map) throws Exception {
		
			Date nowDate = Calendar.getInstance().getTime();
			long timeLong = 3*365*24*3600*1000l;
			long nextYearLong = nowDate.getTime()+timeLong;
			Date nextYearDate = new Date(nextYearLong);
			UserInfo ui = new UserInfo();
			ui.setUsername((String)map.get("username"));
			ui.setPassword((String)map.get("password"));
			ui.setStarttime(nowDate);
			ui.setEndtime(nextYearDate);
			ui.setSysrights(Constant.USERTYPE_DEFAULT);
			ui.setFlag(Constant.DELETED_NO);
			ui.setSyncinfo(Constant.SYNCINFO_DEFAULT);
			ui.setClientfrom(Constant.CLIENTFORM_DEFAULT);
			int i = userInfoMapper.insertSelective(ui);
			
			Subzh sub = new Subzh();
			sub.setPhone((String)map.get("username"));
			sub.setPassword((String)map.get("password"));
			sub.setHeadpicture((String)map.get("headPicture"));
			sub.setPhone((String)map.get("username"));
			sub.setPagentzh((String)map.get("pagentzh"));
			sub.setSubzh((String)map.get("subzh"));
			sub.setKhdate(new Date());
			sub.setIsadmin(4);
			
			byte[] data = sub.getSubzh().getBytes();
			long cookie = Util.Hash64(data, 0, data.length);//生成随机的cookie
			if(cookie < 0){
				sub.setCookie(String.valueOf(Util.readUnsignedLong(cookie)));
			} else {
				sub.setCookie(String.valueOf(cookie));
			}
			int j = subzhMapper.insertSelective(sub);
			if(i > 0 && j > 0){
				return 1;
			}else{
				return 0;
			}
		
	}
	@Override
	public int updatePwd(Map<String, Object> map) throws Exception{
		
		UserInfo ui = new UserInfo();
		ui.setPassword((String)map.get("newPassword"));
		UserInfoExample exampleUI = new UserInfoExample();
		UserInfoExample.Criteria criteriaUI = exampleUI.createCriteria();
		criteriaUI.andUsernameEqualTo((String)map.get("username"));
		if(map.get("password") != null){
			criteriaUI.andPasswordEqualTo((String)map.get("password"));
		}
		int i = userInfoMapper.updateByExampleSelective(ui, exampleUI);
		
		Subzh sub = new Subzh();
		sub.setPassword((String)map.get("newPassword"));
		
		SubzhExample example = new SubzhExample();
		Criteria criteria = example.createCriteria();

		if(map.get("subzh") != null && map.get("subzh") != ""){
			criteria.andSubzhEqualTo((String)map.get("subzh"));
		}
		if(map.get("password") != null && map.get("password") != ""){
			criteria.andPasswordEqualTo((String)map.get("password"));
		}
		int j = subzhMapper.updateByExampleSelective(sub, example);
		
		if(i > 0 && j > 0){
			return 1;
		}
		return 0;
	}
	@Override
	public int updateUserInfoData(Subzh ud) throws Exception{
		
		return subzhMapper.updateByPrimaryKeySelective(ud);
	}
	
	@Override
	public Subzh getUserInfoByid(Integer id) {
		
		return null;//userInfoDataMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Subzh> getUserInfoAllOrByPhone(String phone) {
//		UserInfoDataExample example = new UserInfoDataExample();
//		example.setOrderByClause("id desc");
//		Criteria criteria = example.createCriteria();
//		if(!StringUtil.isAllNullOrEmpty(phone)){
//			criteria.andUsernameEqualTo(phone);
//		}
		List<Subzh> list = null;//userInfoDataMapper.selectByExample(example);
		return list;
	}
	@Override
	public Subzh getUserInfoByPhone(String phone) {
		Subzh subzh=null;
		SubzhExample example = new SubzhExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<Subzh> list = subzhMapper.selectByExample(example);
		if(list !=null && list.size()==1){
			subzh=list.get(0);
		}
		return subzh;
	}
}
