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

package service.intranet.mef.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import service.intranet.mef.exception.NoSuchModuloTrasportiException;
import service.intranet.mef.model.ModuloTrasporti;
import service.intranet.mef.model.impl.ModuloTrasportiImpl;
import service.intranet.mef.model.impl.ModuloTrasportiModelImpl;
import service.intranet.mef.service.persistence.ModuloTrasportiPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the modulo trasporti service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ModuloTrasportiPersistence
 * @see service.intranet.mef.service.persistence.ModuloTrasportiUtil
 * @generated
 */
@ProviderType
public class ModuloTrasportiPersistenceImpl extends BasePersistenceImpl<ModuloTrasporti>
	implements ModuloTrasportiPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ModuloTrasportiUtil} to access the modulo trasporti persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ModuloTrasportiImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
			ModuloTrasportiModelImpl.FINDER_CACHE_ENABLED,
			ModuloTrasportiImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
			ModuloTrasportiModelImpl.FINDER_CACHE_ENABLED,
			ModuloTrasportiImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
			ModuloTrasportiModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ModuloTrasportiPersistenceImpl() {
		setModelClass(ModuloTrasporti.class);
	}

	/**
	 * Caches the modulo trasporti in the entity cache if it is enabled.
	 *
	 * @param moduloTrasporti the modulo trasporti
	 */
	@Override
	public void cacheResult(ModuloTrasporti moduloTrasporti) {
		entityCache.putResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
			ModuloTrasportiImpl.class, moduloTrasporti.getPrimaryKey(),
			moduloTrasporti);

		moduloTrasporti.resetOriginalValues();
	}

	/**
	 * Caches the modulo trasportis in the entity cache if it is enabled.
	 *
	 * @param moduloTrasportis the modulo trasportis
	 */
	@Override
	public void cacheResult(List<ModuloTrasporti> moduloTrasportis) {
		for (ModuloTrasporti moduloTrasporti : moduloTrasportis) {
			if (entityCache.getResult(
						ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
						ModuloTrasportiImpl.class,
						moduloTrasporti.getPrimaryKey()) == null) {
				cacheResult(moduloTrasporti);
			}
			else {
				moduloTrasporti.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all modulo trasportis.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ModuloTrasportiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the modulo trasporti.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ModuloTrasporti moduloTrasporti) {
		entityCache.removeResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
			ModuloTrasportiImpl.class, moduloTrasporti.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ModuloTrasporti> moduloTrasportis) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ModuloTrasporti moduloTrasporti : moduloTrasportis) {
			entityCache.removeResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
				ModuloTrasportiImpl.class, moduloTrasporti.getPrimaryKey());
		}
	}

	/**
	 * Creates a new modulo trasporti with the primary key. Does not add the modulo trasporti to the database.
	 *
	 * @param id_modulo_trasporti the primary key for the new modulo trasporti
	 * @return the new modulo trasporti
	 */
	@Override
	public ModuloTrasporti create(long id_modulo_trasporti) {
		ModuloTrasporti moduloTrasporti = new ModuloTrasportiImpl();

		moduloTrasporti.setNew(true);
		moduloTrasporti.setPrimaryKey(id_modulo_trasporti);

		return moduloTrasporti;
	}

	/**
	 * Removes the modulo trasporti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_modulo_trasporti the primary key of the modulo trasporti
	 * @return the modulo trasporti that was removed
	 * @throws NoSuchModuloTrasportiException if a modulo trasporti with the primary key could not be found
	 */
	@Override
	public ModuloTrasporti remove(long id_modulo_trasporti)
		throws NoSuchModuloTrasportiException {
		return remove((Serializable)id_modulo_trasporti);
	}

	/**
	 * Removes the modulo trasporti with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the modulo trasporti
	 * @return the modulo trasporti that was removed
	 * @throws NoSuchModuloTrasportiException if a modulo trasporti with the primary key could not be found
	 */
	@Override
	public ModuloTrasporti remove(Serializable primaryKey)
		throws NoSuchModuloTrasportiException {
		Session session = null;

		try {
			session = openSession();

			ModuloTrasporti moduloTrasporti = (ModuloTrasporti)session.get(ModuloTrasportiImpl.class,
					primaryKey);

			if (moduloTrasporti == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchModuloTrasportiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(moduloTrasporti);
		}
		catch (NoSuchModuloTrasportiException nsee) {
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
	protected ModuloTrasporti removeImpl(ModuloTrasporti moduloTrasporti) {
		moduloTrasporti = toUnwrappedModel(moduloTrasporti);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(moduloTrasporti)) {
				moduloTrasporti = (ModuloTrasporti)session.get(ModuloTrasportiImpl.class,
						moduloTrasporti.getPrimaryKeyObj());
			}

			if (moduloTrasporti != null) {
				session.delete(moduloTrasporti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (moduloTrasporti != null) {
			clearCache(moduloTrasporti);
		}

		return moduloTrasporti;
	}

	@Override
	public ModuloTrasporti updateImpl(ModuloTrasporti moduloTrasporti) {
		moduloTrasporti = toUnwrappedModel(moduloTrasporti);

		boolean isNew = moduloTrasporti.isNew();

		Session session = null;

		try {
			session = openSession();

			if (moduloTrasporti.isNew()) {
				session.save(moduloTrasporti);

				moduloTrasporti.setNew(false);
			}
			else {
				moduloTrasporti = (ModuloTrasporti)session.merge(moduloTrasporti);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
			ModuloTrasportiImpl.class, moduloTrasporti.getPrimaryKey(),
			moduloTrasporti, false);

		moduloTrasporti.resetOriginalValues();

		return moduloTrasporti;
	}

	protected ModuloTrasporti toUnwrappedModel(ModuloTrasporti moduloTrasporti) {
		if (moduloTrasporti instanceof ModuloTrasportiImpl) {
			return moduloTrasporti;
		}

		ModuloTrasportiImpl moduloTrasportiImpl = new ModuloTrasportiImpl();

		moduloTrasportiImpl.setNew(moduloTrasporti.isNew());
		moduloTrasportiImpl.setPrimaryKey(moduloTrasporti.getPrimaryKey());

		moduloTrasportiImpl.setId_modulo_trasporti(moduloTrasporti.getId_modulo_trasporti());
		moduloTrasportiImpl.setCognome(moduloTrasporti.getCognome());
		moduloTrasportiImpl.setNome(moduloTrasporti.getNome());
		moduloTrasportiImpl.setCodice_fiscale(moduloTrasporti.getCodice_fiscale());
		moduloTrasportiImpl.setUtente_inserimento(moduloTrasporti.getUtente_inserimento());
		moduloTrasportiImpl.setData_inserimento(moduloTrasporti.getData_inserimento());
		moduloTrasportiImpl.setFlag_tipospesa(moduloTrasporti.getFlag_tipospesa());
		moduloTrasportiImpl.setIban(moduloTrasporti.getIban());
		moduloTrasportiImpl.setImporto(moduloTrasporti.getImporto());
		moduloTrasportiImpl.setData_titolo_annuale(moduloTrasporti.getData_titolo_annuale());
		moduloTrasportiImpl.setNr_titoli_mensili(moduloTrasporti.getNr_titoli_mensili());
		moduloTrasportiImpl.setFiglio_nome(moduloTrasporti.getFiglio_nome());
		moduloTrasportiImpl.setFiglio_cognome(moduloTrasporti.getFiglio_cognome());
		moduloTrasportiImpl.setFiglio_data_nascita(moduloTrasporti.getFiglio_data_nascita());
		moduloTrasportiImpl.setFiglio_luogo_data(moduloTrasporti.getFiglio_luogo_data());
		moduloTrasportiImpl.setFiglio_codicefiscale(moduloTrasporti.getFiglio_codicefiscale());
		moduloTrasportiImpl.setNote(moduloTrasporti.getNote());
		moduloTrasportiImpl.setFlag_inviato(moduloTrasporti.getFlag_inviato());
		moduloTrasportiImpl.setTelefono(moduloTrasporti.getTelefono());
		moduloTrasportiImpl.setAllegatoUuid(moduloTrasporti.getAllegatoUuid());

		return moduloTrasportiImpl;
	}

	/**
	 * Returns the modulo trasporti with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the modulo trasporti
	 * @return the modulo trasporti
	 * @throws NoSuchModuloTrasportiException if a modulo trasporti with the primary key could not be found
	 */
	@Override
	public ModuloTrasporti findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModuloTrasportiException {
		ModuloTrasporti moduloTrasporti = fetchByPrimaryKey(primaryKey);

		if (moduloTrasporti == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchModuloTrasportiException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return moduloTrasporti;
	}

	/**
	 * Returns the modulo trasporti with the primary key or throws a {@link NoSuchModuloTrasportiException} if it could not be found.
	 *
	 * @param id_modulo_trasporti the primary key of the modulo trasporti
	 * @return the modulo trasporti
	 * @throws NoSuchModuloTrasportiException if a modulo trasporti with the primary key could not be found
	 */
	@Override
	public ModuloTrasporti findByPrimaryKey(long id_modulo_trasporti)
		throws NoSuchModuloTrasportiException {
		return findByPrimaryKey((Serializable)id_modulo_trasporti);
	}

	/**
	 * Returns the modulo trasporti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the modulo trasporti
	 * @return the modulo trasporti, or <code>null</code> if a modulo trasporti with the primary key could not be found
	 */
	@Override
	public ModuloTrasporti fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
				ModuloTrasportiImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ModuloTrasporti moduloTrasporti = (ModuloTrasporti)serializable;

		if (moduloTrasporti == null) {
			Session session = null;

			try {
				session = openSession();

				moduloTrasporti = (ModuloTrasporti)session.get(ModuloTrasportiImpl.class,
						primaryKey);

				if (moduloTrasporti != null) {
					cacheResult(moduloTrasporti);
				}
				else {
					entityCache.putResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
						ModuloTrasportiImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
					ModuloTrasportiImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return moduloTrasporti;
	}

	/**
	 * Returns the modulo trasporti with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_modulo_trasporti the primary key of the modulo trasporti
	 * @return the modulo trasporti, or <code>null</code> if a modulo trasporti with the primary key could not be found
	 */
	@Override
	public ModuloTrasporti fetchByPrimaryKey(long id_modulo_trasporti) {
		return fetchByPrimaryKey((Serializable)id_modulo_trasporti);
	}

	@Override
	public Map<Serializable, ModuloTrasporti> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ModuloTrasporti> map = new HashMap<Serializable, ModuloTrasporti>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ModuloTrasporti moduloTrasporti = fetchByPrimaryKey(primaryKey);

			if (moduloTrasporti != null) {
				map.put(primaryKey, moduloTrasporti);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
					ModuloTrasportiImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ModuloTrasporti)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MODULOTRASPORTI_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ModuloTrasporti moduloTrasporti : (List<ModuloTrasporti>)q.list()) {
				map.put(moduloTrasporti.getPrimaryKeyObj(), moduloTrasporti);

				cacheResult(moduloTrasporti);

				uncachedPrimaryKeys.remove(moduloTrasporti.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ModuloTrasportiModelImpl.ENTITY_CACHE_ENABLED,
					ModuloTrasportiImpl.class, primaryKey, nullModel);
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
	 * Returns all the modulo trasportis.
	 *
	 * @return the modulo trasportis
	 */
	@Override
	public List<ModuloTrasporti> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the modulo trasportis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of modulo trasportis
	 * @param end the upper bound of the range of modulo trasportis (not inclusive)
	 * @return the range of modulo trasportis
	 */
	@Override
	public List<ModuloTrasporti> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the modulo trasportis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of modulo trasportis
	 * @param end the upper bound of the range of modulo trasportis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of modulo trasportis
	 */
	@Override
	public List<ModuloTrasporti> findAll(int start, int end,
		OrderByComparator<ModuloTrasporti> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the modulo trasportis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ModuloTrasportiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of modulo trasportis
	 * @param end the upper bound of the range of modulo trasportis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of modulo trasportis
	 */
	@Override
	public List<ModuloTrasporti> findAll(int start, int end,
		OrderByComparator<ModuloTrasporti> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ModuloTrasporti> list = null;

		if (retrieveFromCache) {
			list = (List<ModuloTrasporti>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MODULOTRASPORTI);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MODULOTRASPORTI;

				if (pagination) {
					sql = sql.concat(ModuloTrasportiModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ModuloTrasporti>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ModuloTrasporti>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the modulo trasportis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ModuloTrasporti moduloTrasporti : findAll()) {
			remove(moduloTrasporti);
		}
	}

	/**
	 * Returns the number of modulo trasportis.
	 *
	 * @return the number of modulo trasportis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MODULOTRASPORTI);

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
		return ModuloTrasportiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the modulo trasporti persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ModuloTrasportiImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MODULOTRASPORTI = "SELECT moduloTrasporti FROM ModuloTrasporti moduloTrasporti";
	private static final String _SQL_SELECT_MODULOTRASPORTI_WHERE_PKS_IN = "SELECT moduloTrasporti FROM ModuloTrasporti moduloTrasporti WHERE id_modulo_trasporti IN (";
	private static final String _SQL_COUNT_MODULOTRASPORTI = "SELECT COUNT(moduloTrasporti) FROM ModuloTrasporti moduloTrasporti";
	private static final String _ORDER_BY_ENTITY_ALIAS = "moduloTrasporti.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ModuloTrasporti exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ModuloTrasportiPersistenceImpl.class);
}