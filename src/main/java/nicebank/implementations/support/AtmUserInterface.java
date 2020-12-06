package nicebank.implementations.support;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import nicebank.Account;
import nicebank.implementations.ITeller;

public class AtmUserInterface implements ITeller {

    private final EventFiringWebDriver webDriver;

    public AtmUserInterface() {
        this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
    }

    @Override
    public void withdrawFrom(Account account, float dollars) {
        try {
            webDriver.get("http://localhost:9988");
            webDriver.findElement(By.id("Amount"))
                    .sendKeys(String.valueOf(dollars));
            webDriver.findElement(By.id("Withdraw")).click();
        }
        finally {
            webDriver.close();
        }
    }
}
