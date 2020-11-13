package Colas;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class abcNoReply {
    
    public Scanner sc = new Scanner (System.in);
    public Queue<Character> cola = new LinkedList();
    public LinkedList<Character> lista = new LinkedList();
    public int tope=0, opc;
    public char letra, add;
    
    public void isEmpty() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - -¡La pila vacía!- - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public void isFull() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - -¡La pila llena!- - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public void menu() {
        // Mostramos el menú y pedimos el valor de 'opc' que nos indicará que 'case' realizar.
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
    
    public void llenar() {
        // Llenamos la pila con valores del abecedario aleatoriamente.
        int numero;
        // 'Set' y random se encargan de comprobar que no se repitan las letras generadas aleatoriamente.
        Set<Integer> random = new HashSet<>();
        System.out.println("\n- - - - - - -¡Llenando cola!- - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        for (int i=0; i<26; i++) {
            // 'comprobar' es la variable que uso para controlar el ciclo while
            boolean comprobar = false;
            if (tope<26) {
                while (!comprobar) {
                    // Genero un número random y lo convierto en letra.
                    numero = (int)(Math.random()*(91-65)+65);
                    // Comprobamos que no se repita, haciendo uso de 'contains()'
                    if (!random.contains(numero)) {
                        random.add(numero);
                        // Se rompe el ciclo while y continuamos iterando el ciclo for
                        comprobar = true;
                        letra = (char) numero;
                        cola.add(letra);
                        letra++;
                        tope++;
                    }
                }
            }
        }
        System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -\n");
    }
    
    public void mostrar() {
        // Si 'tope' tiene un elemento o más, muestro la cola, sino, llamo a isEmpty();
        if (tope > 0){
            System.out.println("\nMostrando cola:\n");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println(cola);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
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
            menu();
            switch (opc) {
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
        } while (opc != 6);
    }
}
