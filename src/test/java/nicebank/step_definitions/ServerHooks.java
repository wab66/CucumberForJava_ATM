package nicebank.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nicebank.implementations.server.AtmServer;
import nicebank.implementations.support.KnowsTheDomain;


public class ServerHooks {

    //public static final int PORT = 8887;
    public static final int PORT = 9988;
    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception {
        System.out.println("*********** [ServerHooks] > [@Before] > [startServer] >: About to start the scenario.");
        server = new AtmServer( PORT, helper.getCashSlot(), helper.getMyAccount());
        server.start();
    }

    @After
    public void afterRunningScenario(Scenario scenario) throws Exception {
        System.out.println("*********** [ServerHooks] > [@After] > [afterRunningScenario] >: Just finished running scenario: "
                + scenario.getStatus());
        server.stop();
    }
}