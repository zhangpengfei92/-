<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${path}/js/layer/layer.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	
	<c:if test="${status gt 0 }">
		<c:if test="${status eq 3 }">
			<h1>查询用户信息条件中必须有交易用户</h1>
		</c:if>
	
	</c:if>		
	<c:if test="${status eq 0 }">
			<div class="mtable">
                <table width="100%;" >
                          <tr class="tit">
						<td >序号</td>
						<td >用户账户</td>
						<td >用户姓名</td>
						<td >所属渠道</td>
						<td >所属代理商</td>
						<td >所属经纪人</td>
						<td >合约代码</td>
						<td >合约名称</td>
						<td >方向</td>
						<td >总持仓</td>
						<c:if test="${empty lsflag or lsflag eq 1}">
							<!-- <td >昨仓</td>
							<td >今仓</td> -->
							<td >可平量</td>
						</c:if>
						<td >持仓均价</td>   
						<td >持仓盈亏</td>
						<td >操作</td>
					</tr>
                     	<c:forEach items="${page.list}" var="holder" varStatus="st">
						<tr>
						<input type="hidden" id="client_id_${st.count}"  name="client_id" value="${holder.sub_zh}">
						<input type="hidden" id="stock_code_${st.count}"  name="stock_code"  value="${holder.code}">
						<input type="hidden"  id="exchange_type_${st.count}"  name="exchange_type" value="${holder.mark}">
						<input type="hidden"  id="entrust_bs_${st.count}"  name="entrust_bs" value="${holder.bs_type}">
						<input type="hidden"  id="entrust_vol_${st.count}"  name="entrust_vol" value="${holder.sell_vol}">
							<td>${st.count}</td>
							<td>${holder.sub_zh}</td>
							<td>${holder.username}</td>
							<td>${holder.channel}</td>
							<td>${holder.agentzh}</td>
							<td>${holder.broker}</td> 
							<td>${holder.code}</td>
							<td>${holder.name}</td>
							<td>${holder.agent}</td>
							<td>${holder.position_vol}</td>
							<c:if test="${empty lsflag or lsflag eq 1}">
								<%-- <td>${holder.history_vol}</td>
								<td>${holder.today_vol}</td> --%>
								<td>${holder.sell_vol}</td>
							</c:if>
							<td> <fmt:formatNumber type="number" value="${holder.price}" maxFractionDigits="2"/></td>
							<td> <fmt:formatNumber type="number" value="${holder.profit}" maxFractionDigits="2"/></td>
							<td><a onclick="ringout(${st.count})" style="cursor: pointer;">平仓</a></td>
						</tr>
					</c:forEach>
					<tr id="currhodertable">
					</tr>
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
		
		<script type="text/javascript" >
		$(function(){
			getTotalHoder();
		});
		
		function getTotalHoder() {
			var formdate=autoForm ();
			 var html='';
			$.post("${path}/trade/getTotalHoder",formdate,function(data){
				if(data !=null ){
					html=html+"<td>合计:</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>"+data.position_vol.toFixed(2)+"</td><td>"+data.sell_vol.toFixed(2)+"</td><td></td><td>"+data.profit.toFixed(2)+"</td><td></td>";
				}else{
					html=html+"<td>合计:</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>";	
				}
				$("#currhodertable").html("");	
				$("#currhodertable").html(html);
			})
		}
		
		function freshHoder() {
			var formdate=autoForm ();
			$("#seachspan").show();//显示div
			$("#buttonSpan").show();//显示div
			url="${path}/trade/getDrHolder";
			$("#loadtable").load(url,formdate,function(){ $("#loadtable").fadeIn(100);});
		}
		
		function autoForm () {
			var array = new Array();  //定义数组 
		     $("#subzh option").each(function(){  //遍历所有option
		          var txt = $(this).val();   //获取option值 
		          if(txt!=''){
		               array.push(txt);  //添加到数组中
		          }
		     })
		     $("#subzhs").val(array);
		     var formdate=$("#frm").serializeArray();
		     return formdate;
		}
		
		function ringout(index) {
			var formdate=autoForm ();
			var client_id=$("#client_id_"+index).val();
			var stock_code=$("#stock_code_"+index).val();
			var exchange_type=$("#exchange_type_"+index).val();
			var entrust_bs=parseInt($("#entrust_bs_"+index).val());
			var entrust_vol=parseInt($("#entrust_vol_"+index).val());
			layer.confirm('确定要强平吗?', { btn : [ '确定', '取消' ]},function(index){
				 layer.close(index);
				 var index = layer.load(0,{shade: [0.7, '#393D49']}, {shadeClose: true});
			$.post("${path}/trade/ringout",{"client_id":client_id,"stock_code":stock_code,"exchange_type":
				exchange_type,"entrust_bs":entrust_bs,"entrust_vol":entrust_vol},function(data){
					layer.close(index);
					if(data.status==0){
					$.messager.alert('提示', "强平成功!", 'info');
				}else if(data.status==1){
					$.messager.alert('提示', data.describe, 'info');
				}else{
					$.messager.alert('提示', "强平失败", 'info');
				}
					freshHoder();
				})
			 })
		}
		</script>
