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
 * Provides a wrapper for {@link StatoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatoLocalService
 * @generated
 */
@ProviderType
public class StatoLocalServiceWrapper implements StatoLocalService,
	ServiceWrapper<StatoLocalService> {
	public StatoLocalServiceWrapper(StatoLocalService statoLocalService) {
		_statoLocalService = statoLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _statoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statoLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _statoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of statos.
	*
	* @return the number of statos
	*/
	@Override
	public int getStatosCount() {
		return _statoLocalService.getStatosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _statoLocalService.getOSGiServiceIdentifier();
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
		return _statoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the statos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.StatoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statos
	* @param end the upper bound of the range of statos (not inclusive)
	* @return the range of statos
	*/
	@Override
	public java.util.List<servizio.beni.facile.consumo.model.Stato> getStatos(
		int start, int end) {
		return _statoLocalService.getStatos(start, end);
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
		return _statoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _statoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the stato to the database. Also notifies the appropriate model listeners.
	*
	* @param stato the stato
	* @return the stato that was added
	*/
	@Override
	public servizio.beni.facile.consumo.model.Stato addStato(
		servizio.beni.facile.consumo.model.Stato stato) {
		return _statoLocalService.addStato(stato);
	}

	/**
	* Creates a new stato with the primary key. Does not add the stato to the database.
	*
	* @param id the primary key for the new stato
	* @return the new stato
	*/
	@Override
	public servizio.beni.facile.consumo.model.Stato createStato(long id) {
		return _statoLocalService.createStato(id);
	}

	/**
	* Deletes the stato with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the stato
	* @return the stato that was removed
	* @throws PortalException if a stato with the primary key could not be found
	*/
	@Override
	public servizio.beni.facile.consumo.model.Stato deleteStato(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoLocalService.deleteStato(id);
	}

	/**
	* Deletes the stato from the database. Also notifies the appropriate model listeners.
	*
	* @param stato the stato
	* @return the stato that was removed
	*/
	@Override
	public servizio.beni.facile.consumo.model.Stato deleteStato(
		servizio.beni.facile.consumo.model.Stato stato) {
		return _statoLocalService.deleteStato(stato);
	}

	@Override
	public servizio.beni.facile.consumo.model.Stato fetchStato(long id) {
		return _statoLocalService.fetchStato(id);
	}

	/**
	* Returns the stato with the primary key.
	*
	* @param id the primary key of the stato
	* @return the stato
	* @throws PortalException if a stato with the primary key could not be found
	*/
	@Override
	public servizio.beni.facile.consumo.model.Stato getStato(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoLocalService.getStato(id);
	}

	/**
	* Updates the stato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param stato the stato
	* @return the stato that was updated
	*/
	@Override
	public servizio.beni.facile.consumo.model.Stato updateStato(
		servizio.beni.facile.consumo.model.Stato stato) {
		return _statoLocalService.updateStato(stato);
	}

	@Override
	public StatoLocalService getWrappedService() {
		return _statoLocalService;
	}

	@Override
	public void setWrappedService(StatoLocalService statoLocalService) {
		_statoLocalService = statoLocalService;
	}

	private StatoLocalService _statoLocalService;
}