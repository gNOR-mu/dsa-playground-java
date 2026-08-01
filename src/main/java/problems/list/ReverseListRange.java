package problems.list;

import exceptions.NotImplementedException;
import structures.list.ListNode;

/// Invierte los nodos de una lista enlazada desde la posición `left` hasta la posición `right`.
/// Los índices son 0-indexed (basados en 0).
///
/// | Original              | left | right | Esperado              |
/// |-----------------------|------|-------|-----------------------|
/// | 1 -> 2 -> 3 -> 4 -> 5 | 1    | 3     | 1 -> 4 -> 3 -> 2 -> 5 |
/// | 1 -> 2 -> 3 -> 4 -> 5 | 0    | 4     | 5 -> 4 -> 3 -> 2 -> 1 |
/// | 1 -> 2 -> 3           | 1    | 2     | 1 -> 3 -> 2           |
public class ReverseListRange {

    /**
     * Invierte los nodos en el rango especificado.
     *
     * @param <T>   El tipo de dato de los elementos en la lista.
     * @param head  El nodo cabeza de la lista.
     * @param left  La posición inicial del rango (0-indexed, inclusivo).
     * @param right La posición final del rango (0-indexed, inclusivo).
     * @return El nodo cabeza de la lista modificada.
     */
    public <T> ListNode<T> solve(ListNode<T> head, int left, int right) {
        throw new NotImplementedException();
    }
}
