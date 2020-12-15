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

package external.bfc.intranet.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import external.bfc.intranet.mef.exception.NoSuchSediBfcException;
import external.bfc.intranet.mef.model.SediBfc;
import external.bfc.intranet.mef.model.impl.SediBfcImpl;
import external.bfc.intranet.mef.model.impl.SediBfcModelImpl;
import external.bfc.intranet.mef.service.persistence.SediBfcPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sedi bfc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcPersistence
 * @see external.bfc.intranet.mef.service.persistence.SediBfcUtil
 * @generated
 */
@ProviderType
public class SediBfcPersistenceImpl extends BasePersistenceImpl<SediBfc>
	implements SediBfcPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SediBfcUtil} to access the sedi bfc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SediBfcImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, SediBfcImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, SediBfcImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP =
		new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, SediBfcImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdOrgLiv2AndFlagApp",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP =
		new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, SediBfcImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdOrgLiv2AndFlagApp",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SediBfcModelImpl.ID_ORG_LIV2_COLUMN_BITMASK |
			SediBfcModelImpl.FLAG_APP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDORGLIV2ANDFLAGAPP = new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdOrgLiv2AndFlagApp",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @return the matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app) {
		return findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @return the range of matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end) {
		return findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP;
			finderArgs = new Object[] { id_org_liv2, flag_app };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP;
			finderArgs = new Object[] {
					id_org_liv2, flag_app,
					
					start, end, orderByComparator
				};
		}

		List<SediBfc> list = null;

		if (retrieveFromCache) {
			list = (List<SediBfc>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (SediBfc sediBfc : list) {
					if ((id_org_liv2 != sediBfc.getId_org_liv2()) ||
							(flag_app != sediBfc.getFlag_app())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SEDIBFC_WHERE);

			query.append(_FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_ID_ORG_LIV2_2);

			query.append(_FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_FLAG_APP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SediBfcModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_org_liv2);

				qPos.add(flag_app);

				if (!pagination) {
					list = (List<SediBfc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SediBfc>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi bfc
	 * @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc findByIdOrgLiv2AndFlagApp_First(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = fetchByIdOrgLiv2AndFlagApp_First(id_org_liv2,
				flag_app, orderByComparator);

		if (sediBfc != null) {
			return sediBfc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_org_liv2=");
		msg.append(id_org_liv2);

		msg.append(", flag_app=");
		msg.append(flag_app);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediBfcException(msg.toString());
	}

	/**
	 * Returns the first sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc fetchByIdOrgLiv2AndFlagApp_First(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		List<SediBfc> list = findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi bfc
	 * @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc findByIdOrgLiv2AndFlagApp_Last(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = fetchByIdOrgLiv2AndFlagApp_Last(id_org_liv2,
				flag_app, orderByComparator);

		if (sediBfc != null) {
			return sediBfc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_org_liv2=");
		msg.append(id_org_liv2);

		msg.append(", flag_app=");
		msg.append(flag_app);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediBfcException(msg.toString());
	}

	/**
	 * Returns the last sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc fetchByIdOrgLiv2AndFlagApp_Last(long id_org_liv2,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		int count = countByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);

		if (count == 0) {
			return null;
		}

		List<SediBfc> list = findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sedi bfcs before and after the current sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id the primary key of the current sedi bfc
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sedi bfc
	 * @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc[] findByIdOrgLiv2AndFlagApp_PrevAndNext(long id,
		long id_org_liv2, boolean flag_app,
		OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SediBfc[] array = new SediBfcImpl[3];

			array[0] = getByIdOrgLiv2AndFlagApp_PrevAndNext(session, sediBfc,
					id_org_liv2, flag_app, orderByComparator, true);

			array[1] = sediBfc;

			array[2] = getByIdOrgLiv2AndFlagApp_PrevAndNext(session, sediBfc,
					id_org_liv2, flag_app, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SediBfc getByIdOrgLiv2AndFlagApp_PrevAndNext(Session session,
		SediBfc sediBfc, long id_org_liv2, boolean flag_app,
		OrderByComparator<SediBfc> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SEDIBFC_WHERE);

		query.append(_FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_ID_ORG_LIV2_2);

		query.append(_FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_FLAG_APP_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SediBfcModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_org_liv2);

		qPos.add(flag_app);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sediBfc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SediBfc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63; from the database.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 */
	@Override
	public void removeByIdOrgLiv2AndFlagApp(long id_org_liv2, boolean flag_app) {
		for (SediBfc sediBfc : findByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sediBfc);
		}
	}

	/**
	 * Returns the number of sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv2 the id_org_liv2
	 * @param flag_app the flag_app
	 * @return the number of matching sedi bfcs
	 */
	@Override
	public int countByIdOrgLiv2AndFlagApp(long id_org_liv2, boolean flag_app) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDORGLIV2ANDFLAGAPP;

		Object[] finderArgs = new Object[] { id_org_liv2, flag_app };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEDIBFC_WHERE);

			query.append(_FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_ID_ORG_LIV2_2);

			query.append(_FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_FLAG_APP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_org_liv2);

				qPos.add(flag_app);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_ID_ORG_LIV2_2 =
		"sediBfc.id_org_liv2 = ? AND ";
	private static final String _FINDER_COLUMN_IDORGLIV2ANDFLAGAPP_FLAG_APP_2 = "sediBfc.flag_app = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP =
		new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, SediBfcImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdOrgLiv3AndFlagApp",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP =
		new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, SediBfcImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdOrgLiv3AndFlagApp",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SediBfcModelImpl.ID_ORG_LIV3_COLUMN_BITMASK |
			SediBfcModelImpl.FLAG_APP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDORGLIV3ANDFLAGAPP = new FinderPath(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdOrgLiv3AndFlagApp",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @return the matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app) {
		return findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @return the range of matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end) {
		return findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sedi bfcs
	 */
	@Override
	public List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end,
		OrderByComparator<SediBfc> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP;
			finderArgs = new Object[] { id_org_liv3, flag_app };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP;
			finderArgs = new Object[] {
					id_org_liv3, flag_app,
					
					start, end, orderByComparator
				};
		}

		List<SediBfc> list = null;

		if (retrieveFromCache) {
			list = (List<SediBfc>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (SediBfc sediBfc : list) {
					if ((id_org_liv3 != sediBfc.getId_org_liv3()) ||
							(flag_app != sediBfc.getFlag_app())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SEDIBFC_WHERE);

			query.append(_FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_ID_ORG_LIV3_2);

			query.append(_FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_FLAG_APP_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SediBfcModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_org_liv3);

				qPos.add(flag_app);

				if (!pagination) {
					list = (List<SediBfc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SediBfc>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi bfc
	 * @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc findByIdOrgLiv3AndFlagApp_First(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = fetchByIdOrgLiv3AndFlagApp_First(id_org_liv3,
				flag_app, orderByComparator);

		if (sediBfc != null) {
			return sediBfc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_org_liv3=");
		msg.append(id_org_liv3);

		msg.append(", flag_app=");
		msg.append(flag_app);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediBfcException(msg.toString());
	}

	/**
	 * Returns the first sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc fetchByIdOrgLiv3AndFlagApp_First(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		List<SediBfc> list = findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi bfc
	 * @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc findByIdOrgLiv3AndFlagApp_Last(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = fetchByIdOrgLiv3AndFlagApp_Last(id_org_liv3,
				flag_app, orderByComparator);

		if (sediBfc != null) {
			return sediBfc;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_org_liv3=");
		msg.append(id_org_liv3);

		msg.append(", flag_app=");
		msg.append(flag_app);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSediBfcException(msg.toString());
	}

	/**
	 * Returns the last sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	 */
	@Override
	public SediBfc fetchByIdOrgLiv3AndFlagApp_Last(long id_org_liv3,
		boolean flag_app, OrderByComparator<SediBfc> orderByComparator) {
		int count = countByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);

		if (count == 0) {
			return null;
		}

		List<SediBfc> list = findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sedi bfcs before and after the current sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id the primary key of the current sedi bfc
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sedi bfc
	 * @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc[] findByIdOrgLiv3AndFlagApp_PrevAndNext(long id,
		long id_org_liv3, boolean flag_app,
		OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SediBfc[] array = new SediBfcImpl[3];

			array[0] = getByIdOrgLiv3AndFlagApp_PrevAndNext(session, sediBfc,
					id_org_liv3, flag_app, orderByComparator, true);

			array[1] = sediBfc;

			array[2] = getByIdOrgLiv3AndFlagApp_PrevAndNext(session, sediBfc,
					id_org_liv3, flag_app, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SediBfc getByIdOrgLiv3AndFlagApp_PrevAndNext(Session session,
		SediBfc sediBfc, long id_org_liv3, boolean flag_app,
		OrderByComparator<SediBfc> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SEDIBFC_WHERE);

		query.append(_FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_ID_ORG_LIV3_2);

		query.append(_FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_FLAG_APP_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SediBfcModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_org_liv3);

		qPos.add(flag_app);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sediBfc);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SediBfc> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63; from the database.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 */
	@Override
	public void removeByIdOrgLiv3AndFlagApp(long id_org_liv3, boolean flag_app) {
		for (SediBfc sediBfc : findByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sediBfc);
		}
	}

	/**
	 * Returns the number of sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	 *
	 * @param id_org_liv3 the id_org_liv3
	 * @param flag_app the flag_app
	 * @return the number of matching sedi bfcs
	 */
	@Override
	public int countByIdOrgLiv3AndFlagApp(long id_org_liv3, boolean flag_app) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDORGLIV3ANDFLAGAPP;

		Object[] finderArgs = new Object[] { id_org_liv3, flag_app };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SEDIBFC_WHERE);

			query.append(_FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_ID_ORG_LIV3_2);

			query.append(_FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_FLAG_APP_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_org_liv3);

				qPos.add(flag_app);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_ID_ORG_LIV3_2 =
		"sediBfc.id_org_liv3 = ? AND ";
	private static final String _FINDER_COLUMN_IDORGLIV3ANDFLAGAPP_FLAG_APP_2 = "sediBfc.flag_app = ?";

	public SediBfcPersistenceImpl() {
		setModelClass(SediBfc.class);
	}

	/**
	 * Caches the sedi bfc in the entity cache if it is enabled.
	 *
	 * @param sediBfc the sedi bfc
	 */
	@Override
	public void cacheResult(SediBfc sediBfc) {
		entityCache.putResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcImpl.class, sediBfc.getPrimaryKey(), sediBfc);

		sediBfc.resetOriginalValues();
	}

	/**
	 * Caches the sedi bfcs in the entity cache if it is enabled.
	 *
	 * @param sediBfcs the sedi bfcs
	 */
	@Override
	public void cacheResult(List<SediBfc> sediBfcs) {
		for (SediBfc sediBfc : sediBfcs) {
			if (entityCache.getResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
						SediBfcImpl.class, sediBfc.getPrimaryKey()) == null) {
				cacheResult(sediBfc);
			}
			else {
				sediBfc.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sedi bfcs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SediBfcImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sedi bfc.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SediBfc sediBfc) {
		entityCache.removeResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcImpl.class, sediBfc.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SediBfc> sediBfcs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SediBfc sediBfc : sediBfcs) {
			entityCache.removeResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
				SediBfcImpl.class, sediBfc.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sedi bfc with the primary key. Does not add the sedi bfc to the database.
	 *
	 * @param id the primary key for the new sedi bfc
	 * @return the new sedi bfc
	 */
	@Override
	public SediBfc create(long id) {
		SediBfc sediBfc = new SediBfcImpl();

		sediBfc.setNew(true);
		sediBfc.setPrimaryKey(id);

		return sediBfc;
	}

	/**
	 * Removes the sedi bfc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sedi bfc
	 * @return the sedi bfc that was removed
	 * @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc remove(long id) throws NoSuchSediBfcException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the sedi bfc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sedi bfc
	 * @return the sedi bfc that was removed
	 * @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc remove(Serializable primaryKey)
		throws NoSuchSediBfcException {
		Session session = null;

		try {
			session = openSession();

			SediBfc sediBfc = (SediBfc)session.get(SediBfcImpl.class, primaryKey);

			if (sediBfc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSediBfcException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sediBfc);
		}
		catch (NoSuchSediBfcException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SediBfc removeImpl(SediBfc sediBfc) {
		sediBfc = toUnwrappedModel(sediBfc);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sediBfc)) {
				sediBfc = (SediBfc)session.get(SediBfcImpl.class,
						sediBfc.getPrimaryKeyObj());
			}

			if (sediBfc != null) {
				session.delete(sediBfc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sediBfc != null) {
			clearCache(sediBfc);
		}

		return sediBfc;
	}

	@Override
	public SediBfc updateImpl(SediBfc sediBfc) {
		sediBfc = toUnwrappedModel(sediBfc);

		boolean isNew = sediBfc.isNew();

		SediBfcModelImpl sediBfcModelImpl = (SediBfcModelImpl)sediBfc;

		Session session = null;

		try {
			session = openSession();

			if (sediBfc.isNew()) {
				session.save(sediBfc);

				sediBfc.setNew(false);
			}
			else {
				sediBfc = (SediBfc)session.merge(sediBfc);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SediBfcModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sediBfcModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sediBfcModelImpl.getOriginalId_org_liv2(),
						sediBfcModelImpl.getOriginalFlag_app()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDORGLIV2ANDFLAGAPP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP,
					args);

				args = new Object[] {
						sediBfcModelImpl.getId_org_liv2(),
						sediBfcModelImpl.getFlag_app()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDORGLIV2ANDFLAGAPP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV2ANDFLAGAPP,
					args);
			}

			if ((sediBfcModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sediBfcModelImpl.getOriginalId_org_liv3(),
						sediBfcModelImpl.getOriginalFlag_app()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDORGLIV3ANDFLAGAPP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP,
					args);

				args = new Object[] {
						sediBfcModelImpl.getId_org_liv3(),
						sediBfcModelImpl.getFlag_app()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDORGLIV3ANDFLAGAPP,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDORGLIV3ANDFLAGAPP,
					args);
			}
		}

		entityCache.putResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
			SediBfcImpl.class, sediBfc.getPrimaryKey(), sediBfc, false);

		sediBfc.resetOriginalValues();

		return sediBfc;
	}

	protected SediBfc toUnwrappedModel(SediBfc sediBfc) {
		if (sediBfc instanceof SediBfcImpl) {
			return sediBfc;
		}

		SediBfcImpl sediBfcImpl = new SediBfcImpl();

		sediBfcImpl.setNew(sediBfc.isNew());
		sediBfcImpl.setPrimaryKey(sediBfc.getPrimaryKey());

		sediBfcImpl.setId(sediBfc.getId());
		sediBfcImpl.setCodice_geco(sediBfc.getCodice_geco());
		sediBfcImpl.setId_sede_geco(sediBfc.getId_sede_geco());
		sediBfcImpl.setId_sede_siap(sediBfc.getId_sede_siap());
		sediBfcImpl.setId_org_liv2(sediBfc.getId_org_liv2());
		sediBfcImpl.setId_org_liv3(sediBfc.getId_org_liv3());
		sediBfcImpl.setNomeLoc(sediBfc.getNomeLoc());
		sediBfcImpl.setFlag_app(sediBfc.isFlag_app());

		return sediBfcImpl;
	}

	/**
	 * Returns the sedi bfc with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sedi bfc
	 * @return the sedi bfc
	 * @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSediBfcException {
		SediBfc sediBfc = fetchByPrimaryKey(primaryKey);

		if (sediBfc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSediBfcException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sediBfc;
	}

	/**
	 * Returns the sedi bfc with the primary key or throws a {@link NoSuchSediBfcException} if it could not be found.
	 *
	 * @param id the primary key of the sedi bfc
	 * @return the sedi bfc
	 * @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc findByPrimaryKey(long id) throws NoSuchSediBfcException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the sedi bfc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sedi bfc
	 * @return the sedi bfc, or <code>null</code> if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
				SediBfcImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SediBfc sediBfc = (SediBfc)serializable;

		if (sediBfc == null) {
			Session session = null;

			try {
				session = openSession();

				sediBfc = (SediBfc)session.get(SediBfcImpl.class, primaryKey);

				if (sediBfc != null) {
					cacheResult(sediBfc);
				}
				else {
					entityCache.putResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
						SediBfcImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
					SediBfcImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sediBfc;
	}

	/**
	 * Returns the sedi bfc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the sedi bfc
	 * @return the sedi bfc, or <code>null</code> if a sedi bfc with the primary key could not be found
	 */
	@Override
	public SediBfc fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, SediBfc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SediBfc> map = new HashMap<Serializable, SediBfc>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SediBfc sediBfc = fetchByPrimaryKey(primaryKey);

			if (sediBfc != null) {
				map.put(primaryKey, sediBfc);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
					SediBfcImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SediBfc)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SEDIBFC_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (SediBfc sediBfc : (List<SediBfc>)q.list()) {
				map.put(sediBfc.getPrimaryKeyObj(), sediBfc);

				cacheResult(sediBfc);

				uncachedPrimaryKeys.remove(sediBfc.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SediBfcModelImpl.ENTITY_CACHE_ENABLED,
					SediBfcImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the sedi bfcs.
	 *
	 * @return the sedi bfcs
	 */
	@Override
	public List<SediBfc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sedi bfcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @return the range of sedi bfcs
	 */
	@Override
	public List<SediBfc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sedi bfcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sedi bfcs
	 */
	@Override
	public List<SediBfc> findAll(int start, int end,
		OrderByComparator<SediBfc> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sedi bfcs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedi bfcs
	 * @param end the upper bound of the range of sedi bfcs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sedi bfcs
	 */
	@Override
	public List<SediBfc> findAll(int start, int end,
		OrderByComparator<SediBfc> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SediBfc> list = null;

		if (retrieveFromCache) {
			list = (List<SediBfc>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SEDIBFC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEDIBFC;

				if (pagination) {
					sql = sql.concat(SediBfcModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SediBfc>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SediBfc>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sedi bfcs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SediBfc sediBfc : findAll()) {
			remove(sediBfc);
		}
	}

	/**
	 * Returns the number of sedi bfcs.
	 *
	 * @return the number of sedi bfcs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SEDIBFC);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SediBfcModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sedi bfc persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SediBfcImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SEDIBFC = "SELECT sediBfc FROM SediBfc sediBfc";
	private static final String _SQL_SELECT_SEDIBFC_WHERE_PKS_IN = "SELECT sediBfc FROM SediBfc sediBfc WHERE ID IN (";
	private static final String _SQL_SELECT_SEDIBFC_WHERE = "SELECT sediBfc FROM SediBfc sediBfc WHERE ";
	private static final String _SQL_COUNT_SEDIBFC = "SELECT COUNT(sediBfc) FROM SediBfc sediBfc";
	private static final String _SQL_COUNT_SEDIBFC_WHERE = "SELECT COUNT(sediBfc) FROM SediBfc sediBfc WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sediBfc.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SediBfc exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SediBfc exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SediBfcPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "codice_geco", "id_sede_geco", "id_sede_siap",
				"id_org_liv2", "id_org_liv3", "nomeLoc", "flag_app"
			});
}