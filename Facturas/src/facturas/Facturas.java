/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturas;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        long filas = 0;
        
        try
        {
            //Crea un objeto de selección de archivo
            JFileChooser fc = new JFileChooser();
            //Establece el título para la selección del archivo
            fc.setDialogTitle("Seleccione el archivo CSV con los datos de facturas");
            //Establece la extensión a utilizar
            fc.setFileFilter(new FileNameExtensionFilter("Archivo CSV", "csv"));
            
            int seleccion = fc.showDialog(null, "Abrir!");
            
            switch(seleccion) {
                //Si el usuario abre el archivo, recolecta la ruta del mismo y lo guarda en la variable ruta, para su posterior uso
                case JFileChooser.APPROVE_OPTION:
                 File archivo = fc.getSelectedFile();
                 ruta = archivo.getPath();     
                break;
                //Si el usuario cancela, le tirará el mensaje que debe elegir un archivo válido
                case JFileChooser.CANCEL_OPTION:
                System.out.println("Debes elegir un archivo CSV válido");
                break;

                case JFileChooser.ERROR_OPTION:
                System.out.println("Error");
                break;
        } 
            
        } catch (Exception e)
        {
            System.out.println("");
        }
        
        System.out.println();
    }
  
}
