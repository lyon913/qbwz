
package net.xqx.service.certificate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for certificateReg complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="certificateReg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fagreeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fcertificateNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcertifyCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fcertifyDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fcity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fholdPeople" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flicenseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flicenseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fproCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fsex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ftype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fvalid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fvalidityTermEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fvalidityTermStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certificateReg", propOrder = {
    "fagreeDate",
    "fcertificateNo",
    "fcertifyCompany",
    "fcertifyDate",
    "fcity",
    "fholdPeople",
    "flicenseNo",
    "flicenseType",
    "fproCategory",
    "fsex",
    "ftype",
    "fvalid",
    "fvalidityTermEndDate",
    "fvalidityTermStartDate",
    "id"
})
public class CertificateReg {

    protected XMLGregorianCalendar fagreeDate;
    protected String fcertificateNo;
    protected String fcertifyCompany;
    protected XMLGregorianCalendar fcertifyDate;
    protected String fcity;
    protected String fholdPeople;
    protected String flicenseNo;
    protected String flicenseType;
    protected String fproCategory;
    protected String fsex;
    protected String ftype;
    protected String fvalid;
    protected XMLGregorianCalendar fvalidityTermEndDate;
    protected XMLGregorianCalendar fvalidityTermStartDate;
    protected Long id;

    /**
     * Gets the value of the fagreeDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFagreeDate() {
        return fagreeDate;
    }

    /**
     * Sets the value of the fagreeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFagreeDate(XMLGregorianCalendar value) {
        this.fagreeDate = value;
    }

    /**
     * Gets the value of the fcertificateNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcertificateNo() {
        return fcertificateNo;
    }

    /**
     * Sets the value of the fcertificateNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcertificateNo(String value) {
        this.fcertificateNo = value;
    }

    /**
     * Gets the value of the fcertifyCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcertifyCompany() {
        return fcertifyCompany;
    }

    /**
     * Sets the value of the fcertifyCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcertifyCompany(String value) {
        this.fcertifyCompany = value;
    }

    /**
     * Gets the value of the fcertifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFcertifyDate() {
        return fcertifyDate;
    }

    /**
     * Sets the value of the fcertifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFcertifyDate(XMLGregorianCalendar value) {
        this.fcertifyDate = value;
    }

    /**
     * Gets the value of the fcity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcity() {
        return fcity;
    }

    /**
     * Sets the value of the fcity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcity(String value) {
        this.fcity = value;
    }

    /**
     * Gets the value of the fholdPeople property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFholdPeople() {
        return fholdPeople;
    }

    /**
     * Sets the value of the fholdPeople property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFholdPeople(String value) {
        this.fholdPeople = value;
    }

    /**
     * Gets the value of the flicenseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlicenseNo() {
        return flicenseNo;
    }

    /**
     * Sets the value of the flicenseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlicenseNo(String value) {
        this.flicenseNo = value;
    }

    /**
     * Gets the value of the flicenseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlicenseType() {
        return flicenseType;
    }

    /**
     * Sets the value of the flicenseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlicenseType(String value) {
        this.flicenseType = value;
    }

    /**
     * Gets the value of the fproCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFproCategory() {
        return fproCategory;
    }

    /**
     * Sets the value of the fproCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFproCategory(String value) {
        this.fproCategory = value;
    }

    /**
     * Gets the value of the fsex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFsex() {
        return fsex;
    }

    /**
     * Sets the value of the fsex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFsex(String value) {
        this.fsex = value;
    }

    /**
     * Gets the value of the ftype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFtype() {
        return ftype;
    }

    /**
     * Sets the value of the ftype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtype(String value) {
        this.ftype = value;
    }

    /**
     * Gets the value of the fvalid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFvalid() {
        return fvalid;
    }

    /**
     * Sets the value of the fvalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFvalid(String value) {
        this.fvalid = value;
    }

    /**
     * Gets the value of the fvalidityTermEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFvalidityTermEndDate() {
        return fvalidityTermEndDate;
    }

    /**
     * Sets the value of the fvalidityTermEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFvalidityTermEndDate(XMLGregorianCalendar value) {
        this.fvalidityTermEndDate = value;
    }

    /**
     * Gets the value of the fvalidityTermStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFvalidityTermStartDate() {
        return fvalidityTermStartDate;
    }

    /**
     * Sets the value of the fvalidityTermStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFvalidityTermStartDate(XMLGregorianCalendar value) {
        this.fvalidityTermStartDate = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

}
