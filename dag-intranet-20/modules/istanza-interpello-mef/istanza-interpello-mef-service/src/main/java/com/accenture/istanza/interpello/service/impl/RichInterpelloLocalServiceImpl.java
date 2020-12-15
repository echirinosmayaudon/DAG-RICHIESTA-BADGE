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

package com.accenture.istanza.interpello.service.impl;

import com.accenture.istanza.interpello.model.RichInterpello;
import com.accenture.istanza.interpello.service.base.RichInterpelloLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the rich interpello local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.accenture.istanza.interpello.service.RichInterpelloLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichInterpelloLocalServiceBaseImpl
 * @see com.accenture.istanza.interpello.service.RichInterpelloLocalServiceUtil
 */
public class RichInterpelloLocalServiceImpl extends RichInterpelloLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.accenture.istanza.interpello.service.RichInterpelloLocalServiceUtil}
	 * to access the rich interpello local service.
	 */

	Log _log = LogFactoryUtil.getLog(RichInterpelloLocalServiceImpl.class);

	@Override
	public long insertRichiestaInterpello(long id_richiesta, String cognome, String nome, long dipartimento,
			long direzione, long ufficio, String screename, String jsonRichiedente, String jsonRichiesta, String bando,
			Date data_richiesta, String allegato, String pdf, String note) {

		RichInterpello richiestaInterpello = richInterpelloPersistence.create(-1);

		richiestaInterpello.setId_richiesta(id_richiesta);
		richiestaInterpello.setCognome(cognome);
		richiestaInterpello.setNome(nome);
		richiestaInterpello.setDipartimento(dipartimento);
		richiestaInterpello.setDirezione(direzione);
		richiestaInterpello.setUfficio(ufficio);
		richiestaInterpello.setScreename(screename);
		richiestaInterpello.setJson_richiedente(jsonRichiedente);
		richiestaInterpello.setJson_richiesta(jsonRichiesta);
		richiestaInterpello.setBando(bando);
		richiestaInterpello.setData_richiesta(data_richiesta);
		richiestaInterpello.setAllegato(allegato);
		richiestaInterpello.setPdf(pdf);
		richiestaInterpello.setNote(note);

		try {
			richInterpelloPersistence.updateImpl(richiestaInterpello);
			richiestaInterpello.setId_richiesta(richiestaInterpello.getPrimaryKey());
			richInterpelloPersistence.updateImpl(richiestaInterpello);
			return richiestaInterpello.getId_richiesta();
		} catch (Exception e) {
			_log.error(e);
			return 0;
		}

	}

	@Override
	public List<RichInterpello> getRichByScreename(String screename) {
		List<RichInterpello> listaRich = this.richInterpelloPersistence.findByscreename(screename);
		return listaRich;

	}

	@Override
	public List<RichInterpello> getRichiesteOrder(String order, long codiceIstanza, String cognome, long dip, long dir,
			long uff) {
		List<RichInterpello> listaRes = richInterpelloFinder.getRichiesteOrder(order, codiceIstanza, cognome, dip, dir,
				uff);
		return listaRes;
	}
}