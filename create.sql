--系统用户表
CREATE TABLE [dbo].[sysuser](
	[userid] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[status] [int] NOT NULL,  --用户状态 1:使用中 2：已注销
	[modifytime] [datetime] NOT NULL,
	PRIMARY KEY ([userid]) ); 
	 
INSERT INTO [dbo].[sysuser] ([username],[password],[status],[modifytime]) VALUES('admin', '111111', 1, '2017-05-25 00:00:00');

--菜单栏目表
  CREATE TABLE [dbo].[menu_info](
	[menuId] [int] IDENTITY(1,1) NOT NULL,
	[menuName] [nvarchar](40) NOT NULL,
	[depth] [int] NOT NULL,
	[parentId] [int] NULL,
	[sort] [int] NULL,
	[menuUrl] [varchar](256) NULL,
	[cmd] [varchar](20) NULL,
	[openType] [varchar](1) NULL,
	[paramName] [varchar](50) NULL,
	[image] [varchar](50) NULL,
	[imageData] text NULL,
	[disable] [varchar](50) NULL,
	[disableData] text NULL,
	[status] [int] NOT NULL,
	[modifytime] [datetime] NOT NULL,
	PRIMARY KEY ([menuId]) );
--alter table [dbo].[menu_info] add openType varchar(1);
--alter table [dbo].[menu_info] add paramName varchar(50);
--alter table [dbo].[menu_info] add image varchar(50);
--alter table [dbo].[menu_info] add disable varchar(50);
--alter table [dbo].[menu_info] add cmd varchar(20);	
--alter table [dbo].[menu_info] add imageData text;
--alter table [dbo].[menu_info] add disableData text;
--股票指标表
  CREATE TABLE [dbo].[stock_index](
	[indexId] [int] IDENTITY(1,1) NOT NULL,
	[indexName] [nvarchar](40) NOT NULL,
	[depth] [int] NOT NULL,
	[parentId] [int] NULL,
	[sort] [int] NULL,
	[modifytime] [datetime] NOT NULL,
	PRIMARY KEY ([indexId]) );
--用户信息表
CREATE TABLE [dbo].[userinfo_data](
	[id] [int] IDENTITY(1,1) NOT NULL,     
	[username] [varchar](50) NOT NULL UNIQUE,  --邮箱
	[password] [varchar](50) NULL,
	[TrueName] [varchar](50) NULL, --昵称
	[HeadPicture] [varchar](256) NULL, --头像
	[profile] [varchar](max) NULL, --简介
	[localsource] [varchar](10) NULL, --手机类型 安卓 、ios
	[phoneChannelId] [varchar](100) NULL, --手机用户绑定通道ID
	[phoneUserid] [varchar](100) NULL, --手机用户绑定用户名
	[LoginCount] [int] NULL, --登录次数
	[LastLoginTime] [datetime] NULL,--最后登录时间
	[CreateTime] [datetime] NULL,   --注册时间
	[tradeTime] [datetime] NULL,   --交易时间
	[usertype] [int] NULL Default 0,   -- 用户认证状态 0、未认证  1、等待审核 2、已认证 3、认证失败
	[userStatus] [int] NULL Default 0, -- 用户账号状态 1、冻结 2、销户 0、正常
	--[account] [varchar](20) NULL,--谷歌验证秘钥
	--[accountUrl] [varchar](100) NULL,--谷歌验证二维码
	--[accountStatus] [int] NULL Default 0,--谷歌验证 0、未启用  1、启用
	--[cookie] numeric(20) NULL ,--用户名对应的cookie
	
	[birthday] [varchar](20) NULL,   
	[sex] [varchar] (5)NULL,                
	[homePhone] [varchar](20) NULL, 
	[DelFlag] [int] NULL,          
	[telePhone] [varchar](20) NULL,    
	[province] [varchar](20) NULL,   
	[city] [varchar](20) NULL,   
	[town] [varchar](20) NULL,   
	[Email] [varchar](50) NULL,     
	[hometown] [varchar](100) NULL,   
	[homeStyle] [varchar](10) NULL,  
	[postcode] [varchar](20) NULL,  
	[country] [varchar](10) NULL,     
	[nationality] [varchar](10) NULL,  
	[name] [varchar](50) NULL,        -- 姓名
	[ip] [varchar](20) NULL,      --名族
	[ename] [varchar](50) NULL,    --姓名拼音
	[cardImage1] [varchar](256) NULL, --身份证图片正面
	[cardImage2] [varchar](256) NULL,  --身份证图片反面
	[cardImage3] [varchar](256) NULL,  --手持身份证照片
	[cardNumber] [varchar](50) NULL,    --身份证号码
	[address] [varchar](50) NULL,    --住址
	[registfrom] [varchar](50) NULL,  --签发机关
	[cardStarttime] [varchar](50) NULL, --身份证有效期(开始)
	[cardEndtime] [varchar](50) NULL,  --身份证有效期(结束)
	[accountType] [varchar](20) NULL, -- 账户类型
	[tradeType] [varchar](20) NULL,   -- 交易特权
	
	[Day] [int] NULL,
	[QQ] [varchar](50) NULL,
	[Pid] [int] NULL,        --禁用 0 ,null 或者其他不禁用
	[qq_openid] [varchar](50) NULL,
	[login_type] [varchar](10) NULL,   --邮箱激活
	[weibo_openid] [varchar](50) NULL,
	[strategy_id] [int] NULL --(目前是手续费)策略id
	PRIMARY KEY ([id]))	
--客户端用户认证表
  CREATE TABLE [dbo].[userinfo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](30) NOT NULL,
	[password] [varchar](50) NULL,
	[sex] [int] NULL,
	[expiredate] [datetime] NULL,
	[admin] [int] NULL,
	[minver] [int] NULL,
	[lasttime] [datetime] NULL,
	[info] [varchar](50) NULL,
	[online] [varchar](100) NULL,
	[ip] [varchar](20) NULL,
	[netcard] [varchar](20) NULL,
	[starttime] [datetime] NULL,
	[endtime] [datetime] NULL,
	[lastmonth] [int] NULL,
	[huming] [int] NULL,
	[name] [nvarchar](50) NULL,
	[telephone] [nvarchar](20) NULL,
	[paymoney] [float] NULL,        --资金
	[ucname] [nvarchar](50) NULL,
	[paytime] [datetime] NULL,
	[seller] [nvarchar](50) NULL,
	[funcinfo] [varchar](50) NULL,
	[usertype] [int] NULL,
	[updatedAt] [datetime] NULL,
	[flag] [char](10) NULL,
	[syncinfo] [char](10) NULL,
	[clientFrom] [char](10) NULL,
	[openid] [varchar](50) NULL,
	[registfrom] [varchar](50) NULL,
	[hasmobile] [int] NULL,
	[sysrights] varchar(1) NULL ,
	PRIMARY KEY ([id]) );
	
--用户权限表
	CREATE TABLE [dbo].[user_rights](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[info] [varchar](50) NULL,
	[starttime] [datetime] NULL,
	[endtime] [datetime] NULL,
	[created_at] [datetime] NULL,
	[modified_at] [datetime] NULL,
	PRIMARY KEY ([id]) );
	
--用户套餐表
CREATE TABLE [dbo].[package](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](100) NOT NULL,
	[status] [int] NOT NULL, --1、启用 2、暂停
	[description] [varchar](200) NULL,
	PRIMARY KEY ([id]) );
	INSERT INTO [dbo].[package]([name],[status],[description]) VALUES ('免费版',1,'免费版');
	INSERT INTO [dbo].[package]([name],[status],[description]) VALUES ('收费版',1,'收费版');
	
