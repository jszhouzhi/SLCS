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
        url : "/Api/apiSet/update",
        data : $('#signupForm').serialize(),// 你的formid
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
            appId : {
                required : true,
                /*remote : {
                    url : "/Api/apiSet/exit", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        appId : function() {
                            return $("#appId").val();
                        }
                    }
                }*/
            },
            appType : {
                required : true,
            },
            appKey : {
                required : true,
                rangelength : [6,32],
            },
            topic : {
                required : "#newsletter:checked",
                minlength : 2
            },
            agree : "required"
        },
        messages : {
            appType : {
                required : icon + "请输入应用类型",
            },
            appId : {
                required : icon + "请输入应用ID",
               // remote : icon + "商户代码已经存在"
            },
            appKey : {
                required : icon + "请输入应用密匙",
                rangelength : icon + "密匙长度必须大于6小于或小于32",
            }
        }
    })
}
