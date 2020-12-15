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

package mef.richieste.figli.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mef.richieste.figli.exception.NoSuchRICHIESTA_RIMBORSOException;
import mef.richieste.figli.model.RICHIESTA_RIMBORSO;
import mef.richieste.figli.service.RICHIESTA_RIMBORSOLocalServiceUtil;
import mef.richieste.figli.service.persistence.RICHIESTA_RIMBORSOPersistence;
import mef.richieste.figli.service.persistence.RICHIESTA_RIMBORSOUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class RICHIESTA_RIMBORSOPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "mef.richieste.figli.service"));

	@Before
	public void setUp() {
		_persistence = RICHIESTA_RIMBORSOUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RICHIESTA_RIMBORSO> iterator = _richiesta_rimborsos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RICHIESTA_RIMBORSO richiesta_rimborso = _persistence.create(pk);

		Assert.assertNotNull(richiesta_rimborso);

		Assert.assertEquals(richiesta_rimborso.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		_persistence.remove(newRICHIESTA_RIMBORSO);

		RICHIESTA_RIMBORSO existingRICHIESTA_RIMBORSO =
			_persistence.fetchByPrimaryKey(
				newRICHIESTA_RIMBORSO.getPrimaryKey());

		Assert.assertNull(existingRICHIESTA_RIMBORSO);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRICHIESTA_RIMBORSO();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = _persistence.create(pk);

		newRICHIESTA_RIMBORSO.setNome_Richiedente(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setCognome_Richiedente(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setCodice_Fiscale_Richiedente(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setUtente_Inserimento(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setData_Inserimento(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setIban(RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setImporto(RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setFiglio_Nome(RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setFiglio_Cognome(RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setFiglio_Data_Nascita(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setFiglio_Luogo_Nascita(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setFiglio_Codice_Fiscale(
			RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setNote(RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setFlag_Inviato();

		newRICHIESTA_RIMBORSO.setTelefono(RandomTestUtil.randomString());

		newRICHIESTA_RIMBORSO.setAllegato_UUID(RandomTestUtil.randomString());

		_richiesta_rimborsos.add(_persistence.update(newRICHIESTA_RIMBORSO));

		RICHIESTA_RIMBORSO existingRICHIESTA_RIMBORSO =
			_persistence.findByPrimaryKey(
				newRICHIESTA_RIMBORSO.getPrimaryKey());

		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getId(), newRICHIESTA_RIMBORSO.getId());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getNome_Richiedente(),
			newRICHIESTA_RIMBORSO.getNome_Richiedente());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getCognome_Richiedente(),
			newRICHIESTA_RIMBORSO.getCognome_Richiedente());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getCodice_Fiscale_Richiedente(),
			newRICHIESTA_RIMBORSO.getCodice_Fiscale_Richiedente());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getUtente_Inserimento(),
			newRICHIESTA_RIMBORSO.getUtente_Inserimento());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getData_Inserimento(),
			newRICHIESTA_RIMBORSO.getData_Inserimento());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getIban(),
			newRICHIESTA_RIMBORSO.getIban());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getImporto(),
			newRICHIESTA_RIMBORSO.getImporto());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getFiglio_Nome(),
			newRICHIESTA_RIMBORSO.getFiglio_Nome());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getFiglio_Cognome(),
			newRICHIESTA_RIMBORSO.getFiglio_Cognome());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getFiglio_Data_Nascita(),
			newRICHIESTA_RIMBORSO.getFiglio_Data_Nascita());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getFiglio_Luogo_Nascita(),
			newRICHIESTA_RIMBORSO.getFiglio_Luogo_Nascita());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getFiglio_Codice_Fiscale(),
			newRICHIESTA_RIMBORSO.getFiglio_Codice_Fiscale());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getNote(),
			newRICHIESTA_RIMBORSO.getNote());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getFlag_Inviato(),
			newRICHIESTA_RIMBORSO.getFlag_Inviato());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getTelefono(),
			newRICHIESTA_RIMBORSO.getTelefono());
		Assert.assertEquals(
			existingRICHIESTA_RIMBORSO.getAllegato_UUID(),
			newRICHIESTA_RIMBORSO.getAllegato_UUID());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		RICHIESTA_RIMBORSO existingRICHIESTA_RIMBORSO =
			_persistence.findByPrimaryKey(
				newRICHIESTA_RIMBORSO.getPrimaryKey());

		Assert.assertEquals(existingRICHIESTA_RIMBORSO, newRICHIESTA_RIMBORSO);
	}

	@Test(expected = NoSuchRICHIESTA_RIMBORSOException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RICHIESTA_RIMBORSO> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"MFORM_RICHIESTA_RIMBORSO", "Id", true, "Nome_Richiedente", true,
			"Cognome_Richiedente", true, "Codice_Fiscale_Richiedente", true,
			"Utente_Inserimento", true, "Data_Inserimento", true, "Iban", true,
			"Importo", true, "Figlio_Nome", true, "Figlio_Cognome", true,
			"Figlio_Data_Nascita", true, "Figlio_Luogo_Nascita", true,
			"Figlio_Codice_Fiscale", true, "Note", true, "Flag_Inviato", true,
			"Telefono", true, "Allegato_UUID", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		RICHIESTA_RIMBORSO existingRICHIESTA_RIMBORSO =
			_persistence.fetchByPrimaryKey(
				newRICHIESTA_RIMBORSO.getPrimaryKey());

		Assert.assertEquals(existingRICHIESTA_RIMBORSO, newRICHIESTA_RIMBORSO);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RICHIESTA_RIMBORSO missingRICHIESTA_RIMBORSO =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRICHIESTA_RIMBORSO);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO1 = addRICHIESTA_RIMBORSO();
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO2 = addRICHIESTA_RIMBORSO();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRICHIESTA_RIMBORSO1.getPrimaryKey());
		primaryKeys.add(newRICHIESTA_RIMBORSO2.getPrimaryKey());

		Map<Serializable, RICHIESTA_RIMBORSO> richiesta_rimborsos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, richiesta_rimborsos.size());
		Assert.assertEquals(
			newRICHIESTA_RIMBORSO1,
			richiesta_rimborsos.get(newRICHIESTA_RIMBORSO1.getPrimaryKey()));
		Assert.assertEquals(
			newRICHIESTA_RIMBORSO2,
			richiesta_rimborsos.get(newRICHIESTA_RIMBORSO2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RICHIESTA_RIMBORSO> richiesta_rimborsos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(richiesta_rimborsos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRICHIESTA_RIMBORSO.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RICHIESTA_RIMBORSO> richiesta_rimborsos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, richiesta_rimborsos.size());
		Assert.assertEquals(
			newRICHIESTA_RIMBORSO,
			richiesta_rimborsos.get(newRICHIESTA_RIMBORSO.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RICHIESTA_RIMBORSO> richiesta_rimborsos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(richiesta_rimborsos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRICHIESTA_RIMBORSO.getPrimaryKey());

		Map<Serializable, RICHIESTA_RIMBORSO> richiesta_rimborsos =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, richiesta_rimborsos.size());
		Assert.assertEquals(
			newRICHIESTA_RIMBORSO,
			richiesta_rimborsos.get(newRICHIESTA_RIMBORSO.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RICHIESTA_RIMBORSOLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<RICHIESTA_RIMBORSO>() {

				@Override
				public void performAction(
					RICHIESTA_RIMBORSO richiesta_rimborso) {

					Assert.assertNotNull(richiesta_rimborso);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RICHIESTA_RIMBORSO.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", newRICHIESTA_RIMBORSO.getId()));

		List<RICHIESTA_RIMBORSO> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RICHIESTA_RIMBORSO existingRICHIESTA_RIMBORSO = result.get(0);

		Assert.assertEquals(existingRICHIESTA_RIMBORSO, newRICHIESTA_RIMBORSO);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RICHIESTA_RIMBORSO.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<RICHIESTA_RIMBORSO> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RICHIESTA_RIMBORSO newRICHIESTA_RIMBORSO = addRICHIESTA_RIMBORSO();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RICHIESTA_RIMBORSO.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newRICHIESTA_RIMBORSO.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("Id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RICHIESTA_RIMBORSO.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RICHIESTA_RIMBORSO addRICHIESTA_RIMBORSO() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RICHIESTA_RIMBORSO richiesta_rimborso = _persistence.create(pk);

		richiesta_rimborso.setNome_Richiedente(RandomTestUtil.randomString());

		richiesta_rimborso.setCognome_Richiedente(
			RandomTestUtil.randomString());

		richiesta_rimborso.setCodice_Fiscale_Richiedente(
			RandomTestUtil.randomString());

		richiesta_rimborso.setUtente_Inserimento(RandomTestUtil.randomString());

		richiesta_rimborso.setData_Inserimento(RandomTestUtil.randomString());

		richiesta_rimborso.setIban(RandomTestUtil.randomString());

		richiesta_rimborso.setImporto(RandomTestUtil.randomString());

		richiesta_rimborso.setFiglio_Nome(RandomTestUtil.randomString());

		richiesta_rimborso.setFiglio_Cognome(RandomTestUtil.randomString());

		richiesta_rimborso.setFiglio_Data_Nascita(
			RandomTestUtil.randomString());

		richiesta_rimborso.setFiglio_Luogo_Nascita(
			RandomTestUtil.randomString());

		richiesta_rimborso.setFiglio_Codice_Fiscale(
			RandomTestUtil.randomString());

		richiesta_rimborso.setNote(RandomTestUtil.randomString());

		richiesta_rimborso.setFlag_Inviato();

		richiesta_rimborso.setTelefono(RandomTestUtil.randomString());

		richiesta_rimborso.setAllegato_UUID(RandomTestUtil.randomString());

		_richiesta_rimborsos.add(_persistence.update(richiesta_rimborso));

		return richiesta_rimborso;
	}

	private List<RICHIESTA_RIMBORSO> _richiesta_rimborsos =
		new ArrayList<RICHIESTA_RIMBORSO>();
	private RICHIESTA_RIMBORSOPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}