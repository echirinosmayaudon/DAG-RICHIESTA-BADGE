create table CNTB_SOLID_DONATORE_Donatore (
	id_ LONG not null primary key,
	nome VARCHAR(75) null,
	cognome VARCHAR(75) null,
	cod_fiscale VARCHAR(75) null,
	email VARCHAR(75) null,
	importo VARCHAR(75) null,
	data_inserimento VARCHAR(75) null
);

create table CNTB_SOLID_Donatore (
	id_ LONG not null primary key,
	nome VARCHAR(75) null,
	cognome VARCHAR(75) null,
	cod_fiscale VARCHAR(75) null,
	email VARCHAR(75) null,
	data_inserimento VARCHAR(75) null,
	importo VARCHAR(75) null
);