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

package com.intranet.mef.assistance.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Topic service. Represents a row in the &quot;Assistance_Topic&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TopicModel
 * @see com.intranet.mef.assistance.model.impl.TopicImpl
 * @see com.intranet.mef.assistance.model.impl.TopicModelImpl
 * @generated
 */
@ImplementationClassName("com.intranet.mef.assistance.model.impl.TopicImpl")
@ProviderType
public interface Topic extends TopicModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.intranet.mef.assistance.model.impl.TopicImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Topic, String> TOPIC_ID_ACCESSOR = new Accessor<Topic, String>() {
			@Override
			public String get(Topic topic) {
				return topic.getTopicId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Topic> getTypeClass() {
				return Topic.class;
			}
		};
}