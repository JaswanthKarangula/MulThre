package StatSynchronization;

 class StatThread implements Runnable{

    StatThread(){

    }

    @Override
    public void run() {
        for (int i=0;i<10;++i){
            StaticCount.increment(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                //
            }
        }

    }
}
