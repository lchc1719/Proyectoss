package Proyectos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Implementa un programa con los siguientes datos y funcionalidad. Utiliza comentarios
        para indicar cada paso.*/
        Tarea a1 = new Tarea("Extracción de requisitos", 12, Fase.ANALISIS);
        Tarea a2 = new Tarea("Definición de casos de uso", 6, Fase.ANALISIS);

        Tarea d1 = new Tarea("Diseño del modelo de datos", 10, Fase.DISEÑO);

        Tarea i1 = new Tarea("Implementacion de la UI", 20, Fase.IMPLEMENTACION);
        Tarea i2 = new Tarea("Implementación del modelo", 20, Fase.IMPLEMENTACION);
        Tarea i3 = new Tarea("Implementación de las pruebas", 8, Fase.IMPLEMENTACION);

        Tarea de1 = new Tarea("Configuracion de la base de datos", 4, Fase.DESPLIEGUE);
        Tarea de2 = new Tarea("Instalación en el servidor", 6, Fase.DESPLIEGUE);

        Tarea m1 = new Tarea("Programacion nuevos requisitos", 20, Fase.MANTENIMIENTO);

        //Construye una lista con las tareas anteriores.
        List<Tarea> tareas = new ArrayList<>(9);
        Collections.addAll(tareas, a1, a2, d1, i1, i2, i3, de1, de2, m1);

        /*Construye una lista con los siguientes proyectos:
            o Proyecto con duración limitada con nombre “web comercial – equipo 1” y duración
            limitada a 100 horas.
            o Proyecto con fases limitadas llamado “web comercial – equipo 2”. Una vez
            construido el proyecto, se recorrerán todas las fases (método static values
            enumerado) y se establecerá en el proyecto un límite de 2 para cada una de ellas.
            o Proyecto ordenado con nombre “web comercial – equipo 3” y con duración limitada
            a 120 horas.*/
        ProyectoDuracionLimitada pdl;
        pdl = new ProyectoDuracionLimitada("web comercial - equipo 1", 100);

        ProyectoFasesLimitadas pfl;
        pfl = new ProyectoFasesLimitadas("web comecial - equipo 2");
        for (Fase fase : Fase.values()) {
            pfl.setLimiteTareas(fase, 2);
        }

        ProyectoOrdenado po;
        po = new ProyectoOrdenado("web comercial - equipo 3", 120);

        List<Proyecto> proyectos = new ArrayList<>(3);
        Collections.addAll(proyectos, pdl, pfl, po);

        /*Recorre la lista de proyectos y añade al proyecto las tareas de la lista de tareas. Para
        las que no puedan ser insertadas, muestra su nombre por la consola.*/
        for (Proyecto proyecto : proyectos) {
            for (Tarea tarea : tareas) {
                if (!proyecto.añadirTarea(tarea)) {
                    System.out.println(proyecto.toString());
                    System.out.println("ESTA TAREA NO SE PUDO INSERTAR");
                    System.out.println(tarea.toString());
                }
            }
            System.out.println("\n-----------------\n");
        }

        /*Recorre la lista de proyectos y realiza las siguientes operaciones (procesamiento):
            o Arranca los proyectos.
            o En caso de que el proyecto haya podido ser arrancado, realiza las siguientes
            acciones y muestra por la pantalla si han sido efectivas:
                 Finaliza las tareas de las dos primeras fases.
                 Finaliza una de las tareas de la fase de despliegue.
                 Finaliza el resto de tareas que no estén acabadas.
                 Finaliza los proyectos.
            o Si el proyecto es de duración limitada:
                 Muestra la duración máxima.
                 Consulta las tareas ordenadas por duración (ejercicio 5) y muestra por la
                consola el nombre de la primera tarea.*/
        for (Proyecto proyecto : proyectos) {
            proyecto.arrancar();
        }

        //PROCESAMIENTO
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getEstado().equals(Estado.EN_MARCHA)) {
                System.out.println(proyecto.toString());
                LinkedList<Tarea> tareasProyecto = (LinkedList) proyecto.getTareas();
                HashSet<Tarea> lista = (HashSet) proyecto.getTareasPorFase(Fase.ANALISIS);
                System.out.println("ANTES DE");
                System.out.println(tareasProyecto);

                for (Tarea tarea : lista) {
                    proyecto.finalizarTarea(tarea.getNombre(), Fase.ANALISIS);
                }
                System.out.println("(1)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                lista = (HashSet) proyecto.getTareasPorFase(Fase.DISEÑO);
                for (Tarea tarea : lista) {
                    proyecto.finalizarTarea(tarea.getNombre(), Fase.DISEÑO);
                }
                System.out.println("(2)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                lista = (HashSet) proyecto.getTareasPorFase(Fase.DESPLIEGUE);
                proyecto.finalizarTarea(new LinkedList<>(lista).get(0).getNombre(), Fase.DESPLIEGUE);
                System.out.println("(3)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                tareasProyecto = (LinkedList) proyecto.getTareas();
                for (Tarea t : tareasProyecto) {
                    if (!t.isFinalizada()) {
                        proyecto.finalizarTarea(t.getNombre(), t.getFase());
                    }
                }

                System.out.println("(4)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                proyecto.finalizar();
            }

            if (proyecto instanceof ProyectoDuracionLimitada) {
                System.out.println("DURACION MAXIMA: " + ((ProyectoDuracionLimitada) proyecto).getDuracionMax());
                LinkedList<Tarea> listaOrdenada = (LinkedList) proyecto.getTareasOrdenadas(new TareasComparator());
                System.out.println("LISTA DE TAREAS ORDENADAS");
                System.out.println(listaOrdenada);
            }
            System.out.println("\n--------------------\n");
        }

        //Recorre la lista de proyectos y añade una copia de cada uno de ellos
        System.out.println("PROCESAMIENTO CON LAS COPIAS");
        LinkedList<Proyecto> proyectosClone = new LinkedList<>(proyectos);
        for (int i = 0; i < proyectos.size(); i++) {
            Proyecto proyecto = proyectos.get(i);
            proyectosClone.add(proyecto.clone());
        }

        /*Vuelve a repetir los pasos indicados en el punto anterior etiquetado como
        procesamiento.*/
        int contador = 1; //Solo con fines de demostrar que todo sirve
        //Se supone que los 3 primeros proyectos estan finalizados, por ello no entrara
        //ningungo al primer if, sin embargo el proyecto ordenado si entrara al ultimo if
        //Las copias por otro lado siempre empiezan recien comenzadas asi que ellas si entraran
        for (Proyecto proyecto : proyectosClone) {
            proyecto.arrancar();
        }
        
        for (Proyecto proyecto : proyectosClone) {
            System.out.println("Contador: " + contador);
            if (proyecto.getEstado().equals(Estado.EN_MARCHA)) {
                System.out.println(proyecto.toString());
                LinkedList<Tarea> tareasProyecto = (LinkedList) proyecto.getTareas();
                HashSet<Tarea> lista = (HashSet) proyecto.getTareasPorFase(Fase.ANALISIS);
                System.out.println("ANTES DE");
                System.out.println(tareasProyecto);

                for (Tarea tarea : lista) {
                    proyecto.finalizarTarea(tarea.getNombre(), Fase.ANALISIS);
                }
                System.out.println("(1)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                lista = (HashSet) proyecto.getTareasPorFase(Fase.DISEÑO);
                for (Tarea tarea : lista) {
                    proyecto.finalizarTarea(tarea.getNombre(), Fase.DISEÑO);
                }
                System.out.println("(2)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                lista = (HashSet) proyecto.getTareasPorFase(Fase.DESPLIEGUE);
                proyecto.finalizarTarea(new LinkedList<>(lista).get(0).getNombre(), Fase.DESPLIEGUE);
                System.out.println("(3)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                tareasProyecto = (LinkedList) proyecto.getTareas();
                for (Tarea t : tareasProyecto) {
                    if (!t.isFinalizada()) {
                        proyecto.finalizarTarea(t.getNombre(), t.getFase());
                    }
                }

                System.out.println("(4)");
                tareasProyecto = (LinkedList) proyecto.getTareas();
                System.out.println(tareasProyecto);

                proyecto.finalizar();
            }

            if (proyecto instanceof ProyectoDuracionLimitada) {
                System.out.println("DURACION MAXIMA: " + ((ProyectoDuracionLimitada) proyecto).getDuracionMax());
                LinkedList<Tarea> listaOrdenada = (LinkedList) proyecto.getTareasOrdenadas(new TareasComparator());
                System.out.println("LISTA DE TAREAS ORDENADAS");
                System.out.println(listaOrdenada);
            }
            System.out.println("\n--------------------\n");
            contador = contador + 1;
        }
    }
}
