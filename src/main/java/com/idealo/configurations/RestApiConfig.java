package com.idealo.configurations;

import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.idealo.rest.CheckoutResource;
import com.idealo.rest.PingResource;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class RestApiConfig extends ResourceConfig {

    public RestApiConfig() {
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, "true");
        register(PingResource.class);
        register(CheckoutResource.class);
        register(new LoggingFeature(Logger.getLogger("com.idealo.rest"), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 1000));
        register(JacksonJaxbJsonProvider.class);
        register(JsonParseExceptionMapper.class);
    }

}
