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

package autorizzazione.dir.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UtilizzoApplicazioni. This utility wraps
 * {@link autorizzazione.dir.mef.service.impl.UtilizzoApplicazioniLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UtilizzoApplicazioniLocalService
 * @see autorizzazione.dir.mef.service.base.UtilizzoApplicazioniLocalServiceBaseImpl
 * @see autorizzazione.dir.mef.service.impl.UtilizzoApplicazioniLocalServiceImpl
 * @generated
 */
@ProviderType
public class UtilizzoApplicazioniLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link autorizzazione.dir.mef.service.impl.UtilizzoApplicazioniLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni addNewHit(
		long userId, long applicationId) {
		return getService().addNewHit(userId, applicationId);
	}

	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni addNewMediaHit(
		long applicationId) {
		return getService().addNewMediaHit(applicationId);
	}

	/**
	* Adds the utilizzo applicazioni to the database. Also notifies the appropriate model listeners.
	*
	* @param utilizzoApplicazioni the utilizzo applicazioni
	* @return the utilizzo applicazioni that was added
	*/
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni addUtilizzoApplicazioni(
		autorizzazione.dir.mef.model.UtilizzoApplicazioni utilizzoApplicazioni) {
		return getService().addUtilizzoApplicazioni(utilizzoApplicazioni);
	}

	/**
	* Creates a new utilizzo applicazioni with the primary key. Does not add the utilizzo applicazioni to the database.
	*
	* @param utilizzoApplicazioniPK the primary key for the new utilizzo applicazioni
	* @return the new utilizzo applicazioni
	*/
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni createUtilizzoApplicazioni(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK) {
		return getService().createUtilizzoApplicazioni(utilizzoApplicazioniPK);
	}

	/**
	* Deletes the utilizzo applicazioni from the database. Also notifies the appropriate model listeners.
	*
	* @param utilizzoApplicazioni the utilizzo applicazioni
	* @return the utilizzo applicazioni that was removed
	*/
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni deleteUtilizzoApplicazioni(
		autorizzazione.dir.mef.model.UtilizzoApplicazioni utilizzoApplicazioni) {
		return getService().deleteUtilizzoApplicazioni(utilizzoApplicazioni);
	}

	/**
	* Deletes the utilizzo applicazioni with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni that was removed
	* @throws PortalException if a utilizzo applicazioni with the primary key could not be found
	*/
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni deleteUtilizzoApplicazioni(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUtilizzoApplicazioni(utilizzoApplicazioniPK);
	}

	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni fetchUtilizzoApplicazioni(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK) {
		return getService().fetchUtilizzoApplicazioni(utilizzoApplicazioniPK);
	}

	/**
	* Returns the utilizzo applicazioni with the primary key.
	*
	* @param utilizzoApplicazioniPK the primary key of the utilizzo applicazioni
	* @return the utilizzo applicazioni
	* @throws PortalException if a utilizzo applicazioni with the primary key could not be found
	*/
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni getUtilizzoApplicazioni(
		autorizzazione.dir.mef.service.persistence.UtilizzoApplicazioniPK utilizzoApplicazioniPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUtilizzoApplicazioni(utilizzoApplicazioniPK);
	}

	/**
	* Updates the utilizzo applicazioni in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param utilizzoApplicazioni the utilizzo applicazioni
	* @return the utilizzo applicazioni that was updated
	*/
	public static autorizzazione.dir.mef.model.UtilizzoApplicazioni updateUtilizzoApplicazioni(
		autorizzazione.dir.mef.model.UtilizzoApplicazioni utilizzoApplicazioni) {
		return getService().updateUtilizzoApplicazioni(utilizzoApplicazioni);
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
	* Returns the number of utilizzo applicazionis.
	*
	* @return the number of utilizzo applicazionis
	*/
	public static int getUtilizzoApplicazionisCount() {
		return getService().getUtilizzoApplicazionisCount();
	}

	public static java.lang.String fetchLastHitsByUserId(long userId) {
		return getService().fetchLastHitsByUserId(userId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<autorizzazione.dir.mef.model.UtilizzoApplicazioni> fetchLastMediaHits() {
		return getService().fetchLastMediaHits();
	}

	/**
	* Returns a range of all the utilizzo applicazionis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link autorizzazione.dir.mef.model.impl.UtilizzoApplicazioniModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of utilizzo applicazionis
	* @param end the upper bound of the range of utilizzo applicazionis (not inclusive)
	* @return the range of utilizzo applicazionis
	*/
	public static java.util.List<autorizzazione.dir.mef.model.UtilizzoApplicazioni> getUtilizzoApplicazionis(
		int start, int end) {
		return getService().getUtilizzoApplicazionis(start, end);
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

	public static UtilizzoApplicazioniLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UtilizzoApplicazioniLocalService, UtilizzoApplicazioniLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UtilizzoApplicazioniLocalService.class);
}