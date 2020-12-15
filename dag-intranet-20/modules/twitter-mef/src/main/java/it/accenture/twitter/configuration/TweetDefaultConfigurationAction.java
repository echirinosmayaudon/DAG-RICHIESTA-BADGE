package it.accenture.twitter.configuration;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import it.accenture.twitter.portlet.TweetPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;


@Component(
        configurationPid = "it.accenture.forecast.configuration.TweetPortletInstanceConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + TweetPortletKeys.Tweet  
        },
        service = ConfigurationAction.class
)
public class TweetDefaultConfigurationAction extends DefaultConfigurationAction {}