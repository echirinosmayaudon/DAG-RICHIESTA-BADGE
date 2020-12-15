package it.accenture.radiocor.service.api;


import it.accenture.radiocor.model.JsonRadiocor;

public interface   RadiocorService {

	JsonRadiocor getData(
            final String portletInstance,
            int numeroNews
    );
}

