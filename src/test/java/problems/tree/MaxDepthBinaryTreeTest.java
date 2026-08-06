package problems.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.tree.BinaryTreeNode;
import utils.TreeUtils;

public class MaxDepthBinaryTreeTest {

    private MaxDepthBinaryTree solver;

    @BeforeEach
    void setUp() {
        solver = new MaxDepthBinaryTree();

        // Omitir si no está implementado
        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar 0 cuando el árbol es nulo")
    void shouldReturnZeroWhenTreeIsNull() {
        assertEquals(0, solver.solve(null));
    }

    @Test
    @DisplayName("Debe retornar 1 para un árbol con un solo nodo")
    void shouldReturnOneForSingleNode() {
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{10});
        assertEquals(1, solver.solve(root));
    }

    @Test
    @DisplayName("Debe retornar la profundidad correcta para un árbol balanceado")
    void shouldReturnCorrectDepthForBalancedTree() {
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(3, solver.solve(root));
    }

    @Test
    @DisplayName("Debe retornar la profundidad correcta para un árbol degenerado hacia la izquierda")
    void shouldReturnCorrectDepthForLeftSkewedTree() {
        //      1
        //     /
        //    2
        //   /
        //  3
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{1, 2, null, 3});
        assertEquals(3, solver.solve(root));
    }

    @Test
    @DisplayName("Debe retornar la profundidad correcta para un árbol degenerado hacia la derecha")
    void shouldReturnCorrectDepthForRightSkewedTree() {
        //      1
        //       \
        //        2
        //         \
        //          3
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{1, null, 2, null, 3});
        assertEquals(3, solver.solve(root));
    }
}
