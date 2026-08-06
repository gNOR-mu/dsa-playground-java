package problems.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.tree.BinaryTreeNode;
import utils.TreeUtils;

public class PathSumTest {

    private PathSum solver;

    @BeforeEach
    void setUp() {
        solver = new PathSum();

        // Omitir si no está implementado
        try {
            solver.solve(null, 0);
        } catch (UnsupportedOperationException e) {
            Assumptions.abort("Solución no implementada");
        }
    }

    @Test
    @DisplayName("Debe retornar false cuando el árbol es nulo")
    void shouldReturnFalseWhenTreeIsNull() {
        assertFalse(solver.solve(null, 0));
        assertFalse(solver.solve(null, 10));
    }

    @Test
    @DisplayName("Debe validar suma para un solo nodo")
    void shouldValidateSumForSingleNode() {
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] { 5 });
        assertTrue(solver.solve(root, 5));
        assertFalse(solver.solve(root, 10));
    }

    @Test
    @DisplayName("Debe validar suma en un camino de múltiples niveles")
    void shouldValidateSumInMultiLevelTree() {
        // 5
        // / \
        // 4 8
        // / / \
        // 11 13 4
        // / \ \
        // 7 2 1
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] {
                5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1
        });

        assertTrue(solver.solve(root, 22)); // 5 + 4 + 11 + 2
        assertTrue(solver.solve(root, 26)); // 5 + 8 + 13
        assertTrue(solver.solve(root, 18)); // 5 + 8 + 4 + 1
        assertFalse(solver.solve(root, 5)); // 5 está en la raíz, pero no es hoja
        assertFalse(solver.solve(root, 9)); // 5 + 4 = 9, pero 4 no es hoja
        assertFalse(solver.solve(root, 27)); // No hay ningún camino
    }

    @Test
    @DisplayName("Debe permitir desbordamientos estándar de enteros (overflow)")
    void shouldAllowIntegerOverflow() {
        BinaryTreeNode<Integer> root = TreeUtils.deserializeBinaryTreeNode(new Integer[] {
                1500000000, 1000000000
        });
        int targetWithOverflow = 1500000000 + 1000000000;
        assertTrue(solver.solve(root, targetWithOverflow));
    }
}
