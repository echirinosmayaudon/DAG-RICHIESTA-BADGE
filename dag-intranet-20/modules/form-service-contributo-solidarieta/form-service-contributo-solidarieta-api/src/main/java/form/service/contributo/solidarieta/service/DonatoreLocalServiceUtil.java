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

package form.service.contributo.solidarieta.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Donatore. This utility wraps
 * <code>form.service.contributo.solidarieta.service.impl.DonatoreLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DonatoreLocalService
 * @generated
 */
public class DonatoreLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>form.service.contributo.solidarieta.service.impl.DonatoreLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the donatore to the database. Also notifies the appropriate model listeners.
	 *
	 * @param donatore the donatore
	 * @return the donatore that was added
	 */
	public static form.service.contributo.solidarieta.model.Donatore
		addDonatore(
			form.service.contributo.solidarieta.model.Donatore donatore) {

		return getService().addDonatore(donatore);
	}

	public static form.service.contributo.solidarieta.model.Donatore
		creaDonatore(
			String nome, String cognome, String email, String cod_fiscale,
			String importo, String data_inserimento) {

		return getService().creaDonatore(
			nome, cognome, email, cod_fiscale, importo, data_inserimento);
	}

	/**
	 * Creates a new donatore with the primary key. Does not add the donatore to the database.
	 *
	 * @param id the primary key for the new donatore
	 * @return the new donatore
	 */
	public static form.service.contributo.solidarieta.model.Donatore
		createDonatore(long id) {

		return getService().createDonatore(id);
	}

	/**
	 * Deletes the donatore from the database. Also notifies the appropriate model listeners.
	 *
	 * @param donatore the donatore
	 * @return the donatore that was removed
	 */
	public static form.service.contributo.solidarieta.model.Donatore
		deleteDonatore(
			form.service.contributo.solidarieta.model.Donatore donatore) {

		return getService().deleteDonatore(donatore);
	}

	/**
	 * Deletes the donatore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore that was removed
	 * @throws PortalException if a donatore with the primary key could not be found
	 */
	public static form.service.contributo.solidarieta.model.Donatore
			deleteDonatore(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteDonatore(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>form.service.contributo.solidarieta.model.impl.DonatoreModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>form.service.contributo.solidarieta.model.impl.DonatoreModelImpl</code>.
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

	public static form.service.contributo.solidarieta.model.Donatore
		fetchDonatore(long id) {

		return getService().fetchDonatore(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the donatore with the primary key.
	 *
	 * @param id the primary key of the donatore
	 * @return the donatore
	 * @throws PortalException if a donatore with the primary key could not be found
	 */
	public static form.service.contributo.solidarieta.model.Donatore
			getDonatore(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDonatore(id);
	}

	/**
	 * Returns a range of all the donatores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>form.service.contributo.solidarieta.model.impl.DonatoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of donatores
	 * @param end the upper bound of the range of donatores (not inclusive)
	 * @return the range of donatores
	 */
	public static java.util.List
		<form.service.contributo.solidarieta.model.Donatore> getDonatores(
			int start, int end) {

		return getService().getDonatores(start, end);
	}

	/**
	 * Returns the number of donatores.
	 *
	 * @return the number of donatores
	 */
	public static int getDonatoresCount() {
		return getService().getDonatoresCount();
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

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the donatore in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param donatore the donatore
	 * @return the donatore that was updated
	 */
	public static form.service.contributo.solidarieta.model.Donatore
		updateDonatore(
			form.service.contributo.solidarieta.model.Donatore donatore) {

		return getService().updateDonatore(donatore);
	}

	public static DonatoreLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DonatoreLocalService, DonatoreLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DonatoreLocalService.class);

		ServiceTracker<DonatoreLocalService, DonatoreLocalService>
			serviceTracker =
				new ServiceTracker<DonatoreLocalService, DonatoreLocalService>(
					bundle.getBundleContext(), DonatoreLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}