package net.xqx.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 管理员
 * 
 * @author siyi
 * 
 */
@Entity
public class TAdmin implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 管理员名称
	 */
	private String fAdminName;

	/**
	 * 管理员密码
	 */
	private String fAdminPassword;

	/**
	 * 所属权限组
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fFuncGroup")
	private TFuncGroup fFuncGroup;

	/**
	 * 备注
	 */
	private String fMemo;

	/**
	 * 最后登录id
	 */
	private String fLastIP;

	/**
	 * 最后登录时间
	 */
	private Date fLoginTime;

	/**
	 * 登录次数
	 */
	private Long fLoginTimes;

	/**
	 * 加密狗
	 */
	private String fIkey;

	public String getfAdminName() {
		return fAdminName;
	}

	public void setfAdminName(String fAdminName) {
		this.fAdminName = fAdminName;
	}

	public String getfAdminPassword() {
		return fAdminPassword;
	}

	public void setfAdminPassword(String fAdminPassword) {
		this.fAdminPassword = fAdminPassword;
	}

	public TFuncGroup getfFuncGroup() {
		return fFuncGroup;
	}

	public void setfFuncGroup(TFuncGroup fFuncGroup) {
		this.fFuncGroup = fFuncGroup;
	}

	public String getfMemo() {
		return fMemo;
	}

	public void setfMemo(String fMemo) {
		this.fMemo = fMemo;
	}

	public String getfLastIP() {
		return fLastIP;
	}

	public void setfLastIP(String fLastIP) {
		this.fLastIP = fLastIP;
	}

	public Date getfLoginTime() {
		return fLoginTime;
	}

	public void setfLoginTime(Date fLoginTime) {
		this.fLoginTime = fLoginTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getfLoginTimes() {
		return fLoginTimes;
	}

	public void setfLoginTimes(Long fLoginTimes) {
		this.fLoginTimes = fLoginTimes;
	}

	public String getfIkey() {
		return fIkey;
	}

	public void setfIkey(String fIkey) {
		this.fIkey = fIkey;
	}

}
