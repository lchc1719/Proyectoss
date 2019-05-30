package Proyectos;

import Proyectos.Proyecto;
import Proyectos.Fase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProyectoDuracionLimitada extends Proyecto {

    protected final int duracionMax;

    public ProyectoDuracionLimitada(String nombre, int duracionMaxima) {
        super(nombre);
        this.duracionMax = duracionMaxima;
    }
    
    
    public int getDuracionMax() {
        return duracionMax;
    }
    
    
    //Metodos Sobreescritos
    
    @Override
    public boolean añadirTarea(String nombre, int duracion, Fase fase) {
        int durActual = this.getDuracion();
        if ((durActual + duracion) > duracionMax) {
            return false;
        }
        return super.añadirTarea(nombre, duracion, fase);
    }

    @Override
    public boolean esArrancable() {
        List<Fase> fases = Arrays.asList(Fase.values());
        for (int i = 0; i < fases.size(); i++) {
            Fase fase = fases.get(i);
            if (this.getTareasPorFase(fase).isEmpty()) {
                return false;
            }
        }

        return true;
    }

    
    
    @Override
    public ProyectoDuracionLimitada clone() {
        ProyectoDuracionLimitada copia = (ProyectoDuracionLimitada) super.clone();
        return copia;
    }
    
    
}
