<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/login.js"></script>
</head>
<body>
<div>
	<form action="" method="post">
		<table>
			<tr>
                <td colspan="2">
                	<div id="valHtml" style="display: none;">
                		<span id="msg" class="yellow_font">
                			<font>${msg}</font>
                		</span>
                	</div>
                </td>
            </tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="user.userName" id="user.userName"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="user.password" id="user.userName"/><a href="javascript:toPwdBack();" class="logon_link">忘记密码</a></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td>
					<input type="text" name="putjcaptcha" id="putjcaptcha"/>
					<img id="jcaptcha" src="/action/putjcaptcha" width="60" height="22"/>&nbsp;&nbsp;
					<a href="javascript:getOther();" class="">看不清，换一张</a>				
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input name="loginButton" type="button" class="home_but" id="loginButton" onclick="login();" value="登 录"/>
					<a href="action/userReg!openRegAgreementPage.action" class="logon_link">新用户注册</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>