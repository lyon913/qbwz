package net.xqx.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * 下载中心
 * 
 * @author siyi
 * 
 */
@Entity
public class TxzzxNews implements Serializable {

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
	private String fTitle;

	/**
	 * 来源
	 */
	private String fly;

	/**
	 * 作者
	 */
	private String fAuth;

	/**
	 * 资料描述
	 */
	@Lob
	private String fContent;

	/**
	 * 发表时间
	 */
	private Date ffbTime;

	/**
	 * 修改时间
	 */
	private Date fxgTime;

	/**
	 * 置顶时间
	 */
	private Date fzdTime;

	/**
	 * 置顶标记
	 */
	private Long fSortFlag;

	/**
	 * 类型一级
	 */
	@JoinColumn(name = "flxFirst")
	@OneToOne(fetch = FetchType.EAGER)
	private TProperty flxFirst;

	/**
	 * 类型二级
	 */
	@JoinColumn(name = "flxSecond")
	@OneToOne(fetch = FetchType.EAGER)
	private TProperty flxSecond;

	/**
	 * 是否审核通过
	 */
	private Long fIsPass;

	/**
	 * 是否显示
	 */
	private Long fIsShow;

	/**
	 * 关键字
	 */
	private String fKeyWord;

	/**
	 * 新闻显示图
	 */
	private String fNewsPic;

	/**
	 * 附加文件
	 */
	@OneToOne
	@JoinColumn(name="fFile")
	private TFiles fFile;
	
	/**
	 * 点击次数
	 */
	private Long fdjTimes;

	/**
	 * 是否推荐
	 */
	private Long fIsRecord;
	
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

	public String getfAuth() {
		return fAuth;
	}

	public void setfAuth(String fAuth) {
		this.fAuth = fAuth;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public Date getFfbTime() {
		return ffbTime;
	}

	public void setFfbTime(Date ffbTime) {
		this.ffbTime = ffbTime;
	}

	public Date getFxgTime() {
		return fxgTime;
	}

	public void setFxgTime(Date fxgTime) {
		this.fxgTime = fxgTime;
	}

	

	public TProperty getFlxFirst() {
		return flxFirst;
	}

	public void setFlxFirst(TProperty flxFirst) {
		this.flxFirst = flxFirst;
	}

	public TProperty getFlxSecond() {
		return flxSecond;
	}

	public void setFlxSecond(TProperty flxSecond) {
		this.flxSecond = flxSecond;
	}

	public String getFly() {
		return fly;
	}

	public void setFly(String fly) {
		this.fly = fly;
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

	public String getfNewsPic() {
		return fNewsPic;
	}

	public void setfNewsPic(String fNewsPic) {
		this.fNewsPic = fNewsPic;
	}

	public TFiles getfFile() {
		return fFile;
	}

	public void setfFile(TFiles fFile) {
		this.fFile = fFile;
	}

	public String getfKeyWord() {
		return fKeyWord;
	}

	public void setfKeyWord(String fKeyWord) {
		this.fKeyWord = fKeyWord;
	}

	public Long getfIsRecord() {
		return fIsRecord;
	}

	public void setfIsRecord(Long fIsRecord) {
		this.fIsRecord = fIsRecord;
	}

	public Long getFdjTimes()
	{
		return fdjTimes;
	}

	public void setFdjTimes(Long fdjTimes)
	{
		this.fdjTimes = fdjTimes;
	}
	
	

}
