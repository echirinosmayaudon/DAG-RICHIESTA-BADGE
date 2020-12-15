package bacheca.annunci.list.provider;

import com.liferay.portal.kernel.portlet.BasePortletProvider;

import com.liferay.portal.kernel.portlet.ViewPortletProvider;

import org.osgi.service.component.annotations.Component;

import bacheca.annunci.list.portlet.BachecaAnnunciKeys;

@Component(immediate = true, property = {
	"model.class.name=bacheca.annunci.list.provider.BachecaAnnunciListPortletProvider" }, service = BachecaAnnunciListPortletProvider.class)
public class BachecaAnnunciListPortletProvider extends BasePortletProvider implements ViewPortletProvider {
	
	@Override
	public String getPortletName() {
		return BachecaAnnunciKeys.BACHECAANNUNCI;
	}
}
