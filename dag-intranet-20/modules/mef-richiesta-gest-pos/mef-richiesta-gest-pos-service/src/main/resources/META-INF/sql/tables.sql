create table BADGE_POS_Corridoio (
	id_pk_corridoio LONG not null primary key,
	id_corridoio LONG,
	id_piano LONG,
	cod_corridoio VARCHAR(75) null,
	desc_ VARCHAR(75) null,
	data_ins VARCHAR(75) null,
	data_agg VARCHAR(75) null,
	user_ins VARCHAR(75) null,
	user_agg VARCHAR(75) null
);

create table BADGE_POS_FuoriPorta (
	id_pk_fuoriPorta LONG not null primary key,
	id_fuoriPorta LONG,
	id_corridoio LONG,
	cod_fuoriPorta VARCHAR(75) null,
	desc_ VARCHAR(75) null,
	data_ins VARCHAR(75) null,
	data_agg VARCHAR(75) null,
	user_ins VARCHAR(75) null,
	user_agg VARCHAR(75) null
);

create table BADGE_POS_Piano (
	id_pk_piano LONG not null primary key,
	id_piano LONG,
	id_sede LONG,
	cod_piano VARCHAR(75) null,
	desc_ VARCHAR(75) null,
	data_ins VARCHAR(75) null,
	data_agg VARCHAR(75) null,
	user_ins VARCHAR(75) null,
	user_agg VARCHAR(75) null
);

create table BADGE_POS_Sede (
	id_pk_sede LONG not null primary key,
	id_sede LONG,
	cod_sede VARCHAR(75) null,
	desc_ VARCHAR(75) null,
	data_ins VARCHAR(75) null,
	data_agg VARCHAR(75) null,
	user_ins VARCHAR(75) null,
	user_agg VARCHAR(75) null
);