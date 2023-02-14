package DEHR;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// Y la siguiente coleccion
public class Coleccion {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300));

        long count = cursos.stream()
                .filter(curso -> curso.getDuracion() > 5)
                .count();
        System.out.println("Cantidad de cursos con una duración mayor a 5 horas = " + count);

        count = cursos.stream()
                .filter(curso -> curso.getDuracion()<2)
                .count();
        System.out.println("\nCantidad de cursos con una duración menor a 2 horas = " + count);

        System.out.println("\n***Título de todos aquellos cursos con una cantidad de vídeos mayor a 50***\n");
        cursos.stream()
                .filter(s -> s.getVideos()>50)
                .map(Curso::getTitulo)
                .toList()
                .forEach(System.out::println);

        System.out.println("\n***Título de los 3 cursos con mayor duración***\n");
        cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion).reversed())
                .limit(3)
                .map(Curso::getTitulo)
                .toList()
                .forEach(System.out::println);


        Double db = cursos.stream()
                .mapToDouble(Curso::getDuracion)
                .sum();
        System.out.println("\nLa duración total de todos los cursos = "+db);

        System.out.println("\n***Cursos que superen el promedio en cuanto a duración se refiere***\n");
        cursos.stream()
                .filter(curso -> curso.getDuracion()>(cursos.stream()
                        .mapToDouble(Curso::getDuracion)
                        .sum()/5))
                .map(Curso::getTitulo)
                .toList()
                .forEach(System.out::println);

        System.out.println("\n***La duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500***\n");
        cursos.stream()
                .filter(curso -> curso.getAlumnos()<500)
                .map(Curso::getDuracion)
                .toList()
                .forEach(System.out::println);

        System.out.println("\n***El curso con mayor duración***\n");
        cursos.stream()
                .sorted(Comparator.comparing(Curso::getDuracion).reversed())
                .limit(1)
                .map(Curso::getTitulo)
                .toList()
                .forEach(System.out::println);

        System.out.println("\n***Lista de Strings con todos los titulos de los cursos***\n");
        cursos.stream()
                .map(Curso::getTitulo)
                .toList()
                .forEach(System.out::println);
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
