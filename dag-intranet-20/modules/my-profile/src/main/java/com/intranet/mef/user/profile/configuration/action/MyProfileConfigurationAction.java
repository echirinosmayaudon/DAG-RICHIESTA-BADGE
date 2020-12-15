/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.intranet.mef.user.profile.configuration.action;


import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sangiovanni Roberto
 */
@Component(
	immediate = true,
	property = {"javax.portlet.name=com_intranet_mef_user_profile_portlet_ProfilePortlet"},
	service = ConfigurationAction.class
)
public class MyProfileConfigurationAction extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/configuration.jsp";
	}

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		PortletPreferences portletPreferences = actionRequest.getPreferences();

		boolean isShort = ParamUtil.getBoolean(
			actionRequest, "isShort");
		String  profileDetailLayoutId = ParamUtil.getString(
			actionRequest, "profileDetailLayoutId");
		String  labelRestoreDefault = ParamUtil.getString(
				actionRequest, "labelRestoreDefault");
		String  labelUploadImage = ParamUtil.getString(
				actionRequest, "labelUploadImage");
		String  labelSetSIAPImage = ParamUtil.getString(
				actionRequest, "labelSetSIAPImage");
		String  labelNoSIAPImage = ParamUtil.getString(
				actionRequest, "labelNoSIAPImage");
		
		String  labelPrivacyAcceptance = ParamUtil.getString(
				actionRequest, "labelPrivacyAcceptance");
		
		portletPreferences.setValue(
			"isShort", String.valueOf(isShort));
		
		portletPreferences.setValue("profileDetailLayoutId", profileDetailLayoutId);
		portletPreferences.setValue("labelRestoreDefault", labelRestoreDefault);
		portletPreferences.setValue("labelUploadImage", labelUploadImage);
		portletPreferences.setValue("labelSetSIAPImage", labelSetSIAPImage);
		portletPreferences.setValue("labelNoSIAPImage", labelNoSIAPImage);
		portletPreferences.setValue("labelPrivacyAcceptance", labelPrivacyAcceptance);
		portletPreferences.store();

		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Override
    public void include(
        PortletConfig portletConfig, HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();

		List<String[]> privateLayoutList = getLayoutList(groupId, true, themeDisplay.getLocale());
		httpServletRequest.setAttribute("privateLayoutList", privateLayoutList);
        

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }
	
	public List<String[]> getLayoutList(long groupId, boolean isPrivate, Locale locale) throws SystemException {
		List<String[]> layoutList = new ArrayList<String[]>();
		for (Layout l : LayoutLocalServiceUtil.getLayouts(groupId, isPrivate)) {
			if (l.isRootLayout()) {
				String[] lData = new String[] { l.getName(locale), "" + l.getLayoutId()};
				layoutList.add(lData);
				layoutList.addAll(_getChildrenLayoutData(locale, l, 1));
			}
		}
		return layoutList;
	}
	
	private List<String[]> _getChildrenLayoutData(Locale locale, Layout layout, int depth) throws SystemException {
		List<String[]> layoutList = new ArrayList<String[]>();
		StringBuilder depthStr = new StringBuilder();
		int d = depth;
		for (int i = 0; i < d; i++)
			depthStr.append("- ");
		for (Layout l : layout.getChildren()) {
			String[] lData = new String[] { depthStr + " " + l.getName(locale), "" + l.getLayoutId() };
			layoutList.add(lData);
			layoutList.addAll(_getChildrenLayoutData(locale, l, d++));
		}
		return layoutList;
	}
	@Override
	@Reference(
		target = "(osgi.web.symbolicname=my.profile)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}
	
	
}