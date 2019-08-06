var buildindex=null;
$("#document").ready(function(){
	layui.use('layedit', function(){
	  var layedit = layui.layedit;
	  buildindex = layedit.build('newscontent'); 
	});
    validateRule();
    // $('#fileupload').fileupload({
    //     dataType: 'json',
    //     done: function (e, data) {
    //     	$("#upimg").data("id",data.result.id);
    //     	$("#upimg").attr("src","/upload/"+data.result.id);
    //     }
    // });
});

$.validator.setDefaults({
    submitHandler : function(form) {
        save();
    }
});
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
        	merchantCode : {
                required : true
            },
            deptCode : {
		        required : true,
		        digits:true,
		        maxlength:5,
				remote : {
					url : "/operation/optdepartment/exist", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						deptCode : function() {
							return $("#deptCode").val();
						}
					}
				}
		    },
		    deptName : {
		        required : true,
		        maxlength:8
		    }
        },
        messages : {
        	merchantCode : {
                required : icon + "请选择商户代码"
            },
            deptCode : {
	            required : icon + "请填写部门代码",
	            digits : icon + "请输入数字",
	            maxlength : icon + "输入长度不能超过5位数",
            	remote : icon + "部门代码已经存在"
	        },
	        deptName : {
	            required : icon + "请填写部门名",
	            maxlength : icon + "输入长度不能超过8位数"
	        }
        }
    });
}

function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/operation/optdepartment/api/add",
        data : $('#signupForm').serialize(),
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
