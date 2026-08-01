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

public class MergeTwoSortedListsNodeTest {

    private static Stream<Arguments> provideLists() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 4), List.of(1, 3, 4), List.of(1, 1, 2, 3, 4, 4)),
                Arguments.of(List.of(), List.of(0), List.of(0)),
                Arguments.of(List.of(5), List.of(), List.of(5)),
                Arguments.of(List.of(1, 5, 9), List.of(2, 4, 10), List.of(1, 2, 4, 5, 9, 10)),
                Arguments.of(List.of("apple", "cherry"), List.of("banana", "date"),
                        List.of("apple", "banana", "cherry", "date")));
    }

    private MergeTwoSortedListsNode solver;

    @BeforeEach
    void setUp() {
        solver = new MergeTwoSortedListsNode();

        try {
            solver.solve(null, null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar null cuando ambas listas son nulas")
    void shouldReturnNullWhenBothListsAreNull() {
        assertNull(solver.solve(null, null));
    }

    @ParameterizedTest
    @MethodSource("provideLists")
    @DisplayName("Debe fusionar correctamente dos listas ordenadas")
    void shouldMergeTwoSortedLists(List<?> list1Vals, List<?> list2Vals, List<?> expectedVals) {
        // cast to comparable for compilation
        @SuppressWarnings("unchecked")
        ListNode<Comparable<Object>> head1 = (ListNode<Comparable<Object>>) ListUtils.deserializeListNode(list1Vals);
        @SuppressWarnings("unchecked")
        ListNode<Comparable<Object>> head2 = (ListNode<Comparable<Object>>) ListUtils.deserializeListNode(list2Vals);

        ListNode<Comparable<Object>> result = solver.solve(head1, head2);
        List<Comparable<Object>> actual = ListUtils.serializeListNode(result);

        assertEquals(expectedVals, actual);
    }
}
