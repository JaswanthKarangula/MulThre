package StaticBlk;

import StatSynchronization.StaticCount;

public class StatBlkThread1 implements Runnable{
    StatBlkThread1(){

    }

    @Override
    public void run() {
        for(int i=0;i<10;++i){

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
