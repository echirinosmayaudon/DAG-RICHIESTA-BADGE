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

package com.intranet.mef.job.siap.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersonalAbsenceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersonalAbsenceLocalService
 * @generated
 */
@ProviderType
public class PersonalAbsenceLocalServiceWrapper
	implements PersonalAbsenceLocalService,
		ServiceWrapper<PersonalAbsenceLocalService> {
	public PersonalAbsenceLocalServiceWrapper(
		PersonalAbsenceLocalService personalAbsenceLocalService) {
		_personalAbsenceLocalService = personalAbsenceLocalService;
	}

	/**
	* Adds the personal absence to the database. Also notifies the appropriate model listeners.
	*
	* @param personalAbsence the personal absence
	* @return the personal absence that was added
	*/
	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence addPersonalAbsence(
		com.intranet.mef.job.siap.model.PersonalAbsence personalAbsence) {
		return _personalAbsenceLocalService.addPersonalAbsence(personalAbsence);
	}

	/**
	* Creates a new personal absence with the primary key. Does not add the personal absence to the database.
	*
	* @param custom_key the primary key for the new personal absence
	* @return the new personal absence
	*/
	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence createPersonalAbsence(
		java.lang.String custom_key) {
		return _personalAbsenceLocalService.createPersonalAbsence(custom_key);
	}

	/**
	* Deletes the personal absence from the database. Also notifies the appropriate model listeners.
	*
	* @param personalAbsence the personal absence
	* @return the personal absence that was removed
	*/
	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence deletePersonalAbsence(
		com.intranet.mef.job.siap.model.PersonalAbsence personalAbsence) {
		return _personalAbsenceLocalService.deletePersonalAbsence(personalAbsence);
	}

	/**
	* Deletes the personal absence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence that was removed
	* @throws PortalException if a personal absence with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence deletePersonalAbsence(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personalAbsenceLocalService.deletePersonalAbsence(custom_key);
	}

	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence fetchPersonalAbsence(
		java.lang.String custom_key) {
		return _personalAbsenceLocalService.fetchPersonalAbsence(custom_key);
	}

	/**
	* Returns the personal absence with the primary key.
	*
	* @param custom_key the primary key of the personal absence
	* @return the personal absence
	* @throws PortalException if a personal absence with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence getPersonalAbsence(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personalAbsenceLocalService.getPersonalAbsence(custom_key);
	}

	/**
	* Updates the personal absence in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param personalAbsence the personal absence
	* @return the personal absence that was updated
	*/
	@Override
	public com.intranet.mef.job.siap.model.PersonalAbsence updatePersonalAbsence(
		com.intranet.mef.job.siap.model.PersonalAbsence personalAbsence) {
		return _personalAbsenceLocalService.updatePersonalAbsence(personalAbsence);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personalAbsenceLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personalAbsenceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _personalAbsenceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of personal absences.
	*
	* @return the number of personal absences
	*/
	@Override
	public int getPersonalAbsencesCount() {
		return _personalAbsenceLocalService.getPersonalAbsencesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _personalAbsenceLocalService.getOSGiServiceIdentifier();
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
		return _personalAbsenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _personalAbsenceLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _personalAbsenceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.job.siap.model.PersonalAbsence> getByPersonIdAndRefMonth(
		long personId, java.lang.String refMonth) {
		return _personalAbsenceLocalService.getByPersonIdAndRefMonth(personId,
			refMonth);
	}

	/**
	* Returns a range of all the personal absences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.job.siap.model.impl.PersonalAbsenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of personal absences
	* @param end the upper bound of the range of personal absences (not inclusive)
	* @return the range of personal absences
	*/
	@Override
	public java.util.List<com.intranet.mef.job.siap.model.PersonalAbsence> getPersonalAbsences(
		int start, int end) {
		return _personalAbsenceLocalService.getPersonalAbsences(start, end);
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
		return _personalAbsenceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _personalAbsenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public PersonalAbsenceLocalService getWrappedService() {
		return _personalAbsenceLocalService;
	}

	@Override
	public void setWrappedService(
		PersonalAbsenceLocalService personalAbsenceLocalService) {
		_personalAbsenceLocalService = personalAbsenceLocalService;
	}

	private PersonalAbsenceLocalService _personalAbsenceLocalService;
}