sys_user        --系统用户表
role            --角色表
sysuser_role    --用户角色表
role_permission --角色权限表
permission      --权限表
pre_menu        --权限菜单表    
subzh_pre_menu  --子账户权限菜单列表
subzh_role      --子账户角色表
/*
系统用户表
*/
-- ----------------------------
-- Table structure for [dbo].[sys_user]
-- ----------------------------
DROP TABLE [dbo].[sys_user]
GO
CREATE TABLE [dbo].[sys_user] (
[id] int NOT NULL IDENTITY(1,1) ,
[username] varchar(100) NOT NULL ,
[password] varchar(50) NOT NULL ,
[nickname] varchar(40) NULL ,
[sysRights] varchar(1) NULL ,
[status] int NOT NULL ,
[modifytime] datetime NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[sys_user]', RESEED, 28)
GO

-- ----------------------------
-- Records of sys_user
-- ----------------------------
SET IDENTITY_INSERT [dbo].[sys_user] ON
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'2', N'admin', N'123456', N'系统管理员', null, N'1', N'2018-01-25 09:49:55.400');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'3', N'admin1', N'111111', N'admin', null, N'1', N'2017-12-12 09:06:22.603');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'4', N'admin2', N'111111', N'admin', null, N'1', N'2017-12-11 16:32:54.103');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'11', N'admin231', N'admin123', N'admin', null, N'1', N'2017-12-14 17:23:11.303');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'13', N'admin21321', N'SAMIDNS213', N'admin21', null, N'1', N'2017-12-14 17:28:16.383');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'23', N'admin1232', N'admin1232', N'管理员账户', null, N'1', N'2017-12-16 16:44:11.627');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'24', N'qq1EDDDD', N'1111111111', N'111', null, N'1', N'2018-01-25 09:54:31.983');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'26', N'jcl', N'123456', N'金策略', null, N'1', N'2018-04-25 19:09:25.000');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'27', N'zpf', N'123456', N'测试的', null, N'1', N'2018-04-26 14:01:22.000');
GO
INSERT INTO [dbo].[sys_user] ([id], [username], [password], [nickname], [sysRights], [status], [modifytime]) VALUES (N'28', N'tom', N'123456', N'测试二', null, N'1', N'2018-04-26 14:02:09.000');
GO
SET IDENTITY_INSERT [dbo].[sys_user] OFF
GO

-- ----------------------------
-- Indexes structure for table sys_user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[sys_user]
-- ----------------------------
ALTER TABLE [dbo].[sys_user] ADD PRIMARY KEY ([id])
GO

