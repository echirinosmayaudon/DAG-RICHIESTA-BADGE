create table MFORM_Asset (
	id_ LONG not null primary key,
	descrizione VARCHAR(500) null
);

create table MFORM_BadgeRichieste (
	id_ LONG not null primary key,
	utente VARCHAR(75) null,
	dettaglio_richiedente VARCHAR(2500) null,
	cognome VARCHAR(75) null,
	nome VARCHAR(75) null,
	luogo_nascita VARCHAR(75) null,
	data_nascita DATE null,
	codice_fiscale VARCHAR(16) null,
	numerobadge VARCHAR(75) null,
	allegatoUuid VARCHAR(75) null,
	operazione VARCHAR(75) null,
	data_richiesta DATE null,
	procedura VARCHAR(200) null,
	disattivazione DATE null
);

create table MFORM_BeneInv (
	id_ LONG not null primary key,
	bene VARCHAR(75) null,
	id_tipo LONG
);

create table MFORM_BeneInvRichiesto (
	id_bene_rich LONG not null primary key,
	tipologia VARCHAR(75) null,
	descrizione VARCHAR(75) null,
	quantita INTEGER,
	dettagli VARCHAR(75) null,
	in_elenco BOOLEAN,
	id_richiesta LONG
);

create table MFORM_HardwareTecnici (
	id_ LONG not null primary key,
	descrizione VARCHAR(500) null
);

create table MFORM_LogisticaRichieste (
	id_ LONG not null primary key,
	oggetto VARCHAR(1500) null,
	utente VARCHAR(500) null,
	dipartimento VARCHAR(75) null,
	data_richiesta DATE null,
	dettaglio_richiedente VARCHAR(2500) null,
	dettaglio_richieste VARCHAR(2500) null,
	note_gestore VARCHAR(500) null,
	id_valutazione LONG,
	id_stato LONG,
	note VARCHAR(1500) null
);

create table MFORM_LogisticaServizio (
	id_ LONG not null primary key,
	descrizione VARCHAR(500) null
);

create table MFORM_LogisticaStato (
	id_ LONG not null primary key,
	descrizione VARCHAR(500) null,
	utente VARCHAR(500) null
);

create table MFORM_LogisticaValutazione (
	id_ LONG not null primary key,
	descrizione VARCHAR(500) null
);

create table MFORM_ModuloTrasporti (
	id_modulo_trasporti LONG not null primary key,
	cognome VARCHAR(75) null,
	nome VARCHAR(75) null,
	codice_fiscale VARCHAR(16) null,
	utente_inserimento VARCHAR(75) null,
	data_inserimento DATE null,
	flag_tipospesa VARCHAR(75) null,
	iban VARCHAR(75) null,
	importo VARCHAR(75) null,
	data_titolo_annuale DATE null,
	nr_titoli_mensili VARCHAR(75) null,
	figlio_nome VARCHAR(75) null,
	figlio_cognome VARCHAR(75) null,
	figlio_data_nascita DATE null,
	figlio_luogo_data VARCHAR(75) null,
	figlio_codicefiscale VARCHAR(16) null,
	note VARCHAR(500) null,
	flag_inviato VARCHAR(75) null,
	telefono VARCHAR(75) null,
	allegatoUuid VARCHAR(75) null
);

create table MFORM_PeriodicitaRichPubblic (
	id_ LONG not null primary key,
	periodicita VARCHAR(75) null
);

create table MFORM_RichiestaBeneInv (
	id_richiesta LONG not null primary key,
	utente VARCHAR(75) null,
	nome_rich VARCHAR(75) null,
	cogn_rich VARCHAR(75) null,
	dip_dir VARCHAR(75) null,
	dati_rich VARCHAR(500) null,
	oggetto VARCHAR(75) null,
	data_ DATE null,
	beneficiario VARCHAR(255) null,
	destinazione VARCHAR(75) null,
	id_stato LONG,
	note_consegn VARCHAR(500) null
);

create table MFORM_RichiestaInterventi (
	id_ LONG not null primary key,
	utente VARCHAR(75) null,
	dettaglio VARCHAR(2500) null,
	data_interventi DATE null
);

create table MFORM_RichiestaPubblicSiti (
	id_rich_pubblic LONG not null primary key,
	dati_richiedente VARCHAR(255) null,
	dati_docum VARCHAR(255) null,
	titolo VARCHAR(255) null,
	sottotitolo VARCHAR(255) null,
	novita_abstract VARCHAR(3500) null,
	note_riferim VARCHAR(2000) null,
	dati_stampa_carta VARCHAR(75) null,
	dati_altro VARCHAR(75) null,
	dati_autorizzaz VARCHAR(75) null,
	note_autorizzaz VARCHAR(500) null,
	lista_allegati VARCHAR(255) null
);

create table MFORM_RichiesteHW (
	id_richieste_hw LONG not null primary key,
	utente VARCHAR(200) null,
	dettaglio VARCHAR(2500) null,
	data_richiesta DATE null
);

create table MFORM_RichiesteUtenza (
	id_richieste_utenza LONG not null primary key,
	utente VARCHAR(200) null,
	destinatario VARCHAR(200) null,
	dettaglio VARCHAR(2500) null,
	data_richiesta DATE null
);

create table MFORM_StatoRichBeneInv (
	id_ LONG not null primary key,
	stato VARCHAR(75) null
);

create table MFORM_TipoBeneInv (
	id_ LONG not null primary key,
	tipo VARCHAR(75) null
);

create table MFORM_TipologiaComputer (
	id_tipologia_computer LONG not null primary key,
	descrizione VARCHAR(75) null
);

create table MFORM_TipologiaDispositivi (
	id_tipologia_dispositivi LONG not null primary key,
	descrizione VARCHAR(75) null
);

create table MFORM_TipologiaRichPubblic (
	id_ LONG not null primary key,
	tipologia VARCHAR(75) null
);

create table MFORM_TipologiaStampanti (
	id_tipologia_stampanti LONG not null primary key,
	descrizione VARCHAR(75) null
);