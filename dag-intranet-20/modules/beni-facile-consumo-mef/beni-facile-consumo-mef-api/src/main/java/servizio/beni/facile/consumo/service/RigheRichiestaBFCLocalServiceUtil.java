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
 * Provides the local service utility for RigheRichiestaBFC. This utility wraps
 * {@link servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCLocalService
 * @see servizio.beni.facile.consumo.service.base.RigheRichiestaBFCLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl
 * @generated
 */
@ProviderType
public class RigheRichiestaBFCLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of righe richiesta b f cs.
	*
	* @return the number of righe richiesta b f cs
	*/
	public static int getRigheRichiestaBFCsCount() {
		return getService().getRigheRichiestaBFCsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<servizio.beni.facile.consumo.model.RigheRichiestaBFC> getRigaRichiestaByIdRichiesta(
		long id_richiesta) {
		return getService().getRigaRichiestaByIdRichiesta(id_richiesta);
	}

	/**
	* Returns a range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of righe richiesta b f cs
	*/
	public static java.util.List<servizio.beni.facile.consumo.model.RigheRichiestaBFC> getRigheRichiestaBFCs(
		int start, int end) {
		return getService().getRigheRichiestaBFCs(start, end);
	}

	public static java.util.List<servizio.beni.facile.consumo.model.RigheRichiestaBFC> getRigheRichiestaByDipartimento(
		java.lang.String dipartimento) {
		return getService().getRigheRichiestaByDipartimento(dipartimento);
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
	* Adds the righe richiesta b f c to the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	* @return the righe richiesta b f c that was added
	*/
	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC addRigheRichiestaBFC(
		servizio.beni.facile.consumo.model.RigheRichiestaBFC righeRichiestaBFC) {
		return getService().addRigheRichiestaBFC(righeRichiestaBFC);
	}

	/**
	* Creates a new righe richiesta b f c with the primary key. Does not add the righe richiesta b f c to the database.
	*
	* @param id the primary key for the new righe richiesta b f c
	* @return the new righe richiesta b f c
	*/
	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC createRigheRichiestaBFC(
		long id) {
		return getService().createRigheRichiestaBFC(id);
	}

	/**
	* Deletes the righe richiesta b f c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c that was removed
	* @throws PortalException if a righe richiesta b f c with the primary key could not be found
	*/
	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC deleteRigheRichiestaBFC(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRigheRichiestaBFC(id);
	}

	/**
	* Deletes the righe richiesta b f c from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	* @return the righe richiesta b f c that was removed
	*/
	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC deleteRigheRichiestaBFC(
		servizio.beni.facile.consumo.model.RigheRichiestaBFC righeRichiestaBFC) {
		return getService().deleteRigheRichiestaBFC(righeRichiestaBFC);
	}

	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC fetchRigheRichiestaBFC(
		long id) {
		return getService().fetchRigheRichiestaBFC(id);
	}

	/**
	* Returns the righe richiesta b f c with the primary key.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c
	* @throws PortalException if a righe richiesta b f c with the primary key could not be found
	*/
	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC getRigheRichiestaBFC(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRigheRichiestaBFC(id);
	}

	/**
	* Updates the righe richiesta b f c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	* @return the righe richiesta b f c that was updated
	*/
	public static servizio.beni.facile.consumo.model.RigheRichiestaBFC updateRigheRichiestaBFC(
		servizio.beni.facile.consumo.model.RigheRichiestaBFC righeRichiestaBFC) {
		return getService().updateRigheRichiestaBFC(righeRichiestaBFC);
	}

	public static RigheRichiestaBFCLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RigheRichiestaBFCLocalService, RigheRichiestaBFCLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RigheRichiestaBFCLocalService.class);
}