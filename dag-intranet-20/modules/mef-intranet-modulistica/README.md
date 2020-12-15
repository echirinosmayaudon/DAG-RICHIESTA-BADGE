Portlet per la gestione della modulistica.

Descrizione: 
-Configurazione "Classic": visualizzazione degli n moduli più scaricati negli ultimi n giorni.
-Configurazione "Categories": visualizzazione di tutte le categorie e dei relativi moduli;
                              motore di ricerca per parola chiave e per categoria d'appartenenza.
                              
                              
Componenti necessarie per il funzionamento della portlet:
-Creare un Custom fields associato a Document: Key=lastDownloadDate, Type=Date.
-Includere le categorie relative ai Documents in un vocabolario di nome "modulistica".
-Scaricare il modulo "mef-common-utilities", necessario per il funzionamento del motore di ricerca. 
  
  
Parametri di configurazione della portlet.
-in HomePage: choose folder = modulistica
              View = Classic
              Site Pages = ---Modulistica  
              
 -in Modulistica: choose folder = modulistica
                  View = Categories
                  Site Pages = Home                                         