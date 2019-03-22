package bankApp;

public class Current {


        private float balance = 3000;

        public float getBalance() {
            return balance;
        }

        public void addDeposit(float deposit) {
            balance = balance + deposit;
        }

        public void takeWithdrawal(float withdraw) {
            balance = balance - withdraw;
        }

        public void transferMoney() {

        }

}
