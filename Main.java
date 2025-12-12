public class Main {
    public static void main(String[] args) {
        FakeDateProvider fakeDateProvider = new FakeDateProvider();
        Account account = new Account(fakeDateProvider);

        fakeDateProvider.setDate("10-01-2012");
        account.deposit(1000);

        fakeDateProvider.setDate("13-01-2012");
        account.deposit(2000);

        fakeDateProvider.setDate("14-01-2012");
        account.withdraw(500);

        account.printStatement();
    }
}

