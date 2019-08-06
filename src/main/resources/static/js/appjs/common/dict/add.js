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
		url : "/common/sysDict/save",
		data : $('#signupForm').serialize(), // 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("网络超时");
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
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			dictCode : {
				required : true
			},
			dataCode : {
				required : true,
				digits:true,
				maxlength:8
			},
			dataValue : {
				required : true,
				maxlength:8
			}
		},
		messages : {
			dictCode : {
				required : icon + "请输入字典代码（类型）"
			},
			dataCode : {
				required : icon + "请输入字典数据项代码",
				digits : icon + "只能输入整数",
				maxlength : icon + "输入长度不能超过8位数"
			},
			dataValue : {
				required : icon + "请输入字典数据项值",
				maxlength : icon + "输入长度不能超过8位数"
			}
			
		}
	})
}