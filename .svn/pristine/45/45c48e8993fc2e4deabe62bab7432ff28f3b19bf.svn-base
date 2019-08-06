var buildindex=null;
$("#document").ready(function(){
	    new TINY.editor.edit('editor', {
		        id: 'newscontent',
		        width: 850,
		        height: 185,
		        cssclass: 'te',
		        controlclass: 'tecontrol',
		        rowclass: 'teheader',
		        dividerclass: 'tedivider',
		        controls: ['bold', 'italic', 'underline', 'strikethrough', '|', 'subscript', 'superscript', '|',
		 'orderedlist', 'unorderedlist', '|', 'outdent', 'indent', '|', 'leftalign',
		 'centeralign', 'rightalign', 'blockjustify', '|', 'unformat', '|', 'undo', 'redo', 'n',
		 'font', 'size', 'style', '|', 'image', 'hr', 'link', 'unlink', '|', 'cut', 'copy', 'paste', 'print'],
		        footer: true,
		        fonts: ['新宋体', '黑体', 'Verdana', 'Arial', 'Georgia', 'Trebuchet MS', '微软雅黑', '宋体', '幼圆', '楷体', '华文行楷'],
		        xhtml: true,
		        cssfile: 'style.css',
		        bodyid: 'editor',
		        footerclass: 'tefooter',
		        toggle: { text: 'source', activetext: 'wysiwyg', cssclass: 'toggle' },
		        resize: { cssclass: 'resize' }
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
	editor.post(); 
	//instance.post();
	var newscontent = document.getElementById("newscontent").value; 
	if(!newscontent)
	{
		layer.alert('请填写正文内容');
		return;
	}
	var obj = $("#merchantcode option:selected");
	var  artime_val  = obj.val();
	
    $.ajax({
        cache : true,
        type : "POST",
        url : "/operation/article/api/add",
        data : {
        	arttype:$("#arttype").val(),
        	arttitle:$("#arttitle").val(),
        	artsummary:$("#artsummary").val(),
        	content:newscontent,
        	imgpath:$("#upimg").data("id"),
        	merchantCode:artime_val
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
