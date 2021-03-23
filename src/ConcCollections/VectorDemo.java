package ConcCollections;


import java.util.Iterator;
import java.util.Vector;

class VectorDemo extends Thread {
    private static Vector<String> vct = new Vector<>();

    VectorDemo() {


    }

    @Override
    public void run() {
        char c = 'M';
        for (int i = 1; i <= 10; ++i) {
             synchronized (vct) {
                String s = "" + c;
                System.out.println("Updating in thread");
                vct.add(s);
                c++;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Interrupted " + e);
                }

            }

        }
    }


    public static void main(String [] args){
        vct.add("A");
        vct.add("B");
        vct.add(null);
        VectorDemo t =new VectorDemo();
        t.start();

        Iterator<String> itr = vct.iterator();
        synchronized (vct) {
            while (itr.hasNext()) {
                String curr = itr.next();
                System.out.println("from main   " + curr);
                // itr.remove();//does not support add set using iterator throws unsupported exception
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //
                }
            }
        }
    }
}
