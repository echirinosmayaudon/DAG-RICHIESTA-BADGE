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

package com.mef.geco.intranet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for supportData. This utility wraps
 * {@link com.mef.geco.intranet.service.impl.supportDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see supportDataLocalService
 * @see com.mef.geco.intranet.service.base.supportDataLocalServiceBaseImpl
 * @see com.mef.geco.intranet.service.impl.supportDataLocalServiceImpl
 * @generated
 */
@ProviderType
public class supportDataLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.mef.geco.intranet.service.impl.supportDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the support data to the database. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was added
	*/
	public static com.mef.geco.intranet.model.supportData addsupportData(
		com.mef.geco.intranet.model.supportData supportData) {
		return getService().addsupportData(supportData);
	}

	/**
	* Creates a new support data with the primary key. Does not add the support data to the database.
	*
	* @param id the primary key for the new support data
	* @return the new support data
	*/
	public static com.mef.geco.intranet.model.supportData createsupportData(
		long id) {
		return getService().createsupportData(id);
	}

	/**
	* Deletes the support data from the database. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was removed
	*/
	public static com.mef.geco.intranet.model.supportData deletesupportData(
		com.mef.geco.intranet.model.supportData supportData) {
		return getService().deletesupportData(supportData);
	}

	/**
	* Deletes the support data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the support data
	* @return the support data that was removed
	* @throws PortalException if a support data with the primary key could not be found
	*/
	public static com.mef.geco.intranet.model.supportData deletesupportData(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletesupportData(id);
	}

	public static com.mef.geco.intranet.model.supportData fetchsupportData(
		long id) {
		return getService().fetchsupportData(id);
	}

	/**
	* Returns the support data with the primary key.
	*
	* @param id the primary key of the support data
	* @return the support data
	* @throws PortalException if a support data with the primary key could not be found
	*/
	public static com.mef.geco.intranet.model.supportData getsupportData(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getsupportData(id);
	}

	/**
	* Updates the support data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was updated
	*/
	public static com.mef.geco.intranet.model.supportData updatesupportData(
		com.mef.geco.intranet.model.supportData supportData) {
		return getService().updatesupportData(supportData);
	}

	/**
	* Returns the number of support datas.
	*
	* @return the number of support datas
	*/
	public static int getsupportDatasCount() {
		return getService().getsupportDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String nuovaRichiestaBfc(java.lang.String origine,
		java.lang.String idIntranet, java.lang.String codUtente,
		java.lang.String codiceUfficio, java.lang.String email,
		java.lang.String ispettorato, java.lang.String ufficio,
		java.lang.String telefono_richiedente,
		java.lang.String riferimento_stanza, java.lang.String idSede,
		java.lang.String oggetto, java.lang.String data,
		java.lang.String periodicita, java.lang.String budget,
		java.lang.String consuntivo,
		java.util.List<geco.mef.it.MaterialeBean> listamateriali,
		java.lang.String note, java.lang.String servizio,
		java.lang.String ambiente) {
		return getService()
				   .nuovaRichiestaBfc(origine, idIntranet, codUtente,
			codiceUfficio, email, ispettorato, ufficio, telefono_richiedente,
			riferimento_stanza, idSede, oggetto, data, periodicita, budget,
			consuntivo, listamateriali, note, servizio, ambiente);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.geco.intranet.model.impl.supportDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.geco.intranet.model.impl.supportDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<geco.mef.it.SchedaMaterialeBean> getListMateriali(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceSottogruppo,
		java.lang.String codiceUfficio, java.lang.String servizio,
		java.lang.String ambiente) {
		return getService()
				   .getListMateriali(origine, tipoMateriale, codiceGruppo,
			codiceSottogruppo, codiceUfficio, servizio, ambiente);
	}

	public static java.util.List<geco.mef.it.SottoGruppoBean> getListSottogruppi(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceUfficio,
		java.lang.String servizio, java.lang.String ambiente) {
		return getService()
				   .getListSottogruppi(origine, tipoMateriale, codiceGruppo,
			codiceUfficio, servizio, ambiente);
	}

	/**
	* Returns a range of all the support datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.mef.geco.intranet.model.impl.supportDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of support datas
	* @param end the upper bound of the range of support datas (not inclusive)
	* @return the range of support datas
	*/
	public static java.util.List<com.mef.geco.intranet.model.supportData> getsupportDatas(
		int start, int end) {
		return getService().getsupportDatas(start, end);
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

	public static supportDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<supportDataLocalService, supportDataLocalService> _serviceTracker =
		ServiceTrackerFactory.open(supportDataLocalService.class);
}