
package facturas;

/**
 *
 * @author Brian Rivera y Rudy Sanchez
 */

public class Factura {
    
    public int id;
    public int nit;
    public String nombre;
    public double monto;
    
    public Factura(int idF, String nombreF, int nitF, int montoF){ //Constructor
        this.id = idF;
        this.nombre = nombreF;
        this.nit = nitF;
        this.monto = montoF;
    }
    
    public void imprimir(){
        System.out.println("");
        System.out.print(this.id+"  ");
        System.out.print(this.nit+"  ");
        System.out.print(this.nombre+"  ");
        System.out.print(this.monto+"  ");
    }
    
    public void imprimir2(){
        System.out.println("");
        System.out.println("Mostrando la factura "+ this.id + ":");
        System.out.println("Número de factura:"+this.id+"  ");
        System.out.println("Nombre del cliente: "+this.nombre+"  ");
        System.out.println("Nit del cliente: "+this.nit+"  ");
        System.out.println("Monto facturado: "+this.monto+"  ");
    }
}
