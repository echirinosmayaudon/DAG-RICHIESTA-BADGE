/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package servizio.richieste.badge.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface RichiestaBadgeFinder {
	public java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> getRichiestaBadgeByFilters(
		java.lang.String cogn_intest, java.lang.String nome_intest,
		java.lang.String cf_intest, java.lang.String societa,
		java.lang.String ref_societa, java.lang.String motivazione_rich,
		java.lang.String progetto, java.lang.String screenName,
		java.util.List<java.lang.Long> lista_idUffici, boolean is_last,
		java.util.List<java.lang.Long> lista_sedi,
		java.lang.String is_internal, java.util.List<java.lang.Long> lista_stati);

	public java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiestaByDipartimentoStato(
		java.lang.String dipartimento,
		java.util.List<java.lang.Long> lista_IdStato);

	public java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiestaByDataRuoloSede(
		java.util.Date dataStart, java.util.Date dataEnd, boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap);

	public java.util.List<servizio.richieste.badge.mef.model.RichiestaBadge> findRichiesteInScadenza(
		java.util.Date data_begin, java.util.Date data_end, boolean is_last,
		long id_stato, java.lang.String screen_name_richiedente,
		java.util.List<java.lang.Long> id_uffici_competenza_list);

	public java.util.List<java.lang.Object[]> findNumbersRichiestaByDataRuoloSedeforIdOggetto(
		java.util.Date dataStart, java.util.Date dataEnd, boolean is_last,
		boolean is_internal, long id_stato, long id_sedesiap);
}