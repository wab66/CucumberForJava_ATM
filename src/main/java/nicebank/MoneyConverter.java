package nicebank;

//import cucumber.api.Transformer;
//import javax.xml.transform.Transformer;
import io.cucumber.cucumberexpressions.Transformer;

public class MoneyConverter implements Transformer<Money> {
    public Money transform(String amount){
        return new Money(amount);
    }
}
