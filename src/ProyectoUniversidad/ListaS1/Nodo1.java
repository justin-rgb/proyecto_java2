package ProyectoUniversidad.ListaS1;

import ProyectoUniversidad.Estudiante;

public class Nodo1 {

    private Estudiante dato; //donde se almacenar� la info de la persona
    private Nodo1 next; //la referecia al siguiente objeto de tipo Nodo1 que contiene una persona

    @Override
    public String toString() {
        return "Nodo [dato=" + dato + "]";
    }

    public Nodo1(Estudiante dato) {// El constructor s�lo recibe persona, n se requiere next...
        this.dato = dato;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public Nodo1 getNext() {
        return next;
    }

    public void setNext(Nodo1 next) {
        this.next = next;
    }

}
