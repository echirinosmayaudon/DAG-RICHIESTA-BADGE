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

import service.intranet.mef.model.RichiestaBeneInv;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for RichiestaBeneInv. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RichiestaBeneInvLocalServiceUtil
 * @see service.intranet.mef.service.base.RichiestaBeneInvLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.RichiestaBeneInvLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RichiestaBeneInvLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiestaBeneInvLocalServiceUtil} to access the richiesta bene inv local service. Add custom service methods to {@link service.intranet.mef.service.impl.RichiestaBeneInvLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Returns the number of richiesta bene invs.
	*
	* @return the number of richiesta bene invs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRichiestaBeneInvsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.RichiestaBeneInvModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiestaBeneInvs(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteBeniInvByFilters(
		long id_richiesta, java.lang.String nome_rich,
		java.lang.String cogn_rich, Date data, java.lang.String dip_dir,
		List<java.lang.Long> list_id_stato, java.lang.String tipologia,
		boolean in_elenco);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteBeniInvByFiltersRichiedente(
		long id_richiesta, java.lang.String screenName, Date data,
		List<java.lang.Long> list_id_stato, java.lang.String tipologia,
		boolean in_elenco);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteByDipartimento(
		java.lang.String dipartimento);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteByDipartimentoAndStato(
		List<java.lang.String> dip_dir, long id_stato);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RichiestaBeneInv> getRichiesteByUtente(java.lang.String utente);

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
	* Adds the richiesta bene inv to the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBeneInv the richiesta bene inv
	* @return the richiesta bene inv that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RichiestaBeneInv addRichiestaBeneInv(
		RichiestaBeneInv richiestaBeneInv);

	/**
	* Creates a new richiesta bene inv with the primary key. Does not add the richiesta bene inv to the database.
	*
	* @param id_richiesta the primary key for the new richiesta bene inv
	* @return the new richiesta bene inv
	*/
	public RichiestaBeneInv createRichiestaBeneInv(long id_richiesta);

	/**
	* Deletes the richiesta bene inv with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv that was removed
	* @throws PortalException if a richiesta bene inv with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public RichiestaBeneInv deleteRichiestaBeneInv(long id_richiesta)
		throws PortalException;

	/**
	* Deletes the richiesta bene inv from the database. Also notifies the appropriate model listeners.
	*
	* @param richiestaBeneInv the richiesta bene inv
	* @return the richiesta bene inv that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public RichiestaBeneInv deleteRichiestaBeneInv(
		RichiestaBeneInv richiestaBeneInv);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RichiestaBeneInv fetchRichiestaBeneInv(long id_richiesta);

	/**
	* Returns the richiesta bene inv with the primary key.
	*
	* @param id_richiesta the primary key of the richiesta bene inv
	* @return the richiesta bene inv
	* @throws PortalException if a richiesta bene inv with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RichiestaBeneInv getRichiestaBeneInv(long id_richiesta)
		throws PortalException;

	public RichiestaBeneInv insertRichiestaBeneInv();

	/**
	* Updates the richiesta bene inv in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiestaBeneInv the richiesta bene inv
	* @return the richiesta bene inv that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RichiestaBeneInv updateRichiestaBeneInv(
		RichiestaBeneInv richiestaBeneInv);
}