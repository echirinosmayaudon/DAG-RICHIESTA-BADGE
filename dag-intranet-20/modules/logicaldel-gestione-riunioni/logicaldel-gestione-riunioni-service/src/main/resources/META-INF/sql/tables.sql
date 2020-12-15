create table LOGICALGR_CancelAmmConv (
	id_amministrazione_convocante LONG not null primary key,
	cancellato BOOLEAN
);

create table LOGICALGR_CancelLuogo (
	id_luogo LONG not null primary key,
	cancellato BOOLEAN
);