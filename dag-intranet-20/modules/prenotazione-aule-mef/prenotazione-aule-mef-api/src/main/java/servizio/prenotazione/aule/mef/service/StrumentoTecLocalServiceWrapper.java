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

package servizio.prenotazione.aule.mef.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrumentoTecLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTecLocalService
 * @generated
 */
@ProviderType
public class StrumentoTecLocalServiceWrapper implements StrumentoTecLocalService,
	ServiceWrapper<StrumentoTecLocalService> {
	public StrumentoTecLocalServiceWrapper(
		StrumentoTecLocalService strumentoTecLocalService) {
		_strumentoTecLocalService = strumentoTecLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _strumentoTecLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _strumentoTecLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _strumentoTecLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoTecLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoTecLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of strumento tecs.
	*
	* @return the number of strumento tecs
	*/
	@Override
	public int getStrumentoTecsCount() {
		return _strumentoTecLocalService.getStrumentoTecsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _strumentoTecLocalService.getOSGiServiceIdentifier();
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
		return _strumentoTecLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _strumentoTecLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _strumentoTecLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StrumentoTec> getStrumentoTecListByDescStrumento(
		java.lang.String desc_strumento) {
		return _strumentoTecLocalService.getStrumentoTecListByDescStrumento(desc_strumento);
	}

	/**
	* Returns a range of all the strumento tecs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of strumento tecs
	* @param end the upper bound of the range of strumento tecs (not inclusive)
	* @return the range of strumento tecs
	*/
	@Override
	public java.util.List<servizio.prenotazione.aule.mef.model.StrumentoTec> getStrumentoTecs(
		int start, int end) {
		return _strumentoTecLocalService.getStrumentoTecs(start, end);
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
		return _strumentoTecLocalService.dynamicQueryCount(dynamicQuery);
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
		return _strumentoTecLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the strumento tec to the database. Also notifies the appropriate model listeners.
	*
	* @param strumentoTec the strumento tec
	* @return the strumento tec that was added
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec addStrumentoTec(
		servizio.prenotazione.aule.mef.model.StrumentoTec strumentoTec) {
		return _strumentoTecLocalService.addStrumentoTec(strumentoTec);
	}

	/**
	* Creates a new strumento tec with the primary key. Does not add the strumento tec to the database.
	*
	* @param id_strumento the primary key for the new strumento tec
	* @return the new strumento tec
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec createStrumentoTec(
		long id_strumento) {
		return _strumentoTecLocalService.createStrumentoTec(id_strumento);
	}

	/**
	* Deletes the strumento tec with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec that was removed
	* @throws PortalException if a strumento tec with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec deleteStrumentoTec(
		long id_strumento)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoTecLocalService.deleteStrumentoTec(id_strumento);
	}

	/**
	* Deletes the strumento tec from the database. Also notifies the appropriate model listeners.
	*
	* @param strumentoTec the strumento tec
	* @return the strumento tec that was removed
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec deleteStrumentoTec(
		servizio.prenotazione.aule.mef.model.StrumentoTec strumentoTec) {
		return _strumentoTecLocalService.deleteStrumentoTec(strumentoTec);
	}

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec fetchStrumentoTec(
		long id_strumento) {
		return _strumentoTecLocalService.fetchStrumentoTec(id_strumento);
	}

	/**
	* Returns the strumento tec with the primary key.
	*
	* @param id_strumento the primary key of the strumento tec
	* @return the strumento tec
	* @throws PortalException if a strumento tec with the primary key could not be found
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec getStrumentoTec(
		long id_strumento)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _strumentoTecLocalService.getStrumentoTec(id_strumento);
	}

	/**
	* Updates the strumento tec in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param strumentoTec the strumento tec
	* @return the strumento tec that was updated
	*/
	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec updateStrumentoTec(
		servizio.prenotazione.aule.mef.model.StrumentoTec strumentoTec) {
		return _strumentoTecLocalService.updateStrumentoTec(strumentoTec);
	}

	@Override
	public StrumentoTecLocalService getWrappedService() {
		return _strumentoTecLocalService;
	}

	@Override
	public void setWrappedService(
		StrumentoTecLocalService strumentoTecLocalService) {
		_strumentoTecLocalService = strumentoTecLocalService;
	}

	private StrumentoTecLocalService _strumentoTecLocalService;
}