var input_content;
$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

var f=0;
var fromAmount;
var toAmount;
function addBtn(){
    // 获取form的值
     fromAmount = $("input[name='fromAmount']").val();
     toAmount = $("input[name='toAmount']").val();
    var discountAmount = $("input[name='discountAmount']").val();
    
    // 在table 中生成tr 
    var tr = $("<tr><td><input type='text' name='!fromAmount'/></td><td><input id='toAmount' type='text' name='toAmount' onmouseleave='addDate()' /></td><td><input type='text' name='discountAmount'/></td><td><a href='#' onclick='deleteItem(this);'>删除</a></td></tr>");

    $("table").append(tr);
    input_content += $("input[name='fromAmount']").val();+"&"+$("input[name='toAmount']").val()+"&"+$("input[name='discountAmount']").val()
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
	//var discountname = $("input[name='discountname']").val()
	//var discountdesc = $("input[name='discountdesc']").val()
	//alert(input_content);
	var content = $('#signupForm').serialize();
	
	content = decodeURIComponent(content,true);
	
	$.ajax({
		cache : true,
		type : "POST",
		url : "/operation/sendcase/save",
		data : {content:content},// 你的formid
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
			discountname : {
				required : true
			},
			discountdesc : {
				required : true
			},
			effectivedatetime : {
				required : true
			},
			expireddatetime : {
				required : true
			},
			merchantCode : {
				required : true
			}
			
		},
		messages : {
			discountname : {
				required : icon + "请输入方案名称"
			},
			discountdesc : {
				required : icon + "请输入方案描述"
			},
			effectivedatetime : {
				required : icon + "请选择方案开始时间"
			},
			expireddatetime : {
				required : icon + "请选择方案结束时间"
			},
			merchantCode : {
				required : icon + "请选择商户"
			}
		}
	})
}



layui.use(['laydate'], function(){
	  var laydate = layui.laydate;
	  
	  //日期
	  laydate.render({
	    elem: '#effectivedatetime'
	  });
	  laydate.render({
	    elem: '#expireddatetime'
	  });
	  
	});