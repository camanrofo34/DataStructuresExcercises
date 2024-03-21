/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thursday.STD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.model.LinkedList.singly.LinkedList;
import org.model.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class STD {
    LinkedList<Integer> list;
    float media;
    LinkedList<Integer> moda;
    float mediana;
    LinkedList<Integer> elementos;
    Array<Integer> frecuencias;

    public STD() {
        this.list = new LinkedList<>();
        this.media = (float) 0.0;
        this.moda = new LinkedList<>();
        this.mediana = (float) 0.0;
        this.elementos = new LinkedList<>();
        this.frecuencias = new Array<>();
    }
    
    
    
    public void startCount(){
        String filePathR = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\STD\\std.in";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String firstNumber = line.replaceAll("\\D", "");
                list.add(Integer.parseInt(firstNumber));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        media();
        mediana();
        establecerElementos();
        obtFrecuencias();
        getModa();
        
        String filePathW = "C:\\Users\\PC 4060TI\\Documents\\NetBeansProjects\\ParcialED202410\\src\\main\\java\\Thursday\\STD\\std.out";

        try (FileWriter writer = new FileWriter(filePathW)) {
            writer.write("Media: " + String.valueOf(media)+"\n");
            writer.write("Mediana: " + String.valueOf(mediana)+"\n");
            Iterator<Integer> elemento = elementos.iterator();
            Iterator<Integer> frecuencia = frecuencias.iterator();
            while(elemento.hasNext()){
                writer.write("Frecuencia del " + String.valueOf(elemento.next() + " es de: "+  String.valueOf(frecuencia.next()))+"\n");
            }
            Iterator<Integer> modas = moda.iterator();
            while(modas.hasNext()){
                writer.write("La moda es: " + String.valueOf(modas.next())+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void media(){
        Double[] mediaSum ={0.0};
        list.forEach(e -> {mediaSum[0] += e; return null;});
        float resultado = (float) (mediaSum[0]/list.size());
        this.media=resultado;
    }
    
    public void mediana(){
        float mediana = 0;
        list.sort(e -> e);
        int mid = list.size()/2;
        int i=0;
        Iterator<Integer> iterator = list.iterator();
        if (list.size() % 2 == 1){
            while(i++ < mid){
                iterator.next();
            }
            mediana=iterator.next();
        }
        else{
            while(i++ < mid-1){
                iterator.next();
            }
            mediana+=iterator.next();
            mediana+=iterator.next();
            mediana /= 2;
        }
        this.mediana = mediana;
        
    }
    
    public int count(int n){
        int count =0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next() == n) count++;
        }
        return count;
    }
    
    public void establecerElementos(){
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer numero = iterator.next();
            if (!elementos.contains(numero)) {
                elementos.add(numero);
            }
        }
    }
    
    public void obtFrecuencias(){
        Iterator<Integer> iterator = elementos.iterator();
        frecuencias = new Array<>(elementos.size());
        while (iterator.hasNext()){
            frecuencias.add(count(iterator.next()));
        }
    }
    
    public void getModa(){
        int mayor = 0;
        Iterator<Integer> iterator = elementos.iterator();
        Iterator<Integer> iteratorF = frecuencias.iterator();
        while (iteratorF.hasNext()){
            Integer i = iteratorF.next();
            if (i>mayor) mayor = i;
        }
        for (int i=0; i<elementos.size(); i++){
            Integer s = iterator.next();
            if (frecuencias.get(i) == mayor){
                this.moda.add(s);
            }
        }
    }
    
}
