package Collectionsss;

import java.lang.ref.WeakReference;
class Temp{
    int a;
    String b;
    Temp(){

    }
    Temp(int a,String b){
        this.a=a;
        this.b=b;
    }
    public String toString(){
        return ""+a+"     "+b;
    }
}
public class Referencess {
    public static void main(String[] arg) {
        // garbage collector
        //strong reference
//        Temp temp=new Temp(10,"weak");
//        WeakReference<Temp1> wref = new WeakReference<>(temp);
//        System.out.println(wref.get());
//        temp =null;
//        System.out.println(wref.get());
//        System.gc();
//        System.out.println(wref.get());
        // soft reference only removes object when jvm highly needs memory

    }

}
