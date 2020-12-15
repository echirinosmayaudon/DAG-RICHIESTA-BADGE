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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SegreteriaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SegreteriaLocalService
 * @generated
 */
@ProviderType
public class SegreteriaLocalServiceWrapper implements SegreteriaLocalService,
	ServiceWrapper<SegreteriaLocalService> {
	public SegreteriaLocalServiceWrapper(
		SegreteriaLocalService segreteriaLocalService) {
		_segreteriaLocalService = segreteriaLocalService;
	}

	/**
	* Adds the segreteria to the database. Also notifies the appropriate model listeners.
	*
	* @param segreteria the segreteria
	* @return the segreteria that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria addSegreteria(
		com.intranet.mef.gestione.riunioni.model.Segreteria segreteria) {
		return _segreteriaLocalService.addSegreteria(segreteria);
	}

	/**
	* Creates a new segreteria with the primary key. Does not add the segreteria to the database.
	*
	* @param id_segreteria the primary key for the new segreteria
	* @return the new segreteria
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria createSegreteria(
		long id_segreteria) {
		return _segreteriaLocalService.createSegreteria(id_segreteria);
	}

	/**
	* Deletes the segreteria from the database. Also notifies the appropriate model listeners.
	*
	* @param segreteria the segreteria
	* @return the segreteria that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria deleteSegreteria(
		com.intranet.mef.gestione.riunioni.model.Segreteria segreteria) {
		return _segreteriaLocalService.deleteSegreteria(segreteria);
	}

	/**
	* Deletes the segreteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria that was removed
	* @throws PortalException if a segreteria with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria deleteSegreteria(
		long id_segreteria)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segreteriaLocalService.deleteSegreteria(id_segreteria);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria fetchSegreteria(
		long id_segreteria) {
		return _segreteriaLocalService.fetchSegreteria(id_segreteria);
	}

	/**
	* Returns the segreteria with the primary key.
	*
	* @param id_segreteria the primary key of the segreteria
	* @return the segreteria
	* @throws PortalException if a segreteria with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria getSegreteria(
		long id_segreteria)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segreteriaLocalService.getSegreteria(id_segreteria);
	}

	/**
	* Updates the segreteria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param segreteria the segreteria
	* @return the segreteria that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Segreteria updateSegreteria(
		com.intranet.mef.gestione.riunioni.model.Segreteria segreteria) {
		return _segreteriaLocalService.updateSegreteria(segreteria);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _segreteriaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _segreteriaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _segreteriaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segreteriaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segreteriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of segreterias.
	*
	* @return the number of segreterias
	*/
	@Override
	public int getSegreteriasCount() {
		return _segreteriaLocalService.getSegreteriasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _segreteriaLocalService.getOSGiServiceIdentifier();
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
		return _segreteriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _segreteriaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _segreteriaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the segreterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.SegreteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segreterias
	* @param end the upper bound of the range of segreterias (not inclusive)
	* @return the range of segreterias
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.Segreteria> getSegreterias(
		int start, int end) {
		return _segreteriaLocalService.getSegreterias(start, end);
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
		return _segreteriaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _segreteriaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public SegreteriaLocalService getWrappedService() {
		return _segreteriaLocalService;
	}

	@Override
	public void setWrappedService(SegreteriaLocalService segreteriaLocalService) {
		_segreteriaLocalService = segreteriaLocalService;
	}

	private SegreteriaLocalService _segreteriaLocalService;
}