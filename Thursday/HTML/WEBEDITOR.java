/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.HTML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.model.LinkedList.doubly.LinkedList;
import org.model.stack.list.Stack;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class WEBEDITOR {

    Stack<String> etiquetaApertura;

    public WEBEDITOR() {
        this.etiquetaApertura = new Stack<>();
    }

    public void Buscador() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\HTML\\in.html"));
        String linea;
        boolean gut = true;
        while ((linea = br.readLine()) != null) {
            Iterator<String> iterator = patrones(linea).iterator();
            while (iterator.hasNext()) {
                String etiqueta = iterator.next();
                if (etiqueta.startsWith("</")) {
                    if (!(etiqueta.substring(2, etiqueta.length() - 1).equals(etiquetaApertura.peek().substring(1, etiquetaApertura.peek().length() - 1)))) {
                        gut = false;
                        System.out.println("Error:" + etiqueta + " no tiene una etiqueta de apertura.");
                        System.out.println("Error:" + etiquetaApertura.pop() + " no tiene una etiqueta de cierre.");
                    } else {
                        etiquetaApertura.pop();
                    }
                } else {
                    etiquetaApertura.push(etiqueta);
                }
            }
        }
        if (gut) {
            System.out.println("OK");
        }

    }

    public LinkedList<String> patrones(String line) {
        LinkedList<String> patterns = new LinkedList<>();
        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String tag = matcher.group();
            patterns.add(tag);
        }
        return patterns;
    }
}
