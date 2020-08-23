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
    
    public static String direccionGauss;
    public static String frase;
    public static String direccionCifrado;
    public static String direccionDescifrado1;
    public static String direccionDescifrado2;
    public static int longitudCif = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner cadenas = new Scanner(System.in);
        Scanner cadenas2 = new Scanner(System.in);
        
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
                    
                    char[] caracteres;
                    System.out.println("CIFRAR");
                    System.out.print("Ingrese la frase a cifrar: ");
                    frase = cadenas.nextLine();
                    caracteres = frase.toCharArray();
                    System.out.println("Son " + caracteres.length + " caracteres");
                    System.out.println("Tu frase es: " + frase);
                    System.out.print("Ingrese la ruta del archivo para cifrar: ");
                    direccionCifrado = cadenas2.nextLine();
                    Cifrado();
                    break;
                case 2:
                    System.out.println("DESCIFRAR");
                    System.out.print("Ingrese la ruta del archivo a desencriptar: ");
                    direccionDescifrado1 = cadenas.nextLine();
                    System.out.print("Ingrese la ruta de la matriz cuadrada: ");
                    direccionDescifrado2 = cadenas2.nextLine();
                    Descifrado();
                    break;
                case 3:
                    System.out.println("GAUSS-JORDAN");
                    System.out.print("Ingrese la ruta del archivo: ");
                    direccionGauss = cadenas.nextLine(); 
                    GaussJordan();
                    break;
                case 4: 
                    System.out.println("Adiós :D");
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
        String  mat2 = "";
        int [][] matriz1;
        int aa1;
        aa1 = 0;
        try {
            String texto = "";
            System.out.print("Ingrese la ruta del primer archivo: ");
            BufferedReader br = new BufferedReader(new FileReader(direccionDescifrado1));
            String bfRead;
            String temp ="";
            while((bfRead = br.readLine()) != null){
                temp = temp + bfRead + ",";
                aa1++;
            }
            texto=temp;
            br.close();
            mat2=texto;
        }
        catch(Exception e){
         e.printStackTrace();
        }
        String[] textElements1 = mat2.split(",");
        System.out.println("La matriz dada es de: " + aa1 + " * "+ textElements1.length/aa1);

        int u=0;
        int [][] mattriz1 = new int [aa1][textElements1.length/aa1];
        for(int i=0;i<aa1;i++){
            for(int j=0;j<textElements1.length/aa1;j++){
                mattriz1[i][j]=Integer.valueOf(textElements1[u]);
                //System.out.println(" " + valoi[i][j]);
                u++;
            }
        }
        System.out.println(Arrays.deepToString(mattriz1));
        
      /*int [] matri2= new int [textElements1.length] ;
      for (int i = 0; i<textElements1.length;i++){
          matri2[i] = Integer.valueOf(textElements1[i]);
      }*/

        String direccion2,mat1="";
        int [][] matriz;
        int aa= 0;
        try {
            String texto = "";
            BufferedReader br = new BufferedReader(new FileReader(direccionDescifrado2));
            String bfRead;
            String temp ="";
            while((bfRead = br.readLine()) != null){
                temp = temp + bfRead + ",";
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
        int two=0;
        int [][] MatrizCua = new int [aa][aa];
        for(int i = 0;i <aa; i++){
            for(int j = 0;j < aa1; j++){
                MatrizCua[i][j]=Integer.valueOf(textElements[two]);
                //System.out.println(" " + valoi[i][j]);
                two++;
            }
        }
        System.out.println(Arrays.deepToString(MatrizCua));    
        
        
      //String[] textElements = mat1.split(",");
      //System.out.println("Segunda  matriz " + Arrays.deepToString(textElements));
      int [] matri2= new int [textElements.length] ;
      for (int i = 0; i<textElements.length;i++){
          matri2[i] = Integer.valueOf(textElements[i]);
      }
      
      
        //-----------------------------------------------------------------------------------------------------------------------
        //Asignar valores para la matriz cuadrada
            int n =(textElements.length/aa),cc=0;
             double a[][]= new double[n][n];
            //System.out.print("Ingrese los elementos de la matriz: ");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j] = matri2[cc];
                    System.out.print(a[i][j]+ " ");
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
        int aas; 
        int [][]inveInt=new int [d.length][d.length];
        for (int i =0;i<d.length;i++){
                for (int j=0;j<d.length;j++){
                    aas = (int)(d[i][j]);
                    inveInt[i][j]=aas;
                }
        }
       // System.out.println(Arrays.deepToString(inveInt));
        System.out.println("La Multiplicacion es: ");
        int [][] c = MultiplicacionDoble(d, mattriz1);
        System.out.println(Arrays.deepToString(c));
        
        int DimVectorASCII = c.length*c[0].length;
        byte VectorASCII[] = new byte [DimVectorASCII];
        int ContASCII = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) { //cuenta las filas columnas se multiplican, se agregan en un vector, luego se convierten en bytes, y se saca el resulta ASCII
                VectorASCII[ContASCII] = (byte) c[i][j];
                ContASCII++;
            }
        }  
        String Fas = new String (VectorASCII);
        System.out.println("La frase desencriptada es : " + Fas);
        
