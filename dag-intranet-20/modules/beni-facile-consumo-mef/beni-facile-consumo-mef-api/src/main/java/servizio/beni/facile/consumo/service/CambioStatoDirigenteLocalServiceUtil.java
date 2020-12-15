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
 * Provides the local service utility for CambioStatoDirigente. This utility wraps
 * {@link servizio.beni.facile.consumo.service.impl.CambioStatoDirigenteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CambioStatoDirigenteLocalService
 * @see servizio.beni.facile.consumo.service.base.CambioStatoDirigenteLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.impl.CambioStatoDirigenteLocalServiceImpl
 * @generated
 */
@ProviderType
public class CambioStatoDirigenteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.beni.facile.consumo.service.impl.CambioStatoDirigenteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean insertCambioStatoDirigente(long id_rich,
		long id_stato, java.util.Date data, java.lang.String note,
		java.lang.String nomeutente) {
		return getService()
				   .insertCambioStatoDirigente(id_rich, id_stato, data, note,
			nomeutente);
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
	* Returns the number of cambio stato dirigentes.
	*
	* @return the number of cambio stato dirigentes
	*/
	public static int getCambioStatoDirigentesCount() {
		return getService().getCambioStatoDirigentesCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.beni.facile.consumo.model.CambioStatoDirigente> getCambioStatoDirigenteByIdRichiesta(
		long id_rich) {
		return getService().getCambioStatoDirigenteByIdRichiesta(id_rich);
	}

	/**
	* Returns a range of all the cambio stato dirigentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.CambioStatoDirigenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cambio stato dirigentes
	* @param end the upper bound of the range of cambio stato dirigentes (not inclusive)
	* @return the range of cambio stato dirigentes
	*/
	public static java.util.List<servizio.beni.facile.consumo.model.CambioStatoDirigente> getCambioStatoDirigentes(
		int start, int end) {
		return getService().getCambioStatoDirigentes(start, end);
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
	* Adds the cambio stato dirigente to the database. Also notifies the appropriate model listeners.
	*
	* @param cambioStatoDirigente the cambio stato dirigente
	* @return the cambio stato dirigente that was added
	*/
	public static servizio.beni.facile.consumo.model.CambioStatoDirigente addCambioStatoDirigente(
		servizio.beni.facile.consumo.model.CambioStatoDirigente cambioStatoDirigente) {
		return getService().addCambioStatoDirigente(cambioStatoDirigente);
	}

	/**
	* Creates a new cambio stato dirigente with the primary key. Does not add the cambio stato dirigente to the database.
	*
	* @param id the primary key for the new cambio stato dirigente
	* @return the new cambio stato dirigente
	*/
	public static servizio.beni.facile.consumo.model.CambioStatoDirigente createCambioStatoDirigente(
		long id) {
		return getService().createCambioStatoDirigente(id);
	}

	/**
	* Deletes the cambio stato dirigente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente that was removed
	* @throws PortalException if a cambio stato dirigente with the primary key could not be found
	*/
	public static servizio.beni.facile.consumo.model.CambioStatoDirigente deleteCambioStatoDirigente(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCambioStatoDirigente(id);
	}

	/**
	* Deletes the cambio stato dirigente from the database. Also notifies the appropriate model listeners.
	*
	* @param cambioStatoDirigente the cambio stato dirigente
	* @return the cambio stato dirigente that was removed
	*/
	public static servizio.beni.facile.consumo.model.CambioStatoDirigente deleteCambioStatoDirigente(
		servizio.beni.facile.consumo.model.CambioStatoDirigente cambioStatoDirigente) {
		return getService().deleteCambioStatoDirigente(cambioStatoDirigente);
	}

	public static servizio.beni.facile.consumo.model.CambioStatoDirigente fetchCambioStatoDirigente(
		long id) {
		return getService().fetchCambioStatoDirigente(id);
	}

	/**
	* Returns the cambio stato dirigente with the primary key.
	*
	* @param id the primary key of the cambio stato dirigente
	* @return the cambio stato dirigente
	* @throws PortalException if a cambio stato dirigente with the primary key could not be found
	*/
	public static servizio.beni.facile.consumo.model.CambioStatoDirigente getCambioStatoDirigente(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCambioStatoDirigente(id);
	}

	/**
	* Updates the cambio stato dirigente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cambioStatoDirigente the cambio stato dirigente
	* @return the cambio stato dirigente that was updated
	*/
	public static servizio.beni.facile.consumo.model.CambioStatoDirigente updateCambioStatoDirigente(
		servizio.beni.facile.consumo.model.CambioStatoDirigente cambioStatoDirigente) {
		return getService().updateCambioStatoDirigente(cambioStatoDirigente);
	}

	public static CambioStatoDirigenteLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CambioStatoDirigenteLocalService, CambioStatoDirigenteLocalService> _serviceTracker =
		ServiceTrackerFactory.open(CambioStatoDirigenteLocalService.class);
}