package com.jcl.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcl.dao.PermissionMapper;
import com.jcl.dao.PreMenuMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.dao.SubzhPreMenuMapper;
import com.jcl.dao.SubzhRoleMapper;
import com.jcl.pojo.Permission;
import com.jcl.pojo.PreMenu;
import com.jcl.pojo.PreMenuExample;
import com.jcl.pojo.PreMenuExample.Criteria;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhPreMenu;
import com.jcl.pojo.SubzhRole;
import com.jcl.service.SubzhService;
import com.jcl.util.StringUtil;
import com.jcl.vo.SubVo;

@Service
public class SubzhServiceImpl implements SubzhService {

	@Autowired
	private SubzhMapper subzhMapper;
	
	@Autowired
	private SubzhPreMenuMapper subzhPreMenuMapper;
	
	@Autowired
	private SubzhRoleMapper subzhRoleMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	@Autowired
	private PreMenuMapper prememuMapper;
	
	@Override
	public List<Subzh> selectAll(String username) {
		return subzhMapper.selectAll(username);
	}

	@Override
	public Subzh selectByPrimaryKey(String subzhName) {
		return subzhMapper.selectByPrimaryKeySubzh(subzhName);
	}

	@Override
	public List<Map<String,Object>> selectByLike(String nickname, Integer usertype) {

		return subzhMapper.selectByLike(nickname, usertype);
	}
	
