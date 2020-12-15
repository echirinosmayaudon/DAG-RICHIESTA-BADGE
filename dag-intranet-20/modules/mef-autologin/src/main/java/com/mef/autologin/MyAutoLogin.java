package com.mef.autologin;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, service = AutoLogin.class)
public class MyAutoLogin extends BaseAutoLogin {

	@Override
	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String[] credentials = null;

		long companyId = PortalUtil.getCompanyId(request);

		User autoLoginUser = null;

		String screenName = GetterUtil.getString(request.getHeader("SSO_CF"));

		try {
			if (Validator.isNotNull(screenName)) {
				autoLoginUser = _userLocalService.getUserByScreenName(
					companyId, screenName);
			}
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

		if (autoLoginUser != null) {
			long socialId = GetterUtil.getLong(
				PropsUtil.get("id.company.social.collaboration"));

			if (companyId != socialId){
				String cauName = GetterUtil.getString(
					request.getHeader("CAU_NAME"));
				String objClassName = GetterUtil.getString(
					request.getHeader("OBJ_CLASS_NAME"));

				autoLoginUser.getExpandoBridge().setAttribute(
					"cau-name", cauName, false);
				autoLoginUser.getExpandoBridge().setAttribute(
					"obj-class-name", objClassName, false);
			}

			credentials = new String[3];

			credentials[0] = Long.toString(autoLoginUser.getUserId());
			credentials[1] = autoLoginUser.getPassword();
			credentials[2] = Boolean.toString(true);

			request.setAttribute(
				AutoLogin.AUTO_LOGIN_REDIRECT_AND_CONTINUE,
				PortalUtil.getPathMain());
		}
		else {
			String redirectPageName = GetterUtil.getString(
				PropsUtil.get("default.sso.redirect.page.name"));

			if (Validator.isNotNull(redirectPageName)){
				request.setAttribute(
					AutoLogin.AUTO_LOGIN_REDIRECT, "/" + redirectPageName);
			}
		}

		return credentials;
	}

	private static final Log _log = LogFactoryUtil.getLog(MyAutoLogin.class);

	@Reference
	private UserLocalService _userLocalService;

}

