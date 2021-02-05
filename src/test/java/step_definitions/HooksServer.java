package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import nicebank.AtmServer;
import support.KnowsTheDomain;


public class HooksServer {

    public static final int PORT = 8887;
    //public static final int PORT = 9988;
    private AtmServer server;
    private KnowsTheDomain helper;

    public HooksServer(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Before
    public void startServer() throws Exception {
        System.out.println("*********** [ServerHooks] > [@Before] > [startServer()] >: 1) About to create new ATMServer (server) - (helper.getMyAccount())");
        server = new AtmServer( PORT, helper.getCashSlot(), helper.getMyAccount());
        System.out.println("*********** [ServerHooks] > [@Before] > [startServer()] >: 2) Created new ATMServer (server): " + server);
        //server = new AtmServer(PORT);
        server.start();
    }

    @After
    public void afterRunningScenario(Scenario scenario) throws Exception {
        System.out.println("*********** [ServerHooks] > [@After] > [afterRunningScenario] >: Just finished running scenario: "
                + scenario.getStatus());
        server.stop();
    }
}