
var prefix = "/set/ticketprice"
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
								searchName : $('#searchName').val(),
								merchantCode:$('#merchantCode').val()
 
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
									align : 'center',
									title : '商户' 
								},
																{
									field : 'linecode', 
									align : 'center',
									title : '线路' 
								},
								/*								{
									field : 'pricesetting', 
									align : 'center',
									title : '票价' 
								},*/
/*																{
									field : 'discountsetting', 
									title : '卡类: 折扣',
									formatter : function(value, row, index) {										
										var result = JSON.stringify(JSON.parse(value), null, 2);
										result = result.replace(/"/g, "");
										result = result.replace(/,/g, "&nbsp; | &nbsp;");
										result = result.replace("{","");
										result = result.replace("}","");
										return result;
									}
								},*/
								{
									field : 'discountsetting',
									title : '卡类: 折扣',
									cellStyle:formatTableUnit,
									formatter :paramsMatter
								},
																{
									field : 'isenable', 
									align : 'center',
									title : '是否启用',
									formatter: function(value){
										if(value==0){
											return '<span class="label label-danger">不启用</span>';
										}else if(value==1){
											return '<span class="label label-success">启用</span>';
										}
							
									}
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '600px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '600px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
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

//表格超出宽度鼠标悬停显示td内容
function paramsMatter(value,row,index, field) {
	var result = JSON.stringify(JSON.parse(value), null, 2);
	result = result.replace(/"/g, "");
	result = result.replace(/,/g, "&nbsp; | &nbsp;");
	result = result.replace("{","");
	result = result.replace("}","");	
	
	var result2 = JSON.stringify(JSON.parse(value), null, 2);
	result2 = result2.replace(/"/g, "");
	result2 = result2.replace(/,/g, "");
	result2 = result2.replace("{","卡类:折扣");
	result2 = result2.replace("}","");	
	
	var span=document.createElement('span');
	span.setAttribute('title',result2);
	span.innerHTML = result;
	return span.outerHTML;
}
//td宽度以及内容超过宽度隐藏
function formatTableUnit(value, row, index) {
	return {
		css: {
		"white-space": 'nowrap',
		"text-overflow": 'ellipsis',
		"overflow": 'hidden',
		"max-width":'150px'
		}
	}
}
 

 
 