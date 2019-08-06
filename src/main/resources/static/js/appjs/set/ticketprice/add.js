$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});


var carType;
var disCount;
function addBtn(){
    // 获取form的值
	carType = $("input[name='carType']").val();
	disCount = $("input[name='disCount']").val();
 
    
    // 在table 中生成tr 
    var tr = $("<tr><td><input type='text' id='!carType' name='!carType'/></td><td><input id='disCount' type='text' name='disCount' /></td><td><a href='#' onclick='deleteItem(this);'>删除</a></td></tr>");

    $("table").append(tr);
    input_content += $("input[name='carType']").val();+"&"+$("input[name='disCount']").val()
    // form重置，清除刚才表单填写的内容
    //$("form")[0].reset();
/*
    var reg = /^[0-9]+$/;
    if(!fromAmount.test(reg)){
        alert('只能输入数字！');
        return false;
    }
    if(!fromAmount.test(reg)){
        alert('只能输入数字！');
        return false;
    }*/


}

//删除
function deleteItem(a){
    // 删除 a 元素所在行 
    $(a).parents("tr").remove();
}

function save() {
	var content = $('#signupForm').serialize();
	
	content = decodeURIComponent(content,true);
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/set/ticketprice/save",
		//data : $('#signupForm').serialize(),// 你的formid
		data : {content:content},
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
			merchantcode : {
				required : true,
			},
			linecode : {
				required : true,
				maxlength:10
			}/*,
			pricesetting : {
				required : true,
				min:0,
				maxlength:7
			}*/
		},
		messages : {
			merchantcode : {
				required : icon + "请选择商户"
			},
			linecode : {
				required : icon + "请输入线路"
			}/*,
			pricesetting : {
				required : icon + "票价只能输入数字，且不能小于零"
			} */
		}
	})
}