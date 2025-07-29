import java.text.DecimalFormat;
import java.util.Scanner;

class Account {
    Scanner menuInput = new Scanner(System.in);
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    DecimalFormat moneyFormat = new DecimalFormat(" '$'###,##0.00");

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance -= amount;
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance -= amount;
        return savingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance += amount;
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance += amount;
        return checkingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
        System.out.print("Amount to withdraw: ");
        double amount = menuInput.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
        System.out.print("Amount to withdraw: ");
        double amount =menuInput.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    public void getCheckingDepositInput() {
        System.out.print("Amount to deposit into Checking: ");
        double amount = menuInput.nextDouble();
        calcCheckingDeposit(amount);
        System.out.println("New Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
    }

    public void getSavingDepositInput() {
        System.out.print("Amount to deposit into Saving: ");
        double amount = menuInput.nextDouble();
        calcSavingDeposit(amount);
        System.out.println("New Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
    }
}