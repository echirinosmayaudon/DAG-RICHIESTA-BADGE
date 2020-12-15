
package it.intranetdag.rubrica.services.vo.xsd;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnagraficaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnagraficaVO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acronimo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cellulare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codice" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codstrutt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comandato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comandatoUffDestinazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="comandatoUffProvenienza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="consip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="corridoioId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extraField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extraField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extraField3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="faxUff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="incarico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="livello1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="livello2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="livellogerarchia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pianoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="posizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="scalaCorpoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="settoreId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="stanzaId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telUffi1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telUffi2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ubicazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnagraficaVO", propOrder = {
    "acronimo",
    "attiva",
    "cellulare",
    "codice",
    "codiceFiscale",
    "codstrutt",
    "comandato",
    "comandatoUffDestinazione",
    "comandatoUffProvenienza",
    "consip",
    "corridoioId",
    "emailAddress",
    "extraField1",
    "extraField2",
    "extraField3",
    "fax",
    "faxUff",
    "firstName",
    "incarico",
    "lastName",
    "liv1",
    "liv2",
    "liv3",
    "liv4",
    "liv5",
    "livello1",
    "livello2",
    "livellogerarchia",
    "pianoId",
    "posizione",
    "scalaCorpoId",
    "sede",
    "settoreId",
    "sex",
    "stanzaId",
    "telUffi1",
    "telUffi2",
    "telefono",
    "ubicazione"
})
@JSON(strict = true)
public class AnagraficaVO {

