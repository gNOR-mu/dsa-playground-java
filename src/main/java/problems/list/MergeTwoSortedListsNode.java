package problems.list;

import exceptions.NotImplementedException;
import structures.list.ListNode;

/// Fusiona dos listas enlazadas ordenadas de forma no decreciente en una sola
/// lista enlazada ordenada. La nueva lista debe crearse uniendo los nodos de las
/// dos listas originales.
///
/// | Lista 1         | Lista 2         | Esperado               |
/// |-----------------|-----------------|------------------------|
/// | 1 -> 2 -> 4     | 1 -> 3 -> 4     | 1 -> 1 -> 3 -> 4 -> 4  |
/// | (nulo)          | (nulo)          | (nulo)                 |
/// | (nulo)          | 0               | 0 |
public class MergeTwoSortedListsNode {

    /**
     * Fusiona dos listas enlazadas ordenadas.
     *
     * @param <T>   El tipo de dato de los elementos de la lista, debe ser
     *              comparable.
     * @param list1 La cabeza de la primera lista enlazada ordenada.
     * @param list2 La cabeza de la segunda lista enlazada ordenada.
     * @return La cabeza de la lista enlazada fusionada y ordenada.
     * 
     * @apiNote Este método recibe dos listas ordenadas cuyos elementos se pueden
     *          comparar entre sí (incluso si la lógica de comparación está definida
     *          en una clase padre) y retorna una nueva lista ordenada con el mismo
     *          tipo de elementos.
     */
    public <T extends Comparable<? super T>> ListNode<T> solve(ListNode<T> list1, ListNode<T> list2) {
        throw new NotImplementedException();
    }
}
