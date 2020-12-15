
package it.intranetdag.rubrica.services.vo.xsd;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TagVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TagVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTAg" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="numUffAssoc" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tagCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="tagName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TagVO", propOrder = {
    "idTAg",
    "numUffAssoc",
    "tagCount",
    "tagName"
})
@JSON(strict = true)
public class TagVO {

    protected Integer idTAg;
    protected Integer numUffAssoc;
    protected Integer tagCount;
    @XmlElementRef(name = "tagName", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tagName;

    /**
     * Gets the value of the idTAg property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @JSON
    public Integer getIdTAg() {
        return idTAg;
    }

    /**
     * Sets the value of the idTAg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTAg(Integer value) {
        this.idTAg = value;
    }

    /**
     * Gets the value of the numUffAssoc property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @JSON
    public Integer getNumUffAssoc() {
        return numUffAssoc;
    }

    /**
     * Sets the value of the numUffAssoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumUffAssoc(Integer value) {
        this.numUffAssoc = value;
    }

    /**
     * Gets the value of the tagCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @JSON
    public Integer getTagCount() {
        return tagCount;
    }

    /**
     * Sets the value of the tagCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTagCount(Integer value) {
        this.tagCount = value;
    }

    /**
     * Gets the value of the tagName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getTagName() {
        return tagName;
    }

    /**
     * Sets the value of the tagName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTagName(JAXBElement<String> value) {
        this.tagName = value;
    }

    @Override
   	public String toString() {
   		StringBundler sb = new StringBundler(11);

   		sb.append("{idTAg=");
   		sb.append(getIdTAg());	
   		sb.append("{numUffAssoc=");
   		sb.append(getNumUffAssoc());	
   		sb.append("{tagCount=");
   		sb.append(getTagCount());	
   		sb.append("{tagName=");
   		sb.append(getTagName());	
   		sb.append("}");

   		return sb.toString();
   	}

}
