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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link supportDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see supportDataLocalService
 * @generated
 */
@ProviderType
public class supportDataLocalServiceWrapper implements supportDataLocalService,
	ServiceWrapper<supportDataLocalService> {
	public supportDataLocalServiceWrapper(
		supportDataLocalService supportDataLocalService) {
		_supportDataLocalService = supportDataLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _supportDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supportDataLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _supportDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supportDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supportDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the support data to the database. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was added
	*/
	@Override
	public com.mef.geco.intranet.model.supportData addsupportData(
		com.mef.geco.intranet.model.supportData supportData) {
		return _supportDataLocalService.addsupportData(supportData);
	}

	/**
	* Creates a new support data with the primary key. Does not add the support data to the database.
	*
	* @param id the primary key for the new support data
	* @return the new support data
	*/
	@Override
	public com.mef.geco.intranet.model.supportData createsupportData(long id) {
		return _supportDataLocalService.createsupportData(id);
	}

	/**
	* Deletes the support data from the database. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was removed
	*/
	@Override
	public com.mef.geco.intranet.model.supportData deletesupportData(
		com.mef.geco.intranet.model.supportData supportData) {
		return _supportDataLocalService.deletesupportData(supportData);
	}

	/**
	* Deletes the support data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the support data
	* @return the support data that was removed
	* @throws PortalException if a support data with the primary key could not be found
	*/
	@Override
	public com.mef.geco.intranet.model.supportData deletesupportData(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supportDataLocalService.deletesupportData(id);
	}

	@Override
	public com.mef.geco.intranet.model.supportData fetchsupportData(long id) {
		return _supportDataLocalService.fetchsupportData(id);
	}

	/**
	* Returns the support data with the primary key.
	*
	* @param id the primary key of the support data
	* @return the support data
	* @throws PortalException if a support data with the primary key could not be found
	*/
	@Override
	public com.mef.geco.intranet.model.supportData getsupportData(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _supportDataLocalService.getsupportData(id);
	}

	/**
	* Updates the support data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was updated
	*/
	@Override
	public com.mef.geco.intranet.model.supportData updatesupportData(
		com.mef.geco.intranet.model.supportData supportData) {
		return _supportDataLocalService.updatesupportData(supportData);
	}

	/**
	* Returns the number of support datas.
	*
	* @return the number of support datas
	*/
	@Override
	public int getsupportDatasCount() {
		return _supportDataLocalService.getsupportDatasCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _supportDataLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String nuovaRichiestaBfc(java.lang.String origine,
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
		return _supportDataLocalService.nuovaRichiestaBfc(origine, idIntranet,
			codUtente, codiceUfficio, email, ispettorato, ufficio,
			telefono_richiedente, riferimento_stanza, idSede, oggetto, data,
			periodicita, budget, consuntivo, listamateriali, note, servizio,
			ambiente);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _supportDataLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _supportDataLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _supportDataLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<geco.mef.it.SchedaMaterialeBean> getListMateriali(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceSottogruppo,
		java.lang.String codiceUfficio, java.lang.String servizio,
		java.lang.String ambiente) {
		return _supportDataLocalService.getListMateriali(origine,
			tipoMateriale, codiceGruppo, codiceSottogruppo, codiceUfficio,
			servizio, ambiente);
	}

	@Override
	public java.util.List<geco.mef.it.SottoGruppoBean> getListSottogruppi(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceUfficio,
		java.lang.String servizio, java.lang.String ambiente) {
		return _supportDataLocalService.getListSottogruppi(origine,
			tipoMateriale, codiceGruppo, codiceUfficio, servizio, ambiente);
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
	@Override
	public java.util.List<com.mef.geco.intranet.model.supportData> getsupportDatas(
		int start, int end) {
		return _supportDataLocalService.getsupportDatas(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _supportDataLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _supportDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public supportDataLocalService getWrappedService() {
		return _supportDataLocalService;
	}

	@Override
	public void setWrappedService(
		supportDataLocalService supportDataLocalService) {
		_supportDataLocalService = supportDataLocalService;
	}

	private supportDataLocalService _supportDataLocalService;
}