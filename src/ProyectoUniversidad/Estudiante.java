
package ProyectoUniversidad;

import ProyectoUniversidad.ListaCS.ListaCS;
import ProyectoUniversidad.pila.NodoP;
import ProyectoUniversidad.pila.Pila;


public class Estudiante {
    private int matricula;
    private String nombre;
    private String apellido;
    private String cedula;
    private String tel;
    private String genero;
    private String residencia;
    private Pila materias;
    private ListaCS congeladas;

    public Estudiante() {
        this.matricula = -1;
        this.nombre = "";
        this.apellido = "";
        this.cedula = "";
        this.tel = "";
        this.genero = "";
        this.residencia = "";
        this.materias = new Pila();
        this.congeladas = new ListaCS();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public Pila getMaterias() {
        return materias;
    }

    public void setMaterias(Pila materias) {
        this.materias = materias;
    }

    public ListaCS getCongeladas() {
        return congeladas;
    }

    public void setCongeladas(ListaCS congeladas) {
        this.congeladas = congeladas;
    }
    
    public void mostrarMateriasActivas(){
        final int DIAS = 5;
        
        for (int i = 0; i < materias.size(); i++){
            Materia obj = materias.get(i);
            
            System.out.println(obj);
        }
    }
    
    public void mostrarMateriasCongeladas(){
     
        for (int i = 0; i < congeladas.size(); i++){
            Materia obj = congeladas.get(i);
            
            System.out.println(obj);
        }
    }

    @Override
    public String toString() {
        return String.format("\tMATRICULA : %d\n"
                + "\tNombre y Apelido : %s, %s\n"
                + "\tCedula : %s\n"
                + "\tTelefono/celular : %s\n"
                + "\tGenero: %s\n"
                + "\tResidencia : %s\n"
                + "\tMaterias activas : %d\n"
                + "\tMaterias congeladas : %d\n", getMatricula(), getApellido().toUpperCase(), getNombre(), getCedula(), getTel(), getGenero(),
                getResidencia(), materias.size(), congeladas.size());
    } 

    public void congelarMateria(String codigo) {
        Pila pila = new Pila();
        
        while (!getMaterias().isEmpty()){
            Materia materia = getMaterias().pop();
            
            if (!materia.getId().equals(codigo)){
                pila.push(new NodoP(materia));
            } else{
                congeladas.inserta(materia);
            }
        }
        
        this.setMaterias(pila);
    }
}
