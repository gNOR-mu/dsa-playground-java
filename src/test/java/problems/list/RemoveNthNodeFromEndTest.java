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

public class RemoveNthNodeFromEndTest {

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                // Original, n, Esperado
                Arguments.of(List.of(1, 2, 3, 4, 5), 2, List.of(1, 2, 3, 5)),
                Arguments.of(List.of(1), 1, List.of()),
                Arguments.of(List.of(1, 2), 1, List.of(1)),
                Arguments.of(List.of(1, 2), 2, List.of(2)),
                Arguments.of(List.of(10, 20, 30), 3, List.of(20, 30)),
                Arguments.of(List.of("A", "B", "C", "D"), 1, List.of("A", "B", "C")));
    }

    private RemoveNthNodeFromEnd solver;

    @BeforeEach
    void setUp() {
        solver = new RemoveNthNodeFromEnd();

        try {
            solver.solve(null, 1);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar null cuando la cabeza es nula")
    void shouldReturnNullWhenHeadIsNull() {
        assertNull(solver.solve(null, 1));
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe eliminar el n-ésimo nodo desde el final correctamente")
    void shouldRemoveNthFromEnd(List<?> original, int n, List<?> expected) {
        var head = ListUtils.deserializeListNode(original);
        ListNode<?> result = solver.solve(head, n);
        List<?> actual = ListUtils.serializeListNode(result);
        assertEquals(expected, actual);
    }
}
