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

package bookmarks.model.impl;

import aQute.bnd.annotation.ProviderType;

import bookmarks.model.Favourites;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Favourites in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Favourites
 * @generated
 */
@ProviderType
public class FavouritesCacheModel implements CacheModel<Favourites>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FavouritesCacheModel)) {
			return false;
		}

		FavouritesCacheModel favouritesCacheModel = (FavouritesCacheModel)obj;

		if (favourite_id == favouritesCacheModel.favourite_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, favourite_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{favourite_id=");
		sb.append(favourite_id);
		sb.append(", user_id=");
		sb.append(user_id);
		sb.append(", title_favourite=");
		sb.append(title_favourite);
		sb.append(", description_favourite=");
		sb.append(description_favourite);
		sb.append(", tag_favourite=");
		sb.append(tag_favourite);
		sb.append(", url_favourite=");
		sb.append(url_favourite);
		sb.append(", save_date=");
		sb.append(save_date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Favourites toEntityModel() {
		FavouritesImpl favouritesImpl = new FavouritesImpl();

		favouritesImpl.setFavourite_id(favourite_id);
		favouritesImpl.setUser_id(user_id);

		if (title_favourite == null) {
			favouritesImpl.setTitle_favourite(StringPool.BLANK);
		}
		else {
			favouritesImpl.setTitle_favourite(title_favourite);
		}

		if (description_favourite == null) {
			favouritesImpl.setDescription_favourite(StringPool.BLANK);
		}
		else {
			favouritesImpl.setDescription_favourite(description_favourite);
		}

		if (tag_favourite == null) {
			favouritesImpl.setTag_favourite(StringPool.BLANK);
		}
		else {
			favouritesImpl.setTag_favourite(tag_favourite);
		}

		if (url_favourite == null) {
			favouritesImpl.setUrl_favourite(StringPool.BLANK);
		}
		else {
			favouritesImpl.setUrl_favourite(url_favourite);
		}

		if (save_date == null) {
			favouritesImpl.setSave_date(StringPool.BLANK);
		}
		else {
			favouritesImpl.setSave_date(save_date);
		}

		favouritesImpl.resetOriginalValues();

		return favouritesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		favourite_id = objectInput.readLong();

		user_id = objectInput.readLong();
		title_favourite = objectInput.readUTF();
		description_favourite = objectInput.readUTF();
		tag_favourite = objectInput.readUTF();
		url_favourite = objectInput.readUTF();
		save_date = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(favourite_id);

		objectOutput.writeLong(user_id);

		if (title_favourite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title_favourite);
		}

		if (description_favourite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description_favourite);
		}

		if (tag_favourite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag_favourite);
		}

		if (url_favourite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url_favourite);
		}

		if (save_date == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(save_date);
		}
	}

	public long favourite_id;
	public long user_id;
	public String title_favourite;
	public String description_favourite;
	public String tag_favourite;
	public String url_favourite;
	public String save_date;
}