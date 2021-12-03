package ProyectoUniversidad.pila;

import ProyectoUniversidad.Materia;
import ProyectoUniversidad.pila.NodoP;

public class Pila {
    private NodoP top;
    
    public void push(NodoP ElementoNuevo){
        ElementoNuevo.setNext(top);
        top = ElementoNuevo;
    }

    public NodoP getTop() {
        return top;
    }
    
    public Materia pop(){
        NodoP aux = top;
        if(isEmpty()){
            System.out.println("No hay elementos en la pila");
        }else{
            top = top.getNext();
            aux.setNext(null);
        }
        
        return aux.getDato();
    }
    
    public Materia get(int index) {
        int i = 0;
        Materia p = null;
        NodoP aux = top;
        
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
    
    public boolean isEmpty(){
        if(top == null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean existe(String id) {
        boolean esta = false;
	
        NodoP aux = top;
        
        while (aux != null) {
            if (id.equals(aux.getDato().getId())) {
                esta = true;
            }
            aux = aux.getNext();
        }
        return esta;
    }
    
    public int size(){
        int size = 0;
        
        NodoP aux = top;
        
        while (aux != null) {
            size++;
            aux = aux.getNext();
        }

        return size; 
    }
}
