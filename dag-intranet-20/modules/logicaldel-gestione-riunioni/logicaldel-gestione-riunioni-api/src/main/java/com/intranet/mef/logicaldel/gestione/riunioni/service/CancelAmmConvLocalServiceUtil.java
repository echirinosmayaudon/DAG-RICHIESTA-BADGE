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

package com.intranet.mef.logicaldel.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CancelAmmConv. This utility wraps
 * {@link com.intranet.mef.logicaldel.gestione.riunioni.service.impl.CancelAmmConvLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConvLocalService
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.base.CancelAmmConvLocalServiceBaseImpl
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.impl.CancelAmmConvLocalServiceImpl
 * @generated
 */
@ProviderType
public class CancelAmmConvLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.intranet.mef.logicaldel.gestione.riunioni.service.impl.CancelAmmConvLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cancel amm conv to the database. Also notifies the appropriate model listeners.
	*
	* @param cancelAmmConv the cancel amm conv
	* @return the cancel amm conv that was added
	*/
	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv addCancelAmmConv(
		com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv cancelAmmConv) {
		return getService().addCancelAmmConv(cancelAmmConv);
	}

	/**
	* Creates a new cancel amm conv with the primary key. Does not add the cancel amm conv to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new cancel amm conv
	* @return the new cancel amm conv
	*/
	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv createCancelAmmConv(
		long id_amministrazione_convocante) {
		return getService().createCancelAmmConv(id_amministrazione_convocante);
	}

	/**
	* Deletes the cancel amm conv from the database. Also notifies the appropriate model listeners.
	*
	* @param cancelAmmConv the cancel amm conv
	* @return the cancel amm conv that was removed
	*/
	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv deleteCancelAmmConv(
		com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv cancelAmmConv) {
		return getService().deleteCancelAmmConv(cancelAmmConv);
	}

	/**
	* Deletes the cancel amm conv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv that was removed
	* @throws PortalException if a cancel amm conv with the primary key could not be found
	*/
	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv deleteCancelAmmConv(
		long id_amministrazione_convocante)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCancelAmmConv(id_amministrazione_convocante);
	}

	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv fetchCancelAmmConv(
		long id_amministrazione_convocante) {
		return getService().fetchCancelAmmConv(id_amministrazione_convocante);
	}

	/**
	* Returns the cancel amm conv with the primary key.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv
	* @throws PortalException if a cancel amm conv with the primary key could not be found
	*/
	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv getCancelAmmConv(
		long id_amministrazione_convocante)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCancelAmmConv(id_amministrazione_convocante);
	}

	/**
	* Updates the cancel amm conv in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cancelAmmConv the cancel amm conv
	* @return the cancel amm conv that was updated
	*/
	public static com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv updateCancelAmmConv(
		com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv cancelAmmConv) {
		return getService().updateCancelAmmConv(cancelAmmConv);
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
	* Returns the number of cancel amm convs.
	*
	* @return the number of cancel amm convs
	*/
	public static int getCancelAmmConvsCount() {
		return getService().getCancelAmmConvsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv> getAmmConvByCancStatus(
		boolean cancellato) {
		return getService().getAmmConvByCancStatus(cancellato);
	}

	/**
	* Returns a range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @return the range of cancel amm convs
	*/
	public static java.util.List<com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv> getCancelAmmConvs(
		int start, int end) {
		return getService().getCancelAmmConvs(start, end);
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

	public static CancelAmmConvLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CancelAmmConvLocalService, CancelAmmConvLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CancelAmmConvLocalService.class);
}