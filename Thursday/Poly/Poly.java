/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.Poly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.model.stack.list.Stack;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class Poly {

    Stack<Integer> poly;
    Stack<Integer> derivatedPoly;
    Stack<Integer> diferencePoly;
    Stack<Integer> rangos;

    public Poly() {
        this.poly = new Stack<>();
        this.derivatedPoly = new Stack<>();
        this.diferencePoly = new Stack<>();
        this.rangos = new Stack<>();
    }

    public void startConvertion() {
        String filePathR = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\Poly\\polys.poly";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("-?\\d+"); // Expresión regular para encontrar números enteros
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    int num = Integer.parseInt(matcher.group());
                    poly.push(num);
                }
            }
            Stack<Integer> otherPoly = new Stack<>();
            otherPoly.push(-1);
            otherPoly.push(-2);
            otherPoly.push(3);
            otherPoly.push(4);
            diference(otherPoly);
            derivate();
            calculateRange(1, 3);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePathW = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\Poly\\results.poly";

        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<Integer> iterator = derivatedPoly.iterator();
            writer.write("<");
            while (iterator.hasNext()) {
                writer.write(iterator.next() + ", ");
            }
            writer.write(">");
            Iterator<Integer> iteratorD = diferencePoly.iterator();
            writer.write("<");
            while (iteratorD.hasNext()) {
                writer.write(iteratorD.next() + ", ");
            }
            writer.write(">");
            Iterator<Integer> iteratorR = rangos.iterator();
            while (iteratorR.hasNext()) {
                writer.write(iteratorR.next() + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void derivate() {
        Stack<Integer> auxiliar = new Stack<>();
        Stack<Integer> samePoly = new Stack<>();
        int tamanio = poly.size();
        for (int i = tamanio - 1; i >= 0; i--) {
            Integer n = poly.pop();
            samePoly.push(n);
            auxiliar.push(n * i);
        }
        auxiliar.reverse();
        samePoly.reverse();
        this.poly = samePoly;
        derivatedPoly = auxiliar;
    }

    public void diference(Stack<Integer> sPoly) {
        Stack<Integer> auxiliar = new Stack<>();
        Stack<Integer> samePoly = new Stack<>();
        int polyS=sPoly.size();
        int ppolyS = poly.size();
        int highLength = Math.max(polyS, ppolyS); // Use Math.max to simplify finding the maximum size

        while (ppolyS < highLength) {
            poly.push(0);
            ppolyS++;
        }
        while (polyS < highLength) {
            sPoly.push(0);
            polyS++;
        }

        for (int i = highLength - 1; i >= 0; i--) {
            Integer n = poly.pop();
            samePoly.push(n);
            int dig1 = n;
            int dig2 = sPoly.pop();
            int digF = dig1 - dig2;
            auxiliar.push(digF);
        }
        auxiliar.reverse();
        samePoly.reverse();
        poly=samePoly;
        diferencePoly = auxiliar;
    }

    public void calculateRange(int from, int to) {
        Stack<Integer> auxiliar = new Stack<>();
        Stack<Integer> samePoly = new Stack<>();
        for (int i = from + 1; i <= to; i++) {
            int sum = 0;
            for (int ii = poly.size() - 1; ii >= 0; ii--) {
                Integer n = poly.pop();
                samePoly.push(n);
                sum += (int) Math.pow(i, ii) * n;
            }
            for (int h = samePoly.size() - 1; h >= 0; h--){
                poly.push(samePoly.pop());
            }
            
            auxiliar.push(sum);
        }
        rangos = auxiliar;
    }
}
