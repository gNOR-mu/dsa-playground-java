package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structures.tree.BinaryTreeNode;

public class TreeUtilsTest {

    @Test
    @DisplayName("deserializeBinaryTreeNode debe retornar null si el arreglo es nulo, vacío o su primer elemento es nulo")
    void shouldReturnNullWhenArrayIsNullOrEmptyOrFirstElementIsNull() {
        assertNull(TreeUtils.deserializeBinaryTreeNode(null));
        assertNull(TreeUtils.deserializeBinaryTreeNode(new Integer[0]));
        assertNull(TreeUtils.deserializeBinaryTreeNode(new Integer[]{null}));
    }

    @Test
    @DisplayName("serializeBinaryTreeNode debe retornar una lista vacía cuando el nodo raíz es nulo")
    void shouldReturnEmptyListWhenRootIsNull() {
        List<Integer> result = TreeUtils.serializeBinaryTreeNode(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Debe serializar y deserializar correctamente un árbol con un solo nodo")
    void shouldRoundtripSingleNode() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        List<Integer> serialized = TreeUtils.serializeBinaryTreeNode(root);

        assertEquals(List.of(10), serialized);

        BinaryTreeNode<Integer> deserialized = TreeUtils.deserializeBinaryTreeNode(new Integer[]{10});
        assertEquals(root, deserialized);
    }

    @Test
    @DisplayName("Debe serializar y deserializar correctamente un árbol binario completo y balanceado")
    void shouldRoundtripBalancedTree() {
        //      1
        //     / \
        //    2   3
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                new BinaryTreeNode<>(2),
                new BinaryTreeNode<>(3));

        List<Integer> serialized = TreeUtils.serializeBinaryTreeNode(root);
        assertEquals(List.of(1, 2, 3), serialized);

        BinaryTreeNode<Integer> deserialized = TreeUtils.deserializeBinaryTreeNode(new Integer[]{1, 2, 3});
        assertEquals(root, deserialized);
    }

    @Test
    @DisplayName("Debe serializar y deserializar un árbol desbalanceado con hijos nulos intermedios")
    void shouldRoundtripUnbalancedTreeWithIntermediateNulls() {
        //      1
        //       \
        //        3
        //       /
        //      4
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                null,
                new BinaryTreeNode<>(3, new BinaryTreeNode<>(4), null));

        List<Integer> serialized = TreeUtils.serializeBinaryTreeNode(root);
        // Arrays.asList admite elementos nulos, a diferencia de List.of
        assertEquals(Arrays.asList(1, null, 3, 4), serialized);

        BinaryTreeNode<Integer> deserialized = TreeUtils.deserializeBinaryTreeNode(new Integer[]{1, null, 3, 4});
        assertEquals(root, deserialized);
    }

    @Test
    @DisplayName("Debe serializar y deserializar un árbol degenerado (tipo lista enlazada a la izquierda)")
    void shouldRoundtripDegenerateLeftTree() {
        //      1
        //     /
        //    2
        //   /
        //  3
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1,
                new BinaryTreeNode<>(2, new BinaryTreeNode<>(3), null),
                null);

        List<Integer> serialized = TreeUtils.serializeBinaryTreeNode(root);
        assertEquals(Arrays.asList(1, 2, null, 3), serialized);

        BinaryTreeNode<Integer> deserialized = TreeUtils.deserializeBinaryTreeNode(new Integer[]{1, 2, null, 3});
        assertEquals(root, deserialized);
    }

    @Test
    @DisplayName("Debe funcionar con tipos de datos genéricos como String")
    void shouldWorkWithStrings() {
        //      "A"
        //     /   \
        //  "B"     "C"
        //    \
        //    "D"
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A",
                new BinaryTreeNode<>("B", null, new BinaryTreeNode<>("D")),
                new BinaryTreeNode<>("C"));

        List<String> serialized = TreeUtils.serializeBinaryTreeNode(root);
        assertEquals(Arrays.asList("A", "B", "C", null, "D"), serialized);

        BinaryTreeNode<String> deserialized = TreeUtils.deserializeBinaryTreeNode(new String[]{"A", "B", "C", null, "D"});
        assertEquals(root, deserialized);
    }
}
