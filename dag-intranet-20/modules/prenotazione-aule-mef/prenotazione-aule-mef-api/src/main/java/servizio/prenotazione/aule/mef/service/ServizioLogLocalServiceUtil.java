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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ServizioLog. This utility wraps
 * {@link servizio.prenotazione.aule.mef.service.impl.ServizioLogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioLogLocalService
 * @see servizio.prenotazione.aule.mef.service.base.ServizioLogLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.impl.ServizioLogLocalServiceImpl
 * @generated
 */
@ProviderType
public class ServizioLogLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.prenotazione.aule.mef.service.impl.ServizioLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of servizio logs.
	*
	* @return the number of servizio logs
	*/
	public static int getServizioLogsCount() {
		return getService().getServizioLogsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.prenotazione.aule.mef.model.ServizioLog> getServizioLogListByDescServizio(
		java.lang.String desc_servizio) {
		return getService().getServizioLogListByDescServizio(desc_servizio);
	}

	/**
	* Returns a range of all the servizio logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.ServizioLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio logs
	* @param end the upper bound of the range of servizio logs (not inclusive)
	* @return the range of servizio logs
	*/
	public static java.util.List<servizio.prenotazione.aule.mef.model.ServizioLog> getServizioLogs(
		int start, int end) {
		return getService().getServizioLogs(start, end);
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
	* Adds the servizio log to the database. Also notifies the appropriate model listeners.
	*
	* @param servizioLog the servizio log
	* @return the servizio log that was added
	*/
	public static servizio.prenotazione.aule.mef.model.ServizioLog addServizioLog(
		servizio.prenotazione.aule.mef.model.ServizioLog servizioLog) {
		return getService().addServizioLog(servizioLog);
	}

	/**
	* Creates a new servizio log with the primary key. Does not add the servizio log to the database.
	*
	* @param id_servizio the primary key for the new servizio log
	* @return the new servizio log
	*/
	public static servizio.prenotazione.aule.mef.model.ServizioLog createServizioLog(
		long id_servizio) {
		return getService().createServizioLog(id_servizio);
	}

	/**
	* Deletes the servizio log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log that was removed
	* @throws PortalException if a servizio log with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.ServizioLog deleteServizioLog(
		long id_servizio)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteServizioLog(id_servizio);
	}

	/**
	* Deletes the servizio log from the database. Also notifies the appropriate model listeners.
	*
	* @param servizioLog the servizio log
	* @return the servizio log that was removed
	*/
	public static servizio.prenotazione.aule.mef.model.ServizioLog deleteServizioLog(
		servizio.prenotazione.aule.mef.model.ServizioLog servizioLog) {
		return getService().deleteServizioLog(servizioLog);
	}

	public static servizio.prenotazione.aule.mef.model.ServizioLog fetchServizioLog(
		long id_servizio) {
		return getService().fetchServizioLog(id_servizio);
	}

	/**
	* Returns the servizio log with the primary key.
	*
	* @param id_servizio the primary key of the servizio log
	* @return the servizio log
	* @throws PortalException if a servizio log with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.ServizioLog getServizioLog(
		long id_servizio)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getServizioLog(id_servizio);
	}

	/**
	* Updates the servizio log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param servizioLog the servizio log
	* @return the servizio log that was updated
	*/
	public static servizio.prenotazione.aule.mef.model.ServizioLog updateServizioLog(
		servizio.prenotazione.aule.mef.model.ServizioLog servizioLog) {
		return getService().updateServizioLog(servizioLog);
	}

	public static ServizioLogLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServizioLogLocalService, ServizioLogLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ServizioLogLocalService.class);
}