package transforms;

import nicebank.Money;

//public class MoneyConverter extends Transformer<Money> {
public class MoneyConverter {
    public Money transform(String amount){
        return new Money(amount);
    }
}
