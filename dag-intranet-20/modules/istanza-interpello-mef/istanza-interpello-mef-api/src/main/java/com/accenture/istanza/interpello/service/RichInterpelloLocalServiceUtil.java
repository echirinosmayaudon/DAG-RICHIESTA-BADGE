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

package com.accenture.istanza.interpello.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RichInterpello. This utility wraps
 * {@link com.accenture.istanza.interpello.service.impl.RichInterpelloLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichInterpelloLocalService
 * @see com.accenture.istanza.interpello.service.base.RichInterpelloLocalServiceBaseImpl
 * @see com.accenture.istanza.interpello.service.impl.RichInterpelloLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichInterpelloLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.accenture.istanza.interpello.service.impl.RichInterpelloLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rich interpello to the database. Also notifies the appropriate model listeners.
	*
	* @param richInterpello the rich interpello
	* @return the rich interpello that was added
	*/
	public static com.accenture.istanza.interpello.model.RichInterpello addRichInterpello(
		com.accenture.istanza.interpello.model.RichInterpello richInterpello) {
		return getService().addRichInterpello(richInterpello);
	}

	/**
	* Creates a new rich interpello with the primary key. Does not add the rich interpello to the database.
	*
	* @param id the primary key for the new rich interpello
	* @return the new rich interpello
	*/
	public static com.accenture.istanza.interpello.model.RichInterpello createRichInterpello(
		long id) {
		return getService().createRichInterpello(id);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the rich interpello with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello that was removed
	* @throws PortalException if a rich interpello with the primary key could not be found
	*/
	public static com.accenture.istanza.interpello.model.RichInterpello deleteRichInterpello(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichInterpello(id);
	}

	/**
	* Deletes the rich interpello from the database. Also notifies the appropriate model listeners.
	*
	* @param richInterpello the rich interpello
	* @return the rich interpello that was removed
	*/
	public static com.accenture.istanza.interpello.model.RichInterpello deleteRichInterpello(
		com.accenture.istanza.interpello.model.RichInterpello richInterpello) {
		return getService().deleteRichInterpello(richInterpello);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.istanza.interpello.model.impl.RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.istanza.interpello.model.impl.RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.accenture.istanza.interpello.model.RichInterpello fetchRichInterpello(
		long id) {
		return getService().fetchRichInterpello(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
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

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<com.accenture.istanza.interpello.model.RichInterpello> getRichByScreename(
		String screename) {
		return getService().getRichByScreename(screename);
	}

	public static java.util.List<com.accenture.istanza.interpello.model.RichInterpello> getRichiesteOrder(
		String order, long codiceIstanza, String cognome, long dip, long dir,
		long uff) {
		return getService()
				   .getRichiesteOrder(order, codiceIstanza, cognome, dip, dir,
			uff);
	}

	/**
	* Returns the rich interpello with the primary key.
	*
	* @param id the primary key of the rich interpello
	* @return the rich interpello
	* @throws PortalException if a rich interpello with the primary key could not be found
	*/
	public static com.accenture.istanza.interpello.model.RichInterpello getRichInterpello(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichInterpello(id);
	}

	/**
	* Returns a range of all the rich interpellos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.istanza.interpello.model.impl.RichInterpelloModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich interpellos
	* @param end the upper bound of the range of rich interpellos (not inclusive)
	* @return the range of rich interpellos
	*/
	public static java.util.List<com.accenture.istanza.interpello.model.RichInterpello> getRichInterpellos(
		int start, int end) {
		return getService().getRichInterpellos(start, end);
	}

	/**
	* Returns the number of rich interpellos.
	*
	* @return the number of rich interpellos
	*/
	public static int getRichInterpellosCount() {
		return getService().getRichInterpellosCount();
	}

	public static long insertRichiestaInterpello(long id_richiesta,
		String cognome, String nome, long dipartimento, long direzione,
		long ufficio, String screename, String jsonRichiedente,
		String jsonRichiesta, String bando, java.util.Date data_richiesta,
		String allegato, String pdf, String note) {
		return getService()
				   .insertRichiestaInterpello(id_richiesta, cognome, nome,
			dipartimento, direzione, ufficio, screename, jsonRichiedente,
			jsonRichiesta, bando, data_richiesta, allegato, pdf, note);
	}

	/**
	* Updates the rich interpello in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richInterpello the rich interpello
	* @return the rich interpello that was updated
	*/
	public static com.accenture.istanza.interpello.model.RichInterpello updateRichInterpello(
		com.accenture.istanza.interpello.model.RichInterpello richInterpello) {
		return getService().updateRichInterpello(richInterpello);
	}

	public static RichInterpelloLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichInterpelloLocalService, RichInterpelloLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RichInterpelloLocalService.class);

		ServiceTracker<RichInterpelloLocalService, RichInterpelloLocalService> serviceTracker =
			new ServiceTracker<RichInterpelloLocalService, RichInterpelloLocalService>(bundle.getBundleContext(),
				RichInterpelloLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}