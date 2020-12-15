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

package com.intranet.mef.assistance.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.intranet.mef.assistance.model.Faq;
import com.intranet.mef.assistance.service.base.FaqLocalServiceBaseImpl;
import com.intranet.mef.assistance.service.persistence.FaqPK;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the faq local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.assistance.service.FaqLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FaqLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.FaqLocalServiceUtil
 */
@ProviderType
public class FaqLocalServiceImpl extends FaqLocalServiceBaseImpl {
	
	public static final Log _log = LogFactoryUtil.getLog(FaqLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.assistance.service.FaqLocalServiceUtil} to access the faq local service.
	 */
	public void add(String faqId, String siebelId, String questions,
		String response){

		FaqPK faqpk = new FaqPK(faqId, siebelId);
		Faq faq=faqPersistence.create(faqpk);
		faq.setQuestions(questions);
		faq.setResponse(response);
		_log.info("response"+ response);
//		try {
//			faq.setResponse(new String(response.getBytes("ISO-8859-1"), "UTF-8"));
//			_log.info("response after encoding"+ faq.getResponse());
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			_log.error("Unable to convert response in UTF-8 charset",e);
//		}
		

		faqPersistence.update(faq);		

	}

	public List<Faq> findByProblemId(String key){

		return faqPersistence.findByFaqId(key);
 
	}

	public void removeAll(){
		faqPersistence.removeAll();
	}

}