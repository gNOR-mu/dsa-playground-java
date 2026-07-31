package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.list.ListNode;

public class ListUtilsTest {

    @Test
    @DisplayName("deserializeListNode debe retornar null cuando la lista es nula o vacía")
    void shouldReturnNullWhenListIsNullOrEmpty() {
        assertNull(ListUtils.deserializeListNode(null));
        assertNull(ListUtils.deserializeListNode(List.of()));
    }

    @Test
    @DisplayName("deserializeListNode debe deserializar una lista de un solo elemento")
    void shouldDeserializeSingleElementList() {
        ListNode<Integer> result = ListUtils.deserializeListNode(List.of(10));

        assertEquals(10, result.getVal());
        assertNull(result.getNext());
    }

    @Test
    @DisplayName("deserializeListNode debe deserializar una lista de múltiples elementos en orden")
    void shouldDeserializeMultiElementList() {
        ListNode<Integer> result = ListUtils.deserializeListNode(List.of(1, 2, 3));

        assertEquals(1, result.getVal());
        assertEquals(2, result.getNext().getVal());
        assertEquals(3, result.getNext().getNext().getVal());
        assertNull(result.getNext().getNext().getNext());
    }

    @Test
    @DisplayName("serializeListNode no debe retornar null cuando la cabeza es nula")
    void shouldNotReturnNullWhenHeadIsNull() {
        assertNotNull(ListUtils.serializeListNode(null));
    }

    @Test
    @DisplayName("serializeListNode debe serializar una lista enlazada a List de elementos")
    void shouldSerializeListNodeToList() {
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)));
        List<Integer> result = ListUtils.serializeListNode(head);

        assertEquals(3, result.size());
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
    }

    @Test
    @DisplayName("Debe cumplir con el ciclo completo de deserialización y serialización")
    void shouldPerformRoundTripCorrectly() {
        List<Integer> original = List.of(5, 10, 15, 20);
        ListNode<Integer> head = ListUtils.deserializeListNode(original);
        List<Integer> serialized = ListUtils.serializeListNode(head);

        assertEquals(original.size(), serialized.size());
        assertEquals(original, serialized);
    }

    @Test
    @DisplayName("getStringRepresentation para ListNode debe retornar una cadena vacía cuando la lista es nula")
    void shouldReturnEmptyStringWhenListIsNull() {
        assertEquals("", ListUtils.getStringRepresentation((ListNode<Integer>) null));
    }

    @Test
    @DisplayName("getStringRepresentation para ListNode debe retornar la cadena formateada")
    void shouldReturnCorrectStringRepresentation() {
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, new ListNode<>(null, new ListNode<>(4))));
        assertEquals("1->2->null->4", ListUtils.getStringRepresentation(head));
    }
}
