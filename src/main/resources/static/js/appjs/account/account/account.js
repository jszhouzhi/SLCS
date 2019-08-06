
var prefix = "/account/account"
$(function() {
	load();
	//good test morning
});
$('#exampleTable').on('load-success.bs.table', function (e, data) {
    if (data.total && !data.rows.length) {
        $('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
    }
});

layui.use('form', function(){
	  var form = layui.form;
	  
	  var users = $.cookie("onlyDeductions") || '';
	  if(users == '')
		  $('#isDeductions').remove('checked');
	  else
		 $('#isDeductions').attr('checked','checked');

	  form.on('checkbox(checkDeductionsUsers)', function(data){
		  var users = data.elem.checked ? '1' : '';
		  $.cookie("onlyDeductions", users);
	  });  
	  form.render();
	  
	});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
								searchName:$('#searchName').val(),
                                merchantCode:$('#merchantCode').val(),
								state:$('#state').val(),
								vipMemberID:$('#vipMemberID').val(),
								deductions:$.cookie("onlyDeductions") || ''
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
 
							{
								field : 'merchantcode', 
								align : 'center',
								title : '商户' 
							},
								{
									field : 'accountno', 
									align : 'center',
									title : '账号' 
								},
																{
									field : 'accountTypeName', 
									align : 'center',
									title : '账户类型' 
								},
																{
									field : 'stateName', 
									align : 'left',
									title : '账户状态' 
								},
								{
									field : 'openId', 
									align : 'center',
									title : 'openId',
									cellStyle:formatTableUnit,
									formatter :paramsMatter
								},
																{
									field : 'mobilephone', 
									align : 'center',
									title : '手机号码' 
								},
																{
									field : 'createddate', 
									align : 'center',
									title : '注册时间' 
								},
																{
									field : 'balance', 									
									title : '账户余额',
									align:'right',
									formatter : function(value, row, index) {
										if(value) {
                                            return value.toFixed(2);
										}else {
                                            return '-';
										}
									}
								},
                            								  {
									field : 'freebalance',
									title : '赠送余额',
									align:'right',
									formatter : function(value, row, index) {
                                        if(value) {
                                            return value.toFixed(2);
                                        }else {
                                            return '-';
                                        }
                               		 }
                           		 },
																{
									field : 'lastdebittime', 
									title : '最后消费时间',
									align : 'center',
									formatter: function(value){
										if(value=='1900-01-01 00:00:00'){
											return '-';
										}else{
											return value;
										}
									}
								},
																{
									field : 'lastdebitamount', 
									title : '最后消费金额',
									align:'right',
									formatter : function(value, row, index) {
										return value.toFixed(2);
									}
								},
								
								{
									field : 'vipMemberID', 
									title : '是否VIP',
									align:'center',
									formatter : function(value, row, index) {
										if(row.vipMemberID!=null){
											return "VIP"
										}else{
											return "-"
										}
									}
								},
								
								{
									field : 'vipExpireDateTime', 
									title : 'VIP过期时间',
									align:'center',
									formatter: function(value){
										if(value=='1900-01-01 00:00:00'){
											return '-';
										}else{
											return value;
										}
									}
								},
								
								{
									field : 'signing', 
									title : '免密支付',
									align:'center',
									formatter : function(value, row, index) {
										if(value==null){
											return '<span class="label label-default">未签约</span>';
										}else{
											return '<span class="label label-success">已签约</span>';
										}
									}
								},
								
						/*										{
									field : 'certphotourl', 
									align : 'center',
									title : '身份证正面照' ,
									formatter : function(value, row, index) {
										var imgurl;
							
										row.certphotourl==""? imgurl="../img/null.jpg" : imgurl=row.certphotourl;
										
									var e = '<a href="#" mce_href="#" onclick="showimg(\''
										+ imgurl
										+ '\')">点击查看</a> ';
									return e;
									}
								},
																{
									field : 'personphotourl', 
									align : 'center',
									title : '个人照', 
									formatter : function(value, row, index) {
										var imgurl;
										
										row.certphotourl==""? imgurl="../img/null.jpg" : imgurl=row.certphotourl;
										
										var p = '<a href="#" mce_href="#" onclick="showimg(\''
											+ imgurl
											+ '\')">点击查看</a> ';
										return p;
										}
								},*/
																{
									title : '操作',
									field : 'dealresult',
									align : 'center',
									formatter : function(value, row, index) {
										/*	var e = '<a class="btn btn-primary btn-sm '+s_deal_h+'" href="#" mce_href="#" title="审核" onclick="deal(\''
													+ row.id
													+ '\')"><i class="fa fa-edit"></i></a> ';*/
										
										if(row.balance>0){
											var r = '<button class="layui-btn layui-btn-sm'+s_g_h+'" type="button" onclick="refund(\''+ row.accountno													
											+ '\')">退款</button> ';	
										}else{
											r="";
										}

										
										if(row.stateName=='审核通过'){
										/*	var z = '<button class="layui-btn layui-btn-sm'+s_g_h+'" type="button" onclick="operation(\''+ row.accountno													
											+ '\',-3)">注销</button> ';*/
											var g = '<button class="layui-btn layui-btn-sm'+s_g_h+'" type="button" onclick="operation(\''+ row.accountno													
											+ '\',-1)">挂失</button> ';
											return g+r ;
										}
										if(row.stateName=='锁定'){
											var j = '<button class="layui-btn layui-btn-sm'+s_g_h+'" type="button" onclick="operation(\''+ row.accountno													
											+ '\',1)">解锁</button> ';	
											return j+r ;
										}
 
									}
								},
								
								{
									title : '特种卡审核',
									field : 'subAccountStateName',
									align : 'center',
									formatter : function(value, row, index) {
							/*			if(row.subAccountStateName=='待审核'){
											var s = '<button class="layui-btn layui-btn-sm'+s_g_h+'" type="button" onclick="operation(\''+ row.accountno	
											+ '\',11)">审核</button> ';												
											
											return s ;
										}else{
											return row.subAccountStateName;
										} */
										if (value == '待审核') {
											var s = '<button class="layui-btn layui-btn-sm'+s_g_h+'" type="button" onclick="operation(\''+ row.accountno	
											+ '\',11)">审核</button> ';		
											return s;
										} else if (value == '审核不通过') {
											return '<span class="label label-danger">审核不通过</span>';
										}else if(value=='审核通过'){
											return '<span class="label label-success">审核通过</span>';
										}else{
											return '<span class="label label-default">未申请</span>';
										}
									}
								}
								]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

