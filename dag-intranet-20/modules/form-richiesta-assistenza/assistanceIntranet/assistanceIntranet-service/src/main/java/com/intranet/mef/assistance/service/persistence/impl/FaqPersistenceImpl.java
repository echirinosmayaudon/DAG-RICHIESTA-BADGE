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

package com.intranet.mef.assistance.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.exception.NoSuchFaqException;
import com.intranet.mef.assistance.model.Faq;
import com.intranet.mef.assistance.model.impl.FaqImpl;
import com.intranet.mef.assistance.model.impl.FaqModelImpl;
import com.intranet.mef.assistance.service.persistence.FaqPK;
import com.intranet.mef.assistance.service.persistence.FaqPersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the faq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FaqPersistence
 * @see com.intranet.mef.assistance.service.persistence.FaqUtil
 * @generated
 */
@ProviderType
public class FaqPersistenceImpl extends BasePersistenceImpl<Faq>
	implements FaqPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FaqUtil} to access the faq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FaqImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, FaqImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, FaqImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, FaqImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, FaqImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FaqModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the faqs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faqs
	 */
	@Override
	public List<Faq> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faqs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	@Override
	public List<Faq> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faqs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	@Override
	public List<Faq> findByUuid(String uuid, int start, int end,
		OrderByComparator<Faq> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faqs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Override
	public List<Faq> findByUuid(String uuid, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Faq> list = null;

		if (retrieveFromCache) {
			list = (List<Faq>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Faq faq : list) {
					if (!Objects.equals(uuid, faq.getUuid())) {
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

			query.append(_SQL_SELECT_FAQ_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FaqModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Faq>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Faq>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	@Override
	public Faq findByUuid_First(String uuid,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		Faq faq = fetchByUuid_First(uuid, orderByComparator);

		if (faq != null) {
			return faq;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFaqException(msg.toString());
	}

	/**
	 * Returns the first faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public Faq fetchByUuid_First(String uuid,
		OrderByComparator<Faq> orderByComparator) {
		List<Faq> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	@Override
	public Faq findByUuid_Last(String uuid,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		Faq faq = fetchByUuid_Last(uuid, orderByComparator);

		if (faq != null) {
			return faq;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFaqException(msg.toString());
	}

	/**
	 * Returns the last faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public Faq fetchByUuid_Last(String uuid,
		OrderByComparator<Faq> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Faq> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faqs before and after the current faq in the ordered set where uuid = &#63;.
	 *
	 * @param faqPK the primary key of the current faq
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	@Override
	public Faq[] findByUuid_PrevAndNext(FaqPK faqPK, String uuid,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		Faq faq = findByPrimaryKey(faqPK);

		Session session = null;

		try {
			session = openSession();

			Faq[] array = new FaqImpl[3];

			array[0] = getByUuid_PrevAndNext(session, faq, uuid,
					orderByComparator, true);

			array[1] = faq;

			array[2] = getByUuid_PrevAndNext(session, faq, uuid,
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

	protected Faq getByUuid_PrevAndNext(Session session, Faq faq, String uuid,
		OrderByComparator<Faq> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQ_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(FaqModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faq);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Faq> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faqs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Faq faq : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(faq);
		}
	}

	/**
	 * Returns the number of faqs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faqs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQ_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "faq.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "faq.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(faq.uuid IS NULL OR faq.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FAQID = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, FaqImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFaqId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAQID = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, FaqImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFaqId",
			new String[] { String.class.getName() },
			FaqModelImpl.FAQID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FAQID = new FinderPath(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFaqId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the faqs where faqId = &#63;.
	 *
	 * @param faqId the faq ID
	 * @return the matching faqs
	 */
	@Override
	public List<Faq> findByFaqId(String faqId) {
		return findByFaqId(faqId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faqs where faqId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param faqId the faq ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	@Override
	public List<Faq> findByFaqId(String faqId, int start, int end) {
		return findByFaqId(faqId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faqs where faqId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param faqId the faq ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	@Override
	public List<Faq> findByFaqId(String faqId, int start, int end,
		OrderByComparator<Faq> orderByComparator) {
		return findByFaqId(faqId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faqs where faqId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param faqId the faq ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Override
	public List<Faq> findByFaqId(String faqId, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAQID;
			finderArgs = new Object[] { faqId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FAQID;
			finderArgs = new Object[] { faqId, start, end, orderByComparator };
		}

		List<Faq> list = null;

		if (retrieveFromCache) {
			list = (List<Faq>)finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Faq faq : list) {
					if (!Objects.equals(faqId, faq.getFaqId())) {
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

			query.append(_SQL_SELECT_FAQ_WHERE);

			boolean bindFaqId = false;

			if (faqId == null) {
				query.append(_FINDER_COLUMN_FAQID_FAQID_1);
			}
			else if (faqId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FAQID_FAQID_3);
			}
			else {
				bindFaqId = true;

				query.append(_FINDER_COLUMN_FAQID_FAQID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FaqModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFaqId) {
					qPos.add(faqId);
				}

				if (!pagination) {
					list = (List<Faq>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Faq>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first faq in the ordered set where faqId = &#63;.
	 *
	 * @param faqId the faq ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	@Override
	public Faq findByFaqId_First(String faqId,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		Faq faq = fetchByFaqId_First(faqId, orderByComparator);

		if (faq != null) {
			return faq;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("faqId=");
		msg.append(faqId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFaqException(msg.toString());
	}

	/**
	 * Returns the first faq in the ordered set where faqId = &#63;.
	 *
	 * @param faqId the faq ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public Faq fetchByFaqId_First(String faqId,
		OrderByComparator<Faq> orderByComparator) {
		List<Faq> list = findByFaqId(faqId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faq in the ordered set where faqId = &#63;.
	 *
	 * @param faqId the faq ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	@Override
	public Faq findByFaqId_Last(String faqId,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		Faq faq = fetchByFaqId_Last(faqId, orderByComparator);

		if (faq != null) {
			return faq;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("faqId=");
		msg.append(faqId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFaqException(msg.toString());
	}

	/**
	 * Returns the last faq in the ordered set where faqId = &#63;.
	 *
	 * @param faqId the faq ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public Faq fetchByFaqId_Last(String faqId,
		OrderByComparator<Faq> orderByComparator) {
		int count = countByFaqId(faqId);

		if (count == 0) {
			return null;
		}

		List<Faq> list = findByFaqId(faqId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faqs before and after the current faq in the ordered set where faqId = &#63;.
	 *
	 * @param faqPK the primary key of the current faq
	 * @param faqId the faq ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	@Override
	public Faq[] findByFaqId_PrevAndNext(FaqPK faqPK, String faqId,
		OrderByComparator<Faq> orderByComparator) throws NoSuchFaqException {
		Faq faq = findByPrimaryKey(faqPK);

		Session session = null;

		try {
			session = openSession();

			Faq[] array = new FaqImpl[3];

			array[0] = getByFaqId_PrevAndNext(session, faq, faqId,
					orderByComparator, true);

			array[1] = faq;

			array[2] = getByFaqId_PrevAndNext(session, faq, faqId,
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

	protected Faq getByFaqId_PrevAndNext(Session session, Faq faq,
		String faqId, OrderByComparator<Faq> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQ_WHERE);

		boolean bindFaqId = false;

		if (faqId == null) {
			query.append(_FINDER_COLUMN_FAQID_FAQID_1);
		}
		else if (faqId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FAQID_FAQID_3);
		}
		else {
			bindFaqId = true;

			query.append(_FINDER_COLUMN_FAQID_FAQID_2);
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
			query.append(FaqModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFaqId) {
			qPos.add(faqId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faq);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Faq> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faqs where faqId = &#63; from the database.
	 *
	 * @param faqId the faq ID
	 */
	@Override
	public void removeByFaqId(String faqId) {
		for (Faq faq : findByFaqId(faqId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(faq);
		}
	}

	/**
	 * Returns the number of faqs where faqId = &#63;.
	 *
	 * @param faqId the faq ID
	 * @return the number of matching faqs
	 */
	@Override
	public int countByFaqId(String faqId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FAQID;

		Object[] finderArgs = new Object[] { faqId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQ_WHERE);

			boolean bindFaqId = false;

			if (faqId == null) {
				query.append(_FINDER_COLUMN_FAQID_FAQID_1);
			}
			else if (faqId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FAQID_FAQID_3);
			}
			else {
				bindFaqId = true;

				query.append(_FINDER_COLUMN_FAQID_FAQID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFaqId) {
					qPos.add(faqId);
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

	private static final String _FINDER_COLUMN_FAQID_FAQID_1 = "faq.id.faqId IS NULL";
	private static final String _FINDER_COLUMN_FAQID_FAQID_2 = "faq.id.faqId = ?";
	private static final String _FINDER_COLUMN_FAQID_FAQID_3 = "(faq.id.faqId IS NULL OR faq.id.faqId = '')";

	public FaqPersistenceImpl() {
		setModelClass(Faq.class);
	}

	/**
	 * Caches the faq in the entity cache if it is enabled.
	 *
	 * @param faq the faq
	 */
	@Override
	public void cacheResult(Faq faq) {
		entityCache.putResult(FaqModelImpl.ENTITY_CACHE_ENABLED, FaqImpl.class,
			faq.getPrimaryKey(), faq);

		faq.resetOriginalValues();
	}

	/**
	 * Caches the faqs in the entity cache if it is enabled.
	 *
	 * @param faqs the faqs
	 */
	@Override
	public void cacheResult(List<Faq> faqs) {
		for (Faq faq : faqs) {
			if (entityCache.getResult(FaqModelImpl.ENTITY_CACHE_ENABLED,
						FaqImpl.class, faq.getPrimaryKey()) == null) {
				cacheResult(faq);
			}
			else {
				faq.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all faqs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FaqImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the faq.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Faq faq) {
		entityCache.removeResult(FaqModelImpl.ENTITY_CACHE_ENABLED,
			FaqImpl.class, faq.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Faq> faqs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Faq faq : faqs) {
			entityCache.removeResult(FaqModelImpl.ENTITY_CACHE_ENABLED,
				FaqImpl.class, faq.getPrimaryKey());
		}
	}

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqPK the primary key for the new faq
	 * @return the new faq
	 */
	@Override
	public Faq create(FaqPK faqPK) {
		Faq faq = new FaqImpl();

		faq.setNew(true);
		faq.setPrimaryKey(faqPK);

		String uuid = PortalUUIDUtil.generate();

		faq.setUuid(uuid);

		return faq;
	}

	/**
	 * Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqPK the primary key of the faq
	 * @return the faq that was removed
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	@Override
	public Faq remove(FaqPK faqPK) throws NoSuchFaqException {
		return remove((Serializable)faqPK);
	}

	/**
	 * Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faq
	 * @return the faq that was removed
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	@Override
	public Faq remove(Serializable primaryKey) throws NoSuchFaqException {
		Session session = null;

		try {
			session = openSession();

			Faq faq = (Faq)session.get(FaqImpl.class, primaryKey);

			if (faq == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFaqException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faq);
		}
		catch (NoSuchFaqException nsee) {
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
	protected Faq removeImpl(Faq faq) {
		faq = toUnwrappedModel(faq);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(faq)) {
				faq = (Faq)session.get(FaqImpl.class, faq.getPrimaryKeyObj());
			}

			if (faq != null) {
				session.delete(faq);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (faq != null) {
			clearCache(faq);
		}

		return faq;
	}

	@Override
	public Faq updateImpl(Faq faq) {
		faq = toUnwrappedModel(faq);

		boolean isNew = faq.isNew();

		FaqModelImpl faqModelImpl = (FaqModelImpl)faq;

		if (Validator.isNull(faq.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			faq.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (faq.isNew()) {
				session.save(faq);

				faq.setNew(false);
			}
			else {
				faq = (Faq)session.merge(faq);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FaqModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { faqModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { faqModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((faqModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAQID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { faqModelImpl.getOriginalFaqId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FAQID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAQID,
					args);

				args = new Object[] { faqModelImpl.getFaqId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FAQID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FAQID,
					args);
			}
		}

		entityCache.putResult(FaqModelImpl.ENTITY_CACHE_ENABLED, FaqImpl.class,
			faq.getPrimaryKey(), faq, false);

		faq.resetOriginalValues();

		return faq;
	}

	protected Faq toUnwrappedModel(Faq faq) {
		if (faq instanceof FaqImpl) {
			return faq;
		}

		FaqImpl faqImpl = new FaqImpl();

		faqImpl.setNew(faq.isNew());
		faqImpl.setPrimaryKey(faq.getPrimaryKey());

		faqImpl.setUuid(faq.getUuid());
		faqImpl.setFaqId(faq.getFaqId());
		faqImpl.setSiebelId(faq.getSiebelId());
		faqImpl.setQuestions(faq.getQuestions());
		faqImpl.setResponse(faq.getResponse());

		return faqImpl;
	}

	/**
	 * Returns the faq with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the faq
	 * @return the faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	@Override
	public Faq findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFaqException {
		Faq faq = fetchByPrimaryKey(primaryKey);

		if (faq == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFaqException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return faq;
	}

	/**
	 * Returns the faq with the primary key or throws a {@link NoSuchFaqException} if it could not be found.
	 *
	 * @param faqPK the primary key of the faq
	 * @return the faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	@Override
	public Faq findByPrimaryKey(FaqPK faqPK) throws NoSuchFaqException {
		return findByPrimaryKey((Serializable)faqPK);
	}

	/**
	 * Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faq
	 * @return the faq, or <code>null</code> if a faq with the primary key could not be found
	 */
	@Override
	public Faq fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FaqModelImpl.ENTITY_CACHE_ENABLED,
				FaqImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Faq faq = (Faq)serializable;

		if (faq == null) {
			Session session = null;

			try {
				session = openSession();

				faq = (Faq)session.get(FaqImpl.class, primaryKey);

				if (faq != null) {
					cacheResult(faq);
				}
				else {
					entityCache.putResult(FaqModelImpl.ENTITY_CACHE_ENABLED,
						FaqImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FaqModelImpl.ENTITY_CACHE_ENABLED,
					FaqImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return faq;
	}

	/**
	 * Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param faqPK the primary key of the faq
	 * @return the faq, or <code>null</code> if a faq with the primary key could not be found
	 */
	@Override
	public Faq fetchByPrimaryKey(FaqPK faqPK) {
		return fetchByPrimaryKey((Serializable)faqPK);
	}

	@Override
	public Map<Serializable, Faq> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Faq> map = new HashMap<Serializable, Faq>();

		for (Serializable primaryKey : primaryKeys) {
			Faq faq = fetchByPrimaryKey(primaryKey);

			if (faq != null) {
				map.put(primaryKey, faq);
			}
		}

		return map;
	}

	/**
	 * Returns all the faqs.
	 *
	 * @return the faqs
	 */
	@Override
	public List<Faq> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of faqs
	 */
	@Override
	public List<Faq> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faqs
	 */
	@Override
	public List<Faq> findAll(int start, int end,
		OrderByComparator<Faq> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FaqModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of faqs
	 */
	@Override
	public List<Faq> findAll(int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean retrieveFromCache) {
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

		List<Faq> list = null;

		if (retrieveFromCache) {
			list = (List<Faq>)finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FAQ);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQ;

				if (pagination) {
					sql = sql.concat(FaqModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Faq>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Faq>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the faqs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Faq faq : findAll()) {
			remove(faq);
		}
	}

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQ);

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
		return FaqModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faq persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FaqImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FAQ = "SELECT faq FROM Faq faq";
	private static final String _SQL_SELECT_FAQ_WHERE = "SELECT faq FROM Faq faq WHERE ";
	private static final String _SQL_COUNT_FAQ = "SELECT COUNT(faq) FROM Faq faq";
	private static final String _SQL_COUNT_FAQ_WHERE = "SELECT COUNT(faq) FROM Faq faq WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faq.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Faq exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Faq exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FaqPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}