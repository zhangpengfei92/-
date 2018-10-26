package com.jcl.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcl.comm.PaginationContext;
import com.jcl.pojo.FileUploadPathObject;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.UserInfo;
import com.jcl.pojo.UserInfoExample;
import com.jcl.pojo.UserInfoExample.Criteria;
import com.jcl.service.RightsRoleService;
import com.jcl.service.UserInfoService;
import com.jcl.stock.entity.CONST;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.entity.RegisterReq;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.ExcelReader;
import com.jcl.util.FileUtil;
import com.jcl.util.ReadExcel2007;
import com.jcl.util.StringUtil;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	public static Logger log = Logger.getLogger(MemberController.class);
	/*体验版权限ID*/
	private static final int FREE_ROLEID = DeployProperties.getInstance().getPublicFreeversionRoleId();
	/*体验版 免费天数*/
	private static final int FREE_DAY = DeployProperties.getInstance().getPublicFreeversionDays();
	/*上传文件路径*/
	//private static final String UPLOAD_FILEPATH = DeployProperties.getInstance().getPublicFilePath();
	/*重置默认密码*/
	private static final String DEFAULT_PASSWORD = DeployProperties.getInstance().getPublicDefaultPassword();
	
	@Autowired
	private UserInfoService userInfoservice;

	//@Autowired
	//private TraderService traderservice;

	/*权限角色Service*/
	@Autowired
	private RightsRoleService rightsRoleService;
	
	/*交易Service*/
	@Autowired
    private SimulateStockService simulateStockService;

	// 会员管理页面跳转
	@RequestMapping("/jumpcommonmember")
	public String jumpmember(Model model) {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<UserInfo> userlist = userInfoservice.selectAll();
			PageInfo<UserInfo> userpage = new PageInfo<UserInfo>(userlist);
			if(userlist != null && userlist.size() > 0){
				List<RightsRole> roles = null;
				/*查询权限列表*/
				try {
					roles = rightsRoleService.getListByLikeName(null);
					model.addAttribute("rightsRoles", roles);
				} catch (Exception e1) {
					log.error("查询权限列表异常：" + e1.getMessage());
				}
				boolean roleFlag = false;
				if(roles != null && roles.size() > 0){
					roleFlag = true;
				}
				for(UserInfo userInfo : userlist){
					if(roleFlag){
						for(RightsRole rightsRole : roles){
							if(rightsRole.getId().equals(userInfo.getUsertype())){
								userInfo.setFuncinfo(rightsRole.getRolename());
								break;
							}
						}
					}
					if(userInfo.getStarttime() != null){//起始时间显示
						userInfo.setSyncinfo(DateUtil.dateToString(userInfo.getStarttime()));
					} else {
						userInfo.setSyncinfo("--");
					}
					if(userInfo.getEndtime() != null){//结束时间显示
						userInfo.setClientfrom(DateUtil.dateToString(userInfo.getEndtime()));
					} else {
						userInfo.setClientfrom("--");
					}
				}
			}
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常：" + e.getMessage());
		}
		return "member/getmember";
	}

	// 会员列表模糊查询
	@RequestMapping("/select")
	public String select(String nickname, String usertype, Model model) throws UnsupportedEncodingException {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			UserInfoExample example = new UserInfoExample();
			example.setOrderByClause(" id desc, createTime desc");
			Criteria criteria = example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andUsernameLike("%" + nickname + "%");
			}
			if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andUsertypeEqualTo(Integer.parseInt(usertype));
			}
			List<UserInfo> userlist = userInfoservice.selectByExample(example);
			PageInfo<UserInfo> userpage = new PageInfo<UserInfo>(userlist);
			if(userlist != null && userlist.size() > 0){
				List<RightsRole> roles = null;
				/*查询权限列表*/
				try {
					roles = rightsRoleService.getListByLikeName(null);
					model.addAttribute("rightsRoles", roles);
				} catch (Exception e1) {
					log.error("查询权限列表异常：" + e1.getMessage());
				}
				boolean roleFlag = false;
				if(roles != null && roles.size() > 0){
					roleFlag = true;
				}
				for(UserInfo userInfo : userlist){
					if(roleFlag){
						for(RightsRole rightsRole : roles){
							if(rightsRole.getId().equals(userInfo.getUsertype())){
								userInfo.setFuncinfo(rightsRole.getRolename());
								break;
							}
						}
					}
					if(userInfo.getStarttime() != null){//起始时间显示
						userInfo.setSyncinfo(DateUtil.dateToString(userInfo.getStarttime()));
					} else {
						userInfo.setSyncinfo("--");
					}
					if(userInfo.getEndtime() != null){//结束时间显示
						userInfo.setClientfrom(DateUtil.dateToString(userInfo.getEndtime()));
					} else {
						userInfo.setClientfrom("--");
					}
				}
			}
			model.addAttribute("nickname", nickname);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常：" + e.getMessage());
		}
		return "member/getmember";
	}

	// 编辑会员
	@RequestMapping("/editmember")
	public String editmember(Integer id, Model model) {
		try {
			List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
			model.addAttribute("rightsRoles", roles);
			UserInfo user = userInfoservice.selectByPrimaryKey(id);
			if(user.getStarttime() != null){
				model.addAttribute("starttimeStr", DateUtil.dateToString(user.getStarttime()));
			}
			if(user.getEndtime() != null){
				model.addAttribute("endtimeStr", DateUtil.dateToString(user.getEndtime()));
			}
			model.addAttribute("user", user);
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "member/addmember";
	}
	
	// 新增会员
	@RequestMapping("/addmember")
	public String addmember(Integer id, Model model) {
		try {
			List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
			model.addAttribute("rightsRoles", roles);
			UserInfo user = userInfoservice.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "member/addmember";
	}
	
	// 批量添加账户
	@RequestMapping("/addmemberMore")
	public String addmemberMore(Model model) {
		try {
			List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
			model.addAttribute("rightsRoles", roles);
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "member/addmemberMore";
	}
	
	// 批量保存账户信息
	@RequestMapping("/saveUserMore")
	@ResponseBody
	public String saveUserMore(UserInfo user, String starttimeStr, String endtimeStr, Integer startnum) {
		if(user.getId() == null && user.getMinver() != null && user.getMinver() > 0){//新增
			user.setCreatetime(Calendar.getInstance().getTime());
			user.setDelflag(Constant.DELETED_INT_NO);//正常
			if(user.getUsertype() == null){
				user.setUsertype(FREE_ROLEID);//体验版
			}
			if(StringUtil.isAnyNullOrEmpty(starttimeStr)){
				user.setStarttime(Calendar.getInstance().getTime());
			} else {
				user.setStarttime(DateUtil.stringToDate(starttimeStr, "yyyy-MM-dd"));
			}
			if(StringUtil.isAnyNullOrEmpty(endtimeStr)){
				Date nowDate = Calendar.getInstance().getTime();
				String endDateStr = DateUtil.changeDay(DateUtil.dateToString(nowDate), "yyyy-MM-dd", FREE_DAY);
				user.setEndtime(DateUtil.stringToDate(endDateStr + " 23:59:59", DateUtil.DATETIME_PATTERN_ONE));
			} else {
				user.setEndtime(DateUtil.stringToDate(endtimeStr + " 23:59:59", DateUtil.DATETIME_PATTERN_ONE));
			}
			/*查询权限子栏目*/
			List<RightsRole> roleList = rightsRoleService.selectById(user.getUsertype());
			try {
				String usernameStr = user.getUsername();
				boolean pwFlag = false;
				boolean isExistFlag = false;
				if(StringUtil.isAnyNullOrEmpty(user.getPassword())){
					pwFlag = true;
				}
				/*已存在账户*/
				StringBuffer strBuffer = new StringBuffer("");
				int i = 0;
				int k = user.getMinver() + 1;
				/*起始编号*/
				int startIndex = 1;
				if(startnum != null){
					startIndex = startnum;
					k = k + startnum - 1;
				}
				List<UserInfo> userList = null;
				RegisterReq rr = new RegisterReq();
				Gson gson = new Gson();
				JsonObject jsonObj = null;
    			JsonParser parser = new JsonParser();
				for(int index = startIndex; index < k; index++){
					if(pwFlag){
						user.setPassword(CommonFunc.getEightRandomStr());
					}
					if(index < 10) {
						user.setUsername(usernameStr + "000" + index);
					} else if(index < 100){
						user.setUsername(usernameStr + "00" + index);
					} else if(index < 1000){
						user.setUsername(usernameStr + "0" + index);
					} else {
						user.setUsername(usernameStr + index);
					}
					/*用户名是否存在*/
					userList = userInfoservice.isExist(user.getUsername());
					if(userList == null || userList.size() == 0){
						i = userInfoservice.insertSelective(user, roleList);
						try {
		    	    		/*协议接口*/
		    	    		rr = new RegisterReq();
		    	    		rr.setClient_id(user.getUsername());
		    	    		rr.setNickname(user.getUsername());
		    	    		if(StringUtil.isAnyNullOrEmpty(user.getTelephone())){
		    	    			rr.setTel_num("");
		    	    		} else {
		    	    			rr.setTel_num(user.getTelephone());
		    	    		}
		    	    		String rbStr = simulateStockService.commonFunction(gson.toJson(rr), DefineNumber.JCL_PROTOCOL_REQ_SIGNIN);
		    	    		if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
		    	    			parser = new JsonParser();
		    	    			JsonElement element = parser.parse(rbStr);
		    					jsonObj = element.getAsJsonObject();
		    					if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
		    						log.info("世基模拟交易，注册成功");
			    	    		} else {
									log.error("世基模拟交易注册，" + jsonObj.get("describe").getAsString());
			    				}
		    	    		} else {
		    	    			log.error("注册失败，联系管理员！" + rbStr);
		    	    		}
		    	    	} catch (Exception e1) {
		    				log.error("注册失败，调用注册协议11110异常：" + e1.getMessage());
		    			}
					} else {
						isExistFlag = true;
						strBuffer.append(user.getUsername()).append(",");
					}
				}
				if(isExistFlag){
					usernameStr = strBuffer.toString().substring(0, strBuffer.toString().length()-1);
					return usernameStr;
				}
				if(i > 0){//保存用户成功
					return "true";
				}
			} catch (Exception e) {
				log.error("新增账户信息异常：" + e.getMessage());
				return "fasle";
			}
			return "fasle";
		} 
		return "fasle";
	}
	
	// excel导入
	@RequestMapping("/addmemberImport")
	public String addmemberImport(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("sessionToken", "6aa35341f25184fd996c4c918255c3a1");
		return "member/addmemberImport";
	}

	// excel批量保存账户信息
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveUserMoreExcel")
	public String saveUserMoreExcel(@RequestParam("file")MultipartFile file, HttpServletRequest request, Model model) {
		String sessionToken = request.getSession().getAttribute("sessionToken").toString();
		if("6aa35341f25184fd996c4c918255c3a1".equals(sessionToken) && !file.isEmpty()){
			try {
	        	CommonsMultipartFile cf = (CommonsMultipartFile)file; 
				DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
				File fil = fi.getStoreLocation();
				String[] strs={"XLS","XLSX"};
				FileUtil._strAllowdFileExts = strs;
				/*开始行、开始列*/
				int startRow = 2;
				int startColumn = 1;
				/*添加Excel数据*/
				FileUploadPathObject uploadPathObject = FileUtil.uploadProjectLocal("excel", fil, "excel_"+System.currentTimeMillis()+".xlsx");
				/*判断上传地址不为空*/
				if (uploadPathObject != null){
					/*获取该Excel数据信息*/
					String filePath = uploadPathObject.getAbsoluteFullPath();
					/*实例化ExcelReader对象*/
					ExcelReader excelReader = new ExcelReader(filePath);
					
					/*总行数 */
					//int rowCount = 0;
					/*总列数 */
					//int colCount = 0;
					
					List<List<String>> listData = null;
					// 判断是否是97-2003 Excel文件格式
					if (excelReader.isExcelFile()) {
						// 表格的行数 
						//rowCount = excelReader.getRowsNum();
						
						// 表格的列数 
						//colCount = excelReader.getColumnsNum();
						
						// 设置工作薄页码 
						excelReader.setCurrentSheetIndex(0);
			
						// 设置表行列起始位置 (第2行，第1列)第一行为标题行 
						excelReader.setDataStartRowCol(startRow, startColumn);
						
						//是2003格式时 读取数据
						listData = excelReader.readData();
					} else {
						//builder.append("错误提示信息：表格版本不符合规范！（Excel：97-2003版）");
						//是2007格式时 读取数据
						ReadExcel2007 readExcel2007 = new ReadExcel2007(filePath);
						
						// 设置表行列起始位置 (第2行，第1列)第一行为标题行 
						readExcel2007.setDataStartRowCol(startRow, startColumn);
						
						listData = readExcel2007.readData();
					}
					
					/*保存详细表即excel中数据*/
					int exceptionRow = 0;
					String exceptionDate = "";
					UserInfo ruleInfo = null;
					boolean isExistFlag = false;
					/*已存在账户*/
					StringBuffer strBuffer = new StringBuffer("系统已存在账户或规则验证失败账户：");
					/*查询权限子栏目*/
					List<RightsRole> roleList = null;
					List<UserInfo> userList = null;
					int usert = 0;
					Gson gson = new Gson();
					RegisterReq rr = new RegisterReq();
					JsonObject jsonObj = null;
	    			JsonParser parser = new JsonParser();
					for (List<String> data : listData) {
						if(data != null && data.size() > 0){
							
							ruleInfo = new UserInfo();
							ruleInfo.setDelflag(Constant.DELETED_INT_NO);//正常
							exceptionRow = exceptionRow + 1;
					        
							/*直接截取数据库相应字段个数的数据*/
					        /*判断是否全为空*/
							Boolean isFlag = false;
							for(int i = 0; i < data.size(); i++){
								/*此数字在list集合中，则为字符串或日期 加'' */
								if(i == 0){
									ruleInfo.setUsername(data.get(0));//用户名
									if(data.get(0) != null && (data.get(0).length() > 20 || data.get(0).length() < 8)){
										break;
									} else if(data.get(0) != null && !data.get(0).matches("[0-9A-Za-z_]*")){
										break;
									}
								} else if(i == 1){
									ruleInfo.setPassword(data.get(1));//密码
									if(data.get(1) != null && (data.get(1).length() > 20 || data.get(1).length() < 8)){
										//ruleInfo.setPassword(data.get(1).substring(0, 20));
										break;
									} else if(data.get(1) != null && !data.get(1).matches("[0-9A-Za-z_]*")){
										break;
									} 
								} else if(i == 2){
									ruleInfo.setInfo(data.get(2));//价格
								} else if(i == 3){
									if(!StringUtil.isAnyNullOrEmpty(data.get(3))){
										ruleInfo.setUsertype(Integer.parseInt(data.get(3)));//账户权限
									} else {
										ruleInfo.setUsertype(FREE_ROLEID);//账户权限
									}
								} else if(i == 4){//起始时间
									if(!StringUtil.isAnyNullOrEmpty(data.get(4))){
										ruleInfo.setStarttime(DateUtil.stringToDate(data.get(4), "yyyy/MM/dd"));
									} else {
										ruleInfo.setStarttime(Calendar.getInstance().getTime());
									}
								} else if(i == 5){//结束时间
									if(!StringUtil.isAnyNullOrEmpty(data.get(5))){
										ruleInfo.setEndtime(DateUtil.stringToDate(data.get(5), "yyyy/MM/dd"));
									} else {
										Date nowDate = Calendar.getInstance().getTime();
										String endDateStr = DateUtil.changeDay(DateUtil.dateToString(nowDate), "yyyy-MM-dd", FREE_DAY);
										ruleInfo.setEndtime(DateUtil.stringToDate(endDateStr, "yyyy-MM-dd"));
									}
								} else if(i == 6){
									ruleInfo.setTelephone(data.get(6));//手机号码
								} 
								
								/*判断是否全为空*/
								for(int in = 0; in < data.size(); in++){
									/*按模板所在列取数据*/
									//int ki = colList.get(in) - 1;
									if(!StringUtil.isAnyNullOrEmpty(data.get(in))){
										isFlag = true;
										break;
									}
								}
							}
							try {
								if(isFlag){
									roleList = rightsRoleService.selectById(ruleInfo.getUsertype());
									/*保存用户数据*/
									/*用户名是否存在*/
									userList = userInfoservice.isExist(ruleInfo.getUsername());
									if(userList == null || userList.size() == 0){
										usert = userInfoservice.insertSelective(ruleInfo, roleList);
										try {
						    	    		/*协议接口*/
											rr = new RegisterReq();
						    	    		rr.setClient_id(ruleInfo.getUsername());
						    	    		rr.setNickname(ruleInfo.getUsername());
						    	    		if(StringUtil.isAnyNullOrEmpty(ruleInfo.getTelephone())){
						    	    			rr.setTel_num("");
						    	    		} else {
						    	    			rr.setTel_num(ruleInfo.getTelephone());
						    	    		}
						    	    		String rbStr = simulateStockService.commonFunction(gson.toJson(rr), DefineNumber.JCL_PROTOCOL_REQ_SIGNIN);
						    	    		if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
						    	    			parser = new JsonParser();
						    	    			JsonElement element = parser.parse(rbStr);
						    					jsonObj = element.getAsJsonObject();
						    					if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
						    						log.info("世基模拟交易，注册成功");
							    	    		} else {
													log.error("世基模拟交易注册，" + jsonObj.get("describe").getAsString());
							    				}
						    	    		} else {
						    	    			log.error("注册失败，联系管理员！" + rbStr);
						    	    		}
						    	    	} catch (Exception e1) {
						    				log.error("注册失败，调用注册协议11110异常：" + e1.getMessage());
						    			}
									} else {
										isExistFlag = true;
										strBuffer.append(ruleInfo.getUsername()).append("、");
										log.info("Excel中，系统已存在账户->" + ruleInfo.getUsername() + " 上传excel中第" + (exceptionRow + (startRow-1)) + "行");
									}
								} else {
									break;
								}
							} catch (Exception e) {
								log.error("Excel中，系统已存在账户->" + ruleInfo.getUsername() + 
								" 上传excel中第" + (exceptionRow + (startRow-1)) + "行数据字段长度过大或字段类型不匹配！" + exceptionDate + e.getMessage());
							}
						}
					}
					request.getSession().setAttribute("sessionToken", "");
					if(isExistFlag){
						String usernameStr = strBuffer.toString().substring(0, strBuffer.toString().length()-1) + "，其他账户添加成功。";
						model.addAttribute("upload", usernameStr);
					}
					if(usert > 0){//保存用户成功
						model.addAttribute("upload", "true");
					}
				}
			} catch (Exception ew) {
				log.error("excel读取异常：" + ew.getMessage());
			}
		}
			
		try {
			PageHelper.startPage(1, 10);
			List<UserInfo> userlist = userInfoservice.selectAll();
			PageInfo<UserInfo> userpage = new PageInfo<UserInfo>(userlist);
			if(userlist != null && userlist.size() > 0){
				List<RightsRole> roles = null;
				/*查询权限列表*/
				try {
					roles = rightsRoleService.getListByLikeName(null);
					model.addAttribute("rightsRoles", roles);
				} catch (Exception e1) {
					log.error("查询权限列表异常：" + e1.getMessage());
				}
				boolean roleFlag = false;
				if(roles != null && roles.size() > 0){
					roleFlag = true;
				}
				for(UserInfo userInfo : userlist){
					if(roleFlag){
						for(RightsRole rightsRole : roles){
							if(rightsRole.getId().equals(userInfo.getUsertype())){
								userInfo.setFuncinfo(rightsRole.getRolename());
								break;
							}
						}
					}
					if(userInfo.getStarttime() != null){//起始时间显示
						userInfo.setSyncinfo(DateUtil.dateToString(userInfo.getStarttime()));
					} else {
						userInfo.setSyncinfo("--");
					}
					if(userInfo.getEndtime() != null){//结束时间显示
						userInfo.setClientfrom(DateUtil.dateToString(userInfo.getEndtime()));
					} else {
						userInfo.setClientfrom("--");
					}
				}
			}
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常：" + e.getMessage());
		}
		return "member/getmember";
		//return "member/addmemberImport";
	}
	
	// 编辑会员
	@RequestMapping("/editUser")
	@ResponseBody
	public String editUser(UserInfo user, String starttimeStr, String endtimeStr, Integer id) {
		if(user.getId() == null){//新增
			/*判断用户名是否已存在*/
			try {
				List<UserInfo> userList = userInfoservice.isExist(user.getUsername());
				if(userList != null && userList.size() > 0){
					return "fasle";
				}
			} catch (Exception es) {
				log.error("查询用户名是否已存在异常：" + es.getMessage());
			}
			
			user.setCreatetime(Calendar.getInstance().getTime());
			user.setDelflag(Constant.DELETED_INT_NO);//正常
			if(user.getUsertype() == null){
				user.setUsertype(FREE_ROLEID);//体验版
			}
			if(StringUtil.isAnyNullOrEmpty(starttimeStr)){
				user.setStarttime(Calendar.getInstance().getTime());
			} else {
				user.setStarttime(DateUtil.stringToDate(starttimeStr, "yyyy-MM-dd"));
			}
			if(StringUtil.isAnyNullOrEmpty(endtimeStr)){
				Date nowDate = Calendar.getInstance().getTime();
				String endDateStr = DateUtil.changeDay(DateUtil.dateToString(nowDate), "yyyy-MM-dd", FREE_DAY);
				user.setEndtime(DateUtil.stringToDate(endDateStr + " 23:59:59", DateUtil.DATETIME_PATTERN_ONE));
			} else {
				user.setEndtime(DateUtil.stringToDate(endtimeStr + " 23:59:59", DateUtil.DATETIME_PATTERN_ONE));
			}
			if(!user.getStarttime().before(user.getEndtime())){
				return "dateFalse";
			}
			/*查询权限子栏目*/
			List<RightsRole> roleList = rightsRoleService.selectById(user.getUsertype());
			try {
				int i = userInfoservice.insertSelective(user, roleList);
				if(i > 0){//保存用户成功
	    	    	
	    	    	try {
	    	    		/*协议接口*/
	    	    		RegisterReq rr = new RegisterReq();
	    	    		rr.setClient_id(user.getUsername());
	    	    		rr.setNickname(user.getUsername());
	    	    		if(StringUtil.isAnyNullOrEmpty(user.getTelephone())){
	    	    			rr.setTel_num("");
	    	    		} else {
	    	    			rr.setTel_num(user.getTelephone());
	    	    		}
	    	    		Gson gson = new Gson();
	    	    		String rbStr = simulateStockService.commonFunction(gson.toJson(rr), DefineNumber.JCL_PROTOCOL_REQ_SIGNIN);
	    	    		if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
	    	    			JsonObject jsonObj = null;
	    	    			JsonParser parser = new JsonParser();
	    	    			JsonElement element = parser.parse(rbStr);
	    					jsonObj = element.getAsJsonObject();
	    					if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
	    						//result.setMessage("注册成功");
	    						log.info("世基模拟交易，注册成功");
		    	    		} else {
		    	    			//result.setCode(Constant.RETURN_DATA_ERROR);
								//result.setMessage(jsonObj.get("describe").getAsString());
								log.error("世基模拟交易注册，" + jsonObj.get("describe").getAsString());
		    				}
	    	    		} else {
	    	    			//result.setCode(Constant.RETURN_DATA_ERROR);
							//result.setMessage("注册失败，联系管理员！" + rbStr);
	    	    			log.error("注册失败，联系管理员！" + rbStr);
	    	    		}
	    	    	} catch (Exception e1) {
	    				log.error("注册失败，调用注册协议11110异常：" + e1.getMessage());
	    				//result.setCode(Constant.RETURN_DATA_ERROR);
	    				//result.setMessage("注册异常，联系管理员 " + e1.getMessage());
	    			}
					return "true";
				}
			} catch (Exception e) {
				log.error("新增账户信息异常：" + e.getMessage());
				return "fasle";
			}
			return "false";
		} else {
			user.setCreatetime(Calendar.getInstance().getTime());
			user.setDelflag(Constant.DELETED_INT_NO);//正常
			if(user.getUsertype() == null){
				user.setUsertype(FREE_ROLEID);//体验版
			}
			if(StringUtil.isAnyNullOrEmpty(starttimeStr)){
				user.setStarttime(Calendar.getInstance().getTime());
			} else {
				user.setStarttime(DateUtil.stringToDate(starttimeStr, "yyyy-MM-dd"));
			}
			if(StringUtil.isAnyNullOrEmpty(endtimeStr)){
				Date nowDate = Calendar.getInstance().getTime();
				String endDateStr = DateUtil.changeDay(DateUtil.dateToString(nowDate), "yyyy-MM-dd", FREE_DAY);
				user.setEndtime(DateUtil.stringToDate(endDateStr + " 23:59:59", DateUtil.DATETIME_PATTERN_ONE));
			} else {
				user.setEndtime(DateUtil.stringToDate(endtimeStr + " 23:59:59", DateUtil.DATETIME_PATTERN_ONE));
			}
			if(!user.getStarttime().before(user.getEndtime())){
				return "dateFalse";
			}
			/*查询权限子栏目*/
			List<RightsRole> roleList = rightsRoleService.selectById(user.getUsertype());
			try {
				int i = userInfoservice.updateByPrimaryKeyAndRole(user, roleList);
				if(i > 0){//保存用户成功
					return "true";
				}
			} catch (Exception e) {
				log.error("更新账户信息异常：" + e.getMessage());
				return "fasle";
			}
			return "false";
		}

	}

	// 批量删除
	@RequestMapping("/DeleteUsers")
	@ResponseBody
	public String DeleteUsers(Integer[] ids) {
		if (ids != null) {
			for (Integer id : ids) {
				try {
					//UserInfo user = userInfoservice.selectByPrimaryKey(id);
					//user.setStatus(0);
					//i = userInfoservice.updateByPrimaryKey(user);
					userInfoservice.deleteByPrimaryKey(id);
				} catch (Exception e) {
					log.error("删除账户异常：" + e.getMessage());
					return "false";
				}
			}
		}
		return "true";
	}

	// 单个删除
	@RequestMapping("/DeleteUserOne")
	@ResponseBody
	public String DeleteUserOne(Integer id) {
		//UserInfo user = userInfoservice.selectByPrimaryKey(id);
		//user.setStatus(0);
		//int i = userInfoservice.updateByPrimaryKey(user);
		try {
			userInfoservice.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}
	
	// 单个暂停
	@RequestMapping("/setStatusUserOne")
	@ResponseBody
	public String setStatusUserOne(Integer id) {
		//UserInfo user = userInfoservice.selectByPrimaryKey(id);
		//user.setStatus(0);
		//int i = userInfoservice.updateByPrimaryKey(user);
		int i = 0;
		try {
			UserInfo user = userInfoservice.selectByPrimaryKey(id);
			user.setDelflag(Constant.DELETED_INT_YES);
			i = userInfoservice.updateByPrimaryKey(user);
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
		}
		if(i > 0){
			return "true";
		} else {
			return "false";
		}
	}

	// 恢复
	@RequestMapping("/reinstate")
	@ResponseBody
	public String reinstate(Integer id) {
		int i = 0;
		try {
			UserInfo user = userInfoservice.selectByPrimaryKey(id);
			user.setDelflag(Constant.DELETED_INT_NO);
			i = userInfoservice.updateByPrimaryKey(user);
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}

	}
	
	/*重置密码*/
	@RequestMapping("/defaultPsw")
	@ResponseBody
	public String defaultPsw(Integer id) {
		int i = 0;
		try {
			UserInfo user = userInfoservice.selectByPrimaryKey(id);
			user.setPassword(DEFAULT_PASSWORD);
			i = userInfoservice.updateByPrimaryKey(user);
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}

	}
	
	// 批量启用
	@RequestMapping("/reinstateUsers")
	@ResponseBody
	public String reinstateUsers(Integer[] ids) {
		if (ids != null) {
			UserInfo user = null;
			for (Integer id : ids) {
				try {
					user = userInfoservice.selectByPrimaryKey(id);
					user.setDelflag(Constant.DELETED_INT_NO);
					userInfoservice.updateByPrimaryKey(user);
				} catch (Exception e) {
					log.error("启用账户异常：" + e.getMessage());
					return "false";
				}
			}
		}
		return "true";
	}

}