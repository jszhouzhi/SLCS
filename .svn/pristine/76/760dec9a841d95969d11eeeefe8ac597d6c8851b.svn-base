
var prefix = "/account/vipMemberApply"
$(function() {
	load();
});

$('#exampleTable').on('load-success.bs.table', function (e, data) {
    if (data.total && !data.rows.length) {
        $('#exampleTable').bootstrapTable('selectPage').bootstrapTable('refresh');
    }
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/account", // 服务器数据的加载地址
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
								payResult:$('#payResult').val(),
								merchantCode:$('#merchantCode').val(),
								vipMemberId:$('#vipMemberId').val()
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
										align : 'center',
										title : '商户' 
									},
       
																{
									field : 'nickName', 
									align : 'center',
									title : '申请人' 
								},
																{
									field : 'accountNo', 
									align : 'center',
									title : '二维码账号' 
								},
																{
									field : 'orderNo', 
									align : 'center',
									title : '订单编号' 
								},
																{
									field : 'vipMemberName', 
									align : 'center',
									title : 'vip会员类型' 
								},
																{
									field : 'buyDays', 
									align : 'center',
									title : '购买天数' 
								},
																{
									field : 'price', 
									align : 'right',
									title : '价格',
									formatter : function(value, row, index) {
										if(value!=null){
											return value.toFixed(2);
										}
									}
								},
																{
									field : 'discountPrice', 
									align : 'right',
									title : '优惠价格',
									formatter : function(value, row, index) {
										if(value!=null){
											return value.toFixed(2);
										}
									}
								},
																{
									field : 'applyDateTime', 
									align : 'center',
									title : '申请时间' 
								},
								 
																{
									field : 'payDateTime', 
									align : 'center',
									title : '支付时间' 
								},
																{
									field : 'payResult', 
									align : 'center',
									title : '支付结果',
									formatter : function(value, row, index) {
										if(value==1){
											return "成功";
										}else if(value==0){
											return "未支付";
										}else {
											return "失败";
										}
									}
								},
																{
									field : 'payMessage', 
									align : 'center',
									title : '支付结果信息描述' 
								}, 
																{
									field : 'oldExpireDateTime', 
									align : 'center',
									title : '延长日期',
									formatter : function(value, row, index) {
										if(row.oldExpireDateTime!=null && row.newExpireDateTime!=null)
											return row.oldExpireDateTime+' 至  '+row.newExpireDateTime;								 
									}
								} 
								
								
								]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
 
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

 
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}