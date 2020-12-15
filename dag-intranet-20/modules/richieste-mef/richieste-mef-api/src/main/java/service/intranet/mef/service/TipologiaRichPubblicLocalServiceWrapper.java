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
 * Provides a wrapper for {@link TipologiaRichPubblicLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaRichPubblicLocalService
 * @generated
 */
@ProviderType
public class TipologiaRichPubblicLocalServiceWrapper
	implements TipologiaRichPubblicLocalService,
		ServiceWrapper<TipologiaRichPubblicLocalService> {
	public TipologiaRichPubblicLocalServiceWrapper(
		TipologiaRichPubblicLocalService tipologiaRichPubblicLocalService) {
		_tipologiaRichPubblicLocalService = tipologiaRichPubblicLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _tipologiaRichPubblicLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipologiaRichPubblicLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _tipologiaRichPubblicLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaRichPubblicLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaRichPubblicLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of tipologia rich pubblics.
	*
	* @return the number of tipologia rich pubblics
	*/
	@Override
	public int getTipologiaRichPubblicsCount() {
		return _tipologiaRichPubblicLocalService.getTipologiaRichPubblicsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _tipologiaRichPubblicLocalService.getOSGiServiceIdentifier();
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
		return _tipologiaRichPubblicLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipologiaRichPubblicLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tipologiaRichPubblicLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the tipologia rich pubblics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaRichPubblicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia rich pubblics
	* @param end the upper bound of the range of tipologia rich pubblics (not inclusive)
	* @return the range of tipologia rich pubblics
	*/
	@Override
	public java.util.List<service.intranet.mef.model.TipologiaRichPubblic> getTipologiaRichPubblics(
		int start, int end) {
		return _tipologiaRichPubblicLocalService.getTipologiaRichPubblics(start,
			end);
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
		return _tipologiaRichPubblicLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tipologiaRichPubblicLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the tipologia rich pubblic to the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaRichPubblic the tipologia rich pubblic
	* @return the tipologia rich pubblic that was added
	*/
	@Override
	public service.intranet.mef.model.TipologiaRichPubblic addTipologiaRichPubblic(
		service.intranet.mef.model.TipologiaRichPubblic tipologiaRichPubblic) {
		return _tipologiaRichPubblicLocalService.addTipologiaRichPubblic(tipologiaRichPubblic);
	}

	/**
	* Creates a new tipologia rich pubblic with the primary key. Does not add the tipologia rich pubblic to the database.
	*
	* @param id the primary key for the new tipologia rich pubblic
	* @return the new tipologia rich pubblic
	*/
	@Override
	public service.intranet.mef.model.TipologiaRichPubblic createTipologiaRichPubblic(
		long id) {
		return _tipologiaRichPubblicLocalService.createTipologiaRichPubblic(id);
	}

	/**
	* Deletes the tipologia rich pubblic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tipologia rich pubblic
	* @return the tipologia rich pubblic that was removed
	* @throws PortalException if a tipologia rich pubblic with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.TipologiaRichPubblic deleteTipologiaRichPubblic(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaRichPubblicLocalService.deleteTipologiaRichPubblic(id);
	}

	/**
	* Deletes the tipologia rich pubblic from the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaRichPubblic the tipologia rich pubblic
	* @return the tipologia rich pubblic that was removed
	*/
	@Override
	public service.intranet.mef.model.TipologiaRichPubblic deleteTipologiaRichPubblic(
		service.intranet.mef.model.TipologiaRichPubblic tipologiaRichPubblic) {
		return _tipologiaRichPubblicLocalService.deleteTipologiaRichPubblic(tipologiaRichPubblic);
	}

	@Override
	public service.intranet.mef.model.TipologiaRichPubblic fetchTipologiaRichPubblic(
		long id) {
		return _tipologiaRichPubblicLocalService.fetchTipologiaRichPubblic(id);
	}

	/**
	* Returns the tipologia rich pubblic with the primary key.
	*
	* @param id the primary key of the tipologia rich pubblic
	* @return the tipologia rich pubblic
	* @throws PortalException if a tipologia rich pubblic with the primary key could not be found
	*/
	@Override
	public service.intranet.mef.model.TipologiaRichPubblic getTipologiaRichPubblic(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return _tipologiaRichPubblicLocalService.getTipologiaRichPubblic(id);
	}

	/**
	* Updates the tipologia rich pubblic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipologiaRichPubblic the tipologia rich pubblic
	* @return the tipologia rich pubblic that was updated
	*/
	@Override
	public service.intranet.mef.model.TipologiaRichPubblic updateTipologiaRichPubblic(
		service.intranet.mef.model.TipologiaRichPubblic tipologiaRichPubblic) {
		return _tipologiaRichPubblicLocalService.updateTipologiaRichPubblic(tipologiaRichPubblic);
	}

	@Override
	public TipologiaRichPubblicLocalService getWrappedService() {
		return _tipologiaRichPubblicLocalService;
	}

	@Override
	public void setWrappedService(
		TipologiaRichPubblicLocalService tipologiaRichPubblicLocalService) {
		_tipologiaRichPubblicLocalService = tipologiaRichPubblicLocalService;
	}

	private TipologiaRichPubblicLocalService _tipologiaRichPubblicLocalService;
}