package problems.list;

import structures.list.ListNode;

/**
 * Dado una cabeza de {@link ListNode} encuentra su valor en la posición
 * central en una lista no ordenada y no cíclica. En caso de que se hallen 2
 * valores en la posición central, se considera que el segundo elemento
 * corresponde al nodo central
 * 
 * 
 * Ej 1:
 * 1->2->3->4->5 Su valor central es 3
 * 
 * Ej 2:
 * 3->1->2->9->99 Su valor central es 2
 * 
 * Ej 3:
 * 1->2->3->4 Su valor central es 3
 * 
 * Ej 4:
 * 1->2 Su valor central es 2
 * 
 * Ej 5:
 * (nulo) Su valor central es nulo
 */
public class MiddlePointListNode {

    /**
     * 
     * @param <T>  El tipo de dato de los elementos en la lista
     * @param head El nodo cabeza de la lista
     * @return El nodo central de la lista
     * @implNote Utiliza la estrategia de doble punteros fast y slow para encontrar
     *           el valor central
     */
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
