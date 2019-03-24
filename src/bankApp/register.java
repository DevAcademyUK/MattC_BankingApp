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
       char cont = 'n';
        do {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Hello, welcome to the bank. What account would you like to manage?\ncurrent (c)\njoint (j)\nsavings (s)");
            char account = myScanner.nextLine().charAt(0);
            System.out.println("And what would you like to do with this account? \nView balance (b)\nWithdraw (w)\nDeposit (d)\nTransfer (t)");
            char option = myScanner.nextLine().charAt(0);

            String amount;
            switch (option) {
                case 'b':
                    System.out.println("Your account balance for this account is: " + data.viewBalance(account, pin));
                    break;
                case 'w':
                    System.out.println("Please enter amount for the withdrawal");
                    amount = myScanner.nextLine();
                    System.out.println("Your new account balance is " + data.withdrawal(account, pin, Float.parseFloat(amount)));

                    break;
                case 'd':
                    System.out.println("Please enter amount for the deposit");
                    amount = myScanner.nextLine();
                    System.out.println("Your new account balance is " + data.deposit(account, pin, Float.parseFloat(amount)));

                    break;
                case 't':

                    break;
            }
            System.out.println("Is there anything else you would like help with? (y)es or (n)o");
          cont = myScanner.nextLine().charAt(0);

        } while(cont == 'y');




    }


}
