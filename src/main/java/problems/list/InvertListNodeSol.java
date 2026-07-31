package problems.list;

import structures.list.ListNode;

/**
 * Solución propuesta para invertir listas una lista enlazada
 * 
 * @see InvertListNode
 */
public class InvertListNodeSol extends InvertListNode {

    /**
     * {@inheritDoc}
     * 
     * @implNote Invierte una lista enlazada a partir de su nodo cabeza utilizando 2
     *           punteros curr (actual) y prev (anterior) el cual se inicializa como
     *           nulo debido a que el anterior del primer nodo invertido pasa a ser
     *           nulo.
     *           Luego se cambia el puntero del nodo actual para que apunte hacia
     *           atrás y se itera hasta terminar
     * 
     */
    @Override
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
