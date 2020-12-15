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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Luogo. This utility wraps
 * {@link com.intranet.mef.gestione.riunioni.service.impl.LuogoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LuogoLocalService
 * @see com.intranet.mef.gestione.riunioni.service.base.LuogoLocalServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.LuogoLocalServiceImpl
 * @generated
 */
@ProviderType
public class LuogoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.LuogoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean setLuogo(java.lang.String nome) {
		return getService().setLuogo(nome);
	}

	/**
	* Adds the luogo to the database. Also notifies the appropriate model listeners.
	*
	* @param luogo the luogo
	* @return the luogo that was added
	*/
	public static com.intranet.mef.gestione.riunioni.model.Luogo addLuogo(
		com.intranet.mef.gestione.riunioni.model.Luogo luogo) {
		return getService().addLuogo(luogo);
	}

	/**
	* Creates a new luogo with the primary key. Does not add the luogo to the database.
	*
	* @param id_luogo the primary key for the new luogo
	* @return the new luogo
	*/
	public static com.intranet.mef.gestione.riunioni.model.Luogo createLuogo(
		long id_luogo) {
		return getService().createLuogo(id_luogo);
	}

	/**
	* Deletes the luogo from the database. Also notifies the appropriate model listeners.
	*
	* @param luogo the luogo
	* @return the luogo that was removed
	*/
	public static com.intranet.mef.gestione.riunioni.model.Luogo deleteLuogo(
		com.intranet.mef.gestione.riunioni.model.Luogo luogo) {
		return getService().deleteLuogo(luogo);
	}

	/**
	* Deletes the luogo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo that was removed
	* @throws PortalException if a luogo with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.Luogo deleteLuogo(
		long id_luogo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLuogo(id_luogo);
	}

	public static com.intranet.mef.gestione.riunioni.model.Luogo fetchLuogo(
		long id_luogo) {
		return getService().fetchLuogo(id_luogo);
	}

	/**
	* Returns the luogo with the primary key.
	*
	* @param id_luogo the primary key of the luogo
	* @return the luogo
	* @throws PortalException if a luogo with the primary key could not be found
	*/
	public static com.intranet.mef.gestione.riunioni.model.Luogo getLuogo(
		long id_luogo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLuogo(id_luogo);
	}

	/**
	* Updates the luogo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param luogo the luogo
	* @return the luogo that was updated
	*/
	public static com.intranet.mef.gestione.riunioni.model.Luogo updateLuogo(
		com.intranet.mef.gestione.riunioni.model.Luogo luogo) {
		return getService().updateLuogo(luogo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of luogos.
	*
	* @return the number of luogos
	*/
	public static int getLuogosCount() {
		return getService().getLuogosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.intranet.mef.gestione.riunioni.model.Luogo> findByKeywordLuogo(
		java.lang.String keyword) {
		return getService().findByKeywordLuogo(keyword);
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
	public static java.util.List<com.intranet.mef.gestione.riunioni.model.Luogo> getLuogos(
		int start, int end) {
		return getService().getLuogos(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static LuogoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LuogoLocalService, LuogoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LuogoLocalService.class);
}