/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

/**
 * Esta clase representa un nodo en una estructura de datos enlazada.
 * Cada nodo contiene una cadena de texto que representa un método
 * y una referencia al siguiente nodo en la lista.
 * 
 * @author Personal
 */
public class Node {
    
        String methodName;
        String methodBody;
        Node next;

        Node(String methodName, String methodBody) {
            this.methodName = methodName;
            this.methodBody = methodBody;
            this.next = null;
        }
    }
    
    
    
    
    

