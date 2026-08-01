package problems.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

public class RemoveDuplicatesListNode2Test {

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                // Original, Esperado
                Arguments.of(List.of(1, 2, 3, 3, 4, 4, 5), List.of(1, 2, 5)),
                Arguments.of(List.of(1, 1, 1, 2, 3), List.of(2, 3)),
                Arguments.of(List.of(1, 2, 2, 1), List.of()),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3)),
                Arguments.of(List.of(1, 1, 2, 2), List.of()),
                Arguments.of(List.of("apple", "banana", "banana", "cherry"), List.of("apple", "cherry")));
    }

    private RemoveDuplicatesListNode2 solver;

    @BeforeEach
    void setUp() {
        solver = new RemoveDuplicatesListNode2();

        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar null cuando la cabeza es nula")
    void shouldReturnNullWhenHeadIsNull() {
        assertNull(solver.solve(null));
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe eliminar por completo todos los nodos duplicados")
    void shouldRemoveAllDuplicatesCorrectly(List<?> original, List<?> expected) {
        var head = ListUtils.deserializeListNode(original);
        ListNode<?> result = solver.solve(head);
        List<?> actual = ListUtils.serializeListNode(result);
        assertEquals(expected, actual);
    }
}
