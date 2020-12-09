package nicebank.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nicebank.implementations.server.AtmServer;


public class ServerHooks {

    public static final int PORT = 8887;
    private AtmServer server;

    @Before
    public void startServer() throws Exception {
        System.out.println("*********** [ServerHooks] > [@Before] > [startServer] >: About to start the scenario.");
        server = new AtmServer( PORT);
        server.start();
    }

    @After
    public void afterRunningScenario(Scenario scenario) throws Exception {
        System.out.println("*********** [ServerHooks] > [@After] > [afterRunningScenario] >: Just finished running scenario: "
                + scenario.getStatus());
        server.stop();
    }
}