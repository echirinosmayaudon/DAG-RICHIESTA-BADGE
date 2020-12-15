package it.smc.osportal.sc.portal.search.web.util;

import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.asset.util.AssetUtil;

import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

public class CustomSearchUtil {

	public static String getSearchResultViewURL(
			RenderRequest renderRequest, RenderResponse renderResponse,
			String className, long classPK, boolean viewInContext,
			String currentURL)
		throws Exception {

		try {
			PortletURL viewContentURL = renderResponse.createRenderURL();

			viewContentURL.setParameter("mvcPath", "/view_content.jsp");
			viewContentURL.setParameter("redirect", currentURL);
			viewContentURL.setPortletMode(PortletMode.VIEW);
			viewContentURL.setWindowState(WindowState.MAXIMIZED);

			if (Validator.isNull(className) || (classPK <= 0)) {
				return viewContentURL.toString();
			}

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
				className, classPK);

			AssetRendererFactory<?> assetRendererFactory =
				AssetRendererFactoryRegistryUtil.
					getAssetRendererFactoryByClassName(className);

			if (assetRendererFactory == null) {
				return viewContentURL.toString();
			}

			viewContentURL.setParameter(
				"assetEntryId", String.valueOf(assetEntry.getEntryId()));
			viewContentURL.setParameter("type", assetRendererFactory.getType());

			if (viewInContext) {
				String viewFullContentURLString = viewContentURL.toString();

				viewFullContentURLString = HttpUtil.setParameter(
					viewFullContentURLString, "redirect", currentURL);

				// Remove namespaced redirect to reduce URL

				String name = renderResponse.getNamespace() + "redirect";

				viewFullContentURLString = HttpUtil.removeParameter(
					viewFullContentURLString, name);

				AssetRenderer<?> assetRenderer =
					assetRendererFactory.getAssetRenderer(classPK);

				String viewURL = assetRenderer.getURLViewInContext(
					(LiferayPortletRequest)renderRequest,
					(LiferayPortletResponse)renderResponse,
					viewFullContentURLString);

				ThemeDisplay themeDisplay =
					(ThemeDisplay)renderRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

				return AssetUtil.checkViewURL(
					assetEntry, viewInContext, viewURL, currentURL,
					themeDisplay);
			}

			return viewContentURL.toString();
		}
		catch (Exception e) {
			_log.error(
				"Unable to get search result  view URL for class " + className +
					" with primary key " + classPK,
				e);

			return "";
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CustomSearchUtil.class);

}
