$().ready(function() {
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
		url : "/account/member/update",
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
			typeID : {
				required : true
			},
			name : {
				required : true			
			},
			discount : {
				required : true,
				min : 0,
				max : 1,
			 	number : true
			},
			buyMonthPrice : {
				required : true,
				min : 1,
			 	number : true
			},
			buySeasonPrice : {
				required : true,
				min : 1,
			 	number : true
			},
			buyYearPrice : {
				required : true,
				min : 1,
			 	number : true
			},
			buyMonthDiscountPrice : {
				required : true,
				min : 1,
			 	number : true
			},
			buySeasonDiscountPrice : {
				required : true,
				min : 1,
			 	number : true
			},
			buyYearDiscountPrice : {
				required : true,
				min : 1,
			 	number : true
			},
			maxDiscountAmount : {
				required : true,
				min : 1,
			 	number : true
			}
		},
		messages : {
			typeID : {
				required : icon + "会员类型不能为空"
			},
			name : {
				required : icon + "名称不能为空"
			},
			discount : {
				required : icon + "折扣不能为空",
				min : icon + "必须输入合法的数字",
				max : icon + "输入0-1之间的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			buyMonthPrice : {
				required : icon + "月会员价格不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			buySeasonPrice : {
				required : icon + "季会员价格不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			buyYearPrice : {
				required : icon + "年会员价格不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			buyMonthDiscountPrice : {
				required : icon + "月优惠价格不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			buySeasonDiscountPrice : {
				required : icon + "季优惠价格不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			buyYearDiscountPrice : {
				required : icon + "年优惠价格不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			},
			maxDiscountAmount : {
				required : icon + "单次最大优惠金额不能为空",
				min : icon + "必须输入合法的数字",
			 	number : icon + "必须输入合法的数字 " 
			}
		}
	})
}