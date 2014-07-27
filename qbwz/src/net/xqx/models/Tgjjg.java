package net.xqx.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tgjjg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//名称
	private String fname;
	//法人
	private String ffr;
	//资质等级
	private String fzzdj;
	//资质证号
	private String fzzzh;
	//证书开始时间
	private String fkssj;
	//证书结束时间
	private String fjssj;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFfr() {
		return ffr;
	}
	public void setFfr(String ffr) {
		this.ffr = ffr;
	}
	public String getFzzdj() {
		return fzzdj;
	}
	public void setFzzdj(String fzzdj) {
		this.fzzdj = fzzdj;
	}
	public String getFzzzh() {
		return fzzzh;
	}
	public void setFzzzh(String fzzzh) {
		this.fzzzh = fzzzh;
	}
	public String getFkssj() {
		return fkssj;
	}
	public void setFkssj(String fkssj) {
		this.fkssj = fkssj;
	}
	public String getFjssj() {
		return fjssj;
	}
	public void setFjssj(String fjssj) {
		this.fjssj = fjssj;
	}
	
	
}
