package BankAcount;

public class BankAccount {
    private int id;
    private double balance;
    private static double  interestRate = 0.2;
    private static int bankAccountCount = 1;

    public BankAccount(){
        this.id = bankAccountCount++;
    }

}
