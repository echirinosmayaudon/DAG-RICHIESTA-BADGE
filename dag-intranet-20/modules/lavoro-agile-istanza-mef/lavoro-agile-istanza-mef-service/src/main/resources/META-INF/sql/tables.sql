create table MEFISTAGILE_Email (
	id_ LONG not null primary key,
	idStruttura LONG,
	mailCC VARCHAR(2000) null
);

create table MEFISTAGILE_OpzioneRich (
	id_opt LONG not null primary key,
	label_opt VARCHAR(100) null,
	testo_opt VARCHAR(2000) null,
	peso_opt INTEGER,
	data_in DATE null
);

create table MEFISTAGILE_RichLavAgile (
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
	peso_tot INTEGER,
	peso_plus VARCHAR(75) null,
	bando VARCHAR(75) null,
	data_richiesta DATE null,
	allegato VARCHAR(200) null,
	pdf VARCHAR(75) null
);