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

package com.accenture.istanza.interpello.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.exception.NoSuchTextRichException;
import com.accenture.istanza.interpello.model.TextRich;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the text rich service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.accenture.istanza.interpello.service.persistence.impl.TextRichPersistenceImpl
 * @see TextRichUtil
 * @generated
 */
@ProviderType
public interface TextRichPersistence extends BasePersistence<TextRich> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TextRichUtil} to access the text rich persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the text richs where label_text = &#63;.
	*
	* @param label_text the label_text
	* @return the matching text richs
	*/
	public java.util.List<TextRich> findBylabel_text(String label_text);

	/**
	* Returns a range of all the text richs where label_text = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TextRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_text the label_text
	* @param start the lower bound of the range of text richs
	* @param end the upper bound of the range of text richs (not inclusive)
	* @return the range of matching text richs
	*/
	public java.util.List<TextRich> findBylabel_text(String label_text,
		int start, int end);

	/**
	* Returns an ordered range of all the text richs where label_text = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TextRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_text the label_text
	* @param start the lower bound of the range of text richs
	* @param end the upper bound of the range of text richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching text richs
	*/
	public java.util.List<TextRich> findBylabel_text(String label_text,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator);

	/**
	* Returns an ordered range of all the text richs where label_text = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TextRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param label_text the label_text
	* @param start the lower bound of the range of text richs
	* @param end the upper bound of the range of text richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching text richs
	*/
	public java.util.List<TextRich> findBylabel_text(String label_text,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching text rich
	* @throws NoSuchTextRichException if a matching text rich could not be found
	*/
	public TextRich findBylabel_text_First(String label_text,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator)
		throws NoSuchTextRichException;

	/**
	* Returns the first text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching text rich, or <code>null</code> if a matching text rich could not be found
	*/
	public TextRich fetchBylabel_text_First(String label_text,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator);

	/**
	* Returns the last text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching text rich
	* @throws NoSuchTextRichException if a matching text rich could not be found
	*/
	public TextRich findBylabel_text_Last(String label_text,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator)
		throws NoSuchTextRichException;

	/**
	* Returns the last text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching text rich, or <code>null</code> if a matching text rich could not be found
	*/
	public TextRich fetchBylabel_text_Last(String label_text,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator);

	/**
	* Returns the text richs before and after the current text rich in the ordered set where label_text = &#63;.
	*
	* @param id_text the primary key of the current text rich
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next text rich
	* @throws NoSuchTextRichException if a text rich with the primary key could not be found
	*/
	public TextRich[] findBylabel_text_PrevAndNext(long id_text,
		String label_text,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator)
		throws NoSuchTextRichException;

	/**
	* Removes all the text richs where label_text = &#63; from the database.
	*
	* @param label_text the label_text
	*/
	public void removeBylabel_text(String label_text);

	/**
	* Returns the number of text richs where label_text = &#63;.
	*
	* @param label_text the label_text
	* @return the number of matching text richs
	*/
	public int countBylabel_text(String label_text);

	/**
	* Caches the text rich in the entity cache if it is enabled.
	*
	* @param textRich the text rich
	*/
	public void cacheResult(TextRich textRich);

	/**
	* Caches the text richs in the entity cache if it is enabled.
	*
	* @param textRichs the text richs
	*/
	public void cacheResult(java.util.List<TextRich> textRichs);

	/**
	* Creates a new text rich with the primary key. Does not add the text rich to the database.
	*
	* @param id_text the primary key for the new text rich
	* @return the new text rich
	*/
	public TextRich create(long id_text);

	/**
	* Removes the text rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_text the primary key of the text rich
	* @return the text rich that was removed
	* @throws NoSuchTextRichException if a text rich with the primary key could not be found
	*/
	public TextRich remove(long id_text) throws NoSuchTextRichException;

	public TextRich updateImpl(TextRich textRich);

	/**
	* Returns the text rich with the primary key or throws a {@link NoSuchTextRichException} if it could not be found.
	*
	* @param id_text the primary key of the text rich
	* @return the text rich
	* @throws NoSuchTextRichException if a text rich with the primary key could not be found
	*/
	public TextRich findByPrimaryKey(long id_text)
		throws NoSuchTextRichException;

	/**
	* Returns the text rich with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_text the primary key of the text rich
	* @return the text rich, or <code>null</code> if a text rich with the primary key could not be found
	*/
	public TextRich fetchByPrimaryKey(long id_text);

	@Override
	public java.util.Map<java.io.Serializable, TextRich> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the text richs.
	*
	* @return the text richs
	*/
	public java.util.List<TextRich> findAll();

	/**
	* Returns a range of all the text richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TextRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of text richs
	* @param end the upper bound of the range of text richs (not inclusive)
	* @return the range of text richs
	*/
	public java.util.List<TextRich> findAll(int start, int end);

	/**
	* Returns an ordered range of all the text richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TextRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of text richs
	* @param end the upper bound of the range of text richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of text richs
	*/
	public java.util.List<TextRich> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator);

	/**
	* Returns an ordered range of all the text richs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TextRichModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of text richs
	* @param end the upper bound of the range of text richs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of text richs
	*/
	public java.util.List<TextRich> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TextRich> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the text richs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of text richs.
	*
	* @return the number of text richs
	*/
	public int countAll();
}