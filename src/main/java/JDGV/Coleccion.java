package JDGV;


import MGI.Curso;

import java.util.*;
import java.util.stream.Collectors;

// Y la siguiente coleccion
public class Coleccion {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300));

        //Obtener la cantidad de cursos con una duración mayor a 5 horas
        int durations = cursos.stream()
                .map(Curso::getDuracion)
                .filter(x->x>5.0f)
                .collect(Collectors.toList())
                .size();
        System.out.println("\nCursos con duracion mayor a 5 horas = " + durations);

        //Obtener la cantidad de cursos con una duración menor a 2 horas
        durations = cursos.stream()
                .map(Curso::getDuracion)
                .filter(x->x<2.0f)
                .collect(Collectors.toList())
                .size();
        System.out.println("\nCursos con duracion menor a 2 horas = " + durations);

        //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
        List<String> tituloVideos = cursos.stream()
                .filter(Curso->Curso.getVideos()>50)
                .map(Curso::getTitulo)
                .toList();
        System.out.println("\nCursos con una cantidad de videos mayor a 50:\n" + tituloVideos);

        //Mostrar en consola el título de los 3 cursos con mayor duración.
        System.out.println("\nLos tres cursos con mayor duracion");
        cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion))
                .toList()
                .subList(cursos.size()-3, cursos.size()).
                forEach(curso -> System.out.println(curso.getTitulo()));

        //Mostrar en consola la duración total de todos los cursos.
        DoubleSummaryStatistics stats = cursos.stream()
                .map(Curso::getDuracion)
                .mapToDouble((x)-> x)
                .summaryStatistics();
        System.out.println("\nDuracion total de los cursos: " + stats.getSum());

        //Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
        System.out.println("\nCursos que superan la duracion promedio");
        cursos.stream()
                .filter(curso -> curso.getDuracion() > stats.getAverage())
                .forEach(curso -> System.out.println(curso.getTitulo()));



        //Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        List<Float> duracionInscritos = cursos.stream()
                .filter(Curso->Curso.getAlumnos()<500)
                .map(Curso::getDuracion)
                .toList();
        System.out.println("\nDuracion de cursos con mas de 500 alumnos:\n" + duracionInscritos);

        //Obtener el curso con mayor duración.
        String cursoMayorDuracion = cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion))
                .toList()
                .get(cursos.size()-1)
                .getTitulo();
        System.out.println("\nCurso con mayor duracion:\n" + cursoMayorDuracion);



        //Crear una lista de Strings con todos los titulos de los cursos
        List<String> listaTitulos = cursos.stream()
                .map(Curso::getTitulo)
                .collect(Collectors.toList());
        System.out.println("\nLista de los titulos de los cursos:\n"+listaTitulos);


    }
    /***
     * Resolver los siguientes problemas con streams:
     * Obtener la cantidad de cursos con una duración mayor a 5 horas.
     * Obtener la cantidad de cursos con una duración menor a 2 horas.
     * Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
     * Mostrar en consola el título de los 3 cursos con mayor duración.
     * Mostrar en consola la duración total de todos los cursos.
     * Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
     * Mostrar en consola la duración de todos aquellos cursos que tengan una
     * cantidad de alumnos inscritos menor a 500.
     * Obtener el curso con mayor duración.
     * Crear una lista de Strings con todos los titulos de los cursos.
     *
     * Una vez terminado subirlo al repositorio
     */
}