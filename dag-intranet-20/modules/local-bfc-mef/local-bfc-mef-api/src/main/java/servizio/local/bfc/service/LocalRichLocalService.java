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

import servizio.local.bfc.model.LocalRich;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for LocalRich. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LocalRichLocalServiceUtil
 * @see servizio.local.bfc.service.base.LocalRichLocalServiceBaseImpl
 * @see servizio.local.bfc.service.impl.LocalRichLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LocalRichLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LocalRichLocalServiceUtil} to access the local rich local service. Add custom service methods to {@link servizio.local.bfc.service.impl.LocalRichLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Returns the number of local richs.
	*
	* @return the number of local richs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLocalRichsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public List<LocalRich> findByfilters(List<java.lang.Long> lista_stati,
		List<java.lang.String> ufficio, List<User> lista_utenti, boolean instage);

	/**
	* Returns a range of all the local richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.local.bfc.model.impl.LocalRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of local richs
	* @param end the upper bound of the range of local richs (not inclusive)
	* @return the range of local richs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LocalRich> getLocalRichs(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LocalRich> getRichiestebyEmail(boolean instage,
		java.lang.String email);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LocalRich> getRichiestebyIdRichiesta(long id_richiesta);

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
	* Adds the local rich to the database. Also notifies the appropriate model listeners.
	*
	* @param localRich the local rich
	* @return the local rich that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LocalRich addLocalRich(LocalRich localRich);

	/**
	* Creates a new local rich with the primary key. Does not add the local rich to the database.
	*
	* @param id the primary key for the new local rich
	* @return the new local rich
	*/
	public LocalRich createLocalRich(long id);

	/**
	* Deletes the local rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the local rich
	* @return the local rich that was removed
	* @throws PortalException if a local rich with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public LocalRich deleteLocalRich(long id) throws PortalException;

	/**
	* Deletes the local rich from the database. Also notifies the appropriate model listeners.
	*
	* @param localRich the local rich
	* @return the local rich that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public LocalRich deleteLocalRich(LocalRich localRich);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LocalRich fetchLocalRich(long id);

	/**
	* Returns the local rich with the primary key.
	*
	* @param id the primary key of the local rich
	* @return the local rich
	* @throws PortalException if a local rich with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LocalRich getLocalRich(long id) throws PortalException;

	public LocalRich insertLocalRich(java.lang.Long id_richiesta,
		java.lang.Float costoReale, Date dataIns, Date dataRichiesta,
		Date dataUpd, java.lang.String email, java.lang.Integer flagInvio,
		java.lang.Long idPeriodicita, java.lang.String idSede,
		java.lang.Long idStatoAttuale, java.lang.String ispettorato,
		java.lang.String note, java.lang.String noteRichiedente,
		java.lang.String oggetto, java.lang.Integer preventivo,
		java.lang.String riferimentoStanza, java.lang.String strutIsp,
		java.lang.String strutIsp2, java.lang.String strutUff,
		java.lang.String telRichiedente, java.lang.String ufficio,
		java.lang.Long uidIns, java.lang.Long uidUpd, boolean inStage);

	/**
	* Updates the local rich in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param localRich the local rich
	* @return the local rich that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LocalRich updateLocalRich(LocalRich localRich);
}