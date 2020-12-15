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

package servizio.richiesta.trasporti.service;

import aQute.bnd.annotation.ProviderType;
import servizio.richiesta.trasporti.model.Mobilita;

import com.liferay.osgi.util.ServiceTrackerFactory;

import java.util.List;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Mobilita. This utility wraps
 * {@link servizio.richiesta.trasporti.service.impl.MobilitaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MobilitaLocalService
 * @see servizio.richiesta.trasporti.service.base.MobilitaLocalServiceBaseImpl
 * @see servizio.richiesta.trasporti.service.impl.MobilitaLocalServiceImpl
 * @generated
 */
@ProviderType
public class MobilitaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.richiesta.trasporti.service.impl.MobilitaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
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
	* Returns the number of mobilitas.
	*
	* @return the number of mobilitas
	*/
	public static int getMobilitasCount() {
		return getService().getMobilitasCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richiesta.trasporti.model.impl.MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richiesta.trasporti.model.impl.MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the mobilitas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richiesta.trasporti.model.impl.MobilitaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of mobilitas
	* @param end the upper bound of the range of mobilitas (not inclusive)
	* @return the range of mobilitas
	*/
	public static java.util.List<servizio.richiesta.trasporti.model.Mobilita> getMobilitas(
		int start, int end) {
		return getService().getMobilitas(start, end);
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
	* Adds the mobilita to the database. Also notifies the appropriate model listeners.
	*
	* @param mobilita the mobilita
	* @return the mobilita that was added
	*/
	public static servizio.richiesta.trasporti.model.Mobilita addMobilita(
		servizio.richiesta.trasporti.model.Mobilita mobilita) {
		return getService().addMobilita(mobilita);
	}

	/**
	* Creates a new mobilita with the primary key. Does not add the mobilita to the database.
	*
	* @param custom_key the primary key for the new mobilita
	* @return the new mobilita
	*/
	public static servizio.richiesta.trasporti.model.Mobilita createMobilita(
		java.lang.String custom_key) {
		return getService().createMobilita(custom_key);
	}

	/**
	* Deletes the mobilita with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita that was removed
	* @throws PortalException if a mobilita with the primary key could not be found
	*/
	public static servizio.richiesta.trasporti.model.Mobilita deleteMobilita(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMobilita(custom_key);
	}

	/**
	* Deletes the mobilita from the database. Also notifies the appropriate model listeners.
	*
	* @param mobilita the mobilita
	* @return the mobilita that was removed
	*/
	public static servizio.richiesta.trasporti.model.Mobilita deleteMobilita(
		servizio.richiesta.trasporti.model.Mobilita mobilita) {
		return getService().deleteMobilita(mobilita);
	}

	public static servizio.richiesta.trasporti.model.Mobilita fetchMobilita(
		java.lang.String custom_key) {
		return getService().fetchMobilita(custom_key);
	}

	/**
	* Returns the mobilita with the primary key.
	*
	* @param custom_key the primary key of the mobilita
	* @return the mobilita
	* @throws PortalException if a mobilita with the primary key could not be found
	*/
	public static servizio.richiesta.trasporti.model.Mobilita getMobilita(
		java.lang.String custom_key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMobilita(custom_key);
	}

	/**
	* Updates the mobilita in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mobilita the mobilita
	* @return the mobilita that was updated
	*/
	public static servizio.richiesta.trasporti.model.Mobilita updateMobilita(
		servizio.richiesta.trasporti.model.Mobilita mobilita) {
		return getService().updateMobilita(mobilita);
	}

	public static MobilitaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MobilitaLocalService, MobilitaLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MobilitaLocalService.class);

	public static List<Mobilita> getMobilitaByPersonId(long person_id) {
		// TODO Auto-generated method stub
		return null;
	}
}