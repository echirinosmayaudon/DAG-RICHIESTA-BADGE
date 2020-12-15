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

package servizio.beni.facile.consumo.service.persistence.impl;

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

import servizio.beni.facile.consumo.exception.NoSuchCambioStatoDirigenteException;
import servizio.beni.facile.consumo.model.CambioStatoDirigente;
import servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteImpl;
import servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteModelImpl;
import servizio.beni.facile.consumo.service.persistence.CambioStatoDirigentePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the cambio stato dirigente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigentePersistence
 * @see servizio.beni.facile.consumo.service.persistence.CambioStatoDirigenteUtil
 * @generated
 */
@ProviderType
public class CambioStatoDirigentePersistenceImpl extends BasePersistenceImpl<CambioStatoDirigente>
	implements CambioStatoDirigentePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CambioStatoDirigenteUtil} to access the cambio stato dirigente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CambioStatoDirigenteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteModelImpl.FINDER_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteModelImpl.FINDER_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteModelImpl.FINDER_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIdRichiesta",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA =
		new FinderPath(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteModelImpl.FINDER_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIdRichiesta",
			new String[] { Long.class.getName() },
			CambioStatoDirigenteModelImpl.ID_RICH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDRICHIESTA = new FinderPath(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdRichiesta",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cambio stato dirigentes where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @return the matching cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findByIdRichiesta(long id_rich) {
		return findByIdRichiesta(id_rich, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cambio stato dirigentes where id_rich = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_rich the id_rich
	 * @param start the lower bound of the range of cambio stato dirigentes
	 * @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	 * @return the range of matching cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findByIdRichiesta(long id_rich,
		int start, int end) {
		return findByIdRichiesta(id_rich, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cambio stato dirigentes where id_rich = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_rich the id_rich
	 * @param start the lower bound of the range of cambio stato dirigentes
	 * @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findByIdRichiesta(long id_rich,
		int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return findByIdRichiesta(id_rich, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cambio stato dirigentes where id_rich = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param id_rich the id_rich
	 * @param start the lower bound of the range of cambio stato dirigentes
	 * @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findByIdRichiesta(long id_rich,
		int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] { id_rich };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDRICHIESTA;
			finderArgs = new Object[] { id_rich, start, end, orderByComparator };
		}

		List<CambioStatoDirigente> list = null;

		if (retrieveFromCache) {
			list = (List<CambioStatoDirigente>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CambioStatoDirigente cambioStatoDirigente : list) {
					if ((id_rich != cambioStatoDirigente.getId_rich())) {
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

			query.append(_SQL_SELECT_CAMBIOSTATODIRIGENTE_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CambioStatoDirigenteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_rich);

				if (!pagination) {
					list = (List<CambioStatoDirigente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CambioStatoDirigente>)QueryUtil.list(q,
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
	 * Returns the first cambio stato dirigente in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cambio stato dirigente
	 * @throws NoSuchCambioStatoDirigenteException if a matching cambio stato dirigente could not be found
	 */
	@Override
	public CambioStatoDirigente findByIdRichiesta_First(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws NoSuchCambioStatoDirigenteException {
		CambioStatoDirigente cambioStatoDirigente = fetchByIdRichiesta_First(id_rich,
				orderByComparator);

		if (cambioStatoDirigente != null) {
			return cambioStatoDirigente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_rich=");
		msg.append(id_rich);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCambioStatoDirigenteException(msg.toString());
	}

	/**
	 * Returns the first cambio stato dirigente in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cambio stato dirigente, or <code>null</code> if a matching cambio stato dirigente could not be found
	 */
	@Override
	public CambioStatoDirigente fetchByIdRichiesta_First(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		List<CambioStatoDirigente> list = findByIdRichiesta(id_rich, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cambio stato dirigente in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cambio stato dirigente
	 * @throws NoSuchCambioStatoDirigenteException if a matching cambio stato dirigente could not be found
	 */
	@Override
	public CambioStatoDirigente findByIdRichiesta_Last(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws NoSuchCambioStatoDirigenteException {
		CambioStatoDirigente cambioStatoDirigente = fetchByIdRichiesta_Last(id_rich,
				orderByComparator);

		if (cambioStatoDirigente != null) {
			return cambioStatoDirigente;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("id_rich=");
		msg.append(id_rich);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCambioStatoDirigenteException(msg.toString());
	}

	/**
	 * Returns the last cambio stato dirigente in the ordered set where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cambio stato dirigente, or <code>null</code> if a matching cambio stato dirigente could not be found
	 */
	@Override
	public CambioStatoDirigente fetchByIdRichiesta_Last(long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		int count = countByIdRichiesta(id_rich);

		if (count == 0) {
			return null;
		}

		List<CambioStatoDirigente> list = findByIdRichiesta(id_rich, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cambio stato dirigentes before and after the current cambio stato dirigente in the ordered set where id_rich = &#63;.
	 *
	 * @param id the primary key of the current cambio stato dirigente
	 * @param id_rich the id_rich
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cambio stato dirigente
	 * @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente[] findByIdRichiesta_PrevAndNext(long id,
		long id_rich, OrderByComparator<CambioStatoDirigente> orderByComparator)
		throws NoSuchCambioStatoDirigenteException {
		CambioStatoDirigente cambioStatoDirigente = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CambioStatoDirigente[] array = new CambioStatoDirigenteImpl[3];

			array[0] = getByIdRichiesta_PrevAndNext(session,
					cambioStatoDirigente, id_rich, orderByComparator, true);

			array[1] = cambioStatoDirigente;

			array[2] = getByIdRichiesta_PrevAndNext(session,
					cambioStatoDirigente, id_rich, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CambioStatoDirigente getByIdRichiesta_PrevAndNext(
		Session session, CambioStatoDirigente cambioStatoDirigente,
		long id_rich,
		OrderByComparator<CambioStatoDirigente> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMBIOSTATODIRIGENTE_WHERE);

		query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICH_2);

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
			query.append(CambioStatoDirigenteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(id_rich);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cambioStatoDirigente);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CambioStatoDirigente> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cambio stato dirigentes where id_rich = &#63; from the database.
	 *
	 * @param id_rich the id_rich
	 */
	@Override
	public void removeByIdRichiesta(long id_rich) {
		for (CambioStatoDirigente cambioStatoDirigente : findByIdRichiesta(
				id_rich, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cambioStatoDirigente);
		}
	}

	/**
	 * Returns the number of cambio stato dirigentes where id_rich = &#63;.
	 *
	 * @param id_rich the id_rich
	 * @return the number of matching cambio stato dirigentes
	 */
	@Override
	public int countByIdRichiesta(long id_rich) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDRICHIESTA;

		Object[] finderArgs = new Object[] { id_rich };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMBIOSTATODIRIGENTE_WHERE);

			query.append(_FINDER_COLUMN_IDRICHIESTA_ID_RICH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id_rich);

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

	private static final String _FINDER_COLUMN_IDRICHIESTA_ID_RICH_2 = "cambioStatoDirigente.id_rich = ?";

	public CambioStatoDirigentePersistenceImpl() {
		setModelClass(CambioStatoDirigente.class);
	}

	/**
	 * Caches the cambio stato dirigente in the entity cache if it is enabled.
	 *
	 * @param cambioStatoDirigente the cambio stato dirigente
	 */
	@Override
	public void cacheResult(CambioStatoDirigente cambioStatoDirigente) {
		entityCache.putResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class,
			cambioStatoDirigente.getPrimaryKey(), cambioStatoDirigente);

		cambioStatoDirigente.resetOriginalValues();
	}

	/**
	 * Caches the cambio stato dirigentes in the entity cache if it is enabled.
	 *
	 * @param cambioStatoDirigentes the cambio stato dirigentes
	 */
	@Override
	public void cacheResult(List<CambioStatoDirigente> cambioStatoDirigentes) {
		for (CambioStatoDirigente cambioStatoDirigente : cambioStatoDirigentes) {
			if (entityCache.getResult(
						CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
						CambioStatoDirigenteImpl.class,
						cambioStatoDirigente.getPrimaryKey()) == null) {
				cacheResult(cambioStatoDirigente);
			}
			else {
				cambioStatoDirigente.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cambio stato dirigentes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CambioStatoDirigenteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cambio stato dirigente.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CambioStatoDirigente cambioStatoDirigente) {
		entityCache.removeResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class, cambioStatoDirigente.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CambioStatoDirigente> cambioStatoDirigentes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CambioStatoDirigente cambioStatoDirigente : cambioStatoDirigentes) {
			entityCache.removeResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
				CambioStatoDirigenteImpl.class,
				cambioStatoDirigente.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cambio stato dirigente with the primary key. Does not add the cambio stato dirigente to the database.
	 *
	 * @param id the primary key for the new cambio stato dirigente
	 * @return the new cambio stato dirigente
	 */
	@Override
	public CambioStatoDirigente create(long id) {
		CambioStatoDirigente cambioStatoDirigente = new CambioStatoDirigenteImpl();

		cambioStatoDirigente.setNew(true);
		cambioStatoDirigente.setPrimaryKey(id);

		return cambioStatoDirigente;
	}

	/**
	 * Removes the cambio stato dirigente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cambio stato dirigente
	 * @return the cambio stato dirigente that was removed
	 * @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente remove(long id)
		throws NoSuchCambioStatoDirigenteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cambio stato dirigente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cambio stato dirigente
	 * @return the cambio stato dirigente that was removed
	 * @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente remove(Serializable primaryKey)
		throws NoSuchCambioStatoDirigenteException {
		Session session = null;

		try {
			session = openSession();

			CambioStatoDirigente cambioStatoDirigente = (CambioStatoDirigente)session.get(CambioStatoDirigenteImpl.class,
					primaryKey);

			if (cambioStatoDirigente == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCambioStatoDirigenteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cambioStatoDirigente);
		}
		catch (NoSuchCambioStatoDirigenteException nsee) {
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
	protected CambioStatoDirigente removeImpl(
		CambioStatoDirigente cambioStatoDirigente) {
		cambioStatoDirigente = toUnwrappedModel(cambioStatoDirigente);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cambioStatoDirigente)) {
				cambioStatoDirigente = (CambioStatoDirigente)session.get(CambioStatoDirigenteImpl.class,
						cambioStatoDirigente.getPrimaryKeyObj());
			}

			if (cambioStatoDirigente != null) {
				session.delete(cambioStatoDirigente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cambioStatoDirigente != null) {
			clearCache(cambioStatoDirigente);
		}

		return cambioStatoDirigente;
	}

	@Override
	public CambioStatoDirigente updateImpl(
		CambioStatoDirigente cambioStatoDirigente) {
		cambioStatoDirigente = toUnwrappedModel(cambioStatoDirigente);

		boolean isNew = cambioStatoDirigente.isNew();

		CambioStatoDirigenteModelImpl cambioStatoDirigenteModelImpl = (CambioStatoDirigenteModelImpl)cambioStatoDirigente;

		Session session = null;

		try {
			session = openSession();

			if (cambioStatoDirigente.isNew()) {
				session.save(cambioStatoDirigente);

				cambioStatoDirigente.setNew(false);
			}
			else {
				cambioStatoDirigente = (CambioStatoDirigente)session.merge(cambioStatoDirigente);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CambioStatoDirigenteModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cambioStatoDirigenteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cambioStatoDirigenteModelImpl.getOriginalId_rich()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);

				args = new Object[] { cambioStatoDirigenteModelImpl.getId_rich() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_IDRICHIESTA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDRICHIESTA,
					args);
			}
		}

		entityCache.putResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
			CambioStatoDirigenteImpl.class,
			cambioStatoDirigente.getPrimaryKey(), cambioStatoDirigente, false);

		cambioStatoDirigente.resetOriginalValues();

		return cambioStatoDirigente;
	}

	protected CambioStatoDirigente toUnwrappedModel(
		CambioStatoDirigente cambioStatoDirigente) {
		if (cambioStatoDirigente instanceof CambioStatoDirigenteImpl) {
			return cambioStatoDirigente;
		}

		CambioStatoDirigenteImpl cambioStatoDirigenteImpl = new CambioStatoDirigenteImpl();

		cambioStatoDirigenteImpl.setNew(cambioStatoDirigente.isNew());
		cambioStatoDirigenteImpl.setPrimaryKey(cambioStatoDirigente.getPrimaryKey());

		cambioStatoDirigenteImpl.setId(cambioStatoDirigente.getId());
		cambioStatoDirigenteImpl.setId_rich(cambioStatoDirigente.getId_rich());
		cambioStatoDirigenteImpl.setData(cambioStatoDirigente.getData());
		cambioStatoDirigenteImpl.setUtente(cambioStatoDirigente.getUtente());
		cambioStatoDirigenteImpl.setId_stato(cambioStatoDirigente.getId_stato());
		cambioStatoDirigenteImpl.setNote(cambioStatoDirigente.getNote());

		return cambioStatoDirigenteImpl;
	}

	/**
	 * Returns the cambio stato dirigente with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cambio stato dirigente
	 * @return the cambio stato dirigente
	 * @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCambioStatoDirigenteException {
		CambioStatoDirigente cambioStatoDirigente = fetchByPrimaryKey(primaryKey);

		if (cambioStatoDirigente == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCambioStatoDirigenteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cambioStatoDirigente;
	}

	/**
	 * Returns the cambio stato dirigente with the primary key or throws a {@link NoSuchCambioStatoDirigenteException} if it could not be found.
	 *
	 * @param id the primary key of the cambio stato dirigente
	 * @return the cambio stato dirigente
	 * @throws NoSuchCambioStatoDirigenteException if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente findByPrimaryKey(long id)
		throws NoSuchCambioStatoDirigenteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cambio stato dirigente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cambio stato dirigente
	 * @return the cambio stato dirigente, or <code>null</code> if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
				CambioStatoDirigenteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CambioStatoDirigente cambioStatoDirigente = (CambioStatoDirigente)serializable;

		if (cambioStatoDirigente == null) {
			Session session = null;

			try {
				session = openSession();

				cambioStatoDirigente = (CambioStatoDirigente)session.get(CambioStatoDirigenteImpl.class,
						primaryKey);

				if (cambioStatoDirigente != null) {
					cacheResult(cambioStatoDirigente);
				}
				else {
					entityCache.putResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
						CambioStatoDirigenteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
					CambioStatoDirigenteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cambioStatoDirigente;
	}

	/**
	 * Returns the cambio stato dirigente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cambio stato dirigente
	 * @return the cambio stato dirigente, or <code>null</code> if a cambio stato dirigente with the primary key could not be found
	 */
	@Override
	public CambioStatoDirigente fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, CambioStatoDirigente> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CambioStatoDirigente> map = new HashMap<Serializable, CambioStatoDirigente>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CambioStatoDirigente cambioStatoDirigente = fetchByPrimaryKey(primaryKey);

			if (cambioStatoDirigente != null) {
				map.put(primaryKey, cambioStatoDirigente);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
					CambioStatoDirigenteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CambioStatoDirigente)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CAMBIOSTATODIRIGENTE_WHERE_PKS_IN);

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

			for (CambioStatoDirigente cambioStatoDirigente : (List<CambioStatoDirigente>)q.list()) {
				map.put(cambioStatoDirigente.getPrimaryKeyObj(),
					cambioStatoDirigente);

				cacheResult(cambioStatoDirigente);

				uncachedPrimaryKeys.remove(cambioStatoDirigente.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CambioStatoDirigenteModelImpl.ENTITY_CACHE_ENABLED,
					CambioStatoDirigenteImpl.class, primaryKey, nullModel);
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
	 * Returns all the cambio stato dirigentes.
	 *
	 * @return the cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cambio stato dirigentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cambio stato dirigentes
	 * @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	 * @return the range of cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cambio stato dirigentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cambio stato dirigentes
	 * @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findAll(int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cambio stato dirigentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cambio stato dirigentes
	 * @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cambio stato dirigentes
	 */
	@Override
	public List<CambioStatoDirigente> findAll(int start, int end,
		OrderByComparator<CambioStatoDirigente> orderByComparator,
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

		List<CambioStatoDirigente> list = null;

		if (retrieveFromCache) {
			list = (List<CambioStatoDirigente>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CAMBIOSTATODIRIGENTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMBIOSTATODIRIGENTE;

				if (pagination) {
					sql = sql.concat(CambioStatoDirigenteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CambioStatoDirigente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CambioStatoDirigente>)QueryUtil.list(q,
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
	 * Removes all the cambio stato dirigentes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CambioStatoDirigente cambioStatoDirigente : findAll()) {
			remove(cambioStatoDirigente);
		}
	}

	/**
	 * Returns the number of cambio stato dirigentes.
	 *
	 * @return the number of cambio stato dirigentes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAMBIOSTATODIRIGENTE);

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
		return CambioStatoDirigenteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cambio stato dirigente persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CambioStatoDirigenteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CAMBIOSTATODIRIGENTE = "SELECT cambioStatoDirigente FROM CambioStatoDirigente cambioStatoDirigente";
	private static final String _SQL_SELECT_CAMBIOSTATODIRIGENTE_WHERE_PKS_IN = "SELECT cambioStatoDirigente FROM CambioStatoDirigente cambioStatoDirigente WHERE id_ IN (";
	private static final String _SQL_SELECT_CAMBIOSTATODIRIGENTE_WHERE = "SELECT cambioStatoDirigente FROM CambioStatoDirigente cambioStatoDirigente WHERE ";
	private static final String _SQL_COUNT_CAMBIOSTATODIRIGENTE = "SELECT COUNT(cambioStatoDirigente) FROM CambioStatoDirigente cambioStatoDirigente";
	private static final String _SQL_COUNT_CAMBIOSTATODIRIGENTE_WHERE = "SELECT COUNT(cambioStatoDirigente) FROM CambioStatoDirigente cambioStatoDirigente WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cambioStatoDirigente.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CambioStatoDirigente exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CambioStatoDirigente exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CambioStatoDirigentePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "data"
			});
}