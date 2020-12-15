create table MEFBFC_CambioStatoDirigente (
	id_ LONG not null primary key,
	id_rich LONG,
	data_ DATE null,
	utente VARCHAR(75) null,
	id_stato LONG,
	note VARCHAR(500) null
);

create table MEFBFC_GestioneUtenti (
	id_ LONG not null primary key,
	data_ DATE null,
	cod_fiscale VARCHAR(16) null,
	nome VARCHAR(75) null,
	cognome VARCHAR(75) null,
	ufficio VARCHAR(75) null,
	abilitazione BOOLEAN,
	delega BOOLEAN
);

create table MEFBFC_Periodicita (
	id_ LONG not null primary key,
	descrizione VARCHAR(75) null
);

create table MEFBFC_RigheRichiestaBFC (
	id_ LONG not null primary key,
	id_richiesta LONG,
	dipartimento VARCHAR(75) null,
	dati STRING null
);

create table MEFBFC_ServizioMateriale (
	gruppo VARCHAR(75) not null primary key,
	descrizione VARCHAR(75) null,
	categoria VARCHAR(75) null
);

create table MEFBFC_Stato (
	id_ LONG not null primary key,
	descrizione VARCHAR(75) null
);