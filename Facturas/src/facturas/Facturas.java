
package facturas;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Brian Rivera y Rudy Sanchez
 */
public class Facturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = null;

        try {
            //Crea un objeto de selección de archivo
            JFileChooser fc = new JFileChooser();
            //Establece el título para la selección del archivo
            fc.setDialogTitle("Seleccione el archivo CSV donde se encuentran almacenadas las facturas");
            //Establece la extensión a utilizar
            fc.setFileFilter(new FileNameExtensionFilter("Archivo CSV", "csv"));

            int seleccion = fc.showDialog(null, "Abrir!");

            switch (seleccion) {
                //Si el usuario abre el archivo, recolecta la ruta del mismo y lo guarda en la variable ruta, para su posterior uso
                case JFileChooser.APPROVE_OPTION:
                    File archivo = fc.getSelectedFile();
                    ruta = archivo.getPath();
                    break;
                //Si el usuario cancela, le tirará el mensaje que debe elegir un archivo válido
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("Porfavor seleccione un archivo CSV válido");
                    break;

                case JFileChooser.ERROR_OPTION:
                    System.out.println("Porfavor seleccione un archivo CSV válido");
                    break;
            }
            // Empezamos a leer el archivo CSV linea por linea y separando cada linea por comas.
            String line = null;
            abb arbol = new abb();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(ruta));
                while ((line = reader.readLine()) != null) {

                    List<String> arrLine = Arrays.asList(line.split(",")); // Array de todos los campos en cada linea+
                    int numeroF = Integer.parseInt(arrLine.get(0).replaceAll("\\s", "")); //limpiamos los espacios en blanco que pudiera tener el numero de factura
                    String nombreF = arrLine.get(1);
                    int nitF = Integer.parseInt(arrLine.get(2).replaceAll("\\s", "")); //limpiamos los espacios en blanco que pudiera tener el nit de factura
                    int montoF = Integer.parseInt(arrLine.get(3).replaceAll("\\s", "")); //limpiamos los espacios en blanco que pudiera tener el monto de factura
                    Factura nFactura = new Factura(numeroF, nombreF, nitF, montoF); //creamos un objeto de tipo factura
                    arbol.insertar(nFactura);
                }
                System.out.println("Proyecto Árboles");
                System.out.println("Rudy Sánchez y Brian Rivera");
                System.out.println("");
                System.out.println("Archivo CSV cargado con éxito");
                int opcion = 0;
                while (opcion != 3){
                    System.out.println("");
                    System.out.println("¿Qué desea hacer a continuación? Ingrese el número de su opción y oprima la tecla enter");
                    System.out.println("     1. Buscar una factura por ID ");
                    System.out.println("     2. Mostrar lista de facturas ");
                    System.out.println("     3. Salir ");
                    Scanner scan = new Scanner(System.in);
                    opcion = scan.nextInt();
                    
                    switch (opcion){
                        case 1:
                            System.out.println("");
                            System.out.println("Ingrese el número de factura que desea visualizar");
                            int nf = scan.nextInt();
                            Factura factura = arbol.buscar(nf);
                            if (factura != null){
                                factura.imprimir2();
                            } else
                                System.out.println("La factura no existe");
                            break;
                            
                        case 2:
                            System.out.println("");
                            System.out.println("Número | Nit | Nombre | Monto");
                            arbol.recorrer();
                            break;
                            
                        case 3:
                            System.out.println("Ha finalizado la ejecución del programa");
                            break;
                        default:
                            System.out.println("Elija una opción correcta");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("");
        }

        System.out.println();
    }

}
