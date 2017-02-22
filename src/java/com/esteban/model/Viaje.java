/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esteban.model;

import java.util.*;

/**
 *
 * @author esteban
 */
public class Viaje {

    /**
     * Para determinar el número de viajes máximo permitido empareja los
     * elementos de mayor valor con los de menos valor, dependiedo de cuantos
     * elementos deban acompañar dicho elemento.
     *
     * @param pesos: Listado de los pesos en libras que tienen los elementos un
     * viaje
     * @return Un entero que indica el número de viajes máximos que pueden
     * hacerse
     */
    public int numero_max_viajes(List pesos) {
        int viajes = 0;
        while (pesos.size() > 1) {
            System.out.println("Pesos antes de operar: " + pesos);
            List emparejados = emparejar(pesos);
            pesos = emparejados;
            System.out.println("Esta es la longitud de pesos: " + pesos.size());
            System.out.println("Pesos como emparejados: " + pesos);
            viajes += 1;
        }
        return viajes;
    }

    /**
     * Determina el número de elementos que deben acompañar a uno determinado
     * para que un viaje sea válido
     *
     * @param max número máximo al que se le desea descubrir cuantos elementos
     * deben acompañarlo en la bolsa para que un viaje con el sea válido
     * @return un entero con el número de unidades necesarias en un viaje
     */
    private int elem_x_bolsa(int peso_elemento) {
        System.out.println("Peso de elemento: " + peso_elemento);
        int valor_minimo, peso_total, contador;
        contador = 0;
        peso_total = 0;
        valor_minimo = 50;
        while (peso_total < valor_minimo) {
            contador += 1;
            System.out.println("Encontrando el los elementos que lo acompañarán...");
            peso_total = peso_elemento * contador;
            System.out.println("Peso con "+contador+" elementos: "+peso_total);
            if (peso_total >= valor_minimo) {
                return contador - 1;
            }
            System.out.println("Unidades definidas: " + contador);
        }
        return contador - 1;
    }

    /**
     * Remover aquellos elementos que van cumpliendo con las condiciones para
     * acompañar a un elemento
     *
     * @param pesos Listado de los pesos
     * @return Un array con los elementos que no fueron usados aun por el
     * emparejamiento
     */
    private List emparejar(List pesos) {
        int maximo = (int) max(pesos);
        System.out.println("Máxmio valor: " + maximo);
        int elem_x_bolsa = elem_x_bolsa(maximo);
        System.out.println("Viajes para el valor: " + elem_x_bolsa);
        pesos.remove(Integer.valueOf(maximo));
        System.out.println("Removido máximo: " + pesos);
        for (int i = 0; i < elem_x_bolsa; i++) {
            // Se asigna uno menor con la base de que nunca va a necesitar más
            // elementos que aquel a que está siendo evaluado
            int minimo = (int) min(pesos);
            System.out.println("Minimo para acompañar: " + minimo);
            pesos.remove(Integer.valueOf(minimo));
            System.out.println("Mínimo removido: " + pesos);
            boolean quedan_viajes = quedan_viajes(pesos);
            System.out.println("Quedan viajes: " + quedan_viajes);
            if (quedan_viajes) {
                pesos.clear();
                break;
            }

        }
        return pesos;
    }

    /**
     * Determina si quedan aun pesos válidos para armar otro viaje
     *
     * @param pesos
     * @return true en caso de que no quede opción para armar otro viaje en
     * vista de no existir los elementos necesarios
     */
    private boolean quedan_viajes(List pesos) {
        if (!pesos.isEmpty()) {
            int maximo = (int) max(pesos);
            int elem_x_bolsa = this.elem_x_bolsa(maximo);
            return (pesos.size() <= elem_x_bolsa);
        } else {
            return false;
        }
    }

    /**
     * Máximo elemento de una lista
     *
     * @param elemento lista de la que se desea extraer máximo valor
     * @return Objeto con el máximo valor
     */
    private Object max(List elemento) {
        System.out.println("Buscar máximo en este elemnto: " + elemento);
        Object max = null;
        if (!elemento.isEmpty()) {
            max = Collections.max(elemento);
        }
        System.out.println("Se concluye que el máximo es este: "+max);
        return max;
    }

    /**
     * Mínimo elemento de una lista
     *
     * @param elemento lista de la que se desea extraer máximo valor
     * @return Objeto con el máximo valor
     */
    private Object min(List elemento) {
        Object min = null;
        if (!elemento.isEmpty()) {
            min = Collections.min(elemento);
        }
        return min;
    }
}
