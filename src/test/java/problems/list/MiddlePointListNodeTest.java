package problems.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

public class MiddlePointListNodeTest {
    /**
     * Provee un stream de nodos a probar
     * 
     * @return Stream con los test a probar compuesto por la cabeza y valor
     *         expectado, ninguno de ambos es nulo
     */
    private static Stream<Arguments> provideNodes() {
        return Stream.of(
                createTestCase(List.of(1, 2, 3), 1),
                createTestCase(List.of(1, 2, 3, 4), 2),
                createTestCase(List.of(1), 0),
                createTestCase(List.of(1, 1, 1), 1),
                createTestCase(List.of(Integer.MAX_VALUE, Integer.MIN_VALUE), 1),
                createTestCase(List.of(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE), 1),
                createTestCase(Arrays.asList(1, null, 1), 1),
                createTestCase(Arrays.asList(null, null, null), 1),
                createTestCase(Arrays.asList(null, 1, null), 1));
    }

    /**
     * Genera casos de prueba
     * 
     * @param values      Lista con los valores a probar
     * @param middleIndex Índice del elemento central
     * @return Argumentos compuesto por la cabeza de la lista de nodos (posición 0)
     *         y su valor esperado (posición 1)
     */
    private static Arguments createTestCase(List<?> values, int middleIndex) {
        var head = ListUtils.deserializeListNode(values);
        var expected = head;
        // valor central aproximado hacia arriba

        for (int i = 0; i < middleIndex; i++) {
            expected = expected.getNext();
        }
        return Arguments.of(head, expected);
    }

    private MiddlePointListNode middlePointListNode;

    @BeforeEach
    void setUp() {
        middlePointListNode = new MiddlePointListNode();

        try {
            middlePointListNode.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar nulo cuando la cabeza es nulo")
    void shouldReturnNullWhenHeadIsNull() {
        // arrange
        ListNode<Integer> head = null;

        // act
        var res = middlePointListNode.solve(head);

        // assert
        assertNull(res);
    }

    @ParameterizedTest
    @MethodSource("provideNodes")
    @DisplayName("Debe retornar correctamente el valor central")
    void shouldReturnCorrectlyTheMiddleNode(ListNode<?> head, ListNode<?> expected) {
        // act
        var res = middlePointListNode.solve(head);

        // assert
        assertNotNull(res);
        assertEquals(expected, res);
    }
}
