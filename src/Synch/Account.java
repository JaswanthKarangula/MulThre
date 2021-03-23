package Synch;


public  class Account {
    private int balance = 10000;
    private int minBalance=5000;
    public int getBalance() {
        return balance;
    }
    public     void withdraw(int amount,String place) {
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Interrupted Exception");
        }
        if(balance-amount>=minBalance){


            System.out.println("Withdrawn  from "+ place +"  rem balance "+ (balance-amount));
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println("Interrupted Exception");
            }

            balance-=amount;

        }
        else{
            System.out.println("less than minimum Balance  from " + place);
            System.out.println(" rem balance  "+balance);
        }
    }
    public void deposit(int amount,String place){

        System.out.println("Withdrawn  from "+ place +"  rem balance "+balance);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Interrupted Exception");
        }
        balance+=amount;

    }

}