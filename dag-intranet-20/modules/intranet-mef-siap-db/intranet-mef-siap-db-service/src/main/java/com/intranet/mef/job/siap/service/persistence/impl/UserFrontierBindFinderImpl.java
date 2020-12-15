package com.intranet.mef.job.siap.service.persistence.impl;

import java.util.Iterator;

import com.intranet.mef.job.siap.configuration.IntranetMefSiapDbConfigurationValues;
import com.intranet.mef.job.siap.service.persistence.UserFrontierBindFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

public class UserFrontierBindFinderImpl extends UserFrontierBindFinderBaseImpl
	implements UserFrontierBindFinder {

	public static final String CALL_DUMMY =
			UserFrontierBindFinderImpl.class.getName() +".Dummy";

	public static final String CALL_LOAD_BCK =
		UserFrontierBindFinderImpl.class.getName() +".LoadBck";

	public static final String CALL_ERROR_IMPORT =
			UserFrontierBindFinderImpl.class.getName() +".ErrorImport";

	public String callLoadBck() {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), CALL_LOAD_BCK);

			sql = StringUtil.replace(sql, "[$NAME_FUNCTION$]",
				IntranetMefSiapDbConfigurationValues.FUNCTION_DB_SIAP_ORACLE_LOAD_BCK);

			SQLQuery query  = session.createSQLQuery(sql);
			query.setCacheable(false);

			Iterator<String> itr = query.iterate();

			if (itr.hasNext()) {
				String result = itr.next();

				if (result != null) {
					return result;
				}
			}

			return Boolean.FALSE.toString();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public String callDummy() {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), CALL_DUMMY);

			sql = StringUtil.replace(sql, "[$NAME_FUNCTION$]",
				IntranetMefSiapDbConfigurationValues.FUNCTION_DB_SIAP_ORACLE_DUMMY);

			SQLQuery query  = session.createSQLQuery(sql);
			query.setCacheable(false);

			Iterator<String> itr = query.iterate();

			if (itr.hasNext()) {
				String result = itr.next();

				if (result != null) {
					return result;
				}
			}

			return Boolean.FALSE.toString();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public String callErrorImport(String cf) {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), CALL_ERROR_IMPORT);

			sql = StringUtil.replace(sql, "[$NAME_FUNCTION$]",
				IntranetMefSiapDbConfigurationValues.FUNCTION_DB_SIAP_ORACLE_LOAD_ERROR_IMPORT);

			SQLQuery query  = session.createSQLQuery(sql);
			query.setCacheable(false);

			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(cf);

			Iterator<String> itr = query.iterate();

			if (itr.hasNext()) {
				String result = itr.next();

				if (result != null) {
					return result;
				}
			}

			return Boolean.FALSE.toString();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}
