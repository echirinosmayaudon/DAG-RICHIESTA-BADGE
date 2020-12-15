Progetto per la gestione delle riunioni

PREREQUISITI:

Nel workspace dev'essere presente:
	- il progetto localization-mef : 
		http://ec2-35-157-6-6.eu-central-1.compute.amazonaws.com/devel_mef_intranet/localization-mef.git	
	- il progetto gestione-riunione-mef: (per poter richiamare i servizi dal db)
		http://ec2-35-157-6-6.eu-central-1.compute.amazonaws.com/devel_mef_intranet/gestione-riunioni-mef.git

Data la diversa visualizzazione dell'utente coordinatore rispetto agli altri utenti, occorre creare gli utenti coordinatore e segreteria su liferay, in questo modo:
- control panel>users>roles
- cliccare sul tastino + in basso a dx
- scrivere "coordinatore" su Name*
- ripetere la procedura: cliccare sul tastino + in basso a dx
- scrivere "segreteria" su Name*
- andare nel proprio account > account settings > Roles e aggiungere il ruolo coordinatore o segreteria a seconda della visualizzazione che si vuole testare.