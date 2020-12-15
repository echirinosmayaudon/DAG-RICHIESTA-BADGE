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
 * Provides a wrapper for {@link StatoRichiestaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatoRichiestaLocalService
 * @generated
 */
@ProviderType
public class StatoRichiestaLocalServiceWrapper
	implements StatoRichiestaLocalService,
		ServiceWrapper<StatoRichiestaLocalService> {
	public StatoRichiestaLocalServiceWrapper(
		StatoRichiestaLocalService statoRichiestaLocalService) {
		_statoRichiestaLocalService = statoRichiestaLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _statoRichiestaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statoRichiestaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _statoRichiestaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoRichiestaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoRichiestaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of stato richiestas.
	*
	* @return the number of stato richiestas
	*/
	@Override
	public int getStatoRichiestasCount() {
		return _statoRichiestaLocalService.getStatoRichiestasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _statoRichiestaLocalService.getOSGiServiceIdentifier();
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
		return _statoRichiestaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statoRichiestaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statoRichiestaLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<servizio.richieste.badge.mef.model.StatoRichiesta> findStatoByDescrizione(
		java.lang.String descrizione_stato) {
		return _statoRichiestaLocalService.findStatoByDescrizione(descrizione_stato);
	}

	/**
	* Returns a range of all the stato richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.StatoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato richiestas
	* @param end the upper bound of the range of stato richiestas (not inclusive)
	* @return the range of stato richiestas
	*/
	@Override
	public java.util.List<servizio.richieste.badge.mef.model.StatoRichiesta> getStatoRichiestas(
		int start, int end) {
		return _statoRichiestaLocalService.getStatoRichiestas(start, end);
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
		return _statoRichiestaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _statoRichiestaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the stato richiesta to the database. Also notifies the appropriate model listeners.
	*
	* @param statoRichiesta the stato richiesta
	* @return the stato richiesta that was added
	*/
	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta addStatoRichiesta(
		servizio.richieste.badge.mef.model.StatoRichiesta statoRichiesta) {
		return _statoRichiestaLocalService.addStatoRichiesta(statoRichiesta);
	}

	/**
	* Creates a new stato richiesta with the primary key. Does not add the stato richiesta to the database.
	*
	* @param id_stato the primary key for the new stato richiesta
	* @return the new stato richiesta
	*/
	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta createStatoRichiesta(
		long id_stato) {
		return _statoRichiestaLocalService.createStatoRichiesta(id_stato);
	}

	/**
	* Deletes the stato richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato the primary key of the stato richiesta
	* @return the stato richiesta that was removed
	* @throws PortalException if a stato richiesta with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta deleteStatoRichiesta(
		long id_stato)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoRichiestaLocalService.deleteStatoRichiesta(id_stato);
	}

	/**
	* Deletes the stato richiesta from the database. Also notifies the appropriate model listeners.
	*
	* @param statoRichiesta the stato richiesta
	* @return the stato richiesta that was removed
	*/
	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta deleteStatoRichiesta(
		servizio.richieste.badge.mef.model.StatoRichiesta statoRichiesta) {
		return _statoRichiestaLocalService.deleteStatoRichiesta(statoRichiesta);
	}

	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta fetchStatoRichiesta(
		long id_stato) {
		return _statoRichiestaLocalService.fetchStatoRichiesta(id_stato);
	}

	/**
	* Returns the stato richiesta with the primary key.
	*
	* @param id_stato the primary key of the stato richiesta
	* @return the stato richiesta
	* @throws PortalException if a stato richiesta with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta getStatoRichiesta(
		long id_stato)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoRichiestaLocalService.getStatoRichiesta(id_stato);
	}

	/**
	* Updates the stato richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statoRichiesta the stato richiesta
	* @return the stato richiesta that was updated
	*/
	@Override
	public servizio.richieste.badge.mef.model.StatoRichiesta updateStatoRichiesta(
		servizio.richieste.badge.mef.model.StatoRichiesta statoRichiesta) {
		return _statoRichiestaLocalService.updateStatoRichiesta(statoRichiesta);
	}

	@Override
	public StatoRichiestaLocalService getWrappedService() {
		return _statoRichiestaLocalService;
	}

	@Override
	public void setWrappedService(
		StatoRichiestaLocalService statoRichiestaLocalService) {
		_statoRichiestaLocalService = statoRichiestaLocalService;
	}

	private StatoRichiestaLocalService _statoRichiestaLocalService;
}