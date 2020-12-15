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

package com.intranet.mef.gestione.riunioni.service;

import aQute.bnd.annotation.ProviderType;

import com.intranet.mef.gestione.riunioni.model.Riunione;

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

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for Riunione. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RiunioneLocalServiceUtil
 * @see com.intranet.mef.gestione.riunioni.service.base.RiunioneLocalServiceBaseImpl
 * @see com.intranet.mef.gestione.riunioni.service.impl.RiunioneLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RiunioneLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RiunioneLocalServiceUtil} to access the riunione local service. Add custom service methods to {@link com.intranet.mef.gestione.riunioni.service.impl.RiunioneLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean modifyStatoRiunione(long id_riunione, Date data_modifica,
		long id_stato_riunione) throws PortalException;

	public boolean updateDataSollecitoRiunione(long riunioneId)
		throws PortalException;

	public boolean updateSpostaRiunione(long riunioneId, Date data_inizio,
		long id_luogo) throws PortalException;

	/**
	* Adds the riunione to the database. Also notifies the appropriate model listeners.
	*
	* @param riunione the riunione
	* @return the riunione that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Riunione addRiunione(Riunione riunione);

	/**
	* Creates a new riunione with the primary key. Does not add the riunione to the database.
	*
	* @param id_riunione the primary key for the new riunione
	* @return the new riunione
	*/
	public Riunione createRiunione(long id_riunione);

	/**
	* Deletes the riunione from the database. Also notifies the appropriate model listeners.
	*
	* @param riunione the riunione
	* @return the riunione that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Riunione deleteRiunione(Riunione riunione);

	/**
	* Deletes the riunione with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione that was removed
	* @throws PortalException if a riunione with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Riunione deleteRiunione(long id_riunione) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Riunione fetchRiunione(long id_riunione);

	/**
	* Returns the riunione with the primary key.
	*
	* @param id_riunione the primary key of the riunione
	* @return the riunione
	* @throws PortalException if a riunione with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Riunione getRiunione(long id_riunione) throws PortalException;

	/**
	* Updates the riunione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param riunione the riunione
	* @return the riunione that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Riunione updateRiunione(Riunione riunione);

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
	* Returns the number of riuniones.
	*
	* @return the number of riuniones
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRiunionesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public java.lang.String updateDatiRiunione(long riunioneId,
		java.lang.String oggetto, java.lang.String protocollo,
		long id_amministrazione_convocante, java.lang.String note, long id_tipo)
		throws PortalException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<Riunione> findByFilters(Date da, Date a, long stato,
		java.lang.String ogg, long isp, java.lang.String prot, long am,
		long type) throws SystemException;

	/**
	* Returns a range of all the riuniones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.intranet.mef.gestione.riunioni.model.impl.RiunioneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of riuniones
	* @param end the upper bound of the range of riuniones (not inclusive)
	* @return the range of riuniones
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Riunione> getRiuniones(int start, int end);

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

	public long setRiunione(java.lang.String oggetto, Date data_inizio,
		Date data_fine, java.lang.String note, Date data_modifica,
		Date data_creazione, java.lang.String protocollo,
		long id_stato_riunione, long id_tipo, long id_luogo,
		long id_amministrazione_convocante, long[] id_segreteria);
}