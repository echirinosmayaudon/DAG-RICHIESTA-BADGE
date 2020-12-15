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

package service.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface RichiestaBeneInvFinder {
	public java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFilters(
		long id_richiesta, java.lang.String nome_rich,
		java.lang.String cogn_rich, java.util.Date data,
		java.lang.String dip_dir, java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco);

	public java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(
		long id_richiesta, java.lang.String screenName, java.util.Date data,
		java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco);
}