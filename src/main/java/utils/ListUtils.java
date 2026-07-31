package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import structures.list.ListNode;

/**
 * Clase de utilidad para operaciones relacionadas con listas enlazadas.
 */
public class ListUtils {

    /**
     * Convierte un arreglo de elementos en una lista enlazada simple.
     * La lista se construye en orden, donde el primer elemento del arreglo
     * será la cabeza (head) de la lista.
     *
     * @param <T>   El tipo de dato de los elementos de la lista.
     * @param nodes Una Lista con los valores a serializar. Puede ser nulo o vacío.
     * @return La cabeza (head) de la lista enlazada construida, o {@code null} si
     *         el arreglo es nulo o vacío.
     */
    public static <T> ListNode<T> serializeListNode(List<T> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }

        ListNode<T> head = null;

        for (int i = nodes.size() - 1; i >= 0; i--) {
            head = new ListNode<>(nodes.get(i), head);
        }

        return head;
    }

    /**
     * Convierte una lista enlazada simple de vuelta en una lista de elementos.
     *
     * @param <T>  El tipo de dato de los elementos de la lista.
     * @param head La cabeza (head) de la lista enlazada.
     * @return Una lista con los valores de los nodos en orden, o {@code null} si la
     *         cabeza es nula.
     */
    public static <T> List<T> deserializeListNode(ListNode<T> head) {
        if (head == null) {
            return null;
        }

        List<T> deserialized = new ArrayList<>();

        while (head != null) {
            deserialized.add(head.getVal());
            head = head.getNext();
        }
        return deserialized;
    }

    /**
     * Obtiene la representación en cadena de la lista enlazada.
     *
     * @param <T>  El tipo de dato de los elementos de la lista.
     * @param head La cabeza (head) de la lista enlazada.
     * @return La representación en cadena de la lista.
     */
    public static <T> String getStringRepresentation(ListNode<T> head) {
        StringJoiner joiner = new StringJoiner("->");
        ListNode<T> current = head;

        while (current != null) {
            joiner.add(String.valueOf(current.getVal()));
            current = current.getNext();
        }
        return joiner.toString();
    }

    /**
     * Imprime la representación en cadena de la lista enlazada.
     *
     * @param <T>  El tipo de dato de los elementos de la lista.
     * @param head La cabeza (head) de la lista enlazada.
     */
    public static <T> void printListNode(ListNode<T> head) {
        System.out.println(getStringRepresentation(head));
    }
}
