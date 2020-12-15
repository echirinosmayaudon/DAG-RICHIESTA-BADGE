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

package servizio.local.bfc.service.persistence.impl;

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

import servizio.local.bfc.exception.NoSuchLocalRichInfoException;
import servizio.local.bfc.model.LocalRichInfo;
import servizio.local.bfc.model.impl.LocalRichInfoImpl;
import servizio.local.bfc.model.impl.LocalRichInfoModelImpl;
import servizio.local.bfc.service.persistence.LocalRichInfoPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the local rich info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichInfoPersistence
 * @see servizio.local.bfc.service.persistence.LocalRichInfoUtil
 * @generated
 */
@ProviderType
public class LocalRichInfoPersistenceImpl extends BasePersistenceImpl<LocalRichInfo>
	implements LocalRichInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LocalRichInfoUtil} to access the local rich info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LocalRichInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED,
			LocalRichInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED,
			LocalRichInfoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREQBFCINFO =
		new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED,
			LocalRichInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByemailReqBfcInfo",
			new String[] {
				Boolean.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFCINFO =
		new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED,
			LocalRichInfoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByemailReqBfcInfo",
			new String[] { Boolean.class.getName(), String.class.getName() },
			LocalRichInfoModelImpl.INSTAGE_COLUMN_BITMASK |
			LocalRichInfoModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILREQBFCINFO = new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByemailReqBfcInfo",
			new String[] { Boolean.class.getName(), String.class.getName() });

	/**
	 * Returns all the local rich infos where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @return the matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		String email) {
		return findByemailReqBfcInfo(inStage, email, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local rich infos where inStage = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @return the range of matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		String email, int start, int end) {
		return findByemailReqBfcInfo(inStage, email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the local rich infos where inStage = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		String email, int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return findByemailReqBfcInfo(inStage, email, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the local rich infos where inStage = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByemailReqBfcInfo(boolean inStage,
		String email, int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFCINFO;
			finderArgs = new Object[] { inStage, email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREQBFCINFO;
			finderArgs = new Object[] {
					inStage, email,
					
					start, end, orderByComparator
				};
		}

		List<LocalRichInfo> list = null;

		if (retrieveFromCache) {
			list = (List<LocalRichInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LocalRichInfo localRichInfo : list) {
					if ((inStage != localRichInfo.getInStage()) ||
							!Objects.equals(email, localRichInfo.getEmail())) {
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

			query.append(_SQL_SELECT_LOCALRICHINFO_WHERE);

			query.append(_FINDER_COLUMN_EMAILREQBFCINFO_INSTAGE_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocalRichInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(inStage);

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<LocalRichInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalRichInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first local rich info in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich info
	 * @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo findByemailReqBfcInfo_First(boolean inStage,
		String email, OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = fetchByemailReqBfcInfo_First(inStage,
				email, orderByComparator);

		if (localRichInfo != null) {
			return localRichInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("inStage=");
		msg.append(inStage);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichInfoException(msg.toString());
	}

	/**
	 * Returns the first local rich info in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich info, or <code>null</code> if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo fetchByemailReqBfcInfo_First(boolean inStage,
		String email, OrderByComparator<LocalRichInfo> orderByComparator) {
		List<LocalRichInfo> list = findByemailReqBfcInfo(inStage, email, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last local rich info in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich info
	 * @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo findByemailReqBfcInfo_Last(boolean inStage,
		String email, OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = fetchByemailReqBfcInfo_Last(inStage,
				email, orderByComparator);

		if (localRichInfo != null) {
			return localRichInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("inStage=");
		msg.append(inStage);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichInfoException(msg.toString());
	}

	/**
	 * Returns the last local rich info in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich info, or <code>null</code> if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo fetchByemailReqBfcInfo_Last(boolean inStage,
		String email, OrderByComparator<LocalRichInfo> orderByComparator) {
		int count = countByemailReqBfcInfo(inStage, email);

		if (count == 0) {
			return null;
		}

		List<LocalRichInfo> list = findByemailReqBfcInfo(inStage, email,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the local rich infos before and after the current local rich info in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param id the primary key of the current local rich info
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next local rich info
	 * @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo[] findByemailReqBfcInfo_PrevAndNext(long id,
		boolean inStage, String email,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LocalRichInfo[] array = new LocalRichInfoImpl[3];

			array[0] = getByemailReqBfcInfo_PrevAndNext(session, localRichInfo,
					inStage, email, orderByComparator, true);

			array[1] = localRichInfo;

			array[2] = getByemailReqBfcInfo_PrevAndNext(session, localRichInfo,
					inStage, email, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LocalRichInfo getByemailReqBfcInfo_PrevAndNext(Session session,
		LocalRichInfo localRichInfo, boolean inStage, String email,
		OrderByComparator<LocalRichInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOCALRICHINFO_WHERE);

		query.append(_FINDER_COLUMN_EMAILREQBFCINFO_INSTAGE_2);

		boolean bindEmail = false;

		if (email == null) {
			query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_1);
		}
		else if (email.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_2);
		}

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
			query.append(LocalRichInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(inStage);

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(localRichInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocalRichInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the local rich infos where inStage = &#63; and email = &#63; from the database.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 */
	@Override
	public void removeByemailReqBfcInfo(boolean inStage, String email) {
		for (LocalRichInfo localRichInfo : findByemailReqBfcInfo(inStage,
				email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(localRichInfo);
		}
	}

	/**
	 * Returns the number of local rich infos where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @return the number of matching local rich infos
	 */
	@Override
	public int countByemailReqBfcInfo(boolean inStage, String email) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILREQBFCINFO;

		Object[] finderArgs = new Object[] { inStage, email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOCALRICHINFO_WHERE);

			query.append(_FINDER_COLUMN_EMAILREQBFCINFO_INSTAGE_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(inStage);

				if (bindEmail) {
					qPos.add(email);
				}

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

	private static final String _FINDER_COLUMN_EMAILREQBFCINFO_INSTAGE_2 = "localRichInfo.inStage = ? AND ";
	private static final String _FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_1 = "localRichInfo.email IS NULL";
	private static final String _FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_2 = "localRichInfo.email = ?";
	private static final String _FINDER_COLUMN_EMAILREQBFCINFO_EMAIL_3 = "(localRichInfo.email IS NULL OR localRichInfo.email = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED,
			LocalRichInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdRichiesta",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED,
			LocalRichInfoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdRichiesta", new String[] { Long.class.getName() },
			LocalRichInfoModelImpl.ID_RICHIESTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDRICHIESTA = new FinderPath(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdRichiesta",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the local rich infos where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @return the matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByIdRichiesta(long id_richiesta) {
		return findByIdRichiesta(id_richiesta, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local rich infos where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @return the range of matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByIdRichiesta(long id_richiesta, int start,
		int end) {
		return findByIdRichiesta(id_richiesta, start, end, null);
	}

	/**
	 * Returns an ordered range of all the local rich infos where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByIdRichiesta(long id_richiesta, int start,
		int end, OrderByComparator<LocalRichInfo> orderByComparator) {
		return findByIdRichiesta(id_richiesta, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the local rich infos where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching local rich infos
	 */
	@Override
	public List<LocalRichInfo> findByIdRichiesta(long id_richiesta, int start,
		int end, OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] { id_richiesta };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] {
					id_richiesta,
					
					start, end, orderByComparator
				};
		}

		List<LocalRichInfo> list = null;

		if (retrieveFromCache) {
			list = (List<LocalRichInfo>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LocalRichInfo localRichInfo : list) {
					if ((id_richiesta != localRichInfo.getId_richiesta())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOCALRICHINFO_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocalRichInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

				if (!pagination) {
					list = (List<LocalRichInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalRichInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first local rich info in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich info
	 * @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = fetchByIdRichiesta_First(id_richiesta,
				orderByComparator);

		if (localRichInfo != null) {
			return localRichInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichInfoException(msg.toString());
	}

	/**
	 * Returns the first local rich info in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich info, or <code>null</code> if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo fetchByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		List<LocalRichInfo> list = findByIdRichiesta(id_richiesta, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last local rich info in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich info
	 * @throws NoSuchLocalRichInfoException if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = fetchByIdRichiesta_Last(id_richiesta,
				orderByComparator);

		if (localRichInfo != null) {
			return localRichInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichInfoException(msg.toString());
	}

	/**
	 * Returns the last local rich info in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich info, or <code>null</code> if a matching local rich info could not be found
	 */
	@Override
	public LocalRichInfo fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		int count = countByIdRichiesta(id_richiesta);

		if (count == 0) {
			return null;
		}

		List<LocalRichInfo> list = findByIdRichiesta(id_richiesta, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the local rich infos before and after the current local rich info in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id the primary key of the current local rich info
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next local rich info
	 * @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta, OrderByComparator<LocalRichInfo> orderByComparator)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LocalRichInfo[] array = new LocalRichInfoImpl[3];

			array[0] = getByIdRichiesta_PrevAndNext(session, localRichInfo,
					id_richiesta, orderByComparator, true);

			array[1] = localRichInfo;

			array[2] = getByIdRichiesta_PrevAndNext(session, localRichInfo,
					id_richiesta, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LocalRichInfo getByIdRichiesta_PrevAndNext(Session session,
		LocalRichInfo localRichInfo, long id_richiesta,
		OrderByComparator<LocalRichInfo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCALRICHINFO_WHERE);

		query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

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
			query.append(LocalRichInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_richiesta);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(localRichInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocalRichInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the local rich infos where id_richiesta = &#63; from the database.
	 *
	 * @param id_richiesta the id_richiesta
	 */
	@Override
	public void removeByIdRichiesta(long id_richiesta) {
		for (LocalRichInfo localRichInfo : findByIdRichiesta(id_richiesta,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(localRichInfo);
		}
	}

	/**
	 * Returns the number of local rich infos where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @return the number of matching local rich infos
	 */
	@Override
	public int countByIdRichiesta(long id_richiesta) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDRICHIESTA;

		Object[] finderArgs = new Object[] { id_richiesta };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCALRICHINFO_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

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

	private static final String _FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2 = "localRichInfo.id_richiesta = ?";

	public LocalRichInfoPersistenceImpl() {
		setModelClass(LocalRichInfo.class);
	}

	/**
	 * Caches the local rich info in the entity cache if it is enabled.
	 *
	 * @param localRichInfo the local rich info
	 */
	@Override
	public void cacheResult(LocalRichInfo localRichInfo) {
		entityCache.putResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoImpl.class, localRichInfo.getPrimaryKey(),
			localRichInfo);

		localRichInfo.resetOriginalValues();
	}

	/**
	 * Caches the local rich infos in the entity cache if it is enabled.
	 *
	 * @param localRichInfos the local rich infos
	 */
	@Override
	public void cacheResult(List<LocalRichInfo> localRichInfos) {
		for (LocalRichInfo localRichInfo : localRichInfos) {
			if (entityCache.getResult(
						LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
						LocalRichInfoImpl.class, localRichInfo.getPrimaryKey()) == null) {
				cacheResult(localRichInfo);
			}
			else {
				localRichInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all local rich infos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LocalRichInfoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the local rich info.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LocalRichInfo localRichInfo) {
		entityCache.removeResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoImpl.class, localRichInfo.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LocalRichInfo> localRichInfos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LocalRichInfo localRichInfo : localRichInfos) {
			entityCache.removeResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
				LocalRichInfoImpl.class, localRichInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new local rich info with the primary key. Does not add the local rich info to the database.
	 *
	 * @param id the primary key for the new local rich info
	 * @return the new local rich info
	 */
	@Override
	public LocalRichInfo create(long id) {
		LocalRichInfo localRichInfo = new LocalRichInfoImpl();

		localRichInfo.setNew(true);
		localRichInfo.setPrimaryKey(id);

		return localRichInfo;
	}

	/**
	 * Removes the local rich info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the local rich info
	 * @return the local rich info that was removed
	 * @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo remove(long id) throws NoSuchLocalRichInfoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the local rich info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the local rich info
	 * @return the local rich info that was removed
	 * @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo remove(Serializable primaryKey)
		throws NoSuchLocalRichInfoException {
		Session session = null;

		try {
			session = openSession();

			LocalRichInfo localRichInfo = (LocalRichInfo)session.get(LocalRichInfoImpl.class,
					primaryKey);

			if (localRichInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocalRichInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(localRichInfo);
		}
		catch (NoSuchLocalRichInfoException nsee) {
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
	protected LocalRichInfo removeImpl(LocalRichInfo localRichInfo) {
		localRichInfo = toUnwrappedModel(localRichInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(localRichInfo)) {
				localRichInfo = (LocalRichInfo)session.get(LocalRichInfoImpl.class,
						localRichInfo.getPrimaryKeyObj());
			}

			if (localRichInfo != null) {
				session.delete(localRichInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (localRichInfo != null) {
			clearCache(localRichInfo);
		}

		return localRichInfo;
	}

	@Override
	public LocalRichInfo updateImpl(LocalRichInfo localRichInfo) {
		localRichInfo = toUnwrappedModel(localRichInfo);

		boolean isNew = localRichInfo.isNew();

		LocalRichInfoModelImpl localRichInfoModelImpl = (LocalRichInfoModelImpl)localRichInfo;

		Session session = null;

		try {
			session = openSession();

			if (localRichInfo.isNew()) {
				session.save(localRichInfo);

				localRichInfo.setNew(false);
			}
			else {
				localRichInfo = (LocalRichInfo)session.merge(localRichInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LocalRichInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((localRichInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFCINFO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						localRichInfoModelImpl.getOriginalInStage(),
						localRichInfoModelImpl.getOriginalEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILREQBFCINFO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFCINFO,
					args);

				args = new Object[] {
						localRichInfoModelImpl.getInStage(),
						localRichInfoModelImpl.getEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILREQBFCINFO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFCINFO,
					args);
			}

			if ((localRichInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						localRichInfoModelImpl.getOriginalId_richiesta()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);

				args = new Object[] { localRichInfoModelImpl.getId_richiesta() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);
			}
		}

		entityCache.putResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichInfoImpl.class, localRichInfo.getPrimaryKey(),
			localRichInfo, false);

		localRichInfo.resetOriginalValues();

		return localRichInfo;
	}

	protected LocalRichInfo toUnwrappedModel(LocalRichInfo localRichInfo) {
		if (localRichInfo instanceof LocalRichInfoImpl) {
			return localRichInfo;
		}

		LocalRichInfoImpl localRichInfoImpl = new LocalRichInfoImpl();

		localRichInfoImpl.setNew(localRichInfo.isNew());
		localRichInfoImpl.setPrimaryKey(localRichInfo.getPrimaryKey());

		localRichInfoImpl.setIdStatoAttuale(localRichInfo.getIdStatoAttuale());
		localRichInfoImpl.setId(localRichInfo.getId());
		localRichInfoImpl.setId_richiesta(localRichInfo.getId_richiesta());
		localRichInfoImpl.setDataRichiesta(localRichInfo.getDataRichiesta());
		localRichInfoImpl.setEmail(localRichInfo.getEmail());
		localRichInfoImpl.setRifStanza(localRichInfo.getRifStanza());
		localRichInfoImpl.setIspettorato(localRichInfo.getIspettorato());
		localRichInfoImpl.setNomeRef(localRichInfo.getNomeRef());
		localRichInfoImpl.setTelRef(localRichInfo.getTelRef());
		localRichInfoImpl.setNMacchina(localRichInfo.getNMacchina());
		localRichInfoImpl.setNoteRich(localRichInfo.getNoteRich());
		localRichInfoImpl.setUfficio(localRichInfo.getUfficio());
		localRichInfoImpl.setNote(localRichInfo.getNote());
		localRichInfoImpl.setUidIns(localRichInfo.getUidIns());
		localRichInfoImpl.setDataIns(localRichInfo.getDataIns());
		localRichInfoImpl.setUidUpd(localRichInfo.getUidUpd());
		localRichInfoImpl.setDataUpd(localRichInfo.getDataUpd());
		localRichInfoImpl.setOggetto(localRichInfo.getOggetto());
		localRichInfoImpl.setIdSede(localRichInfo.getIdSede());
		localRichInfoImpl.setTelRich(localRichInfo.getTelRich());
		localRichInfoImpl.setStrutUff(localRichInfo.getStrutUff());
		localRichInfoImpl.setStrutIsp(localRichInfo.getStrutIsp());
		localRichInfoImpl.setCostoReale(localRichInfo.getCostoReale());
		localRichInfoImpl.setPreventivo(localRichInfo.getPreventivo());
		localRichInfoImpl.setFlagInvio(localRichInfo.getFlagInvio());
		localRichInfoImpl.setInStage(localRichInfo.isInStage());

		return localRichInfoImpl;
	}

	/**
	 * Returns the local rich info with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the local rich info
	 * @return the local rich info
	 * @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocalRichInfoException {
		LocalRichInfo localRichInfo = fetchByPrimaryKey(primaryKey);

		if (localRichInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocalRichInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return localRichInfo;
	}

	/**
	 * Returns the local rich info with the primary key or throws a {@link NoSuchLocalRichInfoException} if it could not be found.
	 *
	 * @param id the primary key of the local rich info
	 * @return the local rich info
	 * @throws NoSuchLocalRichInfoException if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo findByPrimaryKey(long id)
		throws NoSuchLocalRichInfoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the local rich info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the local rich info
	 * @return the local rich info, or <code>null</code> if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
				LocalRichInfoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LocalRichInfo localRichInfo = (LocalRichInfo)serializable;

		if (localRichInfo == null) {
			Session session = null;

			try {
				session = openSession();

				localRichInfo = (LocalRichInfo)session.get(LocalRichInfoImpl.class,
						primaryKey);

				if (localRichInfo != null) {
					cacheResult(localRichInfo);
				}
				else {
					entityCache.putResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
						LocalRichInfoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
					LocalRichInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return localRichInfo;
	}

	/**
	 * Returns the local rich info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the local rich info
	 * @return the local rich info, or <code>null</code> if a local rich info with the primary key could not be found
	 */
	@Override
	public LocalRichInfo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LocalRichInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LocalRichInfo> map = new HashMap<Serializable, LocalRichInfo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LocalRichInfo localRichInfo = fetchByPrimaryKey(primaryKey);

			if (localRichInfo != null) {
				map.put(primaryKey, localRichInfo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
					LocalRichInfoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LocalRichInfo)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOCALRICHINFO_WHERE_PKS_IN);

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

			for (LocalRichInfo localRichInfo : (List<LocalRichInfo>)q.list()) {
				map.put(localRichInfo.getPrimaryKeyObj(), localRichInfo);

				cacheResult(localRichInfo);

				uncachedPrimaryKeys.remove(localRichInfo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LocalRichInfoModelImpl.ENTITY_CACHE_ENABLED,
					LocalRichInfoImpl.class, primaryKey, nullModel);
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
	 * Returns all the local rich infos.
	 *
	 * @return the local rich infos
	 */
	@Override
	public List<LocalRichInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local rich infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @return the range of local rich infos
	 */
	@Override
	public List<LocalRichInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the local rich infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of local rich infos
	 */
	@Override
	public List<LocalRichInfo> findAll(int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the local rich infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local rich infos
	 * @param end the upper bound of the range of local rich infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of local rich infos
	 */
	@Override
	public List<LocalRichInfo> findAll(int start, int end,
		OrderByComparator<LocalRichInfo> orderByComparator,
		boolean retrieveFromCache) {
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

		List<LocalRichInfo> list = null;

		if (retrieveFromCache) {
			list = (List<LocalRichInfo>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOCALRICHINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOCALRICHINFO;

				if (pagination) {
					sql = sql.concat(LocalRichInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LocalRichInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalRichInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the local rich infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LocalRichInfo localRichInfo : findAll()) {
			remove(localRichInfo);
		}
	}

	/**
	 * Returns the number of local rich infos.
	 *
	 * @return the number of local rich infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOCALRICHINFO);

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
		return LocalRichInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the local rich info persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LocalRichInfoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOCALRICHINFO = "SELECT localRichInfo FROM LocalRichInfo localRichInfo";
	private static final String _SQL_SELECT_LOCALRICHINFO_WHERE_PKS_IN = "SELECT localRichInfo FROM LocalRichInfo localRichInfo WHERE id_ IN (";
	private static final String _SQL_SELECT_LOCALRICHINFO_WHERE = "SELECT localRichInfo FROM LocalRichInfo localRichInfo WHERE ";
	private static final String _SQL_COUNT_LOCALRICHINFO = "SELECT COUNT(localRichInfo) FROM LocalRichInfo localRichInfo";
	private static final String _SQL_COUNT_LOCALRICHINFO_WHERE = "SELECT COUNT(localRichInfo) FROM LocalRichInfo localRichInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "localRichInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LocalRichInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LocalRichInfo exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LocalRichInfoPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}