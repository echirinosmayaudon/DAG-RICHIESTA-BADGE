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
 * Provides the local service utility for RichiestaBeneInv. This utility wraps
 * {@link service.intranet.mef.service.impl.RichiestaBeneInvLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvLocalService
 * @see service.intranet.mef.service.base.RichiestaBeneInvLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.RichiestaBeneInvLocalServiceImpl
 * @generated
 */
@ProviderType
public class RichiestaBeneInvLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.RichiestaBeneInvLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of richiesta bene invs.
	*
	* @return the number of richiesta bene invs
	*/
	public static int getRichiestaBeneInvsCount() {
		return getService().getRichiestaBeneInvsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the richiesta bene invs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiesta bene invs
	* @param end the upper bound of the range of richiesta bene invs (not inclusive)
	* @return the range of richiesta bene invs
	*/
	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiestaBeneInvs(
		int start, int end) {
		return getService().getRichiestaBeneInvs(start, end);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFilters(
		long id_richiesta, java.lang.String nome_rich,
		java.lang.String cogn_rich, java.util.Date data,
		java.lang.String dip_dir, java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco) {
		return getService()
				   .getRichiesteBeniInvByFilters(id_richiesta, nome_rich,
			cogn_rich, data, dip_dir, list_id_stato, tipologia, in_elenco);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(
		long id_richiesta, java.lang.String screenName, java.util.Date data,
		java.util.List<java.lang.Long> list_id_stato,
		java.lang.String tipologia, boolean in_elenco) {
		return getService()
				   .getRichiesteBeniInvByFiltersRichiedente(id_richiesta,
			screenName, data, list_id_stato, tipologia, in_elenco);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByDipartimento(
		java.lang.String dipartimento) {
		return getService().getRichiesteByDipartimento(dipartimento);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByDipartimentoAndStato(
		java.util.List<java.lang.String> dip_dir, long id_stato) {
		return getService().getRichiesteByDipartimentoAndStato(dip_dir, id_stato);
	}

	public static java.util.List<service.intranet.mef.model.RichiestaBeneInv> getRichiesteByUtente(
		java.lang.String utente) {
		return getService().getRichiesteByUtente(utente);
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
	* Adds the richiesta bene inv to the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBeneInv the richiesta bene inv
	* @return the richiesta bene inv that was added
	*/
	public static service.intranet.mef.model.RichiestaBeneInv addRichiestaBeneInv(
		service.intranet.mef.model.RichiestaBeneInv richiestaBeneInv) {
		return getService().addRichiestaBeneInv(richiestaBeneInv);
	}

	/**
	* Creates a new richiesta bene inv with the primary key. Does not add the richiesta bene inv to the database.
	*
	* @param id_richiesta the primary key for the new richiesta bene inv
	* @return the new richiesta bene inv
	*/
	public static service.intranet.mef.model.RichiestaBeneInv createRichiestaBeneInv(
		long id_richiesta) {
		return getService().createRichiestaBeneInv(id_richiesta);
	}

	/**
	* Deletes the richiesta bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv that was removed
	* @throws PortalException if a richiesta bene inv with the primary key could not be found
	*/
	public static service.intranet.mef.model.RichiestaBeneInv deleteRichiestaBeneInv(
		long id_richiesta)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRichiestaBeneInv(id_richiesta);
	}

	/**
	* Deletes the richiesta bene inv from the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBeneInv the richiesta bene inv
	* @return the richiesta bene inv that was removed
	*/
	public static service.intranet.mef.model.RichiestaBeneInv deleteRichiestaBeneInv(
		service.intranet.mef.model.RichiestaBeneInv richiestaBeneInv) {
		return getService().deleteRichiestaBeneInv(richiestaBeneInv);
	}

	public static service.intranet.mef.model.RichiestaBeneInv fetchRichiestaBeneInv(
		long id_richiesta) {
		return getService().fetchRichiestaBeneInv(id_richiesta);
	}

	/**
	* Returns the richiesta bene inv with the primary key.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv
	* @throws PortalException if a richiesta bene inv with the primary key could not be found
	*/
	public static service.intranet.mef.model.RichiestaBeneInv getRichiestaBeneInv(
		long id_richiesta)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRichiestaBeneInv(id_richiesta);
	}

	public static service.intranet.mef.model.RichiestaBeneInv insertRichiestaBeneInv() {
		return getService().insertRichiestaBeneInv();
	}

	/**
	* Updates the richiesta bene inv in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiestaBeneInv the richiesta bene inv
	* @return the richiesta bene inv that was updated
	*/
	public static service.intranet.mef.model.RichiestaBeneInv updateRichiestaBeneInv(
		service.intranet.mef.model.RichiestaBeneInv richiestaBeneInv) {
		return getService().updateRichiestaBeneInv(richiestaBeneInv);
	}

	public static RichiestaBeneInvLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RichiestaBeneInvLocalService, RichiestaBeneInvLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RichiestaBeneInvLocalService.class);
}