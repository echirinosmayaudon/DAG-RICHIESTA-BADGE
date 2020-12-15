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

package servizio.prenotazione.aule.mef.service.persistence.impl;

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

import servizio.prenotazione.aule.mef.exception.NoSuchSalaStrutturaException;
import servizio.prenotazione.aule.mef.model.SalaStruttura;
import servizio.prenotazione.aule.mef.model.impl.SalaStrutturaImpl;
import servizio.prenotazione.aule.mef.model.impl.SalaStrutturaModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.SalaStrutturaPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sala struttura service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaStrutturaPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.SalaStrutturaUtil
 * @generated
 */
@ProviderType
public class SalaStrutturaPersistenceImpl extends BasePersistenceImpl<SalaStruttura>
	implements SalaStrutturaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SalaStrutturaUtil} to access the sala struttura persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SalaStrutturaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaModelImpl.FINDER_CACHE_ENABLED,
			SalaStrutturaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaModelImpl.FINDER_CACHE_ENABLED,
			SalaStrutturaImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSTRUTTURA =
		new FinderPath(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaModelImpl.FINDER_CACHE_ENABLED,
			SalaStrutturaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByIdStruttura",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA =
		new FinderPath(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaModelImpl.FINDER_CACHE_ENABLED,
			SalaStrutturaImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIdStruttura", new String[] { Long.class.getName() },
			SalaStrutturaModelImpl.ID_STRUTTURA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDSTRUTTURA = new FinderPath(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdStruttura",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the sala strutturas where id_struttura = &#63;.
	 *
	 * @param id_struttura the id_struttura
	 * @return the matching sala strutturas
	 */
	@Override
	public List<SalaStruttura> findByIdStruttura(long id_struttura) {
		return findByIdStruttura(id_struttura, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sala strutturas where id_struttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_struttura the id_struttura
	 * @param start the lower bound of the range of sala strutturas
	 * @param end the upper bound of the range of sala strutturas (not inclusive)
	 * @return the range of matching sala strutturas
	 */
	@Override
	public List<SalaStruttura> findByIdStruttura(long id_struttura, int start,
		int end) {
		return findByIdStruttura(id_struttura, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sala strutturas where id_struttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_struttura the id_struttura
	 * @param start the lower bound of the range of sala strutturas
	 * @param end the upper bound of the range of sala strutturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sala strutturas
	 */
	@Override
	public List<SalaStruttura> findByIdStruttura(long id_struttura, int start,
		int end, OrderByComparator<SalaStruttura> orderByComparator) {
		return findByIdStruttura(id_struttura, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the sala strutturas where id_struttura = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_struttura the id_struttura
	 * @param start the lower bound of the range of sala strutturas
	 * @param end the upper bound of the range of sala strutturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching sala strutturas
	 */
	@Override
	public List<SalaStruttura> findByIdStruttura(long id_struttura, int start,
		int end, OrderByComparator<SalaStruttura> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA;
			finderArgs = new Object[] { id_struttura };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSTRUTTURA;
			finderArgs = new Object[] {
					id_struttura,
					
					start, end, orderByComparator
				};
		}

		List<SalaStruttura> list = null;

		if (retrieveFromCache) {
			list = (List<SalaStruttura>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SalaStruttura salaStruttura : list) {
					if ((id_struttura != salaStruttura.getId_struttura())) {
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

			query.append(_SQL_SELECT_SALASTRUTTURA_WHERE);

			query.append(_FINDER_COLUMN_IDSTRUTTURA_ID_STRUTTURA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SalaStrutturaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_struttura);

				if (!pagination) {
					list = (List<SalaStruttura>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalaStruttura>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first sala struttura in the ordered set where id_struttura = &#63;.
	 *
	 * @param id_struttura the id_struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sala struttura
	 * @throws NoSuchSalaStrutturaException if a matching sala struttura could not be found
	 */
	@Override
	public SalaStruttura findByIdStruttura_First(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator)
		throws NoSuchSalaStrutturaException {
		SalaStruttura salaStruttura = fetchByIdStruttura_First(id_struttura,
				orderByComparator);

		if (salaStruttura != null) {
			return salaStruttura;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_struttura=");
		msg.append(id_struttura);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSalaStrutturaException(msg.toString());
	}

	/**
	 * Returns the first sala struttura in the ordered set where id_struttura = &#63;.
	 *
	 * @param id_struttura the id_struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sala struttura, or <code>null</code> if a matching sala struttura could not be found
	 */
	@Override
	public SalaStruttura fetchByIdStruttura_First(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator) {
		List<SalaStruttura> list = findByIdStruttura(id_struttura, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sala struttura in the ordered set where id_struttura = &#63;.
	 *
	 * @param id_struttura the id_struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sala struttura
	 * @throws NoSuchSalaStrutturaException if a matching sala struttura could not be found
	 */
	@Override
	public SalaStruttura findByIdStruttura_Last(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator)
		throws NoSuchSalaStrutturaException {
		SalaStruttura salaStruttura = fetchByIdStruttura_Last(id_struttura,
				orderByComparator);

		if (salaStruttura != null) {
			return salaStruttura;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_struttura=");
		msg.append(id_struttura);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSalaStrutturaException(msg.toString());
	}

	/**
	 * Returns the last sala struttura in the ordered set where id_struttura = &#63;.
	 *
	 * @param id_struttura the id_struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sala struttura, or <code>null</code> if a matching sala struttura could not be found
	 */
	@Override
	public SalaStruttura fetchByIdStruttura_Last(long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator) {
		int count = countByIdStruttura(id_struttura);

		if (count == 0) {
			return null;
		}

		List<SalaStruttura> list = findByIdStruttura(id_struttura, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sala strutturas before and after the current sala struttura in the ordered set where id_struttura = &#63;.
	 *
	 * @param id the primary key of the current sala struttura
	 * @param id_struttura the id_struttura
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sala struttura
	 * @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura[] findByIdStruttura_PrevAndNext(long id,
		long id_struttura, OrderByComparator<SalaStruttura> orderByComparator)
		throws NoSuchSalaStrutturaException {
		SalaStruttura salaStruttura = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SalaStruttura[] array = new SalaStrutturaImpl[3];

			array[0] = getByIdStruttura_PrevAndNext(session, salaStruttura,
					id_struttura, orderByComparator, true);

			array[1] = salaStruttura;

			array[2] = getByIdStruttura_PrevAndNext(session, salaStruttura,
					id_struttura, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalaStruttura getByIdStruttura_PrevAndNext(Session session,
		SalaStruttura salaStruttura, long id_struttura,
		OrderByComparator<SalaStruttura> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SALASTRUTTURA_WHERE);

		query.append(_FINDER_COLUMN_IDSTRUTTURA_ID_STRUTTURA_2);

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
			query.append(SalaStrutturaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_struttura);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(salaStruttura);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SalaStruttura> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sala strutturas where id_struttura = &#63; from the database.
	 *
	 * @param id_struttura the id_struttura
	 */
	@Override
	public void removeByIdStruttura(long id_struttura) {
		for (SalaStruttura salaStruttura : findByIdStruttura(id_struttura,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(salaStruttura);
		}
	}

	/**
	 * Returns the number of sala strutturas where id_struttura = &#63;.
	 *
	 * @param id_struttura the id_struttura
	 * @return the number of matching sala strutturas
	 */
	@Override
	public int countByIdStruttura(long id_struttura) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDSTRUTTURA;

		Object[] finderArgs = new Object[] { id_struttura };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SALASTRUTTURA_WHERE);

			query.append(_FINDER_COLUMN_IDSTRUTTURA_ID_STRUTTURA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_struttura);

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

	private static final String _FINDER_COLUMN_IDSTRUTTURA_ID_STRUTTURA_2 = "salaStruttura.id_struttura = ?";

	public SalaStrutturaPersistenceImpl() {
		setModelClass(SalaStruttura.class);
	}

	/**
	 * Caches the sala struttura in the entity cache if it is enabled.
	 *
	 * @param salaStruttura the sala struttura
	 */
	@Override
	public void cacheResult(SalaStruttura salaStruttura) {
		entityCache.putResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaImpl.class, salaStruttura.getPrimaryKey(),
			salaStruttura);

		salaStruttura.resetOriginalValues();
	}

	/**
	 * Caches the sala strutturas in the entity cache if it is enabled.
	 *
	 * @param salaStrutturas the sala strutturas
	 */
	@Override
	public void cacheResult(List<SalaStruttura> salaStrutturas) {
		for (SalaStruttura salaStruttura : salaStrutturas) {
			if (entityCache.getResult(
						SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
						SalaStrutturaImpl.class, salaStruttura.getPrimaryKey()) == null) {
				cacheResult(salaStruttura);
			}
			else {
				salaStruttura.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sala strutturas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalaStrutturaImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sala struttura.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalaStruttura salaStruttura) {
		entityCache.removeResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaImpl.class, salaStruttura.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SalaStruttura> salaStrutturas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SalaStruttura salaStruttura : salaStrutturas) {
			entityCache.removeResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
				SalaStrutturaImpl.class, salaStruttura.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sala struttura with the primary key. Does not add the sala struttura to the database.
	 *
	 * @param id the primary key for the new sala struttura
	 * @return the new sala struttura
	 */
	@Override
	public SalaStruttura create(long id) {
		SalaStruttura salaStruttura = new SalaStrutturaImpl();

		salaStruttura.setNew(true);
		salaStruttura.setPrimaryKey(id);

		return salaStruttura;
	}

	/**
	 * Removes the sala struttura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the sala struttura
	 * @return the sala struttura that was removed
	 * @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura remove(long id) throws NoSuchSalaStrutturaException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the sala struttura with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sala struttura
	 * @return the sala struttura that was removed
	 * @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura remove(Serializable primaryKey)
		throws NoSuchSalaStrutturaException {
		Session session = null;

		try {
			session = openSession();

			SalaStruttura salaStruttura = (SalaStruttura)session.get(SalaStrutturaImpl.class,
					primaryKey);

			if (salaStruttura == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalaStrutturaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(salaStruttura);
		}
		catch (NoSuchSalaStrutturaException nsee) {
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
	protected SalaStruttura removeImpl(SalaStruttura salaStruttura) {
		salaStruttura = toUnwrappedModel(salaStruttura);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salaStruttura)) {
				salaStruttura = (SalaStruttura)session.get(SalaStrutturaImpl.class,
						salaStruttura.getPrimaryKeyObj());
			}

			if (salaStruttura != null) {
				session.delete(salaStruttura);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (salaStruttura != null) {
			clearCache(salaStruttura);
		}

		return salaStruttura;
	}

	@Override
	public SalaStruttura updateImpl(SalaStruttura salaStruttura) {
		salaStruttura = toUnwrappedModel(salaStruttura);

		boolean isNew = salaStruttura.isNew();

		SalaStrutturaModelImpl salaStrutturaModelImpl = (SalaStrutturaModelImpl)salaStruttura;

		Session session = null;

		try {
			session = openSession();

			if (salaStruttura.isNew()) {
				session.save(salaStruttura);

				salaStruttura.setNew(false);
			}
			else {
				salaStruttura = (SalaStruttura)session.merge(salaStruttura);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SalaStrutturaModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((salaStrutturaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						salaStrutturaModelImpl.getOriginalId_struttura()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA,
					args);

				args = new Object[] { salaStrutturaModelImpl.getId_struttura() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSTRUTTURA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSTRUTTURA,
					args);
			}
		}

		entityCache.putResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
			SalaStrutturaImpl.class, salaStruttura.getPrimaryKey(),
			salaStruttura, false);

		salaStruttura.resetOriginalValues();

		return salaStruttura;
	}

	protected SalaStruttura toUnwrappedModel(SalaStruttura salaStruttura) {
		if (salaStruttura instanceof SalaStrutturaImpl) {
			return salaStruttura;
		}

		SalaStrutturaImpl salaStrutturaImpl = new SalaStrutturaImpl();

		salaStrutturaImpl.setNew(salaStruttura.isNew());
		salaStrutturaImpl.setPrimaryKey(salaStruttura.getPrimaryKey());

		salaStrutturaImpl.setId(salaStruttura.getId());
		salaStrutturaImpl.setId_sala(salaStruttura.getId_sala());
		salaStrutturaImpl.setId_struttura(salaStruttura.getId_struttura());

		return salaStrutturaImpl;
	}

	/**
	 * Returns the sala struttura with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sala struttura
	 * @return the sala struttura
	 * @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalaStrutturaException {
		SalaStruttura salaStruttura = fetchByPrimaryKey(primaryKey);

		if (salaStruttura == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalaStrutturaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return salaStruttura;
	}

	/**
	 * Returns the sala struttura with the primary key or throws a {@link NoSuchSalaStrutturaException} if it could not be found.
	 *
	 * @param id the primary key of the sala struttura
	 * @return the sala struttura
	 * @throws NoSuchSalaStrutturaException if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura findByPrimaryKey(long id)
		throws NoSuchSalaStrutturaException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the sala struttura with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sala struttura
	 * @return the sala struttura, or <code>null</code> if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
				SalaStrutturaImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SalaStruttura salaStruttura = (SalaStruttura)serializable;

		if (salaStruttura == null) {
			Session session = null;

			try {
				session = openSession();

				salaStruttura = (SalaStruttura)session.get(SalaStrutturaImpl.class,
						primaryKey);

				if (salaStruttura != null) {
					cacheResult(salaStruttura);
				}
				else {
					entityCache.putResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
						SalaStrutturaImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
					SalaStrutturaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return salaStruttura;
	}

	/**
	 * Returns the sala struttura with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the sala struttura
	 * @return the sala struttura, or <code>null</code> if a sala struttura with the primary key could not be found
	 */
	@Override
	public SalaStruttura fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, SalaStruttura> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SalaStruttura> map = new HashMap<Serializable, SalaStruttura>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SalaStruttura salaStruttura = fetchByPrimaryKey(primaryKey);

			if (salaStruttura != null) {
				map.put(primaryKey, salaStruttura);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
					SalaStrutturaImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SalaStruttura)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SALASTRUTTURA_WHERE_PKS_IN);

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

			for (SalaStruttura salaStruttura : (List<SalaStruttura>)q.list()) {
				map.put(salaStruttura.getPrimaryKeyObj(), salaStruttura);

				cacheResult(salaStruttura);

				uncachedPrimaryKeys.remove(salaStruttura.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SalaStrutturaModelImpl.ENTITY_CACHE_ENABLED,
					SalaStrutturaImpl.class, primaryKey, nullModel);
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
	 * Returns all the sala strutturas.
	 *
	 * @return the sala strutturas
	 */
	@Override
	public List<SalaStruttura> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sala strutturas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sala strutturas
	 * @param end the upper bound of the range of sala strutturas (not inclusive)
	 * @return the range of sala strutturas
	 */
	@Override
	public List<SalaStruttura> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sala strutturas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sala strutturas
	 * @param end the upper bound of the range of sala strutturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sala strutturas
	 */
	@Override
	public List<SalaStruttura> findAll(int start, int end,
		OrderByComparator<SalaStruttura> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sala strutturas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sala strutturas
	 * @param end the upper bound of the range of sala strutturas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of sala strutturas
	 */
	@Override
	public List<SalaStruttura> findAll(int start, int end,
		OrderByComparator<SalaStruttura> orderByComparator,
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

		List<SalaStruttura> list = null;

		if (retrieveFromCache) {
			list = (List<SalaStruttura>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SALASTRUTTURA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SALASTRUTTURA;

				if (pagination) {
					sql = sql.concat(SalaStrutturaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SalaStruttura>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SalaStruttura>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the sala strutturas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalaStruttura salaStruttura : findAll()) {
			remove(salaStruttura);
		}
	}

	/**
	 * Returns the number of sala strutturas.
	 *
	 * @return the number of sala strutturas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SALASTRUTTURA);

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
		return SalaStrutturaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sala struttura persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SalaStrutturaImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SALASTRUTTURA = "SELECT salaStruttura FROM SalaStruttura salaStruttura";
	private static final String _SQL_SELECT_SALASTRUTTURA_WHERE_PKS_IN = "SELECT salaStruttura FROM SalaStruttura salaStruttura WHERE id_ IN (";
	private static final String _SQL_SELECT_SALASTRUTTURA_WHERE = "SELECT salaStruttura FROM SalaStruttura salaStruttura WHERE ";
	private static final String _SQL_COUNT_SALASTRUTTURA = "SELECT COUNT(salaStruttura) FROM SalaStruttura salaStruttura";
	private static final String _SQL_COUNT_SALASTRUTTURA_WHERE = "SELECT COUNT(salaStruttura) FROM SalaStruttura salaStruttura WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "salaStruttura.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SalaStruttura exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SalaStruttura exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SalaStrutturaPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}