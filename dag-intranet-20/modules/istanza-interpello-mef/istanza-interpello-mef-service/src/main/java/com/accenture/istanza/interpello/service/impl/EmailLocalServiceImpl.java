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

package com.accenture.istanza.interpello.service.impl;

import com.accenture.istanza.interpello.model.Email;
import com.accenture.istanza.interpello.service.base.EmailLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The implementation of the email local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.accenture.istanza.interpello.service.EmailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailLocalServiceBaseImpl
 * @see com.accenture.istanza.interpello.service.EmailLocalServiceUtil
 */
public class EmailLocalServiceImpl extends EmailLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.accenture.istanza.interpello.service.EmailLocalServiceUtil} to access the email local service.
	 */
	
	@Override
	public List<String> getCcEmailListByIdStruttura(long idStruttura){
		
		List<String> other_cc_mail_list = new ArrayList<>(0);
		
		List<Email> email_list = this.emailPersistence.findByIdStruttura(idStruttura);
		
		if(email_list!=null && !email_list.isEmpty()) {
			Email email = this.emailPersistence.findByIdStruttura(idStruttura).get(0);
			String mailCc = email.getMailCC();
			if(mailCc!=null && !"".equals(mailCc))
				other_cc_mail_list = Arrays.asList(mailCc.split(","));
		}
		
		return other_cc_mail_list;
		
	}
	
}