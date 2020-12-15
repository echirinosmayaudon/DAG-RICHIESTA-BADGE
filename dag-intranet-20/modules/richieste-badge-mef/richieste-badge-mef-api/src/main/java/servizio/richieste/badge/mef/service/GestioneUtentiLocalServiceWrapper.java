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
 * Provides a wrapper for {@link GestioneUtentiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GestioneUtentiLocalService
 * @generated
 */
@ProviderType
public class GestioneUtentiLocalServiceWrapper
	implements GestioneUtentiLocalService,
		ServiceWrapper<GestioneUtentiLocalService> {
	public GestioneUtentiLocalServiceWrapper(
		GestioneUtentiLocalService gestioneUtentiLocalService) {
		_gestioneUtentiLocalService = gestioneUtentiLocalService;
	}

	@Override
	public boolean insertGestioneUtenti(java.util.Date data,
		java.lang.String screename_dirigente,
		java.lang.String screename_utente, long id_ufficio,
		java.lang.String btnAction,
		com.liferay.portal.kernel.model.User utente, long companyId) {
		return _gestioneUtentiLocalService.insertGestioneUtenti(data,
			screename_dirigente, screename_utente, id_ufficio, btnAction,
			utente, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _gestioneUtentiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gestioneUtentiLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _gestioneUtentiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _gestioneUtentiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _gestioneUtentiLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of gestione utentis.
	*
	* @return the number of gestione utentis
	*/
	@Override
	public int getGestioneUtentisCount() {
		return _gestioneUtentiLocalService.getGestioneUtentisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _gestioneUtentiLocalService.getOSGiServiceIdentifier();
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
		return _gestioneUtentiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gestioneUtentiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gestioneUtentiLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the gestione utentis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.GestioneUtentiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gestione utentis
	* @param end the upper bound of the range of gestione utentis (not inclusive)
	* @return the range of gestione utentis
	*/
	@Override
	public java.util.List<servizio.richieste.badge.mef.model.GestioneUtenti> getGestioneUtentis(
		int start, int end) {
		return _gestioneUtentiLocalService.getGestioneUtentis(start, end);
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
		return _gestioneUtentiLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gestioneUtentiLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the gestione utenti to the database. Also notifies the appropriate model listeners.
	*
	* @param gestioneUtenti the gestione utenti
	* @return the gestione utenti that was added
	*/
	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti addGestioneUtenti(
		servizio.richieste.badge.mef.model.GestioneUtenti gestioneUtenti) {
		return _gestioneUtentiLocalService.addGestioneUtenti(gestioneUtenti);
	}

	/**
	* Creates a new gestione utenti with the primary key. Does not add the gestione utenti to the database.
	*
	* @param id_gest_utenti the primary key for the new gestione utenti
	* @return the new gestione utenti
	*/
	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti createGestioneUtenti(
		long id_gest_utenti) {
		return _gestioneUtentiLocalService.createGestioneUtenti(id_gest_utenti);
	}

	/**
	* Deletes the gestione utenti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_gest_utenti the primary key of the gestione utenti
	* @return the gestione utenti that was removed
	* @throws PortalException if a gestione utenti with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti deleteGestioneUtenti(
		long id_gest_utenti)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _gestioneUtentiLocalService.deleteGestioneUtenti(id_gest_utenti);
	}

	/**
	* Deletes the gestione utenti from the database. Also notifies the appropriate model listeners.
	*
	* @param gestioneUtenti the gestione utenti
	* @return the gestione utenti that was removed
	*/
	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti deleteGestioneUtenti(
		servizio.richieste.badge.mef.model.GestioneUtenti gestioneUtenti) {
		return _gestioneUtentiLocalService.deleteGestioneUtenti(gestioneUtenti);
	}

	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti fetchGestioneUtenti(
		long id_gest_utenti) {
		return _gestioneUtentiLocalService.fetchGestioneUtenti(id_gest_utenti);
	}

	/**
	* Returns the gestione utenti with the primary key.
	*
	* @param id_gest_utenti the primary key of the gestione utenti
	* @return the gestione utenti
	* @throws PortalException if a gestione utenti with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti getGestioneUtenti(
		long id_gest_utenti)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _gestioneUtentiLocalService.getGestioneUtenti(id_gest_utenti);
	}

	/**
	* Updates the gestione utenti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gestioneUtenti the gestione utenti
	* @return the gestione utenti that was updated
	*/
	@Override
	public servizio.richieste.badge.mef.model.GestioneUtenti updateGestioneUtenti(
		servizio.richieste.badge.mef.model.GestioneUtenti gestioneUtenti) {
		return _gestioneUtentiLocalService.updateGestioneUtenti(gestioneUtenti);
	}

	@Override
	public GestioneUtentiLocalService getWrappedService() {
		return _gestioneUtentiLocalService;
	}

	@Override
	public void setWrappedService(
		GestioneUtentiLocalService gestioneUtentiLocalService) {
		_gestioneUtentiLocalService = gestioneUtentiLocalService;
	}

	private GestioneUtentiLocalService _gestioneUtentiLocalService;
}