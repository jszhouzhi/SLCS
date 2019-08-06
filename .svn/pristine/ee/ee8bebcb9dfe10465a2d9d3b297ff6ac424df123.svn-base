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
        url : "/operation/settle/api/check",
        data : {
        	id:$("#id").val(),
        	auditvalue:$("#checktype").val(),
        	remark:$("#transDec").val(),
        	amount:$("#transAmount").val(),
        	transdate:$("#transDate").val(),
        	transno:$("#transNo").val(),
        	transstatus:$("#transStatus").val()
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
            transStatus : {
		        required : true
		    },
		    transDate : {
		        required : true
		    }
        },
        messages : {
        	checktype : {
                required : icon + "请选择审核结果"
            },
            transStatus : {
	            required : icon + "请选择转账状态"
	        },
	        transDate:{
	            required : icon + "请选择转账时间"
	        }
        }
    });

	$('#transDate').datetimepicker({
        format: 'yyyy-mm-dd',
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
}
