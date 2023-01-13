import java.util.Objects;

public class SBIUser implements BankInterface {

    //attributes

    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public SBIUser(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBIUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance=balance+amount;
        return "Balance dikh rha hai "+balance;
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if (enteredPassword.equals(password)) {
            if (amount > balance) {
                return "Insufficient Money Bro what is this!!!";
            } else {
                balance = balance - amount;
                return "Paisa hi paisa hai";
            }
        } else {
            return "Password galat hai Bhai";
        }
    }
    @Override
    public double calculateInterest(int years) {
        return ((balance*years*rateOfInterest)/100);
    }
    }