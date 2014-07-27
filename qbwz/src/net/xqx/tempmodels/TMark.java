package net.xqx.tempmodels;


/**
 * Achievement entity. @author MyEclipse Persistence Tools
 */

public class TMark implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String licenseNo;
	private String firstgoal;
	private String secondgoal;
	private String thirdgoal;
	private String fourgoal;
	private String admissionNo;
	private String archiveNo;
	private String theyear;
	private String status;
	private String excelname;
	private String remark;

	// Constructors

	/** default constructor */
	public TMark() {
	}

	public TMark(String name, String licenseNo, String firstgoal,
			String secondgoal, String thirdgoal, String fourgoal,
			String admissionNo, String archiveNo, String theyear,
			String status, String excelname) {
		super();
		this.name = name;
		this.licenseNo = licenseNo;
		this.firstgoal = firstgoal;
		this.secondgoal = secondgoal;
		this.thirdgoal = thirdgoal;
		this.fourgoal = fourgoal;
		this.admissionNo = admissionNo;
		this.archiveNo = archiveNo;
		this.theyear = theyear;
		this.status = status;
		this.excelname = excelname;
		this.remark = remark;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNo() {
		return this.licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getArchiveNo() {
		return this.archiveNo;
	}

	public void setArchiveNo(String archiveNo) {
		this.archiveNo = archiveNo;
	}

	public String getTheyear() {
		return this.theyear;
	}

	public void setTheyear(String theyear) {
		this.theyear = theyear;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExcelname() {
		return excelname;
	}

	public void setExcelname(String excelname) {
		this.excelname = excelname;
	}

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getFirstgoal() {
		return firstgoal;
	}

	public void setFirstgoal(String firstgoal) {
		this.firstgoal = firstgoal;
	}

	public String getSecondgoal() {
		return secondgoal;
	}

	public void setSecondgoal(String secondgoal) {
		this.secondgoal = secondgoal;
	}

	public String getThirdgoal() {
		return thirdgoal;
	}

	public void setThirdgoal(String thirdgoal) {
		this.thirdgoal = thirdgoal;
	}

	public String getFourgoal() {
		return fourgoal;
	}

	public void setFourgoal(String fourgoal) {
		this.fourgoal = fourgoal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}