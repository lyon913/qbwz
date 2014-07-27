package net.xqx.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 权限列表
 * 
 * @author siyi
 * 
 */
@Entity
public class TFuncList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	/**
	 * 权限名称
	 */
	private String fFuncName;

	/**
	 * 权限链接地址
	 */
	private String fFuncURL;

	/**
	 * 父id
	 */
	private Long fid;

	/**
	 * 列表排序
	 */
	private Long fFuncSort;

	/**
	 * 功能说明
	 */
	private String fFuncMemo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfFuncName() {
		return fFuncName;
	}

	public void setfFuncName(String fFuncName) {
		this.fFuncName = fFuncName;
	}

	public String getfFuncURL() {
		return fFuncURL;
	}

	public void setfFuncURL(String fFuncURL) {
		this.fFuncURL = fFuncURL;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getfFuncSort() {
		return fFuncSort;
	}

	public void setfFuncSort(Long fFuncSort) {
		this.fFuncSort = fFuncSort;
	}

	public String getfFuncMemo() {
		return fFuncMemo;
	}

	public void setfFuncMemo(String fFuncMemo) {
		this.fFuncMemo = fFuncMemo;
	}

}
