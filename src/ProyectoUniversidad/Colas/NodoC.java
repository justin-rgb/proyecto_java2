package ProyectoUniversidad.Colas;

import ProyectoUniversidad.Estudiante;

public class NodoC {
    private Estudiante dato;
    private NodoC next;

    public NodoC(Estudiante valor) {
        this.dato = valor;
        this.next = null;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public NodoC getNext() {
        return next;
    }

    public void setNext(NodoC next) {
        this.next = next;
    }   
    
}
