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
 * Provides a wrapper for {@link RigheRichiesteInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RigheRichiesteInfoLocalService
 * @generated
 */
@ProviderType
public class RigheRichiesteInfoLocalServiceWrapper
	implements RigheRichiesteInfoLocalService,
		ServiceWrapper<RigheRichiesteInfoLocalService> {
	public RigheRichiesteInfoLocalServiceWrapper(
		RigheRichiesteInfoLocalService righeRichiesteInfoLocalService) {
		_righeRichiesteInfoLocalService = righeRichiesteInfoLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _righeRichiesteInfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _righeRichiesteInfoLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _righeRichiesteInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteInfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the righe richieste info to the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiesteInfo the righe richieste info
	* @return the righe richieste info that was added
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo addRigheRichiesteInfo(
		external.bfc.intranet.mef.model.RigheRichiesteInfo righeRichiesteInfo) {
		return _righeRichiesteInfoLocalService.addRigheRichiesteInfo(righeRichiesteInfo);
	}

	/**
	* Creates a new righe richieste info with the primary key. Does not add the righe richieste info to the database.
	*
	* @param righeRichiesteInfoPK the primary key for the new righe richieste info
	* @return the new righe richieste info
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo createRigheRichiesteInfo(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK) {
		return _righeRichiesteInfoLocalService.createRigheRichiesteInfo(righeRichiesteInfoPK);
	}

	/**
	* Deletes the righe richieste info from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiesteInfo the righe richieste info
	* @return the righe richieste info that was removed
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo deleteRigheRichiesteInfo(
		external.bfc.intranet.mef.model.RigheRichiesteInfo righeRichiesteInfo) {
		return _righeRichiesteInfoLocalService.deleteRigheRichiesteInfo(righeRichiesteInfo);
	}

	/**
	* Deletes the righe richieste info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info that was removed
	* @throws PortalException if a righe richieste info with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo deleteRigheRichiesteInfo(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteInfoLocalService.deleteRigheRichiesteInfo(righeRichiesteInfoPK);
	}

	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo fetchRigheRichiesteInfo(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK) {
		return _righeRichiesteInfoLocalService.fetchRigheRichiesteInfo(righeRichiesteInfoPK);
	}

	/**
	* Returns the righe richieste info with the primary key.
	*
	* @param righeRichiesteInfoPK the primary key of the righe richieste info
	* @return the righe richieste info
	* @throws PortalException if a righe richieste info with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo getRigheRichiesteInfo(
		external.bfc.intranet.mef.service.persistence.RigheRichiesteInfoPK righeRichiesteInfoPK)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _righeRichiesteInfoLocalService.getRigheRichiesteInfo(righeRichiesteInfoPK);
	}

	/**
	* Updates the righe richieste info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param righeRichiesteInfo the righe richieste info
	* @return the righe richieste info that was updated
	*/
	@Override
	public external.bfc.intranet.mef.model.RigheRichiesteInfo updateRigheRichiesteInfo(
		external.bfc.intranet.mef.model.RigheRichiesteInfo righeRichiesteInfo) {
		return _righeRichiesteInfoLocalService.updateRigheRichiesteInfo(righeRichiesteInfo);
	}

	/**
	* Returns the number of righe richieste infos.
	*
	* @return the number of righe richieste infos
	*/
	@Override
	public int getRigheRichiesteInfosCount() {
		return _righeRichiesteInfoLocalService.getRigheRichiesteInfosCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _righeRichiesteInfoLocalService.getOSGiServiceIdentifier();
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
		return _righeRichiesteInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _righeRichiesteInfoLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _righeRichiesteInfoLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the righe richieste infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RigheRichiesteInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe richieste infos
	* @param end the upper bound of the range of righe richieste infos (not inclusive)
	* @return the range of righe richieste infos
	*/
	@Override
	public java.util.List<external.bfc.intranet.mef.model.RigheRichiesteInfo> getRigheRichiesteInfos(
		int start, int end) {
		return _righeRichiesteInfoLocalService.getRigheRichiesteInfos(start, end);
	}

	@Override
	public java.util.List<external.bfc.intranet.mef.model.RigheRichiesteInfo> getrichiesteInfoId(
		long id) {
		return _righeRichiesteInfoLocalService.getrichiesteInfoId(id);
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
		return _righeRichiesteInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _righeRichiesteInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public RigheRichiesteInfoLocalService getWrappedService() {
		return _righeRichiesteInfoLocalService;
	}

	@Override
	public void setWrappedService(
		RigheRichiesteInfoLocalService righeRichiesteInfoLocalService) {
		_righeRichiesteInfoLocalService = righeRichiesteInfoLocalService;
	}

	private RigheRichiesteInfoLocalService _righeRichiesteInfoLocalService;
}