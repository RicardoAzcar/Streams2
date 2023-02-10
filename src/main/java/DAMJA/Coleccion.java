package DAMJA;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
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

        //1- Obtener la cantidad de cursos con una duración mayor a 5 horas.
        System.out.println("1) cursos mayores a 5 horas = ");
        cursos.stream().filter((curso)->{ return curso.getDuracion() > 5.00;}).collect(Collectors.toList())
                .forEach((curso)-> System.out.println( curso.getTitulo()));
        System.out.println();


        //2- Obtener la cantidad de cursos con una duración menor a 2 horas.
        System.out.println("2) cursos menores a 2 horas = ");
        cursos.stream().filter((curso)->{ return curso.getDuracion() < 2.00;}).collect(Collectors.toList())
                .forEach((curso)-> System.out.println( curso.getTitulo()));
        System.out.println();

        System.out.println("3) cursos mayor a 50 videos = ");
        //3- Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
        cursos.stream().filter((curso)->{ return curso.getVideos() >50;}).collect(Collectors.toList())
                .forEach((curso)-> System.out.println( curso.getTitulo()));
        System.out.println();


        System.out.println("4) Los tres cursos con mayor duración =");
        //4- Mostrar en consola el título de los 3 cursos con mayor duración.

        cursos.stream().sorted(Comparator.comparing(Curso::getDuracion,Comparator.reverseOrder()))
                .limit(3)
                .forEach(curso -> System.out.println( curso.getTitulo()));
        System.out.println();

        System.out.println("5) Duración total de los cursos=");
        //5- Mostrar en consola la duración total de todos los cursos.
        cursos.stream()
                .map((duracion)-> duracion.getDuracion());
        DoubleSummaryStatistics duracionTotal = cursos.stream()
                .mapToDouble((x)->x.getDuracion()).summaryStatistics();
        System.out.println(duracionTotal.getSum() + " horas");
        System.out.println();

        //6- Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
        System.out.println("6) cursos que superan el promedio en duración : ");
        System.out.println("Duracion promedio de todos los cursos = " + duracionTotal.getAverage());
        cursos.stream()
                .map((duracion)-> duracion.getDuracion());
        DoubleSummaryStatistics superaPromedio = cursos.stream().mapToDouble((x)->x.getDuracion())
                .summaryStatistics();

        cursos.stream().filter((curso)->{ return curso.getDuracion() > duracionTotal.getAverage();})
                .collect(Collectors.toList())
                .forEach((curso)-> System.out.println( curso.getTitulo()));
        System.out.println();

        //7- Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        System.out.println("7) Cursos que superan 500 alumnos = ");
        cursos.stream().filter((curso)->{ return curso.getAlumnos() > 500;}).collect(Collectors.toList())
                .forEach((curso)-> System.out.println( curso.getTitulo()));

        System.out.println();
        //8- Obtener el curso con mayor duración.
        System.out.println("8) Curso con mayor duración =");


        cursos.stream().sorted(Comparator.comparing(Curso::getDuracion,Comparator.reverseOrder()))
                .limit(1)
                .forEach(curso -> System.out.println(curso.getTitulo()));

        //9- Crear una lista de Strings con todos los titulos de los cursos.
        System.out.println("9) Lista en un String =");
        List<String> listaCursos = cursos.stream()
                .map(Curso::getTitulo)

                .distinct()
                .collect(Collectors.toList());
        System.out.println(listaCursos);

    }
    /***
     * Resolver los siguientes problemas con streams:
     * 1 Obtener la cantidad de cursos con una duración mayor a 5 horas. +++++
     * 2 Obtener la cantidad de cursos con una duración menor a 2 horas. +++++
     * 3 Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.- +++++
     * 4 Mostrar en consola el título de los 3 cursos con mayor duración.     ++++
     * 5 Mostrar en consola la duración total de todos los cursos. ++++
     * 6 Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere. ++++
     * 7 Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500. ++++
     * 8 Obtener el curso con mayor duración. ++++
     * 9 Crear una lista de Strings con todos los titulos de los cursos.
     *
     * Una vez terminado subirlo al repositorio
     */
}