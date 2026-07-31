package structures.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    @DisplayName("Debe crear un nodo con el constructor de un argumento")
    void shouldCreateNodeWithSingleArgConstructor() {
        ListNode<Integer> node = new ListNode<>(5);

        assertEquals(5, node.getVal());
        assertNull(node.getNext(), "El siguiente nodo debe ser null por defecto");
    }

    @Test
    @DisplayName("Debe construir una lista con el constructor de todos los argumentos")
    void shouldBuildListWithAllArgsConstructor() {
        ListNode<Integer> nextNode = new ListNode<>(10);
        ListNode<Integer> head = new ListNode<>(5, nextNode);

        assertEquals(5, head.getVal());
        assertEquals(nextNode, head.getNext());
        assertEquals(10, head.getNext().getVal());
    }

    @Test
    @DisplayName("Debe validar la igualdad profunda cuando la estructura y valores coinciden")
    void shouldBeEqualWhenStructureAndValuesMatch() {
        // 1 -> 2 -> 3
        ListNode<Integer> list1 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)));

        // 1 -> 2 -> 3
        ListNode<Integer> list2 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)));

        assertEquals(list1, list2, "Lombok @Data debe validar la igualdad profunda de la lista");
        assertEquals(list1.hashCode(), list2.hashCode(), "El hashCode debe coincidir para estructuras idénticas");
    }

    @Test
    @DisplayName("No debe considerar iguales nodos con diferentes valores o estructuras")
    void shouldNotBeEqualWhenStructureDiffers() {
        ListNode<Integer> list1 = new ListNode<>(1, new ListNode<>(2));
        ListNode<Integer> list2 = new ListNode<>(1, new ListNode<>(3));

        assertNotEquals(list1, list2, "Nodos con diferentes valores en los siguientes nodos no son iguales");
    }

    @Test
    @DisplayName("Debe permitir valores nulos en el nodo de la lista")
    void shouldAllowNullValues() {
        ListNode<Integer> nodeWithNullVal = new ListNode<>(null);
        assertNull(nodeWithNullVal.getVal());
    }

}
