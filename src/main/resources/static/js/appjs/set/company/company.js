var prefix = "/company/companySet"
$(function() {
    var deptId = '';

    load(deptId);
});

function load(deptId) {
    console.log("数据加载");
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                // showRefresh : true,  //显示刷新按钮
                // showToggle : true,   //名片格式
                // showColumns : true,searchName  //显示隐藏列
                iconSize : 'outline',
                toolbar : '#exampleToolbar',   //设置工具栏的Id或者class
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit", // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",// //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                // search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者// "server"
                queryParams : function(params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit : params.limit,
                        offset : params.offset,
                        keyWord : $('#searchName').val(),
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
                        checkbox : true
                    },
                    {
                        field : 'code', // 列字段名
                        title : '机构代码', // 列标题
                        align :  'center'
                    },
                    {
                        field : 'cityCode',
                        title : '城市代码',
                        align :  'center'
                    },
                    {
                        field : 'name',
                        title : '机构名称',
                        align :  'center'
                    },
                    {
                        field : 'shortName',
                        title : '机构简称',
                        align :  'center'
                    },

                    {
                        field : 'pinYin',
                        title : '机构拼音',
                        align :  'center'
                    },
                   {
                        field : 'cityName',
                        title : '城市名称',
                        /* text-align : 'center',*/
                        align :  'center'
                    },
                    {
                        field : 'cityPinYin',
                        title : '城市拼音',
                       /* text-align : 'center',*/
                        align :  'center'
                    },
                    {
                        title : '运营设置',
                        field : 'setting',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="设置" onclick="setting(\''
                                + row.id
                                + '\')">运营设置</a> ';
                            return e ;
                        }
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit "></i></a> ';
                            return e ;
                        }
                    } ]
            });
}
    function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function impor(){
    var keyWord = $("#searchName")  .val();
    if(confirm("确定导出吗？")){
        window.location.href= prefix + '/import?keyWord=' + keyWord ;
    }
}

function setting(id) {
    layer.open({
        type : 2,
        title : '运营设置',
        maxmin : true,
        shadeClose : true, // 点击遮罩关闭层
        area : [ '1200px', '800px' ],
        content : prefix + '/setting/' + id // iframe的url
    });
}


function add() {
    // iframe层
    layer.open({
        type : 2,
        title : '添加机构',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '690px' ],
        content : prefix + '/add'
    });
}

function edit(id) {
    layer.open({
        type : 2,
        title : '机构修改',
        maxmin : true,
        shadeClose : true, // 点击遮罩关闭层
        area : [ '800px', '690px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}

