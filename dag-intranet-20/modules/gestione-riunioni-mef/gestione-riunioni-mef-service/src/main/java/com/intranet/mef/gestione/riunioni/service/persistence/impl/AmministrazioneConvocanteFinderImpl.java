package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import com.intranet.mef.gestione.riunioni.model.AmministrazioneConvocante;
import com.intranet.mef.gestione.riunioni.service.AmministrazioneConvocanteLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.persistence.AmministrazioneConvocanteFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class AmministrazioneConvocanteFinderImpl extends AmministrazioneConvocanteFinderBaseImpl
		implements AmministrazioneConvocanteFinder {

	final Log _log = LogFactoryUtil.getLog(AmministrazioneConvocanteFinderImpl.class);

	public List<AmministrazioneConvocante> findByKeywordAdmin(String keyword) {

		List<AmministrazioneConvocante> res = new ArrayList<>();
		Session session = null;
		try {
			session = openSession();

			DynamicQuery queryAmministrazioneConvocante = DynamicQueryFactoryUtil
					.forClass(AmministrazioneConvocante.class, getClassLoader());

			if (!"".equals(keyword)) {
				String value = (new StringBuilder("%")).append(keyword).append("%").toString();
				queryAmministrazioneConvocante.add(RestrictionsFactoryUtil.ilike("nome_amministrazione", value));
			}

			res = AmministrazioneConvocanteLocalServiceUtil.dynamicQuery(queryAmministrazioneConvocante);

		} catch (Exception e) {
			_log.warn(e);
		} finally {

			closeSession(session);
		}
		return res;
	}

}
