// package main;

public class Alumno {
    /* Atributos */
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Integer edad;
    private String direccion;
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

}
