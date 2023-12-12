import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Contiene los metodos necesarios para el calculo del indicador y numero de inscripcion de cada alumno.
 */
public class GenNumInscripcion {
    public String generarIndicador(Double promedio){

        Double escolaridad;
        Double velocidad;
        Double indicador;
        String indicadorEscolar = "";

        escolaridad = Double.valueOf(100);
        // System.out.println("Escolareidad: "+escolaridad);
        velocidad = Double.valueOf(100);
        // System.out.println("Velocidad: "+velocidad);
        indicador = Double.valueOf(promedio*escolaridad*velocidad);

        indicadorEscolar = indicador.toString();
        // System.out.println("Indicador escolar: "+indicador);
        return indicadorEscolar;
    }

    /**
     * Se aplica la primera vez que ordena los numero de inscripcion
     * @param alumnos Lista de alumnos a ordenar
     */
    public static void ordenarPorNumInscripcion(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion).reversed();
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    
    /**
     * Se aplica cuando ya han sido ordenados los numeros de inscripcion al menos una vez
     * @param alumnos Lista de alumnos a ordenar
     */
    public static void ordenarPorNumInscripcion2(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion);
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    
    /**
     * Ordena la lista de alumnos de acuerdo a su promedio.
     * @param alumnos Lista de alumnos
     */
    public static void ordenarPorPromedio(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorPromedio = Comparator.comparing(Alumno::getPromedio);
        Collections.sort(alumnos, comparadorPorPromedio);
    }

    
    
}
