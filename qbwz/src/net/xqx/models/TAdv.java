package net.xqx.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 广告类
 * 
 * @author siyi
 * 
 */
@Entity
public class TAdv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 广告名称
	 */
	private String fName;

	/**
	 * 链接地址
	 */
	private String fLinkAddress;

	/**
	 * 广告位置
	 */
	@OneToOne
	@JoinColumn(name = "fwz")
	private Tggw fwz;
	
	/**
	 * 是否显示
	 */
	private Long fIsShow;
	
	/**
	 * 广告图片路径
	 */
	private String fURL;
	
	public String getfURL() {
		return fURL;
	}

	public void setfURL(String fURL) {
		this.fURL = fURL;
	}

	public Long getfIsShow() {
		return fIsShow;
	}

	public void setfIsShow(Long fIsShow) {
		this.fIsShow = fIsShow;
	}

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

	public Tggw getFwz() {
		return fwz;
	}

	public void setFwz(Tggw fwz) {
		this.fwz = fwz;
	}


}
