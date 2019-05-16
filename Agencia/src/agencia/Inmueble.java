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
public abstract class Inmueble {
    protected String ubicacion;
    protected double metrosc;
    private double precio;

    public Inmueble(String ubicacion, double metrosc) {
        this.ubicacion = ubicacion;
        this.metrosc = metrosc;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public double getMetrosc() {
        return metrosc;
    }
    
    public void muestra(){
        System.out.println("ubicacion: " + this.ubicacion + " metrosc: " + this.metrosc);
    }

    public double getPrecio() {
        return precio;
    }

    ZonaSolar getUbic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    mano_construc getMano() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
