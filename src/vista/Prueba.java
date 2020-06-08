/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import util.Secuencia;

/**
 *
 * @author OMAR
 */
public class Prueba {

    public static <T extends Comparable<T>> Secuencia<T> shellSort(Secuencia<T> array) {
        long inicio = System.currentTimeMillis();
        long contador = 0;
        int j;
        T val;
        for (int gap = array.getTamanio() / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.getTamanio(); i++) {
                val = array.get(i);
                for (j = i; j >= gap && array.get(j - gap).compareTo(val) > 0; j -= gap) {
                    array.set(j, array.get(j - gap));
                    contador++;
                }
                array.set(j, val);
                contador++;
            }
        }

        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio));

        String result = "shellSort1 \nTiempo: " + tiempo + " mseg.\n#N: " + array.getTamanio() + "\n#Iteraciones: " + String.format("%,d", contador) + "\n";

        System.out.println(result);

        return array;
    }

    public static <T extends Comparable<T>> Secuencia<T> shellSortUpdate(Secuencia<T> array) {
        long inicio = System.currentTimeMillis();
        long contador = 0;
        int j;
        T val;
        for (int gap = (int) (array.getTamanio() / 2.25); gap > 0; gap /= 2.25) {

            for (int i = gap; i < array.getTamanio(); i++) {
                val = array.get(i);
                for (j = i; j >= gap && array.get(j - gap).compareTo(val) > 0; j -= gap) {
                    array.set(j, array.get(j - gap));
                    contador++;
                }
                array.set(j, val);
                contador++;
            }
        }

        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio));

        String result = "shellSortUpdate \nTiempo: " + tiempo + " mseg.\n#N: " + array.getTamanio() + "\n#Iteraciones: " + String.format("%,d", contador) + "\n";

        System.out.println(result);

        return array;
    }

    public static void main(String[] args) {

        int[] sizes = new int[]{40000, 80000, 120000, 160000, 200000, 240000, 280000, 320000, 360000, 400000, 440000, 480000, 520000};

        for (int size : sizes) {

            Secuencia s1 = new Secuencia(size);
            Secuencia s2 = new Secuencia(size);

            int cont = size;
            for (int i = 0; i < size; i++) {

                s1.insertar(cont);
                s2.insertar(cont);

                cont--;
            }
            
            System.out.println("SECUENCIA ORDENADA DESCENDENTEMENTE");
            shellSort(s1);
            shellSortUpdate(s2);
            

            Secuencia s3 = new Secuencia(size);
            Secuencia s4 = new Secuencia(size);
            Random rng = new Random();
            Set<Integer> generated = new LinkedHashSet<>();
            while (generated.size() < size) {
                generated.add(rng.nextInt(size) + 1);
            }
            for (Integer integer : generated) {
                s3.insertar(integer);
                s4.insertar(integer);
            }
            
            System.out.println("SECUENCIA DESORDENADA ALEATORIAMENTE");
            shellSort(s3);
            shellSortUpdate(s4);
        }

    }

}
