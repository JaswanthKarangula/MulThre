package Collectionsss;

import java.util.WeakHashMap;

public class WeakHMap {
    public static void main(String[] ars) {
        WeakHashMap<String, Integer> wmap = new WeakHashMap<>();
        {
            String s = "A";
            wmap.put(s,1);
            s=null;
        }
        //returns previous value associated with key or nulll;
        wmap.put(new String("B"),2);
        wmap.put("C",3);
        wmap.put("D",4);
        System.out.println(wmap);
        System.gc();
        try{

            Thread.sleep(1000);
        }
        catch (Exception e){
            //
        }

        System.out.println(wmap);
    }

}
