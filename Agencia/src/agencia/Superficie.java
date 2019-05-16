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
public class Superficie extends Inmueble {
    private double precio;

    public Superficie(String ubicacion, double metrosc) {
        super(ubicacion, metrosc);
    }
    
    public void precio(){
        this.precio = 7 * this.metrosc;
    }
    
    
    
}
