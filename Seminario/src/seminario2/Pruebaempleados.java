package seminario2;
import java.util.Date;



/**
 *
 * @author Estudiante
 */
public class Pruebaempleados {
    public static void main(String[] args) {
       // Empleado empleado = new Empleado("Juan",100,2001);
        //System.out.println("Empleado"+ empleado.getNombre());
        
       // Jefe jefe = new Jefe("Pedro",1200,1999,0.5f);
       // System.out.println("Jefe:"+ jefe.getNombre());
        
       // System.out.println("Salario del Jefe: "+ jefe.getSalario());
        
       // System.out.println(jefe.getDesripcion());
       // Administrativa admin = new Administrativa("Pedro",900,2003,jefe);
       // System.out.println("Administrativo:"+ admin.getNombre());
       // System.out.println("Gana:"+ admin.getSalario());
       
      /* Empleado empleado = new Empleado ("Juan",1200,1999);
       empleado = new Jefe ("Pedro",1200,1999,0.5f);
       if(empleado instanceof Jefe){
        Jefe jefe =(Jefe)empleado;
        jefe.setBonificacion(0.7f);
        System.out.println(jefe.getNombre());
    } else
            System.out.println("El empleado no es un jefe");
    
    
    }*/
        /*Solucion 1 del Seminario 2
        Empleado[] empleados = new Empleado[3];
        empleados[0]= new Empleado ("Juan",1000,2001);
        Jefe jefe = new Jefe ("Pedro",1200,1999,0.5f);
        empleados[1]=jefe;
        empleados[2]= new Administrativa("Enrique",900,200,jefe);
        
        for(Empleado empleado : empleados){
            if(empleado instanceof Jefe){
        Jefe jefe2 =(Jefe)empleado;
        System.out.println("Soy"+jefe2.getNombre()+"y gano:"+ jefe2.getSalario());
        }else if(empleado instanceof Administrativa){
            Administrativa admin =(Administrativa)empleado;
                System.out.println("Soy"+ admin.getNombre()+"y gano"+admin.getSalario());
                
        }else{System.out.println("Soy"+ empleado.getNombre()+"y gano"+empleado.getSalario());
        
    }
        }*/
        
        
        /*Solucion 2 del Seminario 2
        Empleado[] empleados = new Empleado[3];
        empleados[0]= new Empleado ("Juan",1000,2001);
        Jefe jefe = new Jefe ("Pedro",1200,1999,0.5f);
        empleados[1]=jefe;
        empleados[2]= new Administrativa("Enrique",900,200,jefe);
        
        for(Empleado empleado : empleados){
            
   System.out.println("Soy"+ empleado.getNombre()+"y gano"+empleado.getSalario());
        
    }*/
        
        // EJEMPLO JUSTIFICADO
        Empleado[] empleados = new Empleado[3];
        empleados[0]= new Empleado ("Juan",1000,2001);
        Jefe jefe = new Jefe ("Pedro",1200,1999,0.5f);
        empleados[1]=jefe;
        empleados[2]= new Administrativa("Enrique",900,200,jefe);
        for(Empleado empleado : empleados){
        if(empleado instanceof Jefe){
        Jefe jefe2 =(Jefe)jefe;
        jefe.setBonificacion(0.8f);
        System.out.println("Bonificacion para: "+jefe.getNombre());
    } 
    
        }
    }
}

