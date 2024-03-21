/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.OCTHEX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.model.LinkedList.doubly.LinkedList;
import org.model.array.Array;
import org.model.stack.list.Stack;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class HexadecimalOctal {
    public Stack<String> hexadecimal;
    public LinkedList<String> binario;
    public LinkedList<String> octal;

    public HexadecimalOctal() {
        this.hexadecimal = new Stack<>();
        this.binario = new LinkedList<>();
        this.octal = new LinkedList<>();
    }
    
        public void startConvertion(){
        String filePathR = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\OCTHEX\\in.hex";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    hexadecimal.push(String.valueOf(currentChar));
                }
            }
            HexaBinario();
            BinarioOct();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String filePathW = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\OCTHEX\\out.oct";

        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<String> iterator = octal.iterator();
            while(iterator.hasNext()){
                writer.write(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void HexaBinario(){
        while(!hexadecimal.isEmpty()){
            String conversion = String.format("%4s", Integer.toBinaryString(Integer.parseInt(hexadecimal.pop(), 16))).replace(' ', '0');
            binario.addFirst(conversion.split(""));
        }
    }
    
    public void BinarioOct(){
        String number="";
        int numberToWork=0;
        while(!binario.isEmpty()){
            number = ArrayToString(binario.pollLastArray(3));
            numberToWork = Integer.parseInt(number, 2);
            String oct = Integer.toOctalString(numberToWork);
            octal.addFirst(oct);
        }
    }
    
    public String ArrayToString(Object[] nodo) {
        StringBuilder answer = new StringBuilder();
        for (Object nod : nodo) {
            answer.append(nod != null ? nod.toString() : "");
        }
        return answer.toString();
    }
}
