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

package external.bfc.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RichiesteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteLocalService
 * @generated
 */
@ProviderType
public class RichiesteLocalServiceWrapper implements RichiesteLocalService,
	ServiceWrapper<RichiesteLocalService> {
	public RichiesteLocalServiceWrapper(
		RichiesteLocalService richiesteLocalService) {
		_richiesteLocalService = richiesteLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _richiesteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _richiesteLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _richiesteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the richieste to the database. Also notifies the appropriate model listeners.
	*
	* @param richieste the richieste
	* @return the richieste that was added
	*/
	@Override
	public external.bfc.intranet.mef.model.Richieste addRichieste(
		external.bfc.intranet.mef.model.Richieste richieste) {
		return _richiesteLocalService.addRichieste(richieste);
	}

	/**
	* Creates a new richieste with the primary key. Does not add the richieste to the database.
	*
	* @param id the primary key for the new richieste
	* @return the new richieste
	*/
	@Override
	public external.bfc.intranet.mef.model.Richieste createRichieste(long id) {
		return _richiesteLocalService.createRichieste(id);
	}

	/**
	* Deletes the richieste from the database. Also notifies the appropriate model listeners.
	*
	* @param richieste the richieste
	* @return the richieste that was removed
	*/
	@Override
	public external.bfc.intranet.mef.model.Richieste deleteRichieste(
		external.bfc.intranet.mef.model.Richieste richieste) {
		return _richiesteLocalService.deleteRichieste(richieste);
	}

	/**
	* Deletes the richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richieste
	* @return the richieste that was removed
	* @throws PortalException if a richieste with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.Richieste deleteRichieste(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteLocalService.deleteRichieste(id);
	}

	@Override
	public external.bfc.intranet.mef.model.Richieste fetchRichieste(long id) {
		return _richiesteLocalService.fetchRichieste(id);
	}

	/**
	* Returns the richieste with the primary key.
	*
	* @param id the primary key of the richieste
	* @return the richieste
	* @throws PortalException if a richieste with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.Richieste getRichieste(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteLocalService.getRichieste(id);
	}

	/**
	* Updates the richieste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richieste the richieste
	* @return the richieste that was updated
	*/
	@Override
	public external.bfc.intranet.mef.model.Richieste updateRichieste(
		external.bfc.intranet.mef.model.Richieste richieste) {
		return _richiesteLocalService.updateRichieste(richieste);
	}

	/**
	* Returns the number of richiestes.
	*
	* @return the number of richiestes
	*/
	@Override
	public int getRichiestesCount() {
		return _richiesteLocalService.getRichiestesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _richiesteLocalService.getOSGiServiceIdentifier();
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
		return _richiesteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _richiesteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _richiesteLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<external.bfc.intranet.mef.model.Richieste> findByfilters(
		java.util.List<java.lang.Long> lista_stati,
		java.util.List<java.lang.String> ufficio,
		java.util.List<com.liferay.portal.kernel.model.User> lista_utenti) {
		return _richiesteLocalService.findByfilters(lista_stati, ufficio,
			lista_utenti);
	}

	@Override
	public java.util.List<external.bfc.intranet.mef.model.Richieste> getRichiestebyEmail(
		java.lang.String email) {
		return _richiesteLocalService.getRichiestebyEmail(email);
	}

	/**
	* Returns a range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @return the range of richiestes
	*/
	@Override
	public java.util.List<external.bfc.intranet.mef.model.Richieste> getRichiestes(
		int start, int end) {
		return _richiesteLocalService.getRichiestes(start, end);
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
		return _richiesteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _richiesteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public RichiesteLocalService getWrappedService() {
		return _richiesteLocalService;
	}

	@Override
	public void setWrappedService(RichiesteLocalService richiesteLocalService) {
		_richiesteLocalService = richiesteLocalService;
	}

	private RichiesteLocalService _richiesteLocalService;
}