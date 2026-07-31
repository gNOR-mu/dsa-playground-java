package problems.list;

import structures.list.ListNode;

/**
 * Solución propuesta de {@link MiddlePointListNode} para encontrar su valor
 * central.
 */
public class MiddlePointListNodeSol extends MiddlePointListNode {

    /**
     * {@inheritDoc}
     * 
     * @implNote Utiliza la estrategia de doble punteros fast y slow para encontrar
     *           el valor central
     */
    @Override
    public <T> ListNode<T> solve(ListNode<T> head) {
        if (head == null) {
            return null;
        }

        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

}
