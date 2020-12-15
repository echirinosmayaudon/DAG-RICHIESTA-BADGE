create table SENDCALENDAR_LogMail (
	uuid_ VARCHAR(75) null,
	logMailId LONG not null primary key,
	mailTo VARCHAR(75) null,
	eventTitle VARCHAR(75) null,
	eventDescription VARCHAR(75) null,
	dateStart DATE null,
	dateFinish DATE null
);