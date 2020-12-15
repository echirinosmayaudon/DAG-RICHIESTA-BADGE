
package it.intranetdag.rubrica.services.vo.xsd;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirezioneVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirezioneVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acronimo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceStruttura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirezioneVO", propOrder = {
    "acronimo",
    "codiceStruttura"
})
@JSON(strict = true)
public class DirezioneVO {

    @XmlElementRef(name = "acronimo", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acronimo;
    @XmlElementRef(name = "codiceStruttura", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceStruttura;

    /**
     * Gets the value of the acronimo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getAcronimo() {
        return acronimo;
    }

    /**
     * Sets the value of the acronimo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAcronimo(JAXBElement<String> value) {
        this.acronimo = value;
    }

    /**
     * Gets the value of the codiceStruttura property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getCodiceStruttura() {
        return codiceStruttura;
    }

    /**
     * Sets the value of the codiceStruttura property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceStruttura(JAXBElement<String> value) {
        this.codiceStruttura = value;
    }

    
    @Override
   	public String toString() {
   		StringBundler sb = new StringBundler(5);

   		sb.append("{acronimo=");
   		sb.append(getAcronimo());	
   		sb.append("{codiceStruttura=");
   		sb.append(getCodiceStruttura());	
   		sb.append("}");

   		return sb.toString();
   	}
}
