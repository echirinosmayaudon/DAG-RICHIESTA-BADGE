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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Problem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Problem
 * @generated
 */
@ProviderType
public class ProblemWrapper implements Problem, ModelWrapper<Problem> {
	public ProblemWrapper(Problem problem) {
		_problem = problem;
	}

	@Override
	public Class<?> getModelClass() {
		return Problem.class;
	}

	@Override
	public String getModelClassName() {
		return Problem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("problemId", getProblemId());
		attributes.put("problemName", getProblemName());
		attributes.put("topicId", getTopicId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String problemId = (String)attributes.get("problemId");

		if (problemId != null) {
			setProblemId(problemId);
		}

		String problemName = (String)attributes.get("problemName");

		if (problemName != null) {
			setProblemName(problemName);
		}

		String topicId = (String)attributes.get("topicId");

		if (topicId != null) {
			setTopicId(topicId);
		}
	}

	@Override
	public Problem toEscapedModel() {
		return new ProblemWrapper(_problem.toEscapedModel());
	}

	@Override
	public Problem toUnescapedModel() {
		return new ProblemWrapper(_problem.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _problem.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _problem.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _problem.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _problem.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Problem> toCacheModel() {
		return _problem.toCacheModel();
	}

	@Override
	public int compareTo(Problem problem) {
		return _problem.compareTo(problem);
	}

	@Override
	public int hashCode() {
		return _problem.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _problem.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ProblemWrapper((Problem)_problem.clone());
	}

	/**
	* Returns the primary key of this problem.
	*
	* @return the primary key of this problem
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _problem.getPrimaryKey();
	}

	/**
	* Returns the problem ID of this problem.
	*
	* @return the problem ID of this problem
	*/
	@Override
	public java.lang.String getProblemId() {
		return _problem.getProblemId();
	}

	/**
	* Returns the problem name of this problem.
	*
	* @return the problem name of this problem
	*/
	@Override
	public java.lang.String getProblemName() {
		return _problem.getProblemName();
	}

	/**
	* Returns the topic ID of this problem.
	*
	* @return the topic ID of this problem
	*/
	@Override
	public java.lang.String getTopicId() {
		return _problem.getTopicId();
	}

	/**
	* Returns the uuid of this problem.
	*
	* @return the uuid of this problem
	*/
	@Override
	public java.lang.String getUuid() {
		return _problem.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _problem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _problem.toXmlString();
	}

	@Override
	public void persist() {
		_problem.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_problem.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_problem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_problem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_problem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_problem.setNew(n);
	}

	/**
	* Sets the primary key of this problem.
	*
	* @param primaryKey the primary key of this problem
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_problem.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_problem.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the problem ID of this problem.
	*
	* @param problemId the problem ID of this problem
	*/
	@Override
	public void setProblemId(java.lang.String problemId) {
		_problem.setProblemId(problemId);
	}

	/**
	* Sets the problem name of this problem.
	*
	* @param problemName the problem name of this problem
	*/
	@Override
	public void setProblemName(java.lang.String problemName) {
		_problem.setProblemName(problemName);
	}

	/**
	* Sets the topic ID of this problem.
	*
	* @param topicId the topic ID of this problem
	*/
	@Override
	public void setTopicId(java.lang.String topicId) {
		_problem.setTopicId(topicId);
	}

	/**
	* Sets the uuid of this problem.
	*
	* @param uuid the uuid of this problem
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_problem.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProblemWrapper)) {
			return false;
		}

		ProblemWrapper problemWrapper = (ProblemWrapper)obj;

		if (Objects.equals(_problem, problemWrapper._problem)) {
			return true;
		}

		return false;
	}

	@Override
	public Problem getWrappedModel() {
		return _problem;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _problem.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _problem.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_problem.resetOriginalValues();
	}

	private final Problem _problem;
}