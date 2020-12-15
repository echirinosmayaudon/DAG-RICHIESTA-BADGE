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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServizioMaterialeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ServizioMaterialeLocalService
 * @generated
 */
@ProviderType
public class ServizioMaterialeLocalServiceWrapper
	implements ServizioMaterialeLocalService,
		ServiceWrapper<ServizioMaterialeLocalService> {
	public ServizioMaterialeLocalServiceWrapper(
		ServizioMaterialeLocalService servizioMaterialeLocalService) {
		_servizioMaterialeLocalService = servizioMaterialeLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _servizioMaterialeLocalService.dynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioMaterialeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioMaterialeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of servizio materiales.
	*
	* @return the number of servizio materiales
	*/
	@Override
	public int getServizioMaterialesCount() {
		return _servizioMaterialeLocalService.getServizioMaterialesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _servizioMaterialeLocalService.getOSGiServiceIdentifier();
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
		return _servizioMaterialeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _servizioMaterialeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _servizioMaterialeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	@Override
	public java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getGruppi() {
		return _servizioMaterialeLocalService.getGruppi();
	}

	@Override
	public java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getGruppiByCategoria(
		java.lang.String categoria) {
		return _servizioMaterialeLocalService.getGruppiByCategoria(categoria);
	}

	/**
	* Returns a range of all the servizio materiales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link servizio.beni.facile.consumo.model.impl.ServizioMaterialeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servizio materiales
	* @param end the upper bound of the range of servizio materiales (not inclusive)
	* @return the range of servizio materiales
	*/
	@Override
	public java.util.List<servizio.beni.facile.consumo.model.ServizioMateriale> getServizioMateriales(
		int start, int end) {
		return _servizioMaterialeLocalService.getServizioMateriales(start, end);
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
		return _servizioMaterialeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _servizioMaterialeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Adds the servizio materiale to the database. Also notifies the appropriate model listeners.
	*
	* @param servizioMateriale the servizio materiale
	* @return the servizio materiale that was added
	*/
	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale addServizioMateriale(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return _servizioMaterialeLocalService.addServizioMateriale(servizioMateriale);
	}

	/**
	* Creates a new servizio materiale with the primary key. Does not add the servizio materiale to the database.
	*
	* @param gruppo the primary key for the new servizio materiale
	* @return the new servizio materiale
	*/
	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale createServizioMateriale(
		java.lang.String gruppo) {
		return _servizioMaterialeLocalService.createServizioMateriale(gruppo);
	}

	/**
	* Deletes the servizio materiale with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale that was removed
	* @throws PortalException if a servizio materiale with the primary key could not be found
	*/
	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale deleteServizioMateriale(
		java.lang.String gruppo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioMaterialeLocalService.deleteServizioMateriale(gruppo);
	}

	/**
	* Deletes the servizio materiale from the database. Also notifies the appropriate model listeners.
	*
	* @param servizioMateriale the servizio materiale
	* @return the servizio materiale that was removed
	*/
	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale deleteServizioMateriale(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return _servizioMaterialeLocalService.deleteServizioMateriale(servizioMateriale);
	}

	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale fetchServizioMateriale(
		java.lang.String gruppo) {
		return _servizioMaterialeLocalService.fetchServizioMateriale(gruppo);
	}

	/**
	* Returns the servizio materiale with the primary key.
	*
	* @param gruppo the primary key of the servizio materiale
	* @return the servizio materiale
	* @throws PortalException if a servizio materiale with the primary key could not be found
	*/
	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale getServizioMateriale(
		java.lang.String gruppo)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _servizioMaterialeLocalService.getServizioMateriale(gruppo);
	}

	/**
	* Updates the servizio materiale in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param servizioMateriale the servizio materiale
	* @return the servizio materiale that was updated
	*/
	@Override
	public servizio.beni.facile.consumo.model.ServizioMateriale updateServizioMateriale(
		servizio.beni.facile.consumo.model.ServizioMateriale servizioMateriale) {
		return _servizioMaterialeLocalService.updateServizioMateriale(servizioMateriale);
	}

	@Override
	public ServizioMaterialeLocalService getWrappedService() {
		return _servizioMaterialeLocalService;
	}

	@Override
	public void setWrappedService(
		ServizioMaterialeLocalService servizioMaterialeLocalService) {
		_servizioMaterialeLocalService = servizioMaterialeLocalService;
	}

	private ServizioMaterialeLocalService _servizioMaterialeLocalService;
}