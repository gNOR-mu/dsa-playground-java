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

public class ReverseListRangeTest {

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                // Original, left, right, Esperado
                Arguments.of(List.of(1, 2, 3, 4, 5), 1, 3, List.of(1, 4, 3, 2, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5), 0, 4, List.of(5, 4, 3, 2, 1)),
                Arguments.of(List.of(1, 2, 3), 1, 2, List.of(1, 3, 2)),
                Arguments.of(List.of(5), 0, 0, List.of(5)),
                Arguments.of(List.of("A", "B", "C", "D"), 0, 2, List.of("C", "B", "A", "D")));
    }

    private ReverseListRange solver;

    @BeforeEach
    void setUp() {
        solver = new ReverseListRange();

        try {
            solver.solve(null, 0, 0);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar null cuando la cabeza es nula")
    void shouldReturnNullWhenHeadIsNull() {
        assertNull(solver.solve(null, 0, 0));
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe invertir correctamente los nodos dentro del rango especificado")
    void shouldReverseListRangeCorrectly(List<?> original, int left, int right, List<?> expected) {
        var head = ListUtils.deserializeListNode(original);
        ListNode<?> result = solver.solve(head, left, right);
        List<?> actual = ListUtils.serializeListNode(result);
        assertEquals(expected, actual);
    }
}
