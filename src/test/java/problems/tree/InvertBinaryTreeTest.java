package problems.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.tree.BinaryTreeNode;
import utils.TreeUtils;

public class InvertBinaryTreeTest {

    private InvertBinaryTree solver;

    @BeforeEach
    void setUp() {
        solver = new InvertBinaryTree();

        // Omitir si no está implementado
        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar null cuando el árbol es nulo")
    void shouldReturnNullWhenTreeIsNull() {
        assertNull(solver.solve(null));
    }

    @Test
    @DisplayName("Debe retornar el mismo árbol para un solo nodo")
    void shouldReturnSameForSingleNode() {
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{10});
        BinaryTreeNode<Integer> inverted = solver.solve(root);
        assertNotNull(inverted);
        assertEquals(10, inverted.getVal());
        assertNull(inverted.getLeft());
        assertNull(inverted.getRight());
    }

    @Test
    @DisplayName("Debe invertir correctamente un árbol balanceado")
    void shouldInvertBalancedTree() {
        //        4                  4
        //      /   \              /   \
        //     2     7     =>     7     2
        //    / \   / \          / \   / \
        //   1   3 6   9        9   6 3   1
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{
            4, 2, 7, 1, 3, 6, 9
        });

        BinaryTreeNode<Integer> inverted = solver.solve(root);
        List<Integer> expected = List.of(4, 7, 2, 9, 6, 3, 1);
        assertEquals(expected, TreeUtils.serializeBinaryTreeNode(inverted));
    }

    @Test
    @DisplayName("Debe invertir un árbol con hijos parciales/nulos")
    void shouldInvertTreeWithMissingNodes() {
        //        2                  2
        //       /                 /   \
        //      1        =>       null  1
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{
            2, 1
        });

        BinaryTreeNode<Integer> inverted = solver.solve(root);
        List<Integer> expected = List.of(2, null, 1);
        assertEquals(expected, TreeUtils.serializeBinaryTreeNode(inverted));
    }
}
