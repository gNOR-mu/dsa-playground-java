package problems.list;

import exceptions.NotImplementedException;
import structures.list.ListNode;

/// Determina si una lista enlazada contiene un ciclo (bucle infinito).
/// Un ciclo ocurre si algún nodo en la lista puede ser alcanzado de nuevo
/// siguiendo continuamente el puntero `next`.
///
/// | Representación (pos indica dónde apunta el último nodo) | Esperado |
/// |--------------------------------------------------------|----------|
/// | 3 -> 2 -> 0 -> -4 (pos = 1, apunta al nodo con valor 2) | true     |
/// | 1 -> 2 (pos = 0, apunta al nodo con valor 1)            | true     |
/// | 1 (pos = -1, sin ciclo)                                 | false    |
/// | (nulo)                                                 | false    |
public class DetectCycleListNode {

    /**
     * Determina si la lista enlazada tiene un ciclo.
     *
     * @param <T>  El tipo de dato de los elementos en la lista.
     * @param head El nodo cabeza de la lista.
     * @return true si la lista contiene un ciclo, false en caso contrario.
     */
    public <T> boolean solve(ListNode<T> head) {
        throw new NotImplementedException();
    }
}
