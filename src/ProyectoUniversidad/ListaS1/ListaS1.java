package ProyectoUniversidad.ListaS1;

import ProyectoUniversidad.Estudiante;
import ProyectoUniversidad.ListaS2.Nodo2;
import ProyectoUniversidad.Materia;

public class ListaS1 {
    private Nodo1 cabeza;

    public void agregar(Estudiante p) {
        if (cabeza == null) { //si la lista está vacía solo asignar y listo
            cabeza = new Nodo1(p);
        } else {
            Nodo1 aux = cabeza;//defino aux como cabeza (uso aux como especie 
            //Mientras no se acabe la lista y el dato del siguiente sea menor 
            //que el dato que voy a insertar... avance en la lista
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            
            aux.setNext(new Nodo1(p));//enlazo el siguiente de aux como temp
        }
    }

    public int size(){
        int size = 0;
        
        Nodo1 aux = cabeza;
        
        while (aux != null) {
            size++;
            aux = aux.getNext();
        }

        return size; 
    }
    
    public boolean existe(String cedula) {
        boolean esta = false;
        //Busca en la lista y retorna true si una persona tiene el matricula 
        //en la lista		
        Nodo1 aux = cabeza;
        while (aux != null) {
            if (cedula.equals(aux.getDato().getCedula())) {
                esta = true;
                break;
            }
            aux = aux.getNext();
        }
        return esta;
    }

    public Estudiante buscar(String cedula) {
        Estudiante obj = null;
        //Busca en la lista y retorna true si una persona tiene el matricula 
        //en la lista		
        Nodo1 aux = cabeza;
        while (aux != null) {
            if (cedula.equals(aux.getDato().getCedula())) {
                obj = aux.getDato();
                break;
            }
            aux = aux.getNext();
        }
        
        return obj;
    }

    public Estudiante get(int index) {
        int i = 0;
        Estudiante p = null;
        Nodo1 aux = cabeza;
        
        while (aux != null) {
            if (i == index) {
                p = aux.getDato();
                break;
            }
            aux = aux.getNext();
            i++;
        }

        return p;
    }
    
    @Override
    public String toString() {
        Nodo1 aux = cabeza;
        String s = "Lista: ";
        while (aux != null) {
            s += aux + ", ";
            aux = aux.getNext();
        }
        return s;
    }

}
