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
 * Provides the local service utility for ModuloTrasporti. This utility wraps
 * {@link service.intranet.mef.service.impl.ModuloTrasportiLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ModuloTrasportiLocalService
 * @see service.intranet.mef.service.base.ModuloTrasportiLocalServiceBaseImpl
 * @see service.intranet.mef.service.impl.ModuloTrasportiLocalServiceImpl
 * @generated
 */
@ProviderType
public class ModuloTrasportiLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link service.intranet.mef.service.impl.ModuloTrasportiLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of modulo trasportis.
	*
	* @return the number of modulo trasportis
	*/
	public static int getModuloTrasportisCount() {
		return getService().getModuloTrasportisCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the modulo trasportis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link service.intranet.mef.model.impl.ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of modulo trasportis
	* @param end the upper bound of the range of modulo trasportis (not inclusive)
	* @return the range of modulo trasportis
	*/
	public static java.util.List<service.intranet.mef.model.ModuloTrasporti> getModuloTrasportis(
		int start, int end) {
		return getService().getModuloTrasportis(start, end);
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
	* Adds the modulo trasporti to the database. Also notifies the appropriate model listeners.
	*
	* @param moduloTrasporti the modulo trasporti
	* @return the modulo trasporti that was added
	*/
	public static service.intranet.mef.model.ModuloTrasporti addModuloTrasporti(
		service.intranet.mef.model.ModuloTrasporti moduloTrasporti) {
		return getService().addModuloTrasporti(moduloTrasporti);
	}

	/**
	* Creates a new modulo trasporti with the primary key. Does not add the modulo trasporti to the database.
	*
	* @param id_modulo_trasporti the primary key for the new modulo trasporti
	* @return the new modulo trasporti
	*/
	public static service.intranet.mef.model.ModuloTrasporti createModuloTrasporti(
		long id_modulo_trasporti) {
		return getService().createModuloTrasporti(id_modulo_trasporti);
	}

	/**
	* Deletes the modulo trasporti with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_modulo_trasporti the primary key of the modulo trasporti
	* @return the modulo trasporti that was removed
	* @throws PortalException if a modulo trasporti with the primary key could not be found
	*/
	public static service.intranet.mef.model.ModuloTrasporti deleteModuloTrasporti(
		long id_modulo_trasporti)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteModuloTrasporti(id_modulo_trasporti);
	}

	/**
	* Deletes the modulo trasporti from the database. Also notifies the appropriate model listeners.
	*
	* @param moduloTrasporti the modulo trasporti
	* @return the modulo trasporti that was removed
	*/
	public static service.intranet.mef.model.ModuloTrasporti deleteModuloTrasporti(
		service.intranet.mef.model.ModuloTrasporti moduloTrasporti) {
		return getService().deleteModuloTrasporti(moduloTrasporti);
	}

	public static service.intranet.mef.model.ModuloTrasporti fetchModuloTrasporti(
		long id_modulo_trasporti) {
		return getService().fetchModuloTrasporti(id_modulo_trasporti);
	}

	/**
	* Returns the modulo trasporti with the primary key.
	*
	* @param id_modulo_trasporti the primary key of the modulo trasporti
	* @return the modulo trasporti
	* @throws PortalException if a modulo trasporti with the primary key could not be found
	*/
	public static service.intranet.mef.model.ModuloTrasporti getModuloTrasporti(
		long id_modulo_trasporti)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getModuloTrasporti(id_modulo_trasporti);
	}

	public static service.intranet.mef.model.ModuloTrasporti insertModuloTrasporti(
		java.lang.String cognome, java.lang.String nome,
		java.lang.String codice_fiscale, java.lang.String utente_inserimento,
		java.util.Date data_inserimento, java.lang.String flag_tipospesa,
		java.lang.String iban, java.lang.String importo,
		java.util.Date data_titolo_annuale, java.lang.String nr_titoli_mensili,
		java.lang.String figlio_nome, java.lang.String figlio_cognome,
		java.util.Date figlio_data_nascita, java.lang.String figlio_luogo_data,
		java.lang.String figlio_codicefiscale, java.lang.String note,
		java.lang.String flag_inviato, java.lang.String telefono,
		java.lang.String allegatoUuid) {
		return getService()
				   .insertModuloTrasporti(cognome, nome, codice_fiscale,
			utente_inserimento, data_inserimento, flag_tipospesa, iban,
			importo, data_titolo_annuale, nr_titoli_mensili, figlio_nome,
			figlio_cognome, figlio_data_nascita, figlio_luogo_data,
			figlio_codicefiscale, note, flag_inviato, telefono, allegatoUuid);
	}

	/**
	* Updates the modulo trasporti in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param moduloTrasporti the modulo trasporti
	* @return the modulo trasporti that was updated
	*/
	public static service.intranet.mef.model.ModuloTrasporti updateModuloTrasporti(
		service.intranet.mef.model.ModuloTrasporti moduloTrasporti) {
		return getService().updateModuloTrasporti(moduloTrasporti);
	}

	public static ModuloTrasportiLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ModuloTrasportiLocalService, ModuloTrasportiLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ModuloTrasportiLocalService.class);
}