var prefix = "/operation/optdepartment"
$(document).ready(function() {
	load();
});

var load = function() {
    $('#exampleTable')
        .bootstrapTreeTable(
            {
                id : 'iD',
                code : 'iD',
                parentColumn : 'parentId',
                type : "GET", // 请求数据的ajax类型
                url : prefix + '/api/list', // 请求数据的ajax的url
                ajaxParams : {}, // 请求数据的ajax的data属性
                expandColumn : '1', // 在哪一列上面显示展开按钮
                striped : true, // 是否各行渐变色
                bordered : true, // 是否显示边框
                expandAll : false, // 是否全部展开
                // toolbar : '#exampleToolbar',
                columns : [
       				{
    					title : '编号',
    					field : 'iD',
    					visible : false,
    					align : 'center',
    					valign : 'middle',
    					width : '50px'
    				},
                    {
                        field : 'merchantCode',
                        title : '商户代码'
                    },
                    {
                        field : 'deptCode',
                        title : '部门代码'
                    },
                    {
                        field : 'deptName',
                        title : '部门名称'
                    },
                    {
                        field : 'parentId',
                        title : '父级部门ID'
                    },
               
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(item, index) {
                        	
                        	if(item.parentId==0){
	                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
	                                + item.iD
	                                + '\')"><i class="fa fa-edit"></i></a> ';
	                            var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="addID(\''
	                                + item.iD
	                                + '\')"><i class="fa fa-plus"></i></a> ';
	                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="deleteDepartment(\''
	                                + item.iD
	                                + '\')"><i class="fa fa-remove"></i></a> ';
	                            return e + a + d;
                        	}else{
		                        var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
	                                + item.iD
	                                + '\')"><i class="fa fa-edit"></i></a> ';
	
	                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="deleteDepartment(\''
	                                + item.iD
	                                + '\')"><i class="fa fa-remove"></i></a> ';
	                            return e + d;
                        	}

                        }
                    } ]
            });
}

function reLoad() {
	load();
}

function deleteDepartment(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix +"/deleteDepartment",
            type : "post",
            data : {
                'id' : id
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

function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '420px' ],
		content : prefix + '/edit/'+id
	});
}

function add(){
	layer.open({
		type : 2,
		title : '添加',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '420px' ],
		content : prefix + '/add'
	});
}
function addID(id){
	layer.open({
		type : 2,
		title : '添加',
		maxmin : true,
		shadeClose : false,
		area : [ '800px', '420px' ],
		content : prefix + '/add/'+ id
	});
}