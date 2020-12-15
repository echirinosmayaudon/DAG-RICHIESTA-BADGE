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

package com.intranet.mef.assistance.service.impl;

import java.util.List;

import com.intranet.mef.assistance.model.Topic;
import com.intranet.mef.assistance.service.base.TopicLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the topic local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.assistance.service.TopicLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.TopicLocalServiceUtil
 */
@ProviderType
public class TopicLocalServiceImpl extends TopicLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.assistance.service.TopicLocalServiceUtil} to access the topic local service.
	 */

	public void add(String topicId, String topicName, String areaId){

		Topic topic= topicPersistence.create(topicId);
		topic.setTopicName(topicName); 
		topic.setAreaId(areaId); 

		topicPersistence.update(topic);		

	}

	public String findTopicNameByPK(String topicId){
		Topic topic = topicPersistence.fetchByPrimaryKey(topicId);
		return topic.getTopicName() ;
	}

	public List<Topic> findByAreaId(String areaId){
		List<Topic> topicArray = topicPersistence.findByAreasId(areaId);
		return topicArray;
	}

	public void removeAll(){
		topicPersistence.removeAll();
	}
}