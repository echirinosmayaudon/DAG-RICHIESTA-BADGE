
package it.intranetdag.rubrica.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="vecchioTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nuovoTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "vecchioTag",
    "nuovoTag"
})
@XmlRootElement(name = "modificaTag")
public class ModificaTag {

    @XmlElementRef(name = "vecchioTag", namespace = "http://services.rubrica.intranetdag.it", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vecchioTag;
    @XmlElementRef(name = "nuovoTag", namespace = "http://services.rubrica.intranetdag.it", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nuovoTag;

    /**
     * Gets the value of the vecchioTag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVecchioTag() {
        return vecchioTag;
    }

    /**
     * Sets the value of the vecchioTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVecchioTag(JAXBElement<String> value) {
        this.vecchioTag = value;
    }

    /**
     * Gets the value of the nuovoTag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNuovoTag() {
        return nuovoTag;
    }

    /**
     * Sets the value of the nuovoTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNuovoTag(JAXBElement<String> value) {
        this.nuovoTag = value;
    }

}
