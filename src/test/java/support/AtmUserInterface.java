package support;

import nicebank.Account;
import nicebank.ITeller;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import step_definitions.HooksServer;

public class AtmUserInterface implements ITeller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface(EventFiringWebDriver webDriver) {
        this.webDriver = webDriver;
        System.out.println("[AtmUserInterface] > constructor(webDriver) -> when webDriver exists");
    }

    //rc99d - @Override
    public void withdrawFrom(Account account, int amount) {
        System.out.println("[AtmUserInterface] > (@OVERRIDE)withdrawFrom() - second version of this method > other is in AutomatedTeller");
        webDriver.get("http://localhost:" + HooksServer.PORT);
        webDriver.findElement(By.id("amount"))
                .sendKeys(String.valueOf(amount));
        webDriver.findElement(By.id("withdraw")).click();

     //rc099m -
//        try {
//            webDriver.get("http://localhost:9988");
//            webDriver.findElement(By.id("amount"))
//                    .sendKeys(String.valueOf(amount));
//            webDriver.findElement(By.id("withdraw")).click();
//            System.out.println("********************************* [AtmUserInterface] > {@OVERRIDE - ITeller}withDrawFrom() > WebDriver, withdraw cash amount");
//        }
//        finally {
//            webDriver.close();
//        }
    }
}
