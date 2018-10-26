<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	
	<c:if test="${status gt 0 }">
		<c:if test="${status eq 3 }">
			<h1>查询用户信息条件中必须有交易用户</h1>
		</c:if>
	
	</c:if>		
	<c:if test="${status eq 0 }">
			<div class="mtable">
                <table width="100%;">
                          <tr class="tit">
						<td >序号</td>
						<c:if test="${not empty lsflag and lsflag eq 2}">
							<td>日期</td>
						</c:if>
						<td >用户账户</td>
						<td >用户姓名</td>
						<td >所属渠道</td>
						<td >所属代理商</td>
						<td >所属经纪人</td>
						<c:if test="${empty lsflag or lsflag eq 1}">
							<td >静态权益</td>
							<td >动态权益</td>
							<td >持仓盈亏</td>
						</c:if>
						<c:if test="${not empty lsflag and lsflag eq 2}">
							<td >当日结存</td>
							<td >出金</td>
							<td >入金</td>
						</c:if>
						<td >占用保证金</td>
						<td >冻结保证金</td>
						<c:if test="${empty lsflag or lsflag eq 1}">
							<td >可用资金</td>
						</c:if>
						<td >手续费总额</td>
						<c:if test="${not empty lsflag and lsflag eq 2}">
							<td >平仓盈亏</td>
						</c:if>
						
						<td >风险率</td>
					</tr>
                     	<c:forEach items="${page.list}" var="fund" varStatus="st">
						<tr>
							<td>${(page.pagenum-1)*page.pagesize + st.count}</td>
							<c:if test="${not empty lsflag and lsflag eq 2}">
								<td>${fund.settleTime }</td>
							</c:if>
							<td>${fund.subzh}</td>
							<td>${fund.username}</td>
							<td>${fund.channelname}</td>
							<td>${fund.agentname}</td>
							<td>${fund.brokername}</td>
							<c:if test="${empty lsflag or lsflag eq 1}">
								<td>${fund.preFundBalance}</td>
								<td>${fund.fundBalance}</td>
								<td>${fund.totalFloatprofit}</td>
							</c:if>
							<c:if test="${not empty lsflag and lsflag eq 2}">
							<td> <fmt:formatNumber type="number" value="${fund.preFundBalance}" maxFractionDigits="2"/></td>
								<td >${fund.outcomingBalance }</td>
								<td >${fund.incomingBalance }</td>
							</c:if>
							<td>${fund.freezeBalance}</td>
							<td>${fund.sell_freeze_balance}</td>
							<c:if test="${empty lsflag or lsflag eq 1}">
								<td>${fund.enableBalance}</td>
							</c:if>
							<td>${fund.fee}</td>
							<c:if test="${not empty lsflag and lsflag eq 2}">
							<td> <fmt:formatNumber type="number" value="${fund.totalCloseprofit}" maxFractionDigits="2"/></td>
							</c:if>
							<td>${fund.rate}%</td>
						</tr>
					</c:forEach>
				</table>
 				</div>
 				<div class="page">
					<c:choose>
							<c:when test="${empty page.pagecount || page.pagecount==0}">0/0</c:when>
							<c:otherwise>${page.pagenum}/${page.pagecount}</c:otherwise>
						</c:choose> 共<i>${empty page.pagecount ? 0 : page.pagecount}</i>页
					<a class="bs" href="javascript:;" onclick="serach('1')">首页</a>
					<input type="hidden" value="${page.pagecount}" id="pages" />
					<c:if test="${page.pagenum!=1}">
						<a class="bs" href="javascript:;" onclick="serach('${page.pagenum-1}')">上一页</a>
					</c:if>
					<c:if test="${page.pagenum!=page.pagecount}">
						<a class="bs" href="javascript:;" onclick="serach('${page.pagenum+1}')">下一页</a>
					</c:if>
					<a class="bs" href="javascript:;" onclick="serach('${page.pagecount}')">尾页</a>
					<a ><input type="text" id="pageNum" value="${page.pagenum}" style="height: 30px;line-height: 30px;padding: 0 5px;"/></a>
					<a style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
				</div>
				
		</c:if>
		
		<script type="text/javascript">
			
		</script>