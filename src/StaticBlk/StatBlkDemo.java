package StaticBlk;



public class StatBlkDemo {
    public  static void main(String[] args){
        StatBlkThread1 inc= new StatBlkThread1();
        Thread t1=new Thread(inc,"from inc thread");
        StatBlkThread2 dec= new StatBlkThread2();
        Thread t2=new Thread(dec,"from dec thread");
        t1.start();
        t2.start();
    }
}

//what happens if main exits before child method
//will main exit earlier