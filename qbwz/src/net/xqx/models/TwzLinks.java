package net.xqx.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 友情链接，文字链接
 * 
 * @author siyi
 * 
 */
@Entity
public class TwzLinks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 友情链接名称
	 */
	private String fName;

	/**
	 * 链接地址
	 */
	private String fLinkAddress;

	/**
	 * 排序
	 */
	private Long fSortFlag;

	/**
	 * 是否显示
	 */
	private Long fIsShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfLinkAddress() {
		return fLinkAddress;
	}

	public void setfLinkAddress(String fLinkAddress) {
		this.fLinkAddress = fLinkAddress;
	}

	public Long getfSortFlag() {
		return fSortFlag;
	}

	public void setfSortFlag(Long fSortFlag) {
		this.fSortFlag = fSortFlag;
	}

	public Long getfIsShow() {
		return fIsShow;
	}

	public void setfIsShow(Long fIsShow) {
		this.fIsShow = fIsShow;
	}

}
