package nicebank;

import java.util.Currency;
import java.util.Locale;

public final class Money {

    private final float amount;
    private Locale locale;
    private final Currency currency;

    public Money() {
        this.currency = Currency.getInstance(Locale.UK);
        this.amount = 0;
    }

    public Money(float amount) {
        this.currency = Currency.getInstance(Locale.UK);
        this.amount = amount;
    }

    public Money(Locale locale, float amount) {
        this.locale = locale;
        this.currency = Currency.getInstance(locale);
        this.amount = amount;
    }

    public Money(String amountStr) {
        this.currency = Currency.getInstance(Locale.UK);
        //this.amount = Double.parseDouble(amountStr);
        this.amount = Float.parseFloat(amountStr);
    }

    public float getAmount() {
        return amount;
    }

    public Locale getLocale() {
        return locale;
    }

    public Currency getCurrency() {
        return currency;
    }
}
