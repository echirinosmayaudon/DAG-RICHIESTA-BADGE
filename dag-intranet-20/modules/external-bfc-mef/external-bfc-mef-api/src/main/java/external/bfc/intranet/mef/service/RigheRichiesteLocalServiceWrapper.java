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

package external.bfc.intranet.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RigheRichiesteLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteLocalService
 * @generated
 */
@ProviderType
public class RigheRichiesteLocalServiceWrapper
	implements RigheRichiesteLocalService,
		ServiceWrapper<RigheRichiesteLocalService> {
	public RigheRichiesteLocalServiceWrapper(
		RigheRichiesteLocalService righeRichiesteLocalService) {
		_righeRichiesteLocalService = righeRichiesteLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _righeRichiesteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _righeRichiesteLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _righeRichiesteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the righe richieste to the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichieste the righe richieste
	* @return the righe richieste that was added
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichieste addRigheRichieste(
		external.bfc.intranet.mef.model.RigheRichieste righeRichieste) {
		return _righeRichiesteLocalService.addRigheRichieste(righeRichieste);
	}

	/**
	* Creates a new righe richieste with the primary key. Does not add the righe richieste to the database.
	*
	* @param righeRichiestePK the primary key for the new righe richieste
	* @return the new righe richieste
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichieste createRigheRichieste(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK) {
		return _righeRichiesteLocalService.createRigheRichieste(righeRichiestePK);
	}

	/**
	* Deletes the righe richieste from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichieste the righe richieste
	* @return the righe richieste that was removed
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichieste deleteRigheRichieste(
		external.bfc.intranet.mef.model.RigheRichieste righeRichieste) {
		return _righeRichiesteLocalService.deleteRigheRichieste(righeRichieste);
	}

	/**
	* Deletes the righe richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste that was removed
	* @throws PortalException if a righe richieste with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichieste deleteRigheRichieste(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteLocalService.deleteRigheRichieste(righeRichiestePK);
	}

	@Override
	public external.bfc.intranet.mef.model.RigheRichieste fetchRigheRichieste(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK) {
		return _righeRichiesteLocalService.fetchRigheRichieste(righeRichiestePK);
	}

	/**
	* Returns the righe richieste with the primary key.
	*
	* @param righeRichiestePK the primary key of the righe richieste
	* @return the righe richieste
	* @throws PortalException if a righe richieste with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichieste getRigheRichieste(
		external.bfc.intranet.mef.service.persistence.RigheRichiestePK righeRichiestePK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteLocalService.getRigheRichieste(righeRichiestePK);
	}

	/**
	* Updates the righe richieste in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param righeRichieste the righe richieste
	* @return the righe richieste that was updated
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichieste updateRigheRichieste(
		external.bfc.intranet.mef.model.RigheRichieste righeRichieste) {
		return _righeRichiesteLocalService.updateRigheRichieste(righeRichieste);
	}

	/**
	* Returns the number of righe richiestes.
	*
	* @return the number of righe richiestes
	*/
	@Override
	public int getRigheRichiestesCount() {
		return _righeRichiesteLocalService.getRigheRichiestesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _righeRichiesteLocalService.getOSGiServiceIdentifier();
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
		return _righeRichiesteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _righeRichiesteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _righeRichiesteLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the righe richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RigheRichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richiestes
	* @param end the upper bound of the range of righe richiestes (not inclusive)
	* @return the range of righe richiestes
	*/
	@Override
	public java.util.List<external.bfc.intranet.mef.model.RigheRichieste> getRigheRichiestes(
		int start, int end) {
		return _righeRichiesteLocalService.getRigheRichiestes(start, end);
	}

	@Override
	public java.util.List<external.bfc.intranet.mef.model.RigheRichieste> getrichiesteId(
		long id) {
		return _righeRichiesteLocalService.getrichiesteId(id);
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
		return _righeRichiesteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _righeRichiesteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public RigheRichiesteLocalService getWrappedService() {
		return _righeRichiesteLocalService;
	}

	@Override
	public void setWrappedService(
		RigheRichiesteLocalService righeRichiesteLocalService) {
		_righeRichiesteLocalService = righeRichiesteLocalService;
	}

	private RigheRichiesteLocalService _righeRichiesteLocalService;
}