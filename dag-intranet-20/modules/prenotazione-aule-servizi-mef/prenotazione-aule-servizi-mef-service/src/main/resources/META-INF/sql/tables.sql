create table MEFAULESERV_ServLog (
	id_serv LONG not null,
	id_sala LONG not null,
	email_ref VARCHAR(250) null,
	primary key (id_serv, id_sala)
);

create table MEFAULESERV_StrumEvento (
	id_strum LONG not null,
	id_sala LONG not null,
	email_ref VARCHAR(250) null,
	primary key (id_strum, id_sala)
);

create table MEFAULESERV_StrumTec (
	id_strum LONG not null,
	id_sala LONG not null,
	email_ref VARCHAR(250) null,
	primary key (id_strum, id_sala)
);