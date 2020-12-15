package com.intranet.mef.central.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;

public class UserPhoneUtil {
	private static Map<String, Long> _phoneTypeMap;
	
	static{
		_getPhoneTypeMap();
	}

	public static long getPhoneTypeIdByName(String name){

		if (_phoneTypeMap.containsKey(name)) {
			return _phoneTypeMap.get(name);
		}

		return 0L;
	}

	private static void _getPhoneTypeMap() {
		
		if (_phoneTypeMap == null) {
			_phoneTypeMap = new HashMap<String, Long>();

			List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(
				Contact.class.getName() + ListTypeConstants.PHONE);

			for (ListType phoneType : phoneTypes) {
				_phoneTypeMap.put(
					phoneType.getName(), phoneType.getListTypeId());
			}
		}

	}

	public final static String PERSONAL ="mobile-phone";
	public final static String BUSINESS ="business";
	public final static String BUSINESS_FAX ="business-fax";
}
