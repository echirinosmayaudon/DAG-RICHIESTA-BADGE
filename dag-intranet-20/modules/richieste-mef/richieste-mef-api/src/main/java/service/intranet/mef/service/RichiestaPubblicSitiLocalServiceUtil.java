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
 * Provides the local service utility for RichiestaPubblicSiti. This utility wraps
 * {@link service.intranet.mef.service.impl.RichiestaPubblicSitiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaPubblicSitiLocalService
 * @see service.intranet.mef.service.base.RichiestaPubblicSitiLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.RichiestaPubblicSitiLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichiestaPubblicSitiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.RichiestaPubblicSitiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of richiesta pubblic sitis.
	*
	* @return the number of richiesta pubblic sitis
	*/
	public static int getRichiestaPubblicSitisCount() {
		return getService().getRichiestaPubblicSitisCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the richiesta pubblic sitis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaPubblicSitiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta pubblic sitis
	* @param end the upper bound of the range of richiesta pubblic sitis (not inclusive)
	* @return the range of richiesta pubblic sitis
	*/
	public static java.util.List<service.intranet.mef.model.RichiestaPubblicSiti> getRichiestaPubblicSitis(
		int start, int end) {
		return getService().getRichiestaPubblicSitis(start, end);
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
	* Adds the richiesta pubblic siti to the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaPubblicSiti the richiesta pubblic siti
	* @return the richiesta pubblic siti that was added
	*/
	public static service.intranet.mef.model.RichiestaPubblicSiti addRichiestaPubblicSiti(
		service.intranet.mef.model.RichiestaPubblicSiti richiestaPubblicSiti) {
		return getService().addRichiestaPubblicSiti(richiestaPubblicSiti);
	}

	/**
	* Creates a new richiesta pubblic siti with the primary key. Does not add the richiesta pubblic siti to the database.
	*
	* @param id_rich_pubblic the primary key for the new richiesta pubblic siti
	* @return the new richiesta pubblic siti
	*/
	public static service.intranet.mef.model.RichiestaPubblicSiti createRichiestaPubblicSiti(
		long id_rich_pubblic) {
		return getService().createRichiestaPubblicSiti(id_rich_pubblic);
	}

	/**
	* Deletes the richiesta pubblic siti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti that was removed
	* @throws PortalException if a richiesta pubblic siti with the primary key could not be found
	*/
	public static service.intranet.mef.model.RichiestaPubblicSiti deleteRichiestaPubblicSiti(
		long id_rich_pubblic)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichiestaPubblicSiti(id_rich_pubblic);
	}

	/**
	* Deletes the richiesta pubblic siti from the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaPubblicSiti the richiesta pubblic siti
	* @return the richiesta pubblic siti that was removed
	*/
	public static service.intranet.mef.model.RichiestaPubblicSiti deleteRichiestaPubblicSiti(
		service.intranet.mef.model.RichiestaPubblicSiti richiestaPubblicSiti) {
		return getService().deleteRichiestaPubblicSiti(richiestaPubblicSiti);
	}

	public static service.intranet.mef.model.RichiestaPubblicSiti fetchRichiestaPubblicSiti(
		long id_rich_pubblic) {
		return getService().fetchRichiestaPubblicSiti(id_rich_pubblic);
	}

	/**
	* Returns the richiesta pubblic siti with the primary key.
	*
	* @param id_rich_pubblic the primary key of the richiesta pubblic siti
	* @return the richiesta pubblic siti
	* @throws PortalException if a richiesta pubblic siti with the primary key could not be found
	*/
	public static service.intranet.mef.model.RichiestaPubblicSiti getRichiestaPubblicSiti(
		long id_rich_pubblic)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichiestaPubblicSiti(id_rich_pubblic);
	}

	/**
	* Updates the richiesta pubblic siti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiestaPubblicSiti the richiesta pubblic siti
	* @return the richiesta pubblic siti that was updated
	*/
	public static service.intranet.mef.model.RichiestaPubblicSiti updateRichiestaPubblicSiti(
		service.intranet.mef.model.RichiestaPubblicSiti richiestaPubblicSiti) {
		return getService().updateRichiestaPubblicSiti(richiestaPubblicSiti);
	}

	public static RichiestaPubblicSitiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaPubblicSitiLocalService, RichiestaPubblicSitiLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaPubblicSitiLocalService.class);
}