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
 * Provides a wrapper for {@link TipologiaComputerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaComputerLocalService
 * @generated
 */
@ProviderType
public class TipologiaComputerLocalServiceWrapper
	implements TipologiaComputerLocalService,
		ServiceWrapper<TipologiaComputerLocalService> {
	public TipologiaComputerLocalServiceWrapper(
		TipologiaComputerLocalService tipologiaComputerLocalService) {
		_tipologiaComputerLocalService = tipologiaComputerLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tipologiaComputerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipologiaComputerLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tipologiaComputerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaComputerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaComputerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of tipologia computers.
	*
	* @return the number of tipologia computers
	*/
	@Override
	public int getTipologiaComputersCount() {
		return _tipologiaComputerLocalService.getTipologiaComputersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipologiaComputerLocalService.getOSGiServiceIdentifier();
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
		return _tipologiaComputerLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _tipologiaComputerLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _tipologiaComputerLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

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
	@Override
	public java.util.List<service.intranet.mef.model.TipologiaComputer> getTipologiaComputers(
		int start, int end) {
		return _tipologiaComputerLocalService.getTipologiaComputers(start, end);
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
		return _tipologiaComputerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipologiaComputerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the tipologia computer to the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaComputer the tipologia computer
	* @return the tipologia computer that was added
	*/
	@Override
	public service.intranet.mef.model.TipologiaComputer addTipologiaComputer(
		service.intranet.mef.model.TipologiaComputer tipologiaComputer) {
		return _tipologiaComputerLocalService.addTipologiaComputer(tipologiaComputer);
	}

	/**
	* Creates a new tipologia computer with the primary key. Does not add the tipologia computer to the database.
	*
	* @param id_tipologia_computer the primary key for the new tipologia computer
	* @return the new tipologia computer
	*/
	@Override
	public service.intranet.mef.model.TipologiaComputer createTipologiaComputer(
		long id_tipologia_computer) {
		return _tipologiaComputerLocalService.createTipologiaComputer(id_tipologia_computer);
	}

	/**
	* Deletes the tipologia computer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer that was removed
	* @throws PortalException if a tipologia computer with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.TipologiaComputer deleteTipologiaComputer(
		long id_tipologia_computer)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaComputerLocalService.deleteTipologiaComputer(id_tipologia_computer);
	}

	/**
	* Deletes the tipologia computer from the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaComputer the tipologia computer
	* @return the tipologia computer that was removed
	*/
	@Override
	public service.intranet.mef.model.TipologiaComputer deleteTipologiaComputer(
		service.intranet.mef.model.TipologiaComputer tipologiaComputer) {
		return _tipologiaComputerLocalService.deleteTipologiaComputer(tipologiaComputer);
	}

	@Override
	public service.intranet.mef.model.TipologiaComputer fetchTipologiaComputer(
		long id_tipologia_computer) {
		return _tipologiaComputerLocalService.fetchTipologiaComputer(id_tipologia_computer);
	}

	/**
	* Returns the tipologia computer with the primary key.
	*
	* @param id_tipologia_computer the primary key of the tipologia computer
	* @return the tipologia computer
	* @throws PortalException if a tipologia computer with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.TipologiaComputer getTipologiaComputer(
		long id_tipologia_computer)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaComputerLocalService.getTipologiaComputer(id_tipologia_computer);
	}

	/**
	* Updates the tipologia computer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipologiaComputer the tipologia computer
	* @return the tipologia computer that was updated
	*/
	@Override
	public service.intranet.mef.model.TipologiaComputer updateTipologiaComputer(
		service.intranet.mef.model.TipologiaComputer tipologiaComputer) {
		return _tipologiaComputerLocalService.updateTipologiaComputer(tipologiaComputer);
	}

	@Override
	public TipologiaComputerLocalService getWrappedService() {
		return _tipologiaComputerLocalService;
	}

	@Override
	public void setWrappedService(
		TipologiaComputerLocalService tipologiaComputerLocalService) {
		_tipologiaComputerLocalService = tipologiaComputerLocalService;
	}

	private TipologiaComputerLocalService _tipologiaComputerLocalService;
}