/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

/**
 *
 * @author Estudiante
 */
public class Construccion extends Inmueble {
    
    private mano_construc mano;

    public Construccion(String ubicacion, double metrosc, mano_construc mano) {
        super(ubicacion, metrosc);
        this.mano = mano;
    }

    @Override
    public void muestra() {
        super.muestra();
        System.out.println("precio: " + this.getPrecio());
    }

    public mano_construc getMano() {
        return mano;
    }
    
    
    
    
    
    
    
}