/******************************************************************/
/*
角色表
*/
-- ----------------------------
-- Table structure for [dbo].[role]
-- ----------------------------
DROP TABLE [dbo].[role]
GO
CREATE TABLE [dbo].[role] (
[lsh] numeric(11) NOT NULL IDENTITY(1,1) ,
[name] varchar(30) NULL ,
[type] int NULL ,
[userid] numeric(18) NULL ,
[agentzh] varchar(32) NULL ,
[ch_name] varchar(128) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[role]', RESEED, 6)
GO

-- ----------------------------
-- Records of role
-- ----------------------------
SET IDENTITY_INSERT [dbo].[role] ON
GO
INSERT INTO [dbo].[role] ([lsh], [name], [type], [userid], [agentzh], [ch_name]) VALUES (N'1', N'admin', null, null, null, N'系统管理员');
GO
INSERT INTO [dbo].[role] ([lsh], [name], [type], [userid], [agentzh], [ch_name]) VALUES (N'3', N'channel', null, null, null, N'渠道');
GO
INSERT INTO [dbo].[role] ([lsh], [name], [type], [userid], [agentzh], [ch_name]) VALUES (N'4', N'Agent', null, null, null, N'经纪人');
GO
INSERT INTO [dbo].[role] ([lsh], [name], [type], [userid], [agentzh], [ch_name]) VALUES (N'6', N'Customer', null, null, null, N'普通用户');
GO
SET IDENTITY_INSERT [dbo].[role] OFF
GO
/***********************************************************************/
/*
用户角色表
*/
-- ----------------------------
-- Table structure for [dbo].[sysuser_role]
-- ----------------------------
DROP TABLE [dbo].[sysuser_role]
GO
CREATE TABLE [dbo].[sysuser_role] (
[id] int NOT NULL IDENTITY(1,1) ,
[rid] int NOT NULL ,
[userid] int NOT NULL ,
[createTime] datetime NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[sysuser_role]', RESEED, 35)
GO

-- ----------------------------
-- Records of sysuser_role
-- ----------------------------
SET IDENTITY_INSERT [dbo].[sysuser_role] ON
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'3', N'1', N'4', N'2017-12-11 16:32:54.120');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'7', N'1', N'3', N'2017-12-12 09:06:22.683');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'13', N'1', N'11', N'2017-12-14 17:23:11.313');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'26', N'1', N'23', N'2017-12-16 16:44:13.213');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'28', N'1', N'2', N'2018-01-25 09:49:55.403');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'29', N'1', N'24', N'2018-01-25 09:54:31.993');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'30', N'3', N'26', N'2018-04-25 19:09:51.000');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'31', N'4', N'27', N'2018-04-26 14:02:27.000');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'32', N'6', N'28', N'2018-04-26 14:03:25.000');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'33', N'3', N'2', N'2018-04-26 14:04:26.000');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'34', N'4', N'2', N'2018-04-26 14:04:39.000');
GO
INSERT INTO [dbo].[sysuser_role] ([id], [rid], [userid], [createTime]) VALUES (N'35', N'6', N'2', N'2018-04-26 14:04:51.000');
GO
SET IDENTITY_INSERT [dbo].[sysuser_role] OFF
GO

