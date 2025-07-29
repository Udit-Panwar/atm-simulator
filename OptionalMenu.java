import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionalMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    int selection;
    DecimalFormat moneyFormat = new DecimalFormat(" '$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<>();

    public OptionalMenu() {
        data.put(984932, 3546);
        data.put(943534, 7458);
        data.put(436831, 2796);
        data.put(894945, 9452);
    }

    public void getLogin() throws IOException {
        boolean loggedIn = false;

        System.out.println("Welcome to the ATM Project!");

        while (!loggedIn) {
            try {
                System.out.print("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());

                int customer = getCustomerNumber();
                int pin = getPinNumber();

                if (data.containsKey(customer) && data.get(customer) == pin) {
                    loggedIn = true;
                    getAccountType();
                } else {
                    System.out.println("Invalid customer number or pin.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter only numbers.");
                menuInput.nextLine(); // Clear invalid input
            }
        }
    }

    public void getAccountType() {
        System.out.println("Select the account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice: ");

        try {
            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    getChecking();
                    break;
                case 2:
                    getSaving();
                    break;
                case 3:
                    System.out.println("Thank you for using this ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    getAccountType();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only numbers.");
            menuInput.nextLine(); // clear buffer
            getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        try {
            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                    getAccountType();
                    break;
                case 2:
                    getCheckingWithdrawInput();
                    getAccountType();
                    break;
                case 3:
                    getCheckingDepositInput();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("Thank you for using this ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    getChecking();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only numbers.");
            menuInput.nextLine();
            getChecking();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        try {
            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                    getAccountType();
                    break;
                case 2:
                    getSavingWithdrawInput();
                    getAccountType();
                    break;
                case 3:
                    getSavingDepositInput();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("Thank you for using this ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    getSaving();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter only numbers.");
            menuInput.nextLine();
            getSaving();
        }
    }
}
