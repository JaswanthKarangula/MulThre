package StatSynchronization;

 class StatThread1 implements Runnable{

    StatThread1(){

    }

    @Override
    public void run() {
        for (int i=0;i<10;++i){
            StaticCount.decrement(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                //
            }
        }

    }
}