-- ----------------------------
-- Indexes structure for table sysuser_role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[sysuser_role]
-- ----------------------------
ALTER TABLE [dbo].[sysuser_role] ADD PRIMARY KEY ([id])
GO
/**************************************************************************/
/*
角色权限表*/
-- ----------------------------
-- Table structure for [dbo].[role_permission]
-- ----------------------------
DROP TABLE [dbo].[role_permission]
GO
CREATE TABLE [dbo].[role_permission] (
[id] int NOT NULL IDENTITY(1,1) ,
[rid] int NOT NULL ,
[pid] int NOT NULL ,
[createTime] datetime NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[role_permission]', RESEED, 6)
GO

-- ----------------------------
-- Records of role_permission
-- ----------------------------
SET IDENTITY_INSERT [dbo].[role_permission] ON
GO
INSERT INTO [dbo].[role_permission] ([id], [rid], [pid], [createTime]) VALUES (N'1', N'1', N'2', N'2017-12-08 00:00:00.000');
GO
INSERT INTO [dbo].[role_permission] ([id], [rid], [pid], [createTime]) VALUES (N'2', N'1', N'3', N'2017-12-08 00:00:00.000');
GO
INSERT INTO [dbo].[role_permission] ([id], [rid], [pid], [createTime]) VALUES (N'3', N'1', N'4', N'2017-12-08 00:00:00.000');
GO
INSERT INTO [dbo].[role_permission] ([id], [rid], [pid], [createTime]) VALUES (N'4', N'1', N'5', N'2017-12-08 00:00:00.000');
GO
INSERT INTO [dbo].[role_permission] ([id], [rid], [pid], [createTime]) VALUES (N'5', N'2', N'2', N'2018-04-25 09:49:44.000');
GO
INSERT INTO [dbo].[role_permission] ([id], [rid], [pid], [createTime]) VALUES (N'6', N'2', N'3', N'2018-04-25 09:50:23.000');
GO
SET IDENTITY_INSERT [dbo].[role_permission] OFF
GO

-- ----------------------------
-- Indexes structure for table role_permission
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[role_permission]
-- ----------------------------
ALTER TABLE [dbo].[role_permission] ADD PRIMARY KEY ([id])
GO
/************************************************************/

/*
角色菜单表
*/
-- ----------------------------
-- Table structure for [dbo].[rolemenu]
-- ----------------------------
DROP TABLE [dbo].[rolemenu]
GO
CREATE TABLE [dbo].[rolemenu] (
[lsh] numeric(18) NOT NULL IDENTITY(1,1) ,
[roleid] int NOT NULL ,
[menuid] int NOT NULL ,
[menucode] varchar(30) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[rolemenu]', RESEED, 160)
GO

-- ----------------------------
-- Records of rolemenu
-- ----------------------------
SET IDENTITY_INSERT [dbo].[rolemenu] ON
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'73', N'1', N'1', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'74', N'1', N'8', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'75', N'1', N'9', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'76', N'1', N'2', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'77', N'1', N'10', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'78', N'1', N'11', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'79', N'1', N'12', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'80', N'1', N'13', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'81', N'1', N'14', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'82', N'1', N'15', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'83', N'1', N'16', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'84', N'1', N'3', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'85', N'1', N'17', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'86', N'1', N'18', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'87', N'1', N'19', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'88', N'1', N'4', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'89', N'1', N'20', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'90', N'1', N'21', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'91', N'1', N'22', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'92', N'1', N'5', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'93', N'1', N'23', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'94', N'1', N'24', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'95', N'1', N'25', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'96', N'1', N'26', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'97', N'1', N'27', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'98', N'1', N'6', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'99', N'1', N'28', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'100', N'1', N'29', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'101', N'1', N'30', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'102', N'1', N'31', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'103', N'1', N'7', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'104', N'1', N'32', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'105', N'1', N'33', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'106', N'1', N'34', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'107', N'1', N'35', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'108', N'1', N'36', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'121', N'4', N'1', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'122', N'4', N'8', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'123', N'4', N'9', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'124', N'4', N'3', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'125', N'4', N'17', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'126', N'4', N'18', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'127', N'4', N'19', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'128', N'4', N'4', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'129', N'4', N'20', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'130', N'4', N'21', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'131', N'4', N'22', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'132', N'5', N'1', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'133', N'5', N'8', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'134', N'5', N'9', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'135', N'5', N'3', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'136', N'5', N'17', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'137', N'5', N'18', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'138', N'5', N'19', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'139', N'5', N'5', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'140', N'5', N'23', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'141', N'5', N'24', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'142', N'5', N'25', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'143', N'5', N'26', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'144', N'5', N'27', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'145', N'5', N'6', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'146', N'5', N'28', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'147', N'5', N'29', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'148', N'5', N'30', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'149', N'5', N'31', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'160', N'1', N'39', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'110', N'3', N'1', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'111', N'3', N'8', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'112', N'3', N'9', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'113', N'3', N'2', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'114', N'3', N'10', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'115', N'3', N'11', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'116', N'3', N'12', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'117', N'3', N'13', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'118', N'3', N'14', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'119', N'3', N'15', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'120', N'3', N'16', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'150', N'6', N'1', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'151', N'6', N'8', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'152', N'6', N'9', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'153', N'6', N'6', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'154', N'6', N'28', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'155', N'6', N'29', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'156', N'6', N'30', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'157', N'6', N'31', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'158', N'1', N'37', null);
GO
INSERT INTO [dbo].[rolemenu] ([lsh], [roleid], [menuid], [menucode]) VALUES (N'159', N'1', N'38', null);
GO
SET IDENTITY_INSERT [dbo].[rolemenu] OFF
GO
/*****************************************************************************************/
/*
权限表
*/
-- ----------------------------
-- Table structure for [dbo].[permission]
-- ----------------------------
DROP TABLE [dbo].[permission]
GO
CREATE TABLE [dbo].[permission] (
[p_id] int NOT NULL IDENTITY(1,1) ,
[pri_name] varchar(50) NOT NULL ,
[keyword] varchar(50) NOT NULL ,
[desc] varchar(500) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[permission]', RESEED, 5)
GO

-- ----------------------------
-- Records of permission
-- ----------------------------
SET IDENTITY_INSERT [dbo].[permission] ON
GO
INSERT INTO [dbo].[permission] ([p_id], [pri_name], [keyword], [desc]) VALUES (N'2', N'sys_user', N'资金管理', N'资金管理列表');
GO
INSERT INTO [dbo].[permission] ([p_id], [pri_name], [keyword], [desc]) VALUES (N'3', N'customer_user', N'账户管理', N'账户管理列表');
GO
INSERT INTO [dbo].[permission] ([p_id], [pri_name], [keyword], [desc]) VALUES (N'4', N'rights_manage', N'交易管理', N'交易管理列表');
GO
INSERT INTO [dbo].[permission] ([p_id], [pri_name], [keyword], [desc]) VALUES (N'5', N'rolelist', N'系统管理', N'系统管理列表');
GO
SET IDENTITY_INSERT [dbo].[permission] OFF
GO

-- ----------------------------
-- Indexes structure for table permission
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[permission]
-- ----------------------------
ALTER TABLE [dbo].[permission] ADD PRIMARY KEY ([p_id])
GO

/*************************************************************************************/
/*
权限菜单表
*/
-- ----------------------------
-- Table structure for [dbo].[pre_menu]
-- ----------------------------
DROP TABLE [dbo].[pre_menu]
GO
CREATE TABLE [dbo].[pre_menu] (
[id] int NOT NULL IDENTITY(1,1) ,
[pre_id] int NOT NULL ,
[mname] varchar(64) NULL ,
[menu_code] varchar(64) NULL ,
[role_id] int NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[pre_menu]', RESEED, 16)
GO

-- ----------------------------
-- Records of pre_menu
-- ----------------------------
SET IDENTITY_INSERT [dbo].[pre_menu] ON
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'2', N'3', N'账户列表', N'zhlist', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'3', N'3', N'收费方案', N'payset', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'4', N'3', N'保证金方案', N'bzj', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'6', N'3', N'风控方案', N'fk', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'7', N'3', N'资金流水', N'zjls', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'9', N'3', N'提现审核', N'txsh', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'10', N'4', N'订单记录', N'ddjl', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'11', N'4', N'持仓对比', N'ccdb', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'12', N'4', N'异常订单', N'exdd', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'13', N'4', N'操盘方案', N'opsch', null);
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'15', N'5', N'系统账户', N'sys', N'1');
GO
INSERT INTO [dbo].[pre_menu] ([id], [pre_id], [mname], [menu_code], [role_id]) VALUES (N'16', N'5', N'app帮助', N'app_help', null);
GO
SET IDENTITY_INSERT [dbo].[pre_menu] OFF
GO

-- ----------------------------
-- Indexes structure for table pre_menu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[pre_menu]
-- ----------------------------
ALTER TABLE [dbo].[pre_menu] ADD PRIMARY KEY ([id], [pre_id])
GO
/*************************************************************************/
/*
子账户权限菜单表
*/
-- ----------------------------
-- Table structure for [dbo].[subzh_pre_menu]
-- ----------------------------
DROP TABLE [dbo].[subzh_pre_menu]
GO
CREATE TABLE [dbo].[subzh_pre_menu] (
[id] int NOT NULL IDENTITY(1,1) ,
[pmid] int NOT NULL ,
[subzh] varchar(64) NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[subzh_pre_menu]', RESEED, 108)
GO

-- ----------------------------
-- Records of subzh_pre_menu
-- ----------------------------
SET IDENTITY_INSERT [dbo].[subzh_pre_menu] ON
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'1', N'2', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'2', N'3', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'3', N'4', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'4', N'6', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'5', N'7', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'6', N'9', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'7', N'10', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'8', N'11', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'9', N'12', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'10', N'13', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'11', N'15', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'12', N'16', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'13', N'2', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'14', N'3', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'15', N'4', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'16', N'6', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'17', N'7', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'18', N'9', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'19', N'10', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'20', N'11', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'21', N'12', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'22', N'13', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'23', N'15', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'24', N'16', N'13260598999');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'25', N'2', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'26', N'3', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'27', N'4', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'28', N'6', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'29', N'7', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'30', N'9', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'31', N'10', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'32', N'11', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'33', N'12', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'34', N'13', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'35', N'15', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'36', N'16', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'37', N'2', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'38', N'3', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'39', N'4', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'40', N'6', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'41', N'7', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'42', N'9', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'43', N'10', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'44', N'11', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'45', N'12', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'46', N'13', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'47', N'15', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'48', N'16', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'49', N'2', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'50', N'3', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'51', N'4', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'52', N'6', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'53', N'7', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'54', N'9', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'55', N'10', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'56', N'11', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'57', N'12', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'58', N'13', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'59', N'15', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'60', N'16', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'61', N'2', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'62', N'3', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'63', N'4', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'64', N'6', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'65', N'7', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'66', N'9', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'67', N'10', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'68', N'11', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'69', N'12', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'70', N'13', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'71', N'15', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'72', N'16', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'73', N'2', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'74', N'3', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'75', N'4', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'76', N'6', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'77', N'7', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'78', N'9', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'79', N'10', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'80', N'11', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'81', N'12', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'82', N'13', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'83', N'15', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'84', N'16', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'85', N'2', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'86', N'3', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'87', N'4', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'88', N'6', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'89', N'7', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'90', N'9', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'91', N'10', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'92', N'11', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'93', N'12', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'94', N'13', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'95', N'15', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'96', N'16', N'06371309');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'97', N'2', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'98', N'3', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'99', N'4', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'100', N'6', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'101', N'7', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'102', N'9', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'103', N'10', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'104', N'11', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'105', N'12', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'106', N'13', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'107', N'15', N'1272');
GO
INSERT INTO [dbo].[subzh_pre_menu] ([id], [pmid], [subzh]) VALUES (N'108', N'16', N'1272');
GO
SET IDENTITY_INSERT [dbo].[subzh_pre_menu] OFF
GO

