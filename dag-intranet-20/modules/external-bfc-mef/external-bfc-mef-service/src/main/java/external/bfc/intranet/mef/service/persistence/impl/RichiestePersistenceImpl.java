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

import external.bfc.intranet.mef.exception.NoSuchRichiesteException;
import external.bfc.intranet.mef.model.Richieste;
import external.bfc.intranet.mef.model.impl.RichiesteImpl;
import external.bfc.intranet.mef.model.impl.RichiesteModelImpl;
import external.bfc.intranet.mef.service.persistence.RichiestePersistence;

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
 * The persistence implementation for the richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RichiestePersistence
 * @see external.bfc.intranet.mef.service.persistence.RichiesteUtil
 * @generated
 */
@ProviderType
public class RichiestePersistenceImpl extends BasePersistenceImpl<Richieste>
	implements RichiestePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RichiesteUtil} to access the richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RichiesteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteModelImpl.FINDER_CACHE_ENABLED, RichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteModelImpl.FINDER_CACHE_ENABLED, RichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREQBFC =
		new FinderPath(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteModelImpl.FINDER_CACHE_ENABLED, RichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemailReqBfc",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC =
		new FinderPath(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteModelImpl.FINDER_CACHE_ENABLED, RichiesteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemailReqBfc",
			new String[] { String.class.getName() },
			RichiesteModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILREQBFC = new FinderPath(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailReqBfc",
			new String[] { String.class.getName() });

	/**
	 * Returns all the richiestes where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching richiestes
	 */
	@Override
	public List<Richieste> findByemailReqBfc(String email) {
		return findByemailReqBfc(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the richiestes where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of richiestes
	 * @param end the upper bound of the range of richiestes (not inclusive)
	 * @return the range of matching richiestes
	 */
	@Override
	public List<Richieste> findByemailReqBfc(String email, int start, int end) {
		return findByemailReqBfc(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestes where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of richiestes
	 * @param end the upper bound of the range of richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching richiestes
	 */
	@Override
	public List<Richieste> findByemailReqBfc(String email, int start, int end,
		OrderByComparator<Richieste> orderByComparator) {
		return findByemailReqBfc(email, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestes where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of richiestes
	 * @param end the upper bound of the range of richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching richiestes
	 */
	@Override
	public List<Richieste> findByemailReqBfc(String email, int start, int end,
		OrderByComparator<Richieste> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC;
			finderArgs = new Object[] { email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILREQBFC;
			finderArgs = new Object[] { email, start, end, orderByComparator };
		}

		List<Richieste> list = null;

		if (retrieveFromCache) {
			list = (List<Richieste>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Richieste richieste : list) {
					if (!Objects.equals(email, richieste.getEmail())) {
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

			query.append(_SQL_SELECT_RICHIESTE_WHERE);

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
				query.append(RichiesteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<Richieste>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Richieste>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first richieste in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richieste
	 * @throws NoSuchRichiesteException if a matching richieste could not be found
	 */
	@Override
	public Richieste findByemailReqBfc_First(String email,
		OrderByComparator<Richieste> orderByComparator)
		throws NoSuchRichiesteException {
		Richieste richieste = fetchByemailReqBfc_First(email, orderByComparator);

		if (richieste != null) {
			return richieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiesteException(msg.toString());
	}

	/**
	 * Returns the first richieste in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching richieste, or <code>null</code> if a matching richieste could not be found
	 */
	@Override
	public Richieste fetchByemailReqBfc_First(String email,
		OrderByComparator<Richieste> orderByComparator) {
		List<Richieste> list = findByemailReqBfc(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last richieste in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richieste
	 * @throws NoSuchRichiesteException if a matching richieste could not be found
	 */
	@Override
	public Richieste findByemailReqBfc_Last(String email,
		OrderByComparator<Richieste> orderByComparator)
		throws NoSuchRichiesteException {
		Richieste richieste = fetchByemailReqBfc_Last(email, orderByComparator);

		if (richieste != null) {
			return richieste;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRichiesteException(msg.toString());
	}

	/**
	 * Returns the last richieste in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching richieste, or <code>null</code> if a matching richieste could not be found
	 */
	@Override
	public Richieste fetchByemailReqBfc_Last(String email,
		OrderByComparator<Richieste> orderByComparator) {
		int count = countByemailReqBfc(email);

		if (count == 0) {
			return null;
		}

		List<Richieste> list = findByemailReqBfc(email, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the richiestes before and after the current richieste in the ordered set where email = &#63;.
	 *
	 * @param id the primary key of the current richieste
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next richieste
	 * @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste[] findByemailReqBfc_PrevAndNext(long id, String email,
		OrderByComparator<Richieste> orderByComparator)
		throws NoSuchRichiesteException {
		Richieste richieste = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Richieste[] array = new RichiesteImpl[3];

			array[0] = getByemailReqBfc_PrevAndNext(session, richieste, email,
					orderByComparator, true);

			array[1] = richieste;

			array[2] = getByemailReqBfc_PrevAndNext(session, richieste, email,
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

	protected Richieste getByemailReqBfc_PrevAndNext(Session session,
		Richieste richieste, String email,
		OrderByComparator<Richieste> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RICHIESTE_WHERE);

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
			query.append(RichiesteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(richieste);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Richieste> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the richiestes where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByemailReqBfc(String email) {
		for (Richieste richieste : findByemailReqBfc(email, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(richieste);
		}
	}

	/**
	 * Returns the number of richiestes where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching richiestes
	 */
	@Override
	public int countByemailReqBfc(String email) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILREQBFC;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RICHIESTE_WHERE);

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

	private static final String _FINDER_COLUMN_EMAILREQBFC_EMAIL_1 = "richieste.email IS NULL";
	private static final String _FINDER_COLUMN_EMAILREQBFC_EMAIL_2 = "richieste.email = ?";
	private static final String _FINDER_COLUMN_EMAILREQBFC_EMAIL_3 = "(richieste.email IS NULL OR richieste.email = '')";

	public RichiestePersistenceImpl() {
		setModelClass(Richieste.class);
	}

	/**
	 * Caches the richieste in the entity cache if it is enabled.
	 *
	 * @param richieste the richieste
	 */
	@Override
	public void cacheResult(Richieste richieste) {
		entityCache.putResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteImpl.class, richieste.getPrimaryKey(), richieste);

		richieste.resetOriginalValues();
	}

	/**
	 * Caches the richiestes in the entity cache if it is enabled.
	 *
	 * @param richiestes the richiestes
	 */
	@Override
	public void cacheResult(List<Richieste> richiestes) {
		for (Richieste richieste : richiestes) {
			if (entityCache.getResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteImpl.class, richieste.getPrimaryKey()) == null) {
				cacheResult(richieste);
			}
			else {
				richieste.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all richiestes.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RichiesteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the richieste.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Richieste richieste) {
		entityCache.removeResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteImpl.class, richieste.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Richieste> richiestes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Richieste richieste : richiestes) {
			entityCache.removeResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteImpl.class, richieste.getPrimaryKey());
		}
	}

	/**
	 * Creates a new richieste with the primary key. Does not add the richieste to the database.
	 *
	 * @param id the primary key for the new richieste
	 * @return the new richieste
	 */
	@Override
	public Richieste create(long id) {
		Richieste richieste = new RichiesteImpl();

		richieste.setNew(true);
		richieste.setPrimaryKey(id);

		return richieste;
	}

	/**
	 * Removes the richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the richieste
	 * @return the richieste that was removed
	 * @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste remove(long id) throws NoSuchRichiesteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the richieste with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the richieste
	 * @return the richieste that was removed
	 * @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste remove(Serializable primaryKey)
		throws NoSuchRichiesteException {
		Session session = null;

		try {
			session = openSession();

			Richieste richieste = (Richieste)session.get(RichiesteImpl.class,
					primaryKey);

			if (richieste == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(richieste);
		}
		catch (NoSuchRichiesteException nsee) {
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
	protected Richieste removeImpl(Richieste richieste) {
		richieste = toUnwrappedModel(richieste);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(richieste)) {
				richieste = (Richieste)session.get(RichiesteImpl.class,
						richieste.getPrimaryKeyObj());
			}

			if (richieste != null) {
				session.delete(richieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (richieste != null) {
			clearCache(richieste);
		}

		return richieste;
	}

	@Override
	public Richieste updateImpl(Richieste richieste) {
		richieste = toUnwrappedModel(richieste);

		boolean isNew = richieste.isNew();

		RichiesteModelImpl richiesteModelImpl = (RichiesteModelImpl)richieste;

		Session session = null;

		try {
			session = openSession();

			if (richieste.isNew()) {
				session.save(richieste);

				richieste.setNew(false);
			}
			else {
				richieste = (Richieste)session.merge(richieste);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RichiesteModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((richiesteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						richiesteModelImpl.getOriginalEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILREQBFC, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC,
					args);

				args = new Object[] { richiesteModelImpl.getEmail() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAILREQBFC, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILREQBFC,
					args);
			}
		}

		entityCache.putResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
			RichiesteImpl.class, richieste.getPrimaryKey(), richieste, false);

		richieste.resetOriginalValues();

		return richieste;
	}

	protected Richieste toUnwrappedModel(Richieste richieste) {
		if (richieste instanceof RichiesteImpl) {
			return richieste;
		}

		RichiesteImpl richiesteImpl = new RichiesteImpl();

		richiesteImpl.setNew(richieste.isNew());
		richiesteImpl.setPrimaryKey(richieste.getPrimaryKey());

		richiesteImpl.setIdStatoAttuale(richieste.getIdStatoAttuale());
		richiesteImpl.setId(richieste.getId());
		richiesteImpl.setDataRichiesta(richieste.getDataRichiesta());
		richiesteImpl.setIdPeriodicita(richieste.getIdPeriodicita());
		richiesteImpl.setEmail(richieste.getEmail());
		richiesteImpl.setRiferimentoStanza(richieste.getRiferimentoStanza());
		richiesteImpl.setIspettorato(richieste.getIspettorato());
		richiesteImpl.setNoteRichiedente(richieste.getNoteRichiedente());
		richiesteImpl.setUfficio(richieste.getUfficio());
		richiesteImpl.setNote(richieste.getNote());
		richiesteImpl.setUidIns(richieste.getUidIns());
		richiesteImpl.setDataIns(richieste.getDataIns());
		richiesteImpl.setUidUpd(richieste.getUidUpd());
		richiesteImpl.setDataUpd(richieste.getDataUpd());
		richiesteImpl.setOggetto(richieste.getOggetto());
		richiesteImpl.setIdSede(richieste.getIdSede());
		richiesteImpl.setStrutIsp(richieste.getStrutIsp());
		richiesteImpl.setStrutUff(richieste.getStrutUff());
		richiesteImpl.setStrutIsp2(richieste.getStrutIsp2());
		richiesteImpl.setTelRichiedente(richieste.getTelRichiedente());
		richiesteImpl.setCostoReale(richieste.getCostoReale());
		richiesteImpl.setPreventivo(richieste.getPreventivo());
		richiesteImpl.setFlagInvio(richieste.getFlagInvio());

		return richiesteImpl;
	}

	/**
	 * Returns the richieste with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste
	 * @return the richieste
	 * @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRichiesteException {
		Richieste richieste = fetchByPrimaryKey(primaryKey);

		if (richieste == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRichiesteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return richieste;
	}

	/**
	 * Returns the richieste with the primary key or throws a {@link NoSuchRichiesteException} if it could not be found.
	 *
	 * @param id the primary key of the richieste
	 * @return the richieste
	 * @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste findByPrimaryKey(long id) throws NoSuchRichiesteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the richieste
	 * @return the richieste, or <code>null</code> if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
				RichiesteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Richieste richieste = (Richieste)serializable;

		if (richieste == null) {
			Session session = null;

			try {
				session = openSession();

				richieste = (Richieste)session.get(RichiesteImpl.class,
						primaryKey);

				if (richieste != null) {
					cacheResult(richieste);
				}
				else {
					entityCache.putResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
						RichiesteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return richieste;
	}

	/**
	 * Returns the richieste with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the richieste
	 * @return the richieste, or <code>null</code> if a richieste with the primary key could not be found
	 */
	@Override
	public Richieste fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Richieste> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Richieste> map = new HashMap<Serializable, Richieste>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Richieste richieste = fetchByPrimaryKey(primaryKey);

			if (richieste != null) {
				map.put(primaryKey, richieste);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Richieste)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_RICHIESTE_WHERE_PKS_IN);

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

			for (Richieste richieste : (List<Richieste>)q.list()) {
				map.put(richieste.getPrimaryKeyObj(), richieste);

				cacheResult(richieste);

				uncachedPrimaryKeys.remove(richieste.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(RichiesteModelImpl.ENTITY_CACHE_ENABLED,
					RichiesteImpl.class, primaryKey, nullModel);
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
	 * Returns all the richiestes.
	 *
	 * @return the richiestes
	 */
	@Override
	public List<Richieste> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestes
	 * @param end the upper bound of the range of richiestes (not inclusive)
	 * @return the range of richiestes
	 */
	@Override
	public List<Richieste> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestes
	 * @param end the upper bound of the range of richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of richiestes
	 */
	@Override
	public List<Richieste> findAll(int start, int end,
		OrderByComparator<Richieste> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the richiestes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiestes
	 * @param end the upper bound of the range of richiestes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of richiestes
	 */
	@Override
	public List<Richieste> findAll(int start, int end,
		OrderByComparator<Richieste> orderByComparator,
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

		List<Richieste> list = null;

		if (retrieveFromCache) {
			list = (List<Richieste>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RICHIESTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RICHIESTE;

				if (pagination) {
					sql = sql.concat(RichiesteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Richieste>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Richieste>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the richiestes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Richieste richieste : findAll()) {
			remove(richieste);
		}
	}

	/**
	 * Returns the number of richiestes.
	 *
	 * @return the number of richiestes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RICHIESTE);

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
		return RichiesteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the richieste persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(RichiesteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_RICHIESTE = "SELECT richieste FROM Richieste richieste";
	private static final String _SQL_SELECT_RICHIESTE_WHERE_PKS_IN = "SELECT richieste FROM Richieste richieste WHERE ID IN (";
	private static final String _SQL_SELECT_RICHIESTE_WHERE = "SELECT richieste FROM Richieste richieste WHERE ";
	private static final String _SQL_COUNT_RICHIESTE = "SELECT COUNT(richieste) FROM Richieste richieste";
	private static final String _SQL_COUNT_RICHIESTE_WHERE = "SELECT COUNT(richieste) FROM Richieste richieste WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "richieste.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Richieste exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Richieste exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(RichiestePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"idStatoAttuale", "id", "dataRichiesta", "idPeriodicita",
				"email", "riferimentoStanza", "ispettorato", "noteRichiedente",
				"ufficio", "note", "uidIns", "dataIns", "uidUpd", "dataUpd",
				"oggetto", "idSede", "strutIsp", "strutUff", "strutIsp2",
				"telRichiedente", "costoReale", "preventivo", "flagInvio"
			});
}