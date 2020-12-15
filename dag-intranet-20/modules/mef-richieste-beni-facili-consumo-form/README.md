Portlet per la funzionalita di richiesta beni di facile consumo

PREREQUISITI:

Occorre creare quattro ruoli:

- Dirigente
- delegatoBfc
- abilitatoBfc
- consegnatarioBfc

Procedere in questo modo:

- control panel>users>roles
- cliccare sul tastino + in basso a dx
- scrivere "Dirigente" su Name*
- ripetere la procedura: cliccare sul tastino + in basso a dx
- scrivere "delegatoBfc" su Name*
- ripetere la procedura: cliccare sul tastino + in basso a dx
- scrivere "abilitatoBfc" su Name*
- ripetere la procedura: cliccare sul tastino + in basso a dx
- scrivere "consegnatarioBfc" su Name*
- creare 4 utenti Liferay per ciascuno di essi.

Creare due custom field in questo modo:
- control panel>pannello di controllo>configurazione>campi personalizzati
- cliccare su Utente
- controllare che non esista già il custom field di nome "Idorgchart"
- se non esiste, creare un custom field di tipo "Testo" ed attribuirgli il nome "Idorgchart"
- per ciascun utente di cui sopra, valorizzare il custom field con il valore di un id di un ufficio esistente (p.e. 24992)
- ripetere la procedura: cliccare su Utente
- controllare che non esista già il custom field di nome "Personalid"
- se non esiste, creare un custom field di tipo "Testo" ed attribuirgli il nome "Personalid"
- SOLO PER L'UTENTE DIRIGENTE DI CUI SOPRA, valorizzare il custom field con un valore valido (p.e. 21301)

Poich� la portlet deve essere accessibile esclusivamente agli utenti di cui sopra, configurare la visibilità della portlet in questo modo: 
- click sui tre puntini delle opzioni della portlet
- click su Permissions
- togliere la spunta view al power user
- mettere la spunta view ai ruoli di cui sopra