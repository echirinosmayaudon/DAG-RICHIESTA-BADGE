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

package bookmarks.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Favourites}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Favourites
 * @generated
 */
@ProviderType
public class FavouritesWrapper implements Favourites, ModelWrapper<Favourites> {
	public FavouritesWrapper(Favourites favourites) {
		_favourites = favourites;
	}

	@Override
	public Class<?> getModelClass() {
		return Favourites.class;
	}

	@Override
	public String getModelClassName() {
		return Favourites.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("favourite_id", getFavourite_id());
		attributes.put("user_id", getUser_id());
		attributes.put("title_favourite", getTitle_favourite());
		attributes.put("description_favourite", getDescription_favourite());
		attributes.put("tag_favourite", getTag_favourite());
		attributes.put("url_favourite", getUrl_favourite());
		attributes.put("save_date", getSave_date());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long favourite_id = (Long)attributes.get("favourite_id");

		if (favourite_id != null) {
			setFavourite_id(favourite_id);
		}

		Long user_id = (Long)attributes.get("user_id");

		if (user_id != null) {
			setUser_id(user_id);
		}

		String title_favourite = (String)attributes.get("title_favourite");

		if (title_favourite != null) {
			setTitle_favourite(title_favourite);
		}

		String description_favourite = (String)attributes.get(
				"description_favourite");

		if (description_favourite != null) {
			setDescription_favourite(description_favourite);
		}

		String tag_favourite = (String)attributes.get("tag_favourite");

		if (tag_favourite != null) {
			setTag_favourite(tag_favourite);
		}

		String url_favourite = (String)attributes.get("url_favourite");

		if (url_favourite != null) {
			setUrl_favourite(url_favourite);
		}

		String save_date = (String)attributes.get("save_date");

		if (save_date != null) {
			setSave_date(save_date);
		}
	}

	@Override
	public bookmarks.model.Favourites toEscapedModel() {
		return new FavouritesWrapper(_favourites.toEscapedModel());
	}

	@Override
	public bookmarks.model.Favourites toUnescapedModel() {
		return new FavouritesWrapper(_favourites.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _favourites.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _favourites.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _favourites.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _favourites.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<bookmarks.model.Favourites> toCacheModel() {
		return _favourites.toCacheModel();
	}

	@Override
	public int compareTo(bookmarks.model.Favourites favourites) {
		return _favourites.compareTo(favourites);
	}

	@Override
	public int hashCode() {
		return _favourites.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _favourites.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FavouritesWrapper((Favourites)_favourites.clone());
	}

	/**
	* Returns the description_favourite of this favourites.
	*
	* @return the description_favourite of this favourites
	*/
	@Override
	public java.lang.String getDescription_favourite() {
		return _favourites.getDescription_favourite();
	}

	/**
	* Returns the save_date of this favourites.
	*
	* @return the save_date of this favourites
	*/
	@Override
	public java.lang.String getSave_date() {
		return _favourites.getSave_date();
	}

	/**
	* Returns the tag_favourite of this favourites.
	*
	* @return the tag_favourite of this favourites
	*/
	@Override
	public java.lang.String getTag_favourite() {
		return _favourites.getTag_favourite();
	}

	/**
	* Returns the title_favourite of this favourites.
	*
	* @return the title_favourite of this favourites
	*/
	@Override
	public java.lang.String getTitle_favourite() {
		return _favourites.getTitle_favourite();
	}

	/**
	* Returns the url_favourite of this favourites.
	*
	* @return the url_favourite of this favourites
	*/
	@Override
	public java.lang.String getUrl_favourite() {
		return _favourites.getUrl_favourite();
	}

	@Override
	public java.lang.String toString() {
		return _favourites.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _favourites.toXmlString();
	}

	/**
	* Returns the favourite_id of this favourites.
	*
	* @return the favourite_id of this favourites
	*/
	@Override
	public long getFavourite_id() {
		return _favourites.getFavourite_id();
	}

	/**
	* Returns the primary key of this favourites.
	*
	* @return the primary key of this favourites
	*/
	@Override
	public long getPrimaryKey() {
		return _favourites.getPrimaryKey();
	}

	/**
	* Returns the user_id of this favourites.
	*
	* @return the user_id of this favourites
	*/
	@Override
	public long getUser_id() {
		return _favourites.getUser_id();
	}

	@Override
	public void persist() {
		_favourites.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_favourites.setCachedModel(cachedModel);
	}

	/**
	* Sets the description_favourite of this favourites.
	*
	* @param description_favourite the description_favourite of this favourites
	*/
	@Override
	public void setDescription_favourite(java.lang.String description_favourite) {
		_favourites.setDescription_favourite(description_favourite);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_favourites.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_favourites.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_favourites.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the favourite_id of this favourites.
	*
	* @param favourite_id the favourite_id of this favourites
	*/
	@Override
	public void setFavourite_id(long favourite_id) {
		_favourites.setFavourite_id(favourite_id);
	}

	@Override
	public void setNew(boolean n) {
		_favourites.setNew(n);
	}

	/**
	* Sets the primary key of this favourites.
	*
	* @param primaryKey the primary key of this favourites
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_favourites.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_favourites.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the save_date of this favourites.
	*
	* @param save_date the save_date of this favourites
	*/
	@Override
	public void setSave_date(java.lang.String save_date) {
		_favourites.setSave_date(save_date);
	}

	/**
	* Sets the tag_favourite of this favourites.
	*
	* @param tag_favourite the tag_favourite of this favourites
	*/
	@Override
	public void setTag_favourite(java.lang.String tag_favourite) {
		_favourites.setTag_favourite(tag_favourite);
	}

	/**
	* Sets the title_favourite of this favourites.
	*
	* @param title_favourite the title_favourite of this favourites
	*/
	@Override
	public void setTitle_favourite(java.lang.String title_favourite) {
		_favourites.setTitle_favourite(title_favourite);
	}

	/**
	* Sets the url_favourite of this favourites.
	*
	* @param url_favourite the url_favourite of this favourites
	*/
	@Override
	public void setUrl_favourite(java.lang.String url_favourite) {
		_favourites.setUrl_favourite(url_favourite);
	}

	/**
	* Sets the user_id of this favourites.
	*
	* @param user_id the user_id of this favourites
	*/
	@Override
	public void setUser_id(long user_id) {
		_favourites.setUser_id(user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FavouritesWrapper)) {
			return false;
		}

		FavouritesWrapper favouritesWrapper = (FavouritesWrapper)obj;

		if (Objects.equals(_favourites, favouritesWrapper._favourites)) {
			return true;
		}

		return false;
	}

	@Override
	public Favourites getWrappedModel() {
		return _favourites;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _favourites.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _favourites.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_favourites.resetOriginalValues();
	}

	private final Favourites _favourites;
}