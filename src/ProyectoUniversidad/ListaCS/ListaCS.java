
package ProyectoUniversidad.ListaCS;

import ProyectoUniversidad.Materia;

public class ListaCS {

    private NodoCS cabeza;
    private NodoCS ultimo;

    public void inserta(Materia p) {
        if (cabeza == null) { //si la lista está vacía solo asignar y listo
            cabeza = new NodoCS(p);
            ultimo = cabeza;
            ultimo.setNext(cabeza);
        } else {
            if (p.getId().compareTo(cabeza.getDato().getId()) > 0) {
                //2. Si lo que voy a insertar debe estar a la izq de cabeza
                NodoCS aux = new NodoCS(p);//creo al nodo auxiliar con p de parámetro
                aux.setNext(cabeza);//coloco aux a la izquierda de cabeza
                cabeza = aux; //cabeza ahora referencia al nuevo elemento 	
                ultimo.setNext(cabeza);
            } else {
                if (ultimo.getDato().getId().compareTo(p.getId()) > 0) {
                    ultimo.setNext(new NodoCS(p));
                    ultimo = ultimo.getNext();
                    ultimo.setNext(cabeza);
                } else {
                    if (cabeza.getNext() == null) {
                        //3. Si debo insertar a la derecha de cabeza y no hay nada ahi.
                        cabeza.setNext(new NodoCS(p));//referencio al next directamente 
                        //creado un Nodo con p como parámetro. 
                    } else {
                        NodoCS aux = cabeza;

                        while (aux.getNext().getDato().getId().compareTo(p.getId()) > 0) {
                            aux = aux.getNext();
                        }

                        NodoCS temp = new NodoCS(p); //creo temp para crear el nodo con p 
                        temp.setNext(aux.getNext());//Enlazo temp al siguiente de aux
                        aux.setNext(temp);//enlazo el siguiente de aux como temp
                    }
                    ultimo.setNext(cabeza);
                }
            }
        }
    }

    public Materia get(int index) {
        
        Materia p = null;

        if (size() != 0) {
            int i = 0;
            NodoCS aux = cabeza;

            do{
                if (i == index) {
                    p = aux.getDato();
                    break;
                }
                aux = aux.getNext();
                i++;
            } while (aux != cabeza) ;
        }

        return p;
    }
    
    public boolean existe(String id) {
        boolean esta = false;

        if (cabeza != null) {
            NodoCS aux = cabeza;
            boolean band = true;

            do {
                if (aux.getDato().getId().equals(id)) {
                    esta = true;
                    band = false;
                }
                aux = aux.getNext();
            } while (aux != cabeza && band);
        }

        return esta;
    }
    
    public int size(){
        int size = 0;
        
        NodoCS aux = cabeza;
        
        if (aux == null) {

        } else {
            do{
                size++;
                aux = aux.getNext();
            }while (aux != cabeza);
        }

        return size; 
    }

}
