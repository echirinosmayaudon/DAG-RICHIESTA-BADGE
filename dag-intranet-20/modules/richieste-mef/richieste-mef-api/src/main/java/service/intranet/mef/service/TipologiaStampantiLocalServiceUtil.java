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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TipologiaStampanti. This utility wraps
 * {@link service.intranet.mef.service.impl.TipologiaStampantiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TipologiaStampantiLocalService
 * @see service.intranet.mef.service.base.TipologiaStampantiLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.TipologiaStampantiLocalServiceImpl
 * @generated
 */
@ProviderType
public class TipologiaStampantiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.TipologiaStampantiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of tipologia stampantis.
	*
	* @return the number of tipologia stampantis
	*/
	public static int getTipologiaStampantisCount() {
		return getService().getTipologiaStampantisCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the tipologia stampantis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.TipologiaStampantiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tipologia stampantis
	* @param end the upper bound of the range of tipologia stampantis (not inclusive)
	* @return the range of tipologia stampantis
	*/
	public static java.util.List<service.intranet.mef.model.TipologiaStampanti> getTipologiaStampantis(
		int start, int end) {
		return getService().getTipologiaStampantis(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the tipologia stampanti to the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaStampanti the tipologia stampanti
	* @return the tipologia stampanti that was added
	*/
	public static service.intranet.mef.model.TipologiaStampanti addTipologiaStampanti(
		service.intranet.mef.model.TipologiaStampanti tipologiaStampanti) {
		return getService().addTipologiaStampanti(tipologiaStampanti);
	}

	/**
	* Creates a new tipologia stampanti with the primary key. Does not add the tipologia stampanti to the database.
	*
	* @param id_tipologia_stampanti the primary key for the new tipologia stampanti
	* @return the new tipologia stampanti
	*/
	public static service.intranet.mef.model.TipologiaStampanti createTipologiaStampanti(
		long id_tipologia_stampanti) {
		return getService().createTipologiaStampanti(id_tipologia_stampanti);
	}

	/**
	* Deletes the tipologia stampanti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti that was removed
	* @throws PortalException if a tipologia stampanti with the primary key could not be found
	*/
	public static service.intranet.mef.model.TipologiaStampanti deleteTipologiaStampanti(
		long id_tipologia_stampanti)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTipologiaStampanti(id_tipologia_stampanti);
	}

	/**
	* Deletes the tipologia stampanti from the database. Also notifies the appropriate model listeners.
	*
	* @param tipologiaStampanti the tipologia stampanti
	* @return the tipologia stampanti that was removed
	*/
	public static service.intranet.mef.model.TipologiaStampanti deleteTipologiaStampanti(
		service.intranet.mef.model.TipologiaStampanti tipologiaStampanti) {
		return getService().deleteTipologiaStampanti(tipologiaStampanti);
	}

	public static service.intranet.mef.model.TipologiaStampanti fetchTipologiaStampanti(
		long id_tipologia_stampanti) {
		return getService().fetchTipologiaStampanti(id_tipologia_stampanti);
	}

	/**
	* Returns the tipologia stampanti with the primary key.
	*
	* @param id_tipologia_stampanti the primary key of the tipologia stampanti
	* @return the tipologia stampanti
	* @throws PortalException if a tipologia stampanti with the primary key could not be found
	*/
	public static service.intranet.mef.model.TipologiaStampanti getTipologiaStampanti(
		long id_tipologia_stampanti)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTipologiaStampanti(id_tipologia_stampanti);
	}

	/**
	* Updates the tipologia stampanti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipologiaStampanti the tipologia stampanti
	* @return the tipologia stampanti that was updated
	*/
	public static service.intranet.mef.model.TipologiaStampanti updateTipologiaStampanti(
		service.intranet.mef.model.TipologiaStampanti tipologiaStampanti) {
		return getService().updateTipologiaStampanti(tipologiaStampanti);
	}

	public static TipologiaStampantiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TipologiaStampantiLocalService, TipologiaStampantiLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TipologiaStampantiLocalService.class);
}