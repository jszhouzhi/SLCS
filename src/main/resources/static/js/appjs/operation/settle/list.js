var prefix = "/operation/settle"
$(function() {
	var Id = '';
	load(Id);
});
$('#exampleTable').on('load-success.bs.table', function (e, data) {
    if (data.total && !data.rows.length) {
        $('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
    }
});

function load(Id) {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "/api/list", // 服务器数据的加载地址
				// showRefresh : true,
				// showToggle : true,
				// showColumns : true,
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
				// search : true, // 是否显示搜索框
				showColumns : false, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
				// "server"
				queryParams : function(params) {
					return {
						// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
						limit : params.limit,
						offset : params.offset,
						searchvalue : $('#searchName').val(),
						settletype:$('#settletype').val(),
						checktype:$('#checktype').val(),
						transstatus:$('#transstatus').val(),
						datetype:$('#datetype').val(),
                        merchantCode:$('#merchantCode').val(),
						sdate:$('#sdate').val(),
						edate:$('#edate').val(),
						settleType:$('#settleType').val()
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
						field : 'merchantName',
						title : '商户名称',
						valign:'middle',
						align:'left'
					},
					{
						field : 'settleType',
						title : '类型',
						valign:'middle',
						align:'center'
					},			
					{
						field : 'settleFromDate',
						title : '结算开始</br>日期',
						align:'center'
					},
					{
						field : 'settleEndDate',
						title : '结算结束</br>日期',
						align:'center'
					},
					
/*					{
						field : 'summaryDateTime',
						title : '日结日期',
						align:'center'
					},*/

					{
						field : 'topupAmount',
						title : '总充值</br>金额',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},

					{
						field : 'platformTopupAmount',
						valign:'middle',
						title : '平台充值',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					{
						field : 'platformRefundAmount',
						valign:'middle',
						title : '平台退款',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					{
						field : 'noPlatformTopupAmount',
						title : '非平台</br>充值',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					{
						field : 'noPlatformRefundAmount',
						title : '非平台</br>退款',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					

					
					{
						field : 'debitAmount',
						valign:'middle',
						title : '消费金额',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					{
						field : 'debitNum',
						valign:'middle',
						title : '消费笔数',
						align:'center'
					},
					{
						field : 'refundAmount',
						valign:'middle',
						title : '账户退款',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								//return value.toFixed(2);
								if(row.settleType=='二维码' && row.orderRefundAmount > 0){
									return row.orderRefundAmount.toFixed(2)
								}else{
									return value.toFixed(2);
								}
							}
						}
					},
					{
						field : 'refundNum',
						title : '账户退款</br>笔数',
						align:'center',
						formatter : function(value, row, index) {
							if(value!=null){
								//return value.toFixed(2);
								if(row.settleType=='二维码' && row.orderRefundAmount > 0){
									return row.orderRefundNum
								}else{
									return value;
								}
							}
						}
					},
					{
						field : 'refundServiceFee',
						title : '账户退款</br>服务费',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
/*								if(row.settleType=='二维码' && row.orderRefundAmount > 0){
									return row.orderRefundFee.toFixed(2)
								}else{
									return value.toFixed(2);
								}*/
							}
						}
					},
					{
						field : 'serviceCharge',
						title : '结算</br>服务费',
						align:'right',
						formatter : function(value, row, index) {
							return value;
						}
					},
					{
						field : 'settleMethod',
						valign:'middle',
						title : '结算方式',
						align:'center',
						formatter : function(value, row, index) {
							if (value == '1') {
								return '充值金额';
							} else if (value == '2') {
								return '消费金额';
							}
						}
					},
					{
						field : 'settleRate',
						valign:'middle',
						title : '结算费率',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					{
						field : 'settleAmount',
						valign:'middle',
						title : '结算金额',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},
					{
						field : 'pappayAmount',
						valign:'middle',
						title : '免密金额',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},					{
						field : 'pappayNum',
						valign:'middle',
						title : '免密笔数',
						align:'right'
					},
/*					{
						field : 'enterAmount',
						title : '入账金额',
						align:'right',
						formatter : function(value, row, index) {
							if(value!=null){
								return value.toFixed(2);
							}
						}
					},*/
					{
						field : 'transferStatus',
						valign:'middle',
						title : '转账状态',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '0') {
								return '未转账';
							} else if (value == '1') {
								return '已转账';
							}
						}
					},
					{
						field : 'auditStatus',
						valign:'middle',
						title : '审核状态',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '-1') {
								return '<span class="label label-danger">未审核</span>';
							} else if (value == '0') {
								return '<span class="label label-info">审核不通过</span>';
							}else if(value=='1'){
								return '<span class="label label-success">审核通过</span>';
							}else{
								return '<span class="label label-warning">未知</span>';
							}
						}
					},
					{
						title : '操作',
						valign:'middle',
						field : 'id',
						align : 'center',
						formatter : function(value, row, index) {
							var detailhtml="";
							detailhtml+="<tr><td>商户代码</td><td>"+row.merchantCode+"</td></tr>";
							detailhtml+="<tr><td>商户简称</td><td>"+row.merchantName+"</td></tr>";
							detailhtml+="<tr><td>审核时间</td><td>"+(row.auditDateTime!=null?row.auditDateTime:"&nbsp;")+"</td></tr>";
							if (row.auditStatus == '-1') {
								detailhtml+="<tr><td>审核状态</td><td>未审核</td></tr>";
							} else if (row.auditStatus == '0') {
								detailhtml+="<tr><td>审核状态</td><td>审核不通过</td></tr>";
							}else if(row.auditStatus=='1'){
								detailhtml+="<tr><td>审核状态</td><td>审核通过</td></tr>";
							}else{
								detailhtml+="<tr><td>审核状态</td><td>未知</td></tr>";
							}
							
							detailhtml+="<tr><td>审核人</td><td>"+(row.auditUserName!=null?row.auditUserName:"&nbsp;")+"</td></tr>";
							detailhtml+="<tr><td>消费金额</td><td>"+row.debitAmount+"</td></tr>";
							detailhtml+="<tr><td>消费笔数</td><td>"+row.debitNum+"</td></tr>";
							detailhtml+="<tr><td>退款金额</td><td>"+row.refundAmount+"</td></tr>";
							detailhtml+="<tr><td>退款笔数</td><td>"+row.refundNum+"</td></tr>";
							detailhtml+="<tr><td>退款服务费</td><td>"+row.refundServiceFee+"</td></tr>";
							detailhtml+="<tr><td>结算服务费</td><td>"+row.serviceCharge+"</td></tr>";
							detailhtml+="<tr><td>结算金额</td><td>"+row.settleAmount+"</td></tr>";
							detailhtml+="<tr><td>结算开始日期</td><td>"+row.settleFromDate+"</td></tr>";
							detailhtml+="<tr><td>结算结束日期</td><td>"+row.settleEndDate+"</td></tr>";
							if (row.settleMethod == '1') {
								detailhtml+="<tr><td>结算方式</td><td>充值金额</td></tr>";
							} else if (row.settleMethod == '2') {
								detailhtml+="<tr><td>结算方式</td><td>消费金额</td></tr>";
							}
							detailhtml+="<tr><td>结算费率</td><td>"+row.settleRate+"</td></tr>";
							detailhtml+="<tr><td>日结日期</td><td>"+row.summaryDateTime+"</td></tr>";
							detailhtml+="<tr><td>充值金额</td><td>"+row.topupAmount+"</td></tr>";
							detailhtml+="<tr><td>充值笔数</td><td>"+row.topupNum+"</td></tr>";
							detailhtml+="<tr><td>转账金额</td><td>"+(row.transferAmount!=null?row.transferAmount:"&nbsp;")+"</td></tr>";
							detailhtml+="<tr><td>转账时间</td><td>"+(row.transferDateTime!=null?row.transferDateTime:"&nbsp;")+"</td></tr>";
							if(row.transferOrderNO)
								detailhtml+="<tr><td>转账单号</td><td>"+row.transferOrderNO+"</td></tr>";
							else
								detailhtml+="<tr><td>转账单号</td><td></td></tr>";
							detailhtml+="<tr><td>转账说明</td><td>"+(row.transferRemark!=null?row.transferRemark:"&nbsp;")+"</td></tr>";
							if (row.transferStatus == '0') {
								detailhtml+="<tr><td>转账状态</td><td>未转账</td></tr>";
							} else if (row.transferStatus == '1') {
								detailhtml+="<tr><td>转账状态</td><td>已转账</td></tr>";
							}
							
							detailhtml+="<tr><td>入账金额</td><td>"+row.enterAmount+"</td></tr>";
							
							detailhtml+="<tr><td>免密金额</td><td>"+row.pappayAmount+"</td></tr>";
							detailhtml+="<tr><td>免密笔数</td><td>"+row.pappayNum+"</td></tr>";
							
							var d = '<button onmouseover=\'over(this)\' onmouseleave=\'leave(this)\' class="btndetail btn btn-warning btn-sm ' + s_detail_h + '" href="javascript:void(0)" title="详情" data-container="body" data-toggle="popover" data-placement="left" data-html="true" data-content="<div style=\'height:550px;\'><table class=\'popdetailtable layui-table\'><tbody>'+detailhtml+'</tbody></table></div>"><i class="fa fa-ellipsis-h "></i></button> ';
							var c = '<a class="btn btn-warning btn-sm ' + s_check_h + '" href="#" title="运营审核"  mce_href="#" onclick="check(\''
								+ row.id
								+ '\')"><i class="fa fa-check"></i></a> ';							
							var ccw = '<a class="btn btn-warning btn-sm ' + s_checkcw_h + '" href="#" title="财务审核"  mce_href="#" onclick="checkcw(\''
								+ row.id
								+ '\')"><i class="fa fa-check"></i></a> ';
							if(row.transferStatus==null || row.transferStatus!= 1){
								if(row.auditStatus==1)
									c='';
								if(row.transferStatus==1)
									ccw='';
								return d + c +ccw;
							}
							else
								return d;
						}
					} ]
			});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
