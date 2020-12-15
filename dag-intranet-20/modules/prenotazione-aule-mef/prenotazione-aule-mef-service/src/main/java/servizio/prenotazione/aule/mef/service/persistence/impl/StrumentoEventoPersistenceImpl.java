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

import servizio.prenotazione.aule.mef.exception.NoSuchStrumentoEventoException;
import servizio.prenotazione.aule.mef.model.StrumentoEvento;
import servizio.prenotazione.aule.mef.model.impl.StrumentoEventoImpl;
import servizio.prenotazione.aule.mef.model.impl.StrumentoEventoModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.StrumentoEventoPersistence;

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
 * The persistence implementation for the strumento evento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEventoPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.StrumentoEventoUtil
 * @generated
 */
@ProviderType
public class StrumentoEventoPersistenceImpl extends BasePersistenceImpl<StrumentoEvento>
	implements StrumentoEventoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StrumentoEventoUtil} to access the strumento evento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StrumentoEventoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoModelImpl.FINDER_CACHE_ENABLED,
			StrumentoEventoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoModelImpl.FINDER_CACHE_ENABLED,
			StrumentoEventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCSTRUMENTO =
		new FinderPath(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoModelImpl.FINDER_CACHE_ENABLED,
			StrumentoEventoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDescStrumento",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO =
		new FinderPath(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoModelImpl.FINDER_CACHE_ENABLED,
			StrumentoEventoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescStrumento",
			new String[] { String.class.getName() },
			StrumentoEventoModelImpl.DESC_STRUMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCSTRUMENTO = new FinderPath(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescStrumento",
			new String[] { String.class.getName() });

	/**
	 * Returns all the strumento eventos where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @return the matching strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findByDescStrumento(String desc_strumento) {
		return findByDescStrumento(desc_strumento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strumento eventos where desc_strumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_strumento the desc_strumento
	 * @param start the lower bound of the range of strumento eventos
	 * @param end the upper bound of the range of strumento eventos (not inclusive)
	 * @return the range of matching strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findByDescStrumento(String desc_strumento,
		int start, int end) {
		return findByDescStrumento(desc_strumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the strumento eventos where desc_strumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_strumento the desc_strumento
	 * @param start the lower bound of the range of strumento eventos
	 * @param end the upper bound of the range of strumento eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findByDescStrumento(String desc_strumento,
		int start, int end, OrderByComparator<StrumentoEvento> orderByComparator) {
		return findByDescStrumento(desc_strumento, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strumento eventos where desc_strumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_strumento the desc_strumento
	 * @param start the lower bound of the range of strumento eventos
	 * @param end the upper bound of the range of strumento eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findByDescStrumento(String desc_strumento,
		int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO;
			finderArgs = new Object[] { desc_strumento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCSTRUMENTO;
			finderArgs = new Object[] {
					desc_strumento,
					
					start, end, orderByComparator
				};
		}

		List<StrumentoEvento> list = null;

		if (retrieveFromCache) {
			list = (List<StrumentoEvento>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StrumentoEvento strumentoEvento : list) {
					if (!Objects.equals(desc_strumento,
								strumentoEvento.getDesc_strumento())) {
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

			query.append(_SQL_SELECT_STRUMENTOEVENTO_WHERE);

			boolean bindDesc_strumento = false;

			if (desc_strumento == null) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1);
			}
			else if (desc_strumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3);
			}
			else {
				bindDesc_strumento = true;

				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StrumentoEventoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesc_strumento) {
					qPos.add(desc_strumento);
				}

				if (!pagination) {
					list = (List<StrumentoEvento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StrumentoEvento>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first strumento evento in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strumento evento
	 * @throws NoSuchStrumentoEventoException if a matching strumento evento could not be found
	 */
	@Override
	public StrumentoEvento findByDescStrumento_First(String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator)
		throws NoSuchStrumentoEventoException {
		StrumentoEvento strumentoEvento = fetchByDescStrumento_First(desc_strumento,
				orderByComparator);

		if (strumentoEvento != null) {
			return strumentoEvento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("desc_strumento=");
		msg.append(desc_strumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStrumentoEventoException(msg.toString());
	}

	/**
	 * Returns the first strumento evento in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strumento evento, or <code>null</code> if a matching strumento evento could not be found
	 */
	@Override
	public StrumentoEvento fetchByDescStrumento_First(String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		List<StrumentoEvento> list = findByDescStrumento(desc_strumento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last strumento evento in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strumento evento
	 * @throws NoSuchStrumentoEventoException if a matching strumento evento could not be found
	 */
	@Override
	public StrumentoEvento findByDescStrumento_Last(String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator)
		throws NoSuchStrumentoEventoException {
		StrumentoEvento strumentoEvento = fetchByDescStrumento_Last(desc_strumento,
				orderByComparator);

		if (strumentoEvento != null) {
			return strumentoEvento;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("desc_strumento=");
		msg.append(desc_strumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStrumentoEventoException(msg.toString());
	}

	/**
	 * Returns the last strumento evento in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strumento evento, or <code>null</code> if a matching strumento evento could not be found
	 */
	@Override
	public StrumentoEvento fetchByDescStrumento_Last(String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		int count = countByDescStrumento(desc_strumento);

		if (count == 0) {
			return null;
		}

		List<StrumentoEvento> list = findByDescStrumento(desc_strumento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the strumento eventos before and after the current strumento evento in the ordered set where desc_strumento = &#63;.
	 *
	 * @param id_strumento the primary key of the current strumento evento
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next strumento evento
	 * @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento[] findByDescStrumento_PrevAndNext(
		long id_strumento, String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator)
		throws NoSuchStrumentoEventoException {
		StrumentoEvento strumentoEvento = findByPrimaryKey(id_strumento);

		Session session = null;

		try {
			session = openSession();

			StrumentoEvento[] array = new StrumentoEventoImpl[3];

			array[0] = getByDescStrumento_PrevAndNext(session, strumentoEvento,
					desc_strumento, orderByComparator, true);

			array[1] = strumentoEvento;

			array[2] = getByDescStrumento_PrevAndNext(session, strumentoEvento,
					desc_strumento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StrumentoEvento getByDescStrumento_PrevAndNext(Session session,
		StrumentoEvento strumentoEvento, String desc_strumento,
		OrderByComparator<StrumentoEvento> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STRUMENTOEVENTO_WHERE);

		boolean bindDesc_strumento = false;

		if (desc_strumento == null) {
			query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1);
		}
		else if (desc_strumento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3);
		}
		else {
			bindDesc_strumento = true;

			query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2);
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
			query.append(StrumentoEventoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDesc_strumento) {
			qPos.add(desc_strumento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(strumentoEvento);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StrumentoEvento> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the strumento eventos where desc_strumento = &#63; from the database.
	 *
	 * @param desc_strumento the desc_strumento
	 */
	@Override
	public void removeByDescStrumento(String desc_strumento) {
		for (StrumentoEvento strumentoEvento : findByDescStrumento(
				desc_strumento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(strumentoEvento);
		}
	}

	/**
	 * Returns the number of strumento eventos where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @return the number of matching strumento eventos
	 */
	@Override
	public int countByDescStrumento(String desc_strumento) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCSTRUMENTO;

		Object[] finderArgs = new Object[] { desc_strumento };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STRUMENTOEVENTO_WHERE);

			boolean bindDesc_strumento = false;

			if (desc_strumento == null) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1);
			}
			else if (desc_strumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3);
			}
			else {
				bindDesc_strumento = true;

				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesc_strumento) {
					qPos.add(desc_strumento);
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

	private static final String _FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1 = "strumentoEvento.desc_strumento IS NULL";
	private static final String _FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2 = "strumentoEvento.desc_strumento = ?";
	private static final String _FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3 = "(strumentoEvento.desc_strumento IS NULL OR strumentoEvento.desc_strumento = '')";

	public StrumentoEventoPersistenceImpl() {
		setModelClass(StrumentoEvento.class);
	}

	/**
	 * Caches the strumento evento in the entity cache if it is enabled.
	 *
	 * @param strumentoEvento the strumento evento
	 */
	@Override
	public void cacheResult(StrumentoEvento strumentoEvento) {
		entityCache.putResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoImpl.class, strumentoEvento.getPrimaryKey(),
			strumentoEvento);

		strumentoEvento.resetOriginalValues();
	}

	/**
	 * Caches the strumento eventos in the entity cache if it is enabled.
	 *
	 * @param strumentoEventos the strumento eventos
	 */
	@Override
	public void cacheResult(List<StrumentoEvento> strumentoEventos) {
		for (StrumentoEvento strumentoEvento : strumentoEventos) {
			if (entityCache.getResult(
						StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
						StrumentoEventoImpl.class,
						strumentoEvento.getPrimaryKey()) == null) {
				cacheResult(strumentoEvento);
			}
			else {
				strumentoEvento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all strumento eventos.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StrumentoEventoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the strumento evento.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StrumentoEvento strumentoEvento) {
		entityCache.removeResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoImpl.class, strumentoEvento.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StrumentoEvento> strumentoEventos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StrumentoEvento strumentoEvento : strumentoEventos) {
			entityCache.removeResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
				StrumentoEventoImpl.class, strumentoEvento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new strumento evento with the primary key. Does not add the strumento evento to the database.
	 *
	 * @param id_strumento the primary key for the new strumento evento
	 * @return the new strumento evento
	 */
	@Override
	public StrumentoEvento create(long id_strumento) {
		StrumentoEvento strumentoEvento = new StrumentoEventoImpl();

		strumentoEvento.setNew(true);
		strumentoEvento.setPrimaryKey(id_strumento);

		return strumentoEvento;
	}

	/**
	 * Removes the strumento evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_strumento the primary key of the strumento evento
	 * @return the strumento evento that was removed
	 * @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento remove(long id_strumento)
		throws NoSuchStrumentoEventoException {
		return remove((Serializable)id_strumento);
	}

	/**
	 * Removes the strumento evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the strumento evento
	 * @return the strumento evento that was removed
	 * @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento remove(Serializable primaryKey)
		throws NoSuchStrumentoEventoException {
		Session session = null;

		try {
			session = openSession();

			StrumentoEvento strumentoEvento = (StrumentoEvento)session.get(StrumentoEventoImpl.class,
					primaryKey);

			if (strumentoEvento == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStrumentoEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(strumentoEvento);
		}
		catch (NoSuchStrumentoEventoException nsee) {
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
	protected StrumentoEvento removeImpl(StrumentoEvento strumentoEvento) {
		strumentoEvento = toUnwrappedModel(strumentoEvento);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(strumentoEvento)) {
				strumentoEvento = (StrumentoEvento)session.get(StrumentoEventoImpl.class,
						strumentoEvento.getPrimaryKeyObj());
			}

			if (strumentoEvento != null) {
				session.delete(strumentoEvento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (strumentoEvento != null) {
			clearCache(strumentoEvento);
		}

		return strumentoEvento;
	}

	@Override
	public StrumentoEvento updateImpl(StrumentoEvento strumentoEvento) {
		strumentoEvento = toUnwrappedModel(strumentoEvento);

		boolean isNew = strumentoEvento.isNew();

		StrumentoEventoModelImpl strumentoEventoModelImpl = (StrumentoEventoModelImpl)strumentoEvento;

		Session session = null;

		try {
			session = openSession();

			if (strumentoEvento.isNew()) {
				session.save(strumentoEvento);

				strumentoEvento.setNew(false);
			}
			else {
				strumentoEvento = (StrumentoEvento)session.merge(strumentoEvento);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StrumentoEventoModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((strumentoEventoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						strumentoEventoModelImpl.getOriginalDesc_strumento()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCSTRUMENTO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO,
					args);

				args = new Object[] { strumentoEventoModelImpl.getDesc_strumento() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCSTRUMENTO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO,
					args);
			}
		}

		entityCache.putResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoEventoImpl.class, strumentoEvento.getPrimaryKey(),
			strumentoEvento, false);

		strumentoEvento.resetOriginalValues();

		return strumentoEvento;
	}

	protected StrumentoEvento toUnwrappedModel(StrumentoEvento strumentoEvento) {
		if (strumentoEvento instanceof StrumentoEventoImpl) {
			return strumentoEvento;
		}

		StrumentoEventoImpl strumentoEventoImpl = new StrumentoEventoImpl();

		strumentoEventoImpl.setNew(strumentoEvento.isNew());
		strumentoEventoImpl.setPrimaryKey(strumentoEvento.getPrimaryKey());

		strumentoEventoImpl.setId_strumento(strumentoEvento.getId_strumento());
		strumentoEventoImpl.setDesc_strumento(strumentoEvento.getDesc_strumento());
		strumentoEventoImpl.setEmail_ref(strumentoEvento.getEmail_ref());

		return strumentoEventoImpl;
	}

	/**
	 * Returns the strumento evento with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the strumento evento
	 * @return the strumento evento
	 * @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStrumentoEventoException {
		StrumentoEvento strumentoEvento = fetchByPrimaryKey(primaryKey);

		if (strumentoEvento == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStrumentoEventoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return strumentoEvento;
	}

	/**
	 * Returns the strumento evento with the primary key or throws a {@link NoSuchStrumentoEventoException} if it could not be found.
	 *
	 * @param id_strumento the primary key of the strumento evento
	 * @return the strumento evento
	 * @throws NoSuchStrumentoEventoException if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento findByPrimaryKey(long id_strumento)
		throws NoSuchStrumentoEventoException {
		return findByPrimaryKey((Serializable)id_strumento);
	}

	/**
	 * Returns the strumento evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the strumento evento
	 * @return the strumento evento, or <code>null</code> if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
				StrumentoEventoImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StrumentoEvento strumentoEvento = (StrumentoEvento)serializable;

		if (strumentoEvento == null) {
			Session session = null;

			try {
				session = openSession();

				strumentoEvento = (StrumentoEvento)session.get(StrumentoEventoImpl.class,
						primaryKey);

				if (strumentoEvento != null) {
					cacheResult(strumentoEvento);
				}
				else {
					entityCache.putResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
						StrumentoEventoImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
					StrumentoEventoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return strumentoEvento;
	}

	/**
	 * Returns the strumento evento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_strumento the primary key of the strumento evento
	 * @return the strumento evento, or <code>null</code> if a strumento evento with the primary key could not be found
	 */
	@Override
	public StrumentoEvento fetchByPrimaryKey(long id_strumento) {
		return fetchByPrimaryKey((Serializable)id_strumento);
	}

	@Override
	public Map<Serializable, StrumentoEvento> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StrumentoEvento> map = new HashMap<Serializable, StrumentoEvento>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StrumentoEvento strumentoEvento = fetchByPrimaryKey(primaryKey);

			if (strumentoEvento != null) {
				map.put(primaryKey, strumentoEvento);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
					StrumentoEventoImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StrumentoEvento)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STRUMENTOEVENTO_WHERE_PKS_IN);

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

			for (StrumentoEvento strumentoEvento : (List<StrumentoEvento>)q.list()) {
				map.put(strumentoEvento.getPrimaryKeyObj(), strumentoEvento);

				cacheResult(strumentoEvento);

				uncachedPrimaryKeys.remove(strumentoEvento.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StrumentoEventoModelImpl.ENTITY_CACHE_ENABLED,
					StrumentoEventoImpl.class, primaryKey, nullModel);
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
	 * Returns all the strumento eventos.
	 *
	 * @return the strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strumento eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strumento eventos
	 * @param end the upper bound of the range of strumento eventos (not inclusive)
	 * @return the range of strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the strumento eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strumento eventos
	 * @param end the upper bound of the range of strumento eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findAll(int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strumento eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strumento eventos
	 * @param end the upper bound of the range of strumento eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of strumento eventos
	 */
	@Override
	public List<StrumentoEvento> findAll(int start, int end,
		OrderByComparator<StrumentoEvento> orderByComparator,
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

		List<StrumentoEvento> list = null;

		if (retrieveFromCache) {
			list = (List<StrumentoEvento>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STRUMENTOEVENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STRUMENTOEVENTO;

				if (pagination) {
					sql = sql.concat(StrumentoEventoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StrumentoEvento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StrumentoEvento>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the strumento eventos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StrumentoEvento strumentoEvento : findAll()) {
			remove(strumentoEvento);
		}
	}

	/**
	 * Returns the number of strumento eventos.
	 *
	 * @return the number of strumento eventos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STRUMENTOEVENTO);

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
		return StrumentoEventoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the strumento evento persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StrumentoEventoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STRUMENTOEVENTO = "SELECT strumentoEvento FROM StrumentoEvento strumentoEvento";
	private static final String _SQL_SELECT_STRUMENTOEVENTO_WHERE_PKS_IN = "SELECT strumentoEvento FROM StrumentoEvento strumentoEvento WHERE id_strumento IN (";
	private static final String _SQL_SELECT_STRUMENTOEVENTO_WHERE = "SELECT strumentoEvento FROM StrumentoEvento strumentoEvento WHERE ";
	private static final String _SQL_COUNT_STRUMENTOEVENTO = "SELECT COUNT(strumentoEvento) FROM StrumentoEvento strumentoEvento";
	private static final String _SQL_COUNT_STRUMENTOEVENTO_WHERE = "SELECT COUNT(strumentoEvento) FROM StrumentoEvento strumentoEvento WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "strumentoEvento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StrumentoEvento exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StrumentoEvento exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StrumentoEventoPersistenceImpl.class);
}