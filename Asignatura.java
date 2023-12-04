public class Asignatura{
    
    private String nombre; // Nombre de la asignatura
    private float creditos; // Creditos de la asignatura
    private Integer semestre; // Semestre al que pertenece la materia

    /* Constructor */
    public Asignatura(String nombre, float creditos, Integer semestre){
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }
    /* Getters and Setters */
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public float getCreditos() {
        return this.creditos;
    }
    
    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }
    
    public Integer getSemestre() {
        return this.semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

}
