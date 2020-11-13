package Colas;

import java.util.Scanner;

public class Colas {
    
    public static Scanner sc = new Scanner (System.in);
    public static int menu=0;
    
    public static void menu() {
        // Mostramos el menú y pedimos el valor de 'opc' que nos indicará que 'case' realizar.
        System.out.println("*************** M E N Ú ***************");
        System.out.print("1 - Abecedario aleatorio (letras repetidas).\n"
                       + "2 - Abecedario aleatorio (letras repetidas y ordenables).\n"
                       + "3 - Números aleatorios de 1 a 100 y de 100 a 200.\n"
                       + "4 - Abecedario aleatorio (Sin repetir).\n"
                       + "5 - Ejercicio de recuperación.\n"
                       + "6 - Salir.\n"
                       + "Tu respuesta: ");
        menu = sc.nextInt();
    }
    
    public static void main (String args[]) {
        do {
            menu();
            switch(menu) {
                case 1:
                    System.out.println("\n- - - - - - - - - - - - - - - - -");
                    System.out.println("- ¡Primera opción seleccionada! -");
                    System.out.println("- - - - - - - - - - - - - - - - -\n");
                    abcRandom abc = new abcRandom();
                    abc.trabajo();
                    break;
                case 2:
                    System.out.println("\n- - - - - - - - - - - - - - - - -");
                    System.out.println("- ¡Segunda opción seleccionada! -");
                    System.out.println("- - - - - - - - - - - - - - - - -\n");
                    abcOrdenado abc2 = new abcOrdenado();
                    abc2.trabajo();
                    break;
                case 3:
                    System.out.println("\n- - - - - - - - - - - - - - - - - -");
                    System.out.println("- ¡Tercera  opción  seleccionada! -");
                    System.out.println("- - - - - - - - - - - - - - - - - -\n");
                    numRandom num = new numRandom();
                    num.trabajo();
                    break;
                case 4:
                    System.out.println("\n- - - - - - - - - - - - - - - - - -");
                    System.out.println("- -¡Cuarta opción seleccionada!- -");
                    System.out.println("- - - - - - - - - - - - - - - - - -\n");
                    abcNoReply abc3 = new abcNoReply();
                    abc3.trabajo();
                    break;
                case 5:
                    System.out.println("\n- - - - - - - - - - - - - - - - - -");
                    System.out.println("- - -¡Quinta opción seleccionada!- - -");
                    System.out.println("- - - - - - - - - - - - - - - - - -\n");
                    recuperacion eR = new recuperacion();
                    eR.trabajo();
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
        } while(menu!=6);
    }
}
