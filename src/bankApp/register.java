package bankApp;

import java.util.Scanner;

public class register {
    //public float getBalance() {
     //   return cbal;
  //  }
    db data = new db();

    public static void main(String[] args) {
        register app = new register();
        app.userLogin();
    }
    public void userLogin() {



        // Login
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is your login username?");
        String user = userInput.nextLine();

        if(data.seed(user)) {
            System.out.println("What is your pin number?");
            String inputPin = userInput.nextLine();
            if (data.authentication(inputPin)) {
                menu(inputPin);
            } else {
                System.out.println("Wrong password");
            }

        } else {
            System.out.println("User does not exist");
        }

    }

    public void menu(String pin) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Hello, welcome to the bank. What account would you like to manage?\ncurrent (c)\njoint (j)\nsavings (s)");
        char account = myScanner.nextLine().charAt(0);
        System.out.println("And what would you like to do with this account? \nView balance (b)\nWithdraw (w)\nDeposit (d)\nTransfer (t)");
        char option = myScanner.nextLine().charAt(0);
        switch (option) {
            case 'b':
                System.out.println("Your account balance for this account is: " +  data.viewBalance(account, pin));
                break;
            case 'w':

                break;
            case 'd':

                break;
            case 't':

                break;

        }

    }


}
