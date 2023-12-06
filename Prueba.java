// package main;

// import java.util.Random;
// import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prueba {

    public static void main(String[] args){
        List<Alumno> alumnos = new ArrayList<Alumno>();
        mostrarMenu(alumnos);

    } 

    public static void mostrarMenu(List<Alumno> alumnos){
        int opcionMenu;

        Scanner scanner = new Scanner(System.in);
        do{
            /* Limpia pantalla y despliega menu */
            limpiaPantalla();
            System.out.println("-----------------------------------------");
            System.out.println("|\t\tBIENVENIDO\t\t|");
            System.out.println("-----------------------------------------");
            System.out.println("1. Generar registro de alumnos aleatorios");
            System.out.println("2. Dar de baja alumno");
            System.out.println("3. Buscar Alumno");
            System.out.println("4. Imprimir lista alumnos");
            System.out.println("5. Generar numeros de inscripcion");
            System.out.println("6. Exportar a CSV");
            System.out.println("-----------------------------------------");
            System.out.println("0. Salir del programa");
            System.out.println("-----------------------------------------");
            System.out.print("Elige la opcion deseada: ");
            
            opcionMenu = scanner.nextInt(); // Guarda la opcion
            System.out.println("-----------------------------------------");

            /* Switch */
            switch(opcionMenu){
                case 0:
                    System.out.println("Saliendo del programa.");
                    pausaPantalla();
                    break;

                case 1:
                    int numAlumnos = 0;
                    limpiaPantalla();
                    System.out.print("Escribe el numero de alumnos a generar (MAX 1000): ");
                    numAlumnos = scanner.nextInt();
                    
                    for(int i = 1; i <= numAlumnos; i++){
                        alumnos.add(GenNombres.generarAlumno(i));
                        System.out.println(alumnos.get(i-1));
                    }
                    pausaPantalla();
                    break;

                case 2:
                    String numeroCuentaEliminar;
                    scanner.nextLine(); // Limpia buffer
                    limpiaPantalla();
                    System.out.print("Escribe el numero de cuenta del alumno a eliminar: ");
                    numeroCuentaEliminar = scanner.nextLine();
                    for(int i = 0; i < alumnos.size(); i++){
                        if(numeroCuentaEliminar.equals(alumnos.get(i).getNumeroCuenta())){
                            alumnos.remove(i);
                        }
                    }
                    pausaPantalla();
                    break;

                case 3:
                    String numeroCuentaBuscar;
                    scanner.nextLine(); // Limpia buffer
                    limpiaPantalla();
                    System.out.print("Escribe el numero de cuenta del alumno a buscar: ");
                    numeroCuentaBuscar = scanner.nextLine();
                    for(int i = 0; i < alumnos.size(); i++){
                        if(numeroCuentaBuscar.equals(alumnos.get(i).getNumeroCuenta())){
                            System.out.println(alumnos.get(i));
                        }
                    }
                    pausaPantalla();
                    break;

                case 4:
                    limpiaPantalla();
                    System.out.println("Imprimiendo alumnos...");
                    for(int i = 0; i < alumnos.size(); i++){
                        System.out.println(alumnos.get(i));
                    }
                    pausaPantalla();
                    break;
                    
                case 5:
                    limpiaPantalla();
                    System.out.println("Ordenando por numero de inscripcion...");
                    GenNumInscripcion.ordenarPorNumInscripcion(alumnos);
                    for(int i = 0; i < alumnos.size(); i++){
                        alumnos.get(i).setNumeroInscripcion(String.format("%04d", i+1));
                    }
                    for(int i = 0; i < alumnos.size(); i++){
                        System.out.println(alumnos.get(i));
                    }
                    pausaPantalla();
                    break;
            }
        }while(opcionMenu != 0);

        scanner.close();
    }

    /**  Simula pausar la pantalla */
    public static void pausaPantalla(){
        System.out.println("Presiona Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Simula limpiar la pantalla */
    public static void limpiaPantalla(){
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
    }

}
