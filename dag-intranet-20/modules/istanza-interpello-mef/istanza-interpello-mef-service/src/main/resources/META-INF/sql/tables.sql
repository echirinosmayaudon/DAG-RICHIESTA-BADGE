create table MEFINTERPELLO_Email (
	id_ LONG not null primary key,
	idStruttura LONG,
	mailCC VARCHAR(2000) null
);

create table MEFINTERPELLO_RichInterpello (
	id_ LONG not null primary key,
	id_richiesta LONG,
	cognome VARCHAR(75) null,
	nome VARCHAR(75) null,
	dipartimento LONG,
	direzione LONG,
	ufficio LONG,
	screename VARCHAR(75) null,
	json_richiedente VARCHAR(2000) null,
	json_richiesta VARCHAR(2000) null,
	bando VARCHAR(75) null,
	data_richiesta DATE null,
	allegato VARCHAR(200) null,
	pdf VARCHAR(200) null,
	note VARCHAR(1000) null
);

create table MEFINTERPELLO_TextRich (
	id_text LONG not null primary key,
	label_text VARCHAR(100) null,
	testo_text VARCHAR(2000) null,
	data_in DATE null
);