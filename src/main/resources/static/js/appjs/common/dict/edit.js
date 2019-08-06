$().ready(function() {
	/*selectType();*/
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/common/sysDict/update",
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

/*function selectType(){
	var html = "";
	$.ajax({
		url : '/common/sysDict/type',
		success : function(data) {
			//加载数据
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].dictCode + '">' + data[i].dictCode + '</option>'
			}
			$(".chosen-select").append(html);
			$(".chosen-select").chosen({
				maxHeight : 200
			});

		}
	});
}*/

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