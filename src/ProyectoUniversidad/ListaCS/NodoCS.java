
package ProyectoUniversidad.ListaCS;

import ProyectoUniversidad.Materia;

public class NodoCS {

    private Materia dato; //donde se almacena la info de la persona
    private NodoCS next; //la referecia al siguiente objeto de tipo Nodo que contiene una persona

    public NodoCS(Materia dato) {// El constructor s�lo recibe persona, n se requiere next...
        this.dato = dato;
        this.next = null;
    }

    public Materia getDato() {
        return dato;
    }

    public void setDato(Materia dato) {
        this.dato = dato;
    }

    public NodoCS getNext() {
        return next;
    }

    public void setNext(NodoCS next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Nodo [dato=" + dato + "]";
    }

}

