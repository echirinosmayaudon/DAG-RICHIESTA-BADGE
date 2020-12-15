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

package servizio.local.bfc.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import servizio.local.bfc.model.LocalRichInfo;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for LocalRichInfo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichInfoLocalServiceUtil
 * @see servizio.local.bfc.service.base.LocalRichInfoLocalServiceBaseImpl
 * @see servizio.local.bfc.service.impl.LocalRichInfoLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LocalRichInfoLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalRichInfoLocalServiceUtil} to access the local rich info local service. Add custom service methods to {@link servizio.local.bfc.service.impl.LocalRichInfoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Returns the number of local rich infos.
	*
	* @return the number of local rich infos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLocalRichInfosCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<LocalRichInfo> findByfilters(List<java.lang.Long> lista_stati,
		List<java.lang.String> ufficio, List<User> lista_utenti, boolean instage);

	/**
	* Returns a range of all the local rich infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local rich infos
	* @param end the upper bound of the range of local rich infos (not inclusive)
	* @return the range of local rich infos
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LocalRichInfo> getLocalRichInfos(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LocalRichInfo> getRichiestebyEmail(boolean instage,
		java.lang.String email);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LocalRichInfo> getRichiestebyIdRichiesta(long id_richiesta);

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
	* Adds the local rich info to the database. Also notifies the appropriate model listeners.
	*
	* @param localRichInfo the local rich info
	* @return the local rich info that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LocalRichInfo addLocalRichInfo(LocalRichInfo localRichInfo);

	/**
	* Creates a new local rich info with the primary key. Does not add the local rich info to the database.
	*
	* @param id the primary key for the new local rich info
	* @return the new local rich info
	*/
	public LocalRichInfo createLocalRichInfo(long id);

	/**
	* Deletes the local rich info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info that was removed
	* @throws PortalException if a local rich info with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public LocalRichInfo deleteLocalRichInfo(long id) throws PortalException;

	/**
	* Deletes the local rich info from the database. Also notifies the appropriate model listeners.
	*
	* @param localRichInfo the local rich info
	* @return the local rich info that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public LocalRichInfo deleteLocalRichInfo(LocalRichInfo localRichInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LocalRichInfo fetchLocalRichInfo(long id);

	/**
	* Returns the local rich info with the primary key.
	*
	* @param id the primary key of the local rich info
	* @return the local rich info
	* @throws PortalException if a local rich info with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LocalRichInfo getLocalRichInfo(long id) throws PortalException;

	public LocalRichInfo insertLocalRichInfo(java.lang.Long id_richiesta,
		java.lang.Float costoReale, Date dataIns, Date dataRichiesta,
		Date dataUpd, java.lang.String email, java.lang.Integer flagInvio,
		java.lang.String nMacchina, java.lang.String idSede,
		java.lang.Long idStatoAttuale, java.lang.String ispettorato,
		java.lang.String note, java.lang.String noteRichiedente,
		java.lang.String nomeReferente, java.lang.String oggetto,
		java.lang.Integer preventivo, java.lang.String riferimentoStanza,
		java.lang.String strutIsp, java.lang.String strutUff,
		java.lang.String telRichiedente, java.lang.String telefonoReferente,
		java.lang.String ufficio, java.lang.Long uidIns, java.lang.Long uidUpd,
		boolean inStage);

	/**
	* Updates the local rich info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param localRichInfo the local rich info
	* @return the local rich info that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LocalRichInfo updateLocalRichInfo(LocalRichInfo localRichInfo);
}