create table MEFINTRANET_Favourites (
	favourite_id LONG not null primary key,
	user_id LONG,
	title_favourite VARCHAR(75) null,
	description_favourite VARCHAR(75) null,
	tag_favourite VARCHAR(75) null,
	url_favourite VARCHAR(75) null,
	save_date VARCHAR(75) null
);