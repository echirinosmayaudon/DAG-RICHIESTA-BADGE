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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link bookmarks.service.http.FavouritesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see bookmarks.service.http.FavouritesServiceSoap
 * @generated
 */
@ProviderType
public class FavouritesSoap implements Serializable {
	public static FavouritesSoap toSoapModel(Favourites model) {
		FavouritesSoap soapModel = new FavouritesSoap();

		soapModel.setFavourite_id(model.getFavourite_id());
		soapModel.setUser_id(model.getUser_id());
		soapModel.setTitle_favourite(model.getTitle_favourite());
		soapModel.setDescription_favourite(model.getDescription_favourite());
		soapModel.setTag_favourite(model.getTag_favourite());
		soapModel.setUrl_favourite(model.getUrl_favourite());
		soapModel.setSave_date(model.getSave_date());

		return soapModel;
	}

	public static FavouritesSoap[] toSoapModels(Favourites[] models) {
		FavouritesSoap[] soapModels = new FavouritesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FavouritesSoap[][] toSoapModels(Favourites[][] models) {
		FavouritesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FavouritesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FavouritesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FavouritesSoap[] toSoapModels(List<Favourites> models) {
		List<FavouritesSoap> soapModels = new ArrayList<FavouritesSoap>(models.size());

		for (Favourites model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FavouritesSoap[soapModels.size()]);
	}

	public FavouritesSoap() {
	}

	public long getPrimaryKey() {
		return _favourite_id;
	}

	public void setPrimaryKey(long pk) {
		setFavourite_id(pk);
	}

	public long getFavourite_id() {
		return _favourite_id;
	}

	public void setFavourite_id(long favourite_id) {
		_favourite_id = favourite_id;
	}

	public long getUser_id() {
		return _user_id;
	}

	public void setUser_id(long user_id) {
		_user_id = user_id;
	}

	public String getTitle_favourite() {
		return _title_favourite;
	}

	public void setTitle_favourite(String title_favourite) {
		_title_favourite = title_favourite;
	}

	public String getDescription_favourite() {
		return _description_favourite;
	}

	public void setDescription_favourite(String description_favourite) {
		_description_favourite = description_favourite;
	}

	public String getTag_favourite() {
		return _tag_favourite;
	}

	public void setTag_favourite(String tag_favourite) {
		_tag_favourite = tag_favourite;
	}

	public String getUrl_favourite() {
		return _url_favourite;
	}

	public void setUrl_favourite(String url_favourite) {
		_url_favourite = url_favourite;
	}

	public String getSave_date() {
		return _save_date;
	}

	public void setSave_date(String save_date) {
		_save_date = save_date;
	}

	private long _favourite_id;
	private long _user_id;
	private String _title_favourite;
	private String _description_favourite;
	private String _tag_favourite;
	private String _url_favourite;
	private String _save_date;
}