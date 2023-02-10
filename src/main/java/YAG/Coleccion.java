package YAG;
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

        long duracion_cinco = cursos.stream().filter(c->c.getDuracion()>5).count();
        System.out.println("Cantidad de cursos con una duración mayor a 5 horas: "+duracion_cinco);

        long duracion_dos = cursos.stream().filter(c->c.getDuracion()<2).count();
        System.out.println("Cantudad de cursos con una duración menor a 2 horas: "+duracion_dos);

        List<String> titulos = cursos.stream().filter(c->c.getVideos()>50).map(c->c.getTitulo()).collect(Collectors.toList());
        System.out.println("Títulos de cursos con cantidad de videos mayor a 50: "+titulos);

        List<String> tres_mayores = cursos.stream().sorted(Comparator.comparing(Curso::getDuracion).reversed()).limit(3).map(c->c.getTitulo()).collect(Collectors.toList());
        System.out.println("Los tres cursos de mayor duración son: "+tres_mayores);

        double duracion_total = cursos.stream().mapToDouble(c->c.getDuracion()).sum();
        System.out.println("Duración total de todos los cursos: "+duracion_total);

        double duracion_prom = (duracion_total/(cursos.stream().count()));
        System.out.println("La duración promedio de los cursos es: "+duracion_prom);

        List<String> mayores_promedio = cursos.stream().filter(c->c.getDuracion()>duracion_prom).map(c->c.getTitulo()).collect(Collectors.toList());
        System.out.println("Títulos de cursos con duración mayor a la promedio: "+mayores_promedio);

        List<Float> alumnos_menoresa = cursos.stream().filter(c->c.getAlumnos()<500).map(c->c.getDuracion()).collect(Collectors.toList());
        System.out.println("Duración de cursos con menos alumnos que 500: "+alumnos_menoresa);

        double duracion_max = cursos.stream().mapToDouble(Curso::getDuracion).max().getAsDouble();
        List<String> curso_max = cursos.stream().filter(c->c.getDuracion()==duracion_max).map(c->c.getTitulo()).collect(Collectors.toList());
        System.out.println("El curso de mayor duración es: "+curso_max);

        List<String> todos = cursos.stream().map(c->c.getTitulo()).collect(Collectors.toList());
        System.out.println("Títulos de todos los cursos: "+todos);
    }

    /*
     * Resolver los siguientes problemas con streams:
     * Obtener la cantidad de cursos con una duración mayor a 5 horas.
     * Obtener la cantidad de cursos con una duración menor a 2 horas.
     * Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
     * Mostrar en consola el título de los 3 cursos con mayor duración.
     * Mostrar en consola la duración total de todos los cursos.
     * Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
     * Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
     * Obtener el curso con mayor duración.
     * Crear una lista de Strings con todos los titulos de los cursos.
     *
     * Una vez terminado subirlo al repositorio
     */
}