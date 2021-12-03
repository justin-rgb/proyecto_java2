package ProyectoUniversidad;


public class Materia {
   private static final int MAXIMO_ALUMNOS = 5;
   
   private String id;
   private String nombre;
   private String profesor;
   private int aula;
   private String dia;
   private int cantidad;
   private String horarioInicio;
   private String horarioFin;
   private double costo;

    public Materia() {
        this.id = "";
        this.nombre = "";
        this.profesor = "";
        this.aula = -1;
        this.dia = "";
        this.cantidad = 0;
        this.horarioInicio = "";
        this.horarioFin = "";
        this.costo = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    public void incrementarAlumnado(){
        cantidad++;
    }
    
    public boolean estaLleno(){
        return getCantidad() == MAXIMO_ALUMNOS;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    @Override
    public String toString() {
        return String.format("%s :\n"
                + "\tCOD : %s\n"
                + "\tPROFESOR : %s\n"
                + "\tAULA : %d\n"
                + "\tDIA : %s\n"
                + "\tHORARIO : %s A %s\n"
                + "\tCantidad : %d / %d\n"
                + "\tCosto : c%.2f .\n", getNombre(), getId(), getProfesor(), getAula(),
                getDia(), getHorarioInicio(), getHorarioFin(), getCantidad(), MAXIMO_ALUMNOS, getCosto());
    }
    
   
}
