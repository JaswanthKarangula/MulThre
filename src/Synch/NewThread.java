package Synch;

 class NewThread implements Runnable{
    Account acc;
    NewThread(Account acc){
        this.acc=acc;

    }

    @Override
    public void run() {

        for(int i=1;i<=5;++i){

            acc.withdraw(1000,Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println("Interrupted "+e);
            }
        }
    }
}
