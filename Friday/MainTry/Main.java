/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Friday.MainTry;

import Friday.BINHEX.BinarioHexadecimal;
import Friday.BINHEX.HexadecimalBinario;
import Friday.Calculator.Calculator;
import Friday.Poly.Poly;
import Friday.SETs.SETs;
import Friday.XML.WEBEDITOR;
import java.io.IOException;
import org.model.LinkedList.doubly.LinkedList;
import org.model.queue.list.Queue;

/**
 *
 * @author PC 4060TI
 */
public class Main {
    public static void main(String[] args) throws IOException {
         //Web editor prueba detecta el error
        WEBEDITOR we = new WEBEDITOR();
        we.Buscador();
        
        //OCTALHEXADECIMAL prueba
        BinarioHexadecimal oh = new BinarioHexadecimal();
        oh.startConvertion();
        
        //HEXADECIMALOCTAL prueba
        HexadecimalBinario ho = new HexadecimalBinario();
        ho.startConvertion();

        //SETs prueba
        LinkedList<String> A = new LinkedList<>();
        A.add("g");
        A.add("a");
        A.add("t");
        A.add("a");
        A.add("c");
        A.add("o");
        A.add("b");
        LinkedList<String> B = new LinkedList<>();
        B.add("t");
        B.add("a");
        B.add("t");
        B.add("c");
        SETs sets = new SETs (A, B);
        sets.data();
        
        //Poly (Asumo la entrada como un txt pq no dice)
        Poly poly = new Poly();
        poly.startConvertion();
        
        //Calculator (Entrada estandar? Osea? Lo importante es que compila,aqui la muestra)
        Queue<Integer> num1 = new Queue<>();
        num1.insert(0);
        num1.insert(2);
        Queue<Integer> num2 = new Queue<>();
        num2.insert(0);
        num2.insert(0);
        num2.insert(4);
        Calculator cl = new Calculator(num2, num1);
        cl.StartDiv();

    }
}
