Progetto per visualizzare le label dei vari progetti in base alla localizzazione 


CONFIGURAZIONE
Per poter sfruttare questo modulo all'interno della portlet seguire i seguenti passi:
- copiare le seguenti righe nel file bnd della portlet che utilizzerà questo modulo:

Require-Capability: liferay.resource.bundle;filter:="(bundle.symbolic.name=localization.mef)"
Provide-Capability: liferay.resource.bundle;resource.bundle.aggregate:String="(bundle.symbolic.name=localization.mef)";resource.bundle.base.name="content.Language"

- verificare che la seguente riga sia presente nella classe controller java della porlet all'interno di @Component

"javax.portlet.resource-bundle=content.Language"


UTILIZZO
aggiungere nel language.properties di questo modulo all'interno della directory resources/content, le coppie chiave = valore che servono nella portlet.

Per l’utilizzo dei language si possono utilizzare due strade all'interno della portlet: 
1)	<liferay-ui:message key=”chiave”/> (nell’html inserire il valore associato alla chiave)
2)	String labelX = LanguageUtil.get(themeDisplay.getLocale(),“key”); 


ulteriori informazioni: 
https://dev.liferay.com/develop/tutorials/-/knowledge_base/7-0/localizing-your-application