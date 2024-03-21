/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.Calculator;

import org.model.queue.list.Queue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class Calculator {

    public Queue<Integer> num1;
    public Queue<Integer> num2;

    public Calculator(Queue<Integer> num1, Queue<Integer> num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Calculator() {
        this.num1 = new Queue<>();
        this.num2 = new Queue<>();
    }

    public void startRest() {
        Iterator<Integer> iterator = difference(num1, num2).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
    public void StartMod(){
                Iterator<Integer> iterator = modulo(num1, num2).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
        

    public Queue<Integer> difference(Queue<Integer> num1, Queue<Integer> num2) {
        Queue<Integer> resultDiff = new Queue<>();
        Queue<Integer> auxiliar1 = new Queue<>();
        Queue<Integer> auxiliar2 = new Queue<>();
        int highLength = Math.max(num1.size(), num2.size());
        int borrow = 0;
        while (num1.size() < highLength) {
            num1.insert(0);
        }
        while (num2.size() < highLength) {
            num2.insert(0);
        }
        num1.reverse();
        boolean mayor1=mayor(num1, num2);
        if (mayor1) {
            while (!num1.isEmpty()) {
                int digit1 = num1.extract();
                int digit2 = num2.extract();
                auxiliar1.insert(digit1);
                auxiliar2.insert(digit2);
                int digitF = digit1 - digit2 - borrow;
                if (digitF >= 0) {
                    resultDiff.insert(digitF);
                    borrow = 0;
                } else {
                    digitF += 10;
                    borrow = 1;
                    resultDiff.insert(digitF);
                }
            }
        } else {
            while (!num1.isEmpty()) {
                int digit1 = num2.extract();
                int digit2 = num1.extract();
                auxiliar1.insert(digit2);
                auxiliar2.insert(digit1);
                int digitF = digit1 - digit2 - borrow;
                if (digitF >= 0) {
                    if (num1.size() == 0) {
                        digitF = digitF * -1;
                    }
                    resultDiff.insert(digitF);
                    borrow = 0;

                } else {
                    digitF += 10;
                    borrow = 1;
                    if (num1.size() == 0) {
                        digitF = digitF * -1;
                    }
                    resultDiff.insert(digitF);
                }
            }
        }
        
        Iterator<Integer> iteratorA1 = auxiliar1.iterator();
        Iterator<Integer> iteratorA2 = auxiliar2.iterator();
        while (iteratorA1.hasNext()) {
            Integer A1 = iteratorA1.next();
            Integer A2 = iteratorA2.next();
                num1.insert(A1);

                num2.insert(A2);
            
        }
        resultDiff.reverse();
        return resultDiff;
    }
    
    
    public Queue<Integer> modulo(Queue<Integer> num1, Queue<Integer> num2) {
        do{
            num1 = difference(num1, num2);
        }while(mayor(num1, num2));
        num1.reverse();
        return num1;
    }
    
    public boolean mayor(Queue<Integer> num1, Queue<Integer> num2){
        boolean mayor1=true;
        num2.reverse();
        Iterator<Integer> iterator1 = num1.iterator();
        Iterator<Integer> iterator2 = num2.iterator();
        while (iterator1.hasNext()) {
            int dig1 = iterator1.next();
            int dig2 = iterator2.next();
            if (dig1 > dig2) {
                break;
            } else if (dig2 > dig1) {
                mayor1 = false;
                break;
            }
        }
        num2.reverse();
        num1.reverse();
        return mayor1;
    }
}
