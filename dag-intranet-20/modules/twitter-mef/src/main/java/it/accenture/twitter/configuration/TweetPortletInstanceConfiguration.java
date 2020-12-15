package it.accenture.twitter.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(
        category = "web-experience",
        scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
@Meta.OCD(
        factory = true,
        id = "it.accenture.twitter.configuration.TweetPortletInstanceConfiguration",
        localization = "content/Language"
)
public interface TweetPortletInstanceConfiguration {

  
    @Meta.AD(required = false)
    public String title();

    @Meta.AD(deflt = "6", required = false)
    public int numTweetForSlide();

    
}
