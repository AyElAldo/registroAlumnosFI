import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public static void ordenarPorNumInscripcion(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion).reversed();
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    
    public static void ordenarPorNumInscripcion2(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion);
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    

    
    
}
