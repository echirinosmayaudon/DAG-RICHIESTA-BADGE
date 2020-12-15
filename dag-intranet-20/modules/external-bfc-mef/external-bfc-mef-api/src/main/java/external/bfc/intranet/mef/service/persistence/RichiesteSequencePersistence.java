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

import external.bfc.intranet.mef.exception.NoSuchRichiesteSequenceException;
import external.bfc.intranet.mef.model.RichiesteSequence;

/**
 * The persistence interface for the richieste sequence service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see external.bfc.intranet.mef.service.persistence.impl.RichiesteSequencePersistenceImpl
 * @see RichiesteSequenceUtil
 * @generated
 */
@ProviderType
public interface RichiesteSequencePersistence extends BasePersistence<RichiesteSequence> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RichiesteSequenceUtil} to access the richieste sequence persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the richieste sequence in the entity cache if it is enabled.
	*
	* @param richiesteSequence the richieste sequence
	*/
	public void cacheResult(RichiesteSequence richiesteSequence);

	/**
	* Caches the richieste sequences in the entity cache if it is enabled.
	*
	* @param richiesteSequences the richieste sequences
	*/
	public void cacheResult(
		java.util.List<RichiesteSequence> richiesteSequences);

	/**
	* Creates a new richieste sequence with the primary key. Does not add the richieste sequence to the database.
	*
	* @param idSeq the primary key for the new richieste sequence
	* @return the new richieste sequence
	*/
	public RichiesteSequence create(long idSeq);

	/**
	* Removes the richieste sequence with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence that was removed
	* @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	*/
	public RichiesteSequence remove(long idSeq)
		throws NoSuchRichiesteSequenceException;

	public RichiesteSequence updateImpl(RichiesteSequence richiesteSequence);

	/**
	* Returns the richieste sequence with the primary key or throws a {@link NoSuchRichiesteSequenceException} if it could not be found.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence
	* @throws NoSuchRichiesteSequenceException if a richieste sequence with the primary key could not be found
	*/
	public RichiesteSequence findByPrimaryKey(long idSeq)
		throws NoSuchRichiesteSequenceException;

	/**
	* Returns the richieste sequence with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idSeq the primary key of the richieste sequence
	* @return the richieste sequence, or <code>null</code> if a richieste sequence with the primary key could not be found
	*/
	public RichiesteSequence fetchByPrimaryKey(long idSeq);

	@Override
	public java.util.Map<java.io.Serializable, RichiesteSequence> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the richieste sequences.
	*
	* @return the richieste sequences
	*/
	public java.util.List<RichiesteSequence> findAll();

	/**
	* Returns a range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @return the range of richieste sequences
	*/
	public java.util.List<RichiesteSequence> findAll(int start, int end);

	/**
	* Returns an ordered range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of richieste sequences
	*/
	public java.util.List<RichiesteSequence> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteSequence> orderByComparator);

	/**
	* Returns an ordered range of all the richieste sequences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link RichiesteSequenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of richieste sequences
	* @param end the upper bound of the range of richieste sequences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of richieste sequences
	*/
	public java.util.List<RichiesteSequence> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RichiesteSequence> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the richieste sequences from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of richieste sequences.
	*
	* @return the number of richieste sequences
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}