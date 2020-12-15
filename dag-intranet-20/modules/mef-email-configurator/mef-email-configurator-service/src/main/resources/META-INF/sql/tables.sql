create table MEFEMAILC_AppNames (
	id_ LONG not null primary key,
	appname VARCHAR(75) null,
	appid LONG
);

create table MEFEMAILC_EmailApp (
	id_ LONG not null primary key,
	appid LONG,
	struttura LONG,
	email VARCHAR(1000) null
);