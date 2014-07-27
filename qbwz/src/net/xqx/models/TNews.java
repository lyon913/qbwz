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
 * 新闻类
 * 
 * @author siyi
 * 
 */
@Entity
public class TNews implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 标题
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

	private String fKeyWord;

	/**
	 * 内容
	 */
	@Lob
	private String fContent;

	/**
	 * 发表时间
	 */
	private Date ffbTime;

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
	 * 点击次数
	 */
	private Long fdjTimes;

	/**
	 * 是否审核通过
	 */
	private Long fIsPass;

	/**
	 * 是否显示
	 */
	private Long fIsShow;

	/**
	 * 新闻显示图
	 */
	private String fNewsPic;

	/**
	 * 是否推荐
	 */
	private Long fIsRecord;

	/**
	 * 是否为头条
	 */
	private Long fIsTop;

	/**
	 * 发布文号
	 */
	private String fDocumentNo;

	private Date fBeginValidDate;
	/**
	 * 生效日期
	 */

	private Date fEndValidDate;

	/**
	 * 发布机关
	 */
	private String fPublishOrganization;
	/**
	 * 文件类型
	 */
	private String fDocumentType;
	
	/**
	 * 顺序，小的排在前面
	 */
	private Integer fSort;


	/**
	 * 职务
	 */
	private String fOcc;


	public Date getfBeginValidDate()
	{
		return fBeginValidDate;
	}

	public void setfBeginValidDate(Date fBeginValidDate)
	{
		this.fBeginValidDate = fBeginValidDate;
	}

	public Date getfEndValidDate()
	{
		return fEndValidDate;
	}

	public void setfEndValidDate(Date fEndValidDate)
	{
		this.fEndValidDate = fEndValidDate;
	}

	public String getfDocumentNo()
	{
		return fDocumentNo;
	}

	public void setfDocumentNo(String fDocumentNo)
	{
		this.fDocumentNo = fDocumentNo;
	}

	public String getfPublishOrganization()
	{
		return fPublishOrganization;
	}

	public void setfPublishOrganization(String fPublishOrganization)
	{
		this.fPublishOrganization = fPublishOrganization;
	}

	public String getfDocumentType()
	{
		return fDocumentType;
	}

	public void setfDocumentType(String fDocumentType)
	{
		this.fDocumentType = fDocumentType;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getfTitle()
	{
		return fTitle;
	}

	public void setfTitle(String fTitle)
	{
		this.fTitle = fTitle;
	}

	public String getfAuth()
	{
		return fAuth;
	}

	public void setfAuth(String fAuth)
	{
		this.fAuth = fAuth;
	}

	public String getfContent()
	{
		return fContent;
	}

	public void setfContent(String fContent)
	{
		this.fContent = fContent;
	}

	public Long getFdjTimes()
	{
		return fdjTimes;
	}

	public void setFdjTimes(Long fdjTimes)
	{
		this.fdjTimes = fdjTimes;
	}

	public Date getFfbTime()
	{
		return ffbTime;
	}

	public void setFfbTime(Date ffbTime)
	{
		this.ffbTime = ffbTime;
	}

	public String getFly()
	{
		return fly;
	}

	public void setFly(String fly)
	{
		this.fly = fly;
	}

	public Date getFzdTime()
	{
		return fzdTime;
	}

	public void setFzdTime(Date fzdTime)
	{
		this.fzdTime = fzdTime;
	}

	public Long getfSortFlag()
	{
		return fSortFlag;
	}

	public void setfSortFlag(Long fSortFlag)
	{
		this.fSortFlag = fSortFlag;
	}

	public Long getfIsPass()
	{
		return fIsPass;
	}

	public void setfIsPass(Long fIsPass)
	{
		this.fIsPass = fIsPass;
	}

	public Long getfIsShow()
	{
		return fIsShow;
	}

	public void setfIsShow(Long fIsShow)
	{
		this.fIsShow = fIsShow;
	}

	public String getfNewsPic()
	{
		return fNewsPic;
	}

	public void setfNewsPic(String fNewsPic)
	{
		this.fNewsPic = fNewsPic;
	}

	public Long getfIsRecord()
	{
		return fIsRecord;
	}

	public void setfIsRecord(Long fIsRecord)
	{
		this.fIsRecord = fIsRecord;
	}

	public TProperty getFlxFirst()
	{
		return flxFirst;
	}

	public void setFlxFirst(TProperty flxFirst)
	{
		this.flxFirst = flxFirst;
	}

	public TProperty getFlxSecond()
	{
		return flxSecond;
	}

	public void setFlxSecond(TProperty flxSecond)
	{
		this.flxSecond = flxSecond;
	}

	public String getfKeyWord()
	{
		return fKeyWord;
	}

	public void setfKeyWord(String fKeyWord)
	{
		this.fKeyWord = fKeyWord;
	}

	public Long getfIsTop()
	{
		return fIsTop;
	}

	public void setfIsTop(Long fIsTop)
	{
		this.fIsTop = fIsTop;
	}

	public Integer getfSort() {
		return fSort;
	}

	public void setfSort(Integer fSort) {
		this.fSort = fSort;
	}

	public String getfOcc() {
		return fOcc;
	}

	public void setfOcc(String fOcc) {
		this.fOcc = fOcc;
	}
}
