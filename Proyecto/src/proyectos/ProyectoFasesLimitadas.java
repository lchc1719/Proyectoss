package Proyectos;

import Proyectos.Proyecto;
import Proyectos.Tarea;
import Proyectos.Fase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProyectoFasesLimitadas extends Proyecto {

    private HashMap<Fase, Integer> limites;
    private HashMap<Fase, ArrayList<Tarea>> control;

    public ProyectoFasesLimitadas(String nombre) {
        super(nombre);
        this.limites = new HashMap<>();
        this.control = new HashMap<>();
    }

    //Metodos
  

    public boolean setLimiteTareas(Fase fase, int limite) {
        if (limites.containsKey(fase)) {
            int num = getNumeroTareasPorFase(fase);
            if (num <= limite) {
                limites.replace(fase, limite);
                return true;
            }
        } else {
            ArrayList<Tarea> lista = new ArrayList<>(limite);
            limites.put(fase, limite);
            control.put(fase, lista);
            return true;
        }

        return false;
    }

      public int getNumeroTareasPorFase(Fase fase) {
        if (control.containsKey(fase)) {
            ArrayList<Tarea> lista = control.get(fase);
            if (lista != null) {
                return lista.size();
            }
        }

        return -1;
    }
      
    public int getLimitePorFase(Fase fase) {
        if (limites.containsKey(fase)) {
            return limites.get(fase);
        }

        return 0;
    }

    //Funcionalidades Sobreescritas
    @Override
    public boolean añadirTarea(String nombre, int duracion, Fase fase) {
        int cant = getNumeroTareasPorFase(fase);
        int limiteFase = getLimitePorFase(fase);
        if (cant < limiteFase) {
            if (super.añadirTarea(nombre, duracion, fase)) {
                Tarea tarea = new Tarea(nombre, duracion, fase);
                ArrayList<Tarea> lista = control.get(fase);
                lista.add(tarea);
                control.replace(fase, lista);
                return true;
            }
        }

        return false;
    }

 
   @Override
    public boolean esArrancable() {
        int duracionTotal = this.getDuracion();
        for (Tarea t : this.tareas) {
            if (t.getDuracion() > Math.floor((0.5) * duracionTotal)) {
                return false;
            }
        }

        return true;
    }
    
    
    @Override
    public ProyectoFasesLimitadas clone() {
        ProyectoFasesLimitadas copia = (ProyectoFasesLimitadas) super.clone();
        copia.control = new HashMap<>(copia.control);
        copia.limites = new HashMap<>(copia.limites);
        return copia;
    }
}
