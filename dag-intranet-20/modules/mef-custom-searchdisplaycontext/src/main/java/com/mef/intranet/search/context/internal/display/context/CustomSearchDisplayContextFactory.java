package com.mef.intranet.search.context.internal.display.context;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.facet.faceted.searcher.FacetedSearcherManager;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.mef.intranet.search.context.api.SearchDisplayContext;
import com.mef.intranet.search.context.api.SearchDisplayContextFactory;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	service = SearchDisplayContextFactory.class
)
public class CustomSearchDisplayContextFactory
	implements SearchDisplayContextFactory {

	private final Log _log = LogFactoryUtil.getLog(
		CustomSearchDisplayContextFactory.class);

	@Override
	public SearchDisplayContext create(
			RenderRequest renderRequest, RenderResponse renderResponse,
			PortletPreferences portletPreferences)
		throws PortletException {

		return new CustomSearchDisplayContext(
				renderRequest,renderResponse, portletPreferences,
				PortalUtil.getPortal(), HtmlUtil.getHtml(),
				LanguageUtil.getLanguage(), _facetedSearcherManager,
				new IndexSearchPropsValuesImpl(), new PortletURLFactoryImpl());
	}

/*
	@Reference(
		target = "(bundle.symbolic.name=com.liferay.portal.search.web)",
		unbind = "-"
	)
	public void setResourceBundleLoader(
		ResourceBundleLoader resourceBundleLoader) {

		_resourceBundleLoader = resourceBundleLoader;
	}
*/

	@Reference
	private FacetedSearcherManager _facetedSearcherManager;

	private ResourceBundleLoader _resourceBundleLoader;

}
