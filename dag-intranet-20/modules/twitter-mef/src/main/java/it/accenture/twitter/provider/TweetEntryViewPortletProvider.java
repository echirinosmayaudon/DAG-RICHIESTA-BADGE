package it.accenture.twitter.provider;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import it.accenture.twitter.portlet.TweetPortletKeys;


@Component(
	    immediate = true,
	    property = {"model.class.name=it.accenture.twitter.provider.TweetEntryViewPortletProvider"},
	    service = TweetEntryViewPortletProvider.class
	)
public class TweetEntryViewPortletProvider extends BasePortletProvider implements ViewPortletProvider {
 
	@Override
	public String getPortletName() {
		return TweetPortletKeys.Tweet;
	}
}
