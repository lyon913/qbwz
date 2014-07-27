
package net.xqx.service.achievement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for achievement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="achievement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admissionNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstGoal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fourGoal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="licenseNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secondGoal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="theYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thirdGoal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "achievement", propOrder = {
    "admissionNo",
    "firstGoal",
    "fourGoal",
    "id",
    "licenseNo",
    "name",
    "secondGoal",
    "theYear",
    "thirdGoal"
})
public class Achievement {

    protected String admissionNo;
    protected String firstGoal;
    protected String fourGoal;
    protected Long id;
    protected String licenseNo;
    protected String name;
    protected String secondGoal;
    protected String theYear;
    protected String thirdGoal;

    /**
     * Gets the value of the admissionNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmissionNo() {
        return admissionNo;
    }

    /**
     * Sets the value of the admissionNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmissionNo(String value) {
        this.admissionNo = value;
    }

    /**
     * Gets the value of the firstGoal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstGoal() {
        return firstGoal;
    }

    /**
     * Sets the value of the firstGoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstGoal(String value) {
        this.firstGoal = value;
    }

    /**
     * Gets the value of the fourGoal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFourGoal() {
        return fourGoal;
    }

    /**
     * Sets the value of the fourGoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFourGoal(String value) {
        this.fourGoal = value;
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

    /**
     * Gets the value of the licenseNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * Sets the value of the licenseNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseNo(String value) {
        this.licenseNo = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the secondGoal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondGoal() {
        return secondGoal;
    }

    /**
     * Sets the value of the secondGoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondGoal(String value) {
        this.secondGoal = value;
    }

    /**
     * Gets the value of the theYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheYear() {
        return theYear;
    }

    /**
     * Sets the value of the theYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheYear(String value) {
        this.theYear = value;
    }

    /**
     * Gets the value of the thirdGoal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThirdGoal() {
        return thirdGoal;
    }

    /**
     * Sets the value of the thirdGoal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThirdGoal(String value) {
        this.thirdGoal = value;
    }

}
