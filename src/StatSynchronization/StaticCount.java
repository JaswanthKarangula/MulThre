package StatSynchronization;

public class StaticCount {
    private static  int count=0;

    StaticCount(){
    }

     public  static    void increment(String from ){

            count++;
            try {
                Thread.sleep(200);
            }
            catch (Exception e) {
            }
            System.out.println("Count is  " + count + "  " + from);


    }
     public   static  void decrement(String from ){
        synchronized (StaticCount.class) {
            count--;
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            System.out.println("Count is  " + count + "  " + from);
        }
    }
}