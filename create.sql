--系统用户表
CREATE TABLE [dbo].[sys_user](
	[id] [int] IDENTITY(1,1) NOT NULL,  /* 主键ID 自增 */
	[username] [varchar](100) NOT NULL, /* 登录用户名 */
	[password] [varchar](50) NOT NULL, /* 登录密码 */
	[nickname] [varchar](40) NULL,     /* 昵称 */
	[sysRights] [varchar](1) NULL,     /* 系统权限-暂为空  冗余字段 */
	[status] [int] NOT NULL,--用户状态 1:使用中 2：已注销
	[modifytime] [datetime] NOT NULL,  /* 更新时间 */
	PRIMARY KEY ([id]) ); 
	 
INSERT INTO [dbo].[sys_user] ([username],[password],[status],[modifytime]) VALUES('admin', '111111', 1, '2018-04-07 00:00:00');

--收费方案
CREATE TABLE [dbo].[feescheme_menu](
	[lsh] [int] IDENTITY(1,1) NOT NULL,  /* 主键ID 自增 */
	[schemeName] [varchar](100) NOT NULL,/*方案名称*/
	PRIMARY KEY ([lsh]) );
--收费方案详细信息表	
CREATE TABLE [dbo].[fee_scheme](
	[lsh] [int] IDENTITY(1,1) NOT NULL,
	[schemeType] [tinyint] NOT NULL,/*收费方案类型,1经纪商交易佣金,2印花税,3过户费  5管理费*/
	[direction] [varchar](5) NULL,/*收费方向 1卖，0买*/
	[percentage] [money](10,4) NULL,/*收费比例*/
	[lowfee] [money](10,4) NULL,/*最低收费*/
	[schemeName] [varchar](100) NOT NULL,/*方案名称*/
	[showStatus] [tinyint] NULL,/*显示状态，1显示，0不显示*/
	[feeSchemeId] [int] NOT NULL,/* 关联 feescheme_menu表 主键ID*/
	PRIMARY KEY ([lsh]) );

  alter table [PrimeBroker_crude].[dbo].[codefeeset_menu] add [percentage] [numeric](12, 3) NULL;/*管理费*/

--保证金模板菜单
CREATE TABLE [dbo].[bzjmb_menu](
	[id] [int] IDENTITY(1,1) NOT NULL,  /* 主键ID 自增 */
	[title] [varchar](100) NOT NULL,    /*方案名称*/
	[modifyTime] [datetime] NOT NULL,   /* 更新时间 */
	[userid] [numeric](18, 0) NULL,         /* 创建人 */
	[agentzh] [varchar](32) NULL,           /* 代理商 */
	 PRIMARY KEY ([ID])); 
--保证金模版
CREATE TABLE [dbo].[bzjmb](
	[id] [int] IDENTITY(1,1) NOT NULL,  /* 主键ID 自增 */
	[sc] [int] NOT NULL,							/* 市场编码 */
	[bzjdm] [varchar](32) NOT NULL,					/* 合约代码 */
	[bzjname] [varchar](32) NOT NULL,				/* 合约名称 */
	[bbbz] [numeric](18, 3) NULL,				    /*本币比重*/
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
	[parentId] [int] NULL,                  /* 关联 bzjmb_menu表 主键ID*/
	[userid] [numeric](18, 0) NULL,         /* 创建人 */
	[agentzh] [varchar](32) NULL,           /* 代理商 */
  PRIMARY KEY ([ID]));

--风控方案   风控全局设置
CREATE TABLE [dbo].[risk_tempall](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[newstock] [int] NULL,/* 上海股指期货  0：不禁买  1：禁买*/
	[newstock_day] [int] NULL,/* 上海商品  0：不禁买  1：禁买*/
	[rubbishstock] [int] NULL,/* 大连商品 0：不禁买  1：禁买*/
	[businessplate] [int] NULL,/* 郑州商品 0：不禁买  1：禁买*/
	[modifytime] [datetime] NULL,/* 更新时间 */
	[type] [varchar](100) NULL,    /* 方案名称 */
	[agentzh] [varchar](32) NULL,    /* 代理商 */
	PRIMARY KEY ([id]));
	
