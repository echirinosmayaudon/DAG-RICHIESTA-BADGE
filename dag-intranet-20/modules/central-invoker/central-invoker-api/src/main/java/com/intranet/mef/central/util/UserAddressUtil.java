package com.intranet.mef.central.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;

public class UserAddressUtil {

	private static Map<String, Long> _addressTypeMap;
	
	static{
		_getAddressTypeMap();
	}

	public static long getAddressTypeIdByName(String name){

		if (_addressTypeMap.containsKey(name)) {
			return _addressTypeMap.get(name);
		}

		return 0L;
	}

	private static void _getAddressTypeMap() {
		
		if (_addressTypeMap == null) {
			_addressTypeMap = new HashMap<String, Long>();

			List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(
				Contact.class.getName() + ListTypeConstants.ADDRESS);

			for (ListType phoneType : phoneTypes) {
				_addressTypeMap.put(
					phoneType.getName(), phoneType.getListTypeId());
			}
		}

	}
	public final static String BIRTH ="other";
	public final static String BUSINESS ="business";
	public final static String PERSONAL ="personal";

}
