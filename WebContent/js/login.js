// 转向找回密码页面
function toPwdBack()
{
	window.location.href = "action/loginAction!toPwdBack.action";
}

// 验证码
function  getOther(){
	 var timenow = new Date().getTime();                            
     document.getElementById("jcaptcha").src= webroot + "servlet/JcaptchaServlet?d="+timenow;  
}

// 登入验证	
function vaildateForm()
{
	var name = document.getElementById("members.userName");
	var pwd = document.getElementById("members.password");
	var v = document.getElementById("putjcaptcha");
	if(trim(name.value)=='') {
		showMsg("用户名不能为空！");
		name.focus();
		return false;
    }
	if(trim(pwd.value)=='') {
		showMsg("密码不能为空！");
		pwd.focus();
		return false;
	}
	if(trim(v.value)==''){
	    showMsg("验证码不能为空！");
		v.focus();
		return false;
	}
	return true;
}

// 验证成功挑转
function login(){
	// 用户名
    var name = document.getElementById("user.userName").value;
	// 密码
    var pwd = document.getElementById("user.password").value;
	// 验证码
    var jpt = document.getElementById("putjcaptcha").value;
	if(vaildateForm()){
		//登录跳转
		$.ajax({   
	        type:"POST",   
	        url:"action/loginAction!loginNameValidate.action",  
	        dataType: "json",
	        data:{name:trim(name),pwd:trim(pwd),jpt:trim(jpt)},   
	        beforeSend:function(){
	        	//$("#loading").css('display','block');
	        },                
	        success:function(d, textStatus){
	        	if(d.check=="succ")
	        	{
	        		window.location.href = "action/loginAction!toIndex.action";
	        	}else if(d.check=="failLogin"){
	        		showMsg("用户名或密码错误！");
		            return false;
	        	}else if(d.check=="failjpt"){
	        		getOther();
	        	    showMsg("验证码错误！");
		            return false;
	        	}else if(d.check=="failStatus"){//未激活页面
	        	    window.location.href = "user/userLoginAction!noStatus.action";
	        	}
	        },
			error: function (xhttp, textStatus, errorThrown) { 
				alert(errorThrown);
			}               
	     }); 
	}
}