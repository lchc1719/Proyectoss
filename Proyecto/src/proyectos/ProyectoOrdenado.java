package Proyectos;

import Proyectos.Tarea;
import Proyectos.Estado;
import Proyectos.Fase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ProyectoOrdenado extends ProyectoDuracionLimitada {

    public ProyectoOrdenado(String nombre, int duracionMaxima) {
        super(nombre, duracionMaxima);
    }

    //Metodos
    public boolean tareasTerminadas(Fase fase) {
        HashSet<Tarea> lista = (HashSet) this.getTareasPorFase(fase);
        for (Tarea t : lista) {
            if (!t.isFinalizada()) {
                return false;
            }
        }

        return true;
    }

    //Funcionalidades Sobreescritas
  
      @Override
    public boolean finalizar() {
        HashSet<Tarea> lista = (HashSet<Tarea>) this.getTareasPorFase(Fase.MANTENIMIENTO);
        for (Tarea t : lista) {
            if (!t.isFinalizada()) {
                return false;
            }
        }

        this.setEstado(Estado.FINALIZADO);
        return true;
    }

    
    @Override
    public boolean finalizarTarea(String nombre, Fase fase) {
        List<Fase> fases = Arrays.asList(Fase.values());
        int pos = fases.indexOf(fase);
        if (pos > 0) {
            if (!tareasTerminadas(fases.get(pos - 1))) {
                return false;
            }
        }

        return super.finalizarTarea(nombre, fase);
    }

  
    @Override
    public ProyectoOrdenado clone() {
        ProyectoOrdenado copia = (ProyectoOrdenado) super.clone();
        return copia;
    }
}
