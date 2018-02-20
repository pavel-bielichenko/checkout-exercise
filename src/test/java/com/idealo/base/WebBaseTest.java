package com.idealo.base;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.idealo.CheckoutApplication;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"test"})
@ContextConfiguration(classes = {CheckoutApplication.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class WebBaseTest {

    private final static String LOCALHOST = "http://localhost";
    

    @LocalServerPort
    protected int serverPort;
    protected WebTarget webTarget;
    private Client client;

    @Before
    public void setup() {
        ClientConfig clientConfig = new ClientConfig().register(JacksonJaxbJsonProvider.class);

        client = ClientBuilder.newClient(clientConfig);
        client.register(new LoggingFeature(Logger.getLogger("com.idealo"), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 100000));
        webTarget = client.target(UriBuilder.fromUri(LOCALHOST).port(serverPort).build());
    }

    @After
    public void cleanup() {
        Optional.ofNullable(client).ifPresent(Client::close);
    }
}
