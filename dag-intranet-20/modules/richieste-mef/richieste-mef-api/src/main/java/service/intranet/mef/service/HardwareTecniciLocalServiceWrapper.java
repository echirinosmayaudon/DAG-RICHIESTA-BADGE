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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HardwareTecniciLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HardwareTecniciLocalService
 * @generated
 */
@ProviderType
public class HardwareTecniciLocalServiceWrapper
	implements HardwareTecniciLocalService,
		ServiceWrapper<HardwareTecniciLocalService> {
	public HardwareTecniciLocalServiceWrapper(
		HardwareTecniciLocalService hardwareTecniciLocalService) {
		_hardwareTecniciLocalService = hardwareTecniciLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _hardwareTecniciLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hardwareTecniciLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _hardwareTecniciLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hardwareTecniciLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _hardwareTecniciLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of hardware tecnicis.
	*
	* @return the number of hardware tecnicis
	*/
	@Override
	public int getHardwareTecnicisCount() {
		return _hardwareTecniciLocalService.getHardwareTecnicisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _hardwareTecniciLocalService.getOSGiServiceIdentifier();
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
		return _hardwareTecniciLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.HardwareTecniciModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _hardwareTecniciLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.HardwareTecniciModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _hardwareTecniciLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the hardware tecnicis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.HardwareTecniciModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hardware tecnicis
	* @param end the upper bound of the range of hardware tecnicis (not inclusive)
	* @return the range of hardware tecnicis
	*/
	@Override
	public java.util.List<service.intranet.mef.model.HardwareTecnici> getHardwareTecnicis(
		int start, int end) {
		return _hardwareTecniciLocalService.getHardwareTecnicis(start, end);
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
		return _hardwareTecniciLocalService.dynamicQueryCount(dynamicQuery);
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
		return _hardwareTecniciLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the hardware tecnici to the database. Also notifies the appropriate model listeners.
	*
	* @param hardwareTecnici the hardware tecnici
	* @return the hardware tecnici that was added
	*/
	@Override
	public service.intranet.mef.model.HardwareTecnici addHardwareTecnici(
		service.intranet.mef.model.HardwareTecnici hardwareTecnici) {
		return _hardwareTecniciLocalService.addHardwareTecnici(hardwareTecnici);
	}

	/**
	* Creates a new hardware tecnici with the primary key. Does not add the hardware tecnici to the database.
	*
	* @param id the primary key for the new hardware tecnici
	* @return the new hardware tecnici
	*/
	@Override
	public service.intranet.mef.model.HardwareTecnici createHardwareTecnici(
		long id) {
		return _hardwareTecniciLocalService.createHardwareTecnici(id);
	}

	/**
	* Deletes the hardware tecnici with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the hardware tecnici
	* @return the hardware tecnici that was removed
	* @throws PortalException if a hardware tecnici with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.HardwareTecnici deleteHardwareTecnici(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _hardwareTecniciLocalService.deleteHardwareTecnici(id);
	}

	/**
	* Deletes the hardware tecnici from the database. Also notifies the appropriate model listeners.
	*
	* @param hardwareTecnici the hardware tecnici
	* @return the hardware tecnici that was removed
	*/
	@Override
	public service.intranet.mef.model.HardwareTecnici deleteHardwareTecnici(
		service.intranet.mef.model.HardwareTecnici hardwareTecnici) {
		return _hardwareTecniciLocalService.deleteHardwareTecnici(hardwareTecnici);
	}

	@Override
	public service.intranet.mef.model.HardwareTecnici fetchHardwareTecnici(
		long id) {
		return _hardwareTecniciLocalService.fetchHardwareTecnici(id);
	}

	/**
	* Returns the hardware tecnici with the primary key.
	*
	* @param id the primary key of the hardware tecnici
	* @return the hardware tecnici
	* @throws PortalException if a hardware tecnici with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.HardwareTecnici getHardwareTecnici(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _hardwareTecniciLocalService.getHardwareTecnici(id);
	}

	/**
	* Updates the hardware tecnici in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param hardwareTecnici the hardware tecnici
	* @return the hardware tecnici that was updated
	*/
	@Override
	public service.intranet.mef.model.HardwareTecnici updateHardwareTecnici(
		service.intranet.mef.model.HardwareTecnici hardwareTecnici) {
		return _hardwareTecniciLocalService.updateHardwareTecnici(hardwareTecnici);
	}

	@Override
	public HardwareTecniciLocalService getWrappedService() {
		return _hardwareTecniciLocalService;
	}

	@Override
	public void setWrappedService(
		HardwareTecniciLocalService hardwareTecniciLocalService) {
		_hardwareTecniciLocalService = hardwareTecniciLocalService;
	}

	private HardwareTecniciLocalService _hardwareTecniciLocalService;
}