var prefix = "/system/log"
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
                        searchvalue : $('#searchName').val(),
                        sdate : $('#sdate').val(),
                        edate : $('#edate').val(),
                        topuptype : $('#topuptype').val(),
                        topupstatus : $('#topupstatus').val(),
                        Id : Id
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns : [{
                    field : 'id', // 列字段名
                    title : '序号' // 列标题
                },
                    {
                        field : 'userName',
                        title : '用户名'
                    },
                    {
                        field : 'ip',
                        title : '主机'
                    },
                    {
                        field : 'moduleName',
                        title : '模块'
                    },
                    {
                        field : 'operateType',
                        title : '操作类型'
                    },
                    {
                        field : 'logContent',
                        title : '日志内容'
                    },
                    {
                        field : 'logDateTime',
                        title : '日志时间'
                    },
                    {
                        field : 'logTypeID',
                        title : '日志状态',
                        align : 'center',
                        formatter : function(value, row, index) {
                            if (value == 1) {
                                return '<span class="label label-success">成功</span>';
                            } else if (value ==3) {
                                return '<span class="label label-primary">错误</span>';
                            }
                        }
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {

                            return ;
                        }
                    } ]
            });
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function excel(){
    layer.confirm('确定导出吗?', {
        btn: ['是','否']
    }, function(){
        layer.closeAll('dialog');
        window.location.href= prefix + '/expexcel?searchvalue=' + $('#searchName').val() + '&sdate=' + $('#sdate').val() + '&edate=' + $('#edate').val() + '&topuptype='+$('#topuptype').val()+ '&topupstatus='+$('#topupstatus').val();
    }, function(){
    });
}