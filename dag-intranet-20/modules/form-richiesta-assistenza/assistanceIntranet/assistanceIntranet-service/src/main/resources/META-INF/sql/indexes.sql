create index IX_E49D14B9 on Assistance_Ambito (uuid_[$COLUMN_LENGTH:75$]);

create index IX_366951DD on Assistance_Area (assServiceId[$COLUMN_LENGTH:75$]);
create index IX_D5F2047A on Assistance_Area (uuid_[$COLUMN_LENGTH:75$]);

create index IX_1D6A560C on Assistance_Faq (faqId[$COLUMN_LENGTH:75$]);
create index IX_58A4327F on Assistance_Faq (uuid_[$COLUMN_LENGTH:75$]);

create index IX_543112BC on Assistance_Problem (topicId[$COLUMN_LENGTH:75$]);
create index IX_3A093996 on Assistance_Problem (uuid_[$COLUMN_LENGTH:75$]);

create index IX_227317DC on Assistance_Servizio (assScopeId[$COLUMN_LENGTH:75$]);
create index IX_509F9D5A on Assistance_Servizio (uuid_[$COLUMN_LENGTH:75$]);

create index IX_21BB692A on Assistance_Topic (areaId[$COLUMN_LENGTH:75$]);
create index IX_FF216EC6 on Assistance_Topic (uuid_[$COLUMN_LENGTH:75$]);