package net.xqx.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 属性表
 * 
 * @author siyi
 * 
 */
@Entity
public class TProperty implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 父id
	 */
	private Long fId;
	
	/**
	 * 属性名称
	 */
	private String fName;
	
	/**
	 * 属性值
	 */
	private String fValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfValue() {
		return fValue;
	}

	public void setfValue(String fValue) {
		this.fValue = fValue;
	}
	
	
}
