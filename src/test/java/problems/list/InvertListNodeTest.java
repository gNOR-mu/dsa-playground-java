package problems.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import structures.list.ListNode;
import utils.ListUtils;

public class InvertListNodeTest {

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of("manzana", "zanahoria", "naranja")),
                Arguments.of(List.of('a', 'b', 'c')),
                Arguments.of(Arrays.asList(1, null, 3, 4, 5)),
                Arguments.of(Arrays.asList(null, 3, 4, 5)),
                Arguments.of(Arrays.asList(null, 3, 4, null)),
                Arguments.of(Arrays.asList(1, 3, 4, null)),
                Arguments.of(Arrays.asList(null, null, 3, 4, 5)),
                Arguments.of(Arrays.asList("manzana", "null", null)),
                Arguments.of(Arrays.asList('a', 'b', null)));
    }

    private InvertListNode invertListNode;

    @BeforeEach
    void setUp() {
        invertListNode = new InvertListNode();

        // omito cualquier solución no implementada
        try {
            invertListNode.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe manejar lista nula sin lanzar excepciones")
    void shouldHandleNullListWithoutExceptions() {
        ListNode<Integer> head = null;
        ListNode<Integer> newHead = invertListNode.solve(head);
        assertNull(newHead);
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe manejar lista sin lanzar excepciones")
    void shouldHandleListWithNullValuesWithoutException(List<?> original) {
        var expected = original.reversed();
        var head = ListUtils.deserializeListNode(original);

        var newHead = invertListNode.solve(head);
        var actual = ListUtils.serializeListNode(newHead);

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Debe mantener el valor igual para una lista de un solo elemento")
    void shouldKeepSameValueForSingleElementList() {
        ListNode<Integer> head = new ListNode<>(1);

        ListNode<Integer> newHead = invertListNode.solve(head);

        assertEquals(1, newHead.getVal());
        assertNull(newHead.getNext());
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe invertir los valores para listas de distintos tipos de datos")
    void shouldInvertValuesInMemoryForDifferentListTypes(List<?> original) {
        var expected = original.reversed();
        var head = ListUtils.deserializeListNode(original);

        var newHead = invertListNode.solve(head);
        var actual = ListUtils.serializeListNode(newHead);

        assertNotEquals(original, expected);
        assertNotEquals(original, actual);
        assertEquals(expected, actual);
    }

}
