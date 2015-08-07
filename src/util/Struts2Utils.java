package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

public class Struts2Utils {

	/**
	 * 获取request
	 * @return
	 */
	public static HttpServletRequest getRequest()
    {
        return ServletActionContext.getRequest();
    }
	
	/**
	 * 获取response
	 * @return
	 */
	public static HttpServletResponse getResponse()
    {
        return ServletActionContext.getResponse();
    }
	
	/**
	 * 获取parameter
	 * @param name
	 * @return
	 */
	public static String getParameter(String name)
    {
        return getRequest().getParameter(name);
    }

}
