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

    /* Constructores */
    // Constructor con parametros
    public Alumno(String nombre, String apellidoP, String apellidoM, Integer edad, String direccion){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.direccion = direccion;
    }
    // Constructor vacio
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

    // Metodo para calcular el semestre a partir de la edad
    public Integer calcularSemestre(){
        Random random = new Random();
        Integer semestre = 1;
        if(this.edad == 18){
            semestre = random.nextInt(2)+1;
        }else if(this.edad == 19){
            semestre = random.nextInt(4)+2;
        }else if(this.edad == 20){
            semestre = random.nextInt(6)+3;
        }else if(this.edad == 21){
            semestre = random.nextInt(8)+4;
        }else{
            semestre = random.nextInt(10)+5;
        }

        return semestre;
    }

}
