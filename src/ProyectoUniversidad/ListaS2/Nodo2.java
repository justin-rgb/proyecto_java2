package ProyectoUniversidad.ListaS2;

import ProyectoUniversidad.Materia;

public class Nodo2 {

    private Materia dato; //donde se almacenar� la info de la persona
    private Nodo2 next; //la referecia al siguiente objeto de tipo Nodo1 que contiene una persona

    @Override
    public String toString() {
        return "Nodo [dato=" + dato + "]";
    }

    public Nodo2(Materia dato) {// El constructor s�lo recibe persona, n se requiere next...
        this.dato = dato;
    }

    public Materia getDato() {
        return dato;
    }

    public void setDato(Materia dato) {
        this.dato = dato;
    }

    public Nodo2 getNext() {
        return next;
    }

    public void setNext(Nodo2 next) {
        this.next = next;
    }

}
