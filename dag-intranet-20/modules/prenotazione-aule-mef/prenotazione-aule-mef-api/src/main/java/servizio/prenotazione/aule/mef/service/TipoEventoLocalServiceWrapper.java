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
 * Provides a wrapper for {@link TipoEventoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipoEventoLocalService
 * @generated
 */
@ProviderType
public class TipoEventoLocalServiceWrapper implements TipoEventoLocalService,
	ServiceWrapper<TipoEventoLocalService> {
	public TipoEventoLocalServiceWrapper(
		TipoEventoLocalService tipoEventoLocalService) {
		_tipoEventoLocalService = tipoEventoLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tipoEventoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipoEventoLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tipoEventoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoEventoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoEventoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of tipo eventos.
	*
	* @return the number of tipo eventos
	*/
	@Override
	public int getTipoEventosCount() {
		return _tipoEventoLocalService.getTipoEventosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipoEventoLocalService.getOSGiServiceIdentifier();
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
		return _tipoEventoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipoEventoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipoEventoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the tipo eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.TipoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipo eventos
	* @param end the upper bound of the range of tipo eventos (not inclusive)
	* @return the range of tipo eventos
	*/
	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.TipoEvento> getTipoEventos(
		int start, int end) {
		return _tipoEventoLocalService.getTipoEventos(start, end);
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
		return _tipoEventoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipoEventoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the tipo evento to the database. Also notifies the appropriate model listeners.
	*
	* @param tipoEvento the tipo evento
	* @return the tipo evento that was added
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento addTipoEvento(
		servizio.prenotazione.aule.mef.model.TipoEvento tipoEvento) {
		return _tipoEventoLocalService.addTipoEvento(tipoEvento);
	}

	/**
	* Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	*
	* @param id_evento the primary key for the new tipo evento
	* @return the new tipo evento
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento createTipoEvento(
		long id_evento) {
		return _tipoEventoLocalService.createTipoEvento(id_evento);
	}

	/**
	* Deletes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento that was removed
	* @throws PortalException if a tipo evento with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento deleteTipoEvento(
		long id_evento)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoEventoLocalService.deleteTipoEvento(id_evento);
	}

	/**
	* Deletes the tipo evento from the database. Also notifies the appropriate model listeners.
	*
	* @param tipoEvento the tipo evento
	* @return the tipo evento that was removed
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento deleteTipoEvento(
		servizio.prenotazione.aule.mef.model.TipoEvento tipoEvento) {
		return _tipoEventoLocalService.deleteTipoEvento(tipoEvento);
	}

	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento fetchTipoEvento(
		long id_evento) {
		return _tipoEventoLocalService.fetchTipoEvento(id_evento);
	}

	/**
	* Returns the tipo evento with the primary key.
	*
	* @param id_evento the primary key of the tipo evento
	* @return the tipo evento
	* @throws PortalException if a tipo evento with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento getTipoEvento(
		long id_evento)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipoEventoLocalService.getTipoEvento(id_evento);
	}

	/**
	* Updates the tipo evento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipoEvento the tipo evento
	* @return the tipo evento that was updated
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.TipoEvento updateTipoEvento(
		servizio.prenotazione.aule.mef.model.TipoEvento tipoEvento) {
		return _tipoEventoLocalService.updateTipoEvento(tipoEvento);
	}

	@Override
	public TipoEventoLocalService getWrappedService() {
		return _tipoEventoLocalService;
	}

	@Override
	public void setWrappedService(TipoEventoLocalService tipoEventoLocalService) {
		_tipoEventoLocalService = tipoEventoLocalService;
	}

	private TipoEventoLocalService _tipoEventoLocalService;
}