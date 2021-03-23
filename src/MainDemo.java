

public class MainDemo {
    public static void main(String[] args){
        ImplementsRunnable imp=new ImplementsRunnable();
        Thread t=new Thread(imp);
        t.start();
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){
            //
        }
        System.out.println("from main");

         System.exit(0);
        //daemon thread --low priority thread runs in background ex--garbage collection
        //even if daemon thread is running JVM can exit
        //jvm terminates running daemon thread if all non daemon threads finishes;
    }
}

 class ImplementsRunnable implements Runnable{

    ImplementsRunnable(){




    }

    @Override
    public void run() {
        for(int i=1;i<=10;++i){
            // acc object is locked perform block and releases lock
            // prevents other thread from entering into a synchronised block of this object

                System.out.println("from child   "+i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Interrupted " + e);
                }

        }
    }
}

