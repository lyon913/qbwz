package net.xqx.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 留言表
 * 
 * @author siyi
 * 
 */
@Entity
public class TlyNews implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 昵称
	 */
	private String fNick;

	/**
	 * 标题
	 */
	private String fTitle;

	/**
	 * 性别，0为男，1为女
	 */
	private Long fSex;

	/**
	 * 联系方式
	 */
	private String fContact;

	/**
	 * 电子邮箱
	 */
	private String fEmail;

	/**
	 * qq号码
	 */
	private String fQq;

	/**
	 * 联系地址
	 */
	private String flinkAddress;

	/**
	 * ip地址
	 */
	private String fIp;

	/**
	 * 内容
	 */
	@Lob
	private String fContent;

	/**
	 * 留言性质,0为公开，1为悄悄话
	 */
	private Long fNature;

	/**
	 * 留言心情
	 */
	private String fMood;

	/**
	 * 验证码
	 */
	private String fCode;

	/**
	 * 发表时间
	 */
	private Date ffbTime;

	/**
	 * 修改时间
	 */
	private Date fxgTimes;

	/**
	 * 类型
	 */
	@OneToOne
	@JoinColumn(name = "flx")
	private TProperty flx;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<TlyhfNews> fhf ;
	/**
	 * 点击次数
	 */
	private Long fdjTimes;

	/**
	 * 是否审核
	 */
	private Long fIsPass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public Long getFdjTimes() {
		return fdjTimes;
	}

	public void setFdjTimes(Long fdjTimes) {
		this.fdjTimes = fdjTimes;
	}

	public Date getFfbTime() {
		return ffbTime;
	}

	public void setFfbTime(Date ffbTime) {
		this.ffbTime = ffbTime;
	}

	public Date getFxgTimes() {
		return fxgTimes;
	}

	public void setFxgTimes(Date fxgTimes) {
		this.fxgTimes = fxgTimes;
	}

	public TProperty getFlx() {
		return flx;
	}

	public void setFlx(TProperty flx) {
		this.flx = flx;
	}

	public String getfNick() {
		return fNick;
	}

	public void setfNick(String fNick) {
		this.fNick = fNick;
	}

	public Long getfSex() {
		return fSex;
	}

	public void setfSex(Long fSex) {
		this.fSex = fSex;
	}

	public String getfContact() {
		return fContact;
	}

	public void setfContact(String fContact) {
		this.fContact = fContact;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public String getfQq() {
		return fQq;
	}

	public void setfQq(String fQq) {
		this.fQq = fQq;
	}

	public String getFlinkAddress() {
		return flinkAddress;
	}

	public void setFlinkAddress(String flinkAddress) {
		this.flinkAddress = flinkAddress;
	}

	public Long getfNature() {
		return fNature;
	}

	public void setfNature(Long fNature) {
		this.fNature = fNature;
	}

	public String getfMood() {
		return fMood;
	}

	public void setfMood(String fMood) {
		this.fMood = fMood;
	}

	public String getfCode() {
		return fCode;
	}

	public void setfCode(String fCode) {
		this.fCode = fCode;
	}

	public String getfIp() {
		return fIp;
	}

	public void setfIp(String fIp) {
		this.fIp = fIp;
	}

	public Long getfIsPass() {
		return fIsPass;
	}

	public void setfIsPass(Long fIsPass) {
		this.fIsPass = fIsPass;
	}

	public List<TlyhfNews> getFhf() {
		return fhf;
	}

	public void setFhf(List<TlyhfNews> fhf) {
		this.fhf = fhf;
	}

	

}