// REPORTE ------------------------------------------------------------------------------------------------

 try {
        String ruta = "ReporteDescifrado.html";
        PrintWriter writer = new PrintWriter(ruta, "UTF-8");
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
	writer.println("<head>");
		writer.println("<title>Reporte Descifrado IPC 1</title>");
		writer.println("<meta charset=\"utf-8\" />");
		writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />");
		writer.println("<meta name=\"description\" content=\"\" />");
		writer.println("<meta name=\"keywords\" content=\"\" />");
		writer.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
	writer.println("</head>");
	writer.println("<body class=\"is-preload\">");
                writer.println("<header id=\"header\">");
                
                
			writer.println("<a class=\"logo\" href=\"ReporteDescifrado.html\">Reporte Descifrado</a>");
                        writer.println("<nav>");
                        writer.println("<a href = \"#menu\"> Menú </a>");
                        writer.println("</nav>");
                        
                	writer.println("<nav id=\"menu\">");
				writer.println("<ul class=\"links\">");
					writer.println("<li><a href=\"ReporteDescifrado.html\">Inicio</a></li>");
					writer.println("<li><a href=\"ReporteCifrado.html\">Cifrado</a></li>");
					writer.println("<li><a href=\"ReporteGaussJordan.html\">Gauss Jordan</a></li>");
				writer.println("</ul>");
			writer.println("</nav>");        
                        
                        
                writer.println("</header>");
                writer.println("<section id=\"banner2\">");
				writer.println("<div class=\"inner\">");
					writer.println("<h1>DESCIFRADO</h1>");
					writer.println("<p>Un reporte generado totalmente en java<br />");
					writer.println("</div>");
				writer.println("<video autoplay loop muted playsinline src=\"images/banner2.mp4\"></video>");
			writer.println("</section>");
                        
            writer.println("<section class = \"wrapper\">");
                writer.println("<div class = \"inner\">");
                    writer.println("<header class = \"special\">");
            writer.println("<h3>");
            writer.println("La ruta del la matriz a descifrar:");
            writer.println("</h3>");
            writer.println("<p>");
            writer.println("<code>");
            writer.println(direccionDescifrado1);
            writer.println("</code>");
            writer.println("</p>");
            writer.println("La matriz que ingresó:");
            
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < aa1; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < textElements1.length/aa1; j++){
                    writer.print("<th>");
                    writer.print(mattriz1[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            writer.println("<h3>");
            writer.println("La ruta de la matriz cuadrada:");
            writer.println("</h3>");
            writer.println("<p>");
            writer.println("<code>");
            writer.println(direccionDescifrado2);
            writer.println("</code>");
            writer.println("</p>");
            
            writer.println("La matriz cuadrada que ingresó es la siguiente:");
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < aa; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < aa; j++){
                    writer.print("<th>");
                    writer.print(MatrizCua[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            writer.println("<h3>");
            writer.println("La inversa de la matriz cuadrada es:");
            writer.println("</h3>");
            
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < n; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < n ; j++){
                    writer.print("<th>");
                    writer.print(d[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            writer.println("<h3>");
            writer.println("La frase desencriptada es:");
            writer.println("</h3>");
            
            writer.println("<b>");
            writer.println(Fas);
            writer.println("</b>");
            
            writer.println("</header>");
            writer.println("</div>");
            writer.println("</section>");
           
            
            
            writer.println("<footer id=\"footer\">");
		writer.println("<div class=\"inner\">");
                    writer.println("<div class=\"content\">");
			writer.println("<section>");
                            writer.println("<h3>Rodrigo Antonio Porón De León</h3>");
                                writer.println("<p>Laboratorio de Introducción a la Programación y Computación</p>");
                                writer.println("<p>Sección D</p>");
			writer.println("</section>");
                writer.println("</div>");
                writer.println("</div>");
            writer.println("</footer>");
            
            
            			writer.println("<script src=\"assets/js/jquery.min.js\"></script>");
			writer.println("<script src=\"assets/js/browser.min.js\"></script>");
			writer.println("<script src=\"assets/js/breakpoints.min.js\"></script>");
			writer.println("<script src=\"assets/js/util.js\"></script>");
			writer.println("<script src=\"assets/js/main.js\"></script>");
            writer.println("</body>");
            writer.println("</html>");
            
            
            writer.close();
        
        
        
    } catch (Exception e){
        e.printStackTrace();
    }  
                
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
    public static void Cifrado(){
        Scanner cadenas = new Scanner(System.in);
        int matriz[][];
        int contador = 0;
        char[] caracteresC = frase.toCharArray();
        int noC[] = new int [caracteresC.length];
        for (int m = 0; m < caracteresC.length; m++) {
            noC[m] = frase.charAt(m);
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
        } else {
            System.out.println("La frase no contiene multiplos permitidos");
        }
        System.out.println("El multiplo es: " + a + " y n es: " + b);
        System.out.println("La frase convertida a ASCII:");
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
        
        System.out.println("La matriz ingresada por medio de archivo:");
        int[][] MatrizL;
        String Matriz;
        Matriz = Leer(direccionCifrado);
        Matriz.split(",");
        String[] ElementosMatriz = Matriz.split(",");
        
        int fila = 0;
        int longitud = ElementosMatriz.length;
        MatrizL = new int[a][a];                            
            for (int i = 0; i < a; i++){
                for (int j = 0; j < a; j++) {
                    MatrizL[i][j] = Integer.valueOf(ElementosMatriz[fila]);
                    fila++;         
                }

            }
                       
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++)
                            System.out.print(MatrizL[i][j] + " ");
                            System.out.println();
			}
			
        
        
        
        
        
                
           /*     String direcc;
                direcc = cadenas.nextLine();
                
                int[][] matrizL = null;
                int longitud = 0;
		try {
                        System.out.print("Ingrese la ruta del archivo: ");
                        direcc = cadenas.nextLine();
			BufferedReader br = new BufferedReader(new FileReader(direcc));

			//Primera linea nos dice longitud de la matriz
			String linea = Integer.toString(a);
			longitud = Integer.parseInt(linea);
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
                
                for (int i = 0; i < longitudCif; i++) {
				for (int j = 0; j < longitudCif; j++)
                                    System.out.print(matrizL[i][j] + " ");
                                    System.out.println();
			}
*/
    int[][] c = Multiplicacion(MatrizL, matriz);
        System.out.println("La multiplicacion de las matrices:");
    System.out.println(Arrays.deepToString(c));
    
    
//REPORTE _____________________________________________________________________________
    
    try {
        String ruta = "ReporteCifrado.html";
        PrintWriter writer = new PrintWriter(ruta, "UTF-8");
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
	writer.println("<head>");
		writer.println("<title>Reporte Cifrado IPC 1</title>");
		writer.println("<meta charset=\"utf-8\" />");
		writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />");
		writer.println("<meta name=\"description\" content=\"\" />");
		writer.println("<meta name=\"keywords\" content=\"\" />");
		writer.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
	writer.println("</head>");
	writer.println("<body class=\"is-preload\">");
                writer.println("<header id=\"header\">");
                
                
			writer.println("<a class=\"logo\" href=\"ReporteCifrado.html\">Reporte Cifrado</a>");
                        writer.println("<nav>");
                        writer.println("<a href = \"#menu\"> Menú </a>");
                        writer.println("</nav>");
                        
                	writer.println("<nav id=\"menu\">");
				writer.println("<ul class=\"links\">");
					writer.println("<li><a href=\"ReporteCifrado.html\">Inicio</a></li>");
					writer.println("<li><a href=\"ReporteDescifrado.html\">Descifrado</a></li>");
					writer.println("<li><a href=\"ReporteGaussJordan.html\">Gauss Jordan</a></li>");
				writer.println("</ul>");
			writer.println("</nav>");        
                        
                        
                writer.println("</header>");
                writer.println("<section id=\"banner\">");
				writer.println("<div class=\"inner\">");
					writer.println("<h1>CIFRADO</h1>");
					writer.println("<p>Un reporte generado totalmente en java<br />");
					writer.println("</div>");
				writer.println("<video autoplay loop muted playsinline src=\"images/banner2.mp4\"></video>");
			writer.println("</section>");
                        
            writer.println("<section class = \"wrapper\">");
                writer.println("<div class = \"inner\">");
                    writer.println("<header class = \"special\">");
            writer.println("<h3>");
            writer.println("La frase que ingresó:");
            writer.println("</h3>");
            writer.println("<p>");
            writer.println("<code>");
            writer.println(frase);
            writer.println("</code>");
            writer.println("</p>");
            writer.println("La matriz en código ASCII es:");
            
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < a; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < b; j++){
                    writer.print("<th>");
                    writer.print(matriz[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            writer.println("<h3>");
            writer.println("La ruta del archivo que ingresó:");
            writer.println("</h3>");
            writer.println("<p>");
            writer.println("<code>");
            writer.println(direccionCifrado);
            writer.println("</code>");
            writer.println("</p>");
            
            writer.println("La matriz del archivo que ingresó es la siguiente:");
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < a; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < a; j++){
                    writer.print("<th>");
                    writer.print(MatrizL[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            writer.println("<h3>");
            writer.println("La frase encriptada:");
            writer.println("</h3>");
            
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < a; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < b; j++){
                    writer.print("<th>");
                    writer.print(c[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            
            
            writer.println("</header>");
            writer.println("</div>");
            writer.println("</section>");
           
            
            writer.println("<footer id=\"footer\">");
		writer.println("<div class=\"inner\">");
                    writer.println("<div class=\"content\">");
			writer.println("<section>");
                            writer.println("<h3>Rodrigo Antonio Porón De León</h3>");
                                writer.println("<p>Laboratorio de Introducción a la Programación y Computación</p>");
                                writer.println("<p>Sección D</p>");
			writer.println("</section>");
                writer.println("</div>");
                writer.println("</div>");
            writer.println("</footer>");
            
            
            			writer.println("<script src=\"assets/js/jquery.min.js\"></script>");
			writer.println("<script src=\"assets/js/browser.min.js\"></script>");
			writer.println("<script src=\"assets/js/breakpoints.min.js\"></script>");
			writer.println("<script src=\"assets/js/util.js\"></script>");
			writer.println("<script src=\"assets/js/main.js\"></script>");
            writer.println("</body>");
            writer.println("</html>");
            
            
            writer.close();
        
        
        
    } catch (Exception e){
        e.printStackTrace();
    }

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
                temp = temp + bfRead + ",";
                a++;
            }
            txt=temp;
        }catch(Exception e){
            System.err.println("No se encontró el archivo");
        }
        
        return (txt + "," + a);
    }
    
    public static int [][] MultiplicacionDoble(double[][] a, int[][] b) {
        double[][] c = new double[a.length][b[0].length];
        int [][]Matr=new int [a.length][b[0].length]; 
        // se comprueba si las matrices se pueden multiplicar
        float s;
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        // aquí se multiplica la matriz
                        c[i][j] += a[i][k] * b[k][j];
                        s = (float)c[i][j];    //Esta linea 
                        Matr[i][j]=Math.round(s);
                    }
                }
            }
        }
    return Matr;
    }   
    
    
    public static void GaussJordan(){
        double[][] MatrizGauss;
        int[][] Matriz1;
        String Matriz;
        Matriz = Leer(direccionGauss);
        Matriz.split(",");
        String[] ElementosMatriz = Matriz.split(",");
        int SinIdentidad = ElementosMatriz.length -1;
        int ConverSinIden = Integer.valueOf(ElementosMatriz[SinIdentidad]);
        int Cant = SinIdentidad/ConverSinIden, Op = 0;
        Matriz1 = new int[ConverSinIden][Cant];
        MatrizGauss = new double[ConverSinIden][Cant];
        int[] VectorDim;
        VectorDim = new int[ConverSinIden * Cant]; 
        for (int i = 0; i < ConverSinIden; i++) {
            for (int j = 0; j < Cant; j++) {
                Matriz1[i][j] = Integer.valueOf(ElementosMatriz[Op]);
                VectorDim[Op] = Matriz1[i][j];
                MatrizGauss[i][j] = Matriz1[i][j];
                Op++;
            }
        }
        System.out.println(Arrays.deepToString(Matriz1));
        System.out.println("La matriz es de " + ConverSinIden + "x" + Cant);
        OperacionGaussJordan(Matriz1);
    }
    
    public static void OperacionGaussJordan(int [][]Matriz){
        
        //Determinar las dimensiones
        double Dim[][] = new double[Matriz.length][Matriz.length];
        double Resu[] = new double[Matriz.length];
        int count = Matriz.length; 
        for (int i = 0; i < count; i++) {

                for (int j = 0; j < count; j++) {
                    //Matriz aumentada
                    Dim[i][j] = Matriz[i][j];
                }
                Resu[i] = Matriz[i][count];
            }
            System.out.println("Matriz cuadrada" + Arrays.deepToString(Dim));
            System.out.println("Matriz aumentada" + Arrays.toString(Resu));
            Resu = Practica1.Resolucion(Dim, Resu, count);
            
            System.out.println("Los resultados son:");
            System.out.println("X = " + Resu[0]);
            System.out.println("Y = " + Resu[1]);
            System.out.println("Z = " + Resu[2]);
            System.out.println();
            
    }
    public static double [] Resolucion(double[][] x, double[] y, int z){
         
        for (int i = 0; i < z; i++) {
            double piv, c = 0;
            //Pivote a usar:
            piv = x[i][i];
            System.out.println(Double.toString(1/piv) + " * Fila " + (i + 1)); //Los pasos que se van realizando se imprimen
            System.out.println();
            for (int j = 0; j <z; j++) {
                //Se comienza a convertir a 1 el pivote que se ha seleccionado.
                x[i][j] = ((x[i][j]) / piv);
            }
            y[i] = ((y[i]) / piv);

            // Sección de la matriz aumentada
            // Pasos
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < z; k++) {
                   System.out.println(Double.toString(x[j][k]));
                }
                System.out.println("(" + Double.toString(y[j]) + ")");
                System.out.println();
            }
            System.out.println();
            System.out.println();
            for (int p = 0; p <z; p++) {
                if (i != p) {
                    c = x[p][i];
                    System.out.println(Double.toString(c) + " * Fila " + (i + 1) + " + Fila " + (p + 1));// 
                    System.out.println();
                    for (int q = 0; q <z; q++) {
                        x[p][q] = x[p][q] - c * x[i][q]; // Se hacen las operaciones entre filas
                    }
                    y[p] = y[p] - c * y[i];
                    for (int j = 0; j < z; j++) {
                        for (int k = 0; k < z; k++) {
                            System.out.println(Double.toString(x[j][k]));
                        }
                        System.out.println("(" + Double.toString(y[j]) + ")");
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();

                }
            }
        }
        
// REPORTE ------------------------------------------------------------------------------------------------

        try {
        String ruta = "ReporteGaussJordan.html";
        PrintWriter writer = new PrintWriter(ruta, "UTF-8");
        writer.println("<!DOCTYPE HTML>");
        writer.println("<html>");
	writer.println("<head>");
		writer.println("<title>Reporte GaussJordan IPC 1</title>");
		writer.println("<meta charset=\"utf-8\" />");
		writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />");
		writer.println("<meta name=\"description\" content=\"\" />");
		writer.println("<meta name=\"keywords\" content=\"\" />");
		writer.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
	writer.println("</head>");
	writer.println("<body class=\"is-preload\">");
                writer.println("<header id=\"header\">");
                
                
			writer.println("<a class=\"logo\" href=\"ReporteDescifrado.html\">Reporte Descifrado</a>");
                        writer.println("<nav>");
                        writer.println("<a href = \"#menu\"> Menú </a>");
                        writer.println("</nav>");
                        
                	writer.println("<nav id=\"menu\">");
				writer.println("<ul class=\"links\">");
					writer.println("<li><a href=\"ReporteDescifrado.html\">Inicio</a></li>");
					writer.println("<li><a href=\"ReporteCifrado.html\">Cifrado</a></li>");
					writer.println("<li><a href=\"ReporteGaussJordan.html\">Gauss Jordan</a></li>");
				writer.println("</ul>");
			writer.println("</nav>");        
                        
                        
                writer.println("</header>");
                writer.println("<section id=\"banner3\">");
				writer.println("<div class=\"inner\">");
					writer.println("<h1>GAUSS JORDAN</h1>");
					writer.println("<p>Un reporte generado totalmente en java<br />");
					writer.println("</div>");
				writer.println("<video autoplay loop muted playsinline src=\"images/banner2.mp4\"></video>");
			writer.println("</section>");
                        
            writer.println("<section class = \"wrapper\">");
                writer.println("<div class = \"inner\">");
                    writer.println("<header class = \"special\">");
            writer.println("<h3>");
            writer.println("La ruta del archivo que contiene el sistema de ecuaciones:");
            writer.println("</h3>");
            writer.println("<p>");
            writer.println("<code>");
            writer.println(direccionGauss);
            writer.println("</code>");
            writer.println("</p>");
            writer.println("La matriz que contiene el sistema de ecuaciones :");//ACÁ QUIERO ENSEÑAR LA MATRIZ QUE INGRESAMOS
            
            writer.println("<div class = \"table-wrapper\">");
            writer.println("<table class = \"alt\">");
            writer.println("<tbody>");	
            for(int i = 0; i < aa1; i++)
            {
                writer.println("<tr>");
                for(int j = 0; j < textElements1.length/aa1; j++){
                    writer.print("<th>");
                    writer.print(mattriz1[i][j]);
                    writer.print("</th>");
                    
                }
                writer.println("</tr>");
            }
            writer.println("</tbody>");
            writer.println("</table>");
            writer.println("</div>");
            
            

            
            writer.println("<h3>");
            writer.println("Los pasos para solucionar el sistema de ecuaciones:");//DESPUÉS DE ESTO ENSEÑO LOS PASOS, EN FILA NO EN TABLA
            writer.println("</h3>");
            
  
            //------aca irian los pasos
            
            
            
            writer.println("<h3>");
            writer.println("El resultado del sistema de ecuaciones es:");
            writer.println("</h3>");
            
            writer.println("<b>");
            writer.println();//ACÁ MUESTRO LOS RESULTADOS
            writer.println("</b>");
            
            writer.println("</header>");
            writer.println("</div>");
            writer.println("</section>");
           
            
            
            writer.println("<footer id=\"footer\">");
		writer.println("<div class=\"inner\">");
                    writer.println("<div class=\"content\">");
			writer.println("<section>");
                            writer.println("<h3>Rodrigo Antonio Porón De León</h3>");
                                writer.println("<p>Laboratorio de Introducción a la Programación y Computación</p>");
                                writer.println("<p>Sección D</p>");
			writer.println("</section>");
                writer.println("</div>");
                writer.println("</div>");
            writer.println("</footer>");
            
            
            			writer.println("<script src=\"assets/js/jquery.min.js\"></script>");
			writer.println("<script src=\"assets/js/browser.min.js\"></script>");
			writer.println("<script src=\"assets/js/breakpoints.min.js\"></script>");
			writer.println("<script src=\"assets/js/util.js\"></script>");
			writer.println("<script src=\"assets/js/main.js\"></script>");
            writer.println("</body>");
            writer.println("</html>");
            
            
            writer.close();
        
        
        
    } catch (Exception e){
        e.printStackTrace();
    }        
        
        
        
        
        return y;
        
  
        
        
        
    }  
}
