package net.xqx.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 新闻图片
 * 
 * @author siyi
 * 
 */
@Entity
public class TNewsPic implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 图片名称
	 */
	private String fName;
	
	/**
	 * 图片地址,固定文件夹为newsPic
	 */
	private String fPicAddress;

	/**
	 * 所属项目
	 */
	@ManyToOne
	@JoinColumn(name="fNewsId")
	private TNews fNewsId;

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

	public String getfPicAddress() {
		return fPicAddress;
	}

	public void setfPicAddress(String fPicAddress) {
		this.fPicAddress = fPicAddress;
	}

	public TNews getfNewsId() {
		return fNewsId;
	}

	public void setfNewsId(TNews fNewsId) {
		this.fNewsId = fNewsId;
	}

}
