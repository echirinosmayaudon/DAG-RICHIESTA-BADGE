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

package com.accenture.lavoro.agile.istanza.mef.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OpzioneRich. This utility wraps
 * {@link com.accenture.lavoro.agile.istanza.mef.service.impl.OpzioneRichLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OpzioneRichLocalService
 * @see com.accenture.lavoro.agile.istanza.mef.service.base.OpzioneRichLocalServiceBaseImpl
 * @see com.accenture.lavoro.agile.istanza.mef.service.impl.OpzioneRichLocalServiceImpl
 * @generated
 */
@ProviderType
public class OpzioneRichLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.accenture.lavoro.agile.istanza.mef.service.impl.OpzioneRichLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the opzione rich to the database. Also notifies the appropriate model listeners.
	*
	* @param opzioneRich the opzione rich
	* @return the opzione rich that was added
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich addOpzioneRich(
		com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich opzioneRich) {
		return getService().addOpzioneRich(opzioneRich);
	}

	/**
	* Creates a new opzione rich with the primary key. Does not add the opzione rich to the database.
	*
	* @param id_opt the primary key for the new opzione rich
	* @return the new opzione rich
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich createOpzioneRich(
		long id_opt) {
		return getService().createOpzioneRich(id_opt);
	}

	/**
	* Deletes the opzione rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich that was removed
	* @throws PortalException if a opzione rich with the primary key could not be found
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich deleteOpzioneRich(
		long id_opt) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteOpzioneRich(id_opt);
	}

	/**
	* Deletes the opzione rich from the database. Also notifies the appropriate model listeners.
	*
	* @param opzioneRich the opzione rich
	* @return the opzione rich that was removed
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich deleteOpzioneRich(
		com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich opzioneRich) {
		return getService().deleteOpzioneRich(opzioneRich);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich fetchOpzioneRich(
		long id_opt) {
		return getService().fetchOpzioneRich(id_opt);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich getOptionByLabel(
		String label_opt) {
		return getService().getOptionByLabel(label_opt);
	}

	/**
	* Returns the opzione rich with the primary key.
	*
	* @param id_opt the primary key of the opzione rich
	* @return the opzione rich
	* @throws PortalException if a opzione rich with the primary key could not be found
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich getOpzioneRich(
		long id_opt) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getOpzioneRich(id_opt);
	}

	/**
	* Returns a range of all the opzione richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.OpzioneRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of opzione richs
	* @param end the upper bound of the range of opzione richs (not inclusive)
	* @return the range of opzione richs
	*/
	public static java.util.List<com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich> getOpzioneRichs(
		int start, int end) {
		return getService().getOpzioneRichs(start, end);
	}

	/**
	* Returns the number of opzione richs.
	*
	* @return the number of opzione richs
	*/
	public static int getOpzioneRichsCount() {
		return getService().getOpzioneRichsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the opzione rich in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param opzioneRich the opzione rich
	* @return the opzione rich that was updated
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich updateOpzioneRich(
		com.accenture.lavoro.agile.istanza.mef.model.OpzioneRich opzioneRich) {
		return getService().updateOpzioneRich(opzioneRich);
	}

	public static OpzioneRichLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OpzioneRichLocalService, OpzioneRichLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OpzioneRichLocalService.class);

		ServiceTracker<OpzioneRichLocalService, OpzioneRichLocalService> serviceTracker =
			new ServiceTracker<OpzioneRichLocalService, OpzioneRichLocalService>(bundle.getBundleContext(),
				OpzioneRichLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}