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

import external.bfc.intranet.mef.exception.NoSuchRichiesteException;
import external.bfc.intranet.mef.model.Richieste;

/**
 * The persistence interface for the richieste service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.persistence.impl.RichiestePersistenceImpl
 * @see RichiesteUtil
 * @generated
 */
@ProviderType
public interface RichiestePersistence extends BasePersistence<Richieste> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiesteUtil} to access the richieste persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the richiestes where email = &#63;.
	*
	* @param email the email
	* @return the matching richiestes
	*/
	public java.util.List<Richieste> findByemailReqBfc(java.lang.String email);

	/**
	* Returns a range of all the richiestes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @return the range of matching richiestes
	*/
	public java.util.List<Richieste> findByemailReqBfc(java.lang.String email,
		int start, int end);

	/**
	* Returns an ordered range of all the richiestes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching richiestes
	*/
	public java.util.List<Richieste> findByemailReqBfc(java.lang.String email,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator);

	/**
	* Returns an ordered range of all the richiestes where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching richiestes
	*/
	public java.util.List<Richieste> findByemailReqBfc(java.lang.String email,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste
	* @throws NoSuchRichiesteException if a matching richieste could not be found
	*/
	public Richieste findByemailReqBfc_First(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator)
		throws NoSuchRichiesteException;

	/**
	* Returns the first richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching richieste, or <code>null</code> if a matching richieste could not be found
	*/
	public Richieste fetchByemailReqBfc_First(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator);

	/**
	* Returns the last richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste
	* @throws NoSuchRichiesteException if a matching richieste could not be found
	*/
	public Richieste findByemailReqBfc_Last(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator)
		throws NoSuchRichiesteException;

	/**
	* Returns the last richieste in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching richieste, or <code>null</code> if a matching richieste could not be found
	*/
	public Richieste fetchByemailReqBfc_Last(java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator);

	/**
	* Returns the richiestes before and after the current richieste in the ordered set where email = &#63;.
	*
	* @param id the primary key of the current richieste
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next richieste
	* @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	*/
	public Richieste[] findByemailReqBfc_PrevAndNext(long id,
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator)
		throws NoSuchRichiesteException;

	/**
	* Removes all the richiestes where email = &#63; from the database.
	*
	* @param email the email
	*/
	public void removeByemailReqBfc(java.lang.String email);

	/**
	* Returns the number of richiestes where email = &#63;.
	*
	* @param email the email
	* @return the number of matching richiestes
	*/
	public int countByemailReqBfc(java.lang.String email);

	/**
	* Caches the richieste in the entity cache if it is enabled.
	*
	* @param richieste the richieste
	*/
	public void cacheResult(Richieste richieste);

	/**
	* Caches the richiestes in the entity cache if it is enabled.
	*
	* @param richiestes the richiestes
	*/
	public void cacheResult(java.util.List<Richieste> richiestes);

	/**
	* Creates a new richieste with the primary key. Does not add the richieste to the database.
	*
	* @param id the primary key for the new richieste
	* @return the new richieste
	*/
	public Richieste create(long id);

	/**
	* Removes the richieste with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the richieste
	* @return the richieste that was removed
	* @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	*/
	public Richieste remove(long id) throws NoSuchRichiesteException;

	public Richieste updateImpl(Richieste richieste);

	/**
	* Returns the richieste with the primary key or throws a {@link NoSuchRichiesteException} if it could not be found.
	*
	* @param id the primary key of the richieste
	* @return the richieste
	* @throws NoSuchRichiesteException if a richieste with the primary key could not be found
	*/
	public Richieste findByPrimaryKey(long id) throws NoSuchRichiesteException;

	/**
	* Returns the richieste with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the richieste
	* @return the richieste, or <code>null</code> if a richieste with the primary key could not be found
	*/
	public Richieste fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Richieste> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richiestes.
	*
	* @return the richiestes
	*/
	public java.util.List<Richieste> findAll();

	/**
	* Returns a range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @return the range of richiestes
	*/
	public java.util.List<Richieste> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richiestes
	*/
	public java.util.List<Richieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator);

	/**
	* Returns an ordered range of all the richiestes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richiestes
	* @param end the upper bound of the range of richiestes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richiestes
	*/
	public java.util.List<Richieste> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Richieste> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richiestes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richiestes.
	*
	* @return the number of richiestes
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}