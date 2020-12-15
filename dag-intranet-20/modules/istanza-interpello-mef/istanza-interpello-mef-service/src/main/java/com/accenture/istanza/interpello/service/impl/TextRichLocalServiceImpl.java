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

import com.accenture.istanza.interpello.model.TextRich;
import com.accenture.istanza.interpello.service.base.TextRichLocalServiceBaseImpl;

/**
 * The implementation of the text rich local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.accenture.istanza.interpello.service.TextRichLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TextRichLocalServiceBaseImpl
 * @see com.accenture.istanza.interpello.service.TextRichLocalServiceUtil
 */
public class TextRichLocalServiceImpl extends TextRichLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.accenture.istanza.interpello.service.TextRichLocalServiceUtil} to access the text rich local service.
	 */
	
	@Override
	public TextRich getTextByLabel(String label_text){
		TextRich opzioneRich= null;
		if(this.textRichPersistence.findBylabel_text(label_text)!=null && !this.textRichPersistence.findBylabel_text(label_text).isEmpty())
		 opzioneRich = this.textRichPersistence.findBylabel_text(label_text).get(0);	
		return opzioneRich;
		
	}
	
}