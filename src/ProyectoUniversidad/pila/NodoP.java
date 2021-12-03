package ProyectoUniversidad.pila;

import ProyectoUniversidad.Materia;


public class NodoP {
    private Materia dato;
    private NodoP next;

    public NodoP(Materia obj) {
        this.dato = obj;
        this.next = null;
    }

    public Materia getDato() {
        return dato;
    }

    public void setDato(Materia dato) {
        this.dato = dato;
    }
    
    public NodoP getNext() {
        return next;
    }

    public void setNext(NodoP abajo) {
        this.next = abajo;
    }
}