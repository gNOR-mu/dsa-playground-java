package structures.list;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un nodo en una estructura de lista enlazada simple.
 * Cada nodo almacena un valor de tipo genérico y mantiene una referencia al
 * siguiente nodo.
 *
 * @param <T> El tipo de dato que almacena el nodo.
 */
@Data
@NoArgsConstructor
public class ListNode<T> {

    /** Valor almacenado en el nodo */
    private T val;

    /** Siguiente nodo en la lista */
    private ListNode<T> next;

    /**
     * Construye un nuevo nodo estableciendo su valor. La referencia al siguiente
     * nodo se inicializa como nula.
     * 
     * @param val El valor del nodo.
     */
    public ListNode(T val) {
        this.val = val;
    }

    /**
     * Construye un nuevo nodo estableciendo su valor y la referencia al siguiente
     * nodo.
     * 
     * @param val  El valor del nodo.
     * @param next El siguiente nodo en la lista. Puede ser nulo.
     */
    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

}
