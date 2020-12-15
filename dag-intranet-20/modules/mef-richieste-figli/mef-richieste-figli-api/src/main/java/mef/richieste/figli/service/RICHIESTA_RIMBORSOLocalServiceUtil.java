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

package mef.richieste.figli.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RICHIESTA_RIMBORSO. This utility wraps
 * <code>mef.richieste.figli.service.impl.RICHIESTA_RIMBORSOLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RICHIESTA_RIMBORSOLocalService
 * @generated
 */
@ProviderType
public class RICHIESTA_RIMBORSOLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>mef.richieste.figli.service.impl.RICHIESTA_RIMBORSOLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the richiesta_rimborso to the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiesta_rimborso the richiesta_rimborso
	 * @return the richiesta_rimborso that was added
	 */
	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
		addRICHIESTA_RIMBORSO(
			mef.richieste.figli.model.RICHIESTA_RIMBORSO richiesta_rimborso) {

		return getService().addRICHIESTA_RIMBORSO(richiesta_rimborso);
	}

	/**
	 * Creates a new richiesta_rimborso with the primary key. Does not add the richiesta_rimborso to the database.
	 *
	 * @param Id the primary key for the new richiesta_rimborso
	 * @return the new richiesta_rimborso
	 */
	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
		createRICHIESTA_RIMBORSO(long Id) {

		return getService().createRICHIESTA_RIMBORSO(Id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the richiesta_rimborso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso that was removed
	 * @throws PortalException if a richiesta_rimborso with the primary key could not be found
	 */
	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
			deleteRICHIESTA_RIMBORSO(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRICHIESTA_RIMBORSO(Id);
	}

	/**
	 * Deletes the richiesta_rimborso from the database. Also notifies the appropriate model listeners.
	 *
	 * @param richiesta_rimborso the richiesta_rimborso
	 * @return the richiesta_rimborso that was removed
	 */
	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
		deleteRICHIESTA_RIMBORSO(
			mef.richieste.figli.model.RICHIESTA_RIMBORSO richiesta_rimborso) {

		return getService().deleteRICHIESTA_RIMBORSO(richiesta_rimborso);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
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

	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
		fetchRICHIESTA_RIMBORSO(long Id) {

		return getService().fetchRICHIESTA_RIMBORSO(Id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the richiesta_rimborso with the primary key.
	 *
	 * @param Id the primary key of the richiesta_rimborso
	 * @return the richiesta_rimborso
	 * @throws PortalException if a richiesta_rimborso with the primary key could not be found
	 */
	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
			getRICHIESTA_RIMBORSO(long Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRICHIESTA_RIMBORSO(Id);
	}

	/**
	 * Returns a range of all the richiesta_rimborsos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richieste.figli.model.impl.RICHIESTA_RIMBORSOModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of richiesta_rimborsos
	 * @param end the upper bound of the range of richiesta_rimborsos (not inclusive)
	 * @return the range of richiesta_rimborsos
	 */
	public static java.util.List<mef.richieste.figli.model.RICHIESTA_RIMBORSO>
		getRICHIESTA_RIMBORSOs(int start, int end) {

		return getService().getRICHIESTA_RIMBORSOs(start, end);
	}

	/**
	 * Returns the number of richiesta_rimborsos.
	 *
	 * @return the number of richiesta_rimborsos
	 */
	public static int getRICHIESTA_RIMBORSOsCount() {
		return getService().getRICHIESTA_RIMBORSOsCount();
	}

	/**
	 * Updates the richiesta_rimborso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param richiesta_rimborso the richiesta_rimborso
	 * @return the richiesta_rimborso that was updated
	 */
	public static mef.richieste.figli.model.RICHIESTA_RIMBORSO
		updateRICHIESTA_RIMBORSO(
			mef.richieste.figli.model.RICHIESTA_RIMBORSO richiesta_rimborso) {

		return getService().updateRICHIESTA_RIMBORSO(richiesta_rimborso);
	}

	public static RICHIESTA_RIMBORSOLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RICHIESTA_RIMBORSOLocalService, RICHIESTA_RIMBORSOLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RICHIESTA_RIMBORSOLocalService.class);

		ServiceTracker
			<RICHIESTA_RIMBORSOLocalService, RICHIESTA_RIMBORSOLocalService>
				serviceTracker =
					new ServiceTracker
						<RICHIESTA_RIMBORSOLocalService,
						 RICHIESTA_RIMBORSOLocalService>(
							 bundle.getBundleContext(),
							 RICHIESTA_RIMBORSOLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}