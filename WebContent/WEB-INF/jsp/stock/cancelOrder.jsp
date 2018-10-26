<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">

</script>
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">撤单</div>
        <div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>
    </header>
    <div class="mainbox">
         <section>
             <div class="Tradebox">
                 <ul class="Tnum">
                    <li>总资产：<span>${userinfo.rzj}</span></li>
                    <li>可用资产：<span>${userinfo.xzj + userinfo.bzj}</span></li>
                 </ul>
                 <ul class="Ttab">
                     <li><a href="javascript:;" onclick="xj()">询价</a></li>
                     <li><a href="javascript:;" onclick="rg()">认购</a></li>
<!--                      <li><a href="javascript:;" class="on" onclick="cd()">撤单</a></li> -->
                     <li><a href="javascript:;" onclick="cc()">持仓</a></li>
                     <li><a href="javascript:;" onclick="js()">结算</a></li>
                 </ul>
                 <ul class="Cdbox">
                     <li>
                        <h3><p><span>2015.07.03</span><span>13:48:39</span></p><em>撤单</em></h3>
                        <table width="100%;" class="Cdtable">
                           <tr>
                              <td>武钢股份<span>(600005)</span></td>
                              <td class="tpadd"><span>权利金：</span>10.3%</td>
                              <td><span>周期：</span>(10周)</td>
                           </tr>
                           <tr>
                              <td><span>名义本金：</span>20万</td>
                              <td class="tpadd"><span>到期时间：</span>2017.10.30</td>
                           </tr>
                        </table>
                     </li>
                     <li>
                        <h3><p><span>2015.07.03</span><span>13:48:39</span></p><em class="Gbut">已成</em></h3>
                        <table width="100%;" class="Cdtable">
                           <tr>
                              <td>武钢股份<span>(600005)</span></td>
                              <td class="tpadd"><span>权利金：</span>10.3%</td>
                              <td><span>周期：</span>(10周)</td>
                           </tr>
                           <tr>
                              <td><span>名义本金：</span>20万</td>
                              <td class="tpadd"><span>到期时间：</span>2017.10.30</td>
                           </tr>
                        </table>
                     </li>
                     <li>
                        <h3><p><span>2015.07.03</span><span>13:48:39</span></p><em>撤单</em></h3>
                        <table width="100%;" class="Cdtable">
                           <tr>
                              <td>武钢股份<span>(600005)</span></td>
                              <td class="tpadd"><span>权利金：</span>10.3%</td>
                              <td><span>周期：</span>(10周)</td>
                           </tr>
                           <tr>
                              <td><span>名义本金：</span>20万</td>
                              <td class="tpadd"><span>到期时间：</span>2017.10.30</td>
                           </tr>
                        </table>
                     </li>
                 </ul>
             </div>
        </section> 
        <%@include file="../../../foot.jsp"%>        
  </div>
</body>
</html>