
package it.intranetdag.rubrica.services.vo.xsd;


import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnagraficaUfficioVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnagraficaUfficioVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acronimo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chiave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chiaviUfficio" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="cod_struttura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dipartimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dirigente" type="{http://vo.services.rubrica.intranetdag.it/xsd}AnagraficaVO" minOccurs="0"/&gt;
 *         &lt;element name="info_sostitutivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="livGerarchia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titolo_sostitutivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnagraficaUfficioVO", propOrder = {
    "acronimo",
    "chiave",
    "chiaviUfficio",
    "codStruttura",
    "descr",
    "descrizione",
    "dipartimento",
    "dirigente",
    "infoSostitutivo",
    "liv1",
    "liv2",
    "liv3",
    "liv4",
    "liv5",
    "livGerarchia",
    "titoloSostitutivo"
})
@JSON(strict = true)
public class AnagraficaUfficioVO {

    @XmlElementRef(name = "acronimo", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acronimo;
    @XmlElementRef(name = "chiave", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> chiave;
    @XmlElement(nillable = true)
    protected List<String> chiaviUfficio;
    @XmlElementRef(name = "cod_struttura", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codStruttura;
    @XmlElementRef(name = "descr", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descr;
    @XmlElementRef(name = "descrizione", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descrizione;
    @XmlElementRef(name = "dipartimento", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dipartimento;
    @XmlElementRef(name = "dirigente", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<AnagraficaVO> dirigente;
    @XmlElementRef(name = "info_sostitutivo", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> infoSostitutivo;
    @XmlElementRef(name = "liv1", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> liv1;
    @XmlElementRef(name = "liv2", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> liv2;
    @XmlElementRef(name = "liv3", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> liv3;
    @XmlElementRef(name = "liv4", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> liv4;
    @XmlElementRef(name = "liv5", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> liv5;
    @XmlElementRef(name = "livGerarchia", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> livGerarchia;
    @XmlElementRef(name = "titolo_sostitutivo", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> titoloSostitutivo;

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
     * Gets the value of the chiave property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getChiave() {
        return chiave;
    }

    /**
     * Sets the value of the chiave property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChiave(JAXBElement<String> value) {
        this.chiave = value;
    }

    /**
     * Gets the value of the chiaviUfficio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chiaviUfficio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChiaviUfficio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @JSON
    public List<String> getChiaviUfficio() {
        if (chiaviUfficio == null) {
            chiaviUfficio = new ArrayList<String>();
        }
        return this.chiaviUfficio;
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

    /**
     * Gets the value of the descr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getDescr() {
        return descr;
    }

    /**
     * Sets the value of the descr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescr(JAXBElement<String> value) {
        this.descr = value;
    }

    /**
     * Gets the value of the descrizione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getDescrizione() {
        return descrizione;
    }

    /**
     * Sets the value of the descrizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrizione(JAXBElement<String> value) {
        this.descrizione = value;
    }

    /**
     * Gets the value of the dipartimento property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getDipartimento() {
        return dipartimento;
    }

    /**
     * Sets the value of the dipartimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDipartimento(JAXBElement<String> value) {
        this.dipartimento = value;
    }

    /**
     * Gets the value of the dirigente property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AnagraficaVO }{@code >}
     *     
     */
    @JSON
    public JAXBElement<AnagraficaVO> getDirigente() {
        return dirigente;
    }

    /**
     * Sets the value of the dirigente property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AnagraficaVO }{@code >}
     *     
     */
    public void setDirigente(JAXBElement<AnagraficaVO> value) {
        this.dirigente = value;
    }

    /**
     * Gets the value of the infoSostitutivo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getInfoSostitutivo() {
        return infoSostitutivo;
    }

    /**
     * Sets the value of the infoSostitutivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInfoSostitutivo(JAXBElement<String> value) {
        this.infoSostitutivo = value;
    }

    /**
     * Gets the value of the liv1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLiv1() {
        return liv1;
    }

    /**
     * Sets the value of the liv1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLiv1(JAXBElement<String> value) {
        this.liv1 = value;
    }

    /**
     * Gets the value of the liv2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLiv2() {
        return liv2;
    }

    /**
     * Sets the value of the liv2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLiv2(JAXBElement<String> value) {
        this.liv2 = value;
    }

    /**
     * Gets the value of the liv3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLiv3() {
        return liv3;
    }

    /**
     * Sets the value of the liv3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLiv3(JAXBElement<String> value) {
        this.liv3 = value;
    }

    /**
     * Gets the value of the liv4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLiv4() {
        return liv4;
    }

    /**
     * Sets the value of the liv4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLiv4(JAXBElement<String> value) {
        this.liv4 = value;
    }

    /**
     * Gets the value of the liv5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLiv5() {
        return liv5;
    }

    /**
     * Sets the value of the liv5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLiv5(JAXBElement<String> value) {
        this.liv5 = value;
    }

    /**
     * Gets the value of the livGerarchia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLivGerarchia() {
        return livGerarchia;
    }

    /**
     * Sets the value of the livGerarchia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLivGerarchia(JAXBElement<String> value) {
        this.livGerarchia = value;
    }

    /**
     * Gets the value of the titoloSostitutivo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getTitoloSostitutivo() {
        return titoloSostitutivo;
    }

    /**
     * Sets the value of the titoloSostitutivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitoloSostitutivo(JAXBElement<String> value) {
        this.titoloSostitutivo = value;
    }
    
    @Override
   	public String toString() {
   		StringBundler sb = new StringBundler(33);

   		sb.append("{acronimo=");
   		sb.append(getAcronimo());	
   		sb.append("{chiave=");
   		sb.append(getChiave());
   		sb.append("{chiaviUfficio=");
   		sb.append(getChiaviUfficio());	
   		sb.append("{codStruttura=");
   		sb.append(getCodStruttura());
   		sb.append("{descr=");
   		sb.append(getDescr());	
   		sb.append("{descrizione=");
   		sb.append(getDescrizione());	
   		sb.append("{dipartimento=");
   		sb.append(getDipartimento());	
   		sb.append("{dirigente=");
   		sb.append(getDirigente());
   		sb.append("{infoSostitutivo=");
   		sb.append(getInfoSostitutivo());
   		sb.append("{liv1=");
   		sb.append(getLiv1());	
   		sb.append("{liv2=");
   		sb.append(getLiv2());
   		sb.append("{liv3=");
   		sb.append(getLiv3());
   		sb.append("{liv4=");
   		sb.append(getLiv4());
   		sb.append("{liv5=");
   		sb.append(getLiv5());
   		sb.append("{livGerarchia=");
   		sb.append(getLivGerarchia());
   		sb.append("{titoloSostitutivo=");
   		sb.append(getTitoloSostitutivo());
   		sb.append("}");

   		return sb.toString();
   	}


}
