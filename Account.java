import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;
    private final DateProvider dateProvider;

    public Account(DateProvider dateProvider) {
        if (dateProvider == null) {
            throw new IllegalArgumentException("DateProvider cannot be null");
        }
        this.dateProvider = dateProvider;
    }

    @Override
    public void deposit(int amount) {
        validateAmount(amount);
        String date = dateProvider.todayAsString();
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        validateAmount(amount);
        String date = dateProvider.todayAsString();
        if (amount > balance) {
            throw new IllegalStateException(
                String.format("Insufficient funds. Cannot withdraw %d. Current balance: %d", amount, balance)
            );
        }
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE | AMOUNT | BALANCE");
        
        if (transactions.isEmpty()) {
            return;
        }
        
        for (int i = transactions.size() - 1; i >= 0; i--) {
            System.out.println(transactions.get(i));
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                String.format("Amount must be > 0. Provided: %d", amount)
            );
        }
    }
}
