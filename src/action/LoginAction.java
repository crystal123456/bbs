package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;
import net.sf.json.JSONObject;
import service.LoginService;
import util.Struts2Utils;

/**
 * 用户登录Action
 * @author fred
 *
 */
@Namespace("/action")
@Actions({ @Action(value = "loginAction", results = {
		@Result(name = "loginSuccess", location = "/members/main.jsp"),
		@Result(name = "activatPage", location = "/members/activatPage.jsp"),
		@Result(name = "loginError", location = "/login.jsp")}) })
public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7922979648150320921L;
	
	/**
	 * 用户注册Service
	 */
	private LoginService loginService;
	
	@ResponseBody
	public String execute(){
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	public void userNameValidate() throws IOException{
		String jcaptcha = (String) Struts2Utils.getRequest().getAttribute("piccode");
		String userName = Struts2Utils.getParameter("name");
		String password = Struts2Utils.getParameter("pwd");
		String jpt = Struts2Utils.getParameter("jpt");
		
		User user = loginService.vailUser(userName);
		
		if(!jcaptcha.equals(jpt)){//判断输入的验证码是否正确
			response.setContentType("text/html;charset=UTF-8");   
			Map map = new HashMap();  
			map.put("check", "failjpt");  
			  
			String json = JSONObject.fromObject(map).toString();  
			response.getWriter().write(json.toString());  
			response.getWriter().flush();  
			response.getWriter().close(); 
		}else{
			if(null != user){
				String passwordDes=des3Util.getEncString(password);
			}
		}
	}

}
