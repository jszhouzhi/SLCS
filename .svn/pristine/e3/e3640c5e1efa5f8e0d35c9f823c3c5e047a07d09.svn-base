/*$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});*/

var input_content;
var html;
/*var obj = [[${disSettingDeta}]]*/
$().ready(function() {
    validateRule();

	var aryList=[];
	var ary = JSON.parse( obj11.discountsetting );
	var aryJson = JSON.stringify( obj11.discountsetting );	
	$.each(ary,function(i,item){
		
			 html+=['<tr>',
				'<td><input type=\"text\" value=\"'+i+'\" id=\"carType\" name=\"!carType\">','</td>',
	            '<td><input type=\"text\" value=\"'+item+'\" id=\"disCount\" name=\"disCount\">','</td>',
	            
	             /*'<td style="display: none"><input type=\"text\" value=\"'+item['discountsetting']+'\" id=\"discountsetting\" name=\"discountsetting\">','</td>',*/
	            '<td><a href=\'#\' onclick=\'deleteItem(this,\"'+i+'\", '+aryJson+','+id+');\'>删除</a></td>',
	            '<tr>'
	
			].join('');		
		
		aryList.push(html)
	});
    $("table").append(html);

});

$.validator.setDefaults({
    submitHandler : function() {
        edit(id);
    }
});

function addBtn(){
    // 获取form的值
    var carType = $("input[name='carType']").val();
    var disCount = $("input[name='disCount']").val();
 

    // 在table 中生成tr 
    var tr = $("<tr><<td><input type='text' name='!carType'/></td><td><input type='text' name='disCount'/></td><td><a href='#' onclick='deleteItem(this);'>删除</a></td></tr>");
    $("table").append(tr);

    input_content += $("input[name='carType']").val();+"&"+$("input[name='disCount']").val()
    // form重置，清除刚才表单填写的内容
    //$("form")[0].reset();
}

function deleteItem(a,key,aryJson,id) {
	if(aryJson==null){
		$(a).parents("tr").remove();
	}else{
		layer.confirm('确定要删除此卡类和对应的折扣？', {
			btn : [ '确定', '取消' ]
		}, function() {
			$.ajax({
				url : "/set/ticketprice/updateByDelete",
				type : "post",
				data : {
					'aryJson' : aryJson,
					'key': key,
					'id': id
				},
				success : function(r) {
					if (r.code == 0) {
						layer.msg(r.msg);
						$(a).parents("tr").remove();
					} else {
						layer.msg(r.msg);
					}
				}
			});
			
		})
	}
	

}

function edit(id) {
    //var discountname = $("input[name='discountname']").val()
    //var discountdesc = $("input[name='discountdesc']").val()
    //alert(input_content);
    var content = $('#signupForm').serialize();

    content = decodeURIComponent(content,true);

    $.ajax({
        cache : true,
        type : "POST",
        url : "/set/ticketprice/update",
        data : {content:content,id:id},// 你的formid
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

/*function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/set/ticketprice/update",
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

}*/


function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			merchantCode : {
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
			merchantCode : {
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