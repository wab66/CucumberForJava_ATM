package support;

import nicebank.Account;
import nicebank.ITeller;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements ITeller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface() {
        this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
        System.out.println("[AtmUserInterface] > constructor() - this contains a second version of withdrawFrom -> which overrides ITeller (the other one is in AutomatedTeller)");
    }

    @Override
    public void withdrawFrom(Account account, int dollars) {
        System.out.println("[AtmUserInterface] > withdrawFrom() - second version of this method > other is in AutomatedTeller");
        try {
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("amount"))
                    .sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("withdraw")).click();
        }
        finally {
            webDriver.close();
        }
    }
}
