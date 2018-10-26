package com.jcl.stock.simulate;

  
    /**        
     * Title: DefineNumber.java    
     * Description: 功能号常量定义
     * @author zhuj       
     * @created 2015-5-15 下午1:28:45    
     */      
    
public interface DefineNumber {
	//数据中心订阅服务号类型
	public static enum ServerNumber{
		SimulateBond,DBService
	}
	//公共----------------------------------------------------------------------------------------------------------
	public static final int SO_TIME_OUT = 6000;                //Socket Time Out  
	public static final int HEAD_BYTE_LENGTH=47;                   //包头文件字节长
	public static final int HEAD_BYTE_ROUTER_LENGTH=298;                   //包头文件字节长
	public static final int USER_BASE_LENGTH=60;                  //UserBase基类字节长
	public static final int STATUS_SUCCESS=0;                  //查询返回状态  成功
	public static final int ZIP_DATALENGTH = 1024;                //是否压缩的数据长度界限 
	public static final long LONG_MAX = 9223372036854775800l;      //9223372036854775807
	public static final long RESPONSE_TIME_OUT = 6000;      //6S
	public static final long HEARTBEAT_INTERVAL = 10000;     //10s
	public static final long REGISTER_INTERVAL = 25000;      //25s
	
	public static final String SimulateBond = "SimulateBond";
	//public static final String SecurityService = "SimulateRZRQ";
	public static final String SecurityService = "SimulateBond";
	public static final String DBService = "DBService";
	public static final String JavaInterface = "JavaInterface\0";
	public static final byte JCL_PROTOCOL_VER = 7;
	public static final int QUEUE_MAX_SIZE = 1000;
	//模拟炒股-------------------------------------------------------------------------------------------------------
	
	/**************************************对协议********************************/
	public static final int JCL_PROTOCOL_REQ_SIGNIN         = 11110;   //注册 签入，开赛
	public static final int JCL_PROTOCOL_ID_REQ_XGMM	    = 11111;   //修改密码
	public static final int REQ_USER_CHECK_OUT              = 11102;   //退出登录
	
	public static final int	JCL_PROTOCOL_REQ_GAMEHOLDER     = 11124;   // 比赛持仓查询
	public static final int	REQ_QUERY_GROUP	                = 11138;   // 查询组合
	public static final int	JCL_PROTOCOL_REQ_NRSJ           = 11139;   //查询牛人数据
	public static final int	JCL_PROTOCOL_REQ_GROUP	        = 11140;   // 查询用户组合
	
	public static final int	JCL_PROTOCOL_GROUP_WT           = 11142;   //最近组合调仓
	public static final int	JCL_PROTOCOL_GAMEMONEY_INFO     = 11143;   //用户参加的比赛信息
	
	public static final int JCL_PROTOCOL_ID_REQ_CDCX	    = 11118;   //可撤单委托查询  333100
	
	public static final int REQ_CREATE_GAME	    			= 11134;   //创建比赛
	public static final int REQ_MODIFY_GAME	    			= 11153;   //修改比赛起始/结束日期
	public static final int JCL_PROTOCOL_REQ_JOIN_GAME	    = 11136;   //加入比赛
	public static final int REQ_BS_REASON					= 11137;   //买卖原因
	public static final int JCL_PROTOCOL_ID_REQ_LSWTCX	    = 11120;   //历史委托查询
	
	
	public static final int JCL_PROTOCOL_UNSUBSCRIBE	    = 11146;   //取消订阅
	public static final int JCL_PROTOCOL_REQ_SUBSCRIBE_DETAIL	    = 12002;   //订阅查询
	
	public static final int JCL_POTOCOL_GAME_WT             = 11146;   //比赛委托
	public static final int JCL_POTOCOL_GROUP_WT   			= 11147;   //组合委托买卖
	
	public static final int JCL_PROTOCOL_GROUP_PROFIT       = 11152;   //组合收益查询
	public static final int JCL_PROTOCOL_TRANSFER_POSITIONS = 11145;   //牛人最近调仓查询
	
	
	public static final int JCL_PROTOCOL_ID_REQ_QUERY_DAY_PROFIT = 30008;  //查询人气/日/周/月/总收益率排行 
	public static final int JCL_PROTOCOL_ID_REQ_QUERY_INDEX_TOPDATA  =30010; //未登录后推荐首页的数据牛人数据
	public static final int JCL_PROTOCOL_ID_REQ_QUERY_SINGLEUSERALLPROFIT  =30000; //查询指定用户所有日收益信息集合
	
	public static final int REQ_CREATE_GAME_SECURITY	    = 20100;   //创建融资融券比赛
	
	/**************************************end*********************************/
	/**************************************外汇跟单功能号***************************/
	public static final int JCL_PROTOCOL_ID_REQ_KHJY	                 = 11101; //客户校验
	public static final int JCL_PROTOCOL_ID_REQ_ZJYE	                 = 11103; //资金余额查询
	public static final int JCL_PROTOCOL_ID_REQ_USERLIST                 = 11104; //查询所有用户信息
	public static final int JCL_PROTOCOL_ID_REQ_LSCJ	                 = 11121; //历史成交记录
	public static final int	JCL_PROTOCOL_ID_REQ_GFCX_KS	    			 = 11123; //持仓查询
	public static final int JCL_PROTOCOL_SUBSCRIBE	                     = 11146; //合约查询
	public static final int JCL_PROTOCOL_CUSTOMER_FOLLOW	             = 11100; //客户跟单
	public static final int JCL_PROTOCOL_FINISH_FOLLOW	                 = 11148; //断开跟随关系
	public static final int JCL_PROTOCOL_CUSTOMER_SETTLE	             = 11149; //交易员结算
	public static final int JCL_POTOCOL_SEARCH_STOCKS	                 = 11150; //请求行情数据
	
	public static final int JCL_PROTOCOL_ID_REQ_DRCJCX	                 = 11117; //当日成交查询
	public static final int JCL_PROTOCOL_ID_REQ_HOLDLISTCOMPARE          = 20002; //持仓对比
	public static final int JCL_PROTOCOL_ID_REQ_RISKTEMPCATE             = 20012; //通知柜台重新加载风控参数
	
	public static final int JCL_PROTOCOL_ID_REQ_SUBZHSELLDEAL	         = 11106; //子账户一键平仓
	public static final int JCL_PROTOCOL_ID_REQ_FUNDMESSAGE = 20009;  //出入金
	
	public static final int JCL_PROTOCOL_ID_REQ_FUNDMESSAGE1=100000000;
	
}