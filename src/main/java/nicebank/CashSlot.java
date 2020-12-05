package nicebank;

public class CashSlot {
    private float contents;

    public float getContents(){
        return contents;
    }

    public void dispense(float amount){
        contents = amount;
    }
}