--文章类型表
  CREATE TABLE [dbo].[doctype](
	[id] [int] identity(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[description] [varchar](200) NULL,
	 PRIMARY KEY ([ID]) );
	INSERT INTO [dbo].[doctype]([name],[description]) VALUES ('网页','正常的网页HTML');
	INSERT INTO [dbo].[doctype]([name],[description]) VALUES ('PDF','PDF内容');
	INSERT INTO [dbo].[doctype]([name],[description]) VALUES ('视频','视频内容');
 
--文章栏目表
  CREATE TABLE [dbo].[doccolumn](
	[id] [int] identity(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[typeid] [int] NOT NULL,
	[showName] [varchar](100) NULL,
	[sort] [varchar](10) NULL,
	[packageid] [int] NULL,
	[acronym] [varchar](50) NULL,
	[description] [varchar](200) NULL,
	 PRIMARY KEY ([ID]) );
	 INSERT INTO [dbo].[doccolumn] ([name],[typeid],[description],[packageid],[acronym],[showName],[sort]) 
      VALUES ('弹窗情报免费版',1,'栏目-弹窗情报免费版',1,'DCQBMFB','弹窗情报-免费版','1');
     INSERT INTO [dbo].[doccolumn] ([name],[typeid],[description],[packageid],[acronym],[showName],[sort]) 
      VALUES ('弹窗情报收费版',1,'栏目-弹窗情报收费版',2,'DCQBSFB','弹窗情报-收费版','2');
      
--文章内容表
  CREATE TABLE [dbo].[doccontent](
	[id] [int] identity(1,1) NOT NULL,
	[columnid] [int] NOT NULL,
	[userid] [int] NOT NULL,
	[title] [varchar](100) NOT NULL,
	[summary] [varchar](400) NULL,
	[content] text NOT NULL,
	[docParentId] [int] NULL,
	[createtime] [datetime] NOT NULL,
	[ispublish] [varchar](1) NOT NULL,
	[shortTerm] [varchar](100) NULL,
	[mediumTerm] [varchar](100) NULL,
	[stockName_1] [varchar](50) NULL,
	[stockName_2] [varchar](50) NULL,
	[stockCode_1] [varchar](50) NULL,
	[stockCode_2] [varchar](50) NULL,
	[deductScore] [varchar](20) NULL,
	[isTop] [varchar](10) NULL,
	[photoPath] [varchar](256) NULL,
	[stubContent] [text] NULL,
	[longContent] [text] NULL,
	 PRIMARY KEY ([ID]) );
	 
	 
	
/*代理商、总部数据库统一；分别手机数据

HeadQuarter		总部库
[PrimeBroker]	代理商库
*/

USE [PrimeBroker]
GO

/*代理商信息表，这个主要总部统计需要
代理商的业务范围，国际期货、外汇、美股港股；
*/
DROP TABLE [dbo].[agentsc]
GO
CREATE TABLE [dbo].[agentsc](
	[agentzh] [varchar](32) NOT NULL,
	[sc] [int] NOT NULL,
	[marketcode] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
/*代理商信息表，这个主要总部统计需要
代理商的业务范围，国际期货、外汇、美股港股；
*/
DROP TABLE [dbo].[agentzh]
GO

CREATE TABLE [dbo].[agentzh](
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[name] [varchar](50) NULL,			/* 代理商详细名字 */
	[password] [varchar](32) NULL,		/* 密码 */
	[sex] [int] NULL,
	[mac] [varchar](32) NULL,			
	[phone] [varchar](20) NULL,
	[qq] [varchar](20) NULL,
	[starttime] [datetime] NULL,		/* 授权开始时间 */
	[endtime] [datetime] NULL,			/* 授权结束时间 */
	[mail] [varchar](32) NULL,
	[address] [varchar](255) NULL,
	[created_at] [datetime] NULL,		/* 创建时间 */
	[modified_at] [datetime] NULL,		/* 修改时间 */
	[softfee] [numeric](18, 3) NULL,	/* 软件使用费 按手数收取 */

 CONSTRAINT [PK_agentzh] PRIMARY KEY CLUSTERED 
(
	[agentzh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
--alter table [dbo].[agentzh] add softfee [numeric](18, 3);

/* 经纪人基础账号信息  */
DROP TABLE [dbo].[brokerzh]
GO
CREATE TABLE [dbo].[brokerzh](
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[brokerzh] [varchar](32) NOT NULL,
	[name] [varchar](50) NULL,
	[sex] [int] NULL,
	[phone] [varchar](20) NULL,
	[qq] [varchar](20) NULL,
	[mail] [varchar](32) NULL,
	[address] [varchar](255) NULL,
	[created_at] [datetime] NULL,		/* 创建时间 */
	[modified_at] [datetime] NULL,		/* 修改时间 */
 CONSTRAINT [PK_brokerzh] PRIMARY KEY CLUSTERED 
(
	[agentzh] ASC,
	[brokerzh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/*经纪人流水库： 每天统计一下，合并;
如果是微交易，这个数据要单独分别统计*/
DROP TABLE [dbo].[brokerls]
GO
CREATE TABLE [dbo].[brokerls](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,		/* 流水号 */
	[agentzh] [varchar](32) NOT NULL,					/* 所属代理商 */
	[brokerzh] [varchar](32) NOT NULL,					/* 经纪人账号 */
	[zjye] [money] NULL,								/* 对应lstime所在日期的总资金余额 */
	[kyzj] [money] NULL,								/* 可用资金，可以提现部分 */
	[djzj] [money] NULL,								/* 冻结资金，属于经纪人，但需要T+N日后提现 */
	[accrued] [money] NULL,								/* 给下级经纪人的提成总额 */
	[tjdate] [datetime],								/* 经纪人的流水*/
) ON [PRIMARY]

GO

/* 经纪人树型关系管理表 , 保存经纪人链表
   如果是全名经纪人，其他字段空
   */
DROP TABLE [dbo].[brokertree]
GO
CREATE TABLE [dbo].[brokertree](
	[agentzh] [varchar](32) NOT NULL,		/* 所属代理商 */
	[brokerzh] [varchar](32) NOT NULL,		/* 该经纪人账号 */
	[b1] [varchar](32) NULL,				/* 对应最上一层经纪人 */
	[b2] [varchar](32) NULL,				/* 对应第二层经纪人 */
	[b3] [varchar](32) NULL,
	[b4] [varchar](32) NULL,
	[uid] [varchar](64) NULL,				/* 特征码 */
 CONSTRAINT [PK_brokertree] PRIMARY KEY CLUSTERED 
(
	[agentzh] ASC,
	[brokerzh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/*市场信息设置 统一设置费率 需要单独打折的在subwtzh信息里面设置*/
/*缺省一个市场的手续费设置，优先以个别品种的手续费设置为准*/
DROP TABLE [dbo].[marketset]
GO
CREATE TABLE [dbo].[marketset](
	[sc] [int] NOT NULL,							/* 市场编码 */
	[marketcode] [varchar](32) NULL,				/* 市场代码 */
	[marketname] [varchar](50) NULL,				/* 市场名称 */
	[counterfee1] [numeric](18, 3) NOT NULL,			/* 市场缺省手续费1;按手数固定收取 */
    [counterfee2] [numeric](18, 3) NOT NULL,			/* 市场缺省手续费 2；按金额百分比收取*/
	[servicefee] [numeric](18, 3) NOT NULL,			/* 市场缺省服务费 */
	[gjwhgylx] [numeric](18, 3) NOT NULL,			/* 国际外汇，隔夜利息 */
	[bzj] [numeric](18, 3) NOT NULL,			/* 保证金 比例*/
 CONSTRAINT [PK_marketset] PRIMARY KEY CLUSTERED 
(
	[sc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

--手续费模板菜单
CREATE TABLE [dbo].[codefeeset_menu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](100) NOT NULL,
	[modifyTime] [datetime] NOT NULL,
	 PRIMARY KEY ([ID])); 

GO
/*具体某个品种的费率设置*/
DROP TABLE [dbo].[codefeeset]
GO
CREATE TABLE [dbo].[codefeeset](
	[sc] [int] NOT NULL,							/* 市场编码 */
	[code] [varchar](32) NOT NULL,					/* 品种代码 */
	[hydm] [varchar](32) NOT NULL,					/* 合约代码 */
	[counterfee1] [numeric](18, 3) NOT NULL,			/* 开仓手续费(按手数) */
    [counterfee2] [numeric](18, 3) NOT NULL,			/* 开仓手续费(按金额%)*/
    [pcfee1] [numeric](18, 3) NOT NULL,			/* 平仓手续费(按手数) */
    [pcfee2] [numeric](18, 3) NOT NULL,			/* 平仓手续费(按金额%)*/
	[servicefee] [numeric](18, 3) NOT NULL,			/* 市场缺省服务费 */
	[gjwhgylx] [numeric](18, 3) NOT NULL,			/* 国际外汇，隔夜利息 */
	[bzj] [numeric](18, 3) NOT NULL,			/* 保证金 比例*/
	[bz] [varchar](4) NULL,					/* 币种 */
	[parentId] [int] NULL,
 CONSTRAINT [PK_codefeeset] PRIMARY KEY CLUSTERED 
(
	[sc] ASC,
	[hydm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/*主账号信息*/
DROP TABLE [dbo].[mainzh]
GO
CREATE TABLE [dbo].[mainzh](
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[mainzh] [varchar](32) NOT NULL,
	[password] [varchar](32) NULL,
	[brokerage] [varchar](50) NOT NULL,			/* 经纪商名称 */
	[exchange] [varchar](32) NOT NULL,			/* 交易所名称 */
	[credit ] [varchar](32) NOT NULL,			/* 账号授信额度 */
	[amount] [money] NOT NULL,					/* 资金总额 */
	[kyzj] [money] NULL,						/* 可用资金 */
	[djzj] [money] NULL,						/* 冻结资金 */
	[cjrj] [money] NULL,						/* 出入金总额（明细单独建表） */
 CONSTRAINT [PK_mainzh] PRIMARY KEY CLUSTERED 
(
	[agentzh] ASC,
	[mainzh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/* 业务类别 */
DROP TABLE [dbo].[ywlb]
GO
CREATE TABLE [dbo].[ywlb] (
	[ywlb] [int] NOT NULL ,
	[ywmc] [varchar] (100) COLLATE Chinese_PRC_CI_AS NOT NULL
) ON [PRIMARY]
GO

/* 统一一个表，采用wt,不区分当日和历史 */
DROP TABLE [dbo].[mainwt]
GO
CREATE TABLE [dbo].[mainwt](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[mainzh] [varchar](32) NOT NULL,	/* 主账号 */
	[wtbh] [varchar](32) NOT NULL,		/* 委托编号 */
	[bz] [tinyint] NOT NULL,			/* 币种  */
	[sc] [tinyint] NOT NULL,			/* 市场编码  */
	[code] [varchar](20) NULL,			/* 市场内的品种代码  */
	[hydm] [varchar](20) NULL,			/* 市场内的合约代码  */
	[ywlb] [int] NOT NULL,				/* 业务类别：买卖开仓平仓等  */
	[xdzllx] [int] NOT NULL,			/* 下单指令类型：限价/市价  */
	[wtjg] [money] NULL,				/* 委托价格 */
	[wtsl] [int] NULL,					/* 委托数量 */
	[cjsl] [int] NULL,					/* 成交数量 */
	[cjje] [money] NULL,				/* 成交金额 */
	[cjjj] [money] NULL,				/* 成交价格 */
	[cdsl] [int] NULL,					/* 撤单数量 */
	[stopjg] [money] NULL,				/* 止损价 */
	[profitjg] [money] NULL,			/* 止盈价 */
	[bond]	[money] NULL,				/* 保证金 */
	[sxf]	[money] NULL,				/* 手续费 */
	[wttime] [datetime],				/* 委托时间 */
) ON [PRIMARY]

GO
/*主账号的当日成交流水,历史和当日合并一个表*/
DROP TABLE [dbo].[maincj]
GO
CREATE TABLE [dbo].[maincj](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[mainzh] [varchar](32) NOT NULL,	/* 主账号 */
	[wtbh] [varchar](32) NOT NULL,		/* 委托编号 */
	[cjbh] [varchar](32) NOT NULL,		/* 成交编号,可以多次成交 */
	[bz] [tinyint] NOT NULL,			/* 币种  */
	[sc] [tinyint] NOT NULL,			/* 市场编码  */
	[code] [varchar](20) NULL,			/* 市场内的品种代码  */
	[hydm] [varchar](20) NULL,			/* 市场内的合约代码  */
	[ywlb] [int] NOT NULL,				/* 业务类别：买卖开仓平仓等  */
	[xdzllx] [int] NOT NULL,				/* 下单指令类型：限价/市价  */
	[cjjg] [money] NOT NULL,			/* 买入卖出或者开平仓实际已经成交的价格 */
	[cjsl] [int] NOT NULL,				/* 实际成交的量，或者期货实际开仓平仓量 */
	[yj] [money] NULL,					/* 佣金 */
	[qtfy] [money] NULL,				/* 其他费用 */
	[cjtime] [datetime] NOT NULL,		/* 成交实际 */
	[cost] [money] NULL,				/* 成本价格 */
	/* 系统自动止损，主账号推送过来之后，通过委托编号（不扣保证金的挂单）
	可以再次修改止损，止盈；和成交编号对应；（是否所有的都可以改，带确认？） */
	[stopjg] [money] NULL,				/* 止损价 */
	[profitjg] [money] NULL,			/* 止盈价 */
	[bond]	[money] NULL,				/* 保证金 */
    [sxf]	[money] NULL,				/* 手续费 */
 ) ON [PRIMARY]

GO

/* 如果合并，就没办法提供止盈止损信息；分开就需要自行汇总 ;
持仓表，分开保存，并且保存成交编号，隔夜后成交编号;
持仓表维护：平仓按照编号查询，删除记录;
平仓指令的委托数量，不能超过改合约的所有持仓总和，否则报错“平仓数量不足，加数字提示”；
*/
DROP TABLE [dbo].[mainzqye]
GO
CREATE TABLE [dbo].[mainzqye](
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[mainzh] [varchar](32) NOT NULL,	/* 主账号 */
	[sc] [tinyint] NOT NULL,			/* 市场编码  */
	[code] [varchar](20) NULL,			/* 市场内的品种代码  */
	[hydm] [varchar](20) NULL,			/* 市场内的合约代码  */
	[zqsl] [int] NULL,					/* 持仓数量，证券数量 */
	[kysl] [int] NULL,					/* 可用数量，可能有Ｔ＋Ｎ冻结不能卖 */
	[djsl] [int] NULL,					/* Ｔ＋Ｎ冻结数量 */
	[cost] [float] NULL,				/* 成本价 */
	[lastpower] [datetime] NULL,			/* 上一次分红派息的时间 */
	[stopjg]  [money] NULL,				/* 止损价 */
	[profitjg] [money] NULL,			/* 止盈价 */
	[sxf]	[money] NULL,				/* 手续费 */
) ON [PRIMARY]

GO

DROP TABLE [dbo].[subzh]
GO
CREATE TABLE [dbo].[subzh](
	[subzh] [varchar](32) NOT NULL,
	[password] [varchar](40) NULL,
	[name] [varchar](50) NULL,
	[sex] [int] NULL,
	[phone] [varchar](20) NULL,
	[khdate] [datetime] NULL,
	[wtzh] [varchar](32) NOT NULL,
	[marginset] [varchar](32) NOT NULL,
	[feeset] [varchar](32) NOT NULL,
	[riskset] [varchar](32) NULL,
	[midman] [varchar](32) NULL,
	[openright] [int] NULL,
	[accounttype] [int] NULL,
	[brokerzh] [varchar](32) NULL,
	[isagent] [int] NULL,
	[qq] [varchar](20) NULL,
	[mail] [varchar](32) NULL,
	[address] [varchar](255) NULL,
	[initmoney] [money] NULL, /* 初始资金 */
	[debitmoney] [money] NULL, /* 借贷资金 */
	[blowup] [varchar](20) NULL, /*配资比例*/
	[bz] [varchar](4) NULL, /* 币种   1:USD 2:CNY 3:HKD */
 CONSTRAINT [PK_subzh] PRIMARY KEY CLUSTERED 
(
	[subzh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE dbo.subzh ADD groupid VARCHAR(1) NULL;
alter table dbo.subzh add headPicture varchar(256) NULL;/*头像*/
alter table dbo.subzh add loginname varchar(50) NULL;/*登陆名称*/
alter table dbo.subzh add notename varchar(50) NULL;/*备注姓名*/
alter table dbo.subzh add notetel varchar(20) NULL;/*备注电话*/
alter table dbo.subzh add risktype int NULL;  /*风控模式   0：每个账户单独风控   1：所有资金账户联合风控*/
alter table dbo.subzh add accountpattern int NULL;  /*账户模式   0:分账户 2：独立账户*/
alter table dbo.subzh add zijinaccount int NULL;  /*资金账户   1:在岸人民币账户 2：美元账户 3:港币账户 4:离岸人民币账户*/
alter table dbo.subzh add jypz int NULL;  	/*交易品种   1:沪深A股*/
alter table dbo.subzh add bdtd varchar(100) NULL; 	/*保单通道   报单账户或报单账户组*/
alter table dbo.subzh add bzj money NULL; 		/*今日卖出冻结      优后*/
alter table dbo.subzh add rzj money NULL; 		/*总资产*/
alter table dbo.subzh add yjx money NULL; 		/*预警线*/
alter table dbo.subzh add pcx money NULL; 		/*平仓线*/
alter table dbo.subzh add xzj money NULL; 		/*可用资金 (现金)*/
alter table dbo.subzh add ccbl int NULL;  		/*持仓比例  0：全局设置  1：单独设置*/
alter table dbo.subzh add isadmin int NULL;     /*是否管理员  1：是  其他：不是*/
alter table dbo.subzh add jyright varchar(32) null;     /*交易状态  1：禁止开仓   2：禁止平仓   3：禁止撤单*/

alter table dbo.subzh add riskstate int NULL;  /*风控状态  0：正常  1：预警  2：强平 3:冻结*/

ALTER TABLE dbo.subzh alter column agentzh varchar(32) null;
ALTER TABLE dbo.subzh alter column mainzh varchar(32) null;
ALTER TABLE dbo.subzh alter column wtzh varchar(32) null;
ALTER TABLE dbo.subzh alter column marginset varchar(32) null;
ALTER TABLE dbo.subzh alter column feeset varchar(32) null;

GO
DROP TABLE [dbo].[subwtzh]
GO
CREATE TABLE [dbo].[subwtzh](
	[subzh] [varchar](32) NOT NULL,
	[sc1] [int] NULL,
	[mainzh1] [varchar](32) NULL,
	[sc2] [int] NULL,
	[mainzh2] [varchar](32) NULL,
	[sc3] [int] NULL,
	[mainzh3] [varchar](32) NULL,
	[sc4] [int] NULL,
	[mainzh4] [varchar](32) NULL,
 CONSTRAINT [PK_subwtzh] PRIMARY KEY CLUSTERED 
(
	[subzh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/* 流水号和主账号的每笔流水号对应;
对应下单主账号有单独表*/
DROP TABLE [dbo].[subwt]
GO
CREATE TABLE [dbo].[subwt](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[subzh] [varchar](32) NOT NULL,		/* 子账号 */
	[wtbh] [varchar](32) NOT NULL,		/* 子账号委托编号（如果模拟自营盘，就没有主账号委托编号） */
	[mainwtbh] [varchar] (32) NOT NULL,	/* 实际对应的主账号委托编号*/
	[bz] [tinyint] NOT NULL,			/* 币种  */
	[sc] [tinyint] NOT NULL,			/* 市场编码  */
	[code] [varchar](20) NULL,			/* 市场内的品种代码  */
	[hydm] [varchar](20) NULL,			/* 市场内的合约代码  */
	[ywlb] [int] NOT NULL,				/* 业务类别：买卖开仓平仓等  */
	[xdzllx] [int] NOT NULL,			/* 下单指令类型：限价/市价  */
	[wtjg] [money] NULL,				/* 委托价格 */
	[wtsl] [int] NULL,					/* 委托数量 */
	[cjsl] [int] NULL,					/* 成交数量 */
	[cjje] [money] NULL,				/* 成交金额 */
	[cjjj] [money] NULL,				/* 成交价格 */
	[cdsl] [int] NULL,					/* 撤单数量 */
	[stopjg] [money] NULL,				/* 止损价 */
	[profitjg] [money] NULL,			/* 止盈价 */
	[bond]	[money] NULL,				/* 保证金 */
	[sxf]	[money] NULL,				/* 手续费 */
	[wttime] [datetime],				/* 委托时间 */
) ON [PRIMARY]

GO
/*  子账户成交表    主账号的当日成交流水,历史和当日合并一个表*/
DROP TABLE [dbo].[subcj]
GO
CREATE TABLE [dbo].[subcj](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[subzh] [varchar](32) NOT NULL,		/* 子账号 */
	[wtbh] [varchar](32) NOT NULL,		/* 委托编号 */
	[cjbh] [varchar](32) NOT NULL,		/* 成交编号,可以多次成交 */
	[mainwtbh] [varchar] (32) NOT NULL,	/* 实际对应的主账号委托编号*/
	[maincjbh] [varchar] (32) NOT NULL,	/* 成交编号,可以多次成交 */
	[bz] [tinyint] NOT NULL,			/* 币种  */
	[sc] [tinyint] NOT NULL,			/* 市场编码  */
	[code] [varchar](20) NULL,			/* 市场内的品种代码  */
	[hydm] [varchar](20) NULL,			/* 市场内的合约代码  */
	[ywlb] [int] NOT NULL,				/* 业务类别：买卖开仓平仓等  */
	[xdzllx] [int] NOT NULL,				/* 下单指令类型：限价/市价  */
	[cjjg] [money] NOT NULL,			/* 买入卖出或者开平仓实际已经成交的价格 */
	[cjsl] [int] NOT NULL,				/* 实际成交的量，或者期货实际开仓平仓量 */
	[yj] [money] NULL,					/* 佣金 */
	[qtfy] [money] NULL,				/* 其他费用 */
	[cjtime] [datetime] NOT NULL,		/* 成交实际 */
	[cost] [money] NULL,				/* 成本价格 */
	/* 系统自动止损，主账号推送过来之后，通过委托编号（不扣保证金的挂单）
	可以再次修改止损，止盈；和成交编号对应；（是否所有的都可以改，带确认？） */
	[stopjg] [money] NULL,				/* 止损价 */
	[profitjg] [money] NULL,			/* 止盈价 */
	[bond]	[money] NULL,				/* 保证金 */
    [sxf]	[money] NULL,				/* 手续费 */
 ) ON [PRIMARY]

GO

/*  子账户证券余额即持仓表    如果合并，就没办法提供止盈止损信息；分开就需要自行汇总 ;
持仓表，分开保存，并且保存成交编号，隔夜后成交编号;
持仓表维护：平仓按照编号查询，删除记录;
平仓指令的委托数量，不能超过改合约的所有持仓总和，否则报错“平仓数量不足，加数字提示”；
*/
DROP TABLE [dbo].[subzqye]
GO
CREATE TABLE [dbo].[subzqye](
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[subzh] [varchar](32) NOT NULL,		/* 主账号 */
	[sc] [tinyint] NOT NULL,			/* 市场编码  */
	[code] [varchar](20) NULL,			/* 市场内的品种代码  */
	[hydm] [varchar](20) NULL,			/* 市场内的合约代码  */
	[zqsl] [int] NULL,					/* 持仓数量，证券数量 */
	[kysl] [int] NULL,					/* 可用数量，可能有Ｔ＋Ｎ冻结不能卖 */
	[djsl] [int] NULL,					/* Ｔ＋Ｎ冻结数量 */
	[cost] [float] NULL,				/* 成本价 */
	[lastpower] [datetime] NULL,			/* 上一次分红派息的时间 */
	[stopjg]  [money] NULL,				/* 止损价 */
	[profitjg] [money] NULL,			/* 止盈价 */
	[sxf]	[money] NULL,				/* 手续费 */
) ON [PRIMARY]

GO

/*子账号出入金日志*/
DROP TABLE [dbo].[subzhfund_log]
GO
CREATE TABLE [dbo].[subzhfund_log](
	[id] [int] IDENTITY(1,1) NOT NULL,          /* 主键 */
	[subzh] [varchar](32) NOT NULL,             /* 子账户 */
	[name] [varchar](50) NULL,                  /* 子账户名称  冗余字段 */
	[type] [varchar](1) NOT NULL,				/* 类型   1：入金   2：出金 */
	[bz] [tinyint] NOT NULL,					/* 币种   1:USD 2:RMB 3:HKD */
	[fund] [money] NULL,						/* 优先资金*/
	[description] [text] NULL,                  /* 描述 */
	[status] [tinyint] NULL,					/* 状态  0:失败 1:成功 */
	[modifytime] [datetime] NULL,               /* 更新时间 */
	 PRIMARY KEY ([ID]) );
   alter table [dbo].[subzhfund_log] ADD afterfund [money] NULL     /*新增劣后资金*/  
	 
/* 汇率表 */
DROP TABLE [dbo].[fund_rate]
CREATE TABLE [dbo].[fund_rate](
	[id] [int] IDENTITY(1,1) NOT NULL,          /* 主键 */
	[rmb] [decimal](5, 2) NULL,                 /* 人民币 */
	[dollar] [decimal](5, 2) NULL,              /* 美元 */
	[hkd] [decimal](5, 2) NULL,  			    /* 港元 */
	[euro] [decimal](5, 2) NULL,                /* 欧元 */
	[jpy] [decimal](5, 2) NULL,  				/* 日元 */
	[pound] [decimal](5, 2) NULL,               /* 英镑 */
	[description] [varchar](100) NULL,          /* 描述 */
	[modifytime] [datetime] NULL,               /* 更新时间 */
	 PRIMARY KEY ([ID]) );
	 
/*主账号净值*/
DROP TABLE [dbo].[mainzhvalue]
CREATE TABLE [dbo].[mainzhvalue](
	[id] [int] IDENTITY(1,1) NOT NULL,          /* 主键 */
	[mainzh] [varchar](32) NOT NULL,			/* 主账户 */
	[workday] [varchar](20) NOT NULL,			/* 交易日 */
	[total_balance] [money] NULL,				/* 资产总额 */
	[balance_value] [money] NULL,				/* 资产净值 */
	[num_value] [money] NULL,					/* 份额净值 */
	[initmoney] [money] NULL,					/* 期初投入 */
	[managecost] [money] NULL,					/* 管理费 */
	[trusteefee] [money] NULL,					/* 托管费 */
	[servicecharge] [money] NULL,				/* 应提费用 */
	 PRIMARY KEY ([ID]) );

CREATE TABLE [dbo].[riskmanage](
	[userno] [VARCHAR](20) NOT NULL,
	[usertype] [VARCHAR](20) NULL,
	[zhms] [VARCHAR](20) NULL,
	[bz] [TINYINT] NOT NULL,
	[bdzh] [VARCHAR](20) NOT NULL,
	[kyzj] [MONEY] NULL,
	[zjye] [MONEY] NULL,
	[djzj] [MONEY] NULL,
	[xzzj] [MONEY] NULL,
	[rzje] [MONEY] NULL,
	[bzj] [MONEY] NULL,
	[zzc] [MONEY] NULL,
	[yjx] [VARCHAR](20) NULL,
	[pcx] [VARCHAR](20) NULL,
	[cksz] [MONEY] NULL,
	[islogin] [TINYINT] NULL,
	[loginzt] [TINYINT] NULL,
PRIMARY KEY CLUSTERED 
(
	[userno] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[notice](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](100) NOT NULL,
	[type] [varchar](1) NOT NULL,
	[pubtime] [datetime] NOT NULL,
	[pubuser] [varchar](20) NOT NULL,
	[recever] [varchar](100) NOT NULL,
	[summary] [varchar](500) NOT NULL,
	[content] text NULL,
	PRIMARY KEY (id)
)

CREATE TABLE [dbo].[risk_role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[account] [varchar](100) NOT NULL,
	[type] [varchar](1) NOT NULL,
	[risk_type] [varchar](1) NOT NULL,
	[suitable_kind] [varchar](10) NOT NULL,
	[risk_param] [varchar](100) NOT NULL,
	[risk_description] [varchar](500) NOT NULL,
	PRIMARY KEY (id)
)

--风控日志表
CREATE TABLE risk_log(
      [id] [INT] IDENTITY(1, 1) NOT NULL ,
      [warnno] [VARCHAR](100) NOT NULL ,/*预警编号*/
      [userno] [VARCHAR](20) NOT NULL ,/*用户编号*/
      [user_type] [VARCHAR](1) NOT NULL ,/*用户类型*/
      [declaration_account] [VARCHAR](10) NOT NULL ,/*报单账户*/
      [warn_type] [VARCHAR](10) NOT NULL ,/*预警类型*/
      [warn_detail] [VARCHAR](200) NOT NULL ,/*预警明细*/
      [warn_time] [DATETIME] NOT NULL ,/*时间*/
      PRIMARY KEY ( id )
    );
    
/*强平记录*/
CREATE TABLE Liquidate_log(
      [id] [INT] IDENTITY(1, 1) NOT NULL ,
      [sub_account] [VARCHAR](20) NOT NULL ,/*子账号*/
      [main_account] [VARCHAR](20) NOT NULL ,/*主账号*/
      [broker] [VARCHAR](20) NOT NULL ,/*经纪商*/
      [bourse] [VARCHAR](20) NOT NULL ,/*交易所*/
      [contract_type] [VARCHAR](10) NOT NULL ,/*合约品种*/
      [contractno] [VARCHAR](10) NOT NULL ,/*合约代码*/
      [direction] VARCHAR(1) NOT NULL ,/*方向*/
      [volume] VARCHAR(10) NOT NULL , /*成交量*/
      [deal_price] MONEY NOT NULL ,/*成交价*/
      [deal_time] DATETIME NOT NULL ,/*成交时间*/
      [deal_no] VARCHAR(20) NOT NULL ,/*成交编号*/
      [fee] MONEY NULL ,/*手续费*/
      [service_charge] MONEY NULL ,/*服务费*/
      [type] VARCHAR(1) NOT NULL ,/*类型*/
      PRIMARY KEY ( id )
    );

--保证金模板菜单
CREATE TABLE [dbo].[bzjmb_menu](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](100) NOT NULL,
	[modifyTime] [datetime] NOT NULL,
	 PRIMARY KEY ([ID])); 

   /*保证金模版*/
CREATE TABLE [dbo].[bzjmb](
	[sc] [int] NOT NULL,							/* 市场编码 */
	[bzjdm] [varchar](32) NOT NULL,					/* 合约代码 */-----
	[bzjname] [varchar](32) NOT NULL,				/* 合约名称 */----
	[bbbz] [numeric](18, 3) NULL,				/*本币比重*/
	[tjdtbzj1] [numeric](18, 3) NOT NULL,			/* 投机多头保证金(按手数) */
    [tjdtbzj2] [numeric](18, 3) NOT NULL,			/* 投机多头保证金率(按金额,百分之) */
	[tjktbzj1] [numeric](18, 3) NOT NULL,			/* 投机空头保证金(按手数)*/
    [tjktbzj2] [numeric](18, 3) NOT NULL,			/* 投机空头保证金率(按金额,百分之) */
	[tldtbzj1] [numeric](18, 3) NULL,			/* 套利多头保证金(按手数) */
    [tldtbzj2] [numeric](18, 3) NULL,			/* 套利多头保证金率(按金额,百分之)*/
	[tlktbzj1] [numeric](18, 3) NULL,			/* 套利空头保证金(按手数)*/
    [tlktbzj2] [numeric](18, 3) NULL,			/* 套利空头保证金率(按金额,百分之) */
	[sqfs] [int] NOT NULL,					/*收取方式  1:绝对  2:相对*/
	[month] [int] NOT NULL, 				/*应用到该品种所有月份*/	
	[parentId] [int] NULL,
 CONSTRAINT [PK_bzjmb] PRIMARY KEY CLUSTERED 
(
	[sc] ASC,
	[bzjdm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
    
    
/*     ====hqw add===== ============================================================================start   */   
DROP TABLE [dbo].[operater]
GO
/*     ====操作员=====    */  
CREATE TABLE [dbo].[operater](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,	
	[code] [varchar](20) NULL,			
	[name] [varchar](30) NULL,		
	[roleid] [int] NULL,			
	[password]  [varchar](30) NULL,
	[mobilephone] [varchar] (20) NULL,
	[createtime] [datetime] NULL
) ON [PRIMARY]

GO
DROP TABLE [dbo].[role]
GO
/*     ====角色=====    */  
CREATE TABLE [dbo].[role](
	[lsh] [numeric](11, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](30) NULL
) ON [PRIMARY]

GO
DROP TABLE [dbo].[rolemenu]
GO
/*     ====角色和菜单的关联中间表=====    */  
CREATE TABLE [dbo].[rolemenu](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[roleid] [int] NOT NULL,
	[menuid] [int] NOT NULL,
	[menucode] [varchar](30) NULL
) ON [PRIMARY]

GO
DROP TABLE [dbo].[menu]
GO
/*     ====菜单表=====    */  
CREATE TABLE [dbo].[menu](
	[lsh] [numeric](11, 0) IDENTITY(1,1) NOT NULL,
	[name] [varchar](32) NOT NULL,	
	[url] [varchar](100) NOT NULL,		
	[parentid] [numeric](11,0) NOT NULL,
	[leaf] [varchar](20) NULL,			
	[isleaf] [varchar](20) NULL,
	[code] [varchar](20) NULL		
) ON [PRIMARY]
GO
alter table [dbo].[menu] add permission varchar(20);

/*     ====操作员与子账号 客户的关联中间表=====    */  
CREATE TABLE [dbo].[operatersubzh](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[operatorid] [numeric](18, 0) NOT NULL,
	[subzhid] [varchar](32) NOT NULL,
	[cookie] [varchar](32) NOT NULL
) ON [PRIMARY]

GO
/*     收费模板 与主账号中间表  */ 
CREATE TABLE [dbo].[mainzhfatemplate](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[schemeid] [numeric](18, 0) NOT NULL,
	[mainzh] [varchar](32) NOT NULL,
	[agentzh] [varchar](32) NOT NULL
) ON [PRIMARY]
	GO
	/*     收费模板  */   
CREATE TABLE [dbo].[schemetemplate](
	[lsh] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[schemename] [varchar](50) NOT NULL,
	[schemeType] int NOT NULL,
	[bz] int not null,
	[brokeryj] [money] NULL,
	[securityfy] [money] NULL,
	[exchangefy] [money] NULL,
	[overnigthfy] [money] NULL,
	[brokerStatus] int NULL,
	[securityStatus] int NULL,
	[exchangeStatus] int NULL,
	[overnightStatus] int NULL
) ON [PRIMARY]

/*     ====hqw add===== ======================================================================= end  */   

/*add by zhangyang 2017-06-23*/
--合约表
CREATE TABLE [dbo].[risk_contract]
(
    contract_code VARCHAR(20) NOT NULL, /*合约代码*/
	variety_code VARCHAR(20) NOT NULL, /*品种代码*/
	contract_name VARCHAR(60) NOT NULL, /*合约名称*/
	minchangeprice MONEY NOT NULL, /*最小变动价位*/
	public_day DATE NOT NULL,/*上市日*/
	prompt_day DATE NOT NULL,/*交割日*/
	exchange_name VARCHAR(20) NOT NULL, /*交易所名称*/
	PRIMARY KEY (contract_code)
)

alter table [dbo].[risk_contract] alter column minchangeprice [numeric](20, 10) NULL;	/* 最小变动价位 */

--品种表
CREATE TABLE [dbo].[risk_variety]
(
	variety_code VARCHAR(20) NOT NULL,/*品种代码*/
	variety_name VARBINARY(20) NOT NULL,/*品种名称*/
	exchange_name VARCHAR(20) NOT NULL, /*交易所名称*/
	contract_multiplier INT NOT NULL,/*合约乘数*/
	minchangeprice MONEY NOT NULL, /*最小变动价位*/
	variety_type VARCHAR(1) NOT NULL,/*品种类型*/
	currency VARCHAR(1) NOT NULL,/*币种类型*/
	PRIMARY KEY (variety_code)
)

--投顾分组关系表   分组为主体  1:n
CREATE TABLE [dbo].[mainzhgrouprel](
	[id] [int] identity(1,1) NOT NULL,
	[groupId] [int] NOT NULL,
	[groupName] [varchar](20) NULL,
	[mainzh] [varchar](32) NOT NULL,
	[modifyTime] [datetime] NULL,
	 PRIMARY KEY ([ID]));
	 
--风控模板菜单
CREATE TABLE [dbo].[risk_template_menu](
	[id] [int] IDENTITY(1,1) NOT NULL,/*主键  自增*/
	[title] [varchar](100) NOT NULL,/*模板名称*/
	[type] [varchar](1) NULL,/*类型  1:白名单  2:黑名单  3:持仓比例 其他:其他*/
	[userid] [numeric](18, 0) NULL,/*创建人*/
	[agentzh] [varchar](32) NULL,/*代理商*/
	[modifyTime] [datetime] NOT NULL,/*更新时间*/
	 PRIMARY KEY ([ID])); 
	
--风控模板
CREATE TABLE [dbo].[risk_template](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[description] [varchar](128) NULL,    /* 名称 */
	[condition] [varchar](1024) NOT NULL, /* 触发条件-风控条件 */
	[operation] [int] NOT NULL,           /* 执行动作 */
	[operation_condition] [varchar](1024) NULL, /* 动作执行条件*/
	[operation_param] [varchar](1024) NULL,/* 动作执行参数 */
	[parentId] [int] NOT NULL,            /* 模板菜单ID*/
	[operation_desc] [varchar](1024) NULL,/* 备注 */
	[code] [varchar](20) NULL,			  /* 品种代码-适用品种  */
	[riskType] [int] DEFAULT 1,            /* 类型*/
	[notify] [varchar](20) NULL,		  /* 通知操作*/
	 PRIMARY KEY ([ID]));

alter table [dbo].[risk_template] add code [varchar](20) NULL;
alter table [dbo].[risk_template] add operation_desc [varchar](1024) NULL;
alter table [dbo].[risk_template] add riskType [int] DEFAULT 1;
alter table [dbo].[risk_template] add notify [int] null;

--结算单
CREATE TABLE [dbo].[settle_info](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Creation_Date] [int] NOT NULL,
	[user_id] [varchar](32) NOT NULL,
	[bz] [char](3) NOT NULL,
	[balance] [money] NOT NULL,
	[in_out_balance] [money] NOT NULL,
	[fund_avail] [money] NOT NULL,
	[margin_occupied] [money] NOT NULL,
	[commission] [money] NULL,
	[realized] [money] NULL,
	[MTM] [money] NULL,
	[risk_degree] [float] NOT NULL,
 	PRIMARY KEY ([ID]));
 	
--子账户结算持仓表
CREATE TABLE [dbo].[subzh_holder](
	[holder_date] [int] NULL,
	[user_id] [varchar](32) NULL,
	[market] [tinyint] NOT NULL,
	[code] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
	[open_date] [int] NULL,
	[hedge_type] [tinyint] NULL,
	[bs_type] [tinyint] NULL,
	[vol] [int] NULL,
	[open_price] [float] NULL,
	[settle_price] [float] NULL,
	[prev_settle] [float] NULL,
	[profit] [money] NULL,
	[mairgin] [money] NULL
);

--操作日志表
  CREATE TABLE [dbo].[operationlog](
	[id] [int] IDENTITY(1,1) NOT NULL,/*主键id*/
	[username] [varchar](30) NULL,
	[menuName] [nvarchar](40) NULL,
	[menuUrl] [varchar](256) NULL,
	[userip] [varchar](20) NULL,
	[operationtime] [datetime] NOT NULL,
	PRIMARY KEY ([id]) ); 
	alter table [dbo].[operationlog] add log [varchar](256) NULL;
	
--子账户结算持仓表
  CREATE TABLE [dbo].[subzh_holder](
    [id] [int] IDENTITY(1,1) NOT NULL,
	[holder_date] [int] NULL,
	[user_id] [varchar](32) NULL,
	[market] [tinyint] NOT NULL,
	[code] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
	[open_date] [int] NULL,
	[hedge_type] [tinyint] NULL,
	[bs_type] [tinyint] NULL,
	[vol] [int] NULL,
	[open_price] [float] NULL,
	[settle_price] [float] NULL,
	[prev_settle] [float] NULL,
	[profit] [money] NULL,
	[mairgin] [money] NULL,
	PRIMARY KEY ([id]) );
	
-------------------------------------新增字段------------------------------
alter table [dbo].[subzh] add bz [varchar](4) NULL;
alter table [dbo].[risk_contract] add contractdetail [numeric](10, 3) NULL;
alter table [dbo].[risk_template] add code [varchar](20) NULL;
alter table [dbo].[risk_template] add operation_desc [varchar](1024) NULL;
alter table [dbo].[risk_template] add riskType [int] NULL;

alter table [dbo].[agentzh] add [softfeeMoney] [numeric](18, 3) NULL;	/* 软件使用费 按金额收取 */

--代理商日常费用统计表
CREATE TABLE [dbo].[agentfee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[agentzh] [varchar](32) NOT NULL,	/* 代理商详细信息表-代理商账号 */
	[name] [varchar](50) NULL,			/* 代理商详细名字 */
	[time] [datetime] NULL,		        /* 数据统计日期 */
	[buy_tick] [numeric](18, 3) NULL,	/* 当日买入总手数 */
	[buy_amount] [numeric](18, 3) NULL,	/* 当日买入总金额 */
	[sell_tick] [numeric](18, 3) NULL,	/* 当日卖出总手数 */
	[sell_amount] [numeric](18, 3) NULL,/* 当日卖出总金额 */
	[fee] [numeric](18, 3) NULL,	    /* 当日总费用 */
	PRIMARY KEY ([id]) );
	
alter table [dbo].[agentzh] add [status] int NULL;	/* 状态 */
alter table [dbo].[agentzh] add [total] [numeric](18, 3) NULL;	/* 总金额 */

alter table [dbo].[agentzh] add [used] [numeric](18, 3) NULL;	/* 已使用金额 */


USE [PrimeBroker]
GO
alter table [dbo].[role] add [type] int NULL;	/* 在角色表中加一个表示角色的类型 */
alter table [dbo].[subzh] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[mainzh] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[agentzh] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[brokerzh] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[bzjmb] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[codefeeset] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[notice] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[marketset] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[operater] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[risk_contract] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[risk_log] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[risk_rule] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[risk_template] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[risk_variety] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[riskmanage] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[schemetemplate] add [userid] [numeric](18, 0) NULL;   /* 加一个表示创建人 */
alter table [dbo].[risk_template_menu] add [userid] [numeric](18, 0) NULL;   /* 风控模板 加一个表示创建人 */
alter table [dbo].[codefeeset_menu] add [userid] [numeric](18, 0) NULL; /* 手续费模板 加一个表示创建人 */
alter table [dbo].[bzjmb_menu] add [userid] [numeric](18, 0) NULL; /* 保证金模板 加一个表示创建人 */
alter table [dbo].[subzhfund_log] add [userid] [numeric](18, 0) NULL; /* 出入金对象 加一个表示创建人 */
alter table [dbo].[mainzhgrouprel] add [userid] [numeric](18, 0) NULL; /* 投顾分组 加一个表示创建人 */
alter table [dbo].[settle_info] add [userid] [numeric](18, 0) NULL; /* 结算单信息 加一个表示创建人 */
alter table [dbo].[subzh_holder] add [userid] [numeric](18, 0) NULL; /* 子账户结算持仓表 加一个表示创建人 */
alter table [dbo].[subcj] add [userid] [numeric](18, 0) NULL; 
alter table [dbo].[subwt] add [userid] [numeric](18, 0) NULL; 
alter table [dbo].[except_order] add [userid] [numeric](18, 0) NULL;
alter table [dbo].[role] add [userid] [numeric](18, 0) NULL;




---alter table [dbo].[subzh] add [agentzh] [varchar](32) NOT NULL;   /* 加一个表示代理商 */
---###alter table [dbo].[mainzh] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
---alter table [dbo].[agentzh] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
---alter table [dbo].[brokerzh] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商    subcj  subwt*/
alter table [dbo].[bzjmb] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[codefeeset] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商*/
alter table [dbo].[notice] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[marketset] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[operater] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[risk_contract] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[risk_log] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[risk_rule] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[risk_template] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[risk_variety] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[riskmanage] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[schemetemplate] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[risk_template_menu] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
alter table [dbo].[codefeeset_menu] add [agentzh] [varchar](32) NULL;
alter table [dbo].[bzjmb_menu] add [agentzh] [varchar](32) NULL;
alter table [dbo].[subzhfund_log] add [agentzh] [varchar](32) NULL;
alter table [dbo].[mainzhgrouprel] add [agentzh] [varchar](32) NULL;
alter table [dbo].[settle_info] add [agentzh] [varchar](32) NULL;    /* 结算单信息 加一个表示代理商 */
alter table [dbo].[subzh_holder] add [agentzh] [varchar](32) NULL;    /* 子账户结算持仓表 加一个表示代理商 */
alter table [dbo].[except_order] add [agentzh] [varchar](32) NULL;
alter table [dbo].[role] add [agentzh] [varchar](32) NULL;

 
 

alter table [dbo].[agentzh] add [used] [numeric](18, 3) NULL;	/* 已使用金额 */

CREATE TABLE [dbo].[agentzhfund_log](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[subzh] [varchar](32) NOT NULL,
	[name] [varchar](50) NULL,
	[type] [varchar](1) NOT NULL,
	[bz] [tinyint] NOT NULL,
	[fund] [money] NULL,
	[description] [text] NULL,
	[modifytime] [datetime] NULL,
	[status] [tinyint] NULL,
	[afterfund] [money] NULL,
	PRIMARY KEY ([id]) );
	
--添加主键
alter table [dbo].[bzjmb] add id [int] IDENTITY(1,1) NOT NULL;
alter table [dbo].[codefeeset] add id [int] IDENTITY(1,1) NOT NULL;
--添加代理商上下级关系
alter table [dbo].[agentzh] add parentagentzh [varchar](32) NULL; /* 上级代理商账户  */

--出入金柜台入库失败原因
alter table [dbo].[subzhfund_log] add reason varchar(128) NULL;

alter table [dbo].[risk_contract] alter column minchangeprice [numeric](20, 10) NULL;	/* 最小变动价位 */

--修改猛士正式数据库字段类型：
alter table [dbo].[codefeeset] alter column counterfee2 [numeric](18, 6) NULL;	/* 开仓手续费(按金额%) */
alter table [dbo].[codefeeset] alter column pcfee2 [numeric](18, 6) NULL;	/* 平仓手续费(按金额%) */

--新增字段 风控规则
alter table [dbo].[risk_template] add data varchar(1024) NULL;	

--系统协议表
CREATE TABLE [dbo].[system_protocol](
	[proid] [int] IDENTITY(1,1) NOT NULL,/*主键id*/
	[name] [varchar](50) NOT NULL,/*协议名称*/
	[description] [varchar](MAX) NOT NULL, /*内容*/
	[state] [varchar](1) NOT NULL, /*状态 0：停用 1：启动*/
	PRIMARY KEY ([proid]) );
	
--系统基本信息表
CREATE TABLE [dbo].[system_basic](
	[bid] [int] IDENTITY(1,1) NOT NULL,/*主键id*/
	[managesysplan] [varchar](50) NULL,/*管理系统方案*/
	[managesysname] [varchar](50) NULL, /*管理系统名称*/
	[tradsysname] [varchar](50) NULL, /*交易系统名称*/
	[tradsyslogo] [varchar](50) NULL, /*交易系统logo*/
	[telephone] [varchar](15) NULL, /*客服电话*/
	[QQ] [varchar](15) NULL, /*客服QQ*/
	[tradsysslogan] [varchar](100) NULL, /*交易系统口号*/
	PRIMARY KEY ([bid]) );
	
	drop table [dbo].[fund_information];
--资金信息表
	CREATE TABLE [dbo].[fund_information](
	[foundid] [int] IDENTITY(1,1) NOT NULL,/*主键id*/
	[skbank] [varchar](50) NOT NULL,/*收款方银行 1:银行卡  2：支付宝 3：微信*/
	[zdcz] [varchar](1) NULL,/*自动充值 0：否  1：是*/
	[zfbloginpass] [varchar](50) NULL, /*支付宝登陆密码*/
	[skname] [varchar](50) NULL, /*收款方名称*/
	[skaccount] [varchar](50) NULL, /*收款方账户*/
	[skkhbank] [varchar](100) NULL, /*收款方开户银行（SWIFT代码）*/
	[skaddress] [varchar](250) NULL, /*收款方地址*/
	[type] [varchar](1) NULL, /*状态 0：不使用  1：使用*/
	[zfbewm] [varchar](50) NULL, /*支付宝二维码*/
	[zkl] [varchar](1) NULL, /*吱口令 0：启用  1：不启用*/
	[zklpass] [varchar](50) NULL, /*吱口令*/
	PRIMARY KEY ([foundid]) );
	
--app文件表
  CREATE TABLE [dbo].[app_file](
	[lsh] [int] IDENTITY(1,1) NOT NULL,
	[filename] [varchar](50) NULL,/*文件名含扩展名*/
	[filepath] [varchar](100) NOT NULL,/*文件路径*/
	[versionName] [varchar](100) NULL,/*版本名称*/
	[versionCode] [int] NOT NULL,/*版本号*/
	[introduce] [varchar](500) NULL,/*版本说明*/
	[filetype] [tinyint] NOT NULL,/*app类型，0安卓，1ios*/
	[createtime] [date] NOT NULL,/*上传时间*/
	PRIMARY KEY ([lsh]) );
	
---收费方案
CREATE TABLE [dbo].[fee_scheme](
	[lsh] [int] IDENTITY(1,1) NOT NULL,
	[schemeType] [tinyint] NOT NULL,/*收费方案类型,1经纪商交易佣金,2印花税,3过户费*/
	[direction] [varchar](5) NULL,/*收费方向 1卖，0买*/
	[percentage] [money](10,4) NULL,/*收费比例*/
	[lowfee] [money](10,4) NULL,/*最低收费*/
	[schemeName] [varchar](100) NOT NULL,/*方案名称*/
	[showStatus] [tinyint] NULL,/*显示状态，1显示，0不显示*/
	[feeSchemeId] [int] NOT NULL,/*显示状态，1显示，0不显示*/
	PRIMARY KEY ([lsh]) );
CREATE TABLE [dbo].[feescheme](
	[lsh] [int] IDENTITY(1,1) NOT NULL,
	[schemeName] [varchar](100) NOT NULL,/*方案名称*/
	PRIMARY KEY ([lsh]) );
	
CREATE TABLE [dbo].[exception_order_set](
	[lsh] [int] IDENTITY(1,1) NOT NULL,
	[exsetType] [tinyint] NULL,
	[dotype] [tinyint] NULL,
	[minustime] [int] NOT NULL,
	[createtime] [date] NOT NULL,
	PRIMARY KEY ([lsh]) );
	
---管理记录表
  CREATE TABLE [dbo].[manage_log](
	[mlid] [int] IDENTITY(1,1) NOT NULL,/*主键id*/
	[adminname] [varchar](50) NOT NULL,/*管理员账户*/
	[createtime] [date] NOT NULL,/*操作时间*/
	[ip] [varchar] (20) NULL,/*操作ip*/
	[log] [varchar] (200) NULL,/*操作记录*/
	PRIMARY KEY ([mlid]) );
	
alter table [dbo].[risk_template_menu] add type [varchar](1) NULL;	
--风控全局设置
CREATE TABLE [dbo].[risk_tempall](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[newstock] [int] NULL,/* 沪深A股新股发行  0：不禁买  1：禁买*/
	[newstock_day] [int] NULL,/* 沪深A股新股发行 禁买自然日设置*/
	[rubbishstock] [int] NULL,/* S、ST、*ST、S*ST、SST 0：不禁买  1：禁买*/
	[businessplate] [int] NULL,/* 创业板 0：不禁买  1：禁买*/
	[modifytime] [datetime] NULL,/* 更新时间 */
	PRIMARY KEY ([id]));

--风控模板类型  1:白名单  2:黑名单
alter table [dbo].[risk_tempall] add type [varchar](1) NULL;
alter table [dbo].[risk_tempall] add [agentzh] [varchar](32) NULL;   /* 加一个表示代理商 */
--个股设置规则
CREATE TABLE [dbo].[risk_stock](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[parentId] [int] NOT NULL,/* 模板ID 对应风控全局设置risk_tempall表*/
	[stockcode] [varchar](20) NULL,/* 股票代码  */
	[stockname] [varchar](50) NULL,/* 股票名称 */
	 PRIMARY KEY ([ID]));
	 
--持仓比例控制
CREATE TABLE [dbo].[risk_holder](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[parentId] [int] NOT NULL,/* 模板ID 对应风控模板菜单risk_template_menu表*/
	[fundStart] [numeric](18, 3) NULL,/* 资产范围 起始金额  */
	[fundEnd] [numeric](18, 3) NULL,/* 资产范围 终止金额  */
	[controlType] [varchar](1) NOT NULL,/* 控制规则  0：个股 1：板块  */
	[plateType] [int] NULL,/* 板块分类 1：创业板  */
	[holderControl] [numeric](10, 2) NULL,/* 持仓比例限制  入库数据不带%为小数  */
	[status] [varchar](1) NOT NULL,/* 是否生效  1:是 2：否 */
	[modifytime] [datetime] NULL,/* 更新时间 */
	 PRIMARY KEY ([ID]));
	
--充值、取现订单表
	CREATE TABLE [dbo].[fund_order](
	[orderid] [int] IDENTITY(1,1) NOT NULL,		/* 订单号 (入金出金申请的单号)*/
	[subzh] [VARCHAR](32) NOT NULL ,/*用户编号*/
	[zj_use] [varchar](1) NOT NULL, /*资金交易类别（1充值、2取现）*/
	[zj_type] [varchar](1) NOT NULL,  /*资金交易方式 （1：银行卡 2：支付宝 3： 微信）*/
	[paymentzh] [varchar](32) NOT NULL,					/* 资金账号（付款，取现账号） */
	[phone] [varchar](20) NULL,/* 登陆手机 */
	[kh_name] [varchar](50) NULL,/* 开户姓名 */
	[fund] [money] NULL,				/* 金额*/
	[remark_name] [varchar](50) NULL,/* 备注姓名 */
	[remark_phone] [varchar](20) NULL,/* 备注手机 */
	[over_time] [DATETIME]  NULL ,/*入账或取现时间*/
	[status] [varchar](1) NOT NULL, /*订单状态 0待审核/1已通过/2未通过*/
	[sys_userid] [int] NULL,/*操作人员*/
	[sys_user_name] [varchar](50) NULL,/* 冗余 操作人员名称 */
	[sk_name] [varchar](15) NULL, /*收款方名称：1银行，2微信，3支付宝*/
	[sk_bank] [varchar](15) NULL, /*收款银行支行（SWIFT代码）*/
	[create_time] [datetime] NULL,		/* 创建时间 */
	[modified_time] [datetime] NULL,		/* 修改时间 */
	PRIMARY KEY ([orderid]) );
	
--报单账户表
	CREATE TABLE [dbo].[bdzh](
	[bdzhid] [int] IDENTITY(1,1) NOT NULL,		/* 主键)*/
	[qsid] [VARCHAR](64)  NULL ,/*报单公司*/
	[qsname] [VARCHAR](128) NULL ,/*券商拼音*/
	[yyb] [varchar](32)  NULL, /*营业部*/
	[mainzh] [varchar](32)  NULL,  /*资金账户*/
	[zh_type] [varchar](1)  NULL,	/* 账户类型：0普通账户/1两融账户 */
	[ha_code] [varchar](20) NULL,/* 沪 A  股东代码 */
	[sa_code] [varchar](20) NULL,/* 深  A  股东代码 */
	[jypassword] [varchar](32) NULL,				/* 交易密码*/
	[txpassword] [varchar](32) NULL,/* 通讯密码 */
	[yj_scale] [numeric](18, 3) NULL,/* 佣金比例 */
	[yj_least] [money]  NULL ,/*最低佣金*/
	[status] [varchar](1)  NULL, /*状态  0有效—启用、1有效—停用、2无效、3显示、4隐藏*/
	[single_securities_scale] [numeric](18, 3) NULL,/*单证券持仓比例*/
	[single_kind_limit] [int] NULL,/* 单品种持仓上限 */
	[special_kind_limit] [int] NULL, /*特定品种持仓上限*/
	[create_time] [datetime] NULL,		/* 创建时间 */
	[modified_time] [datetime] NULL,		/* 修改时间 */
	[isGroup] [varchar](1) NOT NULL,		/* 是否为分组 */
	PRIMARY KEY ([bdzhid]) );
	
	alter table [dbo].[bdzh] add  group_name [varchar](32) NULL;
	--特定品种持仓上限股票
	alter table [dbo].[bdzh] add  special_kind_stock [varchar](32) NULL;
	alter table [dbo].[bdzh] add  in_group [int] NULL;
	alter table [dbo].[bdzh] add  bd_order [int] NULL;
	alter table [dbo].[bdzh] drop column isGroup;
	alter table [dbo].[bdzh] add broker [varchar](32) null;
	alter table [dbo].[bdzh] add exchange [varchar](32) null;
	alter table [dbo].[bdzh] add [group] [varchar](64) null;
	alter table [dbo].[bdzh] add whether_group [varchar](1) null;
	
	
	
	--登录日志记录
	CREATE TABLE [dbo].[login_logger](
	[logger_id] [int] IDENTITY(1,1) NOT NULL,		/* 主键*/
	[subzh] [VARCHAR](32) NOT NULL ,/*交易账号 */
	[account_name] [varchar](30) NOT NULL,	/* 账户名称 */
	[account_type] [int] NULL,/* 账户类型， */
	[broker] [varchar](30) NOT NULL,	/* 经纪商 */
	[login_type] [int] NULL,/* 1登录,2退出 */
	[login_ip] [varchar](30) NOT NULL,	/* 客户ip地址 */
	[logger_time] [datetime] NULL,		/* 日志记录时间 */
	PRIMARY KEY ([logger_id]) );
	
	--管理员权限表
	CREATE TABLE [dbo].[admin_permission](
	[id] [int] identity(1,1) PRIMARY KEY NOT NULL,
	[aduser] [varchar](32) NOT NULL,    -- 管理员
	[permission] [varchar](32) NOT NULL ,   -- 菜单权限
	[note] [varchar](32) NOT NULL -- 菜单描述
	  );
	  
	--账户权限表
	CREATE TABLE [dbo].[subzh_permission](
	[spid] [int] identity(1,1) PRIMARY KEY NOT NULL,
	[subzh] [varchar](32) NOT NULL,    -- 子账户
	[permission] [varchar](32) NOT NULL ,   -- 菜单权限
	  );
	--充值、取现订单表 增加收款银行名称
	alter table [dbo].[fund_order] add  sk_bank_name [varchar](50) NULL;
	--充值、取现订单表 添加实际金额
	alter table [dbo].[fund_order] add  sj_fund [money] NULL;
	alter table [dbo].[fund_order] DROP COLUMN  sj_fund ;
	--充值、取现订单表 添加充值方式
	alter table [dbo].[fund_order] add  cz_type [varchar](1) NULL;
	--充值、取现订单表 添加出款银行
	alter table [dbo].[fund_order] add  ck_bank [varchar](32) NULL;
	
	CREATE TABLE [dbo].[sub_bank](
	[subbank_id] [int] IDENTITY(1,1) NOT NULL,		/* 主键*/
	[subzh] [VARCHAR](32) NOT NULL ,/*交易账号- 绑定的人 */
	[bank_name] [varchar](30) NOT NULL,	/* 银行名称*/
	[bank_type] [int] NULL,/* 银行类型（工商1，建设2....） */
	[bank_account] [varchar](30) NOT NULL,	/* 银行账号 */
	[khbank] [VARCHAR](50) NULL,/* 开户行 */
	[ower_name] [VARCHAR](50) NULL,/* 户名 */
	[create_time] [datetime] NULL,		/* 创建时间 */
	PRIMARY KEY ([subbank_id]) );

	---提现费率信息表
	CREATE TABLE [dbo].[rate_info](
	[rate_infoid] [int] IDENTITY(1,1) NOT NULL,		/* 主键*/
	[rate] [money] NULL ,
	[least_fund] [money] NULL,	
	PRIMARY KEY ([rate_infoid]) );
	---移仓任务表
	CREATE TABLE [dbo].[movezq_task](
	[task_id] [int] IDENTITY(1,1) NOT NULL,		/* 主键*/
	[code] [varchar](32) NULL ,
	[codename] [varchar](32) NULL,	
	[create_time] [datetime] NULL,		/* 创建时间 */
	[modified_time] [datetime] NULL,		/* 修改时间 */
	[movesl] [int] NULL,		
	[out_mainzh] [int] NULL,		
	[in_mainzh] [int] NULL	
	PRIMARY KEY ([task_id]) );
	alter table [dbo].[movezq_task] add  in_movezq_task [int] NULL;
	alter table [dbo].[movezq_task] alter  out_subzh [varchar](32) NULL;
	alter table [dbo].[movezq_task] add  sc [int] NULL;

	
	alter table [DB_Config].[dbo].[powerinfo] add  registertime [datetime] NULL;
	Alter table [stock_funds].[dbo].[fee_scheme] Alter column [percentage] numeric(10,6);
	alter table [stock_funds].[dbo].[feescheme] add  agentzh [varchar](32) NULL;
	alter table [stock_funds].[dbo].[risk_stock] add  agentzh [varchar](32) NULL;
	alter table [stock_funds].[dbo].[bdzh] add  agentzh [varchar](32) NULL;
	alter table [stock_funds].[dbo].[movezq_task] add  agentzh [varchar](32) NULL;
	alter table [stock_funds].[dbo].[system_basic] add  agentzh [varchar](32) NULL;
	
--代理商（子账户后台管理员）服务费信息表
CREATE TABLE [dbo].[sub_serviceFee](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[subzh] [varchar](32) NOT NULL,/* 子账户  */
	[agentPhone] [varchar](20) NOT NULL,/* 手机号  */
	[feePoint] [numeric](15, 5) NULL,/* 服务费比例 入库数据不带%为小数 */
	[feeBalance] [numeric](18, 3) NULL,/* 预存费用（当前剩余费用）  */
	[warnBalance] [numeric](18, 3) NULL,/* 服务费预警提醒设置  */
	[status] [int] NOT NULL,  --状态 0:正常 1:冻结（服务费不足冻结所有子账户）
	[createtime] [datetime] NOT NULL,/*创建时间*/
	[modifytime] [datetime] NULL,/*更新时间*/
	PRIMARY KEY ([id]) );
	
--代理商（子账户后台管理员）服务费预存/扣费记录表
CREATE TABLE [dbo].[sub_feelog](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[subzh] [varchar](32) NOT NULL,/* 子账户  */
	[feetype] [int] NULL,/* 类型 0：充值  1:消费（服务费扣除） 11：子账户入金 12：子账户出金 */
	[nowBalance] [numeric](18, 3) NULL,/* 当前服务费金额  */
	[addBalance] [numeric](18, 3) NULL,/* 服务费充值/扣除金额  */
	[createtime] [datetime] NOT NULL,/*创建时间*/
	PRIMARY KEY ([id]) );

	
	--APP帮助
CREATE TABLE [dbo].[app_help](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[aboutus] [varchar](Max)  NULL,/* 关于我们 */
	[jylc] [varchar](Max)  NULL,/*交易流程  */
	[pttd] [varchar](Max)  NULL,/*平台特点  */
	[sfbz] [varchar](Max)  NULL,/*收费标准  */
	[lybzj] [varchar](Max)  NULL,/*履约保证金  */
	[ylfp] [varchar](Max)  NULL,/*盈利分配  */
	[mrfw] [varchar](Max)  NULL,/*买入范围  */
	[jysj] [varchar](Max)  NULL,/*交易时间  */
	[gyyjpc] [varchar](Max)  NULL,/*关于预警平仓  */
	[gytp] [varchar](Max)  NULL,/*关于停牌  */
	[lxkf] [varchar](Max)  NULL,/*联系客服  */
	PRIMARY KEY ([id]) );
	
--子账户管理员 报单账户 开通模拟成交
alter table [dbo].[subzh] add [mncj] int NULL;  	/*开通模拟成交  1：是  其他：否*/
alter table [dbo].[bdzh] add [mncj] int NULL;  	/*开通模拟成交  1：是  其他：否*/

--个股设置规则 添加字段类型  1：白名单 2：黑名单
alter table [dbo].[risk_stock] add type int NULL;
--子账户持仓比例单独设置   对应risk_holder表主键ID
alter table [dbo].[subzh] add [riskHolderId] [varchar](32) NULL;

-------------------------------------个股期权
--询价
CREATE TABLE [dbo].[stock_enquiry](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[subzh] [varchar](32) NOT NULL,/* 子账户  */
	[stockcode] [varchar](20) NOT NULL,/* 股票代码  */
	[stockname] [varchar](50) NULL,/* 股票名称 */
	[type] [varchar](1) NOT NULL,/* 询价周期 1：天  2：周  3：月 4：年 */
	[enquirytime] [int] NOT NULL,/* 行权时间 */
	[principalBalance] [numeric](18, 2) NULL,/* 名义本金  */
	[principalFloat] [numeric](10, 2) NULL,/* 权利金率  */
	[royaltyBalance] [numeric](18, 2) NULL,/* 权利金  */
	[enquiryPrice] [numeric](12, 2) NULL,/* 行权价  */
	[settlePrice] [numeric](12, 2) NULL,/* 结算价  */
	[status] [int] NOT NULL, /*状态 0:询价 1认购中2认购失败3认购成功4行权成功5 放弃行权6 行权中  */

	[starttime] [datetime] NULL,/*行权开始时间*/
	[endtime] [datetime] NULL,/*行权结束时间*/
	[createtime] [datetime] NOT NULL,/*创建时间*/
	 PRIMARY KEY ([ID]));
	 
alter table [dbo].[stock_enquiry] add buytime datetime NULL;  /*认购时间(行权即为行权时间)*/
alter table [dbo].[sub_serviceFee] add [pagentzh] [varchar](32) NULL;  /*上级机构*/
alter table [dbo].[sub_feelog] add [feedesc] [varchar](200) NULL;  /*认购费用描述*/
alter table [dbo].[stock_enquiry] add [enquirydesc] [varchar](200) NULL;  /*询价描述*/
alter table [dbo].[stock_enquiry] add [setFee] [int] NULL;  /*是否已计算服务费*/
alter table [dbo].[stock_enquiry] add [profit] [numeric](12, 2) NULL;  /*结算的盈亏* 2018-4-02 增加*/
alter table [dbo].[stock_enquiry] add [freePrice] [numeric](12, 2) NULL;  /*期初价* 2018-4-02 增加*/
alter table [dbo].[stock_enquiry] add [isSell] int NULL;  /*是否强平* 2018-4-02 增加* 1 强平,null 或者其他 不强平*/ 
alter table [dbo].[stock_enquiry] add [timeFly] int NULL;  /*最少持仓天数* 2018-4-02 */ 
alter table [dbo].[subzhfund_log] add [bankaccname] [varchar](20) NULL;  /*银行卡账户名 2018-04-10*/
alter table [dbo].[subzhfund_log] add [bankcardNum] [varchar](30) NULL;  /*银行卡号 2018-04-10*/
alter table [dbo].[subzhfund_log] add [openbankname] [varchar](100) NULL;  /*银行卡开户行 2018-04-10*/
alter table [dbo].[subzhfund_log] add [bankflownum] [varchar](50) NULL;  /*银行流水号 2018-04-10*/