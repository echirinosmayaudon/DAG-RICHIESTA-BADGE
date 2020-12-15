
package it.intranetdag.rubrica.services.vo.xsd;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GerarchiaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GerarchiaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codStrutt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv2" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="liv3" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="liv4" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="liv5" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GerarchiaVO", propOrder = {
    "codStrutt",
    "liv2",
    "liv3",
    "liv4",
    "liv5"
})
public class GerarchiaVO {

    @XmlElementRef(name = "codStrutt", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codStrutt;
    @XmlElementRef(name = "liv2", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> liv2;
    @XmlElementRef(name = "liv3", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> liv3;
    @XmlElementRef(name = "liv4", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> liv4;
    @XmlElementRef(name = "liv5", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> liv5;

    /**
     * Gets the value of the codStrutt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodStrutt() {
        return codStrutt;
    }

    /**
     * Sets the value of the codStrutt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodStrutt(JAXBElement<String> value) {
        this.codStrutt = value;
    }

    /**
     * Gets the value of the liv2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getLiv2() {
        return liv2;
    }

    /**
     * Sets the value of the liv2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLiv2(JAXBElement<Object> value) {
        this.liv2 = value;
    }

    /**
     * Gets the value of the liv3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getLiv3() {
        return liv3;
    }

    /**
     * Sets the value of the liv3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLiv3(JAXBElement<Object> value) {
        this.liv3 = value;
    }

    /**
     * Gets the value of the liv4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getLiv4() {
        return liv4;
    }

    /**
     * Sets the value of the liv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLiv4(JAXBElement<Object> value) {
        this.liv4 = value;
    }

    /**
     * Gets the value of the liv5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getLiv5() {
        return liv5;
    }

    /**
     * Sets the value of the liv5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLiv5(JAXBElement<Object> value) {
        this.liv5 = value;
    }

}
