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

package external.bfc.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SediBfc. This utility wraps
 * {@link external.bfc.intranet.mef.service.impl.SediBfcLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SediBfcLocalService
 * @see external.bfc.intranet.mef.service.base.SediBfcLocalServiceBaseImpl
 * @see external.bfc.intranet.mef.service.impl.SediBfcLocalServiceImpl
 * @generated
 */
@ProviderType
public class SediBfcLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link external.bfc.intranet.mef.service.impl.SediBfcLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the sedi bfc to the database. Also notifies the appropriate model listeners.
	*
	* @param sediBfc the sedi bfc
	* @return the sedi bfc that was added
	*/
	public static external.bfc.intranet.mef.model.SediBfc addSediBfc(
		external.bfc.intranet.mef.model.SediBfc sediBfc) {
		return getService().addSediBfc(sediBfc);
	}

	/**
	* Creates a new sedi bfc with the primary key. Does not add the sedi bfc to the database.
	*
	* @param id the primary key for the new sedi bfc
	* @return the new sedi bfc
	*/
	public static external.bfc.intranet.mef.model.SediBfc createSediBfc(long id) {
		return getService().createSediBfc(id);
	}

	/**
	* Deletes the sedi bfc from the database. Also notifies the appropriate model listeners.
	*
	* @param sediBfc the sedi bfc
	* @return the sedi bfc that was removed
	*/
	public static external.bfc.intranet.mef.model.SediBfc deleteSediBfc(
		external.bfc.intranet.mef.model.SediBfc sediBfc) {
		return getService().deleteSediBfc(sediBfc);
	}

	/**
	* Deletes the sedi bfc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc that was removed
	* @throws PortalException if a sedi bfc with the primary key could not be found
	*/
	public static external.bfc.intranet.mef.model.SediBfc deleteSediBfc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSediBfc(id);
	}

	public static external.bfc.intranet.mef.model.SediBfc fetchSediBfc(long id) {
		return getService().fetchSediBfc(id);
	}

	/**
	* Returns the sedi bfc with the primary key.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc
	* @throws PortalException if a sedi bfc with the primary key could not be found
	*/
	public static external.bfc.intranet.mef.model.SediBfc getSediBfc(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSediBfc(id);
	}

	/**
	* Updates the sedi bfc in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sediBfc the sedi bfc
	* @return the sedi bfc that was updated
	*/
	public static external.bfc.intranet.mef.model.SediBfc updateSediBfc(
		external.bfc.intranet.mef.model.SediBfc sediBfc) {
		return getService().updateSediBfc(sediBfc);
	}

	/**
	* Returns the number of sedi bfcs.
	*
	* @return the number of sedi bfcs
	*/
	public static int getSediBfcsCount() {
		return getService().getSediBfcsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv2AndFlagApp(
		long id_org_liv2, boolean flag_app) {
		return getService()
				   .getSediBfcByIdOrgLiv2AndFlagApp(id_org_liv2, flag_app);
	}

	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcByIdOrgLiv3AndFlagApp(
		long id_org_liv3, boolean flag_app) {
		return getService()
				   .getSediBfcByIdOrgLiv3AndFlagApp(id_org_liv3, flag_app);
	}

	/**
	* Returns a range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of sedi bfcs
	*/
	public static java.util.List<external.bfc.intranet.mef.model.SediBfc> getSediBfcs(
		int start, int end) {
		return getService().getSediBfcs(start, end);
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

	public static SediBfcLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SediBfcLocalService, SediBfcLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SediBfcLocalService.class);
}