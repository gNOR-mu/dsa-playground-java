package problems.list;

import exceptions.NotImplementedException;
import structures.list.ListNode;

/// Elimina el n-ésimo nodo desde el final de la lista enlazada y devuelve su cabeza.
///
/// | Original              | n   | Esperado          |
/// |-----------------------|-----|-------------------|
/// | 1 -> 2 -> 3 -> 4 -> 5 | 2   | 1 -> 2 -> 3 -> 5  |
/// | 1                     | 1   | (nulo)            |
/// | 1 -> 2                | 2   | 2                 |
public class RemoveNthNodeFromEnd {

    /**
     * Elimina el n-ésimo nodo desde el final de la lista enlazada.
     *
     * @param <T>  El tipo de dato de los elementos en la lista.
     * @param head El nodo cabeza de la lista.
     * @param n    La posición (1-indexed) desde el final del nodo a eliminar.
     * @return El nodo cabeza de la lista modificada.
     */
    public <T> ListNode<T> solve(ListNode<T> head, int n) {
        throw new NotImplementedException();
    }
}
