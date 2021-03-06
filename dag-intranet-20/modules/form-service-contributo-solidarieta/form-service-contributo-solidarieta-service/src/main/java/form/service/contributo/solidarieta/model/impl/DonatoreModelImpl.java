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

package form.service.contributo.solidarieta.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import form.service.contributo.solidarieta.model.Donatore;
import form.service.contributo.solidarieta.model.DonatoreModel;
import form.service.contributo.solidarieta.model.DonatoreSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Donatore service. Represents a row in the &quot;CNTB_SOLID_DONATORE_Donatore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DonatoreModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DonatoreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonatoreImpl
 * @generated
 */
@JSON(strict = true)
public class DonatoreModelImpl
	extends BaseModelImpl<Donatore> implements DonatoreModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a donatore model instance should use the <code>Donatore</code> interface instead.
	 */
	public static final String TABLE_NAME = "CNTB_SOLID_DONATORE_Donatore";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"nome", Types.VARCHAR},
		{"cognome", Types.VARCHAR}, {"cod_fiscale", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"importo", Types.VARCHAR},
		{"data_inserimento", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cognome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cod_fiscale", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("importo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("data_inserimento", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CNTB_SOLID_DONATORE_Donatore (id_ LONG not null primary key,nome VARCHAR(75) null,cognome VARCHAR(75) null,cod_fiscale VARCHAR(75) null,email VARCHAR(75) null,importo VARCHAR(75) null,data_inserimento VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table CNTB_SOLID_DONATORE_Donatore";

	public static final String ORDER_BY_JPQL = " ORDER BY donatore.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CNTB_SOLID_DONATORE_Donatore.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		form.service.contributo.solidarieta.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.form.service.contributo.solidarieta.model.Donatore"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		form.service.contributo.solidarieta.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.form.service.contributo.solidarieta.model.Donatore"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Donatore toModel(DonatoreSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Donatore model = new DonatoreImpl();

		model.setId(soapModel.getId());
		model.setNome(soapModel.getNome());
		model.setCognome(soapModel.getCognome());
		model.setCod_fiscale(soapModel.getCod_fiscale());
		model.setEmail(soapModel.getEmail());
		model.setImporto(soapModel.getImporto());
		model.setData_inserimento(soapModel.getData_inserimento());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Donatore> toModels(DonatoreSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Donatore> models = new ArrayList<Donatore>(soapModels.length);

		for (DonatoreSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		form.service.contributo.solidarieta.service.util.ServiceProps.get(
			"lock.expiration.time.form.service.contributo.solidarieta.model.Donatore"));

	public DonatoreModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Donatore.class;
	}

	@Override
	public String getModelClassName() {
		return Donatore.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Donatore, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Donatore, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Donatore, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Donatore)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Donatore, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Donatore, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Donatore)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Donatore, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Donatore, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Donatore>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Donatore.class.getClassLoader(), Donatore.class,
			ModelWrapper.class);

		try {
			Constructor<Donatore> constructor =
				(Constructor<Donatore>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Donatore, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Donatore, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Donatore, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Donatore, Object>>();
		Map<String, BiConsumer<Donatore, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Donatore, ?>>();

		attributeGetterFunctions.put(
			"id",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(Donatore donatore, Object idObject) {
					donatore.setId((Long)idObject);
				}

			});
		attributeGetterFunctions.put(
			"nome",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getNome();
				}

			});
		attributeSetterBiConsumers.put(
			"nome",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(Donatore donatore, Object nomeObject) {
					donatore.setNome((String)nomeObject);
				}

			});
		attributeGetterFunctions.put(
			"cognome",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getCognome();
				}

			});
		attributeSetterBiConsumers.put(
			"cognome",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(Donatore donatore, Object cognomeObject) {
					donatore.setCognome((String)cognomeObject);
				}

			});
		attributeGetterFunctions.put(
			"cod_fiscale",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getCod_fiscale();
				}

			});
		attributeSetterBiConsumers.put(
			"cod_fiscale",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(
					Donatore donatore, Object cod_fiscaleObject) {

					donatore.setCod_fiscale((String)cod_fiscaleObject);
				}

			});
		attributeGetterFunctions.put(
			"email",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getEmail();
				}

			});
		attributeSetterBiConsumers.put(
			"email",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(Donatore donatore, Object emailObject) {
					donatore.setEmail((String)emailObject);
				}

			});
		attributeGetterFunctions.put(
			"importo",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getImporto();
				}

			});
		attributeSetterBiConsumers.put(
			"importo",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(Donatore donatore, Object importoObject) {
					donatore.setImporto((String)importoObject);
				}

			});
		attributeGetterFunctions.put(
			"data_inserimento",
			new Function<Donatore, Object>() {

				@Override
				public Object apply(Donatore donatore) {
					return donatore.getData_inserimento();
				}

			});
		attributeSetterBiConsumers.put(
			"data_inserimento",
			new BiConsumer<Donatore, Object>() {

				@Override
				public void accept(
					Donatore donatore, Object data_inserimentoObject) {

					donatore.setData_inserimento(
						(String)data_inserimentoObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@JSON
	@Override
	public String getNome() {
		if (_nome == null) {
			return "";
		}
		else {
			return _nome;
		}
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;
	}

	@JSON
	@Override
	public String getCognome() {
		if (_cognome == null) {
			return "";
		}
		else {
			return _cognome;
		}
	}

	@Override
	public void setCognome(String cognome) {
		_cognome = cognome;
	}

	@JSON
	@Override
	public String getCod_fiscale() {
		if (_cod_fiscale == null) {
			return "";
		}
		else {
			return _cod_fiscale;
		}
	}

	@Override
	public void setCod_fiscale(String cod_fiscale) {
		_cod_fiscale = cod_fiscale;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getImporto() {
		if (_importo == null) {
			return "";
		}
		else {
			return _importo;
		}
	}

	@Override
	public void setImporto(String importo) {
		_importo = importo;
	}

	@JSON
	@Override
	public String getData_inserimento() {
		if (_data_inserimento == null) {
			return "";
		}
		else {
			return _data_inserimento;
		}
	}

	@Override
	public void setData_inserimento(String data_inserimento) {
		_data_inserimento = data_inserimento;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Donatore.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Donatore toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Donatore>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DonatoreImpl donatoreImpl = new DonatoreImpl();

		donatoreImpl.setId(getId());
		donatoreImpl.setNome(getNome());
		donatoreImpl.setCognome(getCognome());
		donatoreImpl.setCod_fiscale(getCod_fiscale());
		donatoreImpl.setEmail(getEmail());
		donatoreImpl.setImporto(getImporto());
		donatoreImpl.setData_inserimento(getData_inserimento());

		donatoreImpl.resetOriginalValues();

		return donatoreImpl;
	}

	@Override
	public int compareTo(Donatore donatore) {
		long primaryKey = donatore.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Donatore)) {
			return false;
		}

		Donatore donatore = (Donatore)obj;

		long primaryKey = donatore.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Donatore> toCacheModel() {
		DonatoreCacheModel donatoreCacheModel = new DonatoreCacheModel();

		donatoreCacheModel.id = getId();

		donatoreCacheModel.nome = getNome();

		String nome = donatoreCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			donatoreCacheModel.nome = null;
		}

		donatoreCacheModel.cognome = getCognome();

		String cognome = donatoreCacheModel.cognome;

		if ((cognome != null) && (cognome.length() == 0)) {
			donatoreCacheModel.cognome = null;
		}

		donatoreCacheModel.cod_fiscale = getCod_fiscale();

		String cod_fiscale = donatoreCacheModel.cod_fiscale;

		if ((cod_fiscale != null) && (cod_fiscale.length() == 0)) {
			donatoreCacheModel.cod_fiscale = null;
		}

		donatoreCacheModel.email = getEmail();

		String email = donatoreCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			donatoreCacheModel.email = null;
		}

		donatoreCacheModel.importo = getImporto();

		String importo = donatoreCacheModel.importo;

		if ((importo != null) && (importo.length() == 0)) {
			donatoreCacheModel.importo = null;
		}

		donatoreCacheModel.data_inserimento = getData_inserimento();

		String data_inserimento = donatoreCacheModel.data_inserimento;

		if ((data_inserimento != null) && (data_inserimento.length() == 0)) {
			donatoreCacheModel.data_inserimento = null;
		}

		return donatoreCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Donatore, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Donatore, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Donatore, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Donatore)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Donatore, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Donatore, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Donatore, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Donatore)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Donatore>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _id;
	private String _nome;
	private String _cognome;
	private String _cod_fiscale;
	private String _email;
	private String _importo;
	private String _data_inserimento;
	private Donatore _escapedModel;

}