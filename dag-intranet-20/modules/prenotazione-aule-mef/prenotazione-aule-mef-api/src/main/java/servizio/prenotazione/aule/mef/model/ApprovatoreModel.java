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

package servizio.prenotazione.aule.mef.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Approvatore service. Represents a row in the &quot;MEFAULE_Approvatore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.prenotazione.aule.mef.model.impl.ApprovatoreModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.prenotazione.aule.mef.model.impl.ApprovatoreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Approvatore
 * @see servizio.prenotazione.aule.mef.model.impl.ApprovatoreImpl
 * @see servizio.prenotazione.aule.mef.model.impl.ApprovatoreModelImpl
 * @generated
 */
@ProviderType
public interface ApprovatoreModel extends BaseModel<Approvatore> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a approvatore model instance should use the {@link Approvatore} interface instead.
	 */

	/**
	 * Returns the primary key of this approvatore.
	 *
	 * @return the primary key of this approvatore
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this approvatore.
	 *
	 * @param primaryKey the primary key of this approvatore
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_approvatore of this approvatore.
	 *
	 * @return the id_approvatore of this approvatore
	 */
	public long getId_approvatore();

	/**
	 * Sets the id_approvatore of this approvatore.
	 *
	 * @param id_approvatore the id_approvatore of this approvatore
	 */
	public void setId_approvatore(long id_approvatore);

	/**
	 * Returns the id_sala of this approvatore.
	 *
	 * @return the id_sala of this approvatore
	 */
	public long getId_sala();

	/**
	 * Sets the id_sala of this approvatore.
	 *
	 * @param id_sala the id_sala of this approvatore
	 */
	public void setId_sala(long id_sala);

	/**
	 * Returns the email_approvatore of this approvatore.
	 *
	 * @return the email_approvatore of this approvatore
	 */
	@AutoEscape
	public String getEmail_approvatore();

	/**
	 * Sets the email_approvatore of this approvatore.
	 *
	 * @param email_approvatore the email_approvatore of this approvatore
	 */
	public void setEmail_approvatore(String email_approvatore);

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
	public int compareTo(
		servizio.prenotazione.aule.mef.model.Approvatore approvatore);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.prenotazione.aule.mef.model.Approvatore> toCacheModel();

	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore toEscapedModel();

	@Override
	public servizio.prenotazione.aule.mef.model.Approvatore toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}