    @XmlElementRef(name = "acronimo", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acronimo;
    @XmlElementRef(name = "attiva", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> attiva;
    @XmlElementRef(name = "cellulare", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cellulare;
    protected Integer codice;
    @XmlElementRef(name = "codiceFiscale", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceFiscale;
    @XmlElementRef(name = "codstrutt", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codstrutt;
    @XmlElementRef(name = "comandato", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comandato;
    @XmlElementRef(name = "comandatoUffDestinazione", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comandatoUffDestinazione;
    @XmlElementRef(name = "comandatoUffProvenienza", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comandatoUffProvenienza;
    @XmlElementRef(name = "consip", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> consip;
    @XmlElementRef(name = "corridoioId", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> corridoioId;
    @XmlElementRef(name = "emailAddress", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> emailAddress;
    @XmlElementRef(name = "extraField1", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraField1;
    @XmlElementRef(name = "extraField2", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraField2;
    @XmlElementRef(name = "extraField3", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraField3;
    @XmlElementRef(name = "fax", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fax;
    @XmlElementRef(name = "faxUff", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> faxUff;
    @XmlElementRef(name = "firstName", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstName;
    @XmlElementRef(name = "incarico", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> incarico;
    @XmlElementRef(name = "lastName", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastName;
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
    @XmlElementRef(name = "livello1", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> livello1;
    @XmlElementRef(name = "livello2", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> livello2;
    @XmlElementRef(name = "livellogerarchia", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> livellogerarchia;
    @XmlElementRef(name = "pianoId", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pianoId;
    @XmlElementRef(name = "posizione", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> posizione;
    @XmlElementRef(name = "scalaCorpoId", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> scalaCorpoId;
    @XmlElementRef(name = "sede", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sede;
    @XmlElementRef(name = "settoreId", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> settoreId;
    @XmlElementRef(name = "sex", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sex;
    @XmlElementRef(name = "stanzaId", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stanzaId;
    @XmlElementRef(name = "telUffi1", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telUffi1;
    @XmlElementRef(name = "telUffi2", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telUffi2;
    @XmlElementRef(name = "telefono", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telefono;
    @XmlElementRef(name = "ubicazione", namespace = "http://vo.services.rubrica.intranetdag.it/xsd", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ubicazione;

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
     * Gets the value of the attiva property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getAttiva() {
        return attiva;
    }

    /**
     * Sets the value of the attiva property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAttiva(JAXBElement<String> value) {
        this.attiva = value;
    }

    /**
     * Gets the value of the cellulare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getCellulare() {
        return cellulare;
    }

    /**
     * Sets the value of the cellulare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCellulare(JAXBElement<String> value) {
        this.cellulare = value;
    }

    /**
     * Gets the value of the codice property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    @JSON
    public Integer getCodice() {
        return codice;
    }

    /**
     * Sets the value of the codice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodice(Integer value) {
        this.codice = value;
    }

    /**
     * Gets the value of the codiceFiscale property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Sets the value of the codiceFiscale property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceFiscale(JAXBElement<String> value) {
        this.codiceFiscale = value;
    }

    /**
     * Gets the value of the codstrutt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getCodstrutt() {
        return codstrutt;
    }

    /**
     * Sets the value of the codstrutt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodstrutt(JAXBElement<String> value) {
        this.codstrutt = value;
    }

    /**
     * Gets the value of the comandato property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getComandato() {
        return comandato;
    }

    /**
     * Sets the value of the comandato property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComandato(JAXBElement<String> value) {
        this.comandato = value;
    }

    /**
     * Gets the value of the comandatoUffDestinazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getComandatoUffDestinazione() {
        return comandatoUffDestinazione;
    }

    /**
     * Sets the value of the comandatoUffDestinazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComandatoUffDestinazione(JAXBElement<String> value) {
        this.comandatoUffDestinazione = value;
    }

    /**
     * Gets the value of the comandatoUffProvenienza property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getComandatoUffProvenienza() {
        return comandatoUffProvenienza;
    }

    /**
     * Sets the value of the comandatoUffProvenienza property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComandatoUffProvenienza(JAXBElement<String> value) {
        this.comandatoUffProvenienza = value;
    }

    /**
     * Gets the value of the consip property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getConsip() {
        return consip;
    }

    /**
     * Sets the value of the consip property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConsip(JAXBElement<String> value) {
        this.consip = value;
    }

    /**
     * Gets the value of the corridoioId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getCorridoioId() {
        return corridoioId;
    }

    /**
     * Sets the value of the corridoioId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorridoioId(JAXBElement<String> value) {
        this.corridoioId = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEmailAddress(JAXBElement<String> value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the extraField1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getExtraField1() {
        return extraField1;
    }

    /**
     * Sets the value of the extraField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtraField1(JAXBElement<String> value) {
        this.extraField1 = value;
    }

    /**
     * Gets the value of the extraField2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getExtraField2() {
        return extraField2;
    }

    /**
     * Sets the value of the extraField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtraField2(JAXBElement<String> value) {
        this.extraField2 = value;
    }

    /**
     * Gets the value of the extraField3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getExtraField3() {
        return extraField3;
    }

    /**
     * Sets the value of the extraField3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtraField3(JAXBElement<String> value) {
        this.extraField3 = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFax(JAXBElement<String> value) {
        this.fax = value;
    }

    /**
     * Gets the value of the faxUff property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getFaxUff() {
        return faxUff;
    }

    /**
     * Sets the value of the faxUff property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFaxUff(JAXBElement<String> value) {
        this.faxUff = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstName(JAXBElement<String> value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the incarico property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getIncarico() {
        return incarico;
    }

    /**
     * Sets the value of the incarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIncarico(JAXBElement<String> value) {
        this.incarico = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastName(JAXBElement<String> value) {
        this.lastName = value;
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
     * Gets the value of the livello1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLivello1() {
        return livello1;
    }

    /**
     * Sets the value of the livello1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLivello1(JAXBElement<String> value) {
        this.livello1 = value;
    }

    /**
     * Gets the value of the livello2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLivello2() {
        return livello2;
    }

    /**
     * Sets the value of the livello2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLivello2(JAXBElement<String> value) {
        this.livello2 = value;
    }

    /**
     * Gets the value of the livellogerarchia property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getLivellogerarchia() {
        return livellogerarchia;
    }

    /**
     * Sets the value of the livellogerarchia property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLivellogerarchia(JAXBElement<String> value) {
        this.livellogerarchia = value;
    }

    /**
     * Gets the value of the pianoId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getPianoId() {
        return pianoId;
    }

    /**
     * Sets the value of the pianoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPianoId(JAXBElement<String> value) {
        this.pianoId = value;
    }

    /**
     * Gets the value of the posizione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getPosizione() {
        return posizione;
    }

    /**
     * Sets the value of the posizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPosizione(JAXBElement<String> value) {
        this.posizione = value;
    }

    /**
     * Gets the value of the scalaCorpoId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getScalaCorpoId() {
        return scalaCorpoId;
    }

    /**
     * Sets the value of the scalaCorpoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setScalaCorpoId(JAXBElement<String> value) {
        this.scalaCorpoId = value;
    }

    /**
     * Gets the value of the sede property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getSede() {
        return sede;
    }

    /**
     * Sets the value of the sede property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSede(JAXBElement<String> value) {
        this.sede = value;
    }

    /**
     * Gets the value of the settoreId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getSettoreId() {
        return settoreId;
    }

    /**
     * Sets the value of the settoreId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSettoreId(JAXBElement<String> value) {
        this.settoreId = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSex(JAXBElement<String> value) {
        this.sex = value;
    }

    /**
     * Gets the value of the stanzaId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getStanzaId() {
        return stanzaId;
    }

    /**
     * Sets the value of the stanzaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStanzaId(JAXBElement<String> value) {
        this.stanzaId = value;
    }

    /**
     * Gets the value of the telUffi1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getTelUffi1() {
        return telUffi1;
    }

    /**
     * Sets the value of the telUffi1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelUffi1(JAXBElement<String> value) {
        this.telUffi1 = value;
    }

    /**
     * Gets the value of the telUffi2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getTelUffi2() {
        return telUffi2;
    }

    /**
     * Sets the value of the telUffi2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelUffi2(JAXBElement<String> value) {
        this.telUffi2 = value;
    }

    /**
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelefono(JAXBElement<String> value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the ubicazione property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    @JSON
    public JAXBElement<String> getUbicazione() {
        return ubicazione;
    }

    /**
     * Sets the value of the ubicazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUbicazione(JAXBElement<String> value) {
        this.ubicazione = value;
    }

    @Override
   	public String toString() {
   		StringBundler sb = new StringBundler(79);

   		sb.append("{acronimo=");
   		sb.append(getAcronimo());	
   		sb.append("{attiva=");
   		sb.append(getAttiva());	
   		sb.append("{cellulare=");
   		sb.append(getCellulare());	
   		sb.append("{codice=");
   		sb.append(getCodice());	
   		sb.append("{codiceFiscale=");
   		sb.append(getCodiceFiscale());	
   		sb.append("{codstrutt=");
   		sb.append(getCodstrutt());	
   		sb.append("{comandato=");
   		sb.append(getComandato());	
   		sb.append("{comandatoUffDestinazione=");
   		sb.append(getComandatoUffDestinazione());
   		sb.append("{comandatoUffProvenienza=");
   		sb.append(getComandatoUffProvenienza());
   		sb.append("{consip=");
   		sb.append(getConsip());
   		sb.append("{corridoioId=");
   		sb.append(getCorridoioId());
   		sb.append("{emailAddress=");
   		sb.append(getEmailAddress()); 
        sb.append("{extraField1=");
   		sb.append(getExtraField1());
		sb.append("{extraField2=");
   		sb.append(getExtraField2());
		sb.append("{extraField3=");
   		sb.append(getExtraField3());
   		sb.append("{fax=");
   		sb.append(getFax());
   		sb.append("{faxUff=");
   		sb.append(getFaxUff());
   		sb.append("{firstName=");
   		sb.append(getFirstName());   
        sb.append("{incarico=");
   		sb.append(getIncarico());
   		sb.append("{lastName=");
   		sb.append(getLastName()); 
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
		sb.append("{livello1=");
   		sb.append(getLivello1());
		sb.append("{livello2=");
   		sb.append(getLivello2());
		sb.append("{livellogerarchia=");
   		sb.append(getLivellogerarchia());
   		sb.append("{pianoId=");
   		sb.append(getPianoId());
   		sb.append("{posizione=");
   		sb.append(getPosizione());
   		sb.append("{scalaCorpoId=");
   		sb.append(getScalaCorpoId()); 
	    sb.append("{sede=");
   		sb.append(getSede());
		sb.append("{settoreId=");
   		sb.append(getSettoreId());
		sb.append("{sex=");
   		sb.append(getSex());
		sb.append("{stanzaId=");
   		sb.append(getStanzaId());
		sb.append("{telUffi1=");
   		sb.append(getTelUffi1());
		sb.append("{telUffi2=");
   		sb.append(getTelUffi2());
   		sb.append("{telefono=");
   		sb.append(getTelefono());
   		sb.append("{ubicazione=");
   		sb.append(getUbicazione());			
   		sb.append("}");

   		return sb.toString();
   	}
    
    
}
