package ProyectoUniversidad.Colas;

public class Cola {
    private NodoC frente;
    private NodoC ultimo;

    public NodoC getFrente() {
        return frente;
    }
    
    public int size(){
        int size = 0;
        
        NodoC aux = frente;
        
        while (aux != null) {
            size++;
            aux = aux.getNext();
        }

        return size; 
    }
    
    public void push(NodoC nuevoElemento){
        if(frente == null){
            frente = nuevoElemento;
            ultimo = nuevoElemento;
        }else{
            ultimo.setNext(nuevoElemento);
            ultimo = nuevoElemento;
        }
        
    }
    
    public NodoC pop(){
        NodoC aux = frente;
        
        if(frente != null){
            frente = frente.getNext();
            aux.setNext(null);
        }
        
        return aux;
    }
    
}
