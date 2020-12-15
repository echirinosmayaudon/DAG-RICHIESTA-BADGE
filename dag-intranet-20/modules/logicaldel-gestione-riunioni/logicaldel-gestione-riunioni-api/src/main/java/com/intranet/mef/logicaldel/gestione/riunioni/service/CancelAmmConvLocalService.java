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

package com.intranet.mef.logicaldel.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.logicaldel.gestione.riunioni.model.CancelAmmConv;

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

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for CancelAmmConv. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CancelAmmConvLocalServiceUtil
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.base.CancelAmmConvLocalServiceBaseImpl
 * @see com.intranet.mef.logicaldel.gestione.riunioni.service.impl.CancelAmmConvLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CancelAmmConvLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CancelAmmConvLocalServiceUtil} to access the cancel amm conv local service. Add custom service methods to {@link com.intranet.mef.logicaldel.gestione.riunioni.service.impl.CancelAmmConvLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the cancel amm conv to the database. Also notifies the appropriate model listeners.
	*
	* @param cancelAmmConv the cancel amm conv
	* @return the cancel amm conv that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CancelAmmConv addCancelAmmConv(CancelAmmConv cancelAmmConv);

	/**
	* Creates a new cancel amm conv with the primary key. Does not add the cancel amm conv to the database.
	*
	* @param id_amministrazione_convocante the primary key for the new cancel amm conv
	* @return the new cancel amm conv
	*/
	public CancelAmmConv createCancelAmmConv(long id_amministrazione_convocante);

	/**
	* Deletes the cancel amm conv from the database. Also notifies the appropriate model listeners.
	*
	* @param cancelAmmConv the cancel amm conv
	* @return the cancel amm conv that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public CancelAmmConv deleteCancelAmmConv(CancelAmmConv cancelAmmConv);

	/**
	* Deletes the cancel amm conv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv that was removed
	* @throws PortalException if a cancel amm conv with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public CancelAmmConv deleteCancelAmmConv(long id_amministrazione_convocante)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CancelAmmConv fetchCancelAmmConv(long id_amministrazione_convocante);

	/**
	* Returns the cancel amm conv with the primary key.
	*
	* @param id_amministrazione_convocante the primary key of the cancel amm conv
	* @return the cancel amm conv
	* @throws PortalException if a cancel amm conv with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CancelAmmConv getCancelAmmConv(long id_amministrazione_convocante)
		throws PortalException;

	/**
	* Updates the cancel amm conv in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cancelAmmConv the cancel amm conv
	* @return the cancel amm conv that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CancelAmmConv updateCancelAmmConv(CancelAmmConv cancelAmmConv);

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
	* Returns the number of cancel amm convs.
	*
	* @return the number of cancel amm convs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCancelAmmConvsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<CancelAmmConv> getAmmConvByCancStatus(boolean cancellato);

	/**
	* Returns a range of all the cancel amm convs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.logicaldel.gestione.riunioni.model.impl.CancelAmmConvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cancel amm convs
	* @param end the upper bound of the range of cancel amm convs (not inclusive)
	* @return the range of cancel amm convs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CancelAmmConv> getCancelAmmConvs(int start, int end);

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