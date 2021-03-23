package ConcCollections;
import  java.util.concurrent.*;
import java.util.*;
class Thread1 extends Thread{
    private ConcurrentHashMap<Integer, String> map;
    Thread1(ConcurrentHashMap<Integer, String> map,String s){
        super(s);
        this.map=map;
    }

    @Override
    public void run() {
        char c='A';
        for(int i=0;i<10;++i){
            Integer key =i;
            String s=""+c;
            c++;
            if(map.putIfAbsent(key, s) == null) {
                System.out.println("Inserted   key -- "+key +"  val --- "+s+ "  in thread "+this.getName());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        Integer key =1;
        String s=""+c;
        c++;
        if(map.put(key, s) !=null) {
            System.out.println("Updated   key -- "+key +"  val --- "+s+ "  in thread "+this.getName());
        }
    }
}
public class ConcHmap {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        Thread1 t= new Thread1(map,"thread1 ");
        //map.put(null,"str");
        //map.put(199,null);
        map.put(1000,"s");
        t.start();
        try{
            Thread.sleep(1000);

        }
        catch (Exception e){

        }
        Set<Integer> ks= map.keySet();
        for(Integer key :ks){
            System.out.println("from  "+Thread.currentThread().getName() + "  key ---"+key +"   val --"+map.get(key));
            try{
                Thread.sleep(1000);

            }
            catch (Exception e){

            }
        }
        System.out.println(map);
    }
}
//bucket