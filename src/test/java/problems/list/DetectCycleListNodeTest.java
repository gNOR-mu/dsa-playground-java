package problems.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import structures.list.ListNode;
import utils.ListUtils;

public class DetectCycleListNodeTest {

    private DetectCycleListNode solver;

    @BeforeEach
    void setUp() {
        solver = new DetectCycleListNode();

        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar false para una lista nula")
    void shouldReturnFalseForNullHead() {
        assertFalse(solver.solve(null));
    }

    @Test
    @DisplayName("Debe retornar false para una lista de un solo elemento sin ciclo")
    void shouldReturnFalseForSingleNodeWithoutCycle() {
        ListNode<Integer> head = new ListNode<>(1);
        assertFalse(solver.solve(head));
    }

    @Test
    @DisplayName("Debe retornar true para una lista de un solo elemento que apunta a sí mismo")
    void shouldReturnTrueForSingleNodeWithSelfCycle() {
        ListNode<Integer> head = new ListNode<>(1);
        head.setNext(head);
        assertTrue(solver.solve(head));
    }

    @Test
    @DisplayName("Debe retornar false para una lista lineal larga sin ciclos")
    void shouldReturnFalseForLinearListWithoutCycle() {
        ListNode<Integer> head = ListUtils.deserializeListNode(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        assertFalse(solver.solve(head));
    }

    @Test
    @DisplayName("Debe retornar true para una lista con ciclo en el medio")
    void shouldReturnTrueForListWithCycleInMiddle() {
        // 3 -> 2 -> 0 -> -4 (apunta a 2 en el índice 1)
        ListNode<Integer> head = createListWithCycle(List.of(3, 2, 0, -4), 1);
        assertTrue(solver.solve(head));
    }

    @Test
    @DisplayName("Debe retornar true para una lista de dos elementos que es cíclica")
    void shouldReturnTrueForTwoNodeCycle() {
        // 1 -> 2 (apunta a 1 en el índice 0)
        ListNode<Integer> head = createListWithCycle(List.of(1, 2), 0);
        assertTrue(solver.solve(head));
    }

    /**
     * Helper para crear listas enlazadas que contengan ciclos.
     * Si cyclePos es -1, la lista se mantiene acíclica.
     */
    private <T> ListNode<T> createListWithCycle(List<T> values, int cyclePos) {
        ListNode<T> head = ListUtils.deserializeListNode(values);
        if (cyclePos < 0 || head == null) {
            return head;
        }
        ListNode<T> current = head;
        ListNode<T> cycleNode = null;
        int i = 0;
        while (current.getNext() != null) {
            if (i == cyclePos) {
                cycleNode = current;
            }
            current = current.getNext();
            i++;
        }
        if (i == cyclePos) {
            cycleNode = current;
        }
        current.setNext(cycleNode);
        return head;
    }
}
