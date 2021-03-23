package Synch;

class DepoThread extends Thread{
    Account acc;
    DepoThread(Account acc,String str){
        super(str);
        this.acc=acc;


    }

    @Override
    public void run() {
        for(int i=1;i<=5;++i){

            acc.deposit(1000,this.getName());
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println("Interrupted "+e);
            }
        }
    }
}
