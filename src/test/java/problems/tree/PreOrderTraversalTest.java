package problems.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.tree.BinaryTreeNode;
import utils.TreeUtils;

public class PreOrderTraversalTest {

    private PreOrderTraversal solver;

    @BeforeEach
    void setUp() {
        solver = new PreOrderTraversal();

        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar lista vacía cuando el árbol es nulo")
    void shouldReturnEmptyListWhenTreeIsNull() {
        List<Integer> result = solver.solve(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Debe recorrer un árbol con un solo nodo")
    void shouldTraverseSingleNode() {
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] { 10 });
        List<Integer> result = solver.solve(root);

        assertEquals(List.of(10), result);
    }

    @Test
    @DisplayName("Debe recorrer en pre-orden un árbol completo y balanceado")
    void shouldTraverseBalancedTreeInPreOrder() {
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] { 1, 2, 3, 4, 5 });
        List<Integer> result = solver.solve(root);

        // Pre-order: Raíz, Izquierda, Derecha -> 1, 2, 4, 5, 3
        assertEquals(List.of(1, 2, 4, 5, 3), result);
    }

    @Test
    @DisplayName("Debe recorrer en pre-orden un árbol degenerado hacia la izquierda")
    void shouldTraverseLeftSkewedTreeInPreOrder() {
        // 1
        // /
        // 2
        // /
        // 3
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] { 1, 2, null, 3 });
        List<Integer> result = solver.solve(root);

        // Pre-order: 1, 2, 3
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    @DisplayName("Debe recorrer en pre-orden un árbol degenerado hacia la derecha")
    void shouldTraverseRightSkewedTreeInPreOrder() {
        // 1
        // \
        // 2
        // \
        // 3
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] { 1, null, 2, null, 3 });
        List<Integer> result = solver.solve(root);

        // Pre-order: 1, 2, 3
        assertEquals(List.of(1, 2, 3), result);
    }
}
