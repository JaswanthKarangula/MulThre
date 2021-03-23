package ConcCollections;
import java.util.*;
import java.util.concurrent.*;

//fail first
//fail safe
//vector hashtable -- cme example

class NewThread extends Thread{
     private static CopyOnWriteArrayList<String> cList=new CopyOnWriteArrayList<>();
    NewThread( ){


    }

    @Override
    public void run() {
        char c='M';
        for(int i=1;i<=10;++i){

           String s=""+c;

            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println("Interrupted "+e);
            }
            System.out.println("Updating in thread");
            cList.add(s);
            c++;

        }
    }
    public static void main(String [] args){
        cList.add("A");
        cList.add("B");
        cList.add(null);
        NewThread t =new NewThread();
        t.start();
        Iterator<String> itr = cList.iterator();
        while(itr.hasNext()){
            String curr= itr.next();
            System.out.println("from main   "+ curr);
            // itr.remove();//does not support add set using iterator throws unsupported exception
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                //
            }
        }
        try{
            t.join();
        }
        catch (Exception e){
            //
        }
        System.out.println(cList);
    }
}

