package SynchBlock;

import Synch.Account;

public class ImplementsRunnable implements Runnable{
    Account acc;
    ImplementsRunnable(Account acc){

        this.acc=acc;


    }

    @Override
    public void run() {
        for(int i=1;i<=5;++i){
            // acc object is locked perform block and releases lock
            // prevents other thread from entering into a synchronised block of this object
            synchronized (acc) {
                acc.withdraw(1000, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Interrupted " + e);
                }
            }
        }
    }
}
