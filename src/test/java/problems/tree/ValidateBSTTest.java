package problems.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.tree.BinaryTreeNode;
import utils.TreeUtils;

public class ValidateBSTTest {

    private ValidateBST solver;

    @BeforeEach
    void setUp() {
        solver = new ValidateBST();

        // Omitir si no está implementado
        try {
            solver.solve(null);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar true cuando el árbol es nulo")
    void shouldReturnTrueWhenTreeIsNull() {
        assertTrue(solver.solve(null));
    }

    @Test
    @DisplayName("Debe retornar true para un solo nodo")
    void shouldReturnTrueForSingleNode() {
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{10});
        assertTrue(solver.solve(root));
    }

    @Test
    @DisplayName("Debe retornar true para un BST balanceado válido")
    void shouldReturnTrueForValidBalancedBST() {
        //        2
        //       / \
        //      1   3
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{2, 1, 3});
        assertTrue(solver.solve(root));
    }

    @Test
    @DisplayName("Debe retornar false para un árbol inválido donde un nodo derecho es menor que un ancestro")
    void shouldReturnFalseForInvalidBSTRightSubtree() {
        //        5
        //       / \
        //      1   4
        //         / \
        //        3   6
        // 3 está en el subárbol derecho de 5 pero es menor que 5
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{
            5, 1, 4, null, null, 3, 6
        });
        assertFalse(solver.solve(root));
    }

    @Test
    @DisplayName("Debe retornar false cuando hay valores duplicados (debe ser estrictamente mayor/menor)")
    void shouldReturnFalseForDuplicateValues() {
        //        22
        //       /
        //      22
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[]{22, 22});
        assertFalse(solver.solve(root));
    }

    @Test
    @DisplayName("Debe manejar límites con Integer.MIN_VALUE e Integer.MAX_VALUE sin causar overflow")
    void shouldHandleIntegerExtremeBounds() {
        BinaryTreeNode<Integer> rootMax = TreeUtils.deserializeBinaryTreeNode(new Integer[]{Integer.MAX_VALUE});
        assertTrue(solver.solve(rootMax));

        BinaryTreeNode<Integer> rootMin = TreeUtils.deserializeBinaryTreeNode(new Integer[]{Integer.MIN_VALUE});
        assertTrue(solver.solve(rootMin));

        // Un BST donde el hijo izquierdo es Integer.MIN_VALUE y el derecho es Integer.MAX_VALUE
        BinaryTreeNode<Integer> rootValidBounds = TreeUtils.deserializeBinaryTreeNode(new Integer[]{
            0, Integer.MIN_VALUE, Integer.MAX_VALUE
        });
        assertTrue(solver.solve(rootValidBounds));

        // Un BST inválido donde un nodo hijo tiene el mismo valor límite superior
        BinaryTreeNode<Integer> rootInvalidBounds = TreeUtils.deserializeBinaryTreeNode(new Integer[]{
            Integer.MAX_VALUE, null, Integer.MAX_VALUE
        });
        assertFalse(solver.solve(rootInvalidBounds));
    }
}
