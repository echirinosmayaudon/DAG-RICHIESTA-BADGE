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
 * Provides the local service utility for Orario. This utility wraps
 * {@link servizio.prenotazione.aule.mef.service.impl.OrarioLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OrarioLocalService
 * @see servizio.prenotazione.aule.mef.service.base.OrarioLocalServiceBaseImpl
 * @see servizio.prenotazione.aule.mef.service.impl.OrarioLocalServiceImpl
 * @generated
 */
@ProviderType
public class OrarioLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.prenotazione.aule.mef.service.impl.OrarioLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of orarios.
	*
	* @return the number of orarios
	*/
	public static int getOrariosCount() {
		return getService().getOrariosCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.prenotazione.aule.mef.model.Orario> findByIdOreListOre(
		java.lang.Long idOraInizio, java.lang.Long idOraFine) {
		return getService().findByIdOreListOre(idOraInizio, idOraFine);
	}

	/**
	* Returns a range of all the orarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.OrarioModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orarios
	* @param end the upper bound of the range of orarios (not inclusive)
	* @return the range of orarios
	*/
	public static java.util.List<servizio.prenotazione.aule.mef.model.Orario> getOrarios(
		int start, int end) {
		return getService().getOrarios(start, end);
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
	* Adds the orario to the database. Also notifies the appropriate model listeners.
	*
	* @param orario the orario
	* @return the orario that was added
	*/
	public static servizio.prenotazione.aule.mef.model.Orario addOrario(
		servizio.prenotazione.aule.mef.model.Orario orario) {
		return getService().addOrario(orario);
	}

	/**
	* Creates a new orario with the primary key. Does not add the orario to the database.
	*
	* @param id_ora the primary key for the new orario
	* @return the new orario
	*/
	public static servizio.prenotazione.aule.mef.model.Orario createOrario(
		long id_ora) {
		return getService().createOrario(id_ora);
	}

	/**
	* Deletes the orario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_ora the primary key of the orario
	* @return the orario that was removed
	* @throws PortalException if a orario with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.Orario deleteOrario(
		long id_ora) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteOrario(id_ora);
	}

	/**
	* Deletes the orario from the database. Also notifies the appropriate model listeners.
	*
	* @param orario the orario
	* @return the orario that was removed
	*/
	public static servizio.prenotazione.aule.mef.model.Orario deleteOrario(
		servizio.prenotazione.aule.mef.model.Orario orario) {
		return getService().deleteOrario(orario);
	}

	public static servizio.prenotazione.aule.mef.model.Orario fetchOrario(
		long id_ora) {
		return getService().fetchOrario(id_ora);
	}

	/**
	* Returns the orario with the primary key.
	*
	* @param id_ora the primary key of the orario
	* @return the orario
	* @throws PortalException if a orario with the primary key could not be found
	*/
	public static servizio.prenotazione.aule.mef.model.Orario getOrario(
		long id_ora) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getOrario(id_ora);
	}

	/**
	* Updates the orario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orario the orario
	* @return the orario that was updated
	*/
	public static servizio.prenotazione.aule.mef.model.Orario updateOrario(
		servizio.prenotazione.aule.mef.model.Orario orario) {
		return getService().updateOrario(orario);
	}

	public static OrarioLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<OrarioLocalService, OrarioLocalService> _serviceTracker =
		ServiceTrackerFactory.open(OrarioLocalService.class);
}