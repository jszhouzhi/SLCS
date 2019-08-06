var buildindex=null;
$("#document").ready(function(){
	layui.use('layedit', function(){
	  var layedit = layui.layedit;
		layedit.set({
			  uploadImage: {
				 url : "/operation/article/image/single"
			    ,type: 'POST'
			  }
	});
	  buildindex = layedit.build('newscontent'); 
	});
    validateRule();
    $('#fileupload').fileupload({
        dataType: 'json',
        done: function (e, data) {
        	$("#upimg").data("id",data.result.fileName);
        	$("#upimg").attr("src",data.result.fileName);
        }
    });
});

$.validator.setDefaults({
    submitHandler : function(form) {
        save();
    }
});
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#form").validate({
        rules : {
        	arttype : {
                required : true
            },
            arttitle : {
		        required : true
		    },
		    artsummary : {
		        required : true
		    }
        },
        messages : {
        	arttype : {
                required : icon + "请选择文章类型"
            },
            arttitle : {
	            required : icon + "请填写文章标题"
	        },
	        artsummary : {
	            required : icon + "请填写文章摘要"
	        }
        }
    });
}

function save() {
	var layedit = layui.layedit;
	var newscontent=layedit.getContent(buildindex);
	if(!newscontent)
	{
		layer.alert('请填写正文内容');
		return;
	}
    $.ajax({
        cache : true,
        type : "POST",
        url : "/operation/article/api/edit",
        data : {
        	id:$("#id").val(),
        	arttype:$("#arttype").val(),
        	arttitle:$("#arttitle").val(),
        	artsummary:$("#artsummary").val(),
        	content:newscontent,
        	imgpath:$("#upimg").data("id")?$("#upimg").data("id"):$("#imgpath").val()
        },
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
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
