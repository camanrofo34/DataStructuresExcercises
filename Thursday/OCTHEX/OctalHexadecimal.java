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
import org.model.stack.list.Stack;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class OctalHexadecimal {
    Stack<String> octal;
    LinkedList<String> binario;
    LinkedList<String> hexadecimal;
    
    public OctalHexadecimal() {
        this.hexadecimal = new LinkedList<>();
        this.binario = new LinkedList<>();
        this.octal = new Stack<>();
    }
    
    public void startConvertion(){
        String filePathR = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\OCTHEX\\in.oct";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    octal.push(String.valueOf(currentChar));
                }
            }
            OctalBinario();
            BinarioHexadecimal();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String filePathW = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\OCTHEX\\out.hex";

        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<String> iterator = hexadecimal.iterator();
            while(iterator.hasNext()){
                writer.write(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void OctalBinario(){
        while(!octal.isEmpty()){
            String conversion = String.format("%3s", Integer.toBinaryString(Integer.parseInt(octal.pop()))).replace(' ', '0');
            binario.addFirst(conversion.split(""));
        }
    }
    
    public void BinarioHexadecimal(){
        String number="";
        int numberToWork=0;
        while(!binario.isEmpty()){
            number = ArrayToString(binario.pollLastArray(4));
            numberToWork = Integer.parseInt(number, 2);
            String hex = Integer.toHexString(numberToWork);
            hexadecimal.addFirst(hex.toUpperCase());
        }
    }
    
    public String ArrayToString(Object[] nodo){
        StringBuilder answer = new StringBuilder();
        for (Object nod : nodo){
            answer.append(nod != null ? nod.toString() : "");
        }
        return answer.toString();
    }
}
