/**
 * Representa una asignatura que puede ser tomada por un alumno. 
 * Se consiseran los datos escenciales para la implementacion de despliegue de informacion.
 */
public class Asignatura{
    
    private String nombre; // Nombre de la asignatura
    private Integer creditos; // Creditos de la asignatura
    private Integer semestre; // Semestre al que pertenece la materia

    /* Constructor */
    public Asignatura(String nombre, Integer creditos, Integer semestre){
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }
    public Asignatura(){};
    /* Getters and Setters */
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getCreditos() {
        return this.creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    public Integer getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

}
