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

package servizio.prenotazione.aule.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApprovatoreLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApprovatoreLocalService
 * @generated
 */
@ProviderType
public class ApprovatoreLocalServiceWrapper implements ApprovatoreLocalService,
	ServiceWrapper<ApprovatoreLocalService> {
	public ApprovatoreLocalServiceWrapper(
		ApprovatoreLocalService approvatoreLocalService) {
		_approvatoreLocalService = approvatoreLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _approvatoreLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _approvatoreLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _approvatoreLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _approvatoreLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _approvatoreLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of approvatores.
	*
	* @return the number of approvatores
	*/
	@Override
	public int getApprovatoresCount() {
		return _approvatoreLocalService.getApprovatoresCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _approvatoreLocalService.getOSGiServiceIdentifier();
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
		return _approvatoreLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _approvatoreLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _approvatoreLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the approvatores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.ApprovatoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of approvatores
	* @param end the upper bound of the range of approvatores (not inclusive)
	* @return the range of approvatores
	*/
	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Approvatore> getApprovatores(
		int start, int end) {
		return _approvatoreLocalService.getApprovatores(start, end);
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Approvatore> getApprovatoriListByIdSala(
		long id_sala) {
		return _approvatoreLocalService.getApprovatoriListByIdSala(id_sala);
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
		return _approvatoreLocalService.dynamicQueryCount(dynamicQuery);
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
		return _approvatoreLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the approvatore to the database. Also notifies the appropriate model listeners.
	*
	* @param approvatore the approvatore
	* @return the approvatore that was added
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore addApprovatore(
		servizio.prenotazione.aule.mef.model.Approvatore approvatore) {
		return _approvatoreLocalService.addApprovatore(approvatore);
	}

	/**
	* Creates a new approvatore with the primary key. Does not add the approvatore to the database.
	*
	* @param id_approvatore the primary key for the new approvatore
	* @return the new approvatore
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore createApprovatore(
		long id_approvatore) {
		return _approvatoreLocalService.createApprovatore(id_approvatore);
	}

	/**
	* Deletes the approvatore with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore that was removed
	* @throws PortalException if a approvatore with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore deleteApprovatore(
		long id_approvatore)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _approvatoreLocalService.deleteApprovatore(id_approvatore);
	}

	/**
	* Deletes the approvatore from the database. Also notifies the appropriate model listeners.
	*
	* @param approvatore the approvatore
	* @return the approvatore that was removed
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore deleteApprovatore(
		servizio.prenotazione.aule.mef.model.Approvatore approvatore) {
		return _approvatoreLocalService.deleteApprovatore(approvatore);
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore fetchApprovatore(
		long id_approvatore) {
		return _approvatoreLocalService.fetchApprovatore(id_approvatore);
	}

	/**
	* Returns the approvatore with the primary key.
	*
	* @param id_approvatore the primary key of the approvatore
	* @return the approvatore
	* @throws PortalException if a approvatore with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore getApprovatore(
		long id_approvatore)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _approvatoreLocalService.getApprovatore(id_approvatore);
	}

	/**
	* Updates the approvatore in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param approvatore the approvatore
	* @return the approvatore that was updated
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore updateApprovatore(
		servizio.prenotazione.aule.mef.model.Approvatore approvatore) {
		return _approvatoreLocalService.updateApprovatore(approvatore);
	}

	@Override
	public ApprovatoreLocalService getWrappedService() {
		return _approvatoreLocalService;
	}

	@Override
	public void setWrappedService(
		ApprovatoreLocalService approvatoreLocalService) {
		_approvatoreLocalService = approvatoreLocalService;
	}

	private ApprovatoreLocalService _approvatoreLocalService;
}