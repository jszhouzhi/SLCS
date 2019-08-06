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
        url : "/updateNameAndPasW",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
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
            userName : {
                required : true,
            },
                passWord : {
                required : true,
                remote : {
                    url : "/isExit", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                    	passWord : function() {
                            return $("#passWord").val();
                        },
                        userName : function() {
                            return $("#userName").val();
                        }
                    }
                }
            },
            newPassword : {
                required : true,
            },
            reNewPassword :{
                equalTo: "#newPassword"
              },
            topic : {
                required : "#newsletter:checked",
                minlength : 2
            },
            agree : "required"
        },
        messages : {
            userName : {
                required : icon + "请输入用户名",
            },
            passWord : {
                required : icon + "请输入旧密码",
                remote : icon + "密码错误，请重新输入"
            },
            newPassword : {
                required : icon + "请输入新密码",
            },
            reNewPassword :{
                equalTo : icon + "俩次输入的密码不一致",
             }
        }
    })
}
