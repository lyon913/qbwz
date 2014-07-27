package net.xqx.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 友情链接,图片链接
 * 
 * @author siyi
 * 
 */
@Entity
public class TtpLinks implements Serializable {

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
	 * 图片地址
	 */
	private String fPicLinkAddress;

	/**
	 * 友情链接排序
	 */
	private Long fSortFlag;

	/**
	 * 是否显示
	 */
	private Long fIsShow;
	
	//图片链接类型
	@JoinColumn(name = "flx")
	@OneToOne(fetch = FetchType.EAGER)
	private TProperty flx;
	
	public TProperty getFlx() {
		return flx;
	}

	public void setFlx(TProperty flx) {
		this.flx = flx;
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

	public String getfPicLinkAddress() {
		return fPicLinkAddress;
	}

	public void setfPicLinkAddress(String fPicLinkAddress) {
		this.fPicLinkAddress = fPicLinkAddress;
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
