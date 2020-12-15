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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RichiesteHW. This utility wraps
 * {@link service.intranet.mef.service.impl.RichiesteHWLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteHWLocalService
 * @see service.intranet.mef.service.base.RichiesteHWLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.RichiesteHWLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichiesteHWLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.RichiesteHWLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean insertRichiestaHw(java.lang.String utente,
		java.lang.String dettaglio, java.util.Date data_richiesta) {
		return getService().insertRichiestaHw(utente, dettaglio, data_richiesta);
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
	* Returns the number of richieste h ws.
	*
	* @return the number of richieste h ws
	*/
	public static int getRichiesteHWsCount() {
		return getService().getRichiesteHWsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the richieste h ws.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiesteHWModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste h ws
	* @param end the upper bound of the range of richieste h ws (not inclusive)
	* @return the range of richieste h ws
	*/
	public static java.util.List<service.intranet.mef.model.RichiesteHW> getRichiesteHWs(
		int start, int end) {
		return getService().getRichiesteHWs(start, end);
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

	/**
	* Adds the richieste h w to the database. Also notifies the appropriate model listeners.
	*
	* @param richiesteHW the richieste h w
	* @return the richieste h w that was added
	*/
	public static service.intranet.mef.model.RichiesteHW addRichiesteHW(
		service.intranet.mef.model.RichiesteHW richiesteHW) {
		return getService().addRichiesteHW(richiesteHW);
	}

	/**
	* Creates a new richieste h w with the primary key. Does not add the richieste h w to the database.
	*
	* @param id_richieste_hw the primary key for the new richieste h w
	* @return the new richieste h w
	*/
	public static service.intranet.mef.model.RichiesteHW createRichiesteHW(
		long id_richieste_hw) {
		return getService().createRichiesteHW(id_richieste_hw);
	}

	/**
	* Deletes the richieste h w with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w that was removed
	* @throws PortalException if a richieste h w with the primary key could not be found
	*/
	public static service.intranet.mef.model.RichiesteHW deleteRichiesteHW(
		long id_richieste_hw)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichiesteHW(id_richieste_hw);
	}

	/**
	* Deletes the richieste h w from the database. Also notifies the appropriate model listeners.
	*
	* @param richiesteHW the richieste h w
	* @return the richieste h w that was removed
	*/
	public static service.intranet.mef.model.RichiesteHW deleteRichiesteHW(
		service.intranet.mef.model.RichiesteHW richiesteHW) {
		return getService().deleteRichiesteHW(richiesteHW);
	}

	public static service.intranet.mef.model.RichiesteHW fetchRichiesteHW(
		long id_richieste_hw) {
		return getService().fetchRichiesteHW(id_richieste_hw);
	}

	/**
	* Returns the richieste h w with the primary key.
	*
	* @param id_richieste_hw the primary key of the richieste h w
	* @return the richieste h w
	* @throws PortalException if a richieste h w with the primary key could not be found
	*/
	public static service.intranet.mef.model.RichiesteHW getRichiesteHW(
		long id_richieste_hw)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichiesteHW(id_richieste_hw);
	}

	/**
	* Updates the richieste h w in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiesteHW the richieste h w
	* @return the richieste h w that was updated
	*/
	public static service.intranet.mef.model.RichiesteHW updateRichiesteHW(
		service.intranet.mef.model.RichiesteHW richiesteHW) {
		return getService().updateRichiesteHW(richiesteHW);
	}

	public static RichiesteHWLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiesteHWLocalService, RichiesteHWLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RichiesteHWLocalService.class);
}