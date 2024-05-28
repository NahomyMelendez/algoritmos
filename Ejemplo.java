/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

import Listas.NodoPersona;

/**
 *
 * @author Personal
 */
public class Ejemplo {
 


    /**
     * Constructor predeterminado para la clase Ejemplo.
     */
    public Ejemplo() {
        // Constructor predeterminado vacío
    }

    /**
     * Método principal.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("Hola, mundo!");
    }

    /**
     * Un método de ejemplo con complejidad O(n).
     */
    public void metodoEjemplo1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Método Ejemplo 1, iteración " + i);
        }
    }

    /**
     * Otro método de ejemplo con complejidad O(n^2).
     *
     * @param n El parámetro de tamaño del problema.
     */
    public void metodoEjemplo2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Método Ejemplo 2, iteración " + i + ", " + j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Método Ejemplo 2, iteración " + i + ", " + j);
            }
        }
    }

    /**
     * Método de ejemplo con complejidad O(n^6).
     *
     * @param n El parámetro de tamaño del problema.
     */
    public void metodoEjemplo3(int n) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    for (int d = 0; c < n; d++) {
                        for (int e = 0; c < n; e++) {
                            for (int f = 0; c < n; f++) {
                                System.out.println("Método Ejemplo 3, iteración " + a + ", " + b + ", " + c + ", " + d + ", " + e + ", " + f);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Método con complejidad O(log n).
     *
     * @param n El parámetro de tamaño del problema.
     */
    public void metodoLogaritmico(int n) {
        for (int i = 1; i < n; i *= 2) {
            System.out.println("Método Logaritmico, iteración " + i);
        }
    }

    /**
     * Método con complejidad O(n log n).
     *
     * @param n El parámetro de tamaño del problema.
     */
    public void metodoNLogN(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                System.out.println("Método N Log N, iteración " + i + ", " + j);
            }
        }
    }

    /**
     * Método con complejidad O(n^3).
     *
     * @param n El parámetro de tamaño del problema.
     */
    public void metodoCubico(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("Método Cúbico, iteración " + i + ", " + j + ", " + k);
                }
            }
        }
    }
}



    
    
    
    
    
    
    

