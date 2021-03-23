package ConcCollections;
import java.util.*;
import java.util.concurrent.*;
public class CowASet {
    public static void  main(String[] args){
        CopyOnWriteArraySet<String> cSet= new CopyOnWriteArraySet<>();
        cSet.add("A");
        cSet.add("B");
        char c='A';

        for(int  i=0;i<10;++i){
            String s=""+c;
            c++;
            System.out.println(cSet.add(s));
        }

        System.out.println();
        ArrayList<String > al = new ArrayList<>();
        //weak hashmap,
        al.add("A");
        al.add("B");
        System.out.println(cSet.contains(1));
        System.out.println(cSet.containsAll(al));
    }
}
// 1 2 3 4 5
