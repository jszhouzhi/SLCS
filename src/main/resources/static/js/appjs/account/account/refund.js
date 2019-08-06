$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		refund();
	}
});
function refund() {
	var refundBalance=Number($('#refundBalance').val())
	var balance=Number($('#balance').val())
	
	if(refundBalance>balance){	
		layer.alert("退款金额必须小于账户余额", {icon: 2});
		return;
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/account/account/refundSubmit",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			 
/*				parent.layer.alert( data.data+'</br>'+data.message);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
*/			if (data.code == 0) {
				parent.layer.alert( data.data+'</br>'+data.message);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);
			
			} else {
				parent.layer.alert( data.data+'</br>'+data.message);
			}
			 

		}
	});

}
 
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			refundBalance : {
				required : true,
				min:0,
				maxlength:8
			},
 
			
			agree : "required"
		},
		messages : {

			refundBalance : {
				required : icon + "请输入退款金额",
				min : icon + "退款金额需填写数字且不小于0",
				maxlength : icon + "退款金额不能大于8位数"
			}
		}
	})
}