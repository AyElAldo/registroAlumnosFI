public class Asignatura{
    
    private String nombre; // Nombre de la asignatura
    private float calificacion; // Calificacion de la asignatura
    private Integer semestre; // Semestre al que pertenece la materia

    /* Constructor */
    public Asignatura(String nombre, float calificacion, Integer semestre){
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.semestre = semestre;
    }
    /* Getters and Setters */
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public float getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    
    public Integer getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

}
