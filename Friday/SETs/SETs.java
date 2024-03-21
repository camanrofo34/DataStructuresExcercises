/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Friday.SETs;

import org.model.LinkedList.doubly.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class SETs {

    LinkedList<String> A;
    LinkedList<String> B;
    LinkedList<String> Q;
    LinkedList<String> R;

    public SETs(LinkedList<String> A, LinkedList<String> B) {
        this.A = A;
        this.B = B;
        this.Q = new LinkedList();
        this.R = new LinkedList();
    }
    
    public void data(){
        intersection();
        difference();
        Iterator<String> iteratorQ = Q.iterator();
        Iterator<String> iteratorR = R.iterator();
        System.out.print("{");
        while(iteratorQ.hasNext()){
            System.out.print(iteratorQ.next() + ", ");
        }
        System.out.println("}");
        System.out.print("{");
        while(iteratorR.hasNext()){
            System.out.print(iteratorR.next() + ", ");
        }
        System.out.println("}");
    }
    

    public void intersection() {
        Iterator<String> iteratorA = A.iterator();
        while (iteratorA.hasNext()) {
            String a = iteratorA.next();
            if (B.contains(a) && !Q.contains(a)) {
                Q.add(a);
            }
        }
    }

    public void difference() {
        Iterator<String> iteratorA = A.iterator();
        while (iteratorA.hasNext()) {
            String a = iteratorA.next();
            if (!B.contains(a) && !R.contains(a)) {
                R.add(a);
            }
        }
    }
}
