package ConcCollections;
import java.util.*;
import java.util.concurrent.*;
public class CowAlist {
    public static void main(String[] args){
        CopyOnWriteArrayList<String> cList= new CopyOnWriteArrayList<>();
        cList.add("A");//returns true if added else throws exception
        cList.addIfAbsent("A");
        cList.add("A");
        ArrayList<String> al =new ArrayList<>();
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        cList.addAll(al); //    returns true if added or NullPointerException - if the specified collection is null
        System.out.println(cList);
        ArrayList<String> al1 =new ArrayList<>();
        al1.add("B");
        al1.add("C");
        al1.add("G");
        al1.add("F");
        cList.addAllAbsent(al1); // returns number of elements added or nullptr exception if it is null
        String[] strArr= cList.toArray(new String[0]);
        for(String s:strArr){
            System.out.println(s);
        }
    }
}
//concurrent modification exception