//表格超出宽度鼠标悬停显示td内容
function paramsMatter(value,row,index, field) {	
	var span=document.createElement('span');
	span.setAttribute('title',value);
	span.innerHTML = value;
	return span.outerHTML;
}
//td宽度以及内容超过宽度隐藏
function formatTableUnit(value, row, index) {
	return {
		css: {
		"white-space": 'nowrap',
		"text-overflow": 'ellipsis',
		"overflow": 'hidden',
		"max-width":'90px'
		}
	}
}

function excel(){
	var searchName = $("#searchName").val();
	var astate = $("#state").val();
	var merchantCode = $('#merchantCode').val();
	
	layer.confirm('您确定导出吗？', {
		  btn: ['是','否']
	}, function(){
		window.location.href= prefix + '/expexcel?searchName=' + searchName + '&state=' + astate + '&merchantCode=' + merchantCode;
		layer.closeAll('dialog');
	}, function(){
	});
}

function showimg(url) {
    layer.open({
        type: 1,
        title: false, //不显示标题
        //skin: 'layui-layer-rim', //加上边框
        area: ['640px', '435px'], //宽高
        content: '<div style="padding:0px 0px;"><img src="'+ url + '"/></div>'
    });

}
function refund(accountno){
	 var perContent = layer.open({
         type:2,
         title: '退款',
         content : prefix + '/refund/' + accountno,
         area: ['700px', '410px'],
         maxmin: false,            //最大化按钮
         anim:4,                    //动画
         shade: [0.8, '#393D49'],//遮罩层
         end: function(){
             
         }
     });
   //layer.full(perContent);  //全屏
}
function operation(accountno,operationType) {
	/*alert(operationType);*/
	if(operationType==-3){
		layer.confirm('您确认要注销该账号吗？', {
			btn : [ '确定', '取消' ]
		}, function() {
			$.ajax({
				url : "/account/account/operation",
				type : "post",
				data : {
					'accountno' : accountno,
					'operationType' : "-3"
				},
				success : function(r) {
					if (r.code == 0) {
						layer.msg(r.msg);
						reLoad();
					} else {
						layer.msg(r.msg);
					}
				}
			});
		})
	}
	if(operationType==-1){
		layer.confirm('您将对该账号进行挂失？', {
			btn : [ '确定', '取消' ]
		}, function() {
			$.ajax({
				url : "/account/account/operation",
				type : "post",
				data : {
					'accountno' : accountno,
					'operationType' : "-1"
				},
				success : function(r) {
					if (r.code == 0) {
						layer.msg(r.msg);
						reLoad();
					} else {
						layer.msg(r.msg);
					}
				}
			});
		})
	}
	if(operationType==1){
		layer.confirm('您将解锁该账号？', {
			btn : [ '确定', '取消' ]
		}, function() {
			$.ajax({
				url : "/account/account/operation",
				type : "post",
				data : {
					'accountno' : accountno,
					'operationType' : "1"
				},
				success : function(r) {
					if (r.code == 0) {
						layer.msg(r.msg);
						reLoad();
					} else {
						layer.msg(r.msg);
					}
				}
			});
		})
	}
	if(operationType==11){
		 
/*		layer.open({
			type : 2,
			title : '账户注销审核',
			maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '560px' ],
			content : prefix + '/deal/' + id // iframe的url
		});*/
	 var perContent = layer.open({
            type:2,
            title: '人工审核',
            content : prefix + '/deal/' + accountno,
            area: ['700px', '250px'],
            maxmin: false,            //最大化按钮
            anim:3,                    //动画
            shade: [0.8, '#393D49'],//遮罩层
            end: function(){
                
            }
        });
      layer.full(perContent);
		
		
		
		
		
/*		layer.confirm('确认通过审核？', {
			btn : [ '确定', '取消' ]
		}, function() {
			$.ajax({
				url : "/account/account/operation",
				type : "post",
				data : {
					'accountno' : accountno,
					'operationType' : "1"
				},
				success : function(r) {
					if (r.code == 0) {
						layer.msg(r.msg);
						reLoad();
					} else {
						layer.msg(r.msg);
					}
				}
			});
		})*/
	}
}



