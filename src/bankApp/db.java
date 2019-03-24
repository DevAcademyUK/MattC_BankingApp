package bankApp;

public class db {

    private String userName;
    private String firstName;
    private String surname;
    private String dob;
    private String pin = "";
    private float cBal = 0;
    private float sBal = 0;
    private float jBal = 0;

    public void createUser(String userData[]) {
        this.userName = userData[0];
        this.firstName = userData[1];
        this.surname = userData[2];
        this.dob = userData[3];
        this.pin = userData[4];
        this.cBal = Float.parseFloat(userData[5]);
        this.sBal = Float.parseFloat(userData[6]);
        this.jBal = Float.parseFloat(userData[7]);


    }
    public boolean seed(String user) {
      //  db userData = new db();
        String data[] = {"Bob1", "Bob", "Marley", "08/07/47", "1234", "500", "600", "700"};
        createUser(data);
        return true;
    }

    public boolean authentication(String givenPin) {
        if(givenPin.equals(pin)) {
            return true;
        } else
        {
            return false;
        }
    }

    public String viewBalance(char account, String pin) {
        String balance = "";
        if(authentication(pin)) {
            switch (account) {
                case 'c' :
                    balance = Float.toString(cBal);
                    break;
                case 's':
                    balance =  Float.toString(sBal);
                    break;
                case 'j':
                    balance =  Float.toString(jBal);
                    break;
                default :
                    balance = "Error, account does not exist";
            }
        } else {
            balance = "Error, access denied";
        }
        return balance;
    }

    public String withdrawal(char account, String pin, Float amount) {
        String balance = "";
        if(authentication(pin)) {

            switch (account) {
                case 'c' :
                    cBal = cBal - amount;
                    balance = Float.toString(cBal);

                    break;
                case 's':
                    sBal = sBal - amount;
                    balance = Float.toString(sBal);
                    break;
                case 'j':
                    jBal = jBal - amount;
                    balance = Float.toString(jBal);
                    break;
                default :
                    balance = "Error, account does not exist";
            }
        } else {
            return "Error, access denied";
        }
        return balance;

    }

    public String deposit(char account, String pin, Float amount) {
        String balance = "";
        if (authentication(pin)) {
            switch (account) {
                case 'c':
                    cBal = cBal + amount;
                    balance = Float.toString(cBal);

                    break;
                case 's':
                    sBal = sBal + amount;
                    balance = Float.toString(sBal);
                    break;
                case 'j':
                    jBal = jBal + amount;
                    balance = Float.toString(jBal);
                    break;
                default:
                    balance = "Error, account does not exist";
            }
        } else {
            return "Error, access denied";
        }
        return balance;
    }

    public String transfer(char fromAccount, char toAccount, String pin, Float amount) {
        String result = "";
        if (authentication(pin)) {
            switch (fromAccount) {
                case 'c':
                    cBal = cBal - amount;
                    if(toAccount == 's') {
                        sBal = sBal + amount;
                        result = "Sucessfully transfered";
                    } else if (toAccount == 'j')
                    {
                        jBal = jBal + amount;
                        result = "Sucessfully transfered";
                    } else {
                        cBal = cBal + amount;
                        result = "error in transfers";
                    }

                    break;
                case 's':
                    sBal = sBal - amount;
                    if(toAccount == 'c') {
                        cBal = cBal + amount;
                        result = "Sucessfully transfered";
                    } else if (toAccount == 'j')
                    {
                        jBal = jBal + amount;
                        result = "Sucessfully transfered";
                    } else {
                        sBal = sBal + amount;
                        result = "error in transfers";
                    }
                    break;
                case 'j':
                    jBal = jBal - amount;
                    if(toAccount == 's') {
                        sBal = sBal + amount;
                        result = "Sucessfully transfered";
                    } else if (toAccount == 'c')
                    {
                        cBal = cBal + amount;
                        result = "Sucessfully transfered";
                    } else {
                        jBal = jBal + amount;
                        result = "error in transfers";
                    }
                    break;
                default:
                    result = "Error, account does not exist";
            }
        } else {
            return "Error, access denied";
        }
        return result;
    }
}
