package Proyectos;

import java.util.Objects;

public class Tarea implements Cloneable {

    private final String nombre;
    private int duracion;
    private final Fase fase;
    private boolean finalizada;

    public Tarea(String nombre, int duracion, Fase fase) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.fase = fase;
        this.finalizada = false;
    }

    public Tarea(String nombre, Fase fase) {
        this(nombre, 10, fase);
    }


    public int getDuracion() { return duracion;
    }
    public void setDuracion(int duracion) { this.duracion = duracion;
    }

    public boolean isFinalizada() {
        return finalizada;
    }
    public void setFinalizada(boolean finalizada) { this.finalizada = finalizada;
    }

    public String getNombre() { return nombre;
    }
    public Fase getFase() { return fase; 
    }

    //Metodos de la Clase Object
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nombre);
        hash = 43 * hash + Objects.hashCode(this.fase);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return this.fase == other.fase;
    }
    
    @Override
    protected Tarea clone() throws CloneNotSupportedException {
        try {
            Tarea copia = (Tarea) super.clone();
            copia.finalizada = false;
            return copia;
        } catch (CloneNotSupportedException e) {
            System.out.println("ERROR EN LA COPIA DE TAREA: " + e.getMessage());
        }

        return null;
    }

    @Override
    public String toString() {
        return "Tarea{" + "nombre=" + nombre + ", duracion=" + duracion + ", fase=" + fase + ", finalizada=" + finalizada + '}';
    }
}
