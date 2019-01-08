package com.jcl.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.dao.FeetemplateMapper;
import com.jcl.dao.Feetemplate_menuMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.Codefeeset;
import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.Feetemplate;
import com.jcl.pojo.FeetemplateExample;
import com.jcl.pojo.FeetemplateExample.Criteria;
import com.jcl.pojo.Feetemplate_menu;
import com.jcl.pojo.Feetemplate_menuExample;
import com.jcl.pojo.Subzh;
import com.jcl.service.FeetemplateService;
import com.jcl.service.SubzhService;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.StringUtil;
import com.jcl.vo.MsCodeResult;

/**
 * 手续费分成
 * 
 * @author zhenghuayi
 *
 */
@Controller
@RequestMapping("/feeTemplate")
public class FeetemplateController {

	public static Logger log = Logger.getLogger(FeetemplateController.class);

	/* 子账户管理service */
	@Autowired
	private SubzhService subzhService;

	@Autowired
	private FeetemplateService feetemplateService;

	@Autowired
	private Feetemplate_menuMapper feetemplate_menuMapper;

	@Autowired
	private SubzhMapper subzhMapper;

	@Autowired
	private FeetemplateMapper feetemplateMapper;

	// 收费方案管理页面跳转
	@RequestMapping("/feeTemplateList")
	public String feeTemplateList(HttpSession session, Model model, String nickname, String usertype, String marketcode,
			Integer pageNum) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "11");
		try {
			/* 查询手续费分成方案列表 */
			Feetemplate_menuExample example = new Feetemplate_menuExample();
			com.jcl.pojo.Feetemplate_menuExample.Criteria ca = example.createCriteria();
			List<Feetemplate_menu> feetemplate_menuList = feetemplate_menuMapper.selectByExample(example);
			model.addAttribute("feeschemeMenuList", feetemplate_menuList);
			if (feetemplate_menuList != null && feetemplate_menuList.size() > 0) {
				PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
				FeetemplateExample ex = new FeetemplateExample();
				ex.setOrderByClause("id desc");
				Criteria criteria = ex.createCriteria();
				if (!StringUtil.isAnyNullOrEmpty(usertype)) {
					criteria.andParentidEqualTo(Integer.parseInt(usertype));
				} else {
					criteria.andParentidEqualTo(feetemplate_menuList.get(0).getId());
				}
				if (!StringUtil.isAnyNullOrEmpty(nickname)) {
					criteria.andStockcodeLike("%" + nickname + "%");
				}
				if (!StringUtil.isAnyNullOrEmpty(marketcode)) {
					criteria.andScEqualTo(Integer.parseInt(marketcode));
				}
				List<Feetemplate> feetemplateList = feetemplateMapper.selectByExample(ex);
				PageInfo<Feetemplate> userpage = new PageInfo<Feetemplate>(feetemplateList);
				model.addAttribute("usertypeValue", usertype);
				model.addAttribute("marketcodeValue", marketcode);
				model.addAttribute("nickname", nickname);
				model.addAttribute("userlist", feetemplateList);
				model.addAttribute("userpage", userpage);
			}
		} catch (Exception e) {
			log.error("查询收费方案列表异常：" + e.getMessage());
		}
		return "feeTemplate/feeTemplateList";
	}

	// 新增收费方案页面
	@RequestMapping("/addfeeScheme")
	public String addfeeScheme() {
		return "feeTemplate/addfeeScheme";
	}

	// 新增收费方案页面
	@RequestMapping("/addCodefeesetMenu")
	public String addCodefeesetMenu() {
		return "feeTemplate/addCodefeesetMenu";
	}

	// 编辑收费方案菜单
	@RequestMapping("/editfeeSchemeMsg")
	@ResponseBody
	public String editfeeSchemeMsg(Feetemplate_menu user, Integer id) {
		/* 判断方案名称是否已存在 */
		try {
			Feetemplate_menuExample example = new Feetemplate_menuExample();
			com.jcl.pojo.Feetemplate_menuExample.Criteria ca = example.createCriteria();
			ca.andTitleEqualTo(user.getTitle());
			List<Feetemplate_menu> feetemplate_menuList = feetemplate_menuMapper.selectByExample(example);
			if (feetemplate_menuList != null && feetemplate_menuList.size() > 0) {
				return "isExist";
			}
			if (id == null) {// 新增
				user.setAgentzh("1");
			} else {
				user.setId(id);
				if (StringUtil.isAnyNullOrEmpty(user.getAgentzh())) {
					user.setAgentzh("1");
				}
			}
			user.setModifytime(new Date());
			int i = feetemplate_menuMapper.insertSelective(user);
			if (i > 0) {
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			feetemplate_menuMapper.deleteByPrimaryKey(user.getId());
		}
		return "false";
	}

	// 编辑收费方案
	@SuppressWarnings("rawtypes")
	@RequestMapping("/editCodefeeset")
	public String editCodefeeset(Integer id, Model model) {
		try {
			List<MsCodeResult> msCodeList = new ArrayList<MsCodeResult>();
			Map<String, String> msCode = CommonFunc.getHttpMsCode();
			if (msCode != null && msCode.size() > 0) {
				MsCodeResult result = null;
				String key = "";
				String[] keyArr = null;
				Iterator entries = msCode.entrySet().iterator();
				while (entries.hasNext()) {
					Map.Entry entry = (Map.Entry) entries.next();
					result = new MsCodeResult();
					key = entry.getKey().toString();
					result.setKey(key);
					keyArr = key.split("-");// 6AH6-CME,14
					if (keyArr.length > 1) {
						result.setCode(keyArr[0]);// 品种代码
						keyArr = keyArr[1].split(",");// CME,14
						result.setMarketCode(keyArr[0]);// 市场代码
					}
					keyArr = key.split(",");
					if (keyArr.length > 1) {
						result.setShowkey(keyArr[0]);// 显示名称
						result.setMarket(keyArr[1]);// 市场
					}
					result.setCodeName(entry.getValue().toString());
					msCodeList.add(result);
					Collections.sort(msCodeList);
				}
			}
			model.addAttribute("yyCodeList", msCodeList);
		} catch (Exception e) {
			log.error("获取代码链或查询异常：" + e.getMessage());
		}
		try {
			List<Feetemplate_menu> feetemplate_menuList = feetemplate_menuMapper.selectAll();
			model.addAttribute("codefeesetMenuList", feetemplate_menuList);
			if (id != null) {
				Feetemplate user = feetemplateMapper.selectByPrimaryKey(id);
				model.addAttribute("user", user);
			}
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "feeTemplate/inputCodefeeset";
	}

	// 编辑收费方案
	@RequestMapping("/editcodefeesetMsg")
	@ResponseBody
	public String editcodefeesetMsg(HttpSession session, Feetemplate user, String starttimeStr, String endtimeStr,
			Integer id) {
		/* 判断方案名称是否已存在 */
		try {
			if (id == null) {// 新增
				String key = user.getStockcode();
				if (!StringUtil.isAnyNullOrEmpty(key)) {
					Map<String, String> msCode = CommonFunc.getHttpMsCode();
					if (msCode != null && msCode.size() > 0) {
						user.setStockname(msCode.get(key));
					}
					String[] keyArr = key.split("-");// 6AH6-CME,14
					if (keyArr.length > 1) {
						user.setStockcode(keyArr[0]);// 品种代码
					}
					keyArr = key.split(",");
					if (keyArr.length > 1) {
						user.setSc(Integer.parseInt(keyArr[1]));// 市场
					}
				}
				FeetemplateExample example = new FeetemplateExample();
				Criteria criteria = example.createCriteria();
				criteria.andStockcodeEqualTo(user.getStockcode());
				criteria.andParentidEqualTo(user.getParentid());
				List<Feetemplate> userList = feetemplateMapper.selectByExample(example);
				if (userList != null && userList.size() > 0) {
					return "isExist";
				}
				user.setAgentzh("1");
				user.setUserid(1l);
			} else {
				FeetemplateExample example = new FeetemplateExample();
				Criteria criteria = example.createCriteria();
				criteria.andStockcodeEqualTo(user.getStockcode());
				criteria.andParentidEqualTo(user.getParentid());
				criteria.andIdNotEqualTo(id);
				List<Feetemplate> userList = feetemplateMapper.selectByExample(example);
				if (userList != null && userList.size() > 0) {
					return "isExist";
				}
				user.setId(id);
				if (StringUtil.isAnyNullOrEmpty(user.getAgentzh())) {
					user.setAgentzh("1");
				}
			}
			user.setModifytime(new Date());
			int i = 0;
			if (id == null) {// 新增
				i = feetemplateMapper.insertSelective(user);
			} else {
				i = feetemplateMapper.updateByPrimaryKeySelective(user);
			}
			if (i > 0) {
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			es.printStackTrace();
			feetemplateMapper.deleteByPrimaryKey(user.getId());
		}
		return "false";
	}

	// 单个删除
	@RequestMapping("/deleteCodefeeset")
	@ResponseBody
	public String deleteCodefeeset(Integer id) {
		try {
			feetemplateMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}

	// 批量修改
	@RequestMapping("/updateCodefeesetMore")
	public String updateCodefeesetMore(Model model, String codefeesetIds) {
		try {
			model.addAttribute("codefeesetId", codefeesetIds);
		} catch (Exception e) {
			log.error("查询异常：" + e.getMessage());
		}
		return "feeTemplate/updateCodefeeset";
	}

	// 编辑收费方案
	@RequestMapping("/editcodefeesetMsgMore")
	@ResponseBody
	public String editcodefeesetMsgMore(HttpSession session, Feetemplate user, String ids) {
		/* 判断方案名称是否已存在 */
		try {
			if (!StringUtil.isAnyNullOrEmpty(ids)) {// 修改
				String[] strId = ids.split(",");
				for (int i = 0; i < strId.length; i++) {
					user.setId(Integer.parseInt(strId[i]));
					feetemplateMapper.updateByPrimaryKeySelective(user);
				}
			}
			return "true";
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
		}
		return "false";
	}

	// 删除收费方案菜单
	@RequestMapping("/deleteCodefeeMenu")
	@ResponseBody
	public String deleteCodefeeMenu(Integer id) {
		try {
			if (id == null) {
				return "false";
			}
			List<Subzh> list = subzhMapper.selectSubzhByRisktype(id);
			if (list != null && list.size() > 0) {// 如果有交易用户关联到此手续费方案
				return "hassub";
			} else {
				feetemplateService.deleteByMenuId(id);
			}
		} catch (Exception e) {
			log.error("删除收费方案异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}
}
