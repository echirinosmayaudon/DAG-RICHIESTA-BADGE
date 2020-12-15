package com.intranet.mef.scadenze.badge.messaging;

import com.intranet.mef.scadenze.badge.costants.ScadenzeBadgeDestinationNames;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationConfiguration;
import com.liferay.portal.kernel.messaging.DestinationFactory;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(
		immediate = true, 
		service = ScadenzeBadgeCheckerMessageListenerConfigurator.class
)
public class ScadenzeBadgeCheckerMessageListenerConfigurator {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_serviceRegistration = registerDestination(
				ScadenzeBadgeDestinationNames.SCADENZE_BADGE);
	}

	@Deactivate
	protected void deactivate() {
		if (_serviceRegistration != null) {
			Destination destination = _bundleContext.getService(
				_serviceRegistration.getReference());

			_serviceRegistration.unregister();

			destination.destroy();
		}

		_bundleContext = null;
	}

	protected ServiceRegistration<Destination> registerDestination(
		String destinationName) {

		DestinationConfiguration destinationConfiguration =
			new DestinationConfiguration(
				DestinationConfiguration.DESTINATION_TYPE_SERIAL,
				destinationName);

		Destination destination = _destinationFactory.createDestination(
			destinationConfiguration);

		Dictionary<String, Object> destinationProperties =
			new HashMapDictionary<>();

		destinationProperties.put("destination.name", destination.getName());

		return _bundleContext.registerService(
			Destination.class, destination, destinationProperties);
	}

	private volatile BundleContext _bundleContext;

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private DestinationFactory _destinationFactory;

	private ServiceRegistration<Destination> _serviceRegistration;

	
}
