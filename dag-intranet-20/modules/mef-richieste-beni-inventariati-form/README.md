Portlet per la funzionalita di richieste beni inventariati

PREREQUISITI:

Data la compresenza di diverse tipologie di utenti coinvolti nel servizio (e quindi di differenti viste e limitazioni per ciascuno di essi), occorre creare 
i seguenti ruoli:

-richiedenteBeniInv  (il relativo dipartimento � ottenuto dall��idOrgChart� dell�utente avente tale ruolo)

-consegnatarioBeniInv_personale  (responsabile centro di costo dag)
-consegnatarioBeniInv_tesoro (responsabile centro di costo dt)
-consegnatarioBeniInv_finanze (responsabile centro di costo df)
-consegnatarioBeniInv_rgs  (responsabile centro di costo rgs)
                                    
-cdcBeniInv_personale (responsabile centro di costo dag)
-cdcBeniInv_tesoro (responsabile centro di costo dt)
-cdcBeniInv_finanze (responsabile centro di costo df)
-cdcBeniInv_rgs (responsabile centro di costo rgs):

Per il direttore responsabileCDC e per il consegnatario sono previsti quattro ruoli distinti  (uno per ogni dipartimento)  in quanto � possibile che uno stesso responsabileCDC o consegnatario
possa avere competenza per pi� dipartimenti (in tal caso l�utente avr� assegnati tanti ruoli di tipo �cdcBeniInv_...� o tanti ruoli "consegnatarioBeniInv_...").



Per la creazione dei sopracitati ruoli, seguire le seguenti indicazioni:
- control panel>users>roles
- cliccare sul tastino + in basso a dx
- scrivere "richiedenteBeniInv" su Name*
- ripetere la procedura: cliccare sul tastino + in basso a dx
- ...
- creare uno specifico account per ogni ruolo e, per ciascuno di questi account,
andare in > account settings > Roles e aggiungere il ruolo d'interesse, a seconda della visualizzazione che si vuole testare.