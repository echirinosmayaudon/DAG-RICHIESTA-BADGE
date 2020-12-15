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

import servizio.prenotazione.aule.mef.exception.NoSuchPrenotazioneException;
import servizio.prenotazione.aule.mef.model.Prenotazione;
import servizio.prenotazione.aule.mef.model.impl.PrenotazioneImpl;
import servizio.prenotazione.aule.mef.model.impl.PrenotazioneModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.PrenotazionePersistence;

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
 * The persistence implementation for the prenotazione service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrenotazionePersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.PrenotazioneUtil
 * @generated
 */
@ProviderType
public class PrenotazionePersistenceImpl extends BasePersistenceImpl<Prenotazione>
	implements PrenotazionePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PrenotazioneUtil} to access the prenotazione persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PrenotazioneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneModelImpl.FINDER_CACHE_ENABLED, PrenotazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneModelImpl.FINDER_CACHE_ENABLED, PrenotazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODFISCALE =
		new FinderPath(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneModelImpl.FINDER_CACHE_ENABLED, PrenotazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodFiscale",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODFISCALE =
		new FinderPath(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneModelImpl.FINDER_CACHE_ENABLED, PrenotazioneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodFiscale",
			new String[] { String.class.getName() },
			PrenotazioneModelImpl.COD_FISCALE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODFISCALE = new FinderPath(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodFiscale",
			new String[] { String.class.getName() });

	/**
	 * Returns all the prenotaziones where cod_fiscale = &#63;.
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @return the matching prenotaziones
	 */
	@Override
	public List<Prenotazione> findByCodFiscale(String cod_fiscale) {
		return findByCodFiscale(cod_fiscale, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prenotaziones where cod_fiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of matching prenotaziones
	 */
	@Override
	public List<Prenotazione> findByCodFiscale(String cod_fiscale, int start,
		int end) {
		return findByCodFiscale(cod_fiscale, start, end, null);
	}

	/**
	 * Returns an ordered range of all the prenotaziones where cod_fiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching prenotaziones
	 */
	@Override
	public List<Prenotazione> findByCodFiscale(String cod_fiscale, int start,
		int end, OrderByComparator<Prenotazione> orderByComparator) {
		return findByCodFiscale(cod_fiscale, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prenotaziones where cod_fiscale = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching prenotaziones
	 */
	@Override
	public List<Prenotazione> findByCodFiscale(String cod_fiscale, int start,
		int end, OrderByComparator<Prenotazione> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODFISCALE;
			finderArgs = new Object[] { cod_fiscale };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODFISCALE;
			finderArgs = new Object[] { cod_fiscale, start, end, orderByComparator };
		}

		List<Prenotazione> list = null;

		if (retrieveFromCache) {
			list = (List<Prenotazione>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Prenotazione prenotazione : list) {
					if (!Objects.equals(cod_fiscale,
								prenotazione.getCod_fiscale())) {
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

			query.append(_SQL_SELECT_PRENOTAZIONE_WHERE);

			boolean bindCod_fiscale = false;

			if (cod_fiscale == null) {
				query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_1);
			}
			else if (cod_fiscale.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_3);
			}
			else {
				bindCod_fiscale = true;

				query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PrenotazioneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCod_fiscale) {
					qPos.add(cod_fiscale);
				}

				if (!pagination) {
					list = (List<Prenotazione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Prenotazione>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first prenotazione in the ordered set where cod_fiscale = &#63;.
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	@Override
	public Prenotazione findByCodFiscale_First(String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator)
		throws NoSuchPrenotazioneException {
		Prenotazione prenotazione = fetchByCodFiscale_First(cod_fiscale,
				orderByComparator);

		if (prenotazione != null) {
			return prenotazione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cod_fiscale=");
		msg.append(cod_fiscale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrenotazioneException(msg.toString());
	}

	/**
	 * Returns the first prenotazione in the ordered set where cod_fiscale = &#63;.
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	@Override
	public Prenotazione fetchByCodFiscale_First(String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator) {
		List<Prenotazione> list = findByCodFiscale(cod_fiscale, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last prenotazione in the ordered set where cod_fiscale = &#63;.
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione
	 * @throws NoSuchPrenotazioneException if a matching prenotazione could not be found
	 */
	@Override
	public Prenotazione findByCodFiscale_Last(String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator)
		throws NoSuchPrenotazioneException {
		Prenotazione prenotazione = fetchByCodFiscale_Last(cod_fiscale,
				orderByComparator);

		if (prenotazione != null) {
			return prenotazione;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cod_fiscale=");
		msg.append(cod_fiscale);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPrenotazioneException(msg.toString());
	}

	/**
	 * Returns the last prenotazione in the ordered set where cod_fiscale = &#63;.
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching prenotazione, or <code>null</code> if a matching prenotazione could not be found
	 */
	@Override
	public Prenotazione fetchByCodFiscale_Last(String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator) {
		int count = countByCodFiscale(cod_fiscale);

		if (count == 0) {
			return null;
		}

		List<Prenotazione> list = findByCodFiscale(cod_fiscale, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the prenotaziones before and after the current prenotazione in the ordered set where cod_fiscale = &#63;.
	 *
	 * @param id_prenota the primary key of the current prenotazione
	 * @param cod_fiscale the cod_fiscale
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione[] findByCodFiscale_PrevAndNext(long id_prenota,
		String cod_fiscale, OrderByComparator<Prenotazione> orderByComparator)
		throws NoSuchPrenotazioneException {
		Prenotazione prenotazione = findByPrimaryKey(id_prenota);

		Session session = null;

		try {
			session = openSession();

			Prenotazione[] array = new PrenotazioneImpl[3];

			array[0] = getByCodFiscale_PrevAndNext(session, prenotazione,
					cod_fiscale, orderByComparator, true);

			array[1] = prenotazione;

			array[2] = getByCodFiscale_PrevAndNext(session, prenotazione,
					cod_fiscale, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Prenotazione getByCodFiscale_PrevAndNext(Session session,
		Prenotazione prenotazione, String cod_fiscale,
		OrderByComparator<Prenotazione> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRENOTAZIONE_WHERE);

		boolean bindCod_fiscale = false;

		if (cod_fiscale == null) {
			query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_1);
		}
		else if (cod_fiscale.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_3);
		}
		else {
			bindCod_fiscale = true;

			query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_2);
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
			query.append(PrenotazioneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCod_fiscale) {
			qPos.add(cod_fiscale);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(prenotazione);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Prenotazione> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the prenotaziones where cod_fiscale = &#63; from the database.
	 *
	 * @param cod_fiscale the cod_fiscale
	 */
	@Override
	public void removeByCodFiscale(String cod_fiscale) {
		for (Prenotazione prenotazione : findByCodFiscale(cod_fiscale,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(prenotazione);
		}
	}

	/**
	 * Returns the number of prenotaziones where cod_fiscale = &#63;.
	 *
	 * @param cod_fiscale the cod_fiscale
	 * @return the number of matching prenotaziones
	 */
	@Override
	public int countByCodFiscale(String cod_fiscale) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODFISCALE;

		Object[] finderArgs = new Object[] { cod_fiscale };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRENOTAZIONE_WHERE);

			boolean bindCod_fiscale = false;

			if (cod_fiscale == null) {
				query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_1);
			}
			else if (cod_fiscale.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_3);
			}
			else {
				bindCod_fiscale = true;

				query.append(_FINDER_COLUMN_CODFISCALE_COD_FISCALE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCod_fiscale) {
					qPos.add(cod_fiscale);
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

	private static final String _FINDER_COLUMN_CODFISCALE_COD_FISCALE_1 = "prenotazione.cod_fiscale IS NULL";
	private static final String _FINDER_COLUMN_CODFISCALE_COD_FISCALE_2 = "prenotazione.cod_fiscale = ?";
	private static final String _FINDER_COLUMN_CODFISCALE_COD_FISCALE_3 = "(prenotazione.cod_fiscale IS NULL OR prenotazione.cod_fiscale = '')";

	public PrenotazionePersistenceImpl() {
		setModelClass(Prenotazione.class);
	}

	/**
	 * Caches the prenotazione in the entity cache if it is enabled.
	 *
	 * @param prenotazione the prenotazione
	 */
	@Override
	public void cacheResult(Prenotazione prenotazione) {
		entityCache.putResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneImpl.class, prenotazione.getPrimaryKey(), prenotazione);

		prenotazione.resetOriginalValues();
	}

	/**
	 * Caches the prenotaziones in the entity cache if it is enabled.
	 *
	 * @param prenotaziones the prenotaziones
	 */
	@Override
	public void cacheResult(List<Prenotazione> prenotaziones) {
		for (Prenotazione prenotazione : prenotaziones) {
			if (entityCache.getResult(
						PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
						PrenotazioneImpl.class, prenotazione.getPrimaryKey()) == null) {
				cacheResult(prenotazione);
			}
			else {
				prenotazione.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all prenotaziones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PrenotazioneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the prenotazione.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Prenotazione prenotazione) {
		entityCache.removeResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneImpl.class, prenotazione.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Prenotazione> prenotaziones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Prenotazione prenotazione : prenotaziones) {
			entityCache.removeResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
				PrenotazioneImpl.class, prenotazione.getPrimaryKey());
		}
	}

	/**
	 * Creates a new prenotazione with the primary key. Does not add the prenotazione to the database.
	 *
	 * @param id_prenota the primary key for the new prenotazione
	 * @return the new prenotazione
	 */
	@Override
	public Prenotazione create(long id_prenota) {
		Prenotazione prenotazione = new PrenotazioneImpl();

		prenotazione.setNew(true);
		prenotazione.setPrimaryKey(id_prenota);

		return prenotazione;
	}

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_prenota the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione remove(long id_prenota)
		throws NoSuchPrenotazioneException {
		return remove((Serializable)id_prenota);
	}

	/**
	 * Removes the prenotazione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the prenotazione
	 * @return the prenotazione that was removed
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione remove(Serializable primaryKey)
		throws NoSuchPrenotazioneException {
		Session session = null;

		try {
			session = openSession();

			Prenotazione prenotazione = (Prenotazione)session.get(PrenotazioneImpl.class,
					primaryKey);

			if (prenotazione == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrenotazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(prenotazione);
		}
		catch (NoSuchPrenotazioneException nsee) {
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
	protected Prenotazione removeImpl(Prenotazione prenotazione) {
		prenotazione = toUnwrappedModel(prenotazione);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(prenotazione)) {
				prenotazione = (Prenotazione)session.get(PrenotazioneImpl.class,
						prenotazione.getPrimaryKeyObj());
			}

			if (prenotazione != null) {
				session.delete(prenotazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (prenotazione != null) {
			clearCache(prenotazione);
		}

		return prenotazione;
	}

	@Override
	public Prenotazione updateImpl(Prenotazione prenotazione) {
		prenotazione = toUnwrappedModel(prenotazione);

		boolean isNew = prenotazione.isNew();

		PrenotazioneModelImpl prenotazioneModelImpl = (PrenotazioneModelImpl)prenotazione;

		Session session = null;

		try {
			session = openSession();

			if (prenotazione.isNew()) {
				session.save(prenotazione);

				prenotazione.setNew(false);
			}
			else {
				prenotazione = (Prenotazione)session.merge(prenotazione);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PrenotazioneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((prenotazioneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODFISCALE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						prenotazioneModelImpl.getOriginalCod_fiscale()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CODFISCALE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODFISCALE,
					args);

				args = new Object[] { prenotazioneModelImpl.getCod_fiscale() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CODFISCALE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODFISCALE,
					args);
			}
		}

		entityCache.putResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
			PrenotazioneImpl.class, prenotazione.getPrimaryKey(), prenotazione,
			false);

		prenotazione.resetOriginalValues();

		return prenotazione;
	}

	protected Prenotazione toUnwrappedModel(Prenotazione prenotazione) {
		if (prenotazione instanceof PrenotazioneImpl) {
			return prenotazione;
		}

		PrenotazioneImpl prenotazioneImpl = new PrenotazioneImpl();

		prenotazioneImpl.setNew(prenotazione.isNew());
		prenotazioneImpl.setPrimaryKey(prenotazione.getPrimaryKey());

		prenotazioneImpl.setId_prenota(prenotazione.getId_prenota());
		prenotazioneImpl.setId_sala(prenotazione.getId_sala());
		prenotazioneImpl.setCod_fiscale(prenotazione.getCod_fiscale());
		prenotazioneImpl.setData_prenota(prenotazione.getData_prenota());
		prenotazioneImpl.setData_inizio(prenotazione.getData_inizio());
		prenotazioneImpl.setData_fine(prenotazione.getData_fine());
		prenotazioneImpl.setPartecipanti(prenotazione.getPartecipanti());
		prenotazioneImpl.setId_evento(prenotazione.getId_evento());
		prenotazioneImpl.setAttivita(prenotazione.getAttivita());
		prenotazioneImpl.setNote(prenotazione.getNote());
		prenotazioneImpl.setId_stato(prenotazione.getId_stato());
		prenotazioneImpl.setDati_rich(prenotazione.getDati_rich());
		prenotazioneImpl.setServizi(prenotazione.getServizi());

		return prenotazioneImpl;
	}

	/**
	 * Returns the prenotazione with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrenotazioneException {
		Prenotazione prenotazione = fetchByPrimaryKey(primaryKey);

		if (prenotazione == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrenotazioneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return prenotazione;
	}

	/**
	 * Returns the prenotazione with the primary key or throws a {@link NoSuchPrenotazioneException} if it could not be found.
	 *
	 * @param id_prenota the primary key of the prenotazione
	 * @return the prenotazione
	 * @throws NoSuchPrenotazioneException if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione findByPrimaryKey(long id_prenota)
		throws NoSuchPrenotazioneException {
		return findByPrimaryKey((Serializable)id_prenota);
	}

	/**
	 * Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the prenotazione
	 * @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
				PrenotazioneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Prenotazione prenotazione = (Prenotazione)serializable;

		if (prenotazione == null) {
			Session session = null;

			try {
				session = openSession();

				prenotazione = (Prenotazione)session.get(PrenotazioneImpl.class,
						primaryKey);

				if (prenotazione != null) {
					cacheResult(prenotazione);
				}
				else {
					entityCache.putResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
						PrenotazioneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
					PrenotazioneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return prenotazione;
	}

	/**
	 * Returns the prenotazione with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_prenota the primary key of the prenotazione
	 * @return the prenotazione, or <code>null</code> if a prenotazione with the primary key could not be found
	 */
	@Override
	public Prenotazione fetchByPrimaryKey(long id_prenota) {
		return fetchByPrimaryKey((Serializable)id_prenota);
	}

	@Override
	public Map<Serializable, Prenotazione> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Prenotazione> map = new HashMap<Serializable, Prenotazione>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Prenotazione prenotazione = fetchByPrimaryKey(primaryKey);

			if (prenotazione != null) {
				map.put(primaryKey, prenotazione);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
					PrenotazioneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Prenotazione)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PRENOTAZIONE_WHERE_PKS_IN);

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

			for (Prenotazione prenotazione : (List<Prenotazione>)q.list()) {
				map.put(prenotazione.getPrimaryKeyObj(), prenotazione);

				cacheResult(prenotazione);

				uncachedPrimaryKeys.remove(prenotazione.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PrenotazioneModelImpl.ENTITY_CACHE_ENABLED,
					PrenotazioneImpl.class, primaryKey, nullModel);
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
	 * Returns all the prenotaziones.
	 *
	 * @return the prenotaziones
	 */
	@Override
	public List<Prenotazione> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @return the range of prenotaziones
	 */
	@Override
	public List<Prenotazione> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of prenotaziones
	 */
	@Override
	public List<Prenotazione> findAll(int start, int end,
		OrderByComparator<Prenotazione> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the prenotaziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PrenotazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of prenotaziones
	 * @param end the upper bound of the range of prenotaziones (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of prenotaziones
	 */
	@Override
	public List<Prenotazione> findAll(int start, int end,
		OrderByComparator<Prenotazione> orderByComparator,
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

		List<Prenotazione> list = null;

		if (retrieveFromCache) {
			list = (List<Prenotazione>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRENOTAZIONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRENOTAZIONE;

				if (pagination) {
					sql = sql.concat(PrenotazioneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Prenotazione>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Prenotazione>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the prenotaziones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Prenotazione prenotazione : findAll()) {
			remove(prenotazione);
		}
	}

	/**
	 * Returns the number of prenotaziones.
	 *
	 * @return the number of prenotaziones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRENOTAZIONE);

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
		return PrenotazioneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the prenotazione persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PrenotazioneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PRENOTAZIONE = "SELECT prenotazione FROM Prenotazione prenotazione";
	private static final String _SQL_SELECT_PRENOTAZIONE_WHERE_PKS_IN = "SELECT prenotazione FROM Prenotazione prenotazione WHERE id_prenota IN (";
	private static final String _SQL_SELECT_PRENOTAZIONE_WHERE = "SELECT prenotazione FROM Prenotazione prenotazione WHERE ";
	private static final String _SQL_COUNT_PRENOTAZIONE = "SELECT COUNT(prenotazione) FROM Prenotazione prenotazione";
	private static final String _SQL_COUNT_PRENOTAZIONE_WHERE = "SELECT COUNT(prenotazione) FROM Prenotazione prenotazione WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "prenotazione.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Prenotazione exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Prenotazione exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PrenotazionePersistenceImpl.class);
}