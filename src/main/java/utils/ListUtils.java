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
     * Convierte una colección de elementos en una lista enlazada simple
     * (deserialización).
     * 
     * @param <T>   El tipo de dato de los elementos de la lista.
     * @param nodes Una Lista con los valores a deserializar. Puede ser nulo o
     *              vacío.
     * @return La cabeza (head) de la lista enlazada construida, o {@code null} si
     *         la lista de entrada es nula o vacía.
     */
    public static <T> ListNode<T> deserializeListNode(List<T> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }

        ListNode<T> dummy = new ListNode<>(null);
        ListNode<T> current = dummy;

        for (T val : nodes) {
            current.setNext(new ListNode<>(val));
            current = current.getNext();
        }

        return dummy.getNext();
    }

    /**
     * Convierte una lista enlazada simple en una lista de elementos
     * (serialización).
     *
     * @param <T>  El tipo de dato de los elementos de la lista.
     * @param head La cabeza (head) de la lista enlazada a serializar.
     * @return Una lista con los valores de los nodos en orden. Nunca retorna null.
     */
    public static <T> List<T> serializeListNode(ListNode<T> head) {
        List<T> serialized = new ArrayList<>();
        ListNode<T> current = head;

        while (current != null) {
            serialized.add(current.getVal());
            current = current.getNext();
        }

        return serialized;
    }

    /**
     * Obtiene la representación en cadena de la lista enlazada mostrando los
     * valores de cada nodo.
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

}
