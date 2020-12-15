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

import com.intranet.mef.assistance.exception.NoSuchTopicException;
import com.intranet.mef.assistance.model.Topic;
import com.intranet.mef.assistance.model.impl.TopicImpl;
import com.intranet.mef.assistance.model.impl.TopicModelImpl;
import com.intranet.mef.assistance.service.persistence.TopicPersistence;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the topic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicPersistence
 * @see com.intranet.mef.assistance.service.persistence.TopicUtil
 * @generated
 */
@ProviderType
public class TopicPersistenceImpl extends BasePersistenceImpl<Topic>
	implements TopicPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TopicUtil} to access the topic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TopicImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			TopicModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the topics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching topics
	 */
	@Override
	public List<Topic> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the topics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @return the range of matching topics
	 */
	@Override
	public List<Topic> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the topics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching topics
	 */
	@Override
	public List<Topic> findByUuid(String uuid, int start, int end,
		OrderByComparator<Topic> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the topics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching topics
	 */
	@Override
	public List<Topic> findByUuid(String uuid, int start, int end,
		OrderByComparator<Topic> orderByComparator, boolean retrieveFromCache) {
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

		List<Topic> list = null;

		if (retrieveFromCache) {
			list = (List<Topic>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Topic topic : list) {
					if (!Objects.equals(uuid, topic.getUuid())) {
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

			query.append(_SQL_SELECT_TOPIC_WHERE);

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
				query.append(TopicModelImpl.ORDER_BY_JPQL);
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
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first topic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic
	 * @throws NoSuchTopicException if a matching topic could not be found
	 */
	@Override
	public Topic findByUuid_First(String uuid,
		OrderByComparator<Topic> orderByComparator) throws NoSuchTopicException {
		Topic topic = fetchByUuid_First(uuid, orderByComparator);

		if (topic != null) {
			return topic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTopicException(msg.toString());
	}

	/**
	 * Returns the first topic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic, or <code>null</code> if a matching topic could not be found
	 */
	@Override
	public Topic fetchByUuid_First(String uuid,
		OrderByComparator<Topic> orderByComparator) {
		List<Topic> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic
	 * @throws NoSuchTopicException if a matching topic could not be found
	 */
	@Override
	public Topic findByUuid_Last(String uuid,
		OrderByComparator<Topic> orderByComparator) throws NoSuchTopicException {
		Topic topic = fetchByUuid_Last(uuid, orderByComparator);

		if (topic != null) {
			return topic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTopicException(msg.toString());
	}

	/**
	 * Returns the last topic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic, or <code>null</code> if a matching topic could not be found
	 */
	@Override
	public Topic fetchByUuid_Last(String uuid,
		OrderByComparator<Topic> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Topic> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the topics before and after the current topic in the ordered set where uuid = &#63;.
	 *
	 * @param topicId the primary key of the current topic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next topic
	 * @throws NoSuchTopicException if a topic with the primary key could not be found
	 */
	@Override
	public Topic[] findByUuid_PrevAndNext(String topicId, String uuid,
		OrderByComparator<Topic> orderByComparator) throws NoSuchTopicException {
		Topic topic = findByPrimaryKey(topicId);

		Session session = null;

		try {
			session = openSession();

			Topic[] array = new TopicImpl[3];

			array[0] = getByUuid_PrevAndNext(session, topic, uuid,
					orderByComparator, true);

			array[1] = topic;

			array[2] = getByUuid_PrevAndNext(session, topic, uuid,
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

	protected Topic getByUuid_PrevAndNext(Session session, Topic topic,
		String uuid, OrderByComparator<Topic> orderByComparator,
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

		query.append(_SQL_SELECT_TOPIC_WHERE);

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
			query.append(TopicModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(topic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Topic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the topics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Topic topic : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(topic);
		}
	}

	/**
	 * Returns the number of topics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching topics
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPIC_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "topic.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "topic.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(topic.uuid IS NULL OR topic.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AREASID = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAreasId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREASID =
		new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, TopicImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAreasId",
			new String[] { String.class.getName() },
			TopicModelImpl.AREAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AREASID = new FinderPath(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAreasId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the topics where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @return the matching topics
	 */
	@Override
	public List<Topic> findByAreasId(String areaId) {
		return findByAreasId(areaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the topics where areaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param areaId the area ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @return the range of matching topics
	 */
	@Override
	public List<Topic> findByAreasId(String areaId, int start, int end) {
		return findByAreasId(areaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the topics where areaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param areaId the area ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching topics
	 */
	@Override
	public List<Topic> findByAreasId(String areaId, int start, int end,
		OrderByComparator<Topic> orderByComparator) {
		return findByAreasId(areaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the topics where areaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param areaId the area ID
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching topics
	 */
	@Override
	public List<Topic> findByAreasId(String areaId, int start, int end,
		OrderByComparator<Topic> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREASID;
			finderArgs = new Object[] { areaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AREASID;
			finderArgs = new Object[] { areaId, start, end, orderByComparator };
		}

		List<Topic> list = null;

		if (retrieveFromCache) {
			list = (List<Topic>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Topic topic : list) {
					if (!Objects.equals(areaId, topic.getAreaId())) {
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

			query.append(_SQL_SELECT_TOPIC_WHERE);

			boolean bindAreaId = false;

			if (areaId == null) {
				query.append(_FINDER_COLUMN_AREASID_AREAID_1);
			}
			else if (areaId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AREASID_AREAID_3);
			}
			else {
				bindAreaId = true;

				query.append(_FINDER_COLUMN_AREASID_AREAID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TopicModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAreaId) {
					qPos.add(areaId);
				}

				if (!pagination) {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first topic in the ordered set where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic
	 * @throws NoSuchTopicException if a matching topic could not be found
	 */
	@Override
	public Topic findByAreasId_First(String areaId,
		OrderByComparator<Topic> orderByComparator) throws NoSuchTopicException {
		Topic topic = fetchByAreasId_First(areaId, orderByComparator);

		if (topic != null) {
			return topic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("areaId=");
		msg.append(areaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTopicException(msg.toString());
	}

	/**
	 * Returns the first topic in the ordered set where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching topic, or <code>null</code> if a matching topic could not be found
	 */
	@Override
	public Topic fetchByAreasId_First(String areaId,
		OrderByComparator<Topic> orderByComparator) {
		List<Topic> list = findByAreasId(areaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last topic in the ordered set where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic
	 * @throws NoSuchTopicException if a matching topic could not be found
	 */
	@Override
	public Topic findByAreasId_Last(String areaId,
		OrderByComparator<Topic> orderByComparator) throws NoSuchTopicException {
		Topic topic = fetchByAreasId_Last(areaId, orderByComparator);

		if (topic != null) {
			return topic;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("areaId=");
		msg.append(areaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTopicException(msg.toString());
	}

	/**
	 * Returns the last topic in the ordered set where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching topic, or <code>null</code> if a matching topic could not be found
	 */
	@Override
	public Topic fetchByAreasId_Last(String areaId,
		OrderByComparator<Topic> orderByComparator) {
		int count = countByAreasId(areaId);

		if (count == 0) {
			return null;
		}

		List<Topic> list = findByAreasId(areaId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the topics before and after the current topic in the ordered set where areaId = &#63;.
	 *
	 * @param topicId the primary key of the current topic
	 * @param areaId the area ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next topic
	 * @throws NoSuchTopicException if a topic with the primary key could not be found
	 */
	@Override
	public Topic[] findByAreasId_PrevAndNext(String topicId, String areaId,
		OrderByComparator<Topic> orderByComparator) throws NoSuchTopicException {
		Topic topic = findByPrimaryKey(topicId);

		Session session = null;

		try {
			session = openSession();

			Topic[] array = new TopicImpl[3];

			array[0] = getByAreasId_PrevAndNext(session, topic, areaId,
					orderByComparator, true);

			array[1] = topic;

			array[2] = getByAreasId_PrevAndNext(session, topic, areaId,
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

	protected Topic getByAreasId_PrevAndNext(Session session, Topic topic,
		String areaId, OrderByComparator<Topic> orderByComparator,
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

		query.append(_SQL_SELECT_TOPIC_WHERE);

		boolean bindAreaId = false;

		if (areaId == null) {
			query.append(_FINDER_COLUMN_AREASID_AREAID_1);
		}
		else if (areaId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AREASID_AREAID_3);
		}
		else {
			bindAreaId = true;

			query.append(_FINDER_COLUMN_AREASID_AREAID_2);
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
			query.append(TopicModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAreaId) {
			qPos.add(areaId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(topic);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Topic> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the topics where areaId = &#63; from the database.
	 *
	 * @param areaId the area ID
	 */
	@Override
	public void removeByAreasId(String areaId) {
		for (Topic topic : findByAreasId(areaId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(topic);
		}
	}

	/**
	 * Returns the number of topics where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @return the number of matching topics
	 */
	@Override
	public int countByAreasId(String areaId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AREASID;

		Object[] finderArgs = new Object[] { areaId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TOPIC_WHERE);

			boolean bindAreaId = false;

			if (areaId == null) {
				query.append(_FINDER_COLUMN_AREASID_AREAID_1);
			}
			else if (areaId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AREASID_AREAID_3);
			}
			else {
				bindAreaId = true;

				query.append(_FINDER_COLUMN_AREASID_AREAID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAreaId) {
					qPos.add(areaId);
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

	private static final String _FINDER_COLUMN_AREASID_AREAID_1 = "topic.areaId IS NULL";
	private static final String _FINDER_COLUMN_AREASID_AREAID_2 = "topic.areaId = ?";
	private static final String _FINDER_COLUMN_AREASID_AREAID_3 = "(topic.areaId IS NULL OR topic.areaId = '')";

	public TopicPersistenceImpl() {
		setModelClass(Topic.class);
	}

	/**
	 * Caches the topic in the entity cache if it is enabled.
	 *
	 * @param topic the topic
	 */
	@Override
	public void cacheResult(Topic topic) {
		entityCache.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicImpl.class, topic.getPrimaryKey(), topic);

		topic.resetOriginalValues();
	}

	/**
	 * Caches the topics in the entity cache if it is enabled.
	 *
	 * @param topics the topics
	 */
	@Override
	public void cacheResult(List<Topic> topics) {
		for (Topic topic : topics) {
			if (entityCache.getResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
						TopicImpl.class, topic.getPrimaryKey()) == null) {
				cacheResult(topic);
			}
			else {
				topic.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all topics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TopicImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the topic.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Topic topic) {
		entityCache.removeResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicImpl.class, topic.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Topic> topics) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Topic topic : topics) {
			entityCache.removeResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
				TopicImpl.class, topic.getPrimaryKey());
		}
	}

	/**
	 * Creates a new topic with the primary key. Does not add the topic to the database.
	 *
	 * @param topicId the primary key for the new topic
	 * @return the new topic
	 */
	@Override
	public Topic create(String topicId) {
		Topic topic = new TopicImpl();

		topic.setNew(true);
		topic.setPrimaryKey(topicId);

		String uuid = PortalUUIDUtil.generate();

		topic.setUuid(uuid);

		return topic;
	}

	/**
	 * Removes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param topicId the primary key of the topic
	 * @return the topic that was removed
	 * @throws NoSuchTopicException if a topic with the primary key could not be found
	 */
	@Override
	public Topic remove(String topicId) throws NoSuchTopicException {
		return remove((Serializable)topicId);
	}

	/**
	 * Removes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the topic
	 * @return the topic that was removed
	 * @throws NoSuchTopicException if a topic with the primary key could not be found
	 */
	@Override
	public Topic remove(Serializable primaryKey) throws NoSuchTopicException {
		Session session = null;

		try {
			session = openSession();

			Topic topic = (Topic)session.get(TopicImpl.class, primaryKey);

			if (topic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTopicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(topic);
		}
		catch (NoSuchTopicException nsee) {
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
	protected Topic removeImpl(Topic topic) {
		topic = toUnwrappedModel(topic);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(topic)) {
				topic = (Topic)session.get(TopicImpl.class,
						topic.getPrimaryKeyObj());
			}

			if (topic != null) {
				session.delete(topic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (topic != null) {
			clearCache(topic);
		}

		return topic;
	}

	@Override
	public Topic updateImpl(Topic topic) {
		topic = toUnwrappedModel(topic);

		boolean isNew = topic.isNew();

		TopicModelImpl topicModelImpl = (TopicModelImpl)topic;

		if (Validator.isNull(topic.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			topic.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (topic.isNew()) {
				session.save(topic);

				topic.setNew(false);
			}
			else {
				topic = (Topic)session.merge(topic);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TopicModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((topicModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { topicModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { topicModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((topicModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREASID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { topicModelImpl.getOriginalAreaId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AREASID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREASID,
					args);

				args = new Object[] { topicModelImpl.getAreaId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_AREASID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AREASID,
					args);
			}
		}

		entityCache.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
			TopicImpl.class, topic.getPrimaryKey(), topic, false);

		topic.resetOriginalValues();

		return topic;
	}

	protected Topic toUnwrappedModel(Topic topic) {
		if (topic instanceof TopicImpl) {
			return topic;
		}

		TopicImpl topicImpl = new TopicImpl();

		topicImpl.setNew(topic.isNew());
		topicImpl.setPrimaryKey(topic.getPrimaryKey());

		topicImpl.setUuid(topic.getUuid());
		topicImpl.setTopicId(topic.getTopicId());
		topicImpl.setTopicName(topic.getTopicName());
		topicImpl.setAreaId(topic.getAreaId());

		return topicImpl;
	}

	/**
	 * Returns the topic with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic
	 * @return the topic
	 * @throws NoSuchTopicException if a topic with the primary key could not be found
	 */
	@Override
	public Topic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTopicException {
		Topic topic = fetchByPrimaryKey(primaryKey);

		if (topic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTopicException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return topic;
	}

	/**
	 * Returns the topic with the primary key or throws a {@link NoSuchTopicException} if it could not be found.
	 *
	 * @param topicId the primary key of the topic
	 * @return the topic
	 * @throws NoSuchTopicException if a topic with the primary key could not be found
	 */
	@Override
	public Topic findByPrimaryKey(String topicId) throws NoSuchTopicException {
		return findByPrimaryKey((Serializable)topicId);
	}

	/**
	 * Returns the topic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the topic
	 * @return the topic, or <code>null</code> if a topic with the primary key could not be found
	 */
	@Override
	public Topic fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
				TopicImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Topic topic = (Topic)serializable;

		if (topic == null) {
			Session session = null;

			try {
				session = openSession();

				topic = (Topic)session.get(TopicImpl.class, primaryKey);

				if (topic != null) {
					cacheResult(topic);
				}
				else {
					entityCache.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
						TopicImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
					TopicImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return topic;
	}

	/**
	 * Returns the topic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param topicId the primary key of the topic
	 * @return the topic, or <code>null</code> if a topic with the primary key could not be found
	 */
	@Override
	public Topic fetchByPrimaryKey(String topicId) {
		return fetchByPrimaryKey((Serializable)topicId);
	}

	@Override
	public Map<Serializable, Topic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Topic> map = new HashMap<Serializable, Topic>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Topic topic = fetchByPrimaryKey(primaryKey);

			if (topic != null) {
				map.put(primaryKey, topic);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
					TopicImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Topic)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_TOPIC_WHERE_PKS_IN);

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

			for (Topic topic : (List<Topic>)q.list()) {
				map.put(topic.getPrimaryKeyObj(), topic);

				cacheResult(topic);

				uncachedPrimaryKeys.remove(topic.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TopicModelImpl.ENTITY_CACHE_ENABLED,
					TopicImpl.class, primaryKey, nullModel);
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
	 * Returns all the topics.
	 *
	 * @return the topics
	 */
	@Override
	public List<Topic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the topics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @return the range of topics
	 */
	@Override
	public List<Topic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the topics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of topics
	 */
	@Override
	public List<Topic> findAll(int start, int end,
		OrderByComparator<Topic> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the topics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TopicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of topics
	 * @param end the upper bound of the range of topics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of topics
	 */
	@Override
	public List<Topic> findAll(int start, int end,
		OrderByComparator<Topic> orderByComparator, boolean retrieveFromCache) {
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

		List<Topic> list = null;

		if (retrieveFromCache) {
			list = (List<Topic>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TOPIC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TOPIC;

				if (pagination) {
					sql = sql.concat(TopicModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Topic>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the topics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Topic topic : findAll()) {
			remove(topic);
		}
	}

	/**
	 * Returns the number of topics.
	 *
	 * @return the number of topics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TOPIC);

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
		return TopicModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the topic persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TopicImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TOPIC = "SELECT topic FROM Topic topic";
	private static final String _SQL_SELECT_TOPIC_WHERE_PKS_IN = "SELECT topic FROM Topic topic WHERE topicId IN (";
	private static final String _SQL_SELECT_TOPIC_WHERE = "SELECT topic FROM Topic topic WHERE ";
	private static final String _SQL_COUNT_TOPIC = "SELECT COUNT(topic) FROM Topic topic";
	private static final String _SQL_COUNT_TOPIC_WHERE = "SELECT COUNT(topic) FROM Topic topic WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "topic.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Topic exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Topic exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TopicPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}