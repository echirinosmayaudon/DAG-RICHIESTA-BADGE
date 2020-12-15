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
 * Provides a wrapper for {@link StatoAulaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StatoAulaLocalService
 * @generated
 */
@ProviderType
public class StatoAulaLocalServiceWrapper implements StatoAulaLocalService,
	ServiceWrapper<StatoAulaLocalService> {
	public StatoAulaLocalServiceWrapper(
		StatoAulaLocalService statoAulaLocalService) {
		_statoAulaLocalService = statoAulaLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _statoAulaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _statoAulaLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _statoAulaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoAulaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoAulaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of stato aulas.
	*
	* @return the number of stato aulas
	*/
	@Override
	public int getStatoAulasCount() {
		return _statoAulaLocalService.getStatoAulasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _statoAulaLocalService.getOSGiServiceIdentifier();
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
		return _statoAulaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statoAulaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _statoAulaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the stato aulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of stato aulas
	* @param end the upper bound of the range of stato aulas (not inclusive)
	* @return the range of stato aulas
	*/
	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StatoAula> getStatoAulas(
		int start, int end) {
		return _statoAulaLocalService.getStatoAulas(start, end);
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
		return _statoAulaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _statoAulaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the stato aula to the database. Also notifies the appropriate model listeners.
	*
	* @param statoAula the stato aula
	* @return the stato aula that was added
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula addStatoAula(
		servizio.prenotazione.aule.mef.model.StatoAula statoAula) {
		return _statoAulaLocalService.addStatoAula(statoAula);
	}

	/**
	* Creates a new stato aula with the primary key. Does not add the stato aula to the database.
	*
	* @param id_stato_aula the primary key for the new stato aula
	* @return the new stato aula
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula createStatoAula(
		long id_stato_aula) {
		return _statoAulaLocalService.createStatoAula(id_stato_aula);
	}

	/**
	* Deletes the stato aula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula that was removed
	* @throws PortalException if a stato aula with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula deleteStatoAula(
		long id_stato_aula)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoAulaLocalService.deleteStatoAula(id_stato_aula);
	}

	/**
	* Deletes the stato aula from the database. Also notifies the appropriate model listeners.
	*
	* @param statoAula the stato aula
	* @return the stato aula that was removed
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula deleteStatoAula(
		servizio.prenotazione.aule.mef.model.StatoAula statoAula) {
		return _statoAulaLocalService.deleteStatoAula(statoAula);
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula fetchStatoAula(
		long id_stato_aula) {
		return _statoAulaLocalService.fetchStatoAula(id_stato_aula);
	}

	/**
	* Returns the stato aula with the primary key.
	*
	* @param id_stato_aula the primary key of the stato aula
	* @return the stato aula
	* @throws PortalException if a stato aula with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula getStatoAula(
		long id_stato_aula)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _statoAulaLocalService.getStatoAula(id_stato_aula);
	}

	/**
	* Updates the stato aula in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statoAula the stato aula
	* @return the stato aula that was updated
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula updateStatoAula(
		servizio.prenotazione.aule.mef.model.StatoAula statoAula) {
		return _statoAulaLocalService.updateStatoAula(statoAula);
	}

	@Override
	public StatoAulaLocalService getWrappedService() {
		return _statoAulaLocalService;
	}

	@Override
	public void setWrappedService(StatoAulaLocalService statoAulaLocalService) {
		_statoAulaLocalService = statoAulaLocalService;
	}

	private StatoAulaLocalService _statoAulaLocalService;
}