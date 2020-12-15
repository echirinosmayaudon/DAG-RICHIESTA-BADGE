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
 * Provides the local service utility for RichLavAgile. This utility wraps
 * {@link com.accenture.lavoro.agile.istanza.mef.service.impl.RichLavAgileLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichLavAgileLocalService
 * @see com.accenture.lavoro.agile.istanza.mef.service.base.RichLavAgileLocalServiceBaseImpl
 * @see com.accenture.lavoro.agile.istanza.mef.service.impl.RichLavAgileLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichLavAgileLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.accenture.lavoro.agile.istanza.mef.service.impl.RichLavAgileLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rich lav agile to the database. Also notifies the appropriate model listeners.
	*
	* @param richLavAgile the rich lav agile
	* @return the rich lav agile that was added
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile addRichLavAgile(
		com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile richLavAgile) {
		return getService().addRichLavAgile(richLavAgile);
	}

	/**
	* Creates a new rich lav agile with the primary key. Does not add the rich lav agile to the database.
	*
	* @param id the primary key for the new rich lav agile
	* @return the new rich lav agile
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile createRichLavAgile(
		long id) {
		return getService().createRichLavAgile(id);
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
	* Deletes the rich lav agile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile that was removed
	* @throws PortalException if a rich lav agile with the primary key could not be found
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile deleteRichLavAgile(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichLavAgile(id);
	}

	/**
	* Deletes the rich lav agile from the database. Also notifies the appropriate model listeners.
	*
	* @param richLavAgile the rich lav agile
	* @return the rich lav agile that was removed
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile deleteRichLavAgile(
		com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile richLavAgile) {
		return getService().deleteRichLavAgile(richLavAgile);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile fetchRichLavAgile(
		long id) {
		return getService().fetchRichLavAgile(id);
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

	public static java.util.List<com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile> getRichByScreename(
		String screename) {
		return getService().getRichByScreename(screename);
	}

	public static java.util.List<com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile> getRichiesteOrder(
		String order, long codiceIstanza, String cognome, long dip, long dir,
		long uff) {
		return getService()
				   .getRichiesteOrder(order, codiceIstanza, cognome, dip, dir,
			uff);
	}

	/**
	* Returns the rich lav agile with the primary key.
	*
	* @param id the primary key of the rich lav agile
	* @return the rich lav agile
	* @throws PortalException if a rich lav agile with the primary key could not be found
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile getRichLavAgile(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichLavAgile(id);
	}

	/**
	* Returns a range of all the rich lav agiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.accenture.lavoro.agile.istanza.mef.model.impl.RichLavAgileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rich lav agiles
	* @param end the upper bound of the range of rich lav agiles (not inclusive)
	* @return the range of rich lav agiles
	*/
	public static java.util.List<com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile> getRichLavAgiles(
		int start, int end) {
		return getService().getRichLavAgiles(start, end);
	}

	/**
	* Returns the number of rich lav agiles.
	*
	* @return the number of rich lav agiles
	*/
	public static int getRichLavAgilesCount() {
		return getService().getRichLavAgilesCount();
	}

	public static long insertRichiestaAgile(long id_richiesta, String cognome,
		String nome, long dipartimento, long direzione, long ufficio,
		String screename, String jsonRichiedente, String jsonRichiesta,
		int peso_tot, String peso_plus, String bando,
		java.util.Date data_richiesta, String allegato, String pdf) {
		return getService()
				   .insertRichiestaAgile(id_richiesta, cognome, nome,
			dipartimento, direzione, ufficio, screename, jsonRichiedente,
			jsonRichiesta, peso_tot, peso_plus, bando, data_richiesta,
			allegato, pdf);
	}

	/**
	* Updates the rich lav agile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richLavAgile the rich lav agile
	* @return the rich lav agile that was updated
	*/
	public static com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile updateRichLavAgile(
		com.accenture.lavoro.agile.istanza.mef.model.RichLavAgile richLavAgile) {
		return getService().updateRichLavAgile(richLavAgile);
	}

	public static RichLavAgileLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichLavAgileLocalService, RichLavAgileLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RichLavAgileLocalService.class);

		ServiceTracker<RichLavAgileLocalService, RichLavAgileLocalService> serviceTracker =
			new ServiceTracker<RichLavAgileLocalService, RichLavAgileLocalService>(bundle.getBundleContext(),
				RichLavAgileLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}