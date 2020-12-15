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

package service.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for BeneInv. This utility wraps
 * {@link service.intranet.mef.service.impl.BeneInvLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BeneInvLocalService
 * @see service.intranet.mef.service.base.BeneInvLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.BeneInvLocalServiceImpl
 * @generated
 */
@ProviderType
public class BeneInvLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.BeneInvLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of bene invs.
	*
	* @return the number of bene invs
	*/
	public static int getBeneInvsCount() {
		return getService().getBeneInvsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<service.intranet.mef.model.BeneInv> getBeneInvByTipoBene(
		long id_tipo) {
		return getService().getBeneInvByTipoBene(id_tipo);
	}

	/**
	* Returns a range of all the bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.BeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bene invs
	* @param end the upper bound of the range of bene invs (not inclusive)
	* @return the range of bene invs
	*/
	public static java.util.List<service.intranet.mef.model.BeneInv> getBeneInvs(
		int start, int end) {
		return getService().getBeneInvs(start, end);
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
	* Adds the bene inv to the database. Also notifies the appropriate model listeners.
	*
	* @param beneInv the bene inv
	* @return the bene inv that was added
	*/
	public static service.intranet.mef.model.BeneInv addBeneInv(
		service.intranet.mef.model.BeneInv beneInv) {
		return getService().addBeneInv(beneInv);
	}

	/**
	* Creates a new bene inv with the primary key. Does not add the bene inv to the database.
	*
	* @param id the primary key for the new bene inv
	* @return the new bene inv
	*/
	public static service.intranet.mef.model.BeneInv createBeneInv(long id) {
		return getService().createBeneInv(id);
	}

	/**
	* Deletes the bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv that was removed
	* @throws PortalException if a bene inv with the primary key could not be found
	*/
	public static service.intranet.mef.model.BeneInv deleteBeneInv(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBeneInv(id);
	}

	/**
	* Deletes the bene inv from the database. Also notifies the appropriate model listeners.
	*
	* @param beneInv the bene inv
	* @return the bene inv that was removed
	*/
	public static service.intranet.mef.model.BeneInv deleteBeneInv(
		service.intranet.mef.model.BeneInv beneInv) {
		return getService().deleteBeneInv(beneInv);
	}

	public static service.intranet.mef.model.BeneInv fetchBeneInv(long id) {
		return getService().fetchBeneInv(id);
	}

	/**
	* Returns the bene inv with the primary key.
	*
	* @param id the primary key of the bene inv
	* @return the bene inv
	* @throws PortalException if a bene inv with the primary key could not be found
	*/
	public static service.intranet.mef.model.BeneInv getBeneInv(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBeneInv(id);
	}

	/**
	* Updates the bene inv in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param beneInv the bene inv
	* @return the bene inv that was updated
	*/
	public static service.intranet.mef.model.BeneInv updateBeneInv(
		service.intranet.mef.model.BeneInv beneInv) {
		return getService().updateBeneInv(beneInv);
	}

	public static BeneInvLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BeneInvLocalService, BeneInvLocalService> _serviceTracker =
		ServiceTrackerFactory.open(BeneInvLocalService.class);
}