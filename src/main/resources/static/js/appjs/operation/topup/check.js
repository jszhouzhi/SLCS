$().ready(function() {
    validateRule();
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/operation/topup/api/check",
        data : {
        	id:$("#id").val(),
        	auditvalue:$("#checktype").val(),
        	remark:$("#checkDec").val()
        },
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });
}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            checktype : {
                required : true
            },
    		checkDec : {
                required : true
            }
        },
        messages : {
        	checktype : {
                required : icon + "请选择审核结果"
            },
            checkDec : {
	            required : icon + "请输入审核描述"
	        }
        }
    });
}
