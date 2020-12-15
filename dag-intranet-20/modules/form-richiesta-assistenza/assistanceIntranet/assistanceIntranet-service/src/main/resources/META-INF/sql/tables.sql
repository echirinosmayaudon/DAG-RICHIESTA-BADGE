create table Assistance_Ambito (
	uuid_ VARCHAR(75) null,
	assScopeId VARCHAR(75) not null primary key,
	scopeName VARCHAR(200) null
);

create table Assistance_Area (
	uuid_ VARCHAR(75) null,
	areaId VARCHAR(75) not null primary key,
	areaName VARCHAR(200) null,
	assServiceId VARCHAR(75) null
);

create table Assistance_Faq (
	uuid_ VARCHAR(75) null,
	faqId VARCHAR(75) not null,
	siebelId VARCHAR(75) not null,
	questions TEXT null,
	response TEXT null,
	primary key (faqId, siebelId)
);

create table Assistance_Problem (
	uuid_ VARCHAR(75) null,
	problemId VARCHAR(75) not null primary key,
	problemName VARCHAR(200) null,
	topicId VARCHAR(75) null
);

create table Assistance_Servizio (
	uuid_ VARCHAR(75) null,
	assServiceId VARCHAR(75) not null primary key,
	serviceName VARCHAR(200) null,
	assScopeId VARCHAR(75) null,
	levelAssistance VARCHAR(75) null
);

create table Assistance_Topic (
	uuid_ VARCHAR(75) null,
	topicId VARCHAR(75) not null primary key,
	topicName VARCHAR(200) null,
	areaId VARCHAR(75) null
);