create table MEFAULE_Approvatore (
	id_approvatore LONG not null primary key,
	id_sala LONG,
	email_approvatore VARCHAR(75) null
);

create table MEFAULE_Orario (
	id_ora LONG not null primary key,
	ore VARCHAR(75) null
);

create table MEFAULE_Prenotazione (
	id_prenota LONG not null primary key,
	id_sala LONG,
	cod_fiscale VARCHAR(16) null,
	data_prenota DATE null,
	data_inizio DATE null,
	data_fine DATE null,
	partecipanti INTEGER,
	id_evento LONG,
	attivita VARCHAR(100) null,
	note VARCHAR(500) null,
	id_stato LONG,
	dati_rich VARCHAR(1500) null,
	servizi VARCHAR(1500) null
);

create table MEFAULE_Sala (
	id_sala LONG not null primary key,
	desc_sala VARCHAR(75) null,
	indirizzo VARCHAR(75) null,
	citta VARCHAR(75) null,
	cap VARCHAR(5) null,
	cod_prov VARCHAR(2) null,
	piano VARCHAR(75) null,
	stanza VARCHAR(75) null,
	posti INTEGER,
	video_conferenza BOOLEAN,
	proiettore BOOLEAN,
	postazione_rete BOOLEAN,
	autorizzazione BOOLEAN,
	email_ref VARCHAR(75) null
);

create table MEFAULE_SalaStruttura (
	id_ LONG not null primary key,
	id_sala LONG,
	id_struttura LONG
);

create table MEFAULE_ServizioLog (
	id_servizio LONG not null primary key,
	desc_servizio VARCHAR(75) null,
	email_ref VARCHAR(75) null
);

create table MEFAULE_StatoAula (
	id_stato_aula LONG not null primary key,
	desc_stato VARCHAR(75) null
);

create table MEFAULE_StrumentoEvento (
	id_strumento LONG not null primary key,
	desc_strumento VARCHAR(75) null,
	email_ref VARCHAR(75) null
);

create table MEFAULE_StrumentoTec (
	id_strumento LONG not null primary key,
	desc_strumento VARCHAR(75) null,
	email_ref VARCHAR(75) null
);

create table MEFAULE_TipoEvento (
	id_evento LONG not null primary key,
	desc_evento VARCHAR(75) null
);