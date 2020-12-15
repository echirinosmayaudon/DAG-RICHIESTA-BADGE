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

package servizio.prenotazione.aule.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SalaStruttura. This utility wraps
 * {@link servizio.prenotazione.aule.mef.service.impl.SalaStrutturaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SalaStrutturaLocalService
 * @see servizio.prenotazione.aule.mef.service.base.SalaStrutturaLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.impl.SalaStrutturaLocalServiceImpl
 * @generated
 */
@ProviderType
public class SalaStrutturaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.prenotazione.aule.mef.service.impl.SalaStrutturaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of sala strutturas.
	*
	* @return the number of sala strutturas
	*/
	public static int getSalaStrutturasCount() {
		return getService().getSalaStrutturasCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the sala strutturas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.SalaStrutturaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sala strutturas
	* @param end the upper bound of the range of sala strutturas (not inclusive)
	* @return the range of sala strutturas
	*/
	public static java.util.List<servizio.prenotazione.aule.mef.model.SalaStruttura> getSalaStrutturas(
		int start, int end) {
		return getService().getSalaStrutturas(start, end);
	}

	public static java.util.List<servizio.prenotazione.aule.mef.model.SalaStruttura> getSaleListByIdStruttura(
		long id_struttura) {
		return getService().getSaleListByIdStruttura(id_struttura);
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
	* Adds the sala struttura to the database. Also notifies the appropriate model listeners.
	*
	* @param salaStruttura the sala struttura
	* @return the sala struttura that was added
	*/
	public static servizio.prenotazione.aule.mef.model.SalaStruttura addSalaStruttura(
		servizio.prenotazione.aule.mef.model.SalaStruttura salaStruttura) {
		return getService().addSalaStruttura(salaStruttura);
	}

	/**
	* Creates a new sala struttura with the primary key. Does not add the sala struttura to the database.
	*
	* @param id the primary key for the new sala struttura
	* @return the new sala struttura
	*/
	public static servizio.prenotazione.aule.mef.model.SalaStruttura createSalaStruttura(
		long id) {
		return getService().createSalaStruttura(id);
	}

	/**
	* Deletes the sala struttura with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura that was removed
	* @throws PortalException if a sala struttura with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.SalaStruttura deleteSalaStruttura(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSalaStruttura(id);
	}

	/**
	* Deletes the sala struttura from the database. Also notifies the appropriate model listeners.
	*
	* @param salaStruttura the sala struttura
	* @return the sala struttura that was removed
	*/
	public static servizio.prenotazione.aule.mef.model.SalaStruttura deleteSalaStruttura(
		servizio.prenotazione.aule.mef.model.SalaStruttura salaStruttura) {
		return getService().deleteSalaStruttura(salaStruttura);
	}

	public static servizio.prenotazione.aule.mef.model.SalaStruttura fetchSalaStruttura(
		long id) {
		return getService().fetchSalaStruttura(id);
	}

	/**
	* Returns the sala struttura with the primary key.
	*
	* @param id the primary key of the sala struttura
	* @return the sala struttura
	* @throws PortalException if a sala struttura with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.SalaStruttura getSalaStruttura(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSalaStruttura(id);
	}

	/**
	* Updates the sala struttura in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param salaStruttura the sala struttura
	* @return the sala struttura that was updated
	*/
	public static servizio.prenotazione.aule.mef.model.SalaStruttura updateSalaStruttura(
		servizio.prenotazione.aule.mef.model.SalaStruttura salaStruttura) {
		return getService().updateSalaStruttura(salaStruttura);
	}

	public static SalaStrutturaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SalaStrutturaLocalService, SalaStrutturaLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SalaStrutturaLocalService.class);
}