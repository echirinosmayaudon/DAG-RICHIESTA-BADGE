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

import com.accenture.istanza.interpello.model.TextRich;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the text rich service. This utility wraps {@link com.accenture.istanza.interpello.service.persistence.impl.TextRichPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TextRichPersistence
 * @see com.accenture.istanza.interpello.service.persistence.impl.TextRichPersistenceImpl
 * @generated
 */
@ProviderType
public class TextRichUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TextRich textRich) {
		getPersistence().clearCache(textRich);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TextRich> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TextRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TextRich> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TextRich> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TextRich update(TextRich textRich) {
		return getPersistence().update(textRich);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TextRich update(TextRich textRich,
		ServiceContext serviceContext) {
		return getPersistence().update(textRich, serviceContext);
	}

	/**
	* Returns all the text richs where label_text = &#63;.
	*
	* @param label_text the label_text
	* @return the matching text richs
	*/
	public static List<TextRich> findBylabel_text(String label_text) {
		return getPersistence().findBylabel_text(label_text);
	}

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
	public static List<TextRich> findBylabel_text(String label_text, int start,
		int end) {
		return getPersistence().findBylabel_text(label_text, start, end);
	}

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
	public static List<TextRich> findBylabel_text(String label_text, int start,
		int end, OrderByComparator<TextRich> orderByComparator) {
		return getPersistence()
				   .findBylabel_text(label_text, start, end, orderByComparator);
	}

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
	public static List<TextRich> findBylabel_text(String label_text, int start,
		int end, OrderByComparator<TextRich> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBylabel_text(label_text, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching text rich
	* @throws NoSuchTextRichException if a matching text rich could not be found
	*/
	public static TextRich findBylabel_text_First(String label_text,
		OrderByComparator<TextRich> orderByComparator)
		throws com.accenture.istanza.interpello.exception.NoSuchTextRichException {
		return getPersistence()
				   .findBylabel_text_First(label_text, orderByComparator);
	}

	/**
	* Returns the first text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching text rich, or <code>null</code> if a matching text rich could not be found
	*/
	public static TextRich fetchBylabel_text_First(String label_text,
		OrderByComparator<TextRich> orderByComparator) {
		return getPersistence()
				   .fetchBylabel_text_First(label_text, orderByComparator);
	}

	/**
	* Returns the last text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching text rich
	* @throws NoSuchTextRichException if a matching text rich could not be found
	*/
	public static TextRich findBylabel_text_Last(String label_text,
		OrderByComparator<TextRich> orderByComparator)
		throws com.accenture.istanza.interpello.exception.NoSuchTextRichException {
		return getPersistence()
				   .findBylabel_text_Last(label_text, orderByComparator);
	}

	/**
	* Returns the last text rich in the ordered set where label_text = &#63;.
	*
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching text rich, or <code>null</code> if a matching text rich could not be found
	*/
	public static TextRich fetchBylabel_text_Last(String label_text,
		OrderByComparator<TextRich> orderByComparator) {
		return getPersistence()
				   .fetchBylabel_text_Last(label_text, orderByComparator);
	}

	/**
	* Returns the text richs before and after the current text rich in the ordered set where label_text = &#63;.
	*
	* @param id_text the primary key of the current text rich
	* @param label_text the label_text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next text rich
	* @throws NoSuchTextRichException if a text rich with the primary key could not be found
	*/
	public static TextRich[] findBylabel_text_PrevAndNext(long id_text,
		String label_text, OrderByComparator<TextRich> orderByComparator)
		throws com.accenture.istanza.interpello.exception.NoSuchTextRichException {
		return getPersistence()
				   .findBylabel_text_PrevAndNext(id_text, label_text,
			orderByComparator);
	}

	/**
	* Removes all the text richs where label_text = &#63; from the database.
	*
	* @param label_text the label_text
	*/
	public static void removeBylabel_text(String label_text) {
		getPersistence().removeBylabel_text(label_text);
	}

	/**
	* Returns the number of text richs where label_text = &#63;.
	*
	* @param label_text the label_text
	* @return the number of matching text richs
	*/
	public static int countBylabel_text(String label_text) {
		return getPersistence().countBylabel_text(label_text);
	}

	/**
	* Caches the text rich in the entity cache if it is enabled.
	*
	* @param textRich the text rich
	*/
	public static void cacheResult(TextRich textRich) {
		getPersistence().cacheResult(textRich);
	}

	/**
	* Caches the text richs in the entity cache if it is enabled.
	*
	* @param textRichs the text richs
	*/
	public static void cacheResult(List<TextRich> textRichs) {
		getPersistence().cacheResult(textRichs);
	}

	/**
	* Creates a new text rich with the primary key. Does not add the text rich to the database.
	*
	* @param id_text the primary key for the new text rich
	* @return the new text rich
	*/
	public static TextRich create(long id_text) {
		return getPersistence().create(id_text);
	}

	/**
	* Removes the text rich with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id_text the primary key of the text rich
	* @return the text rich that was removed
	* @throws NoSuchTextRichException if a text rich with the primary key could not be found
	*/
	public static TextRich remove(long id_text)
		throws com.accenture.istanza.interpello.exception.NoSuchTextRichException {
		return getPersistence().remove(id_text);
	}

	public static TextRich updateImpl(TextRich textRich) {
		return getPersistence().updateImpl(textRich);
	}

	/**
	* Returns the text rich with the primary key or throws a {@link NoSuchTextRichException} if it could not be found.
	*
	* @param id_text the primary key of the text rich
	* @return the text rich
	* @throws NoSuchTextRichException if a text rich with the primary key could not be found
	*/
	public static TextRich findByPrimaryKey(long id_text)
		throws com.accenture.istanza.interpello.exception.NoSuchTextRichException {
		return getPersistence().findByPrimaryKey(id_text);
	}

	/**
	* Returns the text rich with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id_text the primary key of the text rich
	* @return the text rich, or <code>null</code> if a text rich with the primary key could not be found
	*/
	public static TextRich fetchByPrimaryKey(long id_text) {
		return getPersistence().fetchByPrimaryKey(id_text);
	}

	public static java.util.Map<java.io.Serializable, TextRich> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the text richs.
	*
	* @return the text richs
	*/
	public static List<TextRich> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TextRich> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TextRich> findAll(int start, int end,
		OrderByComparator<TextRich> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TextRich> findAll(int start, int end,
		OrderByComparator<TextRich> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the text richs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of text richs.
	*
	* @return the number of text richs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TextRichPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TextRichPersistence, TextRichPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TextRichPersistence.class);

		ServiceTracker<TextRichPersistence, TextRichPersistence> serviceTracker = new ServiceTracker<TextRichPersistence, TextRichPersistence>(bundle.getBundleContext(),
				TextRichPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}