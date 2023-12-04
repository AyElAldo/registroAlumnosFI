import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.RandomAccessFile; // 
import java.util.Random; // Numeros aleatorios

public class RegistroAcadem {
    
    Integer creditosTotales;
    Integer numAsignaturasCursadas;
    List<Asignatura> asignaturasCursadas = new ArrayList<Asignatura>();
    List<Integer> listaCalificaciones = new ArrayList<Integer>();

    /**
     *  Constructor
     * @param semestre Semestre del alumno para asignar aleatoriamente las asignaturas ya cursadas
    */
    RegistroAcadem(Integer semestre){
        this.creditosTotales = 0;
        this.numAsignaturasCursadas = 0;
        String rutaAsignaturas = "src/asignaturas.txt";
        String linea = "";
        String[] datosAsignaturas;

        try(RandomAccessFile archivo = new RandomAccessFile(rutaAsignaturas, "rw")){
            for(int i = 1; i < 51; i++){
                
                linea = archivo.readLine(); // Lee la linea actual y la almacena en linea
                datosAsignaturas = linea.split(","); // Separa cada linea (asignatura. creditos, semestre)

                Integer creditosAsignatura = Integer.parseInt(datosAsignaturas[1]); // Convierte a entero las subcadenas
                // System.out.println("Creditos: " + creditosAsignatura);
                Integer semestreAsignatura = Integer.parseInt(datosAsignaturas[2]); // Convierte a entero las subcadenas

                Integer topeSemestre = semestre+1; 
                
                // El ciclo recorre el txt hasta el semestre indicado
                if(semestreAsignatura != topeSemestre){
                    this.creditosTotales += creditosAsignatura; 
                    this.numAsignaturasCursadas++;
                    
                    /* Crea la asignatura */
                    // Asignatura asignatura = new Asignatura(datosAsignaturas[0],datosAsignaturas[1].toString(),datosAsignaturas[2].toString());
                    Asignatura asignatura = new Asignatura();
                    asignatura.setNombre(datosAsignaturas[0]);
                    asignatura.setCreditos(creditosAsignatura);
                    asignatura.setSemestre(semestreAsignatura);
                    this.asignaturasCursadas.add(asignatura); // Se agrega a las ya cursadas

                    Random random = new Random();
                    this.listaCalificaciones.add(random.nextInt(5)+6);
                }else {
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    /**
     * To String
     */
    @Override
    public String toString(){
        String cadena = "";
        for(int i = 0; i < this.numAsignaturasCursadas; i++){
            cadena += this.asignaturasCursadas.get(i).getNombre() + ": " + this.listaCalificaciones.get(i).toString() + "\n";
        }
        // for(Asignatura asignatura : this.asignaturasCursadas){
        //     cadena += asignatura.getNombre() + ": " + listaCalificaciones.get(0)
        // }
        cadena += "\n";
        return cadena;
    }

}
