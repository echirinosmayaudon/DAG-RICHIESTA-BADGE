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

import service.intranet.mef.model.TipologiaComputer;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for TipologiaComputer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComputerLocalServiceUtil
 * @see service.intranet.mef.service.base.TipologiaComputerLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.TipologiaComputerLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TipologiaComputerLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TipologiaComputerLocalServiceUtil} to access the tipologia computer local service. Add custom service methods to {@link service.intranet.mef.service.impl.TipologiaComputerLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Returns the number of tipologia computers.
	*
	* @return the number of tipologia computers
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTipologiaComputersCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	/**
	* Returns a range of all the tipologia computers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaComputerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia computers
	* @param end the upper bound of the range of tipologia computers (not inclusive)
	* @return the range of tipologia computers
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TipologiaComputer> getTipologiaComputers(int start, int end);

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

	/**
	* Adds the tipologia computer to the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaComputer the tipologia computer
	* @return the tipologia computer that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TipologiaComputer addTipologiaComputer(
		TipologiaComputer tipologiaComputer);

	/**
	* Creates a new tipologia computer with the primary key. Does not add the tipologia computer to the database.
	*
	* @param id_tipologia_computer the primary key for the new tipologia computer
	* @return the new tipologia computer
	*/
	public TipologiaComputer createTipologiaComputer(long id_tipologia_computer);

	/**
	* Deletes the tipologia computer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer that was removed
	* @throws PortalException if a tipologia computer with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public TipologiaComputer deleteTipologiaComputer(long id_tipologia_computer)
		throws PortalException;

	/**
	* Deletes the tipologia computer from the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaComputer the tipologia computer
	* @return the tipologia computer that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public TipologiaComputer deleteTipologiaComputer(
		TipologiaComputer tipologiaComputer);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TipologiaComputer fetchTipologiaComputer(long id_tipologia_computer);

	/**
	* Returns the tipologia computer with the primary key.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer
	* @throws PortalException if a tipologia computer with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TipologiaComputer getTipologiaComputer(long id_tipologia_computer)
		throws PortalException;

	/**
	* Updates the tipologia computer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipologiaComputer the tipologia computer
	* @return the tipologia computer that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public TipologiaComputer updateTipologiaComputer(
		TipologiaComputer tipologiaComputer);
}