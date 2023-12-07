import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<Alumno>(); // Guarda todos los alumnos
        int opcionMenu;
        int opcionSubmenus;
        int opcionSubmenus2;

        Scanner scanner = new Scanner(System.in);
        limpiaPantalla();
        System.out.println("Generando alumnos. Espere un momento...");
        System.out.println("Ordenando por numero de inscripcion...");
        System.out.println("Escribiendo a CSV...");
        for(int i = 1; i <= 1000; i++){
            alumnos.add(GenNombres.generarAlumno(i));
        }
        ordenarPorNumInscripcion(alumnos);
        escribirCSV(alumnos); // Desde que inicia el programa, guarda el CSV
        do{
            
            limpiaPantalla();
            System.out.println("-----------------------------------------");
            System.out.println("|\tBIENVENIDO A LA BASE DE DATOS\t|");
            System.out.println("-----------------------------------------");
            

            System.out.println("1. Edicion de datos");
            System.out.println("2. Guardar datos");
            System.out.println("3. Salir");
            System.out.print("Escribe la opcion: ");
            opcionMenu = scanner.nextInt();

            switch(opcionMenu){
                /** Caso de edicion de datos */
                case 1: 
                    do{
                        opcionSubmenus = 0;
                        limpiaPantalla();
                        System.out.println("-----------------------------------------");
                        System.out.println("1. Alumno");
                        System.out.println("2. Regresar");
                        System.out.println("-----------------------------------------");
                        System.out.print("Selecciona la opcion: ");
                        opcionSubmenus = scanner.nextInt();
                        if(opcionSubmenus == 1){
                            opcionSubmenus2 = 0;
                            limpiaPantalla();
                            System.out.println("-----------------------------------------");
                            System.out.println("1. Buscar alumno");
                            System.out.println("2. Editar datos del alumno");
                            System.out.println("3. Regresar");
                            System.out.println("-----------------------------------------");
                            System.out.print("Selecciona la opcion: ");
                            opcionSubmenus2 = scanner.nextInt();

                            if(opcionSubmenus2 == 1){
                                /** Buscar alumno */
                                String numeroCuentaBuscar;
                                int encontrado = 0;
                                scanner.nextLine(); // Limpia buffer
                                limpiaPantalla();
                                System.out.print("Escribe el numero de cuenta del alumno a buscar: ");
                                numeroCuentaBuscar = scanner.nextLine();
                                for(int i = 0; i < alumnos.size(); i++){
                                    if(numeroCuentaBuscar.equals(alumnos.get(i).getNumeroCuenta())){
                                        System.out.println(alumnos.get(i));
                                        encontrado = 1;
                                        break;
                                    }
                                }
                                if(encontrado == 0) System.out.println("No se ha encontrado.");
                                pausaPantalla();
                            }else if(opcionSubmenus2 == 2){
                                /** Editar datos del alumno */
                                String numeroCuentaEditar;
                                int indice_editar = 0;
                                scanner.nextLine(); // Limpia buffer
                                limpiaPantalla();
                                System.out.println("-----------------------------------------");
                                System.out.print("Escribe el numero de cuenta del alumno a editar: ");
                                numeroCuentaEditar = scanner.nextLine();
                                System.out.println("-----------------------------------------");
                                
                                for(int i = 0; i < alumnos.size(); i++){
                                    if(numeroCuentaEditar.equals(alumnos.get(i).getNumeroCuenta())){
                                        System.out.println(alumnos.get(i));
                                        indice_editar = i;
                                        break;
                                    }
                                }

                                int opcionEditar;
                                System.out.println("-----------------------------------------");
                                System.out.println("Que quieres editar del alumno?");
                                System.out.println("1. Nombre");
                                System.out.println("2. Edad");
                                System.out.println("3. Direccion");
                                System.out.println("-----------------------------------------");
                                opcionEditar = scanner.nextInt();

                                /* Casos para editar */
                                if(opcionEditar == 1){
                                    /** Editar nombre */
                                    String nuevo_nombre;
                                    scanner.nextLine(); // Limpia Buffer
                                    System.out.print("Escribe el nuevo nombre: ");
                                    nuevo_nombre = scanner.nextLine();
                                    alumnos.get(indice_editar).setNombre(nuevo_nombre); // Se asigna nuevo nombre
                                }else if(opcionEditar == 2){
                                    /** Editar edad */
                                    Integer nueva_edad;
                                    System.out.print("Escribe la nueva edad: ");
                                    nueva_edad = scanner.nextInt();
                                    alumnos.get(indice_editar).setEdad(nueva_edad); // Se asigna nueva edad
                                }else if(opcionEditar==3){
                                    String nueva_direccion;
                                    scanner.nextLine(); // Limpia Buffer
                                    System.out.print("Escribe la nueva direccion: ");
                                    nueva_direccion = scanner.nextLine();
                                    alumnos.get(indice_editar).setDireccionManual(nueva_direccion);// Se asigna nueva direccion
                                }else{
                                    System.out.println("Opcion no valida.");
                                }
                                limpiaPantalla();
                                System.out.println("\t\tNuevos Datos");
                                System.out.println("-----------------------------------------");
                                System.out.println(alumnos.get(indice_editar));
                                System.out.println("-----------------------------------------");
                                pausaPantalla();

                            }else if(opcionSubmenus2 == 3){} // Regresa
                            else {
                                System.out.println("Opcion invalida.");
                            }

                        }else if(opcionSubmenus == 2){}
                        else{
                            System.out.println("Opcion invalida.");
                        };
                    }while(opcionSubmenus != 2);
                    break;
                case 2:
                    do{
                        opcionSubmenus = 0;
                        limpiaPantalla();
                        System.out.println("-----------------------------------------");
                        System.out.println("1. Guardar datos");
                        System.out.println("2. Eliminar datos (elimina a un alumno)");
                        System.out.println("3. Regresar");
                        System.out.println("-----------------------------------------");
                        System.out.print("Selecciona la opcion: ");
                        opcionSubmenus = scanner.nextInt();
                        if(opcionSubmenus == 1){
                            /** Guardar datos en CSV */
                            escribirCSV(alumnos);
                            System.out.println("Se ha exportado correctamente al CSV");

                        }else if(opcionSubmenus == 2){
                            /* Elimina a un alumno */
                            String numeroCuentaEliminar;
                            int eliminado = 0;
                            scanner.nextLine(); // Limpia buffer
                            limpiaPantalla();
                            System.out.print("Escribe el numero de cuenta del alumno a eliminar: ");
                            numeroCuentaEliminar = scanner.nextLine();
                            for(int i = 0; i < alumnos.size(); i++){
                                if(numeroCuentaEliminar.equals(alumnos.get(i).getNumeroCuenta())){
                                    alumnos.remove(i);
                                    eliminado = 1;
                                }
                            }
                            if(eliminado != 1){
                                System.out.println("No se ha encontrado el alumno.");
                            }else{
                                ordenarPorNumInscripcion2(alumnos);
                                System.out.println("Alumno eliminado. Recuerda guardas tus cambios.");
                            }
                            pausaPantalla();
                        }else if(opcionSubmenus == 3){} // Regresa
                        else {
                            System.out.println("Opcion invalida.");
                        }
                    }while(opcionSubmenus != 3);
                    break;
                case 3:
                        
                    opcionSubmenus = 0;
                    limpiaPantalla();
                    System.out.println("-----------------------------------------");
                    System.out.println("\t\tSALIR\t\t");
                    System.out.println("-----------------------------------------");
                    System.out.println("Guardo los datos antes de salir?");
                    System.out.println("1. SI");
                    System.out.println("2. NO");
                    System.out.print("Selecciona la opcion: ");
                    opcionSubmenus = scanner.nextInt();
                    if(opcionSubmenus == 1){
                        System.out.println("-----------------------------------------");
                        System.out.println("Saliendo del programa...");
                        System.out.println("-----------------------------------------");
                        break;
                    }else if(opcionSubmenus == 2){
                        opcionMenu = 0; // Para evitar salir
                    }
                    else{
                        System.out.println("Opcion invalida.");
                    };
                    break;
                    
            }

        }while(opcionMenu!=3);

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

    /**
     * Genera el numero de inscripcion y Ordena los alumnos por numero de inscripcion.
     * @param alumnos Lista de alumnos
     */
    public static void ordenarPorNumInscripcion(List<Alumno> alumnos){
        GenNumInscripcion.ordenarPorNumInscripcion(alumnos);
        for(int i = 0; i < alumnos.size(); i++){
            alumnos.get(i).setNumeroInscripcion(String.format("%04d", i+1));
        }
    }
    
    public static void ordenarPorNumInscripcion2(List<Alumno> alumnos){
        GenNumInscripcion.ordenarPorNumInscripcion2(alumnos);
        for(int i = 0; i < alumnos.size(); i++){
            alumnos.get(i).setNumeroInscripcion(String.format("%04d", i+1));
        }
    }

    /** Exporta los datos a CSV
     * @param alumnos Lista de alumnos
     */
    public static void escribirCSV(List<Alumno> alumnos){
        String ruta = "output/datos.csv";

        try(RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")){
            archivo.setLength(0);
            String columnas = "No Inscripcion,NoCuenta,Nombre,Apellido Paterno,Apellido Materno,Edad,Semestre,Promedio,Direccion";
            archivo.writeBytes(columnas + System.lineSeparator());
            
            for(int i = 0; i < alumnos.size(); i++){
                String cadena = "";
                cadena += alumnos.get(i).getNumeroInscripcion();
                cadena += ",";
                cadena += alumnos.get(i).getNumeroCuenta();
                cadena += ",";
                cadena += alumnos.get(i).getNombre();
                cadena += ",";
                cadena += alumnos.get(i).getApellidoP();
                cadena += ",";
                cadena += alumnos.get(i).getApellidoM();
                cadena += ",";
                cadena += alumnos.get(i).getEdad().toString();
                cadena += ",";
                cadena += alumnos.get(i).getSemestre().toString();
                cadena += ",";
                DecimalFormat df = new DecimalFormat("#.##");
                String resultado = df.format(alumnos.get(i).getHistorial().promedio);
                cadena += resultado.toString();
                cadena += ",";
                cadena += alumnos.get(i).getDireccion();
                archivo.writeBytes(cadena + System.lineSeparator());
            }
            archivo.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
