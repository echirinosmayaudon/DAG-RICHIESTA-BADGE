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

package form.service.contributo.solidarieta.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import form.service.contributo.solidarieta.model.Donatore;
import form.service.contributo.solidarieta.service.base.DonatoreLocalServiceBaseImpl;
import form.service.contributo.solidarieta.service.persistence.DonatorePersistence;


/**
 * The implementation of the donatore local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>form.service.contributo.solidarieta.service.DonatoreLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonatoreLocalServiceBaseImpl
 */
public class DonatoreLocalServiceImpl extends DonatoreLocalServiceBaseImpl {
	Log _log=LogFactoryUtil.getLog(this.getClass());
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>form.service.contributo.solidarieta.service.DonatoreLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>form.service.contributo.solidarieta.service.DonatoreLocalServiceUtil</code>.
	 */
	public Donatore creaDonatore(String nome, String cognome, String email, String cod_fiscale, String importo,String data_inserimento) {
		Donatore donatore = donatorePersistence.create(-1);
		
		donatore.setNome(nome);
		donatore.setCognome(cognome);
		donatore.setEmail(email);
		donatore.setCod_fiscale(cod_fiscale.toUpperCase());
		donatore.setImporto(importo);
		donatore.setData_inserimento(data_inserimento);
		Donatore insertout=null;
		 try{
			 insertout = donatorePersistence.updateImpl(donatore);
			 return insertout;
		 }
		 catch(Exception e){
			 _log.error(e);
			 return insertout;
		 
		 }
	}
}