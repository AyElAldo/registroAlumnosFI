//package main;
import java.io.RandomAccessFile; // 
import java.util.Random; // Numeros aleatorios
import java.io.IOException; // Excepciones

/**
 * Clase que se encarga de generar alumnos con datos aleatorios. (Se llenan aleatoriamente casi todos los atributos del alumno).
 * Ademas, se llaman funciones y metodos para el calculo de semestre, calificaciones, promedio, etc.
 */
public class GenNombres {
    
    public static Integer generadorEdad(){
        Random random = new Random();
        // Generar edades entre 18 y 27 
        Integer edad = random.nextInt(18, 28);

        return edad;
    }


    // Genera un alumno con su nombre y apellidos
    public static Alumno generarAlumno(Integer id){
        Alumno alumno = new Alumno(id);
        alumno.setNumeroCuenta(); // Genera un numero de cuenta

        String rutaArchivo; // Ruta de los archivos de texto
        String linea = ""; // Almacena la linea del archivo

        // Se intancia RANDOM
        Random random = new Random();
        
        /* Genera hombre o mujer */
        int numAleatorio = random.nextInt(2); // Determina si es hombre o mujer

        // 0 : Hombre      1 : Mujer
        if (numAleatorio == 0){
            //System.out.println("Es hombre");
            rutaArchivo = "src/nombreH.txt";
        }else{
            //System.out.println("Es mujer");
            rutaArchivo = "src/nombreM.txt";
        }

        
        /* Genera el nombre del alumno */ 
        numAleatorio = random.nextInt(50) + 1; // Genera numero aleatorio del 1 al 50
        
        // Captura la linea que se encuentra en el renglon(numAleatorio)
        try(RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")){
            for (int i = 1; i <= numAleatorio; i++) {
                linea = archivo.readLine();
            }
            // Le asigna el nombre obtenido al alumno
            alumno.setNombre(linea);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        /* Genera los apellidos del alumno */
        rutaArchivo = "src/apellidos.txt";
        
        // Primer apellido
        numAleatorio = random.nextInt(50) + 1; // Genera numero aleatorio del 1 al 50
        
        try(RandomAccessFile archivo = new RandomAccessFile(rutaArchivo, "rw")){
            // Captura el apellido en la linea numAleatorio
            for (int i = 1; i <= numAleatorio; i++) {
                linea = archivo.readLine();
            }
            // Asigna el primer apellido al alumno
            alumno.setApellidoP(linea);
            
            // Segundo apellido
            archivo.seek(0); // Posiciona el cursor al inicio del archivo
            numAleatorio = random.nextInt(50) + 1; // Genera numero aleatorio del 1 al 50
            
            for (int i = 1; i <= numAleatorio; i++) {
                linea = archivo.readLine();
            }
            // Asigna el segundo apellido al alumno
            alumno.setApellidoM(linea);

        }catch(IOException e){
            e.printStackTrace();
        }

        /* Se asigna edad */
        alumno.setEdad(generadorEdad());
        alumno.setSemestre();
        
        return alumno;
        
    }

}
