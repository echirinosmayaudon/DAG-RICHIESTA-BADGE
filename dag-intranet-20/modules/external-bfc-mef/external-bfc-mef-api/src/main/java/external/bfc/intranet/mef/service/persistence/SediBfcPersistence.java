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

package external.bfc.intranet.mef.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import external.bfc.intranet.mef.exception.NoSuchSediBfcException;
import external.bfc.intranet.mef.model.SediBfc;

/**
 * The persistence interface for the sedi bfc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.persistence.impl.SediBfcPersistenceImpl
 * @see SediBfcUtil
 * @generated
 */
@ProviderType
public interface SediBfcPersistence extends BasePersistence<SediBfc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SediBfcUtil} to access the sedi bfc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @return the matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app);

	/**
	* Returns a range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end);

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv2AndFlagApp(long id_org_liv2,
		boolean flag_app, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public SediBfc findByIdOrgLiv2AndFlagApp_First(long id_org_liv2,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException;

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public SediBfc fetchByIdOrgLiv2AndFlagApp_First(long id_org_liv2,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public SediBfc findByIdOrgLiv2AndFlagApp_Last(long id_org_liv2,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException;

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public SediBfc fetchByIdOrgLiv2AndFlagApp_Last(long id_org_liv2,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns the sedi bfcs before and after the current sedi bfc in the ordered set where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id the primary key of the current sedi bfc
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi bfc
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public SediBfc[] findByIdOrgLiv2AndFlagApp_PrevAndNext(long id,
		long id_org_liv2, boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException;

	/**
	* Removes all the sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63; from the database.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	*/
	public void removeByIdOrgLiv2AndFlagApp(long id_org_liv2, boolean flag_app);

	/**
	* Returns the number of sedi bfcs where id_org_liv2 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv2 the id_org_liv2
	* @param flag_app the flag_app
	* @return the number of matching sedi bfcs
	*/
	public int countByIdOrgLiv2AndFlagApp(long id_org_liv2, boolean flag_app);

	/**
	* Returns all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @return the matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app);

	/**
	* Returns a range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end);

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns an ordered range of all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching sedi bfcs
	*/
	public java.util.List<SediBfc> findByIdOrgLiv3AndFlagApp(long id_org_liv3,
		boolean flag_app, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public SediBfc findByIdOrgLiv3AndFlagApp_First(long id_org_liv3,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException;

	/**
	* Returns the first sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public SediBfc fetchByIdOrgLiv3AndFlagApp_First(long id_org_liv3,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc
	* @throws NoSuchSediBfcException if a matching sedi bfc could not be found
	*/
	public SediBfc findByIdOrgLiv3AndFlagApp_Last(long id_org_liv3,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException;

	/**
	* Returns the last sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sedi bfc, or <code>null</code> if a matching sedi bfc could not be found
	*/
	public SediBfc fetchByIdOrgLiv3AndFlagApp_Last(long id_org_liv3,
		boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns the sedi bfcs before and after the current sedi bfc in the ordered set where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id the primary key of the current sedi bfc
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sedi bfc
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public SediBfc[] findByIdOrgLiv3AndFlagApp_PrevAndNext(long id,
		long id_org_liv3, boolean flag_app,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator)
		throws NoSuchSediBfcException;

	/**
	* Removes all the sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63; from the database.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	*/
	public void removeByIdOrgLiv3AndFlagApp(long id_org_liv3, boolean flag_app);

	/**
	* Returns the number of sedi bfcs where id_org_liv3 = &#63; and flag_app = &#63;.
	*
	* @param id_org_liv3 the id_org_liv3
	* @param flag_app the flag_app
	* @return the number of matching sedi bfcs
	*/
	public int countByIdOrgLiv3AndFlagApp(long id_org_liv3, boolean flag_app);

	/**
	* Caches the sedi bfc in the entity cache if it is enabled.
	*
	* @param sediBfc the sedi bfc
	*/
	public void cacheResult(SediBfc sediBfc);

	/**
	* Caches the sedi bfcs in the entity cache if it is enabled.
	*
	* @param sediBfcs the sedi bfcs
	*/
	public void cacheResult(java.util.List<SediBfc> sediBfcs);

	/**
	* Creates a new sedi bfc with the primary key. Does not add the sedi bfc to the database.
	*
	* @param id the primary key for the new sedi bfc
	* @return the new sedi bfc
	*/
	public SediBfc create(long id);

	/**
	* Removes the sedi bfc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc that was removed
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public SediBfc remove(long id) throws NoSuchSediBfcException;

	public SediBfc updateImpl(SediBfc sediBfc);

	/**
	* Returns the sedi bfc with the primary key or throws a {@link NoSuchSediBfcException} if it could not be found.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc
	* @throws NoSuchSediBfcException if a sedi bfc with the primary key could not be found
	*/
	public SediBfc findByPrimaryKey(long id) throws NoSuchSediBfcException;

	/**
	* Returns the sedi bfc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the sedi bfc
	* @return the sedi bfc, or <code>null</code> if a sedi bfc with the primary key could not be found
	*/
	public SediBfc fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, SediBfc> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the sedi bfcs.
	*
	* @return the sedi bfcs
	*/
	public java.util.List<SediBfc> findAll();

	/**
	* Returns a range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @return the range of sedi bfcs
	*/
	public java.util.List<SediBfc> findAll(int start, int end);

	/**
	* Returns an ordered range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sedi bfcs
	*/
	public java.util.List<SediBfc> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator);

	/**
	* Returns an ordered range of all the sedi bfcs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SediBfcModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sedi bfcs
	* @param end the upper bound of the range of sedi bfcs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of sedi bfcs
	*/
	public java.util.List<SediBfc> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SediBfc> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the sedi bfcs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of sedi bfcs.
	*
	* @return the number of sedi bfcs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}