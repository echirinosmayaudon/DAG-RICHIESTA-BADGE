
package it.intranetdag.rubrica.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.intranetdag.rubrica.business.dao.model.xsd.FormRicercaPersona;


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
 *         &lt;element name="frp" type="{http://model.dao.business.rubrica.intranetdag.it/xsd}FormRicercaPersona" minOccurs="0"/&gt;
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
    "frp"
})
@XmlRootElement(name = "getListPersone")
public class GetListPersone {

    @XmlElementRef(name = "frp", namespace = "http://services.rubrica.intranetdag.it", type = JAXBElement.class, required = false)
    protected JAXBElement<FormRicercaPersona> frp;

    /**
     * Gets the value of the frp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FormRicercaPersona }{@code >}
     *     
     */
    public JAXBElement<FormRicercaPersona> getFrp() {
        return frp;
    }

    /**
     * Sets the value of the frp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FormRicercaPersona }{@code >}
     *     
     */
    public void setFrp(JAXBElement<FormRicercaPersona> value) {
        this.frp = value;
    }

}
