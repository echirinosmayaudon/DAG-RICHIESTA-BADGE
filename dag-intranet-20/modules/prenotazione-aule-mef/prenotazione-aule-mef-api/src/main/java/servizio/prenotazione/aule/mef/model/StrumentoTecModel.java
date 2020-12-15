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
 * The base model interface for the StrumentoTec service. Represents a row in the &quot;MEFAULE_StrumentoTec&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.prenotazione.aule.mef.model.impl.StrumentoTecImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTec
 * @see servizio.prenotazione.aule.mef.model.impl.StrumentoTecImpl
 * @see servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl
 * @generated
 */
@ProviderType
public interface StrumentoTecModel extends BaseModel<StrumentoTec> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a strumento tec model instance should use the {@link StrumentoTec} interface instead.
	 */

	/**
	 * Returns the primary key of this strumento tec.
	 *
	 * @return the primary key of this strumento tec
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this strumento tec.
	 *
	 * @param primaryKey the primary key of this strumento tec
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_strumento of this strumento tec.
	 *
	 * @return the id_strumento of this strumento tec
	 */
	public long getId_strumento();

	/**
	 * Sets the id_strumento of this strumento tec.
	 *
	 * @param id_strumento the id_strumento of this strumento tec
	 */
	public void setId_strumento(long id_strumento);

	/**
	 * Returns the desc_strumento of this strumento tec.
	 *
	 * @return the desc_strumento of this strumento tec
	 */
	@AutoEscape
	public String getDesc_strumento();

	/**
	 * Sets the desc_strumento of this strumento tec.
	 *
	 * @param desc_strumento the desc_strumento of this strumento tec
	 */
	public void setDesc_strumento(String desc_strumento);

	/**
	 * Returns the email_ref of this strumento tec.
	 *
	 * @return the email_ref of this strumento tec
	 */
	@AutoEscape
	public String getEmail_ref();

	/**
	 * Sets the email_ref of this strumento tec.
	 *
	 * @param email_ref the email_ref of this strumento tec
	 */
	public void setEmail_ref(String email_ref);

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
		servizio.prenotazione.aule.mef.model.StrumentoTec strumentoTec);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.prenotazione.aule.mef.model.StrumentoTec> toCacheModel();

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec toEscapedModel();

	@Override
	public servizio.prenotazione.aule.mef.model.StrumentoTec toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}