create table MBADGE_AnaDipExt (
	id_dip_ext LONG not null primary key,
	nome_dip_ext VARCHAR(75) null,
	cognome_dip_ext VARCHAR(75) null,
	cf_dip_ext VARCHAR(16) null,
	luogonascita_dip_ext VARCHAR(255) null,
	datanascita_dip_ext DATE null
);

create table MBADGE_GestioneUtenti (
	id_gest_utenti LONG not null primary key,
	data_ DATE null,
	screename_dirigente VARCHAR(16) null,
	screename_utente VARCHAR(16) null,
	id_ufficio LONG,
	abilitazione BOOLEAN,
	delega BOOLEAN
);

create table MBADGE_OggettoRichiesta (
	id_oggetto LONG not null primary key,
	descrizione_oggetto VARCHAR(100) null
);

create table MBADGE_RichiestaBadge (
	id_pk LONG not null primary key,
	id_richiesta LONG,
	screename_richiedente VARCHAR(16) null,
	id_ufficio LONG,
	id_sedesiap LONG,
	json_richiedente VARCHAR(1000) null,
	is_internal BOOLEAN,
	nome_intestatario VARCHAR(75) null,
	cognome_intestatario VARCHAR(75) null,
	cf_intestatario VARCHAR(16) null,
	luogonascita_intestatario VARCHAR(255) null,
	datanascita_intestatario DATE null,
	id_oggetto LONG,
	numero_badge VARCHAR(75) null,
	uuid_foto VARCHAR(75) null,
	uuid_modulosostituzione VARCHAR(75) null,
	societa VARCHAR(150) null,
	referente_societa VARCHAR(100) null,
	progetto VARCHAR(500) null,
	json_richiesta_external VARCHAR(1500) null,
	array_sedi_abilitate VARCHAR(255) null,
	motivazione VARCHAR(500) null,
	data_scadenza DATE null,
	uuid_modulopdf VARCHAR(75) null,
	data_richiesta DATE null,
	data_modifica DATE null,
	id_stato LONG,
	utente_cambio_stato VARCHAR(16) null,
	note VARCHAR(500) null,
	is_last BOOLEAN
);

create table MBADGE_SediEsterne (
	id_sede_esterna LONG not null primary key,
	nome_sede_esterna VARCHAR(75) null,
	id_sedesiap LONG,
	acronimo_sede VARCHAR(75) null
);

create table MBADGE_StatoRichiesta (
	id_stato LONG not null primary key,
	descrizione_stato VARCHAR(100) null
);