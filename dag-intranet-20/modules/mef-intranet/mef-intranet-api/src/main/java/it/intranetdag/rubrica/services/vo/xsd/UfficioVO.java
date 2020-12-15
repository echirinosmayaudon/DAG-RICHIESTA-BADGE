
package it.intranetdag.rubrica.services.vo.xsd;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UfficioVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UfficioVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acronimo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cod_struttura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UfficioVO", propOrder = {
    "acronimo",
    "codStruttura"
})
@JSON(strict = true)
public class UfficioVO {

    @XmlElementRef(name = "acronimo", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acronimo;
    @XmlElementRef(name = "cod_struttura", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codStruttura;

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
     * Gets the value of the codStruttura property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getCodStruttura() {
        return codStruttura;
    }

    /**
     * Sets the value of the codStruttura property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodStruttura(JAXBElement<String> value) {
        this.codStruttura = value;
    }

    @Override
   	public String toString() {
   		StringBundler sb = new StringBundler(5);

   		sb.append("{acronimo=");
   		sb.append(getAcronimo());	
   		sb.append("{codStruttura=");
   		sb.append(getCodStruttura());	  		  		
   		sb.append("}");

   		return sb.toString();
   	}
}
