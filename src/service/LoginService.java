package service;

import model.User;

/**
 * 用户登录Service
 * @author fred
 *
 */
public interface LoginService {
	
	/**
	 * 验证用户名是否存在
	 * @param userName 用户名
	 * @return
	 */
	User vailUser(String userName);

}
