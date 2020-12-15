Portlet per la funzionalita di prenotazione aule e sale

PREREQUISITI:

Occorre creare due ruoli - richiedenteSale ed approvatoreSale - e due utenti Liferay. Procedere in questo modo:
- control panel>users>roles
- cliccare sul tastino + in basso a dx
- scrivere "richiedenteSale" su Name*
- ripetere la procedura: cliccare sul tastino + in basso a dx
- scrivere "approvatoreSale" su Name*
- creare due account: al primo account aggiungere solo il ruolo di richiedenteSale, mentre al secondo aggiungere entrambi i ruoli.

Creare un custom field in questo modo:
- control panel>pannello di controllo>configurazione>campi personalizzati
- cliccare su Utente
- controllare che non esista già il custom field di nome "Idorgchart"
- se non esiste, creare un custom field di tipo "Testo" ed attribuirgli il nome "Idorgchart"
- per ciascun utente di cui sopra, valorizzare il custom field con il valore di un id di un ufficio esistente (p.e. 24892).

Poichè la portlet deve essere accessibile esclusivamente agli utenti di cui sopra, configurare la visibilità della portlet in questo modo: 
- click sui tre puntini delle opzioni della portlet
- click su Permissions
- togliere la spunta view al power user
- mettere la spunta view al richiedenteSale
- mettere la spunta view all'approvatoreSale