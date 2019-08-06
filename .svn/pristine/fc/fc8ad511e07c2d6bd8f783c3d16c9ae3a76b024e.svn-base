
var prefix = "/operation/sendcase"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/api/list", // 服务器数据的加载地址
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
                                merchantCode:$('#merchantCode').val(),
                                discountName:$('#searchName').val()
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
									field : 'id', 
									align : 'center',
									title : 'ID编号'
								},
																{
									field : 'merchantName', 
									align : 'center',
									title : '商户简称'
								},
																{
									field : 'discountName', 
									align : 'center',
									title : '优惠方案名称' 
								},
																{
									field : 'discountDesc', 
									align : 'center',
									title : '优惠方案描述' 
								},
																{
									field : 'effectiveDateTime', 
									align : 'center',
									title : '方案开始时间' 
								},
																{
									field : 'expiredDateTime', 
									align : 'center',
									title : '方案结束时间' 
								},
																{
									field : 'enabled', 
									align : 'center',
									title : '启用状态',
									formatter: function(value){
										if(value==0){
											return '<span class="label label-danger">未启用</span>';
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
										
										if(row.enabled==0){
											var f = '<a class="btn btn-success btn-sm '+s_resetEnabled_h+'"  href="#" title="启用"  mce_href="#" onclick="resetEnabled(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
											return e + d + f ;
										}else{
                                            var f = '<a class="btn btn-danger btn-sm '+s_reesetEnabled_h+'"  href="#" title="禁用"  mce_href="#" onclick="reesetEnabled(\''
                                                + row.id
                                                + '\')"><i class="fa fa-key"></i></a> ';
											return e + d + f;
										}

										
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
		area : [ '1200px', '720px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1200px', '720px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}

function resetEnabled(id) {
    layer.confirm('确定要启用选中的方案吗？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/resetEnabled",
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

function reesetEnabled(id) {
    layer.confirm('确定要禁用选中的方案吗？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/reesetEnabled",
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

