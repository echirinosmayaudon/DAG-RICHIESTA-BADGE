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

package servizio.richieste.badge.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OggettoRichiestaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiestaLocalService
 * @generated
 */
@ProviderType
public class OggettoRichiestaLocalServiceWrapper
	implements OggettoRichiestaLocalService,
		ServiceWrapper<OggettoRichiestaLocalService> {
	public OggettoRichiestaLocalServiceWrapper(
		OggettoRichiestaLocalService oggettoRichiestaLocalService) {
		_oggettoRichiestaLocalService = oggettoRichiestaLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _oggettoRichiestaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _oggettoRichiestaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _oggettoRichiestaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _oggettoRichiestaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _oggettoRichiestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of oggetto richiestas.
	*
	* @return the number of oggetto richiestas
	*/
	@Override
	public int getOggettoRichiestasCount() {
		return _oggettoRichiestaLocalService.getOggettoRichiestasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _oggettoRichiestaLocalService.getOSGiServiceIdentifier();
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
		return _oggettoRichiestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _oggettoRichiestaLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _oggettoRichiestaLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @return the range of oggetto richiestas
	*/
	@Override
	public java.util.List<servizio.richieste.badge.mef.model.OggettoRichiesta> getOggettoRichiestas(
		int start, int end) {
		return _oggettoRichiestaLocalService.getOggettoRichiestas(start, end);
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
		return _oggettoRichiestaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _oggettoRichiestaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the oggetto richiesta to the database. Also notifies the appropriate model listeners.
	*
	* @param oggettoRichiesta the oggetto richiesta
	* @return the oggetto richiesta that was added
	*/
	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta addOggettoRichiesta(
		servizio.richieste.badge.mef.model.OggettoRichiesta oggettoRichiesta) {
		return _oggettoRichiestaLocalService.addOggettoRichiesta(oggettoRichiesta);
	}

	/**
	* Creates a new oggetto richiesta with the primary key. Does not add the oggetto richiesta to the database.
	*
	* @param id_oggetto the primary key for the new oggetto richiesta
	* @return the new oggetto richiesta
	*/
	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta createOggettoRichiesta(
		long id_oggetto) {
		return _oggettoRichiestaLocalService.createOggettoRichiesta(id_oggetto);
	}

	/**
	* Deletes the oggetto richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta that was removed
	* @throws PortalException if a oggetto richiesta with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta deleteOggettoRichiesta(
		long id_oggetto)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _oggettoRichiestaLocalService.deleteOggettoRichiesta(id_oggetto);
	}

	/**
	* Deletes the oggetto richiesta from the database. Also notifies the appropriate model listeners.
	*
	* @param oggettoRichiesta the oggetto richiesta
	* @return the oggetto richiesta that was removed
	*/
	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta deleteOggettoRichiesta(
		servizio.richieste.badge.mef.model.OggettoRichiesta oggettoRichiesta) {
		return _oggettoRichiestaLocalService.deleteOggettoRichiesta(oggettoRichiesta);
	}

	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta fetchOggettoRichiesta(
		long id_oggetto) {
		return _oggettoRichiestaLocalService.fetchOggettoRichiesta(id_oggetto);
	}

	/**
	* Returns the oggetto richiesta with the primary key.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta
	* @throws PortalException if a oggetto richiesta with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta getOggettoRichiesta(
		long id_oggetto)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _oggettoRichiestaLocalService.getOggettoRichiesta(id_oggetto);
	}

	/**
	* Updates the oggetto richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oggettoRichiesta the oggetto richiesta
	* @return the oggetto richiesta that was updated
	*/
	@Override
	public servizio.richieste.badge.mef.model.OggettoRichiesta updateOggettoRichiesta(
		servizio.richieste.badge.mef.model.OggettoRichiesta oggettoRichiesta) {
		return _oggettoRichiestaLocalService.updateOggettoRichiesta(oggettoRichiesta);
	}

	@Override
	public OggettoRichiestaLocalService getWrappedService() {
		return _oggettoRichiestaLocalService;
	}

	@Override
	public void setWrappedService(
		OggettoRichiestaLocalService oggettoRichiestaLocalService) {
		_oggettoRichiestaLocalService = oggettoRichiestaLocalService;
	}

	private OggettoRichiestaLocalService _oggettoRichiestaLocalService;
}