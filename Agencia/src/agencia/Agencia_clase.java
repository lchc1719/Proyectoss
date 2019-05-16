/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Agencia_clase {
    
    private ArrayList<Inmueble> en_venta;
    private ArrayList<Inmueble> en_alquiler;

    public Agencia_clase() {
        this.en_venta = new ArrayList<Inmueble>();
        this.en_alquiler = new ArrayList<Inmueble>();
    }
    
     public void añadeVentaInmueble(Inmueble inmueble){
         this.en_venta.add(inmueble);
     }
     
     public void anadeAlquilerInmueble(Inmueble inmueble){
         this.en_alquiler.add(inmueble);
     }
     
     public void inmueblesVenta(double precio){
         for(Inmueble vendiendo : this.en_venta){
             if(vendiendo.getPrecio() < precio){
                 System.out.println(vendiendo.getUbicacion());
             }
         }
     }
     
     public void localesSegundaMano(double metros){
         for(Inmueble inmueble : this.en_alquiler){
             if(inmueble.getMano() == mano_construc.SEGUNDA){
                 if(inmueble.getMetrosc() > metros){
                     System.out.println("mostrar");
                 }
             }
         }
     }
     public void solaresRusticos(){
         for(Inmueble inmueble : this.en_venta){
             if(inmueble.getUbic() == ZonaSolar.RUSTICA){
                 System.out.println("mostrar");
             }
         }
     }
    
    
    
}
