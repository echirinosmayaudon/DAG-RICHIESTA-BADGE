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
 * Provides a wrapper for {@link StrumentoEventoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoEventoLocalService
 * @generated
 */
@ProviderType
public class StrumentoEventoLocalServiceWrapper
	implements StrumentoEventoLocalService,
		ServiceWrapper<StrumentoEventoLocalService> {
	public StrumentoEventoLocalServiceWrapper(
		StrumentoEventoLocalService strumentoEventoLocalService) {
		_strumentoEventoLocalService = strumentoEventoLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _strumentoEventoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _strumentoEventoLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _strumentoEventoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoEventoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoEventoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of strumento eventos.
	*
	* @return the number of strumento eventos
	*/
	@Override
	public int getStrumentoEventosCount() {
		return _strumentoEventoLocalService.getStrumentoEventosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _strumentoEventoLocalService.getOSGiServiceIdentifier();
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
		return _strumentoEventoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _strumentoEventoLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _strumentoEventoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StrumentoEvento> getStrumentoEventoListByDescStrumento(
		java.lang.String desc_strumento) {
		return _strumentoEventoLocalService.getStrumentoEventoListByDescStrumento(desc_strumento);
	}

	/**
	* Returns a range of all the strumento eventos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StrumentoEventoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento eventos
	* @param end the upper bound of the range of strumento eventos (not inclusive)
	* @return the range of strumento eventos
	*/
	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StrumentoEvento> getStrumentoEventos(
		int start, int end) {
		return _strumentoEventoLocalService.getStrumentoEventos(start, end);
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
		return _strumentoEventoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _strumentoEventoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the strumento evento to the database. Also notifies the appropriate model listeners.
	*
	* @param strumentoEvento the strumento evento
	* @return the strumento evento that was added
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento addStrumentoEvento(
		servizio.prenotazione.aule.mef.model.StrumentoEvento strumentoEvento) {
		return _strumentoEventoLocalService.addStrumentoEvento(strumentoEvento);
	}

	/**
	* Creates a new strumento evento with the primary key. Does not add the strumento evento to the database.
	*
	* @param id_strumento the primary key for the new strumento evento
	* @return the new strumento evento
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento createStrumentoEvento(
		long id_strumento) {
		return _strumentoEventoLocalService.createStrumentoEvento(id_strumento);
	}

	/**
	* Deletes the strumento evento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento that was removed
	* @throws PortalException if a strumento evento with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento deleteStrumentoEvento(
		long id_strumento)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoEventoLocalService.deleteStrumentoEvento(id_strumento);
	}

	/**
	* Deletes the strumento evento from the database. Also notifies the appropriate model listeners.
	*
	* @param strumentoEvento the strumento evento
	* @return the strumento evento that was removed
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento deleteStrumentoEvento(
		servizio.prenotazione.aule.mef.model.StrumentoEvento strumentoEvento) {
		return _strumentoEventoLocalService.deleteStrumentoEvento(strumentoEvento);
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento fetchStrumentoEvento(
		long id_strumento) {
		return _strumentoEventoLocalService.fetchStrumentoEvento(id_strumento);
	}

	/**
	* Returns the strumento evento with the primary key.
	*
	* @param id_strumento the primary key of the strumento evento
	* @return the strumento evento
	* @throws PortalException if a strumento evento with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento getStrumentoEvento(
		long id_strumento)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoEventoLocalService.getStrumentoEvento(id_strumento);
	}

	/**
	* Updates the strumento evento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param strumentoEvento the strumento evento
	* @return the strumento evento that was updated
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoEvento updateStrumentoEvento(
		servizio.prenotazione.aule.mef.model.StrumentoEvento strumentoEvento) {
		return _strumentoEventoLocalService.updateStrumentoEvento(strumentoEvento);
	}

	@Override
	public StrumentoEventoLocalService getWrappedService() {
		return _strumentoEventoLocalService;
	}

	@Override
	public void setWrappedService(
		StrumentoEventoLocalService strumentoEventoLocalService) {
		_strumentoEventoLocalService = strumentoEventoLocalService;
	}

	private StrumentoEventoLocalService _strumentoEventoLocalService;
}