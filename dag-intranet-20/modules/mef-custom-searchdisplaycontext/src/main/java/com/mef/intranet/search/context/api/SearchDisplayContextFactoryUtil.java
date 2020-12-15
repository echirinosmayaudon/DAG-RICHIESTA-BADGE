package com.mef.intranet.search.context.api;

import com.liferay.osgi.util.ServiceTrackerFactory;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.util.tracker.ServiceTracker;

public class SearchDisplayContextFactoryUtil {

	public static SearchDisplayContext create(
			RenderRequest renderRequest, RenderResponse renderResponse,
			PortletPreferences portletPreferences)
		throws PortletException {

		try {
			SearchDisplayContextFactory searchDisplayContextFactory =
				_serviceTracker.getService();

			return searchDisplayContextFactory.create(
				renderRequest, renderResponse, portletPreferences);
		}
		catch(Exception e) {
			throw new PortletException(e);
		}
	}

	private static final ServiceTracker
		<SearchDisplayContextFactory, SearchDisplayContextFactory>
			_serviceTracker = ServiceTrackerFactory.open(
				SearchDisplayContextFactory.class);

}
