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

    
    
}