//function detail(id) {
//	layer.open({
//		type : 2,
//		title : '详情',
//		maxmin : true,
//		shadeClose : false, 
//		area : [ '800px', '520px' ],
//		content : prefix + '/detail/'+id
//	});
//}
function check(id) {
	layer.open({
		type : 2,
		title : '运营审核',
		maxmin : true,
		shadeClose : false, 
		area : [ '800px', '350px' ],
		content : prefix + '/check/'+id
	});
}
function checkcw(id) {
	layer.open({
		type : 2,
		title : '财务审核',
		maxmin : true,
		shadeClose : false, 
		area : [ '800px', '550px' ],
		content : prefix + '/checkcw/'+id
	});
}
function excel(){
	layer.confirm('确定导出吗?', {
		  btn: ['是','否']
	}, function(){
		layer.closeAll('dialog');
		//window.location.href= prefix + '/expexcel?searchvalue=' + $('#searchName').val() + '&settletype=' + $('#settletype').val() + '&checktype=' + $('#checktype').val() + '&transstatus=' + $('#transstatus').val() + '&datetype=' + $('#datetype').val() + '&merchantCode=' + $('#merchantCode').val() +  '&sdate=' + $('#sdate').val() + '&edate=' + $('#edate').val();
		window.location.href= '/ureport/excel?_u=file:DailysummarySettle.ureport.xml&searchvalue=' + $('#searchName').val() + '&settletype=' + $('#settletype').val() + '&checktype=' + $('#checktype').val() + '&transstatus=' + $('#transstatus').val() + '&datetype=' + $('#datetype').val() + '&merchantCode=' + $('#merchantCode').val() +  '&sdate=' + $('#sdate').val() + '&edate=' + $('#edate').val() + '&settleType=' + $('#settleType').val();
	}, function(){
	});
}
function print(){
	var p = "/ureport" 
    var p2 = "&_t=1"
	window.open(p + '/preview?_u=file:DailysummarySettle.ureport.xml&searchvalue=' + $('#searchName').val() + '&settletype=' + $('#settletype').val() + '&checktype=' + $('#checktype').val() + '&transstatus=' + $('#transstatus').val() + '&datetype=' + $('#datetype').val() + '&merchantCode=' + $('#merchantCode').val() +  '&sdate=' + $('#sdate').val() + '&edate=' + $('#edate').val() + '&settleType=' + $('#settleType').val()+p2);  
}

function over(o)
{
	$(o).popover('show');
}
function leave(o)
{
	$(o).popover('hide');
}