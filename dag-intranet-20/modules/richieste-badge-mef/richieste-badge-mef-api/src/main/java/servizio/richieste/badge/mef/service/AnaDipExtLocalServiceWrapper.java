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
 * Provides a wrapper for {@link AnaDipExtLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExtLocalService
 * @generated
 */
@ProviderType
public class AnaDipExtLocalServiceWrapper implements AnaDipExtLocalService,
	ServiceWrapper<AnaDipExtLocalService> {
	public AnaDipExtLocalServiceWrapper(
		AnaDipExtLocalService anaDipExtLocalService) {
		_anaDipExtLocalService = anaDipExtLocalService;
	}

	@Override
	public boolean insertAnaDipExt(java.lang.String nome_dip_ext,
		java.lang.String cognome_dip_ext, java.lang.String cf_dip_ext,
		java.lang.String luogonascita_dip_ext,
		java.util.Date datanascita_dip_ext) {
		return _anaDipExtLocalService.insertAnaDipExt(nome_dip_ext,
			cognome_dip_ext, cf_dip_ext, luogonascita_dip_ext,
			datanascita_dip_ext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _anaDipExtLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _anaDipExtLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _anaDipExtLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray findSuggestionsAnaDipExtBySurname(
		java.lang.String cognome) {
		return _anaDipExtLocalService.findSuggestionsAnaDipExtBySurname(cognome);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anaDipExtLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anaDipExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of ana dip exts.
	*
	* @return the number of ana dip exts
	*/
	@Override
	public int getAnaDipExtsCount() {
		return _anaDipExtLocalService.getAnaDipExtsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _anaDipExtLocalService.getOSGiServiceIdentifier();
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
		return _anaDipExtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _anaDipExtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _anaDipExtLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<servizio.richieste.badge.mef.model.AnaDipExt> findUtentiByCodiceFiscaleEsterno(
		java.lang.String cf_dip_ext) {
		return _anaDipExtLocalService.findUtentiByCodiceFiscaleEsterno(cf_dip_ext);
	}

	/**
	* Returns a range of all the ana dip exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ana dip exts
	* @param end the upper bound of the range of ana dip exts (not inclusive)
	* @return the range of ana dip exts
	*/
	@Override
	public java.util.List<servizio.richieste.badge.mef.model.AnaDipExt> getAnaDipExts(
		int start, int end) {
		return _anaDipExtLocalService.getAnaDipExts(start, end);
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
		return _anaDipExtLocalService.dynamicQueryCount(dynamicQuery);
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
		return _anaDipExtLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the ana dip ext to the database. Also notifies the appropriate model listeners.
	*
	* @param anaDipExt the ana dip ext
	* @return the ana dip ext that was added
	*/
	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt addAnaDipExt(
		servizio.richieste.badge.mef.model.AnaDipExt anaDipExt) {
		return _anaDipExtLocalService.addAnaDipExt(anaDipExt);
	}

	/**
	* Creates a new ana dip ext with the primary key. Does not add the ana dip ext to the database.
	*
	* @param id_dip_ext the primary key for the new ana dip ext
	* @return the new ana dip ext
	*/
	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt createAnaDipExt(
		long id_dip_ext) {
		return _anaDipExtLocalService.createAnaDipExt(id_dip_ext);
	}

	/**
	* Deletes the ana dip ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_dip_ext the primary key of the ana dip ext
	* @return the ana dip ext that was removed
	* @throws PortalException if a ana dip ext with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt deleteAnaDipExt(
		long id_dip_ext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anaDipExtLocalService.deleteAnaDipExt(id_dip_ext);
	}

	/**
	* Deletes the ana dip ext from the database. Also notifies the appropriate model listeners.
	*
	* @param anaDipExt the ana dip ext
	* @return the ana dip ext that was removed
	*/
	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt deleteAnaDipExt(
		servizio.richieste.badge.mef.model.AnaDipExt anaDipExt) {
		return _anaDipExtLocalService.deleteAnaDipExt(anaDipExt);
	}

	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt fetchAnaDipExt(
		long id_dip_ext) {
		return _anaDipExtLocalService.fetchAnaDipExt(id_dip_ext);
	}

	/**
	* Returns the ana dip ext with the primary key.
	*
	* @param id_dip_ext the primary key of the ana dip ext
	* @return the ana dip ext
	* @throws PortalException if a ana dip ext with the primary key could not be found
	*/
	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt getAnaDipExt(
		long id_dip_ext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _anaDipExtLocalService.getAnaDipExt(id_dip_ext);
	}

	/**
	* Updates the ana dip ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param anaDipExt the ana dip ext
	* @return the ana dip ext that was updated
	*/
	@Override
	public servizio.richieste.badge.mef.model.AnaDipExt updateAnaDipExt(
		servizio.richieste.badge.mef.model.AnaDipExt anaDipExt) {
		return _anaDipExtLocalService.updateAnaDipExt(anaDipExt);
	}

	@Override
	public AnaDipExtLocalService getWrappedService() {
		return _anaDipExtLocalService;
	}

	@Override
	public void setWrappedService(AnaDipExtLocalService anaDipExtLocalService) {
		_anaDipExtLocalService = anaDipExtLocalService;
	}

	private AnaDipExtLocalService _anaDipExtLocalService;
}