	@Override
	public List<Subzh> selectByExample(SubzhExample example) {
	
		return subzhMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String subzhName) {
		/*Subzh record = SubzhMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return subzhMapper.deleteByPrimaryKeySubzh(subzhName);
	}

	@Override
	public int updateByPrimaryKeyAndRole(Subzh record, List<RightsRole> roleList) {
		/*删除用户权限、更新用户权限
		UserRightsExample example = new UserRightsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(record.getUsername());
		userRightsMapper.deleteByExample(example);
		if(roleList != null && roleList.size() > 0){//保存用户权限
			UserRights userRights = null;
			Date nowDate = Calendar.getInstance().getTime();
			for(RightsRole rightsRole : roleList){
				userRights = new UserRights();
				userRights.setUsername(record.getUsername());
				userRights.setInfo(rightsRole.getColumnId().toString());//权限ID
				userRights.setStarttime(record.getStarttime());//开始时间
				userRights.setEndtime(record.getEndtime());//结束时间
				userRights.setCreatedAt(nowDate);
				userRightsMapper.insertSelective(userRights);
			}
		}*/
		return subzhMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public int updateByPrimaryKey(Subzh record) {
		return subzhMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return subzhMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(Subzh record, List<RightsRole> roleList) throws Exception {
		/*if(roleList != null && roleList.size() > 0){//保存用户权限
			UserRights userRights = null;
			Date nowDate = Calendar.getInstance().getTime();
			for(RightsRole rightsRole : roleList){
				userRights = new UserRights();
				userRights.setUsername(record.getUsername());
				userRights.setInfo(rightsRole.getColumnId().toString());//权限ID
				userRights.setStarttime(record.getStarttime());//开始时间
				userRights.setEndtime(record.getEndtime());//结束时间
				userRights.setCreatedAt(nowDate);
				userRightsMapper.insertSelective(userRights);
			}
		}*/
		return subzhMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlBySubzhAndAccount() {
		return SubzhMapper.selectALlBySubzhAndAccount();
	}*/
	
	@Override
	public List<Subzh> isExist(String subzh) {
		return subzhMapper.isExist(subzh);
	}

	@Override
	public int addSubzh(Subzh subzh) {
		
		return subzhMapper.insertSelective(subzh);
	}
	
	//保存子账户设置的权限
	@Override
	public int saveSubzhPre(String num,String subzh) {
		num =num.substring(0, num.length()-1);
		int count=0;
		SubzhPreMenu spm=new SubzhPreMenu();
		String arr []=num.split(",");
		for (String i : arr) {
			spm.setPmid(Integer.parseInt(i));
			spm.setSubzh(subzh);
			count+=subzhPreMenuMapper.insertSelective(spm);
		}

		return count;
	}

	@Override
	public int saveSubzhRole(String subzh, Integer roleid) {
		SubzhRole record=new SubzhRole();
		record.setSubzh(subzh);
		record.setRoleid(roleid);
		return	subzhRoleMapper.insertSelective(record);
	}

	@Override
	public Subzh selectBySubzh(String id) {
		Subzh subzh=subzhMapper.selectBySubzh(id);
		return subzh;
	}

	@Override
	public SubzhRole selectSubzhRole(String subzh) {
	
		SubzhRole subzhRole=subzhRoleMapper.selectBySubzh(subzh);
		return subzhRole;
	}

	@Override
	public List<SubzhPreMenu> selectSubPreMenu(String subzh) {
		
		return subzhPreMenuMapper.selectSubPreMenu(subzh);
	}

	@Override
	public List<PreMenu> selectByRoleAndPer(String username) {
		
		return subzhMapper.selectByRoleAndPer(username);
	}

	@Override
	public List<Subzh> selectByName(SubVo svo) {
		
		return subzhMapper.selectByName(svo);
	}

	@Override
	public int updateSubzhRole(SubzhRole sr) {
		
		return subzhRoleMapper.updateByPrimaryKeySelective(sr);
	}
	
	
	//修改客户权限菜单
	@Override
	public int updateSubzhPre(String num, String subzh) {
		num =num.substring(0, num.length()-1);
		int count=0;
		SubzhPreMenu spm=new SubzhPreMenu();
		String arr []=num.split(",");
		List<SubzhPreMenu> slist= subzhPreMenuMapper.selectSubPreMenu(subzh);//之前的权限
		Subzh subzh1=subzhMapper.getPuriSubzh(subzh);
		Subzh condition=new Subzh();
		condition.setIsadmin(subzh1.getIsadmin());
		condition.setSubzh(subzh);
		List<SubzhPreMenu> list=subzhPreMenuMapper.getAllSubPre(condition);//当前修改对象的子级的菜单
		int dnum =0;
		for (SubzhPreMenu subzhPreMenu : slist) {
			int flag=0;
			for (String i : arr) {
				if(i.equals(subzhPreMenu.getPmid().toString())){
					flag=1;
					break;
				}
			}
			if(flag==0){//如果某个菜单被删除了，那它子级的这个菜单也要被删除
				List<SubzhPreMenu> spm2=findSubPre(list,subzhPreMenu.getPmid());
				if(spm2!=null && spm2.size()>0){
					for(SubzhPreMenu menu:spm2){
						subzhPreMenuMapper.deleteByPrimaryKey(menu.getId());
					}
				}
			}
			dnum+= subzhPreMenuMapper.deleteByPrimaryKey(subzhPreMenu.getId());
			
		}
		//如果dnum和查询出来的list条数相同，则说明删除完了，则可以调用添加方法
		if(dnum==slist.size()) {
			for (String i : arr) {
				spm.setPmid(Integer.parseInt(i));
				spm.setSubzh(subzh);
				count+=subzhPreMenuMapper.insertSelective(spm);
			}
		}
		return count;
	}

	
	
	private List<SubzhPreMenu> findSubPre(List<SubzhPreMenu> list,Integer id){
		List<SubzhPreMenu> list2=new ArrayList<SubzhPreMenu>();
		for(SubzhPreMenu spm:list){
			if(spm.getPmid().intValue()==id.intValue()){
				list2.add(spm);
			}
		}
		return list2;
	}
	@Override
	public Subzh loginBySubzh(String userName) {
	
		return subzhMapper.loginBySubzh(userName);
	}

	@Override
	public List<Permission> selectPre() {
		
		return permissionMapper.selectByExample(null);
	}

	@Override
	public int addmenu(PreMenu preMenu) {
		
		return prememuMapper.insertSelective(preMenu);
	}

	@Override
	public List<PreMenu> selectPreMenu(String keyword) {
		
		PreMenuExample example=new PreMenuExample();
		Criteria create = example.createCriteria();
		create.andMenuCodeEqualTo(keyword);
		List<PreMenu> list= prememuMapper.selectByExample(example);
		return list;
	}
	
	public List<Subzh> selectQdJjrUser(Subzh subzh){
		return subzhMapper.selectQdJjrUser(subzh);
	}
	
	/**
	 * 查询此手机号是存在，如果已存在则返回true,如果不存在就返回false;
	 */
	public boolean checkPhoneExist(String phone, String subzh){
		List<Subzh> list=subzhMapper.selectSubzhByPhone(phone, subzh);
		if(list!=null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkSubzhExist(String subzh){
		Subzh sub=subzhMapper.selectBySubzh(subzh);
		if(sub!=null){
			return true;
		}else{
			return false;
		}
	}
	
	
	public List<Subzh> getSubzhLevelList(Subzh s){
		List<Subzh> list=subzhMapper.getSubzhLevelList(s);
		return list;
	}
	
	public Subzh getPuriSubzh(String id){
		return subzhMapper.getPuriSubzh(id);
	}
	
	/**
	 * 查询交易用户，需要关联查出渠道名，经纪人名，方案名，报单账号的。
	 */
	public List<Subzh> selectTradeUser(Subzh subzh){
		List<Subzh> list=subzhMapper.selectTradeUser(subzh);
		return list;
	}
	
	public List<Subzh> getAgentzhPtList(int isadmin) throws Exception{
		List<Subzh> list=subzhMapper.getAgentzhPtList(isadmin);
		return list;
	}

    /** 
     * 实名认证
     */
    @Override
    @Transactional
    public String auth(Subzh subzh) {
        Subzh _subzh = subzhMapper.selectByPrimaryKeySubzh(subzh.getSubzh());
        if (_subzh == null) {
            return "用户不存在";
        }
        if(_subzh.getAuthState() == null){
			return "认证失败";
		}
        if (_subzh.getAuthState() != 0 && _subzh.getAuthState() != 3) {
            return "已认证或正在审核中，请勿重复提交申请";
        }
        //subzh.setAuthState(1);
        int i = subzhMapper.updateByPrimaryKeySelective(subzh);
        return i> 0 ? "SUCCESS" : "FAIL";
    }
	
	public boolean checkNameExist(Subzh subzh){
		List<Subzh> list=subzhMapper.checkNameExist(subzh);
		if(list!=null && list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	public List<Subzh> getTradeUserList(Subzh sub){
		List<Subzh> list=subzhMapper.getTradeUserList(sub);
		return list;
	}
	
	public Subzh getTradeUserOne(String subzh){
		return subzhMapper.getTradeUserOne(subzh);
	}

    @Override
    public Subzh selectByInviteCode(String inviteCode) {
        return subzhMapper.selectByInviteCode(inviteCode);
    }

    
    @Transactional
    @Override
    public String getInviteCode(String inviteCode) {
        Subzh subzh = subzhMapper.selectByInviteCode(inviteCode);
        if (subzh == null) {
            return inviteCode;
        }else {
            return getInviteCode(StringUtil.getRandom(6));
        }
    }
	
	public List<Subzh> getFanganSubzh(Subzh subzh){
		return subzhMapper.getFanganSubzh(subzh);
	}

	@Override
	public Subzh selectByPrimaryKeySubzh(String phone) {
	
		return subzhMapper.selectByPrimaryKeySubzh(phone);
	}

	@Override
	public int insertSelective(Subzh subzh) {
		
		return subzhMapper.insertSelective(subzh);
	}

	@Override
	public Subzh getSubzhByInviteCode(String inviteCode) {
		
		return subzhMapper.getSubzhByInviteCode(inviteCode);
	}

	@Override
	public boolean deleteBySubzh(String subzh) {
		
		return subzhMapper.deleteBySubzh(subzh);
	}
}
