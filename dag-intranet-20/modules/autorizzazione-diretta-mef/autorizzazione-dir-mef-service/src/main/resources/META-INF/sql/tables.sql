create table MEFSERV_AutorizzazioneDir (
	id_autorizzazione LONG not null primary key IDENTITY,
	id_applicazione LONG,
	mef LONG,
	dipartimento LONG,
	direzione LONG,
	ufficio LONG,
	codice_fiscale VARCHAR(75) null,
	nega BOOLEAN,
	tag VARCHAR(75) null
);

create table MEFSERV_Scrivania (
	rowId_ LONG,
	createDate DATE null,
	userId LONG not null,
	applicationId LONG not null,
	homeFlag BOOLEAN,
	profileFlag BOOLEAN,
	primary key (userId, applicationId)
);

create table MEFSERV_UtilizzoApplicazioni (
	rowId_ LONG,
	createDate DATE null,
	userId LONG not null,
	applicationId LONG not null,
	lastUseDate DATE null,
	hitsCount INTEGER,
	primary key (userId, applicationId)
);