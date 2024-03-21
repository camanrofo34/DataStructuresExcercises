/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Friday.Poly;

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

    Stack<Double> poly;
    Stack<Double> derivatedPoly;
    Stack<Double> diferencePoly;
    Stack<Double> rangos;

    public Poly() {
        this.poly = new Stack<>();
        this.derivatedPoly = new Stack<>();
        this.diferencePoly = new Stack<>();
        this.rangos = new Stack<>();
    }

    public void startConvertion() {
        String filePathR = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Friday\\Poly\\polys.poly";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("-?\\d+"); // Expresión regular para encontrar números enteros
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    double num = Integer.parseInt(matcher.group());
                    poly.push(num);
                }
            }
            Stack<Double> otherPoly = new Stack<>();
            otherPoly.push(-1.0);
            otherPoly.push(-2.0);
            otherPoly.push(3.0);
            otherPoly.push(4.0);
            sum(otherPoly);
            integrate();
            calculateRange(1, 3);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePathW = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Friday\\Poly\\results.poly";

        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<Double> iterator = derivatedPoly.iterator();
            writer.write("<");
            while (iterator.hasNext()) {
                writer.write(iterator.next() + ", ");
            }
            writer.write(">");
            Iterator<Double> iteratorD = diferencePoly.iterator();
            writer.write("<");
            while (iteratorD.hasNext()) {
                writer.write(iteratorD.next() + ", ");
            }
            writer.write(">");
            Iterator<Double> iteratorR = rangos.iterator();
            while (iteratorR.hasNext()) {
                writer.write(iteratorR.next() + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void integrate() {
        Stack<Double> auxiliar = new Stack<>();
        Stack<Double> samePoly = new Stack<>();
        int tamanio = poly.size();
        for (int i = tamanio; i > 0; i--) {
            Double n = poly.pop();
            samePoly.push(n);
            auxiliar.push(n / i);
        }
        auxiliar.push(0.0);
        auxiliar.reverse();
        samePoly.reverse();
        this.poly = samePoly;
        derivatedPoly = auxiliar;
    }

    public void sum(Stack<Double> sPoly) {
        Stack<Double> auxiliar = new Stack<>();
        Stack<Double> samePoly = new Stack<>();
        int polyS=sPoly.size();
        int ppolyS = poly.size();
        int highLength = Math.max(polyS, ppolyS); // Use Math.max to simplify finding the maximum size

        while (ppolyS < highLength) {
            poly.push(0.0);
            ppolyS++;
        }
        while (polyS < highLength) {
            sPoly.push(0.0);
            polyS++;
        }

        for (int i = highLength - 1; i >= 0; i--) {
            double n = poly.pop();
            samePoly.push(n);
            double dig1 = n;
            double dig2 = sPoly.pop();
            double digF = dig1 + dig2;
            auxiliar.push(digF);
        }
        auxiliar.reverse();
        samePoly.reverse();
        poly=samePoly;
        diferencePoly = auxiliar;
    }

    public void calculateRange(int from, int to) {
        Stack<Double> auxiliar = new Stack<>();
        Stack<Double> samePoly = new Stack<>();
        for (int i = from + 1; i < to; i++) {
            double sum = 0;
            for (int ii = poly.size() - 1; ii >= 0; ii--) {
                double n = poly.pop();
                samePoly.push(n);
                sum += Math.pow(i, ii) * n;
            }
            for (int h = samePoly.size() - 1; h >= 0; h--){
                poly.push(samePoly.pop());
            }
            
            auxiliar.push(sum);
        }
        rangos = auxiliar;
    }
}

