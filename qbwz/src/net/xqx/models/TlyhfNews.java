package net.xqx.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * 留言回复表
 * 
 * @author siyi
 * 
 */
@Entity
public class TlyhfNews implements Serializable {

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
	@ManyToOne
	@JoinColumn(name = "flyId")
	private TlyNews flyId;

	/**
	 * 回复人
	 */
	private String fAuth;

	/**
	 * 内容
	 */
	@Lob
	private String fContent;

	/**
	 * 发表时间
	 */
	private Date fhfTime;

	/**
	 * 点击次数
	 */
	private Long fdjTimes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getFdjTimes() {
		return fdjTimes;
	}

	public void setFdjTimes(Long fdjTimes) {
		this.fdjTimes = fdjTimes;
	}

	public TlyNews getFlyId() {
		return flyId;
	}

	public void setFlyId(TlyNews flyId) {
		this.flyId = flyId;
	}

	public Date getFhfTime() {
		return fhfTime;
	}

	public void setFhfTime(Date fhfTime) {
		this.fhfTime = fhfTime;
	}

}
