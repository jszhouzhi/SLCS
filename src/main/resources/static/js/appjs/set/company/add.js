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
        url : "/company/companySet/save",
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
            code : {
                required : true,
                maxlength : 6,
                remote : {
                    url : "/company/companySet/exit", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        code : function() {
                            return $("#code").val();
                        }
                    }
                }
            },
            cityCode : {
                required : true,
                maxlength : 6
            },
            shortName : {
                required : true,
                maxlength : 10

            },
            name : {
                required : true

            },
            pinYin : {
                required : true
            },
            cityName  :{
                required : true
            },
            cityPinYin :{
                required : true
            },

            qrTimeOut :{
                required : true,
                number : true,
            },
            agree : "required"
        },
        messages : {

            code : {
                required : icon + "请输入机构代码",
                maxlength :icon + "请输入六个以内的字母或者数字",
                remote : icon + "机构代码已经存在"
            },
            cityCode : {
                required : icon + "请输入城市代码",
                maxlength : icon + "请输入六个以内的字母或者数字",
            },
            name : {
                required : icon + "请输入机构名称"
            },
            shortName : {
                required : icon + "请输入机构简称",
                maxlength : icon + "请输入10个以内的字母或者数字"
            },
            pinYin : {
                required : icon + "请输入机构拼音"
            },
            cityName  :{
                required : icon + "请输入城市名称"
            },
            cityPinYin :{
                required : icon + "请输入城市拼音"
            },
            qrTimeOut   :{
                required : icon + "请输入二维码超时时间",
                number :icon +"请输入数字格式"
            }
        }
    })
}
