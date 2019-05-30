package Proyectos;

import Proyectos.Tarea;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Proyecto implements Cloneable {

    protected String nombre;
    protected HashSet<Tarea> tareas;
    protected Estado estado;

    protected Proyecto(String nombre) {
        this.nombre = nombre;
        this.tareas = new HashSet<>();
        this.estado = Estado.NO_INICIADO;
    }

    

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public List<Tarea> getTareas() {
        return new LinkedList<>(tareas);
    }
    
    

    public int getDuracion() {
        int duracionTotal = 0;
        for (Tarea t : this.tareas) {
            duracionTotal += t.getDuracion();
        }
        return duracionTotal;
    }


    public HashSet<Tarea> getTareasPorFase(Fase fase) {
        HashSet<Tarea> conjunto = new HashSet<>();
        LinkedList<Tarea> lista = new LinkedList<>(this.tareas);
        for (int i = 0; i < this.tareas.size(); i++) {
            Tarea tarea = lista.get(i);
            if (fase.equals(tarea.getFase())) {
                conjunto.add(tarea);
            }
        }

        return conjunto;
    }

    public boolean añadirTarea(String nombre, int duracion, Fase fase) {
        return tareas.add(new Tarea(nombre, duracion, fase));
    }
    
    
    public boolean añadirTarea(Tarea t) {
        return añadirTarea(t.getNombre(), t.getDuracion(), t.getFase());
    }

    public boolean eliminarTarea(Tarea t) {
        return tareas.remove(t);
    }

    public boolean finalizarTarea(String nombre, Fase fase) {
        Tarea tarea = new Tarea(nombre, fase);
        for (Tarea ite : this.tareas) {
            if (ite.equals(tarea)) {
                ite.setFinalizada(true);
                return true;
            }
        }

        return false;
    }
 public boolean finalizar() {
        Estado e = this.getEstado();
        if (e.equals(Estado.EN_MARCHA)) {
            for (Tarea t : tareas) {
                if (!t.isFinalizada()) {
                    return false;
                }
            }

            this.setEstado(Estado.FINALIZADO);
        }

        return true;
    }

    
    
    public abstract boolean esArrancable();

    public boolean arrancar() {
        Estado e = this.getEstado();
        if (e.equals(Estado.NO_INICIADO)) { 
            if (!this.getTareasPorFase(Fase.ANALISIS).isEmpty()) { 
                if (esArrancable()) { 
                    this.setEstado(Estado.EN_MARCHA);
                    return true;
                }
            }
        }

        return false;
    }
    
    
    @Override
    public Proyecto clone() {
        try {
            Proyecto copia = (Proyecto) super.clone();
            copia.estado = Estado.NO_INICIADO;
            for (Tarea t : copia.tareas) {
                t.setFinalizada(false);
            }

            return copia;
        } catch (CloneNotSupportedException e) {
            System.err.println("ERROR EN LA COPIA: " + e.getMessage());
        }

        return null;
    }

    
    public List<Tarea> getTareasOrdenadas(Comparator<Tarea> criterio) {
        List<Tarea> lista = new LinkedList<>(tareas);
        Collections.sort(lista, criterio);
        return lista;
    }
}
