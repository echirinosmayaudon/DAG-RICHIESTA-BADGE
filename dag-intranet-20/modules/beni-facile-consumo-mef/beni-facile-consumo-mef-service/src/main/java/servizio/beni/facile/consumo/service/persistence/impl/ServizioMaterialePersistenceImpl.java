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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import servizio.beni.facile.consumo.exception.NoSuchServizioMaterialeException;
import servizio.beni.facile.consumo.model.ServizioMateriale;
import servizio.beni.facile.consumo.model.impl.ServizioMaterialeImpl;
import servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl;
import servizio.beni.facile.consumo.service.persistence.ServizioMaterialePersistence;

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
 * The persistence implementation for the servizio materiale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMaterialePersistence
 * @see servizio.beni.facile.consumo.service.persistence.ServizioMaterialeUtil
 * @generated
 */
@ProviderType
public class ServizioMaterialePersistenceImpl extends BasePersistenceImpl<ServizioMateriale>
	implements ServizioMaterialePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServizioMaterialeUtil} to access the servizio materiale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServizioMaterialeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeModelImpl.FINDER_CACHE_ENABLED,
			ServizioMaterialeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeModelImpl.FINDER_CACHE_ENABLED,
			ServizioMaterialeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORIA =
		new FinderPath(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeModelImpl.FINDER_CACHE_ENABLED,
			ServizioMaterialeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoria",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIA =
		new FinderPath(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeModelImpl.FINDER_CACHE_ENABLED,
			ServizioMaterialeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoria",
			new String[] { String.class.getName() },
			ServizioMaterialeModelImpl.CATEGORIA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORIA = new FinderPath(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoria",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servizio materiales where categoria = &#63;.
	 *
	 * @param categoria the categoria
	 * @return the matching servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findByCategoria(String categoria) {
		return findByCategoria(categoria, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the servizio materiales where categoria = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoria the categoria
	 * @param start the lower bound of the range of servizio materiales
	 * @param end the upper bound of the range of servizio materiales (not inclusive)
	 * @return the range of matching servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findByCategoria(String categoria, int start,
		int end) {
		return findByCategoria(categoria, start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio materiales where categoria = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoria the categoria
	 * @param start the lower bound of the range of servizio materiales
	 * @param end the upper bound of the range of servizio materiales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findByCategoria(String categoria, int start,
		int end, OrderByComparator<ServizioMateriale> orderByComparator) {
		return findByCategoria(categoria, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio materiales where categoria = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoria the categoria
	 * @param start the lower bound of the range of servizio materiales
	 * @param end the upper bound of the range of servizio materiales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findByCategoria(String categoria, int start,
		int end, OrderByComparator<ServizioMateriale> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIA;
			finderArgs = new Object[] { categoria };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORIA;
			finderArgs = new Object[] { categoria, start, end, orderByComparator };
		}

		List<ServizioMateriale> list = null;

		if (retrieveFromCache) {
			list = (List<ServizioMateriale>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServizioMateriale servizioMateriale : list) {
					if (!Objects.equals(categoria,
								servizioMateriale.getCategoria())) {
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

			query.append(_SQL_SELECT_SERVIZIOMATERIALE_WHERE);

			boolean bindCategoria = false;

			if (categoria == null) {
				query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_1);
			}
			else if (categoria.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_3);
			}
			else {
				bindCategoria = true;

				query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServizioMaterialeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoria) {
					qPos.add(categoria);
				}

				if (!pagination) {
					list = (List<ServizioMateriale>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServizioMateriale>)QueryUtil.list(q,
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
	 * Returns the first servizio materiale in the ordered set where categoria = &#63;.
	 *
	 * @param categoria the categoria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio materiale
	 * @throws NoSuchServizioMaterialeException if a matching servizio materiale could not be found
	 */
	@Override
	public ServizioMateriale findByCategoria_First(String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator)
		throws NoSuchServizioMaterialeException {
		ServizioMateriale servizioMateriale = fetchByCategoria_First(categoria,
				orderByComparator);

		if (servizioMateriale != null) {
			return servizioMateriale;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoria=");
		msg.append(categoria);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioMaterialeException(msg.toString());
	}

	/**
	 * Returns the first servizio materiale in the ordered set where categoria = &#63;.
	 *
	 * @param categoria the categoria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching servizio materiale, or <code>null</code> if a matching servizio materiale could not be found
	 */
	@Override
	public ServizioMateriale fetchByCategoria_First(String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		List<ServizioMateriale> list = findByCategoria(categoria, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last servizio materiale in the ordered set where categoria = &#63;.
	 *
	 * @param categoria the categoria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio materiale
	 * @throws NoSuchServizioMaterialeException if a matching servizio materiale could not be found
	 */
	@Override
	public ServizioMateriale findByCategoria_Last(String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator)
		throws NoSuchServizioMaterialeException {
		ServizioMateriale servizioMateriale = fetchByCategoria_Last(categoria,
				orderByComparator);

		if (servizioMateriale != null) {
			return servizioMateriale;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoria=");
		msg.append(categoria);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchServizioMaterialeException(msg.toString());
	}

	/**
	 * Returns the last servizio materiale in the ordered set where categoria = &#63;.
	 *
	 * @param categoria the categoria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching servizio materiale, or <code>null</code> if a matching servizio materiale could not be found
	 */
	@Override
	public ServizioMateriale fetchByCategoria_Last(String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		int count = countByCategoria(categoria);

		if (count == 0) {
			return null;
		}

		List<ServizioMateriale> list = findByCategoria(categoria, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the servizio materiales before and after the current servizio materiale in the ordered set where categoria = &#63;.
	 *
	 * @param gruppo the primary key of the current servizio materiale
	 * @param categoria the categoria
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next servizio materiale
	 * @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale[] findByCategoria_PrevAndNext(String gruppo,
		String categoria, OrderByComparator<ServizioMateriale> orderByComparator)
		throws NoSuchServizioMaterialeException {
		ServizioMateriale servizioMateriale = findByPrimaryKey(gruppo);

		Session session = null;

		try {
			session = openSession();

			ServizioMateriale[] array = new ServizioMaterialeImpl[3];

			array[0] = getByCategoria_PrevAndNext(session, servizioMateriale,
					categoria, orderByComparator, true);

			array[1] = servizioMateriale;

			array[2] = getByCategoria_PrevAndNext(session, servizioMateriale,
					categoria, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServizioMateriale getByCategoria_PrevAndNext(Session session,
		ServizioMateriale servizioMateriale, String categoria,
		OrderByComparator<ServizioMateriale> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVIZIOMATERIALE_WHERE);

		boolean bindCategoria = false;

		if (categoria == null) {
			query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_1);
		}
		else if (categoria.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_3);
		}
		else {
			bindCategoria = true;

			query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_2);
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
			query.append(ServizioMaterialeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategoria) {
			qPos.add(categoria);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(servizioMateriale);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServizioMateriale> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servizio materiales where categoria = &#63; from the database.
	 *
	 * @param categoria the categoria
	 */
	@Override
	public void removeByCategoria(String categoria) {
		for (ServizioMateriale servizioMateriale : findByCategoria(categoria,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(servizioMateriale);
		}
	}

	/**
	 * Returns the number of servizio materiales where categoria = &#63;.
	 *
	 * @param categoria the categoria
	 * @return the number of matching servizio materiales
	 */
	@Override
	public int countByCategoria(String categoria) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORIA;

		Object[] finderArgs = new Object[] { categoria };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVIZIOMATERIALE_WHERE);

			boolean bindCategoria = false;

			if (categoria == null) {
				query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_1);
			}
			else if (categoria.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_3);
			}
			else {
				bindCategoria = true;

				query.append(_FINDER_COLUMN_CATEGORIA_CATEGORIA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoria) {
					qPos.add(categoria);
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

	private static final String _FINDER_COLUMN_CATEGORIA_CATEGORIA_1 = "servizioMateriale.categoria IS NULL";
	private static final String _FINDER_COLUMN_CATEGORIA_CATEGORIA_2 = "servizioMateriale.categoria = ?";
	private static final String _FINDER_COLUMN_CATEGORIA_CATEGORIA_3 = "(servizioMateriale.categoria IS NULL OR servizioMateriale.categoria = '')";

	public ServizioMaterialePersistenceImpl() {
		setModelClass(ServizioMateriale.class);
	}

	/**
	 * Caches the servizio materiale in the entity cache if it is enabled.
	 *
	 * @param servizioMateriale the servizio materiale
	 */
	@Override
	public void cacheResult(ServizioMateriale servizioMateriale) {
		entityCache.putResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeImpl.class, servizioMateriale.getPrimaryKey(),
			servizioMateriale);

		servizioMateriale.resetOriginalValues();
	}

	/**
	 * Caches the servizio materiales in the entity cache if it is enabled.
	 *
	 * @param servizioMateriales the servizio materiales
	 */
	@Override
	public void cacheResult(List<ServizioMateriale> servizioMateriales) {
		for (ServizioMateriale servizioMateriale : servizioMateriales) {
			if (entityCache.getResult(
						ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
						ServizioMaterialeImpl.class,
						servizioMateriale.getPrimaryKey()) == null) {
				cacheResult(servizioMateriale);
			}
			else {
				servizioMateriale.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all servizio materiales.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServizioMaterialeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the servizio materiale.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServizioMateriale servizioMateriale) {
		entityCache.removeResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeImpl.class, servizioMateriale.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServizioMateriale> servizioMateriales) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServizioMateriale servizioMateriale : servizioMateriales) {
			entityCache.removeResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
				ServizioMaterialeImpl.class, servizioMateriale.getPrimaryKey());
		}
	}

	/**
	 * Creates a new servizio materiale with the primary key. Does not add the servizio materiale to the database.
	 *
	 * @param gruppo the primary key for the new servizio materiale
	 * @return the new servizio materiale
	 */
	@Override
	public ServizioMateriale create(String gruppo) {
		ServizioMateriale servizioMateriale = new ServizioMaterialeImpl();

		servizioMateriale.setNew(true);
		servizioMateriale.setPrimaryKey(gruppo);

		return servizioMateriale;
	}

	/**
	 * Removes the servizio materiale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gruppo the primary key of the servizio materiale
	 * @return the servizio materiale that was removed
	 * @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale remove(String gruppo)
		throws NoSuchServizioMaterialeException {
		return remove((Serializable)gruppo);
	}

	/**
	 * Removes the servizio materiale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the servizio materiale
	 * @return the servizio materiale that was removed
	 * @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale remove(Serializable primaryKey)
		throws NoSuchServizioMaterialeException {
		Session session = null;

		try {
			session = openSession();

			ServizioMateriale servizioMateriale = (ServizioMateriale)session.get(ServizioMaterialeImpl.class,
					primaryKey);

			if (servizioMateriale == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServizioMaterialeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(servizioMateriale);
		}
		catch (NoSuchServizioMaterialeException nsee) {
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
	protected ServizioMateriale removeImpl(ServizioMateriale servizioMateriale) {
		servizioMateriale = toUnwrappedModel(servizioMateriale);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(servizioMateriale)) {
				servizioMateriale = (ServizioMateriale)session.get(ServizioMaterialeImpl.class,
						servizioMateriale.getPrimaryKeyObj());
			}

			if (servizioMateriale != null) {
				session.delete(servizioMateriale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (servizioMateriale != null) {
			clearCache(servizioMateriale);
		}

		return servizioMateriale;
	}

	@Override
	public ServizioMateriale updateImpl(ServizioMateriale servizioMateriale) {
		servizioMateriale = toUnwrappedModel(servizioMateriale);

		boolean isNew = servizioMateriale.isNew();

		ServizioMaterialeModelImpl servizioMaterialeModelImpl = (ServizioMaterialeModelImpl)servizioMateriale;

		Session session = null;

		try {
			session = openSession();

			if (servizioMateriale.isNew()) {
				session.save(servizioMateriale);

				servizioMateriale.setNew(false);
			}
			else {
				servizioMateriale = (ServizioMateriale)session.merge(servizioMateriale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServizioMaterialeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((servizioMaterialeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						servizioMaterialeModelImpl.getOriginalCategoria()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORIA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIA,
					args);

				args = new Object[] { servizioMaterialeModelImpl.getCategoria() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORIA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORIA,
					args);
			}
		}

		entityCache.putResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
			ServizioMaterialeImpl.class, servizioMateriale.getPrimaryKey(),
			servizioMateriale, false);

		servizioMateriale.resetOriginalValues();

		return servizioMateriale;
	}

	protected ServizioMateriale toUnwrappedModel(
		ServizioMateriale servizioMateriale) {
		if (servizioMateriale instanceof ServizioMaterialeImpl) {
			return servizioMateriale;
		}

		ServizioMaterialeImpl servizioMaterialeImpl = new ServizioMaterialeImpl();

		servizioMaterialeImpl.setNew(servizioMateriale.isNew());
		servizioMaterialeImpl.setPrimaryKey(servizioMateriale.getPrimaryKey());

		servizioMaterialeImpl.setGruppo(servizioMateriale.getGruppo());
		servizioMaterialeImpl.setDescrizione(servizioMateriale.getDescrizione());
		servizioMaterialeImpl.setCategoria(servizioMateriale.getCategoria());

		return servizioMaterialeImpl;
	}

	/**
	 * Returns the servizio materiale with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio materiale
	 * @return the servizio materiale
	 * @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServizioMaterialeException {
		ServizioMateriale servizioMateriale = fetchByPrimaryKey(primaryKey);

		if (servizioMateriale == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServizioMaterialeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return servizioMateriale;
	}

	/**
	 * Returns the servizio materiale with the primary key or throws a {@link NoSuchServizioMaterialeException} if it could not be found.
	 *
	 * @param gruppo the primary key of the servizio materiale
	 * @return the servizio materiale
	 * @throws NoSuchServizioMaterialeException if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale findByPrimaryKey(String gruppo)
		throws NoSuchServizioMaterialeException {
		return findByPrimaryKey((Serializable)gruppo);
	}

	/**
	 * Returns the servizio materiale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the servizio materiale
	 * @return the servizio materiale, or <code>null</code> if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
				ServizioMaterialeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ServizioMateriale servizioMateriale = (ServizioMateriale)serializable;

		if (servizioMateriale == null) {
			Session session = null;

			try {
				session = openSession();

				servizioMateriale = (ServizioMateriale)session.get(ServizioMaterialeImpl.class,
						primaryKey);

				if (servizioMateriale != null) {
					cacheResult(servizioMateriale);
				}
				else {
					entityCache.putResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
						ServizioMaterialeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
					ServizioMaterialeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return servizioMateriale;
	}

	/**
	 * Returns the servizio materiale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gruppo the primary key of the servizio materiale
	 * @return the servizio materiale, or <code>null</code> if a servizio materiale with the primary key could not be found
	 */
	@Override
	public ServizioMateriale fetchByPrimaryKey(String gruppo) {
		return fetchByPrimaryKey((Serializable)gruppo);
	}

	@Override
	public Map<Serializable, ServizioMateriale> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ServizioMateriale> map = new HashMap<Serializable, ServizioMateriale>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ServizioMateriale servizioMateriale = fetchByPrimaryKey(primaryKey);

			if (servizioMateriale != null) {
				map.put(primaryKey, servizioMateriale);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
					ServizioMaterialeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ServizioMateriale)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_SERVIZIOMATERIALE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ServizioMateriale servizioMateriale : (List<ServizioMateriale>)q.list()) {
				map.put(servizioMateriale.getPrimaryKeyObj(), servizioMateriale);

				cacheResult(servizioMateriale);

				uncachedPrimaryKeys.remove(servizioMateriale.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ServizioMaterialeModelImpl.ENTITY_CACHE_ENABLED,
					ServizioMaterialeImpl.class, primaryKey, nullModel);
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
	 * Returns all the servizio materiales.
	 *
	 * @return the servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the servizio materiales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio materiales
	 * @param end the upper bound of the range of servizio materiales (not inclusive)
	 * @return the range of servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the servizio materiales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio materiales
	 * @param end the upper bound of the range of servizio materiales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findAll(int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the servizio materiales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of servizio materiales
	 * @param end the upper bound of the range of servizio materiales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of servizio materiales
	 */
	@Override
	public List<ServizioMateriale> findAll(int start, int end,
		OrderByComparator<ServizioMateriale> orderByComparator,
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

		List<ServizioMateriale> list = null;

		if (retrieveFromCache) {
			list = (List<ServizioMateriale>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SERVIZIOMATERIALE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVIZIOMATERIALE;

				if (pagination) {
					sql = sql.concat(ServizioMaterialeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ServizioMateriale>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ServizioMateriale>)QueryUtil.list(q,
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
	 * Removes all the servizio materiales from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServizioMateriale servizioMateriale : findAll()) {
			remove(servizioMateriale);
		}
	}

	/**
	 * Returns the number of servizio materiales.
	 *
	 * @return the number of servizio materiales
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVIZIOMATERIALE);

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
		return ServizioMaterialeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the servizio materiale persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ServizioMaterialeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SERVIZIOMATERIALE = "SELECT servizioMateriale FROM ServizioMateriale servizioMateriale";
	private static final String _SQL_SELECT_SERVIZIOMATERIALE_WHERE_PKS_IN = "SELECT servizioMateriale FROM ServizioMateriale servizioMateriale WHERE gruppo IN (";
	private static final String _SQL_SELECT_SERVIZIOMATERIALE_WHERE = "SELECT servizioMateriale FROM ServizioMateriale servizioMateriale WHERE ";
	private static final String _SQL_COUNT_SERVIZIOMATERIALE = "SELECT COUNT(servizioMateriale) FROM ServizioMateriale servizioMateriale";
	private static final String _SQL_COUNT_SERVIZIOMATERIALE_WHERE = "SELECT COUNT(servizioMateriale) FROM ServizioMateriale servizioMateriale WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "servizioMateriale.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServizioMateriale exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServizioMateriale exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ServizioMaterialePersistenceImpl.class);
}