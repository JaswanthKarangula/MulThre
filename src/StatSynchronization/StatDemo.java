package StatSynchronization;

 class StatDemo {
    public static  void main(String[] args){
        StatThread inc= new StatThread();
        Thread t1=new Thread(inc,"from inc thread");
        StatThread1 dec= new StatThread1();
        Thread t2=new Thread(dec,"from dec thread");
        t1.start();
        t2.start();
    }
}