-- ----------------------------
-- Indexes structure for table subzh_pre_menu
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[subzh_pre_menu]
-- ----------------------------
ALTER TABLE [dbo].[subzh_pre_menu] ADD PRIMARY KEY ([id])
GO

/***************************************************************************************/
/*
子账户角色表
*/
-- ----------------------------
-- Table structure for [dbo].[subzh_role]
-- ----------------------------
DROP TABLE [dbo].[subzh_role]
GO
CREATE TABLE [dbo].[subzh_role] (
[id] int NOT NULL IDENTITY(1,1) ,
[subzh] varchar(32) NOT NULL ,
[roleid] int NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[subzh_role]', RESEED, 6)
GO

-- ----------------------------
-- Records of subzh_role
-- ----------------------------
SET IDENTITY_INSERT [dbo].[subzh_role] ON
GO
INSERT INTO [dbo].[subzh_role] ([id], [subzh], [roleid]) VALUES (N'1', N'06371309', N'3');
GO
INSERT INTO [dbo].[subzh_role] ([id], [subzh], [roleid]) VALUES (N'6', N'1272', N'4');
GO
SET IDENTITY_INSERT [dbo].[subzh_role] OFF
GO

-- ----------------------------
-- Indexes structure for table subzh_role
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table [dbo].[subzh_role]
-- ----------------------------
ALTER TABLE [dbo].[subzh_role] ADD PRIMARY KEY ([id], [subzh])
GO
