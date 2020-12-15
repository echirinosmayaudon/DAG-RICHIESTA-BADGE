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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Favourites service. Represents a row in the &quot;MEFINTRANET_Favourites&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FavouritesModel
 * @see bookmarks.model.impl.FavouritesImpl
 * @see bookmarks.model.impl.FavouritesModelImpl
 * @generated
 */
@ImplementationClassName("bookmarks.model.impl.FavouritesImpl")
@ProviderType
public interface Favourites extends FavouritesModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link bookmarks.model.impl.FavouritesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Favourites, Long> FAVOURITE_ID_ACCESSOR = new Accessor<Favourites, Long>() {
			@Override
			public Long get(Favourites favourites) {
				return favourites.getFavourite_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Favourites> getTypeClass() {
				return Favourites.class;
			}
		};
}