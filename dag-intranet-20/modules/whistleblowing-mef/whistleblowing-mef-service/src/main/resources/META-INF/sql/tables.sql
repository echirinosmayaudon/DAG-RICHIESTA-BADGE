create table MEFWHISTLE_Segnalazione (
	id_segnalazione LONG not null primary key,
	json_dati_personali VARCHAR(1500) null,
	luogo VARCHAR(500) null,
	azioni_omissioni VARCHAR(1500) null,
	descrizione VARCHAR(1000) null,
	autore VARCHAR(1000) null,
	altri_testimoni VARCHAR(1000) null
);