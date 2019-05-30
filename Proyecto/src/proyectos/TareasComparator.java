package Proyectos;

import Proyectos.Tarea;
import java.util.Comparator;

public class TareasComparator implements Comparator<Tarea> {

    @Override
    public int compare(Tarea t1, Tarea t2) {
        int result = Integer.compare(t1.getDuracion(), t2.getDuracion());
        if (result == 0) {
            String strnum1 = t1.getNombre();
            String strnum2 = t2.getNombre();
            result = strnum1.compareTo(strnum2);
        }

        return result;
    }

}
