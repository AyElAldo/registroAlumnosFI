public class GenNumInscripcion {
    public static String generarNumeroInscripcion(Double promedio){

        Double escolaridad;
        Double velocidad;
        Double indicador;
        String indicadorEscolar = "";

        escolaridad = Double.valueOf(100);
        velocidad = Double.valueOf(100);
        indicador = promedio*escolaridad*velocidad;

        indicadorEscolar = indicadorEscolar.toString();
        return indicadorEscolar;
    }

    
    
}
