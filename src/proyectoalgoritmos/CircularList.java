/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoalgoritmos;

/**
 * Representa una lista circular que permite agregar métodos y mostrar su complejidad.
 * Cada nodo de la lista contiene un método representado como una cadena de texto.
 * La lista tiene una referencia al nodo cabeza (head) y al nodo cola (tail).
 * 
 * @author Personal
 */
public class CircularList {

    private Node head = null;
    private Node tail = null;

    /**
     * Agrega un nuevo método a la lista circular.
     * Si la lista está vacía, el nuevo nodo se convierte en el nodo cabeza y cola.
     * Si la lista no está vacía, el nuevo nodo se añade al final de la lista y la cola se actualiza.
     *
     * @param methodName El nombre del método a agregar a la lista.
     * @param methodBody El cuerpo del método a agregar a la lista.
     */
    public void add(String methodName, String methodBody) {
        Node newNode = new Node(methodName, methodBody);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    /**
     * Muestra todos los métodos almacenados en la lista circular.
     * Recorre la lista desde la cabeza y muestra cada método hasta volver a la cabeza.
     */
    public void displayMethods() {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            System.out.println("Método:   " + current.methodName);
            current = current.next;
        } while (current != head);
    }

    /**
     * Muestra la complejidad de todos los métodos almacenados en la lista circular.
     * Recorre la lista desde la cabeza, estima y muestra la complejidad de cada método.
     */
    public void displayComplexities() {
        if (head == null) {
            return;
        }

        Node current = head;
        do {
            String complexity = ComplexityAnalyzer.estimateComplexity(current.methodBody);
            System.out.println("Método:  " + current.methodName
            + " - Complejidad:  " + complexity);
            current = current.next;
        } while (current != head);
    }

 
   
}
