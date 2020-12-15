
package it.intranetdag.rubrica.business.dao.model.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.intranetdag.rubrica.business.dao.model.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FormRicercaPersonaDipartimento_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "dipartimento");
    private final static QName _FormRicercaPersonaDirezione_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "direzione");
    private final static QName _FormRicercaPersonaFirstName_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "firstName");
    private final static QName _FormRicercaPersonaIncaricoQualifica_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "incaricoQualifica");
    private final static QName _FormRicercaPersonaLastName_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "lastName");
    private final static QName _FormRicercaPersonaOrganizzazione_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "organizzazione");
    private final static QName _FormRicercaPersonaStrutturaInterna_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "strutturaInterna");
    private final static QName _FormRicercaPersonaUfficio_QNAME = new QName("http://model.dao.business.rubrica.intranetdag.it/xsd", "ufficio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.intranetdag.rubrica.business.dao.model.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FormRicercaPersona }
     * 
     */
    public FormRicercaPersona createFormRicercaPersona() {
        return new FormRicercaPersona();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "dipartimento", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaDipartimento(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaDipartimento_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "direzione", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaDirezione(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaDirezione_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "firstName", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaFirstName(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaFirstName_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "incaricoQualifica", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaIncaricoQualifica(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaIncaricoQualifica_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "lastName", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaLastName(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaLastName_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "organizzazione", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaOrganizzazione(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaOrganizzazione_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "strutturaInterna", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaStrutturaInterna(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaStrutturaInterna_QNAME, String.class, FormRicercaPersona.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.dao.business.rubrica.intranetdag.it/xsd", name = "ufficio", scope = FormRicercaPersona.class)
    public JAXBElement<String> createFormRicercaPersonaUfficio(String value) {
        return new JAXBElement<String>(_FormRicercaPersonaUfficio_QNAME, String.class, FormRicercaPersona.class, value);
    }

}
