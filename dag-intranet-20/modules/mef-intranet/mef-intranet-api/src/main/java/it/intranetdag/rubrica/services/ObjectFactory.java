
package it.intranetdag.rubrica.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import it.intranetdag.rubrica.business.dao.model.xsd.FormRicercaPersona;
import it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO;
import it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.intranetdag.rubrica.services package. 
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

    private final static QName _SuggestParolaChiaveChiave_QNAME = new QName("http://services.rubrica.intranetdag.it", "chiave");
    private final static QName _SuggestLastNameByFirstAndLastFirstName_QNAME = new QName("http://services.rubrica.intranetdag.it", "firstName");
    private final static QName _SuggestLastNameByFirstAndLastLastName_QNAME = new QName("http://services.rubrica.intranetdag.it", "lastName");
    private final static QName _ServDettagliUfficioIdUfficio_QNAME = new QName("http://services.rubrica.intranetdag.it", "idUfficio");
    private final static QName _ServDettagliUfficioResponseReturn_QNAME = new QName("http://services.rubrica.intranetdag.it", "return");
    private final static QName _ModificaTagVecchioTag_QNAME = new QName("http://services.rubrica.intranetdag.it", "vecchioTag");
    private final static QName _ModificaTagNuovoTag_QNAME = new QName("http://services.rubrica.intranetdag.it", "nuovoTag");
    private final static QName _InserisciTagTagName_QNAME = new QName("http://services.rubrica.intranetdag.it", "tagName");
    private final static QName _GetPersoneByCodStrutCodStruttura_QNAME = new QName("http://services.rubrica.intranetdag.it", "codStruttura");
    private final static QName _GetListTagForCharCharacter_QNAME = new QName("http://services.rubrica.intranetdag.it", "character");
    private final static QName _GetListStruttureInterneIdStruttura_QNAME = new QName("http://services.rubrica.intranetdag.it", "idStruttura");
    private final static QName _GetListPersoneTelNumTelefono_QNAME = new QName("http://services.rubrica.intranetdag.it", "telefono");
    private final static QName _GetListPersoneFrp_QNAME = new QName("http://services.rubrica.intranetdag.it", "frp");
    private final static QName _GetListEntiIdEnte_QNAME = new QName("http://services.rubrica.intranetdag.it", "idEnte");
    private final static QName _GetListDirezioniIdDirezione_QNAME = new QName("http://services.rubrica.intranetdag.it", "idDirezione");
    private final static QName _EliminaTagTag_QNAME = new QName("http://services.rubrica.intranetdag.it", "tag");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.intranetdag.rubrica.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SuggestParolaChiave }
     * 
     */
    public SuggestParolaChiave createSuggestParolaChiave() {
        return new SuggestParolaChiave();
    }

    /**
     * Create an instance of {@link SuggestParolaChiaveResponse }
     * 
     */
    public SuggestParolaChiaveResponse createSuggestParolaChiaveResponse() {
        return new SuggestParolaChiaveResponse();
    }

    /**
     * Create an instance of {@link SuggestLastNameByFirstAndLast }
     * 
     */
    public SuggestLastNameByFirstAndLast createSuggestLastNameByFirstAndLast() {
        return new SuggestLastNameByFirstAndLast();
    }

    /**
     * Create an instance of {@link SuggestLastNameByFirstAndLastResponse }
     * 
     */
    public SuggestLastNameByFirstAndLastResponse createSuggestLastNameByFirstAndLastResponse() {
        return new SuggestLastNameByFirstAndLastResponse();
    }

    /**
     * Create an instance of {@link SuggestLastName }
     * 
     */
    public SuggestLastName createSuggestLastName() {
        return new SuggestLastName();
    }

    /**
     * Create an instance of {@link SuggestLastNameResponse }
     * 
     */
    public SuggestLastNameResponse createSuggestLastNameResponse() {
        return new SuggestLastNameResponse();
    }

    /**
     * Create an instance of {@link ServElencoAnagraficheUffici }
     * 
     */
    public ServElencoAnagraficheUffici createServElencoAnagraficheUffici() {
        return new ServElencoAnagraficheUffici();
    }

    /**
     * Create an instance of {@link ServElencoAnagraficheUfficiResponse }
     * 
     */
    public ServElencoAnagraficheUfficiResponse createServElencoAnagraficheUfficiResponse() {
        return new ServElencoAnagraficheUfficiResponse();
    }

    /**
     * Create an instance of {@link ServDettagliUfficio }
     * 
     */
    public ServDettagliUfficio createServDettagliUfficio() {
        return new ServDettagliUfficio();
    }

    /**
     * Create an instance of {@link ServDettagliUfficioResponse }
     * 
     */
    public ServDettagliUfficioResponse createServDettagliUfficioResponse() {
        return new ServDettagliUfficioResponse();
    }

    /**
     * Create an instance of {@link ModificaTag }
     * 
     */
    public ModificaTag createModificaTag() {
        return new ModificaTag();
    }

    /**
     * Create an instance of {@link ModificaTagResponse }
     * 
     */
    public ModificaTagResponse createModificaTagResponse() {
        return new ModificaTagResponse();
    }

    /**
     * Create an instance of {@link InserisciTag }
     * 
     */
    public InserisciTag createInserisciTag() {
        return new InserisciTag();
    }

    /**
     * Create an instance of {@link InserisciTagResponse }
     * 
     */
    public InserisciTagResponse createInserisciTagResponse() {
        return new InserisciTagResponse();
    }

    /**
     * Create an instance of {@link GetPersoneByCodStrut }
     * 
     */
    public GetPersoneByCodStrut createGetPersoneByCodStrut() {
        return new GetPersoneByCodStrut();
    }

    /**
     * Create an instance of {@link GetPersoneByCodStrutResponse }
     * 
     */
    public GetPersoneByCodStrutResponse createGetPersoneByCodStrutResponse() {
        return new GetPersoneByCodStrutResponse();
    }

    /**
     * Create an instance of {@link GetNuvolaTag }
     * 
     */
    public GetNuvolaTag createGetNuvolaTag() {
        return new GetNuvolaTag();
    }

    /**
     * Create an instance of {@link GetNuvolaTagResponse }
     * 
     */
    public GetNuvolaTagResponse createGetNuvolaTagResponse() {
        return new GetNuvolaTagResponse();
    }

    /**
     * Create an instance of {@link GetListUffici }
     * 
     */
    public GetListUffici createGetListUffici() {
        return new GetListUffici();
    }

    /**
     * Create an instance of {@link GetListUfficiResponse }
     * 
     */
    public GetListUfficiResponse createGetListUfficiResponse() {
        return new GetListUfficiResponse();
    }

    /**
     * Create an instance of {@link GetListTagForChar }
     * 
     */
    public GetListTagForChar createGetListTagForChar() {
        return new GetListTagForChar();
    }

    /**
     * Create an instance of {@link GetListTagForCharResponse }
     * 
     */
    public GetListTagForCharResponse createGetListTagForCharResponse() {
        return new GetListTagForCharResponse();
    }

    /**
     * Create an instance of {@link GetListStruttureInterne }
     * 
     */
    public GetListStruttureInterne createGetListStruttureInterne() {
        return new GetListStruttureInterne();
    }

    /**
     * Create an instance of {@link GetListStruttureInterneResponse }
     * 
     */
    public GetListStruttureInterneResponse createGetListStruttureInterneResponse() {
        return new GetListStruttureInterneResponse();
    }

    /**
     * Create an instance of {@link GetListPersoneTelNum }
     * 
     */
    public GetListPersoneTelNum createGetListPersoneTelNum() {
        return new GetListPersoneTelNum();
    }

    /**
     * Create an instance of {@link GetListPersoneTelNumResponse }
     * 
     */
    public GetListPersoneTelNumResponse createGetListPersoneTelNumResponse() {
        return new GetListPersoneTelNumResponse();
    }

    /**
     * Create an instance of {@link GetListPersone }
     * 
     */
    public GetListPersone createGetListPersone() {
        return new GetListPersone();
    }

    /**
     * Create an instance of {@link GetListPersoneResponse }
     * 
     */
    public GetListPersoneResponse createGetListPersoneResponse() {
        return new GetListPersoneResponse();
    }

    /**
     * Create an instance of {@link GetListEnti }
     * 
     */
    public GetListEnti createGetListEnti() {
        return new GetListEnti();
    }

    /**
     * Create an instance of {@link GetListEntiResponse }
     * 
     */
    public GetListEntiResponse createGetListEntiResponse() {
        return new GetListEntiResponse();
    }

    /**
     * Create an instance of {@link GetListDirezioni }
     * 
     */
    public GetListDirezioni createGetListDirezioni() {
        return new GetListDirezioni();
    }

    /**
     * Create an instance of {@link GetListDirezioniResponse }
     * 
     */
    public GetListDirezioniResponse createGetListDirezioniResponse() {
        return new GetListDirezioniResponse();
    }

    /**
     * Create an instance of {@link GetListCognomi }
     * 
     */
    public GetListCognomi createGetListCognomi() {
        return new GetListCognomi();
    }

    /**
     * Create an instance of {@link GetListCognomiResponse }
     * 
     */
    public GetListCognomiResponse createGetListCognomiResponse() {
        return new GetListCognomiResponse();
    }

    /**
     * Create an instance of {@link GetGerarchiaByCodStrut }
     * 
     */
    public GetGerarchiaByCodStrut createGetGerarchiaByCodStrut() {
        return new GetGerarchiaByCodStrut();
    }

    /**
     * Create an instance of {@link GetGerarchiaByCodStrutResponse }
     * 
     */
    public GetGerarchiaByCodStrutResponse createGetGerarchiaByCodStrutResponse() {
        return new GetGerarchiaByCodStrutResponse();
    }

    /**
     * Create an instance of {@link GetAlfabetoTag }
     * 
     */
    public GetAlfabetoTag createGetAlfabetoTag() {
        return new GetAlfabetoTag();
    }

    /**
     * Create an instance of {@link GetAlfabetoTagResponse }
     * 
     */
    public GetAlfabetoTagResponse createGetAlfabetoTagResponse() {
        return new GetAlfabetoTagResponse();
    }

    /**
     * Create an instance of {@link EliminaTag }
     * 
     */
    public EliminaTag createEliminaTag() {
        return new EliminaTag();
    }

    /**
     * Create an instance of {@link EliminaTagResponse }
     * 
     */
    public EliminaTagResponse createEliminaTagResponse() {
        return new EliminaTagResponse();
    }

    /**
     * Create an instance of {@link AssociaTag }
     * 
     */
    public AssociaTag createAssociaTag() {
        return new AssociaTag();
    }

    /**
     * Create an instance of {@link AssociaTagResponse }
     * 
     */
    public AssociaTagResponse createAssociaTagResponse() {
        return new AssociaTagResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "chiave", scope = SuggestParolaChiave.class)
    public JAXBElement<String> createSuggestParolaChiaveChiave(String value) {
        return new JAXBElement<String>(_SuggestParolaChiaveChiave_QNAME, String.class, SuggestParolaChiave.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "firstName", scope = SuggestLastNameByFirstAndLast.class)
    public JAXBElement<String> createSuggestLastNameByFirstAndLastFirstName(String value) {
        return new JAXBElement<String>(_SuggestLastNameByFirstAndLastFirstName_QNAME, String.class, SuggestLastNameByFirstAndLast.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "lastName", scope = SuggestLastNameByFirstAndLast.class)
    public JAXBElement<String> createSuggestLastNameByFirstAndLastLastName(String value) {
        return new JAXBElement<String>(_SuggestLastNameByFirstAndLastLastName_QNAME, String.class, SuggestLastNameByFirstAndLast.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "firstName", scope = SuggestLastName.class)
    public JAXBElement<String> createSuggestLastNameFirstName(String value) {
        return new JAXBElement<String>(_SuggestLastNameByFirstAndLastFirstName_QNAME, String.class, SuggestLastName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "lastName", scope = SuggestLastName.class)
    public JAXBElement<String> createSuggestLastNameLastName(String value) {
        return new JAXBElement<String>(_SuggestLastNameByFirstAndLastLastName_QNAME, String.class, SuggestLastName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "chiave", scope = ServElencoAnagraficheUffici.class)
    public JAXBElement<String> createServElencoAnagraficheUfficiChiave(String value) {
        return new JAXBElement<String>(_SuggestParolaChiaveChiave_QNAME, String.class, ServElencoAnagraficheUffici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "idUfficio", scope = ServDettagliUfficio.class)
    public JAXBElement<String> createServDettagliUfficioIdUfficio(String value) {
        return new JAXBElement<String>(_ServDettagliUfficioIdUfficio_QNAME, String.class, ServDettagliUfficio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnagraficaUfficioVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "return", scope = ServDettagliUfficioResponse.class)
    public JAXBElement<AnagraficaUfficioVO> createServDettagliUfficioResponseReturn(AnagraficaUfficioVO value) {
        return new JAXBElement<AnagraficaUfficioVO>(_ServDettagliUfficioResponseReturn_QNAME, AnagraficaUfficioVO.class, ServDettagliUfficioResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "vecchioTag", scope = ModificaTag.class)
    public JAXBElement<String> createModificaTagVecchioTag(String value) {
        return new JAXBElement<String>(_ModificaTagVecchioTag_QNAME, String.class, ModificaTag.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "nuovoTag", scope = ModificaTag.class)
    public JAXBElement<String> createModificaTagNuovoTag(String value) {
        return new JAXBElement<String>(_ModificaTagNuovoTag_QNAME, String.class, ModificaTag.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "tagName", scope = InserisciTag.class)
    public JAXBElement<String> createInserisciTagTagName(String value) {
        return new JAXBElement<String>(_InserisciTagTagName_QNAME, String.class, InserisciTag.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "codStruttura", scope = GetPersoneByCodStrut.class)
    public JAXBElement<String> createGetPersoneByCodStrutCodStruttura(String value) {
        return new JAXBElement<String>(_GetPersoneByCodStrutCodStruttura_QNAME, String.class, GetPersoneByCodStrut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "idUfficio", scope = GetListUffici.class)
    public JAXBElement<String> createGetListUfficiIdUfficio(String value) {
        return new JAXBElement<String>(_ServDettagliUfficioIdUfficio_QNAME, String.class, GetListUffici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "character", scope = GetListTagForChar.class)
    public JAXBElement<String> createGetListTagForCharCharacter(String value) {
        return new JAXBElement<String>(_GetListTagForCharCharacter_QNAME, String.class, GetListTagForChar.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "idStruttura", scope = GetListStruttureInterne.class)
    public JAXBElement<String> createGetListStruttureInterneIdStruttura(String value) {
        return new JAXBElement<String>(_GetListStruttureInterneIdStruttura_QNAME, String.class, GetListStruttureInterne.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "telefono", scope = GetListPersoneTelNum.class)
    public JAXBElement<String> createGetListPersoneTelNumTelefono(String value) {
        return new JAXBElement<String>(_GetListPersoneTelNumTelefono_QNAME, String.class, GetListPersoneTelNum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormRicercaPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "frp", scope = GetListPersone.class)
    public JAXBElement<FormRicercaPersona> createGetListPersoneFrp(FormRicercaPersona value) {
        return new JAXBElement<FormRicercaPersona>(_GetListPersoneFrp_QNAME, FormRicercaPersona.class, GetListPersone.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "idEnte", scope = GetListEnti.class)
    public JAXBElement<String> createGetListEntiIdEnte(String value) {
        return new JAXBElement<String>(_GetListEntiIdEnte_QNAME, String.class, GetListEnti.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "idDirezione", scope = GetListDirezioni.class)
    public JAXBElement<String> createGetListDirezioniIdDirezione(String value) {
        return new JAXBElement<String>(_GetListDirezioniIdDirezione_QNAME, String.class, GetListDirezioni.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "lastName", scope = GetListCognomi.class)
    public JAXBElement<String> createGetListCognomiLastName(String value) {
        return new JAXBElement<String>(_SuggestLastNameByFirstAndLastLastName_QNAME, String.class, GetListCognomi.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "codStruttura", scope = GetGerarchiaByCodStrut.class)
    public JAXBElement<String> createGetGerarchiaByCodStrutCodStruttura(String value) {
        return new JAXBElement<String>(_GetPersoneByCodStrutCodStruttura_QNAME, String.class, GetGerarchiaByCodStrut.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GerarchiaVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "return", scope = GetGerarchiaByCodStrutResponse.class)
    public JAXBElement<GerarchiaVO> createGetGerarchiaByCodStrutResponseReturn(GerarchiaVO value) {
        return new JAXBElement<GerarchiaVO>(_ServDettagliUfficioResponseReturn_QNAME, GerarchiaVO.class, GetGerarchiaByCodStrutResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "tag", scope = EliminaTag.class)
    public JAXBElement<String> createEliminaTagTag(String value) {
        return new JAXBElement<String>(_EliminaTagTag_QNAME, String.class, EliminaTag.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "codStruttura", scope = AssociaTag.class)
    public JAXBElement<String> createAssociaTagCodStruttura(String value) {
        return new JAXBElement<String>(_GetPersoneByCodStrutCodStruttura_QNAME, String.class, AssociaTag.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rubrica.intranetdag.it", name = "tag", scope = AssociaTag.class)
    public JAXBElement<String> createAssociaTagTag(String value) {
        return new JAXBElement<String>(_EliminaTagTag_QNAME, String.class, AssociaTag.class, value);
    }

}
