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

package mef.richiesta.gest.pos.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CorridoioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CorridoioLocalService
 * @generated
 */
@ProviderType
public class CorridoioLocalServiceWrapper
	implements CorridoioLocalService, ServiceWrapper<CorridoioLocalService> {

	public CorridoioLocalServiceWrapper(
		CorridoioLocalService corridoioLocalService) {

		_corridoioLocalService = corridoioLocalService;
	}

	/**
	 * Adds the corridoio to the database. Also notifies the appropriate model listeners.
	 *
	 * @param corridoio the corridoio
	 * @return the corridoio that was added
	 */
	@Override
	public mef.richiesta.gest.pos.model.Corridoio addCorridoio(
		mef.richiesta.gest.pos.model.Corridoio corridoio) {

		return _corridoioLocalService.addCorridoio(corridoio);
	}

	/**
	 * Creates a new corridoio with the primary key. Does not add the corridoio to the database.
	 *
	 * @param id_pk_corridoio the primary key for the new corridoio
	 * @return the new corridoio
	 */
	@Override
	public mef.richiesta.gest.pos.model.Corridoio createCorridoio(
		long id_pk_corridoio) {

		return _corridoioLocalService.createCorridoio(id_pk_corridoio);
	}

	/**
	 * Deletes the corridoio from the database. Also notifies the appropriate model listeners.
	 *
	 * @param corridoio the corridoio
	 * @return the corridoio that was removed
	 */
	@Override
	public mef.richiesta.gest.pos.model.Corridoio deleteCorridoio(
		mef.richiesta.gest.pos.model.Corridoio corridoio) {

		return _corridoioLocalService.deleteCorridoio(corridoio);
	}

	/**
	 * Deletes the corridoio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio that was removed
	 * @throws PortalException if a corridoio with the primary key could not be found
	 */
	@Override
	public mef.richiesta.gest.pos.model.Corridoio deleteCorridoio(
			long id_pk_corridoio)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _corridoioLocalService.deleteCorridoio(id_pk_corridoio);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _corridoioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _corridoioLocalService.dynamicQuery();
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

		return _corridoioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _corridoioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _corridoioLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
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

		return _corridoioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _corridoioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public mef.richiesta.gest.pos.model.Corridoio fetchCorridoio(
		long id_pk_corridoio) {

		return _corridoioLocalService.fetchCorridoio(id_pk_corridoio);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _corridoioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the corridoio with the primary key.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio
	 * @throws PortalException if a corridoio with the primary key could not be found
	 */
	@Override
	public mef.richiesta.gest.pos.model.Corridoio getCorridoio(
			long id_pk_corridoio)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _corridoioLocalService.getCorridoio(id_pk_corridoio);
	}

	@Override
	public java.util.List<mef.richiesta.gest.pos.model.Corridoio>
		getCorridoioFromPiano(long idPiano) {

		return _corridoioLocalService.getCorridoioFromPiano(idPiano);
	}

	/**
	 * Returns a range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @return the range of corridoios
	 */
	@Override
	public java.util.List<mef.richiesta.gest.pos.model.Corridoio> getCorridoios(
		int start, int end) {

		return _corridoioLocalService.getCorridoios(start, end);
	}

	/**
	 * Returns the number of corridoios.
	 *
	 * @return the number of corridoios
	 */
	@Override
	public int getCorridoiosCount() {
		return _corridoioLocalService.getCorridoiosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _corridoioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _corridoioLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _corridoioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the corridoio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param corridoio the corridoio
	 * @return the corridoio that was updated
	 */
	@Override
	public mef.richiesta.gest.pos.model.Corridoio updateCorridoio(
		mef.richiesta.gest.pos.model.Corridoio corridoio) {

		return _corridoioLocalService.updateCorridoio(corridoio);
	}

	@Override
	public CorridoioLocalService getWrappedService() {
		return _corridoioLocalService;
	}

	@Override
	public void setWrappedService(CorridoioLocalService corridoioLocalService) {
		_corridoioLocalService = corridoioLocalService;
	}

	private CorridoioLocalService _corridoioLocalService;

}