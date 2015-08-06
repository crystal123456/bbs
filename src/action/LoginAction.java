package action;

import org.apache.struts2.convention.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	public String execute(){
		return SUCCESS;
	}

}
