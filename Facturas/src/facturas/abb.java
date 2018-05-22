
package facturas;

/**
 *
 * @author Brian Rivera y Rudy Sanchez
 */

public class abb {
    private class nodoArbol {
        private abb hd;
        private abb hi;
        private Factura dato;
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = null;
        }
    }
 
    public nodoArbol raiz;
 
    public void abb(){
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean esVacio(){
        return (raiz == null);
    }
 
    public void insertar(Factura a){
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hd = new abb();
            nuevo.hi = new abb();
            raiz = nuevo;
        }
        else {
            if (a.id > raiz.dato.id) {
                (raiz.hd).insertar(a);
            }
            if (a.id < raiz.dato.id){
                (raiz.hi).insertar(a);
            }
        }
    }
 

    public void recorrer(){
        if (!esVacio()) {
            raiz.hi.recorrer();
            raiz.dato.imprimir();
            raiz.hd.recorrer();
        }
    }
 
    public Factura buscar(int a){
        if (!esVacio()) {
            if (a == raiz.dato.id) {
            return this.raiz.dato;
            }
            else {
                if (a < raiz.dato.id) {
                   return(raiz.hi.buscar(a));
                }
                else {
                    return(raiz.hd.buscar(a));
                }
            }
        }
        return null;
    }
 
    public boolean existe(int a){
    if (!esVacio()) {
            if (a == raiz.dato.id) {
            return true;
            }
            else {
                if (a < raiz.dato.id) {
                    raiz.hi.existe(a);
                }
                else {
                    raiz.hd.existe(a);
                }
            }
        }
        return false;
    }
 
}
