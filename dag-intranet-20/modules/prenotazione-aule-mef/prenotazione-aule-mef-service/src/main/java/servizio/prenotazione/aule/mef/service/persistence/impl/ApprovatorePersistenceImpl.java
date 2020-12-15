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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.prenotazione.aule.mef.exception.NoSuchApprovatoreException;
import servizio.prenotazione.aule.mef.model.Approvatore;
import servizio.prenotazione.aule.mef.model.impl.ApprovatoreImpl;
import servizio.prenotazione.aule.mef.model.impl.ApprovatoreModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.ApprovatorePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the approvatore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApprovatorePersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.ApprovatoreUtil
 * @generated
 */
@ProviderType
public class ApprovatorePersistenceImpl extends BasePersistenceImpl<Approvatore>
	implements ApprovatorePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApprovatoreUtil} to access the approvatore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApprovatoreImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreModelImpl.FINDER_CACHE_ENABLED, ApprovatoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreModelImpl.FINDER_CACHE_ENABLED, ApprovatoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSALA = new FinderPath(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreModelImpl.FINDER_CACHE_ENABLED, ApprovatoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdSala",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSALA =
		new FinderPath(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreModelImpl.FINDER_CACHE_ENABLED, ApprovatoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdSala",
			new String[] { Long.class.getName() },
			ApprovatoreModelImpl.ID_SALA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDSALA = new FinderPath(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdSala",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the approvatores where id_sala = &#63;.
	 *
	 * @param id_sala the id_sala
	 * @return the matching approvatores
	 */
	@Override
	public List<Approvatore> findByIdSala(long id_sala) {
		return findByIdSala(id_sala, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approvatores where id_sala = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_sala the id_sala
	 * @param start the lower bound of the range of approvatores
	 * @param end the upper bound of the range of approvatores (not inclusive)
	 * @return the range of matching approvatores
	 */
	@Override
	public List<Approvatore> findByIdSala(long id_sala, int start, int end) {
		return findByIdSala(id_sala, start, end, null);
	}

	/**
	 * Returns an ordered range of all the approvatores where id_sala = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_sala the id_sala
	 * @param start the lower bound of the range of approvatores
	 * @param end the upper bound of the range of approvatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching approvatores
	 */
	@Override
	public List<Approvatore> findByIdSala(long id_sala, int start, int end,
		OrderByComparator<Approvatore> orderByComparator) {
		return findByIdSala(id_sala, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the approvatores where id_sala = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_sala the id_sala
	 * @param start the lower bound of the range of approvatores
	 * @param end the upper bound of the range of approvatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching approvatores
	 */
	@Override
	public List<Approvatore> findByIdSala(long id_sala, int start, int end,
		OrderByComparator<Approvatore> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSALA;
			finderArgs = new Object[] { id_sala };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDSALA;
			finderArgs = new Object[] { id_sala, start, end, orderByComparator };
		}

		List<Approvatore> list = null;

		if (retrieveFromCache) {
			list = (List<Approvatore>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Approvatore approvatore : list) {
					if ((id_sala != approvatore.getId_sala())) {
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

			query.append(_SQL_SELECT_APPROVATORE_WHERE);

			query.append(_FINDER_COLUMN_IDSALA_ID_SALA_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApprovatoreModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_sala);

				if (!pagination) {
					list = (List<Approvatore>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Approvatore>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first approvatore in the ordered set where id_sala = &#63;.
	 *
	 * @param id_sala the id_sala
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approvatore
	 * @throws NoSuchApprovatoreException if a matching approvatore could not be found
	 */
	@Override
	public Approvatore findByIdSala_First(long id_sala,
		OrderByComparator<Approvatore> orderByComparator)
		throws NoSuchApprovatoreException {
		Approvatore approvatore = fetchByIdSala_First(id_sala, orderByComparator);

		if (approvatore != null) {
			return approvatore;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_sala=");
		msg.append(id_sala);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovatoreException(msg.toString());
	}

	/**
	 * Returns the first approvatore in the ordered set where id_sala = &#63;.
	 *
	 * @param id_sala the id_sala
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching approvatore, or <code>null</code> if a matching approvatore could not be found
	 */
	@Override
	public Approvatore fetchByIdSala_First(long id_sala,
		OrderByComparator<Approvatore> orderByComparator) {
		List<Approvatore> list = findByIdSala(id_sala, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last approvatore in the ordered set where id_sala = &#63;.
	 *
	 * @param id_sala the id_sala
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approvatore
	 * @throws NoSuchApprovatoreException if a matching approvatore could not be found
	 */
	@Override
	public Approvatore findByIdSala_Last(long id_sala,
		OrderByComparator<Approvatore> orderByComparator)
		throws NoSuchApprovatoreException {
		Approvatore approvatore = fetchByIdSala_Last(id_sala, orderByComparator);

		if (approvatore != null) {
			return approvatore;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_sala=");
		msg.append(id_sala);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApprovatoreException(msg.toString());
	}

	/**
	 * Returns the last approvatore in the ordered set where id_sala = &#63;.
	 *
	 * @param id_sala the id_sala
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching approvatore, or <code>null</code> if a matching approvatore could not be found
	 */
	@Override
	public Approvatore fetchByIdSala_Last(long id_sala,
		OrderByComparator<Approvatore> orderByComparator) {
		int count = countByIdSala(id_sala);

		if (count == 0) {
			return null;
		}

		List<Approvatore> list = findByIdSala(id_sala, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the approvatores before and after the current approvatore in the ordered set where id_sala = &#63;.
	 *
	 * @param id_approvatore the primary key of the current approvatore
	 * @param id_sala the id_sala
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next approvatore
	 * @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore[] findByIdSala_PrevAndNext(long id_approvatore,
		long id_sala, OrderByComparator<Approvatore> orderByComparator)
		throws NoSuchApprovatoreException {
		Approvatore approvatore = findByPrimaryKey(id_approvatore);

		Session session = null;

		try {
			session = openSession();

			Approvatore[] array = new ApprovatoreImpl[3];

			array[0] = getByIdSala_PrevAndNext(session, approvatore, id_sala,
					orderByComparator, true);

			array[1] = approvatore;

			array[2] = getByIdSala_PrevAndNext(session, approvatore, id_sala,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Approvatore getByIdSala_PrevAndNext(Session session,
		Approvatore approvatore, long id_sala,
		OrderByComparator<Approvatore> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPROVATORE_WHERE);

		query.append(_FINDER_COLUMN_IDSALA_ID_SALA_2);

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
			query.append(ApprovatoreModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_sala);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(approvatore);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Approvatore> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the approvatores where id_sala = &#63; from the database.
	 *
	 * @param id_sala the id_sala
	 */
	@Override
	public void removeByIdSala(long id_sala) {
		for (Approvatore approvatore : findByIdSala(id_sala, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(approvatore);
		}
	}

	/**
	 * Returns the number of approvatores where id_sala = &#63;.
	 *
	 * @param id_sala the id_sala
	 * @return the number of matching approvatores
	 */
	@Override
	public int countByIdSala(long id_sala) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDSALA;

		Object[] finderArgs = new Object[] { id_sala };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPROVATORE_WHERE);

			query.append(_FINDER_COLUMN_IDSALA_ID_SALA_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_sala);

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

	private static final String _FINDER_COLUMN_IDSALA_ID_SALA_2 = "approvatore.id_sala = ?";

	public ApprovatorePersistenceImpl() {
		setModelClass(Approvatore.class);
	}

	/**
	 * Caches the approvatore in the entity cache if it is enabled.
	 *
	 * @param approvatore the approvatore
	 */
	@Override
	public void cacheResult(Approvatore approvatore) {
		entityCache.putResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreImpl.class, approvatore.getPrimaryKey(), approvatore);

		approvatore.resetOriginalValues();
	}

	/**
	 * Caches the approvatores in the entity cache if it is enabled.
	 *
	 * @param approvatores the approvatores
	 */
	@Override
	public void cacheResult(List<Approvatore> approvatores) {
		for (Approvatore approvatore : approvatores) {
			if (entityCache.getResult(
						ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
						ApprovatoreImpl.class, approvatore.getPrimaryKey()) == null) {
				cacheResult(approvatore);
			}
			else {
				approvatore.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all approvatores.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApprovatoreImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the approvatore.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Approvatore approvatore) {
		entityCache.removeResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreImpl.class, approvatore.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Approvatore> approvatores) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Approvatore approvatore : approvatores) {
			entityCache.removeResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
				ApprovatoreImpl.class, approvatore.getPrimaryKey());
		}
	}

	/**
	 * Creates a new approvatore with the primary key. Does not add the approvatore to the database.
	 *
	 * @param id_approvatore the primary key for the new approvatore
	 * @return the new approvatore
	 */
	@Override
	public Approvatore create(long id_approvatore) {
		Approvatore approvatore = new ApprovatoreImpl();

		approvatore.setNew(true);
		approvatore.setPrimaryKey(id_approvatore);

		return approvatore;
	}

	/**
	 * Removes the approvatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_approvatore the primary key of the approvatore
	 * @return the approvatore that was removed
	 * @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore remove(long id_approvatore)
		throws NoSuchApprovatoreException {
		return remove((Serializable)id_approvatore);
	}

	/**
	 * Removes the approvatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the approvatore
	 * @return the approvatore that was removed
	 * @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore remove(Serializable primaryKey)
		throws NoSuchApprovatoreException {
		Session session = null;

		try {
			session = openSession();

			Approvatore approvatore = (Approvatore)session.get(ApprovatoreImpl.class,
					primaryKey);

			if (approvatore == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApprovatoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(approvatore);
		}
		catch (NoSuchApprovatoreException nsee) {
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
	protected Approvatore removeImpl(Approvatore approvatore) {
		approvatore = toUnwrappedModel(approvatore);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(approvatore)) {
				approvatore = (Approvatore)session.get(ApprovatoreImpl.class,
						approvatore.getPrimaryKeyObj());
			}

			if (approvatore != null) {
				session.delete(approvatore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (approvatore != null) {
			clearCache(approvatore);
		}

		return approvatore;
	}

	@Override
	public Approvatore updateImpl(Approvatore approvatore) {
		approvatore = toUnwrappedModel(approvatore);

		boolean isNew = approvatore.isNew();

		ApprovatoreModelImpl approvatoreModelImpl = (ApprovatoreModelImpl)approvatore;

		Session session = null;

		try {
			session = openSession();

			if (approvatore.isNew()) {
				session.save(approvatore);

				approvatore.setNew(false);
			}
			else {
				approvatore = (Approvatore)session.merge(approvatore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApprovatoreModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((approvatoreModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSALA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						approvatoreModelImpl.getOriginalId_sala()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSALA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSALA,
					args);

				args = new Object[] { approvatoreModelImpl.getId_sala() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDSALA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDSALA,
					args);
			}
		}

		entityCache.putResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
			ApprovatoreImpl.class, approvatore.getPrimaryKey(), approvatore,
			false);

		approvatore.resetOriginalValues();

		return approvatore;
	}

	protected Approvatore toUnwrappedModel(Approvatore approvatore) {
		if (approvatore instanceof ApprovatoreImpl) {
			return approvatore;
		}

		ApprovatoreImpl approvatoreImpl = new ApprovatoreImpl();

		approvatoreImpl.setNew(approvatore.isNew());
		approvatoreImpl.setPrimaryKey(approvatore.getPrimaryKey());

		approvatoreImpl.setId_approvatore(approvatore.getId_approvatore());
		approvatoreImpl.setId_sala(approvatore.getId_sala());
		approvatoreImpl.setEmail_approvatore(approvatore.getEmail_approvatore());

		return approvatoreImpl;
	}

	/**
	 * Returns the approvatore with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the approvatore
	 * @return the approvatore
	 * @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApprovatoreException {
		Approvatore approvatore = fetchByPrimaryKey(primaryKey);

		if (approvatore == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApprovatoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return approvatore;
	}

	/**
	 * Returns the approvatore with the primary key or throws a {@link NoSuchApprovatoreException} if it could not be found.
	 *
	 * @param id_approvatore the primary key of the approvatore
	 * @return the approvatore
	 * @throws NoSuchApprovatoreException if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore findByPrimaryKey(long id_approvatore)
		throws NoSuchApprovatoreException {
		return findByPrimaryKey((Serializable)id_approvatore);
	}

	/**
	 * Returns the approvatore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the approvatore
	 * @return the approvatore, or <code>null</code> if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
				ApprovatoreImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Approvatore approvatore = (Approvatore)serializable;

		if (approvatore == null) {
			Session session = null;

			try {
				session = openSession();

				approvatore = (Approvatore)session.get(ApprovatoreImpl.class,
						primaryKey);

				if (approvatore != null) {
					cacheResult(approvatore);
				}
				else {
					entityCache.putResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
						ApprovatoreImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
					ApprovatoreImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return approvatore;
	}

	/**
	 * Returns the approvatore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_approvatore the primary key of the approvatore
	 * @return the approvatore, or <code>null</code> if a approvatore with the primary key could not be found
	 */
	@Override
	public Approvatore fetchByPrimaryKey(long id_approvatore) {
		return fetchByPrimaryKey((Serializable)id_approvatore);
	}

	@Override
	public Map<Serializable, Approvatore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Approvatore> map = new HashMap<Serializable, Approvatore>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Approvatore approvatore = fetchByPrimaryKey(primaryKey);

			if (approvatore != null) {
				map.put(primaryKey, approvatore);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
					ApprovatoreImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Approvatore)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPROVATORE_WHERE_PKS_IN);

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

			for (Approvatore approvatore : (List<Approvatore>)q.list()) {
				map.put(approvatore.getPrimaryKeyObj(), approvatore);

				cacheResult(approvatore);

				uncachedPrimaryKeys.remove(approvatore.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApprovatoreModelImpl.ENTITY_CACHE_ENABLED,
					ApprovatoreImpl.class, primaryKey, nullModel);
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
	 * Returns all the approvatores.
	 *
	 * @return the approvatores
	 */
	@Override
	public List<Approvatore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the approvatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of approvatores
	 * @param end the upper bound of the range of approvatores (not inclusive)
	 * @return the range of approvatores
	 */
	@Override
	public List<Approvatore> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the approvatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of approvatores
	 * @param end the upper bound of the range of approvatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of approvatores
	 */
	@Override
	public List<Approvatore> findAll(int start, int end,
		OrderByComparator<Approvatore> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the approvatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of approvatores
	 * @param end the upper bound of the range of approvatores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of approvatores
	 */
	@Override
	public List<Approvatore> findAll(int start, int end,
		OrderByComparator<Approvatore> orderByComparator,
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

		List<Approvatore> list = null;

		if (retrieveFromCache) {
			list = (List<Approvatore>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPROVATORE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPROVATORE;

				if (pagination) {
					sql = sql.concat(ApprovatoreModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Approvatore>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Approvatore>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the approvatores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Approvatore approvatore : findAll()) {
			remove(approvatore);
		}
	}

	/**
	 * Returns the number of approvatores.
	 *
	 * @return the number of approvatores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPROVATORE);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return ApprovatoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the approvatore persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApprovatoreImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_APPROVATORE = "SELECT approvatore FROM Approvatore approvatore";
	private static final String _SQL_SELECT_APPROVATORE_WHERE_PKS_IN = "SELECT approvatore FROM Approvatore approvatore WHERE id_approvatore IN (";
	private static final String _SQL_SELECT_APPROVATORE_WHERE = "SELECT approvatore FROM Approvatore approvatore WHERE ";
	private static final String _SQL_COUNT_APPROVATORE = "SELECT COUNT(approvatore) FROM Approvatore approvatore";
	private static final String _SQL_COUNT_APPROVATORE_WHERE = "SELECT COUNT(approvatore) FROM Approvatore approvatore WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "approvatore.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Approvatore exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Approvatore exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApprovatorePersistenceImpl.class);
}