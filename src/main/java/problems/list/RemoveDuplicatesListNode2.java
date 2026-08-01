package problems.list;

import exceptions.NotImplementedException;
import structures.list.ListNode;

/// Dada la cabeza de una lista enlazada, elimina todos los nodos que tengan
/// valores duplicados, de modo que solo queden aquellos elementos que aparecen
/// una sola vez en la lista original.
///
/// | Original                            | Esperado        |
/// |-------------------------------------|-----------------|
/// | 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5     | 1 -> 2 -> 5     |
/// | 1 -> 1 -> 1 -> 2 -> 3               | 2 -> 3          |
/// | 1 -> 2 -> 2 -> 1                    | (nulo) |
public class RemoveDuplicatesListNode2 {

    /**
     * Elimina todas las apariciones de cualquier valor que esté duplicado en la
     * lista.
     *
     * @param <T>  El tipo de dato de los elementos en la lista.
     * @param head El nodo cabeza de la lista.
     * @return El nodo cabeza de la lista filtrada sin ningún elemento que haya
     *         tenido duplicados.
     */
    public <T> ListNode<T> solve(ListNode<T> head) {
        throw new NotImplementedException();
    }
}
