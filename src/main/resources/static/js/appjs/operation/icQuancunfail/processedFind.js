
var prefix = "/operation/icQuancunfail"
$(function() {
	load();
});
$('#exampleTable').on('load-success.bs.table', function (e, data) {
    if (data.total && !data.rows.length) {
        $('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
    }
});

layui.use(['form'], function() {
	form=layui.form;
	form.on('select(setdate)', function(data){   
	//var val=data.value;
	//console.info(val);
	$('#exampleTable').bootstrapTable('refresh');
	});
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/processedFind_list", // 服务器数据的加载地址
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
								merchantCode : $('#merchantCode').val(),
								sdate : $('#sdate').val(),
								edate : $('#edate').val(),
								rState:$('#rState').val()
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
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
										field : 'merchantCode',
										title : '商户',
										align:'center'
									},
									{
										field : 'cardno', 
										align : 'center',
										title : '卡号' 
									},	
									{
										field : 'orderno', 
										align : 'center',
										title : '订单号' 
									},

									{
										field : 'txnamount', 										
										title : '交易金额',
										align:'right',
										formatter : function(value, row, index) {
											if(value!=null){
												return value.toFixed(2);
											}
										}
									},	
									{
										field : 'balance', 
										title : '余额',
										align:'right',
										formatter : function(value, row, index) {
											if(value!=null){
												return value.toFixed(2);
											}
										}
									},
								
									{
										field : 'loadstate', 
										align : 'left',
										title : '状态' ,
										formatter: function(value){
											if(value=='0'){
												return '圈存失败';
											}else if(value=='1'){
												return '圈存成功';
											}

											
/*											if(value=='4'){
												return '锁定';
											}else if(value=='5'){
												return '圈存失败';
											}else if(value=='6'){
												return '圈存成功';
											}else if(value=='7'){
												return '已退款';
											}else if(value=='1'){
												return '未支付';
											}else if(value=='2'){
												return '支付成功';
											}else if(value=='3'){
												return '支付失败';
											}else if(value=='-1'){
												return '待审核';
											}*/
										}
									},
									{
										field : 'loaddescribe', 
										align : 'left',
										title : '描述' 
									},
									{
										field : 'reviewtime', 
										align : 'center',
										title : '审核时间' 
									},
									{
										field : 'reviewUserName', 
										align : 'center',
										title : '审核人' 
									},
									{
										field : 'loadbackdate', 
										align : 'center',
										title : '交易时间' 
									},
									
									{
										field : 'paytime', 
										align : 'center',
										title : '支付时间' 
									},
										
									{
										field : 'terminalno', 
										align : 'center',
										title : '自助终端编号' 
									}  ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function excel(){
	var searchName = $("#searchName").val();
	var merchantCode = $("#merchantCode").val();
	var rState = $("#rState").val();
	layer.confirm('您确定导出吗？', {
		  btn: ['是','否']
	}, function(){
		window.location.href= prefix + '/processed_expexcel?searchName=' + searchName + '&merchantCode=' + merchantCode + '&sdate=' + $('#sdate').val() + '&edate=' + $('#edate').val() + '&rState=' + rState;
		layer.closeAll('dialog');
	}, function(){
	});
}

 