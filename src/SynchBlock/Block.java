package SynchBlock;

import Synch.Account;

public class Block {
    public  static  void  main(String[] args){
        Account acc= new Account();
        ImplementsRunnable nt1=new ImplementsRunnable(acc);
        ImplementsRunnable nt2=new ImplementsRunnable(acc );
        Thread t1=new Thread(nt1,"from place 1");
        Thread t2=new Thread(nt1,"from place 2");
        t1.start();
        t2.start();

    }
}
