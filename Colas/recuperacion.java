package Colas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class recuperacion {
    public Scanner sc = new Scanner (System.in);
    public Queue <Character> cola = new LinkedList();
    public String str;
    public int contador=0, aux; 
    public char parentesis='(', llave='{', corchete='[';
    
    public void pedirDatos() {
        System.out.print("Ingresa los datos: ");
        str = sc.next();
    }
    
    public void analizar() {
        aux=str.length();
        
        for (int i=0; i<str.length(); i++) {
            
            // Contar los paréntesis ( ).
            if (str.charAt(i) == '('){
                cola.add(parentesis);
                contador++;
            } else if (str.charAt(i) == ')'){
                if (contador == 0) {
                    break;
                } else {
                    contador--;
                }
            }
            
            // Contar las llaves { }.
            if (str.charAt(i) == '{'){
                cola.add(llave);
                contador++;
            } else if (str.charAt(i) == '}'){
                if (contador == 0) {
                    break;
                } else {
                    contador--;
                    //break;
                }
            }
            
            // Contar las llaves [ ].
            if (str.charAt(i) == '['){
                cola.add(corchete);
                contador++;
            } else if (str.charAt(i) == ']'){
                if (contador == 0) {
                    break;
                } else {
                    contador--;
                }
            }
        }
    }
    
    public void mostrar() {
        if(contador == 0){
            System.out.println("\n- - - - - - - - - - - - - - - - - - - -");
            System.out.println("- - - - - -¡Datos correctos!- - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - -");
        } else{
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
            System.out.println("- - - - - -¡Datos incorrectos!- - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        }
    }
    
    public void trabajo() {
        pedirDatos();
        analizar();
        mostrar();
        System.out.println("Contador: "+contador);
        System.out.println("");
    }
}
