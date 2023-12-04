// package main;

// import java.util.Random;
// import java.io.FileReader;

public class Prueba {

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            
            Alumno alumno = GenNombres.generarAlumno();
            // System.out.print(' '+alumno.getNombre()+' ');
            // System.out.print(alumno.getApellidoP()+' ');
            // System.out.print(alumno.getApellidoM()+' ');
            // System.out.print(alumno.getSemestre().toString()+' ');
            // System.out.print(alumno.getNumeroCuenta()+' ');
            // System.out.println(alumno.getEdad());
            // System.out.println(alumno.getHistorial());
            // System.out.println();

            System.out.println(alumno);
        }

    } 

}
