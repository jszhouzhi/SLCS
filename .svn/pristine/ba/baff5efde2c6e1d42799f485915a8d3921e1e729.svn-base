

$().ready(function() {
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#form").validate({
        rules : {
            driverCode : {
                required : true,
                maxlength : 10
            },
            driverNO : {
                required : false,
                maxlength : 20
            },
            driverName : {
                required : true,
                maxlength : 20
            },
            driverCardID : {
                required : false,
                maxlength : 20
            },
            iDCardNO : {
                required : false,
                maxlength : 18

            },
            iDCardAddr : {
                required : false,
                maxlength : 128
            },
            lineID : {
                required : true,
                maxlength : 4
            },
            phone : {
                required : false,
                number : true,
                maxlength : 32
            },
            workCardNO : {
                required : false,
                maxlength : 20
            },
            beginWorkDate : {
                required : false
            },
            driverState : {
                required : true
            }
        },
        messages : {
            driverCode : {
                required : icon + "司机代码不能为空"
            },
            driverNO : {
                required : icon + "司机编号不能为空"
            },
            driverName : {
                required : icon + "司机姓名不能为空"
            },
            driverCardID : {
                required : icon + "司机卡号不能为空"
            },
            iDCardNO : {
                required : icon + "身份证不能为空"
            },
            iDCardAddr : {
                required : icon + "身份证地址不能为空"
            },
            lineID : {
                required : icon + "线路不能为空"
            },
            phone : {
                required : icon + "电话"
            },
            workCardNO : {
                required : icon + "电话不能为空",
                number : icon + "电话必须为数字"
            },
            beginWorkDate : {
                required : icon + "入职时间不能为空"
            },
            driverState : {
                required : icon + "状态不能为空"
            }
        }
    });
}


function save() {
	// var layedit = layui.layedit;
	// var newscontent=layedit.getContent(buildindex);
	// if(!newscontent)
	// {
	// 	layer.alert('请填写正文内容');
	// }
    $.ajax({
        cache : true,
        type : "POST",
        url : "/operation/optdriver/api/add",
        data : {
            driverCode:$("#driverCode").val(),
            driverNO:$("#driverNO").val(),
            driverName:$("#driverName").val(),
            driverCardID:$("#driverCardID").val(),
            iDCardNO:$("#iDCardNO").val(),
            iDCardAddr:$("#iDCardAddr").val(),
            lineID:$("#lineID").val(),
            phone:$("#phone").val(),
            workCardNO:$("#workCardNO").val(),
            beginWorkDate:$("#beginWorkDate").val(),
            driverState:$("#driverState").val()
        },
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); 
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}
