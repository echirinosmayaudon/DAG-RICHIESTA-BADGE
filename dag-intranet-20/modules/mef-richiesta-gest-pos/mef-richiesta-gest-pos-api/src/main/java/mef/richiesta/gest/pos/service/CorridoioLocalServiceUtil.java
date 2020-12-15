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
 * Provides the local service utility for Corridoio. This utility wraps
 * <code>mef.richiesta.gest.pos.service.impl.CorridoioLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CorridoioLocalService
 * @generated
 */
@ProviderType
public class CorridoioLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>mef.richiesta.gest.pos.service.impl.CorridoioLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the corridoio to the database. Also notifies the appropriate model listeners.
	 *
	 * @param corridoio the corridoio
	 * @return the corridoio that was added
	 */
	public static mef.richiesta.gest.pos.model.Corridoio addCorridoio(
		mef.richiesta.gest.pos.model.Corridoio corridoio) {

		return getService().addCorridoio(corridoio);
	}

	/**
	 * Creates a new corridoio with the primary key. Does not add the corridoio to the database.
	 *
	 * @param id_pk_corridoio the primary key for the new corridoio
	 * @return the new corridoio
	 */
	public static mef.richiesta.gest.pos.model.Corridoio createCorridoio(
		long id_pk_corridoio) {

		return getService().createCorridoio(id_pk_corridoio);
	}

	/**
	 * Deletes the corridoio from the database. Also notifies the appropriate model listeners.
	 *
	 * @param corridoio the corridoio
	 * @return the corridoio that was removed
	 */
	public static mef.richiesta.gest.pos.model.Corridoio deleteCorridoio(
		mef.richiesta.gest.pos.model.Corridoio corridoio) {

		return getService().deleteCorridoio(corridoio);
	}

	/**
	 * Deletes the corridoio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio that was removed
	 * @throws PortalException if a corridoio with the primary key could not be found
	 */
	public static mef.richiesta.gest.pos.model.Corridoio deleteCorridoio(
			long id_pk_corridoio)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCorridoio(id_pk_corridoio);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static mef.richiesta.gest.pos.model.Corridoio fetchCorridoio(
		long id_pk_corridoio) {

		return getService().fetchCorridoio(id_pk_corridoio);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the corridoio with the primary key.
	 *
	 * @param id_pk_corridoio the primary key of the corridoio
	 * @return the corridoio
	 * @throws PortalException if a corridoio with the primary key could not be found
	 */
	public static mef.richiesta.gest.pos.model.Corridoio getCorridoio(
			long id_pk_corridoio)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCorridoio(id_pk_corridoio);
	}

	public static java.util.List<mef.richiesta.gest.pos.model.Corridoio>
		getCorridoioFromPiano(long idPiano) {

		return getService().getCorridoioFromPiano(idPiano);
	}

	/**
	 * Returns a range of all the corridoios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.CorridoioModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of corridoios
	 * @param end the upper bound of the range of corridoios (not inclusive)
	 * @return the range of corridoios
	 */
	public static java.util.List<mef.richiesta.gest.pos.model.Corridoio>
		getCorridoios(int start, int end) {

		return getService().getCorridoios(start, end);
	}

	/**
	 * Returns the number of corridoios.
	 *
	 * @return the number of corridoios
	 */
	public static int getCorridoiosCount() {
		return getService().getCorridoiosCount();
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
	 * Updates the corridoio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param corridoio the corridoio
	 * @return the corridoio that was updated
	 */
	public static mef.richiesta.gest.pos.model.Corridoio updateCorridoio(
		mef.richiesta.gest.pos.model.Corridoio corridoio) {

		return getService().updateCorridoio(corridoio);
	}

	public static CorridoioLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CorridoioLocalService, CorridoioLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CorridoioLocalService.class);

		ServiceTracker<CorridoioLocalService, CorridoioLocalService>
			serviceTracker =
				new ServiceTracker
					<CorridoioLocalService, CorridoioLocalService>(
						bundle.getBundleContext(), CorridoioLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}