package it.smc.mef.assetpublisher.fragment.util;

import java.util.Objects;

import javax.portlet.PortletURL;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

public class CustomAssetPublisherHelper extends com.liferay.asset.publisher.web.util.AssetPublisherHelper {

		  
	
	public static String getAssetViewURL(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, AssetEntry assetEntry,
			boolean viewInContext) {

			AssetRenderer<?> assetRenderer = assetEntry.getAssetRenderer();

			return getAssetViewURL(
				liferayPortletRequest, liferayPortletResponse, assetRenderer,
				assetEntry, viewInContext);
		}
	
	
	public static String getAssetViewURL(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			AssetRenderer<?> assetRenderer, AssetEntry assetEntry,
			boolean viewInContext) {
		
		PortletURL viewFullContentURL =
			liferayPortletResponse.createRenderURL();

		viewFullContentURL.setParameter("mvcPath", "/view_content.jsp");
		viewFullContentURL.setParameter(
			"assetEntryId", String.valueOf(assetEntry.getEntryId()));

		PortletURL redirectURL = liferayPortletResponse.createRenderURL();

		int cur = ParamUtil.getInteger(liferayPortletRequest, "cur");
		int delta = ParamUtil.getInteger(liferayPortletRequest, "delta");
		boolean resetCur = ParamUtil.getBoolean(
			liferayPortletRequest, "resetCur");

		redirectURL.setParameter("cur", String.valueOf(cur));
		if (delta > 0){
			redirectURL.setParameter("delta", String.valueOf(delta));
		}
		redirectURL.setParameter("resetCur", String.valueOf(resetCur));
		redirectURL.setParameter(
			"assetEntryId", String.valueOf(assetEntry.getEntryId()));

		String keywords = ParamUtil.getString(liferayPortletRequest, "keywords");
		long[] categories = ParamUtil.getLongValues(liferayPortletRequest, "categories", null);
		
		if (!Validator.isBlank(keywords)) {
			redirectURL.setParameter("keywords", keywords);
		}
		
		if (Validator.isNotNull(categories)) {
			String[] categoriesArray = ArrayUtil.toStringArray(categories);
			redirectURL.setParameter("categories", categoriesArray);
		}

		String redirectURLString = redirectURL.toString();

		if (_log.isDebugEnabled()) {
			_log.debug(keywords);
			_log.debug(categories);
			_log.debug(redirectURLString);	
		}
		
		viewFullContentURL.setParameter("redirect", redirectURLString);

		AssetRendererFactory<?> assetRendererFactory =
			assetRenderer.getAssetRendererFactory();

		viewFullContentURL.setParameter("type", assetRendererFactory.getType());

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
			if (assetRenderer.getGroupId() != themeDisplay.getScopeGroupId()) {
				viewFullContentURL.setParameter(
					"groupId", String.valueOf(assetRenderer.getGroupId()));
			}

			viewFullContentURL.setParameter(
				"urlTitle", assetRenderer.getUrlTitle());
		}

		String viewURL = null;

		if (viewInContext) {
			try {
				String noSuchEntryRedirect = viewFullContentURL.toString();

				viewURL = assetRenderer.getURLViewInContext(
					liferayPortletRequest, liferayPortletResponse,
					noSuchEntryRedirect);

				if (Validator.isNotNull(viewURL) &&
					!Objects.equals(viewURL, noSuchEntryRedirect)) {

					viewURL = HttpUtil.setParameter(
					
						viewURL, "redirect",
						PortalUtil.getCurrentURL(liferayPortletRequest));
				}
			}
			catch (Exception e) {
				_log.error("Error: " + e); 
			}
		}

		if (Validator.isNull(viewURL)) {
			viewURL = viewFullContentURL.toString();
		}

		return viewURL;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CustomAssetPublisherHelper.class);
	
}
