package practica1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rodrigo Porón
 */
public class Archivos {
    
    private File txt;
    private String content;
    
    public Archivos(File txt) {
        this.txt = txt;
        this.content = "";
        leerContenido();
    }

    public void leerContenido() {
        String linea = null;
        FileReader f = null;
        BufferedReader b = null;
        StringBuilder aux = new StringBuilder();
        try {
            f = new FileReader(this.txt);
            b = new BufferedReader(f);
            try {

                while ((linea = b.readLine()) != null) {
                    aux.append(linea);
                    aux.append("\n");
                }
            } catch (IOException e) {
                    System.out.println("Error accediendo al archivo");
                    e.printStackTrace();  
            }

        } catch (FileNotFoundException e) {
                    System.out.println("No se encuentra archivo");
                    e.printStackTrace();
        }
        this.content = aux.toString();
    }

    public String getContenido() {
        return content;
    }

    public int ObLineas() {
        if (this.content.equals("")) {
            return 0;
        } else {
            return this.content.split("\n").length;
        }
    }

    public int ObPalabras() {
        if (this.content.equals("")) {
            return 0;
        } else {
            return this.content.replace("\n", " ").split("\\s+").length;
        }
    }

    public int ObCaracteres() {

        return this.content.replaceAll(",", "").replace("\n", "").length();
    }
    
}
