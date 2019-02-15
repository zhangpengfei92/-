<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <title>H+ 后台主题UI框架 - 数据表格</title>
    <jsp:include page="${path}/commons/commons.jsp"></jsp:include>
</head>

<body class="gray-bg">
   	<table class="layui-hide" id="test" lay-filter="test"></table>

</body>

<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  </div>
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/javascript">
layui.use('table', function(){
	//alert('${ulist}');
	layer.alert('${ulist}')
  var table = layui.table; 
  table.render({
    elem: '#test'
    ,url:'${path}/useraction/queryUser'
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    ,totalRow: true
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'uid', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计'}
      ,{field:'username', title:'用户名', width:120, edit: 'text'}
      ,{field:'phone', title:'手机号', width:150, edit: 'text', templet: function(res){
        return '<em>'+ res.email +'</em>'
      }}
      ,{field:'address', title:'地址', width:80, sort: true, totalRow: true}
      ,{field:'age', title:'年龄', width:80, edit: 'text', sort: true}
      ,{field:'sex', title:'性别', width:100, sort: true, totalRow: true}
      ,{field:'password', title:'密码'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    }
  });
  
  })
  
</script>
</html>