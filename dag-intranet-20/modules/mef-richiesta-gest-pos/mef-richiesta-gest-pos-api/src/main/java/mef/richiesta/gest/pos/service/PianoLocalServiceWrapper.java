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

package mef.richiesta.gest.pos.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PianoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PianoLocalService
 * @generated
 */
@ProviderType
public class PianoLocalServiceWrapper
	implements PianoLocalService, ServiceWrapper<PianoLocalService> {

	public PianoLocalServiceWrapper(PianoLocalService pianoLocalService) {
		_pianoLocalService = pianoLocalService;
	}

	/**
	 * Adds the piano to the database. Also notifies the appropriate model listeners.
	 *
	 * @param piano the piano
	 * @return the piano that was added
	 */
	@Override
	public mef.richiesta.gest.pos.model.Piano addPiano(
		mef.richiesta.gest.pos.model.Piano piano) {

		return _pianoLocalService.addPiano(piano);
	}

	/**
	 * Creates a new piano with the primary key. Does not add the piano to the database.
	 *
	 * @param id_pk_piano the primary key for the new piano
	 * @return the new piano
	 */
	@Override
	public mef.richiesta.gest.pos.model.Piano createPiano(long id_pk_piano) {
		return _pianoLocalService.createPiano(id_pk_piano);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pianoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the piano with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_pk_piano the primary key of the piano
	 * @return the piano that was removed
	 * @throws PortalException if a piano with the primary key could not be found
	 */
	@Override
	public mef.richiesta.gest.pos.model.Piano deletePiano(long id_pk_piano)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pianoLocalService.deletePiano(id_pk_piano);
	}

	/**
	 * Deletes the piano from the database. Also notifies the appropriate model listeners.
	 *
	 * @param piano the piano
	 * @return the piano that was removed
	 */
	@Override
	public mef.richiesta.gest.pos.model.Piano deletePiano(
		mef.richiesta.gest.pos.model.Piano piano) {

		return _pianoLocalService.deletePiano(piano);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pianoLocalService.dynamicQuery();
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

		return _pianoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.PianoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _pianoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.PianoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _pianoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
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

		return _pianoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _pianoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public mef.richiesta.gest.pos.model.Piano fetchPiano(long id_pk_piano) {
		return _pianoLocalService.fetchPiano(id_pk_piano);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _pianoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _pianoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _pianoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pianoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the piano with the primary key.
	 *
	 * @param id_pk_piano the primary key of the piano
	 * @return the piano
	 * @throws PortalException if a piano with the primary key could not be found
	 */
	@Override
	public mef.richiesta.gest.pos.model.Piano getPiano(long id_pk_piano)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _pianoLocalService.getPiano(id_pk_piano);
	}

	@Override
	public java.util.List<mef.richiesta.gest.pos.model.Piano> getPianoFromSede(
		long idSede) {

		return _pianoLocalService.getPianoFromSede(idSede);
	}

	/**
	 * Returns a range of all the pianos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>mef.richiesta.gest.pos.model.impl.PianoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pianos
	 * @param end the upper bound of the range of pianos (not inclusive)
	 * @return the range of pianos
	 */
	@Override
	public java.util.List<mef.richiesta.gest.pos.model.Piano> getPianos(
		int start, int end) {

		return _pianoLocalService.getPianos(start, end);
	}

	/**
	 * Returns the number of pianos.
	 *
	 * @return the number of pianos
	 */
	@Override
	public int getPianosCount() {
		return _pianoLocalService.getPianosCount();
	}

	/**
	 * Updates the piano in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param piano the piano
	 * @return the piano that was updated
	 */
	@Override
	public mef.richiesta.gest.pos.model.Piano updatePiano(
		mef.richiesta.gest.pos.model.Piano piano) {

		return _pianoLocalService.updatePiano(piano);
	}

	@Override
	public PianoLocalService getWrappedService() {
		return _pianoLocalService;
	}

	@Override
	public void setWrappedService(PianoLocalService pianoLocalService) {
		_pianoLocalService = pianoLocalService;
	}

	private PianoLocalService _pianoLocalService;

}