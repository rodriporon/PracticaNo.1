package practica1;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        Scanner cadenas = new Scanner(System.in);
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
        } else if (contador % 19 ==0) {
            b = contador / 19;
            a = contador / b;
        } else {
            System.out.println("La frase excede el límite de carácteres");
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
                
                String direcc;
                int[][] matrizL = null;
		try {
                        System.out.print("Ingrese el nombre del archivo (incluya la extension del archivo): ");
                        direcc = cadenas.nextLine();
			BufferedReader br = new BufferedReader(new FileReader("archivos/" + direcc));

			//Primera linea nos dice longitud de la matriz

			String linea = Integer.toString(a);

			int longitud = Integer.parseInt(linea);

			matrizL = new int[longitud][longitud];

			//Las siguientes lineas son filas de la matriz

			linea = br.readLine();
                        
                        //Verificar que la matriz es cuadrada del multiplo
                        String[] verificar = linea.split(",");
                        if (verificar.length != a) {
                            System.out.println("Ingrese una matriz cuadrada");
                            System.out.println(verificar.length);
                    } else {
                            
                        

			int fila = 0; //Para recorrer las filas de la matriz
                            
			while(linea != null) {
				String[] enteros = linea.split(",");                                
                        	for (int i = 0; i < enteros.length; i++)
                                    matrizL[fila][i] = Integer.parseInt(enteros[i]);
				fila++;
				linea = br.readLine();

			}
			br.close();
                        
                        
			//Mostramos la matriz leída
			for (int i = 0; i < longitud; i++) {

				for (int j = 0; j < longitud; j++)

					System.out.print(matrizL[i][j] + " ");

				System.out.println();

			}
                        }

		} catch (FileNotFoundException e) {

			System.out.println("No se encuentra archivo");

			e.printStackTrace();

		} catch (NumberFormatException e) {

			System.out.println("No se pudo convertir a entero");

			e.printStackTrace();

		} catch (IOException e) {

			System.out.println("Error accediendo al archivo.");

			e.printStackTrace();
                        

		}

    int[][] c = Multiplicacion(matrizL, matriz);
    System.out.println(Arrays.deepToString(c));

	}
    
public static int[][] Multiplicacion(int[][] a, int[][] b) {
    int[][] c = new int[a.length][b[0].length];
    // se comprueba si las matrices se pueden multiplicar
    if (a[0].length == b.length) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    // aquí se multiplica la matriz
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }
    /**
     * si no se cumple la condición se retorna una matriz vacía
     */
    return c;
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
    
    public static void LeerP(String direccion, String texto){
        try {
            PrintWriter writer = new PrintWriter(direccion, "UTF-8");
            writer.println("Primera línea");
            writer.println("Segunda línea");
            writer.println(texto);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String Leer(String dire){
        String txt = "";
        int a = 0;
        try{
            BufferedReader bf = new BufferedReader(new FileReader (dire));
            String temp ="";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead;
                a++;
            }
            txt=temp;
        }catch(Exception e){
            System.err.println("No se encontró el archivo");
        }
        
        return (txt + "," + a);
    }
    
    
}
