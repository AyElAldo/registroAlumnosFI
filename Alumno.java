// package main;

import java.util.Random;

public class Alumno {
    /* Atributos */
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Integer edad;
    private String direccion;
    private Integer semestre;
    private Integer numeroInscripcion;
    private RegistroAcadem historial;

    
    /**
     * Constructor con parametros
     * @param nombre Nombre del Alumno
     * @param apelldioP Apellido Paterno del alumno
     * @param apellidoM Apellido Materno del alumno
     * @param edad Edad del alumno
     * @param direccion Direccion del alumno
     */
    public Alumno(String nombre, String apellidoP, String apellidoM, Integer edad, String direccion){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.direccion = direccion;
    }
    /** Constructor vacio */ 
    public Alumno(){};

    /* Getters and Setters */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return this.apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return this.apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Integer getEdad() {
        return this.edad;
    }

    /**
     * Determina la edad y le asocia un semestre que concuerde con su edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
        this.semestre = calcularSemestre();
        // System.out.println("Edad: "+ this.edad+ " Semestre: " + this.semestre);
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroInscripcion(){
        return this.numeroInscripcion;
    }

    public Integer getSemestre(){
        return this.semestre;
    }

    public RegistroAcadem getHistorial(){
        return this.historial;
    }

    /**
     * Metodo para calcular el semestre a partir de la edad.
     * Ademas se crea el registro de cada alumno a partir del semestre
     * @return Retorna el semestre aleatorio
     */
    public Integer calcularSemestre(){
        Random random = new Random();
        Integer semestre = 1;
        if(this.edad == 18){
            semestre = random.nextInt(2)+1; // Genera numero [1,2]
        }else if(this.edad == 19){
            semestre = random.nextInt(4)+1; // Genera numero [1,4]
        }else if(this.edad == 20){
            semestre = random.nextInt(4)+3; // Genera numero [3,6]
        }else if(this.edad == 21){
            semestre = random.nextInt(4)+5; // Genera numero [5,8]
        }else{
            semestre = random.nextInt(4)+7; // Genera numero [6,10]
        }

        this.historial = new RegistroAcadem(semestre);

        return semestre;
    }
}
