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
						<td >市场</td>
						<td >合约代码</td>
						<td >合约名称</td>
						<td >方向</td>
						<td >开平</td>
						<td >状态</td>
						<td >委托价格</td>
						<td >委托数量</td>
						<td >已成数量</td>
						<td >成交均价</td>
						<td >下单时间</td>
					</tr>
                     	<c:forEach items="${page.list}" var="entrust" varStatus="st">
						<tr>
							<td>${(page.pagenum-1)*page.pagesize + st.count}</td>
							<c:if test="${not empty lsflag and lsflag eq 2}">
								<td>${entrust.entime}</td>
							</c:if>
							<td>${entrust.subzh}</td>
							<td>${entrust.username}</td>
							<td>${entrust.channelname}</td>
							<td>${entrust.agentname}</td>
							<td>${entrust.brokername}</td>
							<td>
								<c:if test="${entrust.exchangeType eq 24}">
									上海国际能源交易中心
								</c:if>
								<c:if test="${entrust.exchangeType eq 0}">
									深圳证券交易所
								</c:if>
								<c:if test="${entrust.exchangeType eq 1}">
									上海证券交易所
								</c:if>
								<c:if test="${entrust.exchangeType eq 15}">
									国际期货交易市场
								</c:if>
								<c:if test="${entrust.exchangeType eq 3}">
									中国金融期货交易所
								</c:if>
								<c:if test="${entrust.exchangeType eq 4}">
									上海期货交易所
								</c:if>
								<c:if test="${entrust.exchangeType eq 5}">
									大连商品交易所
								</c:if>
								<c:if test="${entrust.exchangeType eq 6}">
									郑州商品交易所
								</c:if>
								<c:if test="${entrust.exchangeType eq 16}">
									香港期货交易所
								</c:if>
							</td>
							<td>${entrust.stockCode}</td>
							<td>${entrust.stockName}</td>
							<td>${entrust.entrustBs eq 1 ? '卖出' : '买入'}</td>
							<td>
								<c:if test="${entrust.directionType eq 0}">
									开仓
								</c:if>
								<c:if test="${entrust.directionType eq 1}">
									平仓
								</c:if>
								<c:if test="${entrust.directionType eq 2}">
									平今
								</c:if>
								<c:if test="${entrust.directionType eq 3}">
									平昨
								</c:if>
							</td>
							<td>${entrust.eno}</td>
							<td>${entrust.entrustPrice}</td>
							<td><fmt:formatNumber type="number" value="${entrust.entrustVol}" maxFractionDigits="0"/> </td>
							<td><fmt:formatNumber type="number" value="${entrust.businessVol}" maxFractionDigits="0"/> </td>
							<td>${entrust.businessPrice}</td>
							<td>${entrust.dealtime}</td>
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
