package Synch;

public class Temp {
    public  static  void  main(String[] args){


        Account acc= new Account();
        NewThread nt1=new NewThread(acc );
        NewThread nt2=new NewThread(acc );
        Thread t1=new Thread(nt1,"from place 1");
        Thread t2=new Thread(nt2,"from place 2");
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){

        }
        System.out.println("Remaining balance after all operations   "+acc.getBalance());
//        NewThread1 nt1=new NewThread1(acc ,"from place 1");
//        NewThread1 nt2=new NewThread1(acc ,"from pace 2");
//        nt1.start();
//        nt2.start();


    }
}

