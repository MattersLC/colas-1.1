package Colas;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class abcOrdenado {
    
    public  Scanner sc = new Scanner (System.in);
    public Queue<Character> cola = new LinkedList();
    public LinkedList <Character> lista = new LinkedList();
    public int opc, numero, tope, pos, aux, aux2;
    public char letra, add;
    
    public void menu3() {
        System.out.println("*************** M E N Ú ***************");
        System.out.print("1 - Llenar cola.\n"
                       + "2 - Mostrar cola.\n"
                       + "3 - Ordenar cola.\n"
                       + "4 - Eliminar elementos de la cola.\n"
                       + "5 - Agregar elementos en la cola.\n"
                       + "6 - Salir.\n"
                       + "Tu respuesta: ");
        opc = sc.nextInt();
    }
    
    public void isEmpty() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - -¡Cola  vacía!- - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public void isFull() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - -¡Cola  llena!- - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public void llenar() {
        // La cola se llena con letras aleatorias.
        System.out.println("\nLlenando cola...");
        for (int i=0; i<26; i++) {
            if (tope<26) {
                numero = (int)(Math.random()*(91-65)+65);
                letra = (char) numero;
                cola.add(letra);
                letra++;
                tope++;
            }
        }
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public void mostrar() {
        // Si 'tope' tiene un elemento o más, muestro la queue, sino, llamo a isEmpty();
        if (tope > 0){
            if (lista.isEmpty()) {
                System.out.println("\nMostrando cola:\n");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println(cola);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
            } else {
                System.out.println("\nMostrando cola:\n");
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
                System.out.println(lista);
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
            }
            
        } else {
            isEmpty();
        }
    }
    
    public void ordenar() {
        // si tope tiene un elemento o m[as, ordeno la pila, sino, llamo a isEmpty
        if (tope > 1) {
            // Creamos una LinkedList de nombre 'lista' y la llenamos con los valores de cola, después, la ordenamos
            // usando el método .sort() de java Collections
            lista = (LinkedList) cola;
            Collections.sort(lista);
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
            System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public void eliminar() {
        // Si 'tope' tiene un elemento o más, elimino un elemento, sino, llamo a isEmpty();
        if (tope > 0) {
            cola.remove();
            tope--;
            System.out.println("Total de elementos: "+tope);
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
            System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public void agregar() {
        // Si 'tope' tiene un elemento o más y además tiene menos de 25 elementos
        // Agrego un elemento, sino, llamo a isEmpty(); o a isFull();
        if (tope > 0) {
            if (tope < 25){
                System.out.println("¿Qué letra te gustaría agregar?");
                add = sc.next().charAt(0);
                add = Character.toUpperCase(add);
                cola.add(add);
                tope++;
            } else {
                isFull();
            }
        } else {
            isEmpty();
        }
    }
    
    public void trabajo() {
        do {
            menu3();
            switch(opc) {
                case 1:
                    llenar();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    ordenar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    agregar();
                    break;
                case 6:
                    System.out.println("\n- - - - - - - - - - - - - - - -");
                    System.out.println("- - - - - - ¡Adiós! - - - - - -");
                    System.out.println("- - - - - - - - - - - - - - - -\n");
                    break;
                default:
                    System.out.println("\n- - - - - - - - - - - - - - -");
                    System.out.println("- ¡No es una opción válida! -");
                    System.out.println("- - - - - - - - - - - - - - -\n");
                    break;
            }
        } while(opc!=6);
    }
}
