package net.xqx.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 首页链接表
 * 
 * @author siyi
 * 
 */
@Entity
public class TClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 链接名称
	 */
	private String fClassName;

	/**
	 * 链接地址
	 */
	private String fLink;

	/**
	 * 排序
	 */
	private Long fSortFlag;

	/**
	 * 备注
	 */
	private String fClassMemo;

	/**
	 * 父id
	 */
	private Long fid;
	
	private Long typeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfClassName() {
		return fClassName;
	}

	public void setfClassName(String fClassName) {
		this.fClassName = fClassName;
	}

	public String getfLink() {
		return fLink;
	}

	public void setfLink(String fLink) {
		this.fLink = fLink;
	}

	public Long getfSortFlag() {
		return fSortFlag;
	}

	public void setfSortFlag(Long fSortFlag) {
		this.fSortFlag = fSortFlag;
	}

	public String getfClassMemo() {
		return fClassMemo;
	}

	public void setfClassMemo(String fClassMemo) {
		this.fClassMemo = fClassMemo;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	

}
