package com.intranet.mef.gestione.riunioni.service.persistence.impl;

import com.intranet.mef.gestione.riunioni.model.Luogo;
import com.intranet.mef.gestione.riunioni.service.LuogoLocalServiceUtil;
import com.intranet.mef.gestione.riunioni.service.persistence.LuogoFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class LuogoFinderImpl extends LuogoFinderBaseImpl implements LuogoFinder {

	final Log _log = LogFactoryUtil.getLog(LuogoFinderImpl.class);

	public List<Luogo> findByKeywordLuogo(String keyword) {

		List<Luogo> res = new ArrayList<>();
		Session session = null;
		try {
			session = openSession();

			DynamicQuery queryLuogo = DynamicQueryFactoryUtil.forClass(Luogo.class, getClassLoader());

			if (!"".equals(keyword)) {
				String value = (new StringBuilder("%")).append(keyword).append("%").toString();
				queryLuogo.add(RestrictionsFactoryUtil.ilike("nome", value));
			}

			res = LuogoLocalServiceUtil.dynamicQuery(queryLuogo);

		} catch (Exception e) {
			_log.warn(e);
		} finally {

			closeSession(session);
		}
		return res;
	}

}
