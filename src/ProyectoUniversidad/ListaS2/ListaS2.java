package ProyectoUniversidad.ListaS2;

import ProyectoUniversidad.Materia;

public class ListaS2 {
    private Nodo2 cabeza;

    public void agregar(Materia p) {
        if (cabeza == null) { //si la lista está vacía solo asignar y listo
            cabeza = new Nodo2(p);
        } else {
            Nodo2 aux = cabeza;//defino aux como cabeza (uso aux como especie 
            //Mientras no se acabe la lista y el dato del siguiente sea menor 
            //que el dato que voy a insertar... avance en la lista
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            
            aux.setNext(new Nodo2(p));//enlazo el siguiente de aux como temp
        }
    }

    public boolean existe(String id) {
        boolean esta = false;
        //Busca en la lista y retorna true si una persona tiene el id 
        //en la lista		
        Nodo2 aux = cabeza;
        while (aux != null) {
            if (id.equals(aux.getDato().getId())) {
                esta = true;
            }
            aux = aux.getNext();
        }
        return esta;
    }
    
    public Materia buscar(String id) {
        Materia obj = null;
        //Busca en la lista y retorna true si una persona tiene el id 
        //en la lista		
        Nodo2 aux = cabeza;
        while (aux != null) {
            if (id.equals(aux.getDato().getId())) {
                obj = aux.getDato();
            }
            aux = aux.getNext();
        }
        return obj;
    }

    public void elimina(String id) {
        //Si una persona tiene el id lo elimina
        Nodo2 auxiliar = null;
        Nodo2 aux = cabeza;
        while (aux != null) {
            if (id.equals(aux.getDato().getId())) {
                if (auxiliar != null) {
                    auxiliar.setNext(aux.getNext());
                    break;
                } else {
                    cabeza = aux.getNext();
                    break;
                }

            }
            auxiliar = aux;
            aux = aux.getNext();
        }

    }

    public int size(){
        int size = 0;
        
        Nodo2 aux = cabeza;
        
        while (aux != null) {
            size++;
            aux = aux.getNext();
        }

        return size; 
    }
    
    public Materia get(int index) {
        int i = 0;
        Materia p = null;
        Nodo2 aux = cabeza;
        
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
}
