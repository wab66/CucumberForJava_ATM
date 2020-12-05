package nicebank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformerMoney {
    private int pounds;
    private int pence;
    private String moneyStr;

    public TransformerMoney() {
        this.pounds = 0;
        this.pence = 0;
    }

    public TransformerMoney(int pounds, int pence) {
        this.pounds = pounds;
        this.pence = pence;
    }

    public TransformerMoney(String amount) {
        Pattern pattern = Pattern.compile("^[\\d]*([\\d+])\\.([\\d][\\d])$");
        Matcher matcher = pattern.matcher(amount);
        matcher.find();
        this.pounds = Integer.parseInt(matcher.group(1));
        this.pence = Integer.parseInt(matcher.group(2));
        getMoney();
    }

    public int getPounds() {
        return pounds;
    }

    public int getPence() {
        return pence;
    }

    public double getMoney() {
        Money money = new Money(moneyStr);
        return money.getAmount();
    }

/*

    public double getMoneyAmount(){
        return (this.pounds + (pence/100));
    }
*/

}
