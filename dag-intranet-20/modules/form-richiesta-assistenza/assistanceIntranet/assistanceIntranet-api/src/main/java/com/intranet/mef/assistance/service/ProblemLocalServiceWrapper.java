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

package com.intranet.mef.assistance.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProblemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProblemLocalService
 * @generated
 */
@ProviderType
public class ProblemLocalServiceWrapper implements ProblemLocalService,
	ServiceWrapper<ProblemLocalService> {
	public ProblemLocalServiceWrapper(ProblemLocalService problemLocalService) {
		_problemLocalService = problemLocalService;
	}

	/**
	* Adds the problem to the database. Also notifies the appropriate model listeners.
	*
	* @param problem the problem
	* @return the problem that was added
	*/
	@Override
	public com.intranet.mef.assistance.model.Problem addProblem(
		com.intranet.mef.assistance.model.Problem problem) {
		return _problemLocalService.addProblem(problem);
	}

	/**
	* Creates a new problem with the primary key. Does not add the problem to the database.
	*
	* @param problemId the primary key for the new problem
	* @return the new problem
	*/
	@Override
	public com.intranet.mef.assistance.model.Problem createProblem(
		java.lang.String problemId) {
		return _problemLocalService.createProblem(problemId);
	}

	/**
	* Deletes the problem from the database. Also notifies the appropriate model listeners.
	*
	* @param problem the problem
	* @return the problem that was removed
	*/
	@Override
	public com.intranet.mef.assistance.model.Problem deleteProblem(
		com.intranet.mef.assistance.model.Problem problem) {
		return _problemLocalService.deleteProblem(problem);
	}

	/**
	* Deletes the problem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param problemId the primary key of the problem
	* @return the problem that was removed
	* @throws PortalException if a problem with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.assistance.model.Problem deleteProblem(
		java.lang.String problemId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _problemLocalService.deleteProblem(problemId);
	}

	@Override
	public com.intranet.mef.assistance.model.Problem fetchProblem(
		java.lang.String problemId) {
		return _problemLocalService.fetchProblem(problemId);
	}

	/**
	* Returns the problem with the primary key.
	*
	* @param problemId the primary key of the problem
	* @return the problem
	* @throws PortalException if a problem with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.assistance.model.Problem getProblem(
		java.lang.String problemId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _problemLocalService.getProblem(problemId);
	}

	/**
	* Updates the problem in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param problem the problem
	* @return the problem that was updated
	*/
	@Override
	public com.intranet.mef.assistance.model.Problem updateProblem(
		com.intranet.mef.assistance.model.Problem problem) {
		return _problemLocalService.updateProblem(problem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _problemLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _problemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _problemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of problems.
	*
	* @return the number of problems
	*/
	@Override
	public int getProblemsCount() {
		return _problemLocalService.getProblemsCount();
	}

	@Override
	public java.lang.String findProblemNameByPK(java.lang.String problemId) {
		return _problemLocalService.findProblemNameByPK(problemId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _problemLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _problemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _problemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _problemLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.assistance.model.Problem> findByTopicId(
		java.lang.String topicId) {
		return _problemLocalService.findByTopicId(topicId);
	}

	/**
	* Returns a range of all the problems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.assistance.model.impl.ProblemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of problems
	* @param end the upper bound of the range of problems (not inclusive)
	* @return the range of problems
	*/
	@Override
	public java.util.List<com.intranet.mef.assistance.model.Problem> getProblems(
		int start, int end) {
		return _problemLocalService.getProblems(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _problemLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _problemLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void add(java.lang.String problemId, java.lang.String problemName,
		java.lang.String topicId) {
		_problemLocalService.add(problemId, problemName, topicId);
	}

	@Override
	public void removeAll() {
		_problemLocalService.removeAll();
	}

	@Override
	public ProblemLocalService getWrappedService() {
		return _problemLocalService;
	}

	@Override
	public void setWrappedService(ProblemLocalService problemLocalService) {
		_problemLocalService = problemLocalService;
	}

	private ProblemLocalService _problemLocalService;
}