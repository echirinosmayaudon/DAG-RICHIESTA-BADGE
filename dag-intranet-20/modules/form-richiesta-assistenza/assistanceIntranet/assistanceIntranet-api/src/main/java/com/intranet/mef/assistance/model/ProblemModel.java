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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Problem service. Represents a row in the &quot;Assistance_Problem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.intranet.mef.assistance.model.impl.ProblemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.intranet.mef.assistance.model.impl.ProblemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Problem
 * @see com.intranet.mef.assistance.model.impl.ProblemImpl
 * @see com.intranet.mef.assistance.model.impl.ProblemModelImpl
 * @generated
 */
@ProviderType
public interface ProblemModel extends BaseModel<Problem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a problem model instance should use the {@link Problem} interface instead.
	 */

	/**
	 * Returns the primary key of this problem.
	 *
	 * @return the primary key of this problem
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this problem.
	 *
	 * @param primaryKey the primary key of this problem
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this problem.
	 *
	 * @return the uuid of this problem
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this problem.
	 *
	 * @param uuid the uuid of this problem
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the problem ID of this problem.
	 *
	 * @return the problem ID of this problem
	 */
	@AutoEscape
	public String getProblemId();

	/**
	 * Sets the problem ID of this problem.
	 *
	 * @param problemId the problem ID of this problem
	 */
	public void setProblemId(String problemId);

	/**
	 * Returns the problem name of this problem.
	 *
	 * @return the problem name of this problem
	 */
	@AutoEscape
	public String getProblemName();

	/**
	 * Sets the problem name of this problem.
	 *
	 * @param problemName the problem name of this problem
	 */
	public void setProblemName(String problemName);

	/**
	 * Returns the topic ID of this problem.
	 *
	 * @return the topic ID of this problem
	 */
	@AutoEscape
	public String getTopicId();

	/**
	 * Sets the topic ID of this problem.
	 *
	 * @param topicId the topic ID of this problem
	 */
	public void setTopicId(String topicId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Problem problem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Problem> toCacheModel();

	@Override
	public Problem toEscapedModel();

	@Override
	public Problem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}