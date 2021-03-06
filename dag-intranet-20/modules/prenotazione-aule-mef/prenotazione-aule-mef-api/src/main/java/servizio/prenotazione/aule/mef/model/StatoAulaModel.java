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
 * The base model interface for the StatoAula service. Represents a row in the &quot;MEFAULE_StatoAula&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link servizio.prenotazione.aule.mef.model.impl.StatoAulaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatoAula
 * @see servizio.prenotazione.aule.mef.model.impl.StatoAulaImpl
 * @see servizio.prenotazione.aule.mef.model.impl.StatoAulaModelImpl
 * @generated
 */
@ProviderType
public interface StatoAulaModel extends BaseModel<StatoAula> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a stato aula model instance should use the {@link StatoAula} interface instead.
	 */

	/**
	 * Returns the primary key of this stato aula.
	 *
	 * @return the primary key of this stato aula
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this stato aula.
	 *
	 * @param primaryKey the primary key of this stato aula
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_stato_aula of this stato aula.
	 *
	 * @return the id_stato_aula of this stato aula
	 */
	public long getId_stato_aula();

	/**
	 * Sets the id_stato_aula of this stato aula.
	 *
	 * @param id_stato_aula the id_stato_aula of this stato aula
	 */
	public void setId_stato_aula(long id_stato_aula);

	/**
	 * Returns the desc_stato of this stato aula.
	 *
	 * @return the desc_stato of this stato aula
	 */
	@AutoEscape
	public String getDesc_stato();

	/**
	 * Sets the desc_stato of this stato aula.
	 *
	 * @param desc_stato the desc_stato of this stato aula
	 */
	public void setDesc_stato(String desc_stato);

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
		servizio.prenotazione.aule.mef.model.StatoAula statoAula);

	@Override
	public int hashCode();

	@Override
	public CacheModel<servizio.prenotazione.aule.mef.model.StatoAula> toCacheModel();

	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula toEscapedModel();

	@Override
	public servizio.prenotazione.aule.mef.model.StatoAula toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}