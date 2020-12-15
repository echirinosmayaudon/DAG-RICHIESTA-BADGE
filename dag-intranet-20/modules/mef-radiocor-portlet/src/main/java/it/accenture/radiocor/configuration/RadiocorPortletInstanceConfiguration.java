package it.accenture.radiocor.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "web-experience",
        scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
        factory = true,
        id = "it.accenture.radiocor.configuration.RadiocorPortletInstanceConfiguration",
        localization = "content/Language"
)
public interface RadiocorPortletInstanceConfiguration {

    @Meta.AD(required = false)
    public String title();

    @Meta.AD(deflt = "6", required = false)
    public int numNewsForPage();

    

}
