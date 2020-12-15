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

package servizio.beni.facile.consumo.richieste.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import servizio.beni.facile.consumo.richieste.exception.NoSuchRigheRichBFCNewException;
import servizio.beni.facile.consumo.richieste.model.RigheRichBFCNew;

/**
 * The persistence interface for the righe rich b f c new service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see servizio.beni.facile.consumo.richieste.service.persistence.impl.RigheRichBFCNewPersistenceImpl
 * @see RigheRichBFCNewUtil
 * @generated
 */
@ProviderType
public interface RigheRichBFCNewPersistence extends BasePersistence<RigheRichBFCNew> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RigheRichBFCNewUtil} to access the righe rich b f c new persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the righe rich b f c news where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento);

	/**
	* Returns a range of all the righe rich b f c news where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @return the range of matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento, int start, int end);

	/**
	* Returns an ordered range of all the righe rich b f c news where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns an ordered range of all the righe rich b f c news where dipartimento = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dipartimento the dipartimento
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByDipartimento(
		java.lang.String dipartimento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew findByDipartimento_First(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Returns the first righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew fetchByDipartimento_First(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns the last righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew findByDipartimento_Last(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Returns the last righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew fetchByDipartimento_Last(
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns the righe rich b f c news before and after the current righe rich b f c new in the ordered set where dipartimento = &#63;.
	*
	* @param id the primary key of the current righe rich b f c new
	* @param dipartimento the dipartimento
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public RigheRichBFCNew[] findByDipartimento_PrevAndNext(long id,
		java.lang.String dipartimento,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Removes all the righe rich b f c news where dipartimento = &#63; from the database.
	*
	* @param dipartimento the dipartimento
	*/
	public void removeByDipartimento(java.lang.String dipartimento);

	/**
	* Returns the number of righe rich b f c news where dipartimento = &#63;.
	*
	* @param dipartimento the dipartimento
	* @return the number of matching righe rich b f c news
	*/
	public int countByDipartimento(java.lang.String dipartimento);

	/**
	* Returns all the righe rich b f c news where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByIdRichiesta(long id_rich);

	/**
	* Returns a range of all the righe rich b f c news where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @return the range of matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByIdRichiesta(long id_rich,
		int start, int end);

	/**
	* Returns an ordered range of all the righe rich b f c news where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByIdRichiesta(long id_rich,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns an ordered range of all the righe rich b f c news where id_rich = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param id_rich the id_rich
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findByIdRichiesta(long id_rich,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew findByIdRichiesta_First(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Returns the first righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew fetchByIdRichiesta_First(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns the last righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew findByIdRichiesta_Last(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Returns the last righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching righe rich b f c new, or <code>null</code> if a matching righe rich b f c new could not be found
	*/
	public RigheRichBFCNew fetchByIdRichiesta_Last(long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns the righe rich b f c news before and after the current righe rich b f c new in the ordered set where id_rich = &#63;.
	*
	* @param id the primary key of the current righe rich b f c new
	* @param id_rich the id_rich
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public RigheRichBFCNew[] findByIdRichiesta_PrevAndNext(long id,
		long id_rich,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Removes all the righe rich b f c news where id_rich = &#63; from the database.
	*
	* @param id_rich the id_rich
	*/
	public void removeByIdRichiesta(long id_rich);

	/**
	* Returns the number of righe rich b f c news where id_rich = &#63;.
	*
	* @param id_rich the id_rich
	* @return the number of matching righe rich b f c news
	*/
	public int countByIdRichiesta(long id_rich);

	/**
	* Caches the righe rich b f c new in the entity cache if it is enabled.
	*
	* @param righeRichBFCNew the righe rich b f c new
	*/
	public void cacheResult(RigheRichBFCNew righeRichBFCNew);

	/**
	* Caches the righe rich b f c news in the entity cache if it is enabled.
	*
	* @param righeRichBFCNews the righe rich b f c news
	*/
	public void cacheResult(java.util.List<RigheRichBFCNew> righeRichBFCNews);

	/**
	* Creates a new righe rich b f c new with the primary key. Does not add the righe rich b f c new to the database.
	*
	* @param id the primary key for the new righe rich b f c new
	* @return the new righe rich b f c new
	*/
	public RigheRichBFCNew create(long id);

	/**
	* Removes the righe rich b f c new with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the righe rich b f c new
	* @return the righe rich b f c new that was removed
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public RigheRichBFCNew remove(long id)
		throws NoSuchRigheRichBFCNewException;

	public RigheRichBFCNew updateImpl(RigheRichBFCNew righeRichBFCNew);

	/**
	* Returns the righe rich b f c new with the primary key or throws a {@link NoSuchRigheRichBFCNewException} if it could not be found.
	*
	* @param id the primary key of the righe rich b f c new
	* @return the righe rich b f c new
	* @throws NoSuchRigheRichBFCNewException if a righe rich b f c new with the primary key could not be found
	*/
	public RigheRichBFCNew findByPrimaryKey(long id)
		throws NoSuchRigheRichBFCNewException;

	/**
	* Returns the righe rich b f c new with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the righe rich b f c new
	* @return the righe rich b f c new, or <code>null</code> if a righe rich b f c new with the primary key could not be found
	*/
	public RigheRichBFCNew fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, RigheRichBFCNew> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the righe rich b f c news.
	*
	* @return the righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findAll();

	/**
	* Returns a range of all the righe rich b f c news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @return the range of righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findAll(int start, int end);

	/**
	* Returns an ordered range of all the righe rich b f c news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator);

	/**
	* Returns an ordered range of all the righe rich b f c news.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RigheRichBFCNewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of righe rich b f c news
	* @param end the upper bound of the range of righe rich b f c news (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of righe rich b f c news
	*/
	public java.util.List<RigheRichBFCNew> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RigheRichBFCNew> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the righe rich b f c news from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of righe rich b f c news.
	*
	* @return the number of righe rich b f c news
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}