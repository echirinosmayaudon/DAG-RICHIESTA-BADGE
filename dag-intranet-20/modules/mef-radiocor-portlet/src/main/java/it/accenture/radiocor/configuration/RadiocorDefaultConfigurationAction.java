package it.accenture.radiocor.configuration;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import mef.radiocor.form.constants.MefRadiocorFormPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;


@Component(
        configurationPid = "it.accenture.radiocor.configuration.RadiocorPortletInstanceConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL,
        immediate = true,
        property = {
                "javax.portlet.name=" + MefRadiocorFormPortletKeys.MefRadiocorForm
        },
        service = ConfigurationAction.class
)
public class RadiocorDefaultConfigurationAction extends DefaultConfigurationAction {}