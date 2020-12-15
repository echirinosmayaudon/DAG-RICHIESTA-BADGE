
package it.intranetdag.rubrica.services.vo.xsd;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SuggestParolaChiaveVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SuggestParolaChiaveVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parolaChiave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuggestParolaChiaveVO", propOrder = {
    "parolaChiave"
})
@JSON(strict = true)
public class SuggestParolaChiaveVO {

    @XmlElementRef(name = "parolaChiave", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> parolaChiave;

    /**
     * Gets the value of the parolaChiave property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getParolaChiave() {
        return parolaChiave;
    }

    /**
     * Sets the value of the parolaChiave property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setParolaChiave(JAXBElement<String> value) {
        this.parolaChiave = value;
    }

    @Override
	public String toString() {
		StringBundler sb = new StringBundler(3);

		sb.append("{parolaChiave=");
		sb.append(getParolaChiave());		
		sb.append("}");

		return sb.toString();
	}
    
}
