(function(){
	$("#document").ready(function(){
		var inputbox=$(".commonquerypage").find(".query-inputs");
		var inputsearch=$(".commonquerypage").find(".searchinput");
		$(".commonquerypage").find(".modechangebtn").on("click",function(){
			if(!$(this).hasClass("nothigh"))
			{
				$(this).html("基本查询 <i class=\"fa fa-chevron-up\"></i>");
				$(this).addClass("nothigh");
				inputbox.show();
			}else
			{
				$(this).html("高级查询 <i class=\"fa fa-chevron-down\"></i>");
				$(this).removeClass("nothigh");
				inputbox.hide();
			}
		});
		$(".commonquerypage").find(".modechangebtn").click();
		$(".commonquerypage").find(".modechangebtn2").on("click",function(){
			if(!inputbox.hasClass("show"))
			{
				$(this).html("<i class=\"fa fa-chevron-up\"></i>");
				inputbox.addClass("show");
				inputbox.show();
			}else
			{
				$(this).html("<i class=\"fa fa-chevron-down\"></i>");
				inputbox.removeClass("show");
				inputbox.hide();
			}
		});
		$(".commonquerypage").find("#btnreset").on("click",function(){
			inputsearch.val("");
			inputbox.find("input[type='text'],input[type='textarea'],select").each(function(){
				$(this).val("");
			});
		});
		layui.use('form', function(){});
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  laydate.render({
			  	elem: '.datepicker'
				  	,type: 'date'
				  	,range: false 
		  });
		});
		inputsearch.focus(function() {
			inputsearch.select();
		});
	});
})();