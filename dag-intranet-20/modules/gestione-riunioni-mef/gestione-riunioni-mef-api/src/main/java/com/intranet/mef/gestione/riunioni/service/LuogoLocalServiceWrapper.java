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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LuogoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LuogoLocalService
 * @generated
 */
@ProviderType
public class LuogoLocalServiceWrapper implements LuogoLocalService,
	ServiceWrapper<LuogoLocalService> {
	public LuogoLocalServiceWrapper(LuogoLocalService luogoLocalService) {
		_luogoLocalService = luogoLocalService;
	}

	@Override
	public boolean setLuogo(java.lang.String nome) {
		return _luogoLocalService.setLuogo(nome);
	}

	/**
	* Adds the luogo to the database. Also notifies the appropriate model listeners.
	*
	* @param luogo the luogo
	* @return the luogo that was added
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo addLuogo(
		com.intranet.mef.gestione.riunioni.model.Luogo luogo) {
		return _luogoLocalService.addLuogo(luogo);
	}

	/**
	* Creates a new luogo with the primary key. Does not add the luogo to the database.
	*
	* @param id_luogo the primary key for the new luogo
	* @return the new luogo
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo createLuogo(
		long id_luogo) {
		return _luogoLocalService.createLuogo(id_luogo);
	}

	/**
	* Deletes the luogo from the database. Also notifies the appropriate model listeners.
	*
	* @param luogo the luogo
	* @return the luogo that was removed
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo deleteLuogo(
		com.intranet.mef.gestione.riunioni.model.Luogo luogo) {
		return _luogoLocalService.deleteLuogo(luogo);
	}

	/**
	* Deletes the luogo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo that was removed
	* @throws PortalException if a luogo with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo deleteLuogo(
		long id_luogo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _luogoLocalService.deleteLuogo(id_luogo);
	}

	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo fetchLuogo(
		long id_luogo) {
		return _luogoLocalService.fetchLuogo(id_luogo);
	}

	/**
	* Returns the luogo with the primary key.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo
	* @throws PortalException if a luogo with the primary key could not be found
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo getLuogo(
		long id_luogo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _luogoLocalService.getLuogo(id_luogo);
	}

	/**
	* Updates the luogo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param luogo the luogo
	* @return the luogo that was updated
	*/
	@Override
	public com.intranet.mef.gestione.riunioni.model.Luogo updateLuogo(
		com.intranet.mef.gestione.riunioni.model.Luogo luogo) {
		return _luogoLocalService.updateLuogo(luogo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _luogoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _luogoLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _luogoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _luogoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _luogoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of luogos.
	*
	* @return the number of luogos
	*/
	@Override
	public int getLuogosCount() {
		return _luogoLocalService.getLuogosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _luogoLocalService.getOSGiServiceIdentifier();
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
		return _luogoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _luogoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _luogoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.Luogo> findByKeywordLuogo(
		java.lang.String keyword) {
		return _luogoLocalService.findByKeywordLuogo(keyword);
	}

	/**
	* Returns a range of all the luogos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.LuogoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of luogos
	* @param end the upper bound of the range of luogos (not inclusive)
	* @return the range of luogos
	*/
	@Override
	public java.util.List<com.intranet.mef.gestione.riunioni.model.Luogo> getLuogos(
		int start, int end) {
		return _luogoLocalService.getLuogos(start, end);
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
		return _luogoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _luogoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public LuogoLocalService getWrappedService() {
		return _luogoLocalService;
	}

	@Override
	public void setWrappedService(LuogoLocalService luogoLocalService) {
		_luogoLocalService = luogoLocalService;
	}

	private LuogoLocalService _luogoLocalService;
}