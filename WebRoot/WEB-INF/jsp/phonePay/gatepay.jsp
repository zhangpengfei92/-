<%@ page import="org.apache.commons.lang3.RandomStringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>网关支付</title>
</head>
<body>
<form action="<%=basePath%>subzhfund/payment" method="post">
<table width="100%" cellpadding="2" cellspacing="1" border="0" align="center" bgcolor="#DDDDDD">
    <tr>
        <td class="head" height="24" colspan="2">网关支付</td>
    </tr>
    <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>订单号:</td>
        <td width="*" class="content">
            <input type="text" name="txSN" size="40" value="<%=RandomStringUtils.randomNumeric(24) %>"/>
        </td>
    </tr>
    <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>订单金额(分):</td>
        <td width="*" class="content">
            <input type="text" name="tranAmt" size="40" value="200"/>
        </td>
    </tr>
    <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>账户类型:</td>
        <td width="*" class="content">
            <select id="accountType" name="accountType" style="width: 274">
                <option value="11">个人账户</option>
                <option value="12">企业账户</option>
            </select>
        </td>
    </tr>

    <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>产品信息:</td>
        <td width="*" class="content">
            <input type="text" name="prodInfo" size="40" value="IPhone8"/>
        </td>
    </tr>
    <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>资金用途:</td>
        <td width="*" class="content">
            <input type="text" name="usage" size="40" value="网上购物支付"/>
        </td>
    </tr>
   <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>同步跳转地址:</td>
        <td width="*" class="content">
            <input type="text" name="returnURL" placeholder="同步跳转地址"/>
        </td>
    </tr>
      <tr class="mouseout">
        <td width="120" class="label" height="24"><font color="red">*</font>异步通知地址</td>
        <td width="*" class="content">
            <input type="text" name="notificationURL" placeholder="异步通知地址"/>
        </td>
    </tr>
    <tr class="mouseout">
        <td colspan="2">
            <button type="submit">提交</button>
        </td>
    </tr>
</table></form>
</body>
</html>