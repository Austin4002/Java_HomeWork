$(document).ready(function(){
  $("#panel-function1").mouseenter(function(){
    $("#panel-function1").css("background-color","#34374C").css("color","#fff");
  });
	$("#panel-function1").mouseleave(function(){
		$("#panel-function1").css("background-color","#fff").css("color","black");
	});
});

$(document).ready(function(){
  $("#panel-function2").mouseenter(function(){
    $("#panel-function2").css("background-color","#34374C").css("color","#fff");
  });
	$("#panel-function2").mouseleave(function(){
		$("#panel-function2").css("background-color","#fff").css("color","black");
	});
});

$(document).ready(function(){
  $("#panel-function3").mouseenter(function(){
    $("#panel-function3").css("background-color","#34374C").css("color","#fff");
  });
	$("#panel-function3").mouseleave(function(){
		$("#panel-function3").css("background-color","#fff").css("color","black");
	});
});

$(document).ready(function(){
  $("#save").click(function(){
	var title = $("#title").val();
	var text = $("#text").val();
    $("#strong").html(title);
	$("#p").html(text);
  });
	
});

$(document).ready(function(){
	var btn =[$(".btn_login"), $(".btn_stay"),  $(".btn_write")];
	var colorArr = ["#34374C", "#2C2E3E", "#DB9019", "#5Ed5d1", "#ff6e97",  "#f1aaa6"];
	for(var i=0;i<btn.length;i++){
		var btnItem = btn[i];
		var colorItem = parseInt(Math.random()*6);
		btnItem.css("color",colorArr[colorItem]);
		btnItem.css("border-color",colorArr[colorItem]);
	}
});