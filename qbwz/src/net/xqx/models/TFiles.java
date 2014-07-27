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
 * 文件表
 * 
 * @author siyi
 * 
 */
@Entity
public class TFiles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 文件名称
	 */
	private String fName;

	/**
	 * 来源
	 */
	private String fly;

	/**
	 * 作者
	 */
	private String fAuth;

	/**
	 * 下载地址
	 */
	private String fDownloadAddress;

	/**
	 * 软件语言
	 */
	private String fLanguage;

	/**
	 * 整理时间
	 */
	private Date fzlTime;

	/**
	 * 运行环境
	 */
	private String fyxEnvironment;

	/**
	 * 软件大小，M为单位
	 */
	private Double fSize;

	/**
	 * 软件等级,为以显示一颗星，依次类推
	 */
	@OneToOne
	@JoinColumn(name = "fGrande")
	private TProperty fGrade;

	/**
	 * 授权方式
	 */
	private Long fsqWay;

	/**
	 * 软件简介
	 */
	private String frjBrief;

	/**
	 * 下载次数
	 */
	private String fdownTimes;

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

	public String getfLanguage() {
		return fLanguage;
	}

	public void setfLanguage(String fLanguage) {
		this.fLanguage = fLanguage;
	}

	public Date getFzlTime() {
		return fzlTime;
	}

	public void setFzlTime(Date fzlTime) {
		this.fzlTime = fzlTime;
	}

	public String getFyxEnvironment() {
		return fyxEnvironment;
	}

	public void setFyxEnvironment(String fyxEnvironment) {
		this.fyxEnvironment = fyxEnvironment;
	}

	public Double getfSize() {
		return fSize;
	}

	public void setfSize(Double fSize) {
		this.fSize = fSize;
	}

	public TProperty getfGrade() {
		return fGrade;
	}

	public void setfGrade(TProperty fGrade) {
		this.fGrade = fGrade;
	}

	public Long getFsqWay() {
		return fsqWay;
	}

	public void setFsqWay(Long fsqWay) {
		this.fsqWay = fsqWay;
	}

	public String getFrjBrief() {
		return frjBrief;
	}

	public void setFrjBrief(String frjBrief) {
		this.frjBrief = frjBrief;
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

}
