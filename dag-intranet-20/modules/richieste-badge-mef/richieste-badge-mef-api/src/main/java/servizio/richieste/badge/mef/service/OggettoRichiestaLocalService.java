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

package servizio.richieste.badge.mef.service;

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

import servizio.richieste.badge.mef.model.OggettoRichiesta;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for OggettoRichiesta. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OggettoRichiestaLocalServiceUtil
 * @see servizio.richieste.badge.mef.service.base.OggettoRichiestaLocalServiceBaseImpl
 * @see servizio.richieste.badge.mef.service.impl.OggettoRichiestaLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OggettoRichiestaLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OggettoRichiestaLocalServiceUtil} to access the oggetto richiesta local service. Add custom service methods to {@link servizio.richieste.badge.mef.service.impl.OggettoRichiestaLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Returns the number of oggetto richiestas.
	*
	* @return the number of oggetto richiestas
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOggettoRichiestasCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the oggetto richiestas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.richieste.badge.mef.model.impl.OggettoRichiestaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of oggetto richiestas
	* @param end the upper bound of the range of oggetto richiestas (not inclusive)
	* @return the range of oggetto richiestas
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OggettoRichiesta> getOggettoRichiestas(int start, int end);

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
	* Adds the oggetto richiesta to the database. Also notifies the appropriate model listeners.
	*
	* @param oggettoRichiesta the oggetto richiesta
	* @return the oggetto richiesta that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public OggettoRichiesta addOggettoRichiesta(
		OggettoRichiesta oggettoRichiesta);

	/**
	* Creates a new oggetto richiesta with the primary key. Does not add the oggetto richiesta to the database.
	*
	* @param id_oggetto the primary key for the new oggetto richiesta
	* @return the new oggetto richiesta
	*/
	public OggettoRichiesta createOggettoRichiesta(long id_oggetto);

	/**
	* Deletes the oggetto richiesta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta that was removed
	* @throws PortalException if a oggetto richiesta with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public OggettoRichiesta deleteOggettoRichiesta(long id_oggetto)
		throws PortalException;

	/**
	* Deletes the oggetto richiesta from the database. Also notifies the appropriate model listeners.
	*
	* @param oggettoRichiesta the oggetto richiesta
	* @return the oggetto richiesta that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public OggettoRichiesta deleteOggettoRichiesta(
		OggettoRichiesta oggettoRichiesta);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OggettoRichiesta fetchOggettoRichiesta(long id_oggetto);

	/**
	* Returns the oggetto richiesta with the primary key.
	*
	* @param id_oggetto the primary key of the oggetto richiesta
	* @return the oggetto richiesta
	* @throws PortalException if a oggetto richiesta with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OggettoRichiesta getOggettoRichiesta(long id_oggetto)
		throws PortalException;

	/**
	* Updates the oggetto richiesta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param oggettoRichiesta the oggetto richiesta
	* @return the oggetto richiesta that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public OggettoRichiesta updateOggettoRichiesta(
		OggettoRichiesta oggettoRichiesta);
}