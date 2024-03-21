/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Friday.BINHEX;

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
public class HexadecimalBinario {

    public Stack<String> hexadecimal;
    public LinkedList<String> binario;

    public HexadecimalBinario() {
        this.hexadecimal = new Stack<>();
        this.binario = new LinkedList<>();
    }
    
        public void startConvertion() {
        String filePathR = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Friday\\BINHEX\\in.hex";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    hexadecimal.push(String.valueOf(currentChar));
                }
            }
            HexaBinario();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePathW = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Friday\\BINHEX\\out.bin";

        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<String> iterator = binario.iterator();
            while (iterator.hasNext()) {
                writer.write(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HexaBinario() {
        while (!hexadecimal.isEmpty()) {
            String conversion = String.format("%4s", Integer.toBinaryString(Integer.parseInt(hexadecimal.pop(), 16))).replace(' ', '0');
            binario.addFirst(conversion.split(""));
        }
    }
}
