create table MEF_AmministrazioneConvocante (
	id_amministrazione_convocante LONG not null primary key,
	nome_amministrazione VARCHAR(250) null
);

create table MEF_InvitatiRiunione (
	id_segreteria LONG not null,
	note STRING null,
	partecipanti STRING null,
	id_stato_invitato LONG,
	id_riunione LONG not null,
	primary key (id_segreteria, id_riunione)
);

create table MEF_Luogo (
	id_luogo LONG not null primary key,
	nome VARCHAR(250) null
);

create table MEF_Riunione (
	id_riunione LONG not null primary key,
	oggetto VARCHAR(500) null,
	data_inizio DATE null,
	data_fine DATE null,
	note STRING null,
	data_modifica DATE null,
	data_creazione DATE null,
	protocollo VARCHAR(50) null,
	id_stato_riunione LONG,
	id_tipo LONG,
	id_luogo LONG,
	id_amministrazione_convocante LONG,
	data_ultimo_sollecito DATE null
);

create table MEF_Segreteria (
	id_segreteria LONG not null primary key,
	email VARCHAR(100) null,
	descrizione VARCHAR(500) null,
	acronimo VARCHAR(50) null,
	livello_gerarchia LONG,
	cod_padre LONG,
	data_fine_esistenza DATE null,
	indirizzo VARCHAR(250) null,
	cap VARCHAR(5) null,
	cod_istat_citta LONG
);

create table MEF_StatoInvitato (
	id_stato_invitato LONG not null primary key,
	nome_stato VARCHAR(50) null
);

create table MEF_StatoRiunione (
	id_stato_riunione LONG not null primary key,
	label VARCHAR(15) null,
	next_stato VARCHAR(35) null
);

create table MEF_StoricoStatoRiunione (
	id_riunione LONG not null,
	id_storico LONG not null,
	data_ DATE null,
	id_stato_riunione LONG,
	primary key (id_riunione, id_storico)
);

create table MEF_TipoRiunione (
	id_tipo LONG not null primary key,
	descrizione VARCHAR(50) null
);