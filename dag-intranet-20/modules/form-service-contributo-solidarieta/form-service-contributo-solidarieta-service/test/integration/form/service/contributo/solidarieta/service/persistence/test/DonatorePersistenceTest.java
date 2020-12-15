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

package form.service.contributo.solidarieta.service.persistence.test;

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

import form.service.contributo.solidarieta.exception.NoSuchDonatoreException;
import form.service.contributo.solidarieta.model.Donatore;
import form.service.contributo.solidarieta.service.DonatoreLocalServiceUtil;
import form.service.contributo.solidarieta.service.persistence.DonatorePersistence;
import form.service.contributo.solidarieta.service.persistence.DonatoreUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class DonatorePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"form.service.contributo.solidarieta.service"));

	@Before
	public void setUp() {
		_persistence = DonatoreUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Donatore> iterator = _donatores.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Donatore donatore = _persistence.create(pk);

		Assert.assertNotNull(donatore);

		Assert.assertEquals(donatore.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Donatore newDonatore = addDonatore();

		_persistence.remove(newDonatore);

		Donatore existingDonatore = _persistence.fetchByPrimaryKey(
			newDonatore.getPrimaryKey());

		Assert.assertNull(existingDonatore);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDonatore();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Donatore newDonatore = _persistence.create(pk);

		newDonatore.setNome(RandomTestUtil.randomString());

		newDonatore.setCognome(RandomTestUtil.randomString());

		newDonatore.setCod_fiscale(RandomTestUtil.randomString());

		newDonatore.setEmail(RandomTestUtil.randomString());

		newDonatore.setImporto(RandomTestUtil.randomString());

		newDonatore.setData_inserimento(RandomTestUtil.randomString());

		_donatores.add(_persistence.update(newDonatore));

		Donatore existingDonatore = _persistence.findByPrimaryKey(
			newDonatore.getPrimaryKey());

		Assert.assertEquals(existingDonatore.getId(), newDonatore.getId());
		Assert.assertEquals(existingDonatore.getNome(), newDonatore.getNome());
		Assert.assertEquals(
			existingDonatore.getCognome(), newDonatore.getCognome());
		Assert.assertEquals(
			existingDonatore.getCod_fiscale(), newDonatore.getCod_fiscale());
		Assert.assertEquals(
			existingDonatore.getEmail(), newDonatore.getEmail());
		Assert.assertEquals(
			existingDonatore.getImporto(), newDonatore.getImporto());
		Assert.assertEquals(
			existingDonatore.getData_inserimento(),
			newDonatore.getData_inserimento());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Donatore newDonatore = addDonatore();

		Donatore existingDonatore = _persistence.findByPrimaryKey(
			newDonatore.getPrimaryKey());

		Assert.assertEquals(existingDonatore, newDonatore);
	}

	@Test(expected = NoSuchDonatoreException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Donatore> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"CNTB_SOLID_DONATORE_Donatore", "id", true, "nome", true, "cognome",
			true, "cod_fiscale", true, "email", true, "importo", true,
			"data_inserimento", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Donatore newDonatore = addDonatore();

		Donatore existingDonatore = _persistence.fetchByPrimaryKey(
			newDonatore.getPrimaryKey());

		Assert.assertEquals(existingDonatore, newDonatore);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Donatore missingDonatore = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDonatore);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Donatore newDonatore1 = addDonatore();
		Donatore newDonatore2 = addDonatore();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDonatore1.getPrimaryKey());
		primaryKeys.add(newDonatore2.getPrimaryKey());

		Map<Serializable, Donatore> donatores = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, donatores.size());
		Assert.assertEquals(
			newDonatore1, donatores.get(newDonatore1.getPrimaryKey()));
		Assert.assertEquals(
			newDonatore2, donatores.get(newDonatore2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Donatore> donatores = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(donatores.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Donatore newDonatore = addDonatore();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDonatore.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Donatore> donatores = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, donatores.size());
		Assert.assertEquals(
			newDonatore, donatores.get(newDonatore.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Donatore> donatores = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(donatores.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Donatore newDonatore = addDonatore();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDonatore.getPrimaryKey());

		Map<Serializable, Donatore> donatores = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, donatores.size());
		Assert.assertEquals(
			newDonatore, donatores.get(newDonatore.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DonatoreLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Donatore>() {

				@Override
				public void performAction(Donatore donatore) {
					Assert.assertNotNull(donatore);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Donatore newDonatore = addDonatore();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Donatore.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newDonatore.getId()));

		List<Donatore> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Donatore existingDonatore = result.get(0);

		Assert.assertEquals(existingDonatore, newDonatore);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Donatore.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Donatore> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Donatore newDonatore = addDonatore();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Donatore.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newDonatore.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Donatore.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Donatore addDonatore() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Donatore donatore = _persistence.create(pk);

		donatore.setNome(RandomTestUtil.randomString());

		donatore.setCognome(RandomTestUtil.randomString());

		donatore.setCod_fiscale(RandomTestUtil.randomString());

		donatore.setEmail(RandomTestUtil.randomString());

		donatore.setImporto(RandomTestUtil.randomString());

		donatore.setData_inserimento(RandomTestUtil.randomString());

		_donatores.add(_persistence.update(donatore));

		return donatore;
	}

	private List<Donatore> _donatores = new ArrayList<Donatore>();
	private DonatorePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}