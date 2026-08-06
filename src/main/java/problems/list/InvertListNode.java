package problems.list;

import structures.list.ListNode;

/**
 * Dada una cabeza (head) de {@link ListNode} invierte su orden.
 * 
 * <pre>
 * Ejemplo:
 * Original     1->2->3->4->5
 * Invertido    5->4->3->2->1
 * </pre>
 */
public class InvertListNode {

    /**
     * Resuelve el problema
     * 
     * @param <T>  el tipo de dato de los elementos en la lista
     * @param head el nodo cabeza de la lista a invertir
     * @return el nuevo nodo cabeza de la lista invertida
     * @implNote Invierte una lista enlazada a partir de su nodo cabeza utilizando 2
     *           punteros curr (actual) y prev (anterior) el cual se inicializa como
     *           nulo debido a que el anterior del primer nodo invertido pasa a ser
     *           nulo.
     *           Luego se cambia el puntero del nodo actual para que apunte hacia
     *           atrás y se itera hasta terminar
     */
    public <T> ListNode<T> solve(ListNode<T> head) {
        ListNode<T> curr = head;
        ListNode<T> prev = null;

        while (curr != null) {
            ListNode<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
