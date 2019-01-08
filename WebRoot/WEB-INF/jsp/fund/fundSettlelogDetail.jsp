<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td width="5%">序号</td>
								<td>用户账户</td>
								<td>所属渠道</td>
								<td>所属代理商</td>
								<td>所属经纪人</td>
								<td>合约代码</td>
								<td>合约名称</td>
								<td>方向</td>
								<td>开平</td>
								<td>数量</td>
								<td>成交时间</td>
								<td>手续费总额</td>
								<c:if test="${sessionScope.SESSION_ISADMIN < 4}"><td>渠道存留手续费</td></c:if>
								<c:if test="${sessionScope.SESSION_ISADMIN < 5}"><td>代理商存留手续费</td></c:if>
								<td>经纪人存留手续费</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td>${user.subzh}</td>
									<td>${user.allocchannel}</td>
									<td>${user.agentzh}</td>
									<td>${user.allocbroker}</td>
									<td>${user.name}</td>
									<td>${user.settledesc}</td>
									<td>
										<c:choose>
											<c:when test="${user.stockbalance<0.1}">买入</c:when>
											<c:when test="${user.stockbalance>0.9}">卖出</c:when>
										</c:choose>
									</td>
									<td>
										<c:choose>
											<c:when test="${user.registnum==0}">开仓</c:when>
											<c:when test="${user.registnum==1}">平仓</c:when>
											<c:when test="${user.registnum==2}">平今</c:when>
											<c:when test="${user.registnum==3}">平昨</c:when>
										</c:choose>
									</td>
									<td><fmt:formatNumber value="${user.feebalance}" pattern="#" type="number"/></td>
									<td><fmt:formatDate value="${user.createtime}" type="both"/></td>
									<td><fmt:formatNumber value="${user.deferredbalance}" pattern="#.##" type="number"/></td>
									<c:if test="${sessionScope.SESSION_ISADMIN < 4}"><td><fmt:formatNumber value="${user.feenextbalance}" pattern="#.##" type="number"/></td></c:if>
									<c:if test="${sessionScope.SESSION_ISADMIN < 5}"><td><fmt:formatNumber value="${user.addbalance}" pattern="#.##" type="number"/></td></c:if>
									<td><fmt:formatNumber value="${user.overbalance}" pattern="#.##" type="number"/></td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				<div class="page">
							<c:choose>
									<c:when test="${userpage.pages==0}">0/${userpage.pages}</c:when>
									<c:otherwise>${userpage.pageNum}/${userpage.pages}</c:otherwise>
								</c:choose> 共<i>${userpage.pages}</i>页
							<a class="bs" href="javascript:;" onclick="serach('1')">首页</a>
							<input type="hidden" value="${userpage.pages}" id="pages" />
							<c:if test="${userpage.pageNum!=1}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.prePage}')">上一页</a>
							</c:if>
							<c:if test="${userpage.pageNum!=userpage.pages}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.nextPage}')">下一页</a>
							</c:if>
							<a class="bs" href="javascript:;" onclick="serach('${userpage.pages}')">尾页</a>
							<a ><input type="text" id="pageNum" value="${userpage.pageNum}" style="height: 30px;line-height: 30px;padding: 0 5px;"/></a>
							<a style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
						</div>
                   
      