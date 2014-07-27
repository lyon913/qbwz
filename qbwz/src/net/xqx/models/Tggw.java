package net.xqx.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 广告位表
 * 
 * @author gwang
 * 
 */
@Entity
public class Tggw {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//广告位名称
	private String fName;
	
	//广告位位置描述
	private String fLocationDes;
	
	//广告位图片数
	private Integer picnum;

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

	public String getfLocationDes() {
		return fLocationDes;
	}

	public void setfLocationDes(String fLocationDes) {
		this.fLocationDes = fLocationDes;
	}

	public Integer getPicnum() {
		return picnum;
	}

	public void setPicnum(Integer picnum) {
		this.picnum = picnum;
	}
	
	
}
