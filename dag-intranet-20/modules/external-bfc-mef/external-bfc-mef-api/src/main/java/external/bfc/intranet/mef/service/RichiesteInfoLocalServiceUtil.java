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

package external.bfc.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RichiesteInfo. This utility wraps
 * {@link external.bfc.intranet.mef.service.impl.RichiesteInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteInfoLocalService
 * @see external.bfc.intranet.mef.service.base.RichiesteInfoLocalServiceBaseImpl
 * @see external.bfc.intranet.mef.service.impl.RichiesteInfoLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichiesteInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link external.bfc.intranet.mef.service.impl.RichiesteInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
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
	* Adds the richieste info to the database. Also notifies the appropriate model listeners.
	*
	* @param richiesteInfo the richieste info
	* @return the richieste info that was added
	*/
	public static external.bfc.intranet.mef.model.RichiesteInfo addRichiesteInfo(
		external.bfc.intranet.mef.model.RichiesteInfo richiesteInfo) {
		return getService().addRichiesteInfo(richiesteInfo);
	}

	/**
	* Creates a new richieste info with the primary key. Does not add the richieste info to the database.
	*
	* @param id the primary key for the new richieste info
	* @return the new richieste info
	*/
	public static external.bfc.intranet.mef.model.RichiesteInfo createRichiesteInfo(
		long id) {
		return getService().createRichiesteInfo(id);
	}

	/**
	* Deletes the richieste info from the database. Also notifies the appropriate model listeners.
	*
	* @param richiesteInfo the richieste info
	* @return the richieste info that was removed
	*/
	public static external.bfc.intranet.mef.model.RichiesteInfo deleteRichiesteInfo(
		external.bfc.intranet.mef.model.RichiesteInfo richiesteInfo) {
		return getService().deleteRichiesteInfo(richiesteInfo);
	}

	/**
	* Deletes the richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info that was removed
	* @throws PortalException if a richieste info with the primary key could not be found
	*/
	public static external.bfc.intranet.mef.model.RichiesteInfo deleteRichiesteInfo(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichiesteInfo(id);
	}

	public static external.bfc.intranet.mef.model.RichiesteInfo fetchRichiesteInfo(
		long id) {
		return getService().fetchRichiesteInfo(id);
	}

	/**
	* Returns the richieste info with the primary key.
	*
	* @param id the primary key of the richieste info
	* @return the richieste info
	* @throws PortalException if a richieste info with the primary key could not be found
	*/
	public static external.bfc.intranet.mef.model.RichiesteInfo getRichiesteInfo(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichiesteInfo(id);
	}

	/**
	* Updates the richieste info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiesteInfo the richieste info
	* @return the richieste info that was updated
	*/
	public static external.bfc.intranet.mef.model.RichiesteInfo updateRichiesteInfo(
		external.bfc.intranet.mef.model.RichiesteInfo richiesteInfo) {
		return getService().updateRichiesteInfo(richiesteInfo);
	}

	/**
	* Returns the number of richieste infos.
	*
	* @return the number of richieste infos
	*/
	public static int getRichiesteInfosCount() {
		return getService().getRichiesteInfosCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<external.bfc.intranet.mef.model.RichiesteInfo> findByfilters(
		java.util.List<java.lang.Long> lista_stati,
		java.util.List<java.lang.String> ufficio,
		java.util.List<com.liferay.portal.kernel.model.User> lista_utenti) {
		return getService().findByfilters(lista_stati, ufficio, lista_utenti);
	}

	public static java.util.List<external.bfc.intranet.mef.model.RichiesteInfo> getRichiesteInfobyEmail(
		java.lang.String email) {
		return getService().getRichiesteInfobyEmail(email);
	}

	/**
	* Returns a range of all the richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste infos
	* @param end the upper bound of the range of richieste infos (not inclusive)
	* @return the range of richieste infos
	*/
	public static java.util.List<external.bfc.intranet.mef.model.RichiesteInfo> getRichiesteInfos(
		int start, int end) {
		return getService().getRichiesteInfos(start, end);
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

	public static RichiesteInfoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiesteInfoLocalService, RichiesteInfoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RichiesteInfoLocalService.class);
}