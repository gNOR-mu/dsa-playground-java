package problems.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

public class RemoveDuplicatesListNodeTest {

    private RemoveDuplicatesListNode solver;

    @BeforeEach
    void setUp() {
        solver = new RemoveDuplicatesListNode();

        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe manejar lista nula sin lanzar excepciones")
    void shouldHandleNullList() {
        ListNode<Integer> head = null;
        solver.solve(head);
        assertNull(head);
    }

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                Arguments.of(List.of(1), List.of(1)),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3)),
                Arguments.of(List.of(1, 1, 1, 1), List.of(1)),
                Arguments.of(List.of(1, 2, 2, 3, 3), List.of(1, 2, 3)),
                Arguments.of(List.of(90, 1, 1, 2, 2, -100), List.of(90, 1, 2, -100)),
                Arguments.of(Arrays.asList("apple", "banana", "apple", "cherry"), List.of("apple", "banana", "cherry")),
                Arguments.of(Arrays.asList(1, null, 1, null, 2), Arrays.asList(1, null, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe eliminar duplicados conservando solo la primera aparición")
    void shouldRemoveDuplicatesInPlace(List<?> original, List<?> expected) {
        var head = ListUtils.deserializeListNode(original);
        solver.solve(head);
        var actual = ListUtils.serializeListNode(head);
        assertEquals(expected, actual);
    }
}
