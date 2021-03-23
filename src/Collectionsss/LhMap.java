package Collectionsss;

import java.util.*;

//It contains only unique elements.
// It may have one null key and multiple null values.
// It is non-synchronized.
// it maintains insertion order.
//the data is stored in the form of nodes
// implementation of the LinkedHashMap is very similar to a doubly-linked list.
//previous key val next
public class LhMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();//insertion order based
        map.put("A",1);//eturns previous value associated with key or null;
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        System.out.println(map.get("F"));//value or null
        System.out.println(map.remove("J"));//he previous value associated with key, or null if there was no mapping
        System.out.println(map.size());
        map.containsKey("A");
        map.containsValue(10);
        System.out.println(map);
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>(16, .75F,true);//access based ordering
        map1.put("A",1);//returns previous value associated with key or null;
        map1.put("B",2);
        map1.put("C",3);
        map1.put("D",4);
        map1.put("A",10);
        System.out.println(map1);
        map1.get("C");
        System.out.println(map1);
        System.out.println();
//        LinkedHashMap<String, Integer> lmap =
//                new LinkedHashMap<String, Integer>() {
//                    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest)
//                    {
//                        return size() > 5;
//                    }
//                };
//        lmap.put("A",1);//returns previous value associated with key or null;
//        lmap.put("B",2);
//        lmap.put("C",3);
//        lmap.put("D",4);
//        lmap.put("E",5);
//
//        System.out.println(lmap);
//        lmap.put("F",6);
//        System.out.println(lmap);
//        lmap.put("G",7);
//        System.out.println(lmap);
        LinkedHashMap<String, Integer> lmap =
                new LinkedHashMap<String, Integer>(16,0.75F,true) {
                    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest)
                    {
                        return size() > 5;
                    }
                };
        lmap.put("A",1);//returns previous value associated with key or null;
        lmap.put("B",2);
        lmap.put("C",3);
        lmap.put("D",4);
        lmap.put("E",5);
        lmap.put("A",5);
        System.out.println(lmap);
        lmap.put("F",6);
        System.out.println(lmap);
        lmap.put("G",7);
        System.out.println(lmap);
    }

}
