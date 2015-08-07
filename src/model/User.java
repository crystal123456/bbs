package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 一般用户类
 * @author fred
 *
 */
@Entity
@Table(name="BBS_USERS")
public class User {
	
	// 用户id
	private Long id;
	
	// 用户名
	private String userName;
	
	// 密码
	private String password;
	
	// 忘记密码时的提示问题
	private String pwdResetPromt;
	
	// 忘记密码时的问题答案
	private String pwdResetAnswer;
	
	// 登录时间
	private Date loginTime;
	
	// 最后登录时间
	private Date lastLoginTime;
	
	// 用户状态（00：未激活，01：激活，02：已删除）
	private String status;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="user_name", nullable=false, length=100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password", nullable=false, length=50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="pwd_reset_promt", length=200)
	public String getPwdResetPromt() {
		return pwdResetPromt;
	}

	public void setPwdResetPromt(String pwdResetPromt) {
		this.pwdResetPromt = pwdResetPromt;
	}

	@Column(name="pwd_reset_answer", length=200)
	public String getPwdResetAnswer() {
		return pwdResetAnswer;
	}

	public void setPwdResetAnswer(String pwdResetAnswer) {
		this.pwdResetAnswer = pwdResetAnswer;
	}

	@Column(name="login_time")
	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name="last_login_time")
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name="status", length=2)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
