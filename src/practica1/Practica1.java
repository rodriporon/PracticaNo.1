package practica1;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner cadenas = new Scanner(System.in);
        
        int opcion;
        do{
            System.out.println("1. Cifrar");
            System.out.println("2. Descifrar");
            System.out.println("3. Gauss-Jordan");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    String frase;
                    char[] caracteres;
                    System.out.println("CIFRAR");
                    System.out.print("Ingrese la frase a cifrar: ");
                    frase = cadenas.nextLine();
                    caracteres = frase.toCharArray();
                    Cifrado(frase);
                    //Multiplo(caracteres.length);
                    /*int contador = caracteres.length;
                    int a = 1;
                    int b = 1;
                    if (contador % 3 == 0) {
                        b = contador / 3;   
                        a = contador / b;
                    } else if (contador % 4 == 0) {
                        b = contador / 4;
                        a = contador / b;
                    } else if (contador % 5 == 0) {
                        b = contador / 5;
                        a = contador / b;
                    } else if (contador % 7 == 0) {
                        b = contador / 7;
                        a = contador / b;
                    } else if (contador % 11 == 0) {
                        b = contador / 11;
                        a = contador / b;
                    } else if (contador % 17 == 0) {
                        b = contador / 17;
                        a = contador / b;
                    } else {
                        System.out.println("La frase excede el límite de carácteres");
                    }
                    System.out.println("El multiplo es: " + a + " y n es: " + b); */
                    

                    System.out.println("Son " + caracteres.length + " caracteres");
                    
                    System.out.println("Tu frase es: " + frase);
                    break;
                case 2:
                    System.out.println("DESCIFRAR");
                    break;
                case 3:
                    System.out.println("GAUSS-JORDAN");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while (opcion != 4);             
        
        
        
        //EscribirDocumento();
        //LeerDocumento();
    }
    
    public static void Cifrado(String fraseC){
        int matriz[][];
        int contador = 0;
        char[] caracteresC = fraseC.toCharArray();
        int noC[] = new int [caracteresC.length];
        for (int m = 0; m < caracteresC.length; m++) {
            noC[m] = fraseC.charAt(m);
            contador++;
        }
        
        int a = 1;
        int b = 1;
        if (contador % 3 == 0) {
            b = contador / 3;   
            a = contador / b;
        } else if (contador % 4 == 0) {
            b = contador / 4;
            a = contador / b;
        } else if (contador % 5 == 0) {
            b = contador / 5;
            a = contador / b;
        } else if (contador % 7 == 0) {
            b = contador / 7;
            a = contador / b;
        } else if (contador % 11 == 0) {
            b = contador / 11;
            a = contador / b;
        } else if (contador % 17 == 0) {
            b = contador / 17;
            a = contador / b;
        }
        System.out.println("El multiplo es: " + a + " y n es: " + b);
        
        matriz = new int[a][b];
        int ubi = 0, pos = 0, gg = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matriz[i][j] = noC[ubi];
                ubi++;
                pos++;
            }
            gg++;
        }
        System.out.println(Arrays.deepToString(matriz));
        System.out.println("La matriz es multiplo de: " + a + " y n es: " + b);
        
    }
    public static boolean Primo(int numero){
        int contadorP = 2;
        boolean primo = true;
        while ((primo) && (contadorP != numero)) {
            if (numero % contadorP == 0) {
                primo = false;
                contadorP++;
            }
        }
        return primo;
    }
        
    public static void Multiplo(int contador){
        int a = 1;
        int b = 1;
        if (contador % 3 == 0) {
            b = contador / 3;   
            a = contador / b;
        } else if (contador % 4 == 0) {
            b = contador / 4;
            a = contador / b;
        } else if (contador % 5 == 0) {
            b = contador / 5;
            a = contador / b;
        } else if (contador % 7 == 0) {
            b = contador / 7;
            a = contador / b;
        } else if (contador % 11 == 0) {
            b = contador / 11;
            a = contador / b;
        } else if (contador % 17 == 0) {
            b = contador / 17;
            a = contador / b;
        }
        System.out.println("El multiplo es: " + a + " y n es: " + b);
    }
    
    
    public static void LeerDocumento(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File ("archivos/texto.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != fr) {
                    fr.close();
                } 
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static void EscribirDocumento(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter("Archivos/texto.txt");
            pw = new PrintWriter(fichero);
            
            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
