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

package autorizzazione.dir.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AutorizzazioneDirLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AutorizzazioneDirLocalService
 * @generated
 */
@ProviderType
public class AutorizzazioneDirLocalServiceWrapper
	implements AutorizzazioneDirLocalService,
		ServiceWrapper<AutorizzazioneDirLocalService> {
	public AutorizzazioneDirLocalServiceWrapper(
		AutorizzazioneDirLocalService autorizzazioneDirLocalService) {
		_autorizzazioneDirLocalService = autorizzazioneDirLocalService;
	}

	/**
	* Adds the autorizzazione dir to the database. Also notifies the appropriate model listeners.
	*
	* @param autorizzazioneDir the autorizzazione dir
	* @return the autorizzazione dir that was added
	*/
	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir addAutorizzazioneDir(
		autorizzazione.dir.mef.model.AutorizzazioneDir autorizzazioneDir) {
		return _autorizzazioneDirLocalService.addAutorizzazioneDir(autorizzazioneDir);
	}

	/**
	* Creates a new autorizzazione dir with the primary key. Does not add the autorizzazione dir to the database.
	*
	* @param id_autorizzazione the primary key for the new autorizzazione dir
	* @return the new autorizzazione dir
	*/
	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir createAutorizzazioneDir(
		long id_autorizzazione) {
		return _autorizzazioneDirLocalService.createAutorizzazioneDir(id_autorizzazione);
	}

	/**
	* Deletes the autorizzazione dir from the database. Also notifies the appropriate model listeners.
	*
	* @param autorizzazioneDir the autorizzazione dir
	* @return the autorizzazione dir that was removed
	*/
	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir deleteAutorizzazioneDir(
		autorizzazione.dir.mef.model.AutorizzazioneDir autorizzazioneDir) {
		return _autorizzazioneDirLocalService.deleteAutorizzazioneDir(autorizzazioneDir);
	}

	/**
	* Deletes the autorizzazione dir with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir that was removed
	* @throws PortalException if a autorizzazione dir with the primary key could not be found
	*/
	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir deleteAutorizzazioneDir(
		long id_autorizzazione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _autorizzazioneDirLocalService.deleteAutorizzazioneDir(id_autorizzazione);
	}

	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir fetchAutorizzazioneDir(
		long id_autorizzazione) {
		return _autorizzazioneDirLocalService.fetchAutorizzazioneDir(id_autorizzazione);
	}

	/**
	* Returns the autorizzazione dir with the primary key.
	*
	* @param id_autorizzazione the primary key of the autorizzazione dir
	* @return the autorizzazione dir
	* @throws PortalException if a autorizzazione dir with the primary key could not be found
	*/
	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir getAutorizzazioneDir(
		long id_autorizzazione)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _autorizzazioneDirLocalService.getAutorizzazioneDir(id_autorizzazione);
	}

	/**
	* Updates the autorizzazione dir in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param autorizzazioneDir the autorizzazione dir
	* @return the autorizzazione dir that was updated
	*/
	@Override
	public autorizzazione.dir.mef.model.AutorizzazioneDir updateAutorizzazioneDir(
		autorizzazione.dir.mef.model.AutorizzazioneDir autorizzazioneDir) {
		return _autorizzazioneDirLocalService.updateAutorizzazioneDir(autorizzazioneDir);
	}

	@Override
	public boolean isAuthorized(long idApplicazione, long mef,
		long dipartimento, long direzione, long ufficio,
		java.lang.String codiceFiscale) {
		return _autorizzazioneDirLocalService.isAuthorized(idApplicazione, mef,
			dipartimento, direzione, ufficio, codiceFiscale);
	}

	@Override
	public boolean isNewsVisible(long mef, long direzione, long dipartimento,
		long ufficio, java.lang.String codiceFiscale, java.lang.String tag) {
		return _autorizzazioneDirLocalService.isNewsVisible(mef, direzione,
			dipartimento, ufficio, codiceFiscale, tag);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _autorizzazioneDirLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _autorizzazioneDirLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _autorizzazioneDirLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _autorizzazioneDirLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _autorizzazioneDirLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of autorizzazione dirs.
	*
	* @return the number of autorizzazione dirs
	*/
	@Override
	public int getAutorizzazioneDirsCount() {
		return _autorizzazioneDirLocalService.getAutorizzazioneDirsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _autorizzazioneDirLocalService.getOSGiServiceIdentifier();
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
		return _autorizzazioneDirLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _autorizzazioneDirLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _autorizzazioneDirLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the autorizzazione dirs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.AutorizzazioneDirModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of autorizzazione dirs
	* @param end the upper bound of the range of autorizzazione dirs (not inclusive)
	* @return the range of autorizzazione dirs
	*/
	@Override
	public java.util.List<autorizzazione.dir.mef.model.AutorizzazioneDir> getAutorizzazioneDirs(
		int start, int end) {
		return _autorizzazioneDirLocalService.getAutorizzazioneDirs(start, end);
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
		return _autorizzazioneDirLocalService.dynamicQueryCount(dynamicQuery);
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
		return _autorizzazioneDirLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public AutorizzazioneDirLocalService getWrappedService() {
		return _autorizzazioneDirLocalService;
	}

	@Override
	public void setWrappedService(
		AutorizzazioneDirLocalService autorizzazioneDirLocalService) {
		_autorizzazioneDirLocalService = autorizzazioneDirLocalService;
	}

	private AutorizzazioneDirLocalService _autorizzazioneDirLocalService;
}