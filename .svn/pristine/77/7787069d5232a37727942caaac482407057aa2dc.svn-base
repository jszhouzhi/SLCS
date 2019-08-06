var prefix = "/operation/icwxrefund"
$(function() {
	var Id = '';
	load(Id);
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
						auditRemark : $('#searchName').val(),
						sdate : $('#sdate').val(),
						edate : $('#edate').val(),
						rechargetype:$('#rechargetype').val(),
						checktype:$('#checktype').val(),
						Id : Id
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
                        field : 'cardNO',
                        title : '卡号'
                    },

					{
						field : 'orderNO',
						title : '订单号'
					},
                    {
                        field : 'refundOrderNO',
                        title : '退款单号'
                    },
                    {
                        field : 'refundAmount',
                        title : '退款金额',
                        align: 'right',
                        formatter : function(value, row, index) {
                            return value.toFixed(2);
                        }
                    },
                    {
                        field : 'refundTime',
                        title : '退款时间	',
                        align: 'center'
                    },
                    {
                        field : 'refundResult',
                        title : '退款结果',
                        align: 'center',
                        formatter : function(value, row, index) {
                            if(value==1)
                                return "退款成功";
                            if(value==0)
                                return "退款失败";
                        }
                    },
					{
						field : 'nickName',
						title : '退款人'
					}]
			});
}

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

// function check(id) {
// 	layer.open({
// 		type : 2,
// 		title : '审核',
// 		maxmin : true,
// 		shadeClose : false,
// 		area : [ '800px', '520px' ],
// 		content : prefix + '/check/'+id
// 	});
// }

function excel(){
	layer.confirm('确定导出吗?', {
		  btn: ['是','否']
	}, function(){
        layer.closeAll('dialog');
		window.location.href= prefix + '/expexcel?auditRemark=' + $('#searchName').val() + '&sdate=' + $('#sdate').val() + '&edate=' + $('#edate').val() + '&rechargetype=' + $('#rechargetype').val() + '&checktype=' + $('#checktype').val();
	}, function(){
	});
}