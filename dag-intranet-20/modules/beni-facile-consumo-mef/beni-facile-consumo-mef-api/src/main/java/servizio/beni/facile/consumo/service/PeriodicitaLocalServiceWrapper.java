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

package servizio.beni.facile.consumo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PeriodicitaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PeriodicitaLocalService
 * @generated
 */
@ProviderType
public class PeriodicitaLocalServiceWrapper implements PeriodicitaLocalService,
	ServiceWrapper<PeriodicitaLocalService> {
	public PeriodicitaLocalServiceWrapper(
		PeriodicitaLocalService periodicitaLocalService) {
		_periodicitaLocalService = periodicitaLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _periodicitaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _periodicitaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _periodicitaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _periodicitaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _periodicitaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of periodicitas.
	*
	* @return the number of periodicitas
	*/
	@Override
	public int getPeriodicitasCount() {
		return _periodicitaLocalService.getPeriodicitasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _periodicitaLocalService.getOSGiServiceIdentifier();
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
		return _periodicitaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _periodicitaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _periodicitaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the periodicitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.PeriodicitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of periodicitas
	* @param end the upper bound of the range of periodicitas (not inclusive)
	* @return the range of periodicitas
	*/
	@Override
	public java.util.List<servizio.beni.facile.consumo.model.Periodicita> getPeriodicitas(
		int start, int end) {
		return _periodicitaLocalService.getPeriodicitas(start, end);
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
		return _periodicitaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _periodicitaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the periodicita to the database. Also notifies the appropriate model listeners.
	*
	* @param periodicita the periodicita
	* @return the periodicita that was added
	*/
	@Override
	public servizio.beni.facile.consumo.model.Periodicita addPeriodicita(
		servizio.beni.facile.consumo.model.Periodicita periodicita) {
		return _periodicitaLocalService.addPeriodicita(periodicita);
	}

	/**
	* Creates a new periodicita with the primary key. Does not add the periodicita to the database.
	*
	* @param id the primary key for the new periodicita
	* @return the new periodicita
	*/
	@Override
	public servizio.beni.facile.consumo.model.Periodicita createPeriodicita(
		long id) {
		return _periodicitaLocalService.createPeriodicita(id);
	}

	/**
	* Deletes the periodicita with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita that was removed
	* @throws PortalException if a periodicita with the primary key could not be found
	*/
	@Override
	public servizio.beni.facile.consumo.model.Periodicita deletePeriodicita(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _periodicitaLocalService.deletePeriodicita(id);
	}

	/**
	* Deletes the periodicita from the database. Also notifies the appropriate model listeners.
	*
	* @param periodicita the periodicita
	* @return the periodicita that was removed
	*/
	@Override
	public servizio.beni.facile.consumo.model.Periodicita deletePeriodicita(
		servizio.beni.facile.consumo.model.Periodicita periodicita) {
		return _periodicitaLocalService.deletePeriodicita(periodicita);
	}

	@Override
	public servizio.beni.facile.consumo.model.Periodicita fetchPeriodicita(
		long id) {
		return _periodicitaLocalService.fetchPeriodicita(id);
	}

	/**
	* Returns the periodicita with the primary key.
	*
	* @param id the primary key of the periodicita
	* @return the periodicita
	* @throws PortalException if a periodicita with the primary key could not be found
	*/
	@Override
	public servizio.beni.facile.consumo.model.Periodicita getPeriodicita(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _periodicitaLocalService.getPeriodicita(id);
	}

	/**
	* Updates the periodicita in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param periodicita the periodicita
	* @return the periodicita that was updated
	*/
	@Override
	public servizio.beni.facile.consumo.model.Periodicita updatePeriodicita(
		servizio.beni.facile.consumo.model.Periodicita periodicita) {
		return _periodicitaLocalService.updatePeriodicita(periodicita);
	}

	@Override
	public PeriodicitaLocalService getWrappedService() {
		return _periodicitaLocalService;
	}

	@Override
	public void setWrappedService(
		PeriodicitaLocalService periodicitaLocalService) {
		_periodicitaLocalService = periodicitaLocalService;
	}

	private PeriodicitaLocalService _periodicitaLocalService;
}