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
public class Vivienda extends Construccion {
    
    private int num_habitaciones;

    public Vivienda(int precio, int num_habitaciones, String ubicacion, double metrosc, mano_construc mano) {
        super(ubicacion, metrosc, mano);
        this.num_habitaciones = num_habitaciones;
    }

    public int getNum_habitaciones() {
        return num_habitaciones;
    }

    @Override
    public void muestra() {
        super.muestra();
        System.out.println("num_habitaciones: " + this.num_habitaciones);
    }
    
    
    
    
    
    
    
}
