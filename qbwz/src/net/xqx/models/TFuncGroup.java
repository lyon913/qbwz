package net.xqx.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 权限组
 * 
 * @author siyi
 * 
 */
@Entity
public class TFuncGroup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	/**
	 * 权限组名称
	 */
	private String fFuncGroupName;

	/**
	 * 拥有权限
	 */
	private String fFuncRights;

	/**
	 * 功能说明
	 */
	private String fFuncGroupMemo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfFuncGroupName() {
		return fFuncGroupName;
	}

	public void setfFuncGroupName(String fFuncGroupName) {
		this.fFuncGroupName = fFuncGroupName;
	}

	public String getfFuncRights() {
		return fFuncRights;
	}

	public void setfFuncRights(String fFuncRights) {
		this.fFuncRights = fFuncRights;
	}

	public String getfFuncGroupMemo() {
		return fFuncGroupMemo;
	}

	public void setfFuncGroupMemo(String fFuncGroupMemo) {
		this.fFuncGroupMemo = fFuncGroupMemo;
	}

}
