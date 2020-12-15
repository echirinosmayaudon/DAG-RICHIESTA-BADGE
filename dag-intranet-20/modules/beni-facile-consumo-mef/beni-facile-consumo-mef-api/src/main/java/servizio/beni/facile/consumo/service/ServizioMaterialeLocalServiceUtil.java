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

package servizio.beni.facile.consumo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ServizioMateriale. This utility wraps
 * {@link servizio.beni.facile.consumo.service.impl.ServizioMaterialeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMaterialeLocalService
 * @see servizio.beni.facile.consumo.service.base.ServizioMaterialeLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.impl.ServizioMaterialeLocalServiceImpl
 * @generated
 */
@ProviderType
public class ServizioMaterialeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.beni.facile.consumo.service.impl.ServizioMaterialeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of servizio materiales.
	*
	* @return the number of servizio materiales
	*/
	public static int getServizioMaterialesCount() {
		return getService().getServizioMaterialesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getGruppi() {
		return getService().getGruppi();
	}

	public static java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getGruppiByCategoria(
		java.lang.String categoria) {
		return getService().getGruppiByCategoria(categoria);
	}

	/**
	* Returns a range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @return the range of servizio materiales
	*/
	public static java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getServizioMateriales(
		int start, int end) {
		return getService().getServizioMateriales(start, end);
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
	* Adds the servizio materiale to the database. Also notifies the appropriate model listeners.
	*
	* @param servizioMateriale the servizio materiale
	* @return the servizio materiale that was added
	*/
	public static servizio.beni.facile.consumo.model.ServizioMateriale addServizioMateriale(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return getService().addServizioMateriale(servizioMateriale);
	}

	/**
	* Creates a new servizio materiale with the primary key. Does not add the servizio materiale to the database.
	*
	* @param gruppo the primary key for the new servizio materiale
	* @return the new servizio materiale
	*/
	public static servizio.beni.facile.consumo.model.ServizioMateriale createServizioMateriale(
		java.lang.String gruppo) {
		return getService().createServizioMateriale(gruppo);
	}

	/**
	* Deletes the servizio materiale with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale that was removed
	* @throws PortalException if a servizio materiale with the primary key could not be found
	*/
	public static servizio.beni.facile.consumo.model.ServizioMateriale deleteServizioMateriale(
		java.lang.String gruppo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteServizioMateriale(gruppo);
	}

	/**
	* Deletes the servizio materiale from the database. Also notifies the appropriate model listeners.
	*
	* @param servizioMateriale the servizio materiale
	* @return the servizio materiale that was removed
	*/
	public static servizio.beni.facile.consumo.model.ServizioMateriale deleteServizioMateriale(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return getService().deleteServizioMateriale(servizioMateriale);
	}

	public static servizio.beni.facile.consumo.model.ServizioMateriale fetchServizioMateriale(
		java.lang.String gruppo) {
		return getService().fetchServizioMateriale(gruppo);
	}

	/**
	* Returns the servizio materiale with the primary key.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale
	* @throws PortalException if a servizio materiale with the primary key could not be found
	*/
	public static servizio.beni.facile.consumo.model.ServizioMateriale getServizioMateriale(
		java.lang.String gruppo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getServizioMateriale(gruppo);
	}

	/**
	* Updates the servizio materiale in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param servizioMateriale the servizio materiale
	* @return the servizio materiale that was updated
	*/
	public static servizio.beni.facile.consumo.model.ServizioMateriale updateServizioMateriale(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return getService().updateServizioMateriale(servizioMateriale);
	}

	public static ServizioMaterialeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServizioMaterialeLocalService, ServizioMaterialeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ServizioMaterialeLocalService.class);
}