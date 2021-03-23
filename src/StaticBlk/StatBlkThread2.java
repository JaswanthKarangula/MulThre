package StaticBlk;

import StatSynchronization.StaticCount;

public class StatBlkThread2 implements Runnable{
    StatBlkThread2(){

    }

    @Override
    public void run() {

        for (int i = 0; i < 10; ++i) {

                StaticCount.decrement(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }

        }
    }
}
