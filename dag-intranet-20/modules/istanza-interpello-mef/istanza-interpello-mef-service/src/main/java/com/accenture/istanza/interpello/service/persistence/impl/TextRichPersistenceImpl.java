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

package com.accenture.istanza.interpello.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.accenture.istanza.interpello.exception.NoSuchTextRichException;
import com.accenture.istanza.interpello.model.TextRich;
import com.accenture.istanza.interpello.model.impl.TextRichImpl;
import com.accenture.istanza.interpello.model.impl.TextRichModelImpl;
import com.accenture.istanza.interpello.service.persistence.TextRichPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the text rich service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TextRichPersistence
 * @see com.accenture.istanza.interpello.service.persistence.TextRichUtil
 * @generated
 */
@ProviderType
public class TextRichPersistenceImpl extends BasePersistenceImpl<TextRich>
	implements TextRichPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TextRichUtil} to access the text rich persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TextRichImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichModelImpl.FINDER_CACHE_ENABLED, TextRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichModelImpl.FINDER_CACHE_ENABLED, TextRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LABEL_TEXT =
		new FinderPath(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichModelImpl.FINDER_CACHE_ENABLED, TextRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylabel_text",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_TEXT =
		new FinderPath(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichModelImpl.FINDER_CACHE_ENABLED, TextRichImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylabel_text",
			new String[] { String.class.getName() },
			TextRichModelImpl.LABEL_TEXT_COLUMN_BITMASK |
			TextRichModelImpl.DATA_IN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABEL_TEXT = new FinderPath(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylabel_text",
			new String[] { String.class.getName() });

	/**
	 * Returns all the text richs where label_text = &#63;.
	 *
	 * @param label_text the label_text
	 * @return the matching text richs
	 */
	@Override
	public List<TextRich> findBylabel_text(String label_text) {
		return findBylabel_text(label_text, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TextRich> findBylabel_text(String label_text, int start, int end) {
		return findBylabel_text(label_text, start, end, null);
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
	@Override
	public List<TextRich> findBylabel_text(String label_text, int start,
		int end, OrderByComparator<TextRich> orderByComparator) {
		return findBylabel_text(label_text, start, end, orderByComparator, true);
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
	@Override
	public List<TextRich> findBylabel_text(String label_text, int start,
		int end, OrderByComparator<TextRich> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_TEXT;
			finderArgs = new Object[] { label_text };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LABEL_TEXT;
			finderArgs = new Object[] { label_text, start, end, orderByComparator };
		}

		List<TextRich> list = null;

		if (retrieveFromCache) {
			list = (List<TextRich>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TextRich textRich : list) {
					if (!Objects.equals(label_text, textRich.getLabel_text())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TEXTRICH_WHERE);

			boolean bindLabel_text = false;

			if (label_text == null) {
				query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_1);
			}
			else if (label_text.equals("")) {
				query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_3);
			}
			else {
				bindLabel_text = true;

				query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TextRichModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel_text) {
					qPos.add(label_text);
				}

				if (!pagination) {
					list = (List<TextRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TextRich>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first text rich in the ordered set where label_text = &#63;.
	 *
	 * @param label_text the label_text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching text rich
	 * @throws NoSuchTextRichException if a matching text rich could not be found
	 */
	@Override
	public TextRich findBylabel_text_First(String label_text,
		OrderByComparator<TextRich> orderByComparator)
		throws NoSuchTextRichException {
		TextRich textRich = fetchBylabel_text_First(label_text,
				orderByComparator);

		if (textRich != null) {
			return textRich;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label_text=");
		msg.append(label_text);

		msg.append("}");

		throw new NoSuchTextRichException(msg.toString());
	}

	/**
	 * Returns the first text rich in the ordered set where label_text = &#63;.
	 *
	 * @param label_text the label_text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching text rich, or <code>null</code> if a matching text rich could not be found
	 */
	@Override
	public TextRich fetchBylabel_text_First(String label_text,
		OrderByComparator<TextRich> orderByComparator) {
		List<TextRich> list = findBylabel_text(label_text, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last text rich in the ordered set where label_text = &#63;.
	 *
	 * @param label_text the label_text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching text rich
	 * @throws NoSuchTextRichException if a matching text rich could not be found
	 */
	@Override
	public TextRich findBylabel_text_Last(String label_text,
		OrderByComparator<TextRich> orderByComparator)
		throws NoSuchTextRichException {
		TextRich textRich = fetchBylabel_text_Last(label_text, orderByComparator);

		if (textRich != null) {
			return textRich;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("label_text=");
		msg.append(label_text);

		msg.append("}");

		throw new NoSuchTextRichException(msg.toString());
	}

	/**
	 * Returns the last text rich in the ordered set where label_text = &#63;.
	 *
	 * @param label_text the label_text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching text rich, or <code>null</code> if a matching text rich could not be found
	 */
	@Override
	public TextRich fetchBylabel_text_Last(String label_text,
		OrderByComparator<TextRich> orderByComparator) {
		int count = countBylabel_text(label_text);

		if (count == 0) {
			return null;
		}

		List<TextRich> list = findBylabel_text(label_text, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TextRich[] findBylabel_text_PrevAndNext(long id_text,
		String label_text, OrderByComparator<TextRich> orderByComparator)
		throws NoSuchTextRichException {
		TextRich textRich = findByPrimaryKey(id_text);

		Session session = null;

		try {
			session = openSession();

			TextRich[] array = new TextRichImpl[3];

			array[0] = getBylabel_text_PrevAndNext(session, textRich,
					label_text, orderByComparator, true);

			array[1] = textRich;

			array[2] = getBylabel_text_PrevAndNext(session, textRich,
					label_text, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TextRich getBylabel_text_PrevAndNext(Session session,
		TextRich textRich, String label_text,
		OrderByComparator<TextRich> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TEXTRICH_WHERE);

		boolean bindLabel_text = false;

		if (label_text == null) {
			query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_1);
		}
		else if (label_text.equals("")) {
			query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_3);
		}
		else {
			bindLabel_text = true;

			query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TextRichModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLabel_text) {
			qPos.add(label_text);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(textRich);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TextRich> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the text richs where label_text = &#63; from the database.
	 *
	 * @param label_text the label_text
	 */
	@Override
	public void removeBylabel_text(String label_text) {
		for (TextRich textRich : findBylabel_text(label_text,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(textRich);
		}
	}

	/**
	 * Returns the number of text richs where label_text = &#63;.
	 *
	 * @param label_text the label_text
	 * @return the number of matching text richs
	 */
	@Override
	public int countBylabel_text(String label_text) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABEL_TEXT;

		Object[] finderArgs = new Object[] { label_text };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TEXTRICH_WHERE);

			boolean bindLabel_text = false;

			if (label_text == null) {
				query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_1);
			}
			else if (label_text.equals("")) {
				query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_3);
			}
			else {
				bindLabel_text = true;

				query.append(_FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLabel_text) {
					qPos.add(label_text);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_1 = "textRich.label_text IS NULL";
	private static final String _FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_2 = "textRich.label_text = ?";
	private static final String _FINDER_COLUMN_LABEL_TEXT_LABEL_TEXT_3 = "(textRich.label_text IS NULL OR textRich.label_text = '')";

	public TextRichPersistenceImpl() {
		setModelClass(TextRich.class);
	}

	/**
	 * Caches the text rich in the entity cache if it is enabled.
	 *
	 * @param textRich the text rich
	 */
	@Override
	public void cacheResult(TextRich textRich) {
		entityCache.putResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichImpl.class, textRich.getPrimaryKey(), textRich);

		textRich.resetOriginalValues();
	}

	/**
	 * Caches the text richs in the entity cache if it is enabled.
	 *
	 * @param textRichs the text richs
	 */
	@Override
	public void cacheResult(List<TextRich> textRichs) {
		for (TextRich textRich : textRichs) {
			if (entityCache.getResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
						TextRichImpl.class, textRich.getPrimaryKey()) == null) {
				cacheResult(textRich);
			}
			else {
				textRich.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all text richs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TextRichImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the text rich.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TextRich textRich) {
		entityCache.removeResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichImpl.class, textRich.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TextRich> textRichs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TextRich textRich : textRichs) {
			entityCache.removeResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
				TextRichImpl.class, textRich.getPrimaryKey());
		}
	}

	/**
	 * Creates a new text rich with the primary key. Does not add the text rich to the database.
	 *
	 * @param id_text the primary key for the new text rich
	 * @return the new text rich
	 */
	@Override
	public TextRich create(long id_text) {
		TextRich textRich = new TextRichImpl();

		textRich.setNew(true);
		textRich.setPrimaryKey(id_text);

		return textRich;
	}

	/**
	 * Removes the text rich with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_text the primary key of the text rich
	 * @return the text rich that was removed
	 * @throws NoSuchTextRichException if a text rich with the primary key could not be found
	 */
	@Override
	public TextRich remove(long id_text) throws NoSuchTextRichException {
		return remove((Serializable)id_text);
	}

	/**
	 * Removes the text rich with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the text rich
	 * @return the text rich that was removed
	 * @throws NoSuchTextRichException if a text rich with the primary key could not be found
	 */
	@Override
	public TextRich remove(Serializable primaryKey)
		throws NoSuchTextRichException {
		Session session = null;

		try {
			session = openSession();

			TextRich textRich = (TextRich)session.get(TextRichImpl.class,
					primaryKey);

			if (textRich == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTextRichException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(textRich);
		}
		catch (NoSuchTextRichException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TextRich removeImpl(TextRich textRich) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(textRich)) {
				textRich = (TextRich)session.get(TextRichImpl.class,
						textRich.getPrimaryKeyObj());
			}

			if (textRich != null) {
				session.delete(textRich);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (textRich != null) {
			clearCache(textRich);
		}

		return textRich;
	}

	@Override
	public TextRich updateImpl(TextRich textRich) {
		boolean isNew = textRich.isNew();

		if (!(textRich instanceof TextRichModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(textRich.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(textRich);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in textRich proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TextRich implementation " +
				textRich.getClass());
		}

		TextRichModelImpl textRichModelImpl = (TextRichModelImpl)textRich;

		Session session = null;

		try {
			session = openSession();

			if (textRich.isNew()) {
				session.save(textRich);

				textRich.setNew(false);
			}
			else {
				textRich = (TextRich)session.merge(textRich);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TextRichModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { textRichModelImpl.getLabel_text() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LABEL_TEXT, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_TEXT,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((textRichModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_TEXT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						textRichModelImpl.getOriginalLabel_text()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABEL_TEXT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_TEXT,
					args);

				args = new Object[] { textRichModelImpl.getLabel_text() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABEL_TEXT, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABEL_TEXT,
					args);
			}
		}

		entityCache.putResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
			TextRichImpl.class, textRich.getPrimaryKey(), textRich, false);

		textRich.resetOriginalValues();

		return textRich;
	}

	/**
	 * Returns the text rich with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the text rich
	 * @return the text rich
	 * @throws NoSuchTextRichException if a text rich with the primary key could not be found
	 */
	@Override
	public TextRich findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTextRichException {
		TextRich textRich = fetchByPrimaryKey(primaryKey);

		if (textRich == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTextRichException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return textRich;
	}

	/**
	 * Returns the text rich with the primary key or throws a {@link NoSuchTextRichException} if it could not be found.
	 *
	 * @param id_text the primary key of the text rich
	 * @return the text rich
	 * @throws NoSuchTextRichException if a text rich with the primary key could not be found
	 */
	@Override
	public TextRich findByPrimaryKey(long id_text)
		throws NoSuchTextRichException {
		return findByPrimaryKey((Serializable)id_text);
	}

	/**
	 * Returns the text rich with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the text rich
	 * @return the text rich, or <code>null</code> if a text rich with the primary key could not be found
	 */
	@Override
	public TextRich fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
				TextRichImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TextRich textRich = (TextRich)serializable;

		if (textRich == null) {
			Session session = null;

			try {
				session = openSession();

				textRich = (TextRich)session.get(TextRichImpl.class, primaryKey);

				if (textRich != null) {
					cacheResult(textRich);
				}
				else {
					entityCache.putResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
						TextRichImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
					TextRichImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return textRich;
	}

	/**
	 * Returns the text rich with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_text the primary key of the text rich
	 * @return the text rich, or <code>null</code> if a text rich with the primary key could not be found
	 */
	@Override
	public TextRich fetchByPrimaryKey(long id_text) {
		return fetchByPrimaryKey((Serializable)id_text);
	}

	@Override
	public Map<Serializable, TextRich> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TextRich> map = new HashMap<Serializable, TextRich>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TextRich textRich = fetchByPrimaryKey(primaryKey);

			if (textRich != null) {
				map.put(primaryKey, textRich);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
					TextRichImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TextRich)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TEXTRICH_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TextRich textRich : (List<TextRich>)q.list()) {
				map.put(textRich.getPrimaryKeyObj(), textRich);

				cacheResult(textRich);

				uncachedPrimaryKeys.remove(textRich.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TextRichModelImpl.ENTITY_CACHE_ENABLED,
					TextRichImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the text richs.
	 *
	 * @return the text richs
	 */
	@Override
	public List<TextRich> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TextRich> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TextRich> findAll(int start, int end,
		OrderByComparator<TextRich> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TextRich> findAll(int start, int end,
		OrderByComparator<TextRich> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TextRich> list = null;

		if (retrieveFromCache) {
			list = (List<TextRich>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TEXTRICH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TEXTRICH;

				if (pagination) {
					sql = sql.concat(TextRichModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TextRich>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TextRich>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the text richs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TextRich textRich : findAll()) {
			remove(textRich);
		}
	}

	/**
	 * Returns the number of text richs.
	 *
	 * @return the number of text richs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TEXTRICH);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TextRichModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the text rich persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TextRichImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TEXTRICH = "SELECT textRich FROM TextRich textRich";
	private static final String _SQL_SELECT_TEXTRICH_WHERE_PKS_IN = "SELECT textRich FROM TextRich textRich WHERE id_text IN (";
	private static final String _SQL_SELECT_TEXTRICH_WHERE = "SELECT textRich FROM TextRich textRich WHERE ";
	private static final String _SQL_COUNT_TEXTRICH = "SELECT COUNT(textRich) FROM TextRich textRich";
	private static final String _SQL_COUNT_TEXTRICH_WHERE = "SELECT COUNT(textRich) FROM TextRich textRich WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "textRich.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TextRich exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TextRich exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TextRichPersistenceImpl.class);
}