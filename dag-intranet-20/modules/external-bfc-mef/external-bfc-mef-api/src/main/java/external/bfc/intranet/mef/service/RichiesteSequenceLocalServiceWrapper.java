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
 * Provides a wrapper for {@link RichiesteSequenceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RichiesteSequenceLocalService
 * @generated
 */
@ProviderType
public class RichiesteSequenceLocalServiceWrapper
	implements RichiesteSequenceLocalService,
		ServiceWrapper<RichiesteSequenceLocalService> {
	public RichiesteSequenceLocalServiceWrapper(
		RichiesteSequenceLocalService richiesteSequenceLocalService) {
		_richiesteSequenceLocalService = richiesteSequenceLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _richiesteSequenceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _richiesteSequenceLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _richiesteSequenceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteSequenceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteSequenceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the richieste sequence to the database. Also notifies the appropriate model listeners.
	*
	* @param richiesteSequence the richieste sequence
	* @return the richieste sequence that was added
	*/
	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence addRichiesteSequence(
		external.bfc.intranet.mef.model.RichiesteSequence richiesteSequence) {
		return _richiesteSequenceLocalService.addRichiesteSequence(richiesteSequence);
	}

	/**
	* Creates a new richieste sequence with the primary key. Does not add the richieste sequence to the database.
	*
	* @param idSeq the primary key for the new richieste sequence
	* @return the new richieste sequence
	*/
	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence createRichiesteSequence(
		long idSeq) {
		return _richiesteSequenceLocalService.createRichiesteSequence(idSeq);
	}

	/**
	* Deletes the richieste sequence from the database. Also notifies the appropriate model listeners.
	*
	* @param richiesteSequence the richieste sequence
	* @return the richieste sequence that was removed
	*/
	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence deleteRichiesteSequence(
		external.bfc.intranet.mef.model.RichiesteSequence richiesteSequence) {
		return _richiesteSequenceLocalService.deleteRichiesteSequence(richiesteSequence);
	}

	/**
	* Deletes the richieste sequence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence that was removed
	* @throws PortalException if a richieste sequence with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence deleteRichiesteSequence(
		long idSeq) throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteSequenceLocalService.deleteRichiesteSequence(idSeq);
	}

	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence fetchRichiesteSequence(
		long idSeq) {
		return _richiesteSequenceLocalService.fetchRichiesteSequence(idSeq);
	}

	/**
	* Returns the richieste sequence with the primary key.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence
	* @throws PortalException if a richieste sequence with the primary key could not be found
	*/
	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence getRichiesteSequence(
		long idSeq) throws com.liferay.portal.kernel.exception.PortalException {
		return _richiesteSequenceLocalService.getRichiesteSequence(idSeq);
	}

	/**
	* Updates the richieste sequence in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param richiesteSequence the richieste sequence
	* @return the richieste sequence that was updated
	*/
	@Override
	public external.bfc.intranet.mef.model.RichiesteSequence updateRichiesteSequence(
		external.bfc.intranet.mef.model.RichiesteSequence richiesteSequence) {
		return _richiesteSequenceLocalService.updateRichiesteSequence(richiesteSequence);
	}

	/**
	* Returns the number of richieste sequences.
	*
	* @return the number of richieste sequences
	*/
	@Override
	public int getRichiesteSequencesCount() {
		return _richiesteSequenceLocalService.getRichiesteSequencesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _richiesteSequenceLocalService.getOSGiServiceIdentifier();
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
		return _richiesteSequenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _richiesteSequenceLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _richiesteSequenceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link external.bfc.intranet.mef.model.impl.RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @return the range of richieste sequences
	*/
	@Override
	public java.util.List<external.bfc.intranet.mef.model.RichiesteSequence> getRichiesteSequences(
		int start, int end) {
		return _richiesteSequenceLocalService.getRichiesteSequences(start, end);
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
		return _richiesteSequenceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _richiesteSequenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public RichiesteSequenceLocalService getWrappedService() {
		return _richiesteSequenceLocalService;
	}

	@Override
	public void setWrappedService(
		RichiesteSequenceLocalService richiesteSequenceLocalService) {
		_richiesteSequenceLocalService = richiesteSequenceLocalService;
	}

	private RichiesteSequenceLocalService _richiesteSequenceLocalService;
}