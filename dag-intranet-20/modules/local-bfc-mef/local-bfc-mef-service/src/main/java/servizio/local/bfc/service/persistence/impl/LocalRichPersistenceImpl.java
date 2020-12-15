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

import servizio.local.bfc.exception.NoSuchLocalRichException;
import servizio.local.bfc.model.LocalRich;
import servizio.local.bfc.model.impl.LocalRichImpl;
import servizio.local.bfc.model.impl.LocalRichModelImpl;
import servizio.local.bfc.service.persistence.LocalRichPersistence;

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
 * The persistence implementation for the local rich service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichPersistence
 * @see servizio.local.bfc.service.persistence.LocalRichUtil
 * @generated
 */
@ProviderType
public class LocalRichPersistenceImpl extends BasePersistenceImpl<LocalRich>
	implements LocalRichPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LocalRichUtil} to access the local rich persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LocalRichImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, LocalRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, LocalRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREQBFC =
		new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, LocalRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemailReqBfc",
			new String[] {
				Boolean.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC =
		new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, LocalRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemailReqBfc",
			new String[] { Boolean.class.getName(), String.class.getName() },
			LocalRichModelImpl.INSTAGE_COLUMN_BITMASK |
			LocalRichModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILREQBFC = new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailReqBfc",
			new String[] { Boolean.class.getName(), String.class.getName() });

	/**
	 * Returns all the local richs where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @return the matching local richs
	 */
	@Override
	public List<LocalRich> findByemailReqBfc(boolean inStage, String email) {
		return findByemailReqBfc(inStage, email, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local richs where inStage = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @return the range of matching local richs
	 */
	@Override
	public List<LocalRich> findByemailReqBfc(boolean inStage, String email,
		int start, int end) {
		return findByemailReqBfc(inStage, email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the local richs where inStage = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching local richs
	 */
	@Override
	public List<LocalRich> findByemailReqBfc(boolean inStage, String email,
		int start, int end, OrderByComparator<LocalRich> orderByComparator) {
		return findByemailReqBfc(inStage, email, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the local richs where inStage = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching local richs
	 */
	@Override
	public List<LocalRich> findByemailReqBfc(boolean inStage, String email,
		int start, int end, OrderByComparator<LocalRich> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC;
			finderArgs = new Object[] { inStage, email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREQBFC;
			finderArgs = new Object[] {
					inStage, email,
					
					start, end, orderByComparator
				};
		}

		List<LocalRich> list = null;

		if (retrieveFromCache) {
			list = (List<LocalRich>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LocalRich localRich : list) {
					if ((inStage != localRich.getInStage()) ||
							!Objects.equals(email, localRich.getEmail())) {
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

			query.append(_SQL_SELECT_LOCALRICH_WHERE);

			query.append(_FINDER_COLUMN_EMAILREQBFC_INSTAGE_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocalRichModelImpl.ORDER_BY_JPQL);
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
					list = (List<LocalRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalRich>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first local rich in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich
	 * @throws NoSuchLocalRichException if a matching local rich could not be found
	 */
	@Override
	public LocalRich findByemailReqBfc_First(boolean inStage, String email,
		OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException {
		LocalRich localRich = fetchByemailReqBfc_First(inStage, email,
				orderByComparator);

		if (localRich != null) {
			return localRich;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("inStage=");
		msg.append(inStage);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichException(msg.toString());
	}

	/**
	 * Returns the first local rich in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich, or <code>null</code> if a matching local rich could not be found
	 */
	@Override
	public LocalRich fetchByemailReqBfc_First(boolean inStage, String email,
		OrderByComparator<LocalRich> orderByComparator) {
		List<LocalRich> list = findByemailReqBfc(inStage, email, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last local rich in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich
	 * @throws NoSuchLocalRichException if a matching local rich could not be found
	 */
	@Override
	public LocalRich findByemailReqBfc_Last(boolean inStage, String email,
		OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException {
		LocalRich localRich = fetchByemailReqBfc_Last(inStage, email,
				orderByComparator);

		if (localRich != null) {
			return localRich;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("inStage=");
		msg.append(inStage);

		msg.append(", email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichException(msg.toString());
	}

	/**
	 * Returns the last local rich in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich, or <code>null</code> if a matching local rich could not be found
	 */
	@Override
	public LocalRich fetchByemailReqBfc_Last(boolean inStage, String email,
		OrderByComparator<LocalRich> orderByComparator) {
		int count = countByemailReqBfc(inStage, email);

		if (count == 0) {
			return null;
		}

		List<LocalRich> list = findByemailReqBfc(inStage, email, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the local richs before and after the current local rich in the ordered set where inStage = &#63; and email = &#63;.
	 *
	 * @param id the primary key of the current local rich
	 * @param inStage the in stage
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next local rich
	 * @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich[] findByemailReqBfc_PrevAndNext(long id, boolean inStage,
		String email, OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException {
		LocalRich localRich = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LocalRich[] array = new LocalRichImpl[3];

			array[0] = getByemailReqBfc_PrevAndNext(session, localRich,
					inStage, email, orderByComparator, true);

			array[1] = localRich;

			array[2] = getByemailReqBfc_PrevAndNext(session, localRich,
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

	protected LocalRich getByemailReqBfc_PrevAndNext(Session session,
		LocalRich localRich, boolean inStage, String email,
		OrderByComparator<LocalRich> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LOCALRICH_WHERE);

		query.append(_FINDER_COLUMN_EMAILREQBFC_INSTAGE_2);

		boolean bindEmail = false;

		if (email == null) {
			query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_1);
		}
		else if (email.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_2);
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
			query.append(LocalRichModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(localRich);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocalRich> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the local richs where inStage = &#63; and email = &#63; from the database.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 */
	@Override
	public void removeByemailReqBfc(boolean inStage, String email) {
		for (LocalRich localRich : findByemailReqBfc(inStage, email,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(localRich);
		}
	}

	/**
	 * Returns the number of local richs where inStage = &#63; and email = &#63;.
	 *
	 * @param inStage the in stage
	 * @param email the email
	 * @return the number of matching local richs
	 */
	@Override
	public int countByemailReqBfc(boolean inStage, String email) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILREQBFC;

		Object[] finderArgs = new Object[] { inStage, email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOCALRICH_WHERE);

			query.append(_FINDER_COLUMN_EMAILREQBFC_INSTAGE_2);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAILREQBFC_EMAIL_2);
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

	private static final String _FINDER_COLUMN_EMAILREQBFC_INSTAGE_2 = "localRich.inStage = ? AND ";
	private static final String _FINDER_COLUMN_EMAILREQBFC_EMAIL_1 = "localRich.email IS NULL";
	private static final String _FINDER_COLUMN_EMAILREQBFC_EMAIL_2 = "localRich.email = ?";
	private static final String _FINDER_COLUMN_EMAILREQBFC_EMAIL_3 = "(localRich.email IS NULL OR localRich.email = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, LocalRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdRichiesta",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, LocalRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdRichiesta",
			new String[] { Long.class.getName() },
			LocalRichModelImpl.ID_RICHIESTA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDRICHIESTA = new FinderPath(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdRichiesta",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the local richs where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @return the matching local richs
	 */
	@Override
	public List<LocalRich> findByIdRichiesta(long id_richiesta) {
		return findByIdRichiesta(id_richiesta, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local richs where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @return the range of matching local richs
	 */
	@Override
	public List<LocalRich> findByIdRichiesta(long id_richiesta, int start,
		int end) {
		return findByIdRichiesta(id_richiesta, start, end, null);
	}

	/**
	 * Returns an ordered range of all the local richs where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching local richs
	 */
	@Override
	public List<LocalRich> findByIdRichiesta(long id_richiesta, int start,
		int end, OrderByComparator<LocalRich> orderByComparator) {
		return findByIdRichiesta(id_richiesta, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the local richs where id_richiesta = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_richiesta the id_richiesta
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching local richs
	 */
	@Override
	public List<LocalRich> findByIdRichiesta(long id_richiesta, int start,
		int end, OrderByComparator<LocalRich> orderByComparator,
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

		List<LocalRich> list = null;

		if (retrieveFromCache) {
			list = (List<LocalRich>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LocalRich localRich : list) {
					if ((id_richiesta != localRich.getId_richiesta())) {
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

			query.append(_SQL_SELECT_LOCALRICH_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LocalRichModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_richiesta);

				if (!pagination) {
					list = (List<LocalRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalRich>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first local rich in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich
	 * @throws NoSuchLocalRichException if a matching local rich could not be found
	 */
	@Override
	public LocalRich findByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException {
		LocalRich localRich = fetchByIdRichiesta_First(id_richiesta,
				orderByComparator);

		if (localRich != null) {
			return localRich;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichException(msg.toString());
	}

	/**
	 * Returns the first local rich in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching local rich, or <code>null</code> if a matching local rich could not be found
	 */
	@Override
	public LocalRich fetchByIdRichiesta_First(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator) {
		List<LocalRich> list = findByIdRichiesta(id_richiesta, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last local rich in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich
	 * @throws NoSuchLocalRichException if a matching local rich could not be found
	 */
	@Override
	public LocalRich findByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException {
		LocalRich localRich = fetchByIdRichiesta_Last(id_richiesta,
				orderByComparator);

		if (localRich != null) {
			return localRich;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_richiesta=");
		msg.append(id_richiesta);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLocalRichException(msg.toString());
	}

	/**
	 * Returns the last local rich in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching local rich, or <code>null</code> if a matching local rich could not be found
	 */
	@Override
	public LocalRich fetchByIdRichiesta_Last(long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator) {
		int count = countByIdRichiesta(id_richiesta);

		if (count == 0) {
			return null;
		}

		List<LocalRich> list = findByIdRichiesta(id_richiesta, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the local richs before and after the current local rich in the ordered set where id_richiesta = &#63;.
	 *
	 * @param id the primary key of the current local rich
	 * @param id_richiesta the id_richiesta
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next local rich
	 * @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich[] findByIdRichiesta_PrevAndNext(long id,
		long id_richiesta, OrderByComparator<LocalRich> orderByComparator)
		throws NoSuchLocalRichException {
		LocalRich localRich = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LocalRich[] array = new LocalRichImpl[3];

			array[0] = getByIdRichiesta_PrevAndNext(session, localRich,
					id_richiesta, orderByComparator, true);

			array[1] = localRich;

			array[2] = getByIdRichiesta_PrevAndNext(session, localRich,
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

	protected LocalRich getByIdRichiesta_PrevAndNext(Session session,
		LocalRich localRich, long id_richiesta,
		OrderByComparator<LocalRich> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOCALRICH_WHERE);

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
			query.append(LocalRichModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_richiesta);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(localRich);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LocalRich> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the local richs where id_richiesta = &#63; from the database.
	 *
	 * @param id_richiesta the id_richiesta
	 */
	@Override
	public void removeByIdRichiesta(long id_richiesta) {
		for (LocalRich localRich : findByIdRichiesta(id_richiesta,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(localRich);
		}
	}

	/**
	 * Returns the number of local richs where id_richiesta = &#63;.
	 *
	 * @param id_richiesta the id_richiesta
	 * @return the number of matching local richs
	 */
	@Override
	public int countByIdRichiesta(long id_richiesta) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDRICHIESTA;

		Object[] finderArgs = new Object[] { id_richiesta };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOCALRICH_WHERE);

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

	private static final String _FINDER_COLUMN_IDRICHIESTA_ID_RICHIESTA_2 = "localRich.id_richiesta = ?";

	public LocalRichPersistenceImpl() {
		setModelClass(LocalRich.class);
	}

	/**
	 * Caches the local rich in the entity cache if it is enabled.
	 *
	 * @param localRich the local rich
	 */
	@Override
	public void cacheResult(LocalRich localRich) {
		entityCache.putResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichImpl.class, localRich.getPrimaryKey(), localRich);

		localRich.resetOriginalValues();
	}

	/**
	 * Caches the local richs in the entity cache if it is enabled.
	 *
	 * @param localRichs the local richs
	 */
	@Override
	public void cacheResult(List<LocalRich> localRichs) {
		for (LocalRich localRich : localRichs) {
			if (entityCache.getResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
						LocalRichImpl.class, localRich.getPrimaryKey()) == null) {
				cacheResult(localRich);
			}
			else {
				localRich.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all local richs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LocalRichImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the local rich.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LocalRich localRich) {
		entityCache.removeResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichImpl.class, localRich.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LocalRich> localRichs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LocalRich localRich : localRichs) {
			entityCache.removeResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
				LocalRichImpl.class, localRich.getPrimaryKey());
		}
	}

	/**
	 * Creates a new local rich with the primary key. Does not add the local rich to the database.
	 *
	 * @param id the primary key for the new local rich
	 * @return the new local rich
	 */
	@Override
	public LocalRich create(long id) {
		LocalRich localRich = new LocalRichImpl();

		localRich.setNew(true);
		localRich.setPrimaryKey(id);

		return localRich;
	}

	/**
	 * Removes the local rich with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the local rich
	 * @return the local rich that was removed
	 * @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich remove(long id) throws NoSuchLocalRichException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the local rich with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the local rich
	 * @return the local rich that was removed
	 * @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich remove(Serializable primaryKey)
		throws NoSuchLocalRichException {
		Session session = null;

		try {
			session = openSession();

			LocalRich localRich = (LocalRich)session.get(LocalRichImpl.class,
					primaryKey);

			if (localRich == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLocalRichException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(localRich);
		}
		catch (NoSuchLocalRichException nsee) {
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
	protected LocalRich removeImpl(LocalRich localRich) {
		localRich = toUnwrappedModel(localRich);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(localRich)) {
				localRich = (LocalRich)session.get(LocalRichImpl.class,
						localRich.getPrimaryKeyObj());
			}

			if (localRich != null) {
				session.delete(localRich);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (localRich != null) {
			clearCache(localRich);
		}

		return localRich;
	}

	@Override
	public LocalRich updateImpl(LocalRich localRich) {
		localRich = toUnwrappedModel(localRich);

		boolean isNew = localRich.isNew();

		LocalRichModelImpl localRichModelImpl = (LocalRichModelImpl)localRich;

		Session session = null;

		try {
			session = openSession();

			if (localRich.isNew()) {
				session.save(localRich);

				localRich.setNew(false);
			}
			else {
				localRich = (LocalRich)session.merge(localRich);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LocalRichModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((localRichModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						localRichModelImpl.getOriginalInStage(),
						localRichModelImpl.getOriginalEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILREQBFC, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC,
					args);

				args = new Object[] {
						localRichModelImpl.getInStage(),
						localRichModelImpl.getEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILREQBFC, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC,
					args);
			}

			if ((localRichModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						localRichModelImpl.getOriginalId_richiesta()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);

				args = new Object[] { localRichModelImpl.getId_richiesta() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);
			}
		}

		entityCache.putResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
			LocalRichImpl.class, localRich.getPrimaryKey(), localRich, false);

		localRich.resetOriginalValues();

		return localRich;
	}

	protected LocalRich toUnwrappedModel(LocalRich localRich) {
		if (localRich instanceof LocalRichImpl) {
			return localRich;
		}

		LocalRichImpl localRichImpl = new LocalRichImpl();

		localRichImpl.setNew(localRich.isNew());
		localRichImpl.setPrimaryKey(localRich.getPrimaryKey());

		localRichImpl.setIdStatoAttuale(localRich.getIdStatoAttuale());
		localRichImpl.setId(localRich.getId());
		localRichImpl.setId_richiesta(localRich.getId_richiesta());
		localRichImpl.setDataRichiesta(localRich.getDataRichiesta());
		localRichImpl.setIdPeriodicita(localRich.getIdPeriodicita());
		localRichImpl.setEmail(localRich.getEmail());
		localRichImpl.setRifStanza(localRich.getRifStanza());
		localRichImpl.setIspettorato(localRich.getIspettorato());
		localRichImpl.setNoteRich(localRich.getNoteRich());
		localRichImpl.setUfficio(localRich.getUfficio());
		localRichImpl.setNote(localRich.getNote());
		localRichImpl.setUidIns(localRich.getUidIns());
		localRichImpl.setDataIns(localRich.getDataIns());
		localRichImpl.setUidUpd(localRich.getUidUpd());
		localRichImpl.setDataUpd(localRich.getDataUpd());
		localRichImpl.setOggetto(localRich.getOggetto());
		localRichImpl.setIdSede(localRich.getIdSede());
		localRichImpl.setStrutIsp(localRich.getStrutIsp());
		localRichImpl.setStrutUff(localRich.getStrutUff());
		localRichImpl.setStrutIsp2(localRich.getStrutIsp2());
		localRichImpl.setTelRich(localRich.getTelRich());
		localRichImpl.setCostoReale(localRich.getCostoReale());
		localRichImpl.setPreventivo(localRich.getPreventivo());
		localRichImpl.setFlagInvio(localRich.getFlagInvio());
		localRichImpl.setInStage(localRich.isInStage());

		return localRichImpl;
	}

	/**
	 * Returns the local rich with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the local rich
	 * @return the local rich
	 * @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLocalRichException {
		LocalRich localRich = fetchByPrimaryKey(primaryKey);

		if (localRich == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLocalRichException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return localRich;
	}

	/**
	 * Returns the local rich with the primary key or throws a {@link NoSuchLocalRichException} if it could not be found.
	 *
	 * @param id the primary key of the local rich
	 * @return the local rich
	 * @throws NoSuchLocalRichException if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich findByPrimaryKey(long id) throws NoSuchLocalRichException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the local rich with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the local rich
	 * @return the local rich, or <code>null</code> if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
				LocalRichImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LocalRich localRich = (LocalRich)serializable;

		if (localRich == null) {
			Session session = null;

			try {
				session = openSession();

				localRich = (LocalRich)session.get(LocalRichImpl.class,
						primaryKey);

				if (localRich != null) {
					cacheResult(localRich);
				}
				else {
					entityCache.putResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
						LocalRichImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
					LocalRichImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return localRich;
	}

	/**
	 * Returns the local rich with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the local rich
	 * @return the local rich, or <code>null</code> if a local rich with the primary key could not be found
	 */
	@Override
	public LocalRich fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LocalRich> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LocalRich> map = new HashMap<Serializable, LocalRich>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LocalRich localRich = fetchByPrimaryKey(primaryKey);

			if (localRich != null) {
				map.put(primaryKey, localRich);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
					LocalRichImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LocalRich)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LOCALRICH_WHERE_PKS_IN);

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

			for (LocalRich localRich : (List<LocalRich>)q.list()) {
				map.put(localRich.getPrimaryKeyObj(), localRich);

				cacheResult(localRich);

				uncachedPrimaryKeys.remove(localRich.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LocalRichModelImpl.ENTITY_CACHE_ENABLED,
					LocalRichImpl.class, primaryKey, nullModel);
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
	 * Returns all the local richs.
	 *
	 * @return the local richs
	 */
	@Override
	public List<LocalRich> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the local richs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @return the range of local richs
	 */
	@Override
	public List<LocalRich> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the local richs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of local richs
	 */
	@Override
	public List<LocalRich> findAll(int start, int end,
		OrderByComparator<LocalRich> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the local richs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of local richs
	 * @param end the upper bound of the range of local richs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of local richs
	 */
	@Override
	public List<LocalRich> findAll(int start, int end,
		OrderByComparator<LocalRich> orderByComparator,
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

		List<LocalRich> list = null;

		if (retrieveFromCache) {
			list = (List<LocalRich>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LOCALRICH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOCALRICH;

				if (pagination) {
					sql = sql.concat(LocalRichModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LocalRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LocalRich>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the local richs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LocalRich localRich : findAll()) {
			remove(localRich);
		}
	}

	/**
	 * Returns the number of local richs.
	 *
	 * @return the number of local richs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOCALRICH);

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
		return LocalRichModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the local rich persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LocalRichImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LOCALRICH = "SELECT localRich FROM LocalRich localRich";
	private static final String _SQL_SELECT_LOCALRICH_WHERE_PKS_IN = "SELECT localRich FROM LocalRich localRich WHERE id_ IN (";
	private static final String _SQL_SELECT_LOCALRICH_WHERE = "SELECT localRich FROM LocalRich localRich WHERE ";
	private static final String _SQL_COUNT_LOCALRICH = "SELECT COUNT(localRich) FROM LocalRich localRich";
	private static final String _SQL_COUNT_LOCALRICH_WHERE = "SELECT COUNT(localRich) FROM LocalRich localRich WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "localRich.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LocalRich exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LocalRich exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LocalRichPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}