create table MEFRUBRICA_SearchData (
	uuid_ VARCHAR(75) null,
	searchId LONG not null primary key,
	searchData VARCHAR(1000) null,
	createDate DATE null
);