alter table [PrimeBroker_crude].[dbo].[risk_tempall] add [crudeoil] [int] NULL;/*原油  0：不禁买  1：禁买*/
alter table [PrimeBroker_crude].[dbo].[risk_tempall] add [warningValue] [numeric](10, 2) NULL;/*预警阀值  如110.05%则入库数据为110.05*/
alter table [PrimeBroker_crude].[dbo].[risk_tempall] add [closeoutValue] [numeric](10, 2) NULL;/*强平阀值*/
alter table [PrimeBroker_crude].[dbo].[risk_tempall] add [closevalue] [numeric](10, 2) NULL;/* 收盘强平阀值  如100%则入库数据为100 */
	
--个股设置规则
CREATE TABLE [dbo].[risk_stock](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[parentId] [int] NOT NULL,/* 模板ID 对应风控全局设置risk_tempall表*/
	[stockcode] [varchar](20) NULL,/* 合约代码  */
	[stockname] [varchar](50) NULL,/* 合约名称 */
	[type] int NULL, /* 合约类型  1：白名单 2：黑名单  3:策略名单 */
	[agentzh] [varchar](32) NULL,    /* 代理商 */
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
	 
--账户信息表
CREATE TABLE [dbo].[subzh](
	[subzh] [varchar](32) NOT NULL,/*用户名*/
	[cookie] [varchar](32) NOT NULL,/*用户名cookie*/
	[pagentzh] [varchar](32) NULL,/*上级账户*/
	[mainzh] [varchar](32) NULL,/*主账户 - 暂未使用*/
	[password] [varchar](40) NULL,/*登录密码*/
	[name] [varchar](50) NULL,/*开户姓名*/
	[sex] [int] NULL,/*性别*/
	[phone] [varchar](20) NULL,/*登录手机*/
	[khdate] [datetime] NULL,/*开户时间*/
	[wtzh] [varchar](32) NULL,/*委托账户*/
	[marginset] [varchar](32) NULL,/*保证金方案*/
	[feeset] [varchar](32) NULL,/*收费方案*/
	[riskset] [int] NULL,/*风控方案*/
	[midman] [varchar](32) NULL,
	[openright] [int] NULL,
	[accounttype] [int] NULL,
	[brokerzh] [varchar](32) NULL,
	[isagent] [int] NULL,
	[qq] [varchar](20) NULL,
	[mail] [varchar](32) NULL,
	[initmoney] [money] NULL,/* 初始资金 */
	[address] [varchar](255) NULL,
	[firstjjs] [varchar](50) NULL,
	[secendjjs] [varchar](50) NULL,
	[thirdjjs] [varchar](50) NULL,
	[mac] [varchar](32) NULL,
	[note] [varchar](200) NULL,
	[groupid] [varchar](1) NULL,/*分组ID */
	[bz] [varchar](4) NULL,/* 币种   1:USD 2:CNY 3:HKD */
	[userid] [numeric](18, 0) NULL,
	[headPicture] [varchar](256) NULL,/*头像*/
	[loginname] [varchar](50) NULL,/*登录名称*/
	[notename] [varchar](50) NULL,/*备注姓名*/
	[notetel] [varchar](20) NULL,/*备注电话*/
	[risktype] [int] NULL,/*风控模式   0：每个账户单独风控   1：所有资金账户联合风控*/
	[accountpattern] [int] NULL,/*账户模式   0:分账户 2：独立账户*/
	[zijinaccount] [int] NULL,/*资金账户   1:在岸人民币账户 2：美元账户 3:港币账户 4:离岸人民币账户*/
	[jypz] [int] NULL, /*交易品种   1:原油期货*/
	[bdtd] [varchar](100) NULL,/*保单通道   报单账户或报单账户组*/
	[bzj] [money] NULL,/*保证金      劣后*/
	[rzj] [money] NULL,/*融资金额  优先*/
	[yjx] [money] NULL,/*预警线*/
	[pcx] [money] NULL,/*平仓线*/
	[xzj] [money] NULL,/*限制可用金额*/
	[ccbl] [int] NULL,/*持仓比例  0：全局设置  1：单独设置*/
	[isadmin] [int] NULL,/*是否管理员  1：管理员 /2：渠道：/3：经纪人 /4普通用户 -*/
	[jyright] [varchar](32) NULL,/*交易状态  1：禁止开仓   2：禁止平仓   3：禁止撤单*/
	[riskstate] [int] NULL, /*风控状态  0：正常  1：预警  2：强平 3:冻结*/
	[mncj] [int] NULL,/*开通模拟成交  1：是  其他：否*/
	[riskHolderId] [varchar](32) NULL,/* 子账户持仓比例单独设置   对应risk_holder表主键ID  */
	[total_defer] [numeric](18, 6) NULL,/* 递延费  */
	[munberno] [varchar](10) NULL,/* 经纪人或渠道编号  */
	[fundBalance] [numeric](21, 3) NULL,/* 账户资产即可提现资金  首次通过充值  */
	[zhstate] [int] NULL,/* 账户状态  0：未激活  1：正常（可交易）  2：申请清算*/
	[allocbroker] [varchar](36) NULL,/* 被分配的经纪人 */
	[allocchannel] [varchar](36) NULL,/* 被分配的渠道*/
	[allocation] [varchar](36) NULL,
 CONSTRAINT [PK_subzh] PRIMARY KEY CLUSTERED 
(
	[subzh] ASC,
	[cookie] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

--报单账户
CREATE TABLE [dbo].[bdzh](
	[bdzhid] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[orderid] [int] NULL, /* 分配顺序  */
	[accountid] [varchar](128) NULL,/*资金账户*/
	[suminterest] [money] NULL,	/*总权益*/
	[bzmoney] [money] NULL, /*占用保证金*/
	[avaamoney] [money] NULL, /*可用资金*/
	[subinterest] [money] NULL, /*子账户权益*/
	[symoney] [money] NULL, /*剩余资金额度*/
	[zhstate] [int] NULL, /* 账户状态  0：不可用 1：正常（可交易）  */
PRIMARY KEY ([bdzhid]) );

--账户配资信息表
CREATE TABLE [dbo].[fund_pzlog](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[subzh] [varchar](32) NOT NULL,/* 子账户  */
	[fundtype] [int] NOT NULL, /* 类型 1:配资 资金比例 2:加配资金比例 3:减配  4:追加保证金 5:出金  6:充值 7:提现 8:调账出金9:调账入金*/
	[setpro] [int] NULL, /* 比例 */
	[fundBalance] [numeric](18, 3) NULL,/* 金额 */
	[nowBalance] [numeric](18, 3) NULL,/* 保证金 */
	[yjxBalance] [numeric](18, 3) NULL,/* 预警线（金额）  */
	[pcxBalance] [numeric](18, 3) NULL,/* 平仓线（金额）  */
	[feeBalance] [numeric](18, 3) NULL,/* 服务费  */
	[againFeeBalance] [numeric](18, 3) NULL,/* 加配服务费  */
	[deferredBalance] [numeric](18, 3) NULL,/* 递延费  */
	[setdesc] [varchar](200) NULL,/* 描述  */
	[createtime] [datetime] NOT NULL,/*创建时间*/
	PRIMARY KEY ([id]) );

--资金（充值提现）信息表
CREATE TABLE [dbo].[agentzhfund_log](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[subzh] [varchar](32) NOT NULL,/* 子账户 关联subzh表  */
	[name] [varchar](50) NULL,/* 信息描述  */
	[type] [varchar](1) NOT NULL,/*类型  2：充值  3：提现 */
	[bz] [tinyint] NOT NULL,/* 币种  1：人民币  */
	[fund] [money] NULL,/* 资金  */
	[description] [text] NULL,/* 详细描述 （订单号）  */
	[modifytime] [datetime] NULL,/* 更新时间  */
	[status] [tinyint] NULL,/*状态   0:预支付  1：支付成功 2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝*/
	[afterfund] [money] NULL,/*  劣后资金 - 暂未使用  */
	PRIMARY KEY ([id]) );

--异常订单
CREATE TABLE [dbo].[EXCEPT_ORDER](
	[id] [numeric](18, 0) IDENTITY(1,1) NOT NULL,/* 主键  */
	[user_id] [varchar](20) NOT NULL,/* 子账户 关联subzh表  */
	[mainzh] [varchar](20) NOT NULL,/* 报单账户  */
	[market] [tinyint] NOT NULL,/* 市场  */
	[hycode] [varchar](32) NOT NULL,/* 合约代码  */
	[hypz] [varchar](50) NULL,/* 合约名称  */
	[direction] [tinyint] NOT NULL,/* 方向  */
	[vol] [int] NULL,/* 下单数量  */
	[price] [float] NULL,/* 下单价格  */
	[order_time] [datetime] NOT NULL,/* 下单时间  */
	[reason] [varchar](255) NULL,/* 异常原因  */
	[userid] [numeric](18, 0) NULL,/* 创建人 */
	[agentzh] [varchar](32) NULL/* 代理商 */
PRIMARY KEY ([id]) );

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
	[limitBalance] [numeric](12, 2) NULL,/*提现审核最小金额*/
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

--当日统计资金流水统计
CREATE TABLE [dbo].[fund_sumlog](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[registnum] [int] NULL, /* 累计注册 */
	[addfund] [int] NULL, /* 累计开单(配资、加配) */
	[addBalance] [numeric](18, 3) NULL,/* 累计开单金额  */
	[feeBalance] [numeric](18, 3) NULL,/* 累计综合服务费  */
	[deferredBalance] [numeric](18, 3) NULL,/* 累计递延费  */
	[feenextBalance] [numeric](18, 3) NULL,/* 累计加配手续费  */
	[overBalance] [numeric](18, 3) NULL,/* 累计穿仓金额  */
	[sumBalance] [numeric](24, 3) NULL,/* 平台收入合计  */
	[settledesc] [varchar](100) NULL,/* 描述  */
	[settletime] [datetime] NOT NULL,/*结算时间*/
	[createtime] [datetime] NOT NULL,/*创建时间*/
	[fundtype] [int] NOT NULL, /* 类型 1:日报 2：月报 */
	[agentzh] [varchar](32) NULL,	/* 代理商账号 */
	PRIMARY KEY ([id]) );

--账户当日结算数据
CREATE TABLE [dbo].[fund_settlelog](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[subzh] [varchar](32) NOT NULL,/* 子账户  */
	[allocbroker] [varchar](36) NULL,/* 经纪人  */
	[allocchannel] [varchar](36) NULL,/* 渠道  */
	[phone] [varchar](20) NULL,/* 手机号  */
	[name] [varchar](50) NULL,/* 姓名  */
	[registnum] [int] NULL, /* 注册数量 */
	[addfund] [int] NULL, /* 开单(配资、加配)数量 */
	[addBalance] [numeric](18, 3) NULL,/* 开单金额  */
	[stockfund] [int] NULL,/* 存量单数  */
	[stockBalance] [numeric](18, 3) NULL,/* 存量金额  */
	[feeBalance] [numeric](18, 3) NULL,/* 综合服务费  */
	[deferredBalance] [numeric](18, 3) NULL,/* 递延费  */
	[feenextBalance] [numeric](18, 3) NULL,/* 加配手续费  */
	[overBalance] [numeric](18, 3) NULL,/* 穿仓金额  */
	[sumBalance] [numeric](24, 3) NULL,/* 平台收入合计  */
	[settledesc] [varchar](100) NULL,/* 描述  */
	[settletime] [datetime] NOT NULL,/*结算时间*/
	[createtime] [datetime] NOT NULL,/*创建时间*/
	[fundtype] [int] NOT NULL, /* 类型 1:日报 2：月报 */
	[agentzh] [varchar](32) NULL,	/* 代理商账号 */
	PRIMARY KEY ([id]) );
	
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
	[limitBalance] [numeric](12, 2) NULL,
	PRIMARY KEY ([id]) );
	
	
	--权限菜单表
CREATE TABLE [dbo].[pre_menu](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[pre_id] [int]  NOT NULL, /*所属权限 --对应权限表*/
	[mname] [varchar](64) NULL, /* 权限菜单名称 */
	[menu_code] [varchar](64) NULL, /*菜单缩写 */
	[role_id] int NULL 	/*对应角色id-冗余字段*/
	PRIMARY KEY ([id]) );

	--子账户权限菜单表
CREATE TABLE [dbo].[subzh_pre_menu](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[pmid] [int]  NOT NULL, /*权限菜单 */
	[subzh] [varchar](64) NULL, /*子账户权限 */
	PRIMARY KEY ([id]) );

	
--子账户角色表
CREATE TABLE [dbo].[subzh_role](
	[id] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[subzh] [int]  NOT NULL, /*子账户编号 */
	[roleid] [int](64) NULL, /*角色变 */
	PRIMARY KEY ([id]) );
	
--样本账户表
CREATE TABLE [dbo].[trade_hedging](
	[id] [int] IDENTITY(1,1) NOT NULL,  /* 主键ID 自增 */
	[vipNumber] [varchar](100) NOT NULL, /* 分组编号 */
	[accountcode] [varchar](100) NOT NULL, /* 登录密码 */
	[createdate] [datetime] NOT NULL,  /* 更新时间 */
	PRIMARY KEY ([id]) );

--合约表	contract
	CREATE TABLE [dbo].[contract](
	[cid] [int] IDENTITY(1,1) NOT NULL,/* 主键  */
	[market] [int]  NOT NULL, /*市场  ---1.中金所CFFEX  /2.上期所  /3.大商所DCE /4.郑商所czce  /5.上期能源INE*/
	[hycode] [varchar](64) NULL, /*合约代码*/
	[hyname] [varchar](64) NULL, /*合约名称*/
	[hynum] [numeric](64) NULL, /*合约乘数*/
	[minprice] [numeric](64) NULL, /*最小变动价格*/
	[bz] [varchar](64) NULL, /*最小变动价格*/
	PRIMARY KEY ([id]));

--手续费详细信息表
CREATE TABLE [dbo].[codefeeset](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[marketcode] [int] NOT NULL,
	[code] [varchar](32) NOT NULL,
	[hyname] [varchar](32) NOT NULL,
	[bbbz] [numeric](18, 3) NULL,
	[counterfee1] [numeric](18, 3) NULL,
	[counterfee2] [numeric](18, 3) NULL,
	[pcfee1] [numeric](18, 3) NULL,
	[pcfee2] [numeric](18, 3) NULL,
	[sqfs] [int] NOT NULL,
	[servicefee] [numeric](18, 3) NULL,
	[gjwhgylx] [numeric](18, 3) NULL,
	[bzj] [numeric](18, 3) NULL,
	[parentId] [int] NULL,
	[bz] [varchar](4) NULL,
	[userid] [numeric](18, 0) NULL,
	[agentzh] [varchar](32) NULL,
	PRIMARY KEY ([id]));
	
	alter table [dbo].[subzh] add manage [varchar](32) NULL;
	alter table [dbo].[bdzh] add create_user [varchar](32) NULL;
	alter table [dbo].[subzh] add coefficient [money] NULL;
	alter table [dbo].[subzh] add is_delete [int] NULL;
	alter table [dbo].[subzh] add allocagent [varchar](32) NULL;
	alter table [dbo].[subzh] add allocpt [varchar](32) NULL;
	
	alter table [dbo].[bdzh] add password [varchar](32) NULL;

	--添加实名认证相关字段	
	ALTER TABLE dbo.subzh ADD bank VARCHAR(20);/*银行*/
	ALTER TABLE dbo.subzh ADD bank_card VARCHAR(30);/*银行卡*/
	ALTER TABLE dbo.subzh ADD id_no VARCHAR(18);/*身份证*/
	ALTER TABLE dbo.subzh ADD front_pic VARCHAR(100);/*身份证正面照*/
	ALTER TABLE dbo.subzh ADD back_pic VARCHAR(100);/*身份证背面照*/
	ALTER TABLE dbo.subzh ADD card_pic VARCHAR(100);/*银行卡照片*/
	ALTER TABLE dbo.subzh ADD auth_state INT DEFAULT 0;/*实名认证状态0 未认证 1申请中 2已通过 3未通过*/