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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Favourites service. Represents a row in the &quot;MEFINTRANET_Favourites&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link bookmarks.model.impl.FavouritesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link bookmarks.model.impl.FavouritesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Favourites
 * @see bookmarks.model.impl.FavouritesImpl
 * @see bookmarks.model.impl.FavouritesModelImpl
 * @generated
 */
@ProviderType
public interface FavouritesModel extends BaseModel<Favourites> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a favourites model instance should use the {@link Favourites} interface instead.
	 */

	/**
	 * Returns the primary key of this favourites.
	 *
	 * @return the primary key of this favourites
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this favourites.
	 *
	 * @param primaryKey the primary key of this favourites
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the favourite_id of this favourites.
	 *
	 * @return the favourite_id of this favourites
	 */
	public long getFavourite_id();

	/**
	 * Sets the favourite_id of this favourites.
	 *
	 * @param favourite_id the favourite_id of this favourites
	 */
	public void setFavourite_id(long favourite_id);

	/**
	 * Returns the user_id of this favourites.
	 *
	 * @return the user_id of this favourites
	 */
	public long getUser_id();

	/**
	 * Sets the user_id of this favourites.
	 *
	 * @param user_id the user_id of this favourites
	 */
	public void setUser_id(long user_id);

	/**
	 * Returns the title_favourite of this favourites.
	 *
	 * @return the title_favourite of this favourites
	 */
	@AutoEscape
	public String getTitle_favourite();

	/**
	 * Sets the title_favourite of this favourites.
	 *
	 * @param title_favourite the title_favourite of this favourites
	 */
	public void setTitle_favourite(String title_favourite);

	/**
	 * Returns the description_favourite of this favourites.
	 *
	 * @return the description_favourite of this favourites
	 */
	@AutoEscape
	public String getDescription_favourite();

	/**
	 * Sets the description_favourite of this favourites.
	 *
	 * @param description_favourite the description_favourite of this favourites
	 */
	public void setDescription_favourite(String description_favourite);

	/**
	 * Returns the tag_favourite of this favourites.
	 *
	 * @return the tag_favourite of this favourites
	 */
	@AutoEscape
	public String getTag_favourite();

	/**
	 * Sets the tag_favourite of this favourites.
	 *
	 * @param tag_favourite the tag_favourite of this favourites
	 */
	public void setTag_favourite(String tag_favourite);

	/**
	 * Returns the url_favourite of this favourites.
	 *
	 * @return the url_favourite of this favourites
	 */
	@AutoEscape
	public String getUrl_favourite();

	/**
	 * Sets the url_favourite of this favourites.
	 *
	 * @param url_favourite the url_favourite of this favourites
	 */
	public void setUrl_favourite(String url_favourite);

	/**
	 * Returns the save_date of this favourites.
	 *
	 * @return the save_date of this favourites
	 */
	@AutoEscape
	public String getSave_date();

	/**
	 * Sets the save_date of this favourites.
	 *
	 * @param save_date the save_date of this favourites
	 */
	public void setSave_date(String save_date);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(bookmarks.model.Favourites favourites);

	@Override
	public int hashCode();

	@Override
	public CacheModel<bookmarks.model.Favourites> toCacheModel();

	@Override
	public bookmarks.model.Favourites toEscapedModel();

	@Override
	public bookmarks.model.Favourites toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}