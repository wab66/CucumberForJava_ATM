package nicebank;

public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        do {
            String message = queue.read();

            // Deliberately slow it down - so feature will work
            try {
                Thread.sleep(4000);
                System.out.println("+++++++++++++++++++++++++++++[TransactionProcessor] > [process]: Thread.sleep: 1000ms");
            } catch (InterruptedException e) {

            }

            if (message.length() > 0) {
                System.out.println("+++++++++++++++++++++++++++++[TransactionProcessor] > [process]: Message found: " + message);
                Money balance = BalanceStore.getBalance();
                System.out.println("+++++++++++++++++++++++++++++[TransactionProcessor] > [process]: BalanceStore.getBalance: " + balance);
                Money transactionAmount = new Money(message);
                System.out.println("+++++++++++++++++++++++++++++[TransactionProcessor] > [process]: Transaction amount: " + transactionAmount);

                if (isCreditTransaction(message)){
                    BalanceStore.setBalance(balance.add(transactionAmount));
                    System.out.println("+++++++++++++++++++++++++++++[TransactionProcessor] > [process]: Add amount: " + transactionAmount + " to Balance amount: " + balance);
                } else {
                    BalanceStore.setBalance(balance.minus(transactionAmount));
                    System.out.println("+++++++++++++++++++++++++++++[TransactionProcessor] > [process]: Deduct amount: " + transactionAmount + " from Balance amount: " + balance);
                }
            }
        } while (true);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }
}
