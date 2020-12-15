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

package servizio.beni.facile.consumo.service;

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

import servizio.beni.facile.consumo.model.RigheRichiestaBFC;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for RigheRichiestaBFC. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiestaBFCLocalServiceUtil
 * @see servizio.beni.facile.consumo.service.base.RigheRichiestaBFCLocalServiceBaseImpl
 * @see servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RigheRichiestaBFCLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RigheRichiestaBFCLocalServiceUtil} to access the righe richiesta b f c local service. Add custom service methods to {@link servizio.beni.facile.consumo.service.impl.RigheRichiestaBFCLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	* Returns the number of righe richiesta b f cs.
	*
	* @return the number of righe richiesta b f cs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRigheRichiestaBFCsCount();

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<RigheRichiestaBFC> getRigaRichiestaByIdRichiesta(
		long id_richiesta);

	/**
	* Returns a range of all the righe richiesta b f cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.RigheRichiestaBFCModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiesta b f cs
	* @param end the upper bound of the range of righe richiesta b f cs (not inclusive)
	* @return the range of righe richiesta b f cs
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RigheRichiestaBFC> getRigheRichiestaBFCs(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RigheRichiestaBFC> getRigheRichiestaByDipartimento(
		java.lang.String dipartimento);

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
	* Adds the righe richiesta b f c to the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	* @return the righe richiesta b f c that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RigheRichiestaBFC addRigheRichiestaBFC(
		RigheRichiestaBFC righeRichiestaBFC);

	/**
	* Creates a new righe richiesta b f c with the primary key. Does not add the righe richiesta b f c to the database.
	*
	* @param id the primary key for the new righe richiesta b f c
	* @return the new righe richiesta b f c
	*/
	public RigheRichiestaBFC createRigheRichiestaBFC(long id);

	/**
	* Deletes the righe richiesta b f c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c that was removed
	* @throws PortalException if a righe richiesta b f c with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public RigheRichiestaBFC deleteRigheRichiestaBFC(long id)
		throws PortalException;

	/**
	* Deletes the righe richiesta b f c from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	* @return the righe richiesta b f c that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public RigheRichiestaBFC deleteRigheRichiestaBFC(
		RigheRichiestaBFC righeRichiestaBFC);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RigheRichiestaBFC fetchRigheRichiestaBFC(long id);

	/**
	* Returns the righe richiesta b f c with the primary key.
	*
	* @param id the primary key of the righe richiesta b f c
	* @return the righe richiesta b f c
	* @throws PortalException if a righe richiesta b f c with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RigheRichiestaBFC getRigheRichiestaBFC(long id)
		throws PortalException;

	/**
	* Updates the righe richiesta b f c in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestaBFC the righe richiesta b f c
	* @return the righe richiesta b f c that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public RigheRichiestaBFC updateRigheRichiestaBFC(
		RigheRichiestaBFC righeRichiestaBFC);
}