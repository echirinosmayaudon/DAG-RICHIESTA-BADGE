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

package com.intranet.mef.central.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CentralInvoker. This utility wraps
 * {@link com.intranet.mef.central.service.impl.CentralInvokerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CentralInvokerLocalService
 * @see com.intranet.mef.central.service.base.CentralInvokerLocalServiceBaseImpl
 * @see com.intranet.mef.central.service.impl.CentralInvokerLocalServiceImpl
 * @generated
 */
@ProviderType
public class CentralInvokerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.central.service.impl.CentralInvokerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Return all roles id of type Architettural
	*
	* @param companyId
	* @return List<Role>
	*/
	public static boolean isTeamArchitettural(java.lang.Long teamId) {
		return getService().isTeamArchitettural(teamId);
	}

	/**
	* Adds the central invoker to the database. Also notifies the appropriate model listeners.
	*
	* @param centralInvoker the central invoker
	* @return the central invoker that was added
	*/
	public static com.intranet.mef.central.model.CentralInvoker addCentralInvoker(
		com.intranet.mef.central.model.CentralInvoker centralInvoker) {
		return getService().addCentralInvoker(centralInvoker);
	}

	/**
	* Creates a new central invoker with the primary key. Does not add the central invoker to the database.
	*
	* @param idRecord the primary key for the new central invoker
	* @return the new central invoker
	*/
	public static com.intranet.mef.central.model.CentralInvoker createCentralInvoker(
		long idRecord) {
		return getService().createCentralInvoker(idRecord);
	}

	/**
	* Deletes the central invoker from the database. Also notifies the appropriate model listeners.
	*
	* @param centralInvoker the central invoker
	* @return the central invoker that was removed
	*/
	public static com.intranet.mef.central.model.CentralInvoker deleteCentralInvoker(
		com.intranet.mef.central.model.CentralInvoker centralInvoker) {
		return getService().deleteCentralInvoker(centralInvoker);
	}

	/**
	* Deletes the central invoker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker that was removed
	* @throws PortalException if a central invoker with the primary key could not be found
	*/
	public static com.intranet.mef.central.model.CentralInvoker deleteCentralInvoker(
		long idRecord)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCentralInvoker(idRecord);
	}

	public static com.intranet.mef.central.model.CentralInvoker fetchCentralInvoker(
		long idRecord) {
		return getService().fetchCentralInvoker(idRecord);
	}

	/**
	* Returns the central invoker with the primary key.
	*
	* @param idRecord the primary key of the central invoker
	* @return the central invoker
	* @throws PortalException if a central invoker with the primary key could not be found
	*/
	public static com.intranet.mef.central.model.CentralInvoker getCentralInvoker(
		long idRecord)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCentralInvoker(idRecord);
	}

	/**
	* Updates the central invoker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param centralInvoker the central invoker
	* @return the central invoker that was updated
	*/
	public static com.intranet.mef.central.model.CentralInvoker updateCentralInvoker(
		com.intranet.mef.central.model.CentralInvoker centralInvoker) {
		return getService().updateCentralInvoker(centralInvoker);
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
	* Returns the number of central invokers.
	*
	* @return the number of central invokers
	*/
	public static int getCentralInvokersCount() {
		return getService().getCentralInvokersCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.central.model.impl.CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.central.model.impl.CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.intranet.mef.job.siap.model.Location> findLocationById(
		long id) {
		return getService().findLocationById(id);
	}

	/**
	* Returns a range of all the central invokers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.central.model.impl.CentralInvokerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of central invokers
	* @param end the upper bound of the range of central invokers (not inclusive)
	* @return the range of central invokers
	*/
	public static java.util.List<com.intranet.mef.central.model.CentralInvoker> getCentralInvokers(
		int start, int end) {
		return getService().getCentralInvokers(start, end);
	}

	/**
	* Return all roles id of type Architettural
	*
	* @param companyId
	* @return List<Role>
	*/
	public static java.util.List<java.lang.Long> getRolesIsArchitettural(
		java.lang.Long companyId) {
		return getService().getRolesIsArchitettural(companyId);
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

	public static CentralInvokerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CentralInvokerLocalService, CentralInvokerLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CentralInvokerLocalService.class);
}