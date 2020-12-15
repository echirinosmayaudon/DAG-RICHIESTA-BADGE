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
 * Provides a wrapper for {@link OrarioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OrarioLocalService
 * @generated
 */
@ProviderType
public class OrarioLocalServiceWrapper implements OrarioLocalService,
	ServiceWrapper<OrarioLocalService> {
	public OrarioLocalServiceWrapper(OrarioLocalService orarioLocalService) {
		_orarioLocalService = orarioLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _orarioLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orarioLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _orarioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _orarioLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _orarioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of orarios.
	*
	* @return the number of orarios
	*/
	@Override
	public int getOrariosCount() {
		return _orarioLocalService.getOrariosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _orarioLocalService.getOSGiServiceIdentifier();
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
		return _orarioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orarioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orarioLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Orario> findByIdOreListOre(
		java.lang.Long idOraInizio, java.lang.Long idOraFine) {
		return _orarioLocalService.findByIdOreListOre(idOraInizio, idOraFine);
	}

	/**
	* Returns a range of all the orarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orarios
	* @param end the upper bound of the range of orarios (not inclusive)
	* @return the range of orarios
	*/
	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.Orario> getOrarios(
		int start, int end) {
		return _orarioLocalService.getOrarios(start, end);
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
		return _orarioLocalService.dynamicQueryCount(dynamicQuery);
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
		return _orarioLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the orario to the database. Also notifies the appropriate model listeners.
	*
	* @param orario the orario
	* @return the orario that was added
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Orario addOrario(
		servizio.prenotazione.aule.mef.model.Orario orario) {
		return _orarioLocalService.addOrario(orario);
	}

	/**
	* Creates a new orario with the primary key. Does not add the orario to the database.
	*
	* @param id_ora the primary key for the new orario
	* @return the new orario
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Orario createOrario(long id_ora) {
		return _orarioLocalService.createOrario(id_ora);
	}

	/**
	* Deletes the orario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ora the primary key of the orario
	* @return the orario that was removed
	* @throws PortalException if a orario with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Orario deleteOrario(long id_ora)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _orarioLocalService.deleteOrario(id_ora);
	}

	/**
	* Deletes the orario from the database. Also notifies the appropriate model listeners.
	*
	* @param orario the orario
	* @return the orario that was removed
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Orario deleteOrario(
		servizio.prenotazione.aule.mef.model.Orario orario) {
		return _orarioLocalService.deleteOrario(orario);
	}

	@Override
	public servizio.prenotazione.aule.mef.model.Orario fetchOrario(long id_ora) {
		return _orarioLocalService.fetchOrario(id_ora);
	}

	/**
	* Returns the orario with the primary key.
	*
	* @param id_ora the primary key of the orario
	* @return the orario
	* @throws PortalException if a orario with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Orario getOrario(long id_ora)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _orarioLocalService.getOrario(id_ora);
	}

	/**
	* Updates the orario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orario the orario
	* @return the orario that was updated
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.Orario updateOrario(
		servizio.prenotazione.aule.mef.model.Orario orario) {
		return _orarioLocalService.updateOrario(orario);
	}

	@Override
	public OrarioLocalService getWrappedService() {
		return _orarioLocalService;
	}

	@Override
	public void setWrappedService(OrarioLocalService orarioLocalService) {
		_orarioLocalService = orarioLocalService;
	}

	private OrarioLocalService _orarioLocalService;
}