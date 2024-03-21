/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thurdsay.MainTry;

import Thursday.Calculator.Calculator;
import Thursday.HTML.WEBEDITOR;
import Thursday.OCTHEX.HexadecimalOctal;
import Thursday.OCTHEX.OctalHexadecimal;
import Thursday.Poly.Poly;
import Thursday.STD.STD;
import java.io.IOException;
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
        OctalHexadecimal oh = new OctalHexadecimal();
        oh.startConvertion();
        
        //HEXADECIMALOCTAL prueba
        HexadecimalOctal ho = new HexadecimalOctal();
        ho.startConvertion();
        
        //STD prueba
        STD std = new STD();
        std.startCount();
        
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
        Calculator cl = new Calculator(num1, num2);
        cl.StartMod();

    }
}
