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
                    Descifrado();
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
    
    public static void Descifrado(){
        Scanner cadenas = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        String direccion;
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         System.out.print("Ingrese la dirección de la matriz a descifrar (sin la extensión): ");
         direccion = cadenas.nextLine();
         File archivo = new File ("archivos/" + direccion + ".txt");
         FileReader fr = new FileReader (archivo);
         BufferedReader br = new BufferedReader(fr);

         // Lectura del archivo
         String linea;
         // Matriz para guardar lo que viene en el archivo.txt
         int [][] matriz;
         int filas = 0;
         int columnas = 0;
         // Variable para guardar la cadena como tal
         String cadena_archivo = "";
         // La matriz va a tener la misma cantidad de columnas por fila.
         // Con un split podemos separar un string por un caracter 
         // en especifico, en este caso sabemo que vienen con ","
         while((linea=br.readLine())!=null){
            String [] fila = linea.split(",");
            // Ahora fila es un vector de tipo String
            // Separados por comas.
            // En esta variable se esta replicando el contenido
            // Del archivo y en mi caso utilizare un salto de linea
            cadena_archivo += linea + "\n";
            // Si imprimimos este vector tendremos la fila separada por comas
            for(int i = 0; i < fila.length; i++){
                System.out.print(fila[i] + " ");
            }
            // Luego de imprimir la fila, podemos darnos cuenta que
            // El tamaño del arreglo es igual a la cantidad de columnas
            // entonces
            columnas = fila.length;
            // En este caso estaremos leyendo linea por linea
            // Por cada linea, la fila aumenta en 1 y al terminar
            // de leer el archivo, filas tendira la cantidad total
            // de filas en el archivo, justo para la matriz.
            filas = filas + 1;
         }
            System.out.println("");
          System.out.println("Las columnas son: " + columnas);
          System.out.println("Las filas son: " + filas);
      fr.close();
      // Con las dimensiones que encontramos, podemos definir nuestra matriz
      matriz = new int[filas][columnas];
          System.out.println("");
      // Hasta este punto tenemos la matriz del tamaño del archivo
      // Y tambien tenemos una variable con el contenido del archivo
          System.out.println(cadena_archivo);
      
      }
      catch(Exception e){
         e.printStackTrace();
      }
        String direccion2,mat1="";
        int [][] matriz;
        int aa= 0;
        try {
            String texto = "";
            System.out.print("Ingrese el nombre del archivo (incluya la extension del archivo): ");
            direccion2 = cadenas.nextLine();
            BufferedReader br = new BufferedReader(new FileReader("archivos/" + direccion2+".txt"));
            String bfRead;
            String temp ="";
            while((bfRead = br.readLine()) != null){
                temp = temp + bfRead;
                aa++;
            }
            texto=temp;
            br.close();
            mat1=texto;
      }
      catch(Exception e){
         e.printStackTrace();
      }
      String[] textElements = mat1.split(",");
      System.out.println("Segunda  matriz " + Arrays.deepToString(textElements));
      int [] matri2= new int [textElements.length] ;
      for (int i = 0; i<textElements.length;i++){
          matri2[i] = Integer.valueOf(textElements[i]);
      }
        //-----------------------------------------------------------------------------------------------------------------------
        //System.out.print("Ingrese la dimensión de la matriz cuadrada: ");
            int n =(textElements.length/aa),cc=0;
             double a[][]= new double[n][n];
            //System.out.print("Ingrese los elementos de la matriz: ");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j] = matri2[cc];
                    System.out.print(a[i][j]+"  ");
                    cc++;
                } System.out.println();
            }
            double d[][] = multmenos(a);
            
            System.out.println("La inversa de la matriz es: ");

            for (int i=0; i<n; ++i) {
                for (int j=0; j<n; ++j)

                {System.out.print(d[i][j]+"  ");}

                System.out.println();
            }
            entrada.close();
        }	
       //-----------------------------------------------------------------------------------------------------------------------------------

        public static double[][] multmenos(double a[][])         {

            int n = a.length;
            double x[][] = new double[n][n];
            double b[][] = new double[n][n];
            int index[] = new int[n];
            for (int i=0; i<n; ++i)
                b[i][i] = 1;

     //La funcion triangulo convierte la matriz en un triángulo para resolver por gauss

            trianguloGauss(a, index);

     // Ingresamos los cocientes de la matriz
            for (int i=0; i<n-1; ++i)
                for (int j=i+1; j<n; ++j)
                    for (int k=0; k<n; ++k)
                        b[index[j]][k]
                        	    -= a[index[j]][i]*b[index[i]][k];

     
     // Aplicamos sustituciones
            for (int i=0; i<n; ++i)             {
                x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
                for (int j=n-2; j>=0; --j)                 {
                    x[j][i] = b[index[j]][i];
                    for (int k=j+1; k<n; ++k)
                    {
                        x[j][i] -= a[index[j]][k]*x[k][i];
                    }

                    x[j][i] /= a[index[j]][j];
                }
            }
            return x;
        }

    // Utilizamos un pivote para el método de gauss

        public static void trianguloGauss(double a[][], int index[])  {

            int n = index.length;
            double c[] = new double[n];
            for (int i=0; i<n; ++i)
                index[i] = i;

     // Acá encontramos los factores reescalando fila por fila
            for (int i=0; i<n; ++i) {
                double c1 = 0;
                for (int j=0; j<n; ++j) {
                    double c0 = Math.abs(a[i][j]);
                    if (c0 > c1) c1 = c0;
                }
                c[i] = c1;
            }

     // Buscamos los pivotes por cada columna
            int k = 0;
            for (int j=0; j<n-1; ++j) {
                double pi1 = 0;
                for (int i=j; i<n; ++i)  {
                    double pi0 = Math.abs(a[index[i]][j]);
                    pi0 /= c[index[i]];
                    if (pi0 > pi1) {
                        pi1 = pi0;
                        k = i;
                    }
                }

       // Intercambiamos filas por el orden del pivote 
                int itmp = index[j];
                index[j] = index[k];
                index[k] = itmp;
                for (int i=j+1; i<n; ++i) {
                    double pj = a[index[i]][j]/a[index[j]][j];

     // Registrar los cocientes de los pivotes por debajo de la diagonal
                    a[index[i]][j] = pj;
                    
                    for (int l=j+1; l<n; ++l)
                        a[index[i]][l] -= pj*a[index[j]][l];
                }
            }
        
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------
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
			System.out.println("Error accediendo al archivo");
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
