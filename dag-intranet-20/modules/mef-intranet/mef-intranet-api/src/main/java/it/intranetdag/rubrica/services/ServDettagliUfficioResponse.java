
package it.intranetdag.rubrica.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO;


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
 *         &lt;element name="return" type="{http://vo.services.rubrica.intranetdag.it/xsd}AnagraficaUfficioVO" minOccurs="0"/&gt;
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
    "_return"
})
@XmlRootElement(name = "servDettagliUfficioResponse")
public class ServDettagliUfficioResponse {

    @XmlElementRef(name = "return", namespace = "http://services.rubrica.intranetdag.it", type = JAXBElement.class, required = false)
    protected JAXBElement<AnagraficaUfficioVO> _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AnagraficaUfficioVO }{@code >}
     *     
     */
    public JAXBElement<AnagraficaUfficioVO> getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AnagraficaUfficioVO }{@code >}
     *     
     */
    public void setReturn(JAXBElement<AnagraficaUfficioVO> value) {
        this._return = value;
    }

}
