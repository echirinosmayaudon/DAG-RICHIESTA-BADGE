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

package com.intranet.mef.assistance.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.assistance.exception.NoSuchTopicException;
import com.intranet.mef.assistance.model.Topic;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the topic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.mef.assistance.service.persistence.impl.TopicPersistenceImpl
 * @see TopicUtil
 * @generated
 */
@ProviderType
public interface TopicPersistence extends BasePersistence<Topic> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TopicUtil} to access the topic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the topics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching topics
	*/
	public java.util.List<Topic> findByUuid(java.lang.String uuid);

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
	public java.util.List<Topic> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Topic> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

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
	public java.util.List<Topic> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic
	* @throws NoSuchTopicException if a matching topic could not be found
	*/
	public Topic findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator)
		throws NoSuchTopicException;

	/**
	* Returns the first topic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic, or <code>null</code> if a matching topic could not be found
	*/
	public Topic fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

	/**
	* Returns the last topic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic
	* @throws NoSuchTopicException if a matching topic could not be found
	*/
	public Topic findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator)
		throws NoSuchTopicException;

	/**
	* Returns the last topic in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic, or <code>null</code> if a matching topic could not be found
	*/
	public Topic fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

	/**
	* Returns the topics before and after the current topic in the ordered set where uuid = &#63;.
	*
	* @param topicId the primary key of the current topic
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic
	* @throws NoSuchTopicException if a topic with the primary key could not be found
	*/
	public Topic[] findByUuid_PrevAndNext(java.lang.String topicId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator)
		throws NoSuchTopicException;

	/**
	* Removes all the topics where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of topics where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching topics
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the topics where areaId = &#63;.
	*
	* @param areaId the area ID
	* @return the matching topics
	*/
	public java.util.List<Topic> findByAreasId(java.lang.String areaId);

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
	public java.util.List<Topic> findByAreasId(java.lang.String areaId,
		int start, int end);

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
	public java.util.List<Topic> findByAreasId(java.lang.String areaId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

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
	public java.util.List<Topic> findByAreasId(java.lang.String areaId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first topic in the ordered set where areaId = &#63;.
	*
	* @param areaId the area ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic
	* @throws NoSuchTopicException if a matching topic could not be found
	*/
	public Topic findByAreasId_First(java.lang.String areaId,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator)
		throws NoSuchTopicException;

	/**
	* Returns the first topic in the ordered set where areaId = &#63;.
	*
	* @param areaId the area ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching topic, or <code>null</code> if a matching topic could not be found
	*/
	public Topic fetchByAreasId_First(java.lang.String areaId,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

	/**
	* Returns the last topic in the ordered set where areaId = &#63;.
	*
	* @param areaId the area ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic
	* @throws NoSuchTopicException if a matching topic could not be found
	*/
	public Topic findByAreasId_Last(java.lang.String areaId,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator)
		throws NoSuchTopicException;

	/**
	* Returns the last topic in the ordered set where areaId = &#63;.
	*
	* @param areaId the area ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching topic, or <code>null</code> if a matching topic could not be found
	*/
	public Topic fetchByAreasId_Last(java.lang.String areaId,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

	/**
	* Returns the topics before and after the current topic in the ordered set where areaId = &#63;.
	*
	* @param topicId the primary key of the current topic
	* @param areaId the area ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next topic
	* @throws NoSuchTopicException if a topic with the primary key could not be found
	*/
	public Topic[] findByAreasId_PrevAndNext(java.lang.String topicId,
		java.lang.String areaId,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator)
		throws NoSuchTopicException;

	/**
	* Removes all the topics where areaId = &#63; from the database.
	*
	* @param areaId the area ID
	*/
	public void removeByAreasId(java.lang.String areaId);

	/**
	* Returns the number of topics where areaId = &#63;.
	*
	* @param areaId the area ID
	* @return the number of matching topics
	*/
	public int countByAreasId(java.lang.String areaId);

	/**
	* Caches the topic in the entity cache if it is enabled.
	*
	* @param topic the topic
	*/
	public void cacheResult(Topic topic);

	/**
	* Caches the topics in the entity cache if it is enabled.
	*
	* @param topics the topics
	*/
	public void cacheResult(java.util.List<Topic> topics);

	/**
	* Creates a new topic with the primary key. Does not add the topic to the database.
	*
	* @param topicId the primary key for the new topic
	* @return the new topic
	*/
	public Topic create(java.lang.String topicId);

	/**
	* Removes the topic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param topicId the primary key of the topic
	* @return the topic that was removed
	* @throws NoSuchTopicException if a topic with the primary key could not be found
	*/
	public Topic remove(java.lang.String topicId) throws NoSuchTopicException;

	public Topic updateImpl(Topic topic);

	/**
	* Returns the topic with the primary key or throws a {@link NoSuchTopicException} if it could not be found.
	*
	* @param topicId the primary key of the topic
	* @return the topic
	* @throws NoSuchTopicException if a topic with the primary key could not be found
	*/
	public Topic findByPrimaryKey(java.lang.String topicId)
		throws NoSuchTopicException;

	/**
	* Returns the topic with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param topicId the primary key of the topic
	* @return the topic, or <code>null</code> if a topic with the primary key could not be found
	*/
	public Topic fetchByPrimaryKey(java.lang.String topicId);

	@Override
	public java.util.Map<java.io.Serializable, Topic> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the topics.
	*
	* @return the topics
	*/
	public java.util.List<Topic> findAll();

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
	public java.util.List<Topic> findAll(int start, int end);

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
	public java.util.List<Topic> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator);

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
	public java.util.List<Topic> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Topic> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the topics from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of topics.
	*
	* @return the number of topics
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}