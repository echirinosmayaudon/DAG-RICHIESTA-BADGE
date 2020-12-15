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

package servizio.whistleblowing.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SegnalazioneLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SegnalazioneLocalService
 * @generated
 */
@ProviderType
public class SegnalazioneLocalServiceWrapper implements SegnalazioneLocalService,
	ServiceWrapper<SegnalazioneLocalService> {
	public SegnalazioneLocalServiceWrapper(
		SegnalazioneLocalService segnalazioneLocalService) {
		_segnalazioneLocalService = segnalazioneLocalService;
	}

	@Override
	public boolean insertSegnalazione(java.lang.String json_dati_personali,
		java.lang.String luogo, java.lang.String azioni_omissioni,
		java.lang.String descrizione, java.lang.String autore,
		java.lang.String altri_testimoni) {
		return _segnalazioneLocalService.insertSegnalazione(json_dati_personali,
			luogo, azioni_omissioni, descrizione, autore, altri_testimoni);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _segnalazioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _segnalazioneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _segnalazioneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segnalazioneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segnalazioneLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of segnalaziones.
	*
	* @return the number of segnalaziones
	*/
	@Override
	public int getSegnalazionesCount() {
		return _segnalazioneLocalService.getSegnalazionesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _segnalazioneLocalService.getOSGiServiceIdentifier();
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
		return _segnalazioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _segnalazioneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _segnalazioneLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the segnalaziones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.whistleblowing.mef.model.impl.SegnalazioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of segnalaziones
	* @param end the upper bound of the range of segnalaziones (not inclusive)
	* @return the range of segnalaziones
	*/
	@Override
	public java.util.List<servizio.whistleblowing.mef.model.Segnalazione> getSegnalaziones(
		int start, int end) {
		return _segnalazioneLocalService.getSegnalaziones(start, end);
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
		return _segnalazioneLocalService.dynamicQueryCount(dynamicQuery);
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
		return _segnalazioneLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the segnalazione to the database. Also notifies the appropriate model listeners.
	*
	* @param segnalazione the segnalazione
	* @return the segnalazione that was added
	*/
	@Override
	public servizio.whistleblowing.mef.model.Segnalazione addSegnalazione(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return _segnalazioneLocalService.addSegnalazione(segnalazione);
	}

	/**
	* Creates a new segnalazione with the primary key. Does not add the segnalazione to the database.
	*
	* @param id_segnalazione the primary key for the new segnalazione
	* @return the new segnalazione
	*/
	@Override
	public servizio.whistleblowing.mef.model.Segnalazione createSegnalazione(
		long id_segnalazione) {
		return _segnalazioneLocalService.createSegnalazione(id_segnalazione);
	}

	/**
	* Deletes the segnalazione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_segnalazione the primary key of the segnalazione
	* @return the segnalazione that was removed
	* @throws PortalException if a segnalazione with the primary key could not be found
	*/
	@Override
	public servizio.whistleblowing.mef.model.Segnalazione deleteSegnalazione(
		long id_segnalazione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segnalazioneLocalService.deleteSegnalazione(id_segnalazione);
	}

	/**
	* Deletes the segnalazione from the database. Also notifies the appropriate model listeners.
	*
	* @param segnalazione the segnalazione
	* @return the segnalazione that was removed
	*/
	@Override
	public servizio.whistleblowing.mef.model.Segnalazione deleteSegnalazione(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return _segnalazioneLocalService.deleteSegnalazione(segnalazione);
	}

	@Override
	public servizio.whistleblowing.mef.model.Segnalazione fetchSegnalazione(
		long id_segnalazione) {
		return _segnalazioneLocalService.fetchSegnalazione(id_segnalazione);
	}

	/**
	* Returns the segnalazione with the primary key.
	*
	* @param id_segnalazione the primary key of the segnalazione
	* @return the segnalazione
	* @throws PortalException if a segnalazione with the primary key could not be found
	*/
	@Override
	public servizio.whistleblowing.mef.model.Segnalazione getSegnalazione(
		long id_segnalazione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _segnalazioneLocalService.getSegnalazione(id_segnalazione);
	}

	/**
	* Updates the segnalazione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param segnalazione the segnalazione
	* @return the segnalazione that was updated
	*/
	@Override
	public servizio.whistleblowing.mef.model.Segnalazione updateSegnalazione(
		servizio.whistleblowing.mef.model.Segnalazione segnalazione) {
		return _segnalazioneLocalService.updateSegnalazione(segnalazione);
	}

	@Override
	public SegnalazioneLocalService getWrappedService() {
		return _segnalazioneLocalService;
	}

	@Override
	public void setWrappedService(
		SegnalazioneLocalService segnalazioneLocalService) {
		_segnalazioneLocalService = segnalazioneLocalService;
	}

	private SegnalazioneLocalService _segnalazioneLocalService;
}