package Collectionsss;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.LinkedHashSet;

public class LhSet {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("A");//true if not already present
        set.add("B");
        set.add("C");
        set.add("D");
        System.out.println(set.add("A"));
        System.out.println(set.remove("A"));//true if set contains that element ;
        System.out.println(set.size());
        System.out.println(set.contains("A"));
        System.out.println(set);


    }
    // Mul
//     abcd
//    1*Mul + 2*Mul^2 +


}
