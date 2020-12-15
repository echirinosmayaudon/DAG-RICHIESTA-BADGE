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

package mef.richiesta.gest.pos.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Sede. This utility wraps
 * <code>mef.richiesta.gest.pos.service.impl.SedeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SedeLocalService
 * @generated
 */
@ProviderType
public class SedeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>mef.richiesta.gest.pos.service.impl.SedeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sede to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sede the sede
	 * @return the sede that was added
	 */
	public static mef.richiesta.gest.pos.model.Sede addSede(
		mef.richiesta.gest.pos.model.Sede sede) {

		return getService().addSede(sede);
	}

	/**
	 * Creates a new sede with the primary key. Does not add the sede to the database.
	 *
	 * @param id_pk_sede the primary key for the new sede
	 * @return the new sede
	 */
	public static mef.richiesta.gest.pos.model.Sede createSede(
		long id_pk_sede) {

		return getService().createSede(id_pk_sede);
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
	 * Deletes the sede with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede that was removed
	 * @throws PortalException if a sede with the primary key could not be found
	 */
	public static mef.richiesta.gest.pos.model.Sede deleteSede(long id_pk_sede)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSede(id_pk_sede);
	}

	/**
	 * Deletes the sede from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sede the sede
	 * @return the sede that was removed
	 */
	public static mef.richiesta.gest.pos.model.Sede deleteSede(
		mef.richiesta.gest.pos.model.Sede sede) {

		return getService().deleteSede(sede);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static mef.richiesta.gest.pos.model.Sede fetchSede(long id_pk_sede) {
		return getService().fetchSede(id_pk_sede);
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
	 * Returns the sede with the primary key.
	 *
	 * @param id_pk_sede the primary key of the sede
	 * @return the sede
	 * @throws PortalException if a sede with the primary key could not be found
	 */
	public static mef.richiesta.gest.pos.model.Sede getSede(long id_pk_sede)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSede(id_pk_sede);
	}

	/**
	 * Returns a range of all the sedes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.SedeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sedes
	 * @param end the upper bound of the range of sedes (not inclusive)
	 * @return the range of sedes
	 */
	public static java.util.List<mef.richiesta.gest.pos.model.Sede> getSedes(
		int start, int end) {

		return getService().getSedes(start, end);
	}

	/**
	 * Returns the number of sedes.
	 *
	 * @return the number of sedes
	 */
	public static int getSedesCount() {
		return getService().getSedesCount();
	}

	/**
	 * Updates the sede in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sede the sede
	 * @return the sede that was updated
	 */
	public static mef.richiesta.gest.pos.model.Sede updateSede(
		mef.richiesta.gest.pos.model.Sede sede) {

		return getService().updateSede(sede);
	}

	public static SedeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SedeLocalService, SedeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SedeLocalService.class);

		ServiceTracker<SedeLocalService, SedeLocalService> serviceTracker =
			new ServiceTracker<SedeLocalService, SedeLocalService>(
				bundle.getBundleContext(), SedeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}