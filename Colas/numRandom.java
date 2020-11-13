package Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class numRandom {
    public Scanner sc = new Scanner (System.in);
    public int tope = 0, tam = 0, opc, numero1, numero2;
    public Queue<Integer> colaA = new LinkedList();
    public Queue<Integer> colaB = new LinkedList();
    public Queue<Integer> colaC = new LinkedList();
    public LinkedList<Integer> listaA = new LinkedList();
    public LinkedList<Integer> listaB = new LinkedList();
    public int arrayA[] = new int[26];
    public int arrayB[] = new int[26];
    public int arrayC[] = new int[52];
    
    // isEmpty(); sólo guarda un mensaje de que las colas están vacías.
    public void isEmpty() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - ¡Pilas  vacías! - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    // isFull(); sólo guarda un mensaje de que las colas están llenas.
    public void isFull() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - - ¡Pilas  llenas! - - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public void menu() {
        // Presentamos un menú al usuario
        System.out.println("*************** M E N Ú ***************");
        System.out.print("1 - Llenar colas.\n"
                       + "2 - Mostrar colas.\n"
                       + "3 - Vaciar colas.\n"
                       + "4 - Unir colas.\n"
                       + "5 - Mostrar cola unida.\n"
                       + "6 - Salir.\n"
                       + "Tu respuesta: ");
        opc = sc.nextInt();
    }
    
    public void llenar() {
        // Pedimos el tamaño que tendrán las colas y lo guardamos en la variable 'tam'
        System.out.print("Ingresa el tamaño de las colas: ");
        tam = sc.nextInt();
        System.out.println("\n- - - - - - ¡Llenando  colas! - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        // Las variables numero1 y numero2 guardaran los números aleatorios de sus colas correspondientes.
        // Generamos números aleatorios en las colas A Y B
        for (int i=0; i<tam; i++) {
            if (tope<tam) {
                numero1 = (int)(Math.random()*100+1);
                numero2 = (int)(Math.random()*200+100);
                colaA.add(numero1);
                colaB.add(numero2);
                tope++;
            }
        }
        System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -\n");
    }
    
    public void mostrar() {
        // Si 'tope' es mayor a cero, mostrar las pilas, sino, llamar a isEmpty();
        if (tope > 0){
            System.out.println("\nMostrando colas:\n");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println(colaA);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println(colaB);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public void vaciar() {
        // Si 'tope' es mayor a cero, cambiamos el valor de 'tope' a cero, sino, llamamos a isEmpty();
        if (tope > 0) {
            System.out.println("\n- - - - - - -¡Vaciando colas!- - - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            tope = 0;
            System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public void unir() {
        // Si 'tope' es mayor a cero, sumamos los valores de colaA y colaB en colaC, sino, llamamos a is Empty();
        if (tope > 0){
            System.out.println("\n- - - - - - -¡Uniendo colas!- - - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            // La variable contador nos sirve para iterar los elementos en arrayC y en colaC
            int contador = 0;
            
            // Guardamos los elementos de colaA y colaB en listaA y listaB para poder iterar los elementos en un bucle
            listaA = (LinkedList) colaA;
            listaB = (LinkedList) colaB;
            
            // Guardamos los elementos de listaA y listaB en arrayA y ArrayB iterandolos
            for (int i=0; i<tope; i++) {
                arrayA[i] = listaA.get(i);
                arrayB[i] = listaB.get(i);
            }
            // Guardamos de manera invertida la suma de los elementos de arrayA y arrayB en arrayC
            for (int i=tam-1; i>=0; i--) {
                arrayC[contador] = arrayA[i] + arrayB[i];
                contador++;
            }
            // Guardamos a los elementos de arrayC en colaC
            for (int i=0; i<tope; i++) {
                colaC.add(arrayC[i]);
            }
            System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public void mostrarUnion() {
        System.out.println("\nMostrando cola:\n");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(colaC);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
    
    public void trabajo() {
        do {
            menu();
            
            switch(opc) {
                case 1:
                    llenar();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    vaciar();
                    break;
                case 4:
                    unir();
                    break;
                case 5:
                    mostrarUnion();
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
        } while (opc!=6);
        
    }
}
