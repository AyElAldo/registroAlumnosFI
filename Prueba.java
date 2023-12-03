// package main;

// import java.util.Random;
// import java.io.FileReader;

public class Prueba {

    public static void main(String[] args){
        for (int i = 0; i < 50; i++) {
            System.out.print(i+1);
            Alumno alumno = GenNombres.generarAlumno();
            System.out.print(' '+alumno.getNombre()+' ');
            System.out.print(alumno.getApellidoP()+' ');
            System.out.print(alumno.getApellidoM()+' ');
            System.out.println(alumno.getEdad());
        }

    } 

}
