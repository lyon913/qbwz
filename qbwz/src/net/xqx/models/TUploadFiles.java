package net.xqx.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 资料文件类
 * 该类区别于下载中心，为提供如专业人才模块的考试资料，政策法规模块的文件等。
 * 
 * @author siyi
 * 
 */
@Entity
public class TUploadFiles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 资料名称
	 */
	private String fName;
	
	/**
	 * 资料描述
	 */
	private String fContent;
	
	/**
	 * 类别
	 */
	@OneToOne
	@JoinColumn(name="flx")
	private TProperty flx;
	
	/**
	 * 关键字
	 */
	private String fKeyWord;

	/**
	 * 来源
	 */
	private String fly;
	
	/**
	 * 上传时间
	 */
	private Date fuploadTime;

	/**
	 * 作者
	 */
	private String fAuth;
	
	/**
	 * 是否审核通过
	 */
	private Long fIsPass;
	
	/**
	 * 是否显示
	 */
	private Long fIsShow;
	
	/**
	 * 是否推荐
	 */
	private Long fIsRecord;

	/**
	 * 下载地址
	 */
	private String fDownloadAddress;

	/**
	 * 下载次数
	 */
	private String fdownTimes;
	
	/**
	 * 置顶时间
	 */
	private Date fzdTime;
	
	/**
	 * 排序
	 */
	private Long fSortFlag;
	
	/**
	 * 父id
	 */
	private Long fId;

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

	public String getFdownTimes() {
		return fdownTimes;
	}

	public void setFdownTimes(String fdownTimes) {
		this.fdownTimes = fdownTimes;
	}

	public String getFly() {
		return fly;
	}

	public void setFly(String fly) {
		this.fly = fly;
	}

	public String getfAuth() {
		return fAuth;
	}

	public void setfAuth(String fAuth) {
		this.fAuth = fAuth;
	}

	public String getfDownloadAddress() {
		return fDownloadAddress;
	}

	public void setfDownloadAddress(String fDownloadAddress) {
		this.fDownloadAddress = fDownloadAddress;
	}

	public Date getFuploadTime() {
		return fuploadTime;
	}

	public void setFuploadTime(Date fuploadTime) {
		this.fuploadTime = fuploadTime;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public TProperty getFlx() {
		return flx;
	}

	public void setFlx(TProperty flx) {
		this.flx = flx;
	}

	public String getfKeyWord() {
		return fKeyWord;
	}

	public void setfKeyWord(String fKeyWord) {
		this.fKeyWord = fKeyWord;
	}

	public Long getfIsPass() {
		return fIsPass;
	}

	public void setfIsPass(Long fIsPass) {
		this.fIsPass = fIsPass;
	}

	public Long getfIsShow() {
		return fIsShow;
	}

	public void setfIsShow(Long fIsShow) {
		this.fIsShow = fIsShow;
	}

	public Long getfIsRecord() {
		return fIsRecord;
	}

	public void setfIsRecord(Long fIsRecord) {
		this.fIsRecord = fIsRecord;
	}

	public Date getFzdTime() {
		return fzdTime;
	}

	public void setFzdTime(Date fzdTime) {
		this.fzdTime = fzdTime;
	}

	public Long getfSortFlag() {
		return fSortFlag;
	}

	public void setfSortFlag(Long fSortFlag) {
		this.fSortFlag = fSortFlag;
	}

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	
	

}
