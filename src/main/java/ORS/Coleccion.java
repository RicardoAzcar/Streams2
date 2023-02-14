package ORS;

import java.util.ArrayList;
import java.util.Comparator;
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

        //Obtener la cantidad de cursos con una duración mayor a 5 horas.
        System.out.println("Número de cursos mayor a 5 horas: " + cursos.stream()
                .filter(i -> i.getDuracion() > 5f)
                .count());

        //Obtener la cantidad de cursos con una duración menor a 2 horas.
        System.out.println("Número de cursos menor a 2 horas: " + cursos.stream()
                .filter(i -> i.getDuracion() < 2f)
                .count());

        //Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
        List<String> titles = cursos.stream()
                .filter(i -> i.getVideos() > 50)
                .map(i -> i.getTitulo())
                .collect(Collectors.toList());
        System.out.println("Cursos mayor a 50 videos: " + titles);

        //Mostrar en consola el título de los 3 cursos con mayor duración.
        Comparator<Curso> comparator = Comparator.comparing(curso -> curso.getDuracion());
        cursos.stream()
                .sorted(comparator.reversed())
                .limit(3)
                .forEach(i -> System.out.println(i.getTitulo()));

        //Mostrar en consola la duración total de todos los cursos.
        System.out.println(cursos.stream()
                .reduce(0f, (dur, curso) -> dur + curso.getDuracion(), Float::sum));

        //Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
        List<Curso> longCourses = cursos.stream()
                .filter(curso -> curso.getDuracion() > cursos.stream()
                        .mapToDouble( i -> i.getDuracion())
                        .average()
                        .orElse(0))
                .collect(Collectors.toList());
        System.out.println(longCourses);

        //Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
        cursos.stream()
                .filter(curso -> curso.getAlumnos() < 500)
                .forEach(curso -> System.out.println(curso.getDuracion()));

        //Obtener el curso con mayor duración.
        Curso longestCourse = cursos.stream()
                .sorted(comparator.reversed())
                .findFirst()
                .orElse(new Curso("Curso Default", 0f, 0, 0 ));
        System.out.println(longestCourse);

        //Crear una lista de Strings con todos los titulos de los cursos.
        List<String> allTitles = cursos.stream()
                .map(i -> i.getTitulo())
                .collect(Collectors.toList());
        System.out.println(allTitles);
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