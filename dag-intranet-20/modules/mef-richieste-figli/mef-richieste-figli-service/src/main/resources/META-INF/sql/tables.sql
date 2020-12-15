create table MFORM_RICHIESTA_RIMBORSO (
	Id LONG not null primary key,
	Nome_Richiedente VARCHAR(75) null,
	Cognome_Richiedente VARCHAR(75) null,
	Codice_Fiscale_Richiedente VARCHAR(75) null,
	Utente_Inserimento VARCHAR(75) null,
	Data_Inserimento VARCHAR(75) null,
	Iban VARCHAR(75) null,
	Importo VARCHAR(75) null,
	Figlio_Nome VARCHAR(75) null,
	Figlio_Cognome VARCHAR(75) null,
	Figlio_Data_Nascita VARCHAR(75) null,
	Figlio_Luogo_Nascita VARCHAR(75) null,
	Figlio_Codice_Fiscale VARCHAR(75) null,
	Note VARCHAR(500) null,
	Flag_Inviato BOOLEAN,
	Telefono VARCHAR(75) null,
	Allegato_UUID VARCHAR(75) null
);