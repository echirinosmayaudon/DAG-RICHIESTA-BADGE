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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.mef.geco.intranet.model.supportData;

import geco.mef.it.MaterialeBean;
import geco.mef.it.SchedaMaterialeBean;
import geco.mef.it.SottoGruppoBean;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for supportData. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see supportDataLocalServiceUtil
 * @see com.mef.geco.intranet.service.base.supportDataLocalServiceBaseImpl
 * @see com.mef.geco.intranet.service.impl.supportDataLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface supportDataLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link supportDataLocalServiceUtil} to access the support data local service. Add custom service methods to {@link com.mef.geco.intranet.service.impl.supportDataLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the support data to the database. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public supportData addsupportData(supportData supportData);

	/**
	* Creates a new support data with the primary key. Does not add the support data to the database.
	*
	* @param id the primary key for the new support data
	* @return the new support data
	*/
	public supportData createsupportData(long id);

	/**
	* Deletes the support data from the database. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public supportData deletesupportData(supportData supportData);

	/**
	* Deletes the support data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the support data
	* @return the support data that was removed
	* @throws PortalException if a support data with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public supportData deletesupportData(long id) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public supportData fetchsupportData(long id);

	/**
	* Returns the support data with the primary key.
	*
	* @param id the primary key of the support data
	* @return the support data
	* @throws PortalException if a support data with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public supportData getsupportData(long id) throws PortalException;

	/**
	* Updates the support data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supportData the support data
	* @return the support data that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public supportData updatesupportData(supportData supportData);

	/**
	* Returns the number of support datas.
	*
	* @return the number of support datas
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getsupportDatasCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public java.lang.String nuovaRichiestaBfc(java.lang.String origine,
		java.lang.String idIntranet, java.lang.String codUtente,
		java.lang.String codiceUfficio, java.lang.String email,
		java.lang.String ispettorato, java.lang.String ufficio,
		java.lang.String telefono_richiedente,
		java.lang.String riferimento_stanza, java.lang.String idSede,
		java.lang.String oggetto, java.lang.String data,
		java.lang.String periodicita, java.lang.String budget,
		java.lang.String consuntivo, List<MaterialeBean> listamateriali,
		java.lang.String note, java.lang.String servizio,
		java.lang.String ambiente);

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SchedaMaterialeBean> getListMateriali(
		java.lang.String origine, java.lang.String tipoMateriale,
		java.lang.String codiceGruppo, java.lang.String codiceSottogruppo,
		java.lang.String codiceUfficio, java.lang.String servizio,
		java.lang.String ambiente);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SottoGruppoBean> getListSottogruppi(java.lang.String origine,
		java.lang.String tipoMateriale, java.lang.String codiceGruppo,
		java.lang.String codiceUfficio, java.lang.String servizio,
		java.lang.String ambiente);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<supportData> getsupportDatas(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}