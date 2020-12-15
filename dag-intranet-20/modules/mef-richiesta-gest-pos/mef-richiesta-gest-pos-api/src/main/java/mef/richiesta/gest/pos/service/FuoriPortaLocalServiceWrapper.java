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
 * Provides a wrapper for {@link FuoriPortaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FuoriPortaLocalService
 * @generated
 */
@ProviderType
public class FuoriPortaLocalServiceWrapper
	implements FuoriPortaLocalService, ServiceWrapper<FuoriPortaLocalService> {

	public FuoriPortaLocalServiceWrapper(
		FuoriPortaLocalService fuoriPortaLocalService) {

		_fuoriPortaLocalService = fuoriPortaLocalService;
	}

	/**
	 * Adds the fuori porta to the database. Also notifies the appropriate model listeners.
	 *
	 * @param fuoriPorta the fuori porta
	 * @return the fuori porta that was added
	 */
	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta addFuoriPorta(
		mef.richiesta.gest.pos.model.FuoriPorta fuoriPorta) {

		return _fuoriPortaLocalService.addFuoriPorta(fuoriPorta);
	}

	/**
	 * Creates a new fuori porta with the primary key. Does not add the fuori porta to the database.
	 *
	 * @param id_pk_fuoriPorta the primary key for the new fuori porta
	 * @return the new fuori porta
	 */
	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta createFuoriPorta(
		long id_pk_fuoriPorta) {

		return _fuoriPortaLocalService.createFuoriPorta(id_pk_fuoriPorta);
	}

	/**
	 * Deletes the fuori porta from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fuoriPorta the fuori porta
	 * @return the fuori porta that was removed
	 */
	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta deleteFuoriPorta(
		mef.richiesta.gest.pos.model.FuoriPorta fuoriPorta) {

		return _fuoriPortaLocalService.deleteFuoriPorta(fuoriPorta);
	}

	/**
	 * Deletes the fuori porta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta that was removed
	 * @throws PortalException if a fuori porta with the primary key could not be found
	 */
	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta deleteFuoriPorta(
			long id_pk_fuoriPorta)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fuoriPortaLocalService.deleteFuoriPorta(id_pk_fuoriPorta);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fuoriPortaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fuoriPortaLocalService.dynamicQuery();
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

		return _fuoriPortaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _fuoriPortaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _fuoriPortaLocalService.dynamicQuery(
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

		return _fuoriPortaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fuoriPortaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta fetchFuoriPorta(
		long id_pk_fuoriPorta) {

		return _fuoriPortaLocalService.fetchFuoriPorta(id_pk_fuoriPorta);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fuoriPortaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the fuori porta with the primary key.
	 *
	 * @param id_pk_fuoriPorta the primary key of the fuori porta
	 * @return the fuori porta
	 * @throws PortalException if a fuori porta with the primary key could not be found
	 */
	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta getFuoriPorta(
			long id_pk_fuoriPorta)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fuoriPortaLocalService.getFuoriPorta(id_pk_fuoriPorta);
	}

	@Override
	public java.util.List<mef.richiesta.gest.pos.model.FuoriPorta>
		getFuoriPortaFromCorridoio(long idCorridoio) {

		return _fuoriPortaLocalService.getFuoriPortaFromCorridoio(idCorridoio);
	}

	/**
	 * Returns a range of all the fuori portas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.FuoriPortaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fuori portas
	 * @param end the upper bound of the range of fuori portas (not inclusive)
	 * @return the range of fuori portas
	 */
	@Override
	public java.util.List<mef.richiesta.gest.pos.model.FuoriPorta>
		getFuoriPortas(int start, int end) {

		return _fuoriPortaLocalService.getFuoriPortas(start, end);
	}

	/**
	 * Returns the number of fuori portas.
	 *
	 * @return the number of fuori portas
	 */
	@Override
	public int getFuoriPortasCount() {
		return _fuoriPortaLocalService.getFuoriPortasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fuoriPortaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fuoriPortaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fuoriPortaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fuori porta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param fuoriPorta the fuori porta
	 * @return the fuori porta that was updated
	 */
	@Override
	public mef.richiesta.gest.pos.model.FuoriPorta updateFuoriPorta(
		mef.richiesta.gest.pos.model.FuoriPorta fuoriPorta) {

		return _fuoriPortaLocalService.updateFuoriPorta(fuoriPorta);
	}

	@Override
	public FuoriPortaLocalService getWrappedService() {
		return _fuoriPortaLocalService;
	}

	@Override
	public void setWrappedService(
		FuoriPortaLocalService fuoriPortaLocalService) {

		_fuoriPortaLocalService = fuoriPortaLocalService;
	}

	private FuoriPortaLocalService _fuoriPortaLocalService;

}