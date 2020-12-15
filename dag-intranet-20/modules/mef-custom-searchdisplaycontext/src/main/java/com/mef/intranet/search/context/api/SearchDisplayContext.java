package com.mef.intranet.search.context.api;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.web.facet.SearchFacet;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;

public interface SearchDisplayContext {

	public static final String DEFAULT_CUR_PARAM = "cur";
	public static final int MAX_DELTA = 10;

	public String checkViewURL(String viewURL, String currentURL);

	public int getCollatedSpellCheckResultDisplayThreshold();

	public List<SearchFacet> getEnabledSearchFacets();

	public Hits getHits();

	public String getKeywords();

	public long[] getAreeTematiche();

	public PortletURL getPortletURL() throws PortletException;

	public QueryConfig getQueryConfig();

	public int getQueryIndexingThreshold();

	public int getQuerySuggestionsDisplayThreshold();

	public int getQuerySuggestionsMax();

	public String[] getQueryTerms();

	public String getSearchConfiguration();

	public SearchContainer<Document> getSearchContainer();

	public SearchContext getSearchContext();

	public long getSearchScopeGroupId();

	public String getSearchScopeParameterString();

	public String getSearchScopePreferenceString();

	public boolean isCollatedSpellCheckResultEnabled();

	public boolean isDisplayFacet(String className);

	public boolean isDisplayMainQuery();

	public boolean isDisplayOpenSearchResults();

	public boolean isDisplayResultsInDocumentForm();

	public boolean isDLLinkToViewURL();

	public boolean isHighlightEnabled();

	public boolean isIncludeSystemPortlets();

	public boolean isQueryIndexingEnabled();

	public boolean isQuerySuggestionsEnabled();

	public boolean isSearchScopePreferenceEverythingAvailable();

	public boolean isSearchScopePreferenceLetTheUserChoose();

	public boolean isShowMenu();

	public boolean isViewInContext();

}
