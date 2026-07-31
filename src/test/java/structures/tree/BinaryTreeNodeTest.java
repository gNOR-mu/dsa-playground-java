package structures.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    // TODO cambiar la inicialización de los árboles cuando se haya implementado
    // la serialización/deserialización y pasar los casos como lista de argumentos

    @Test
    @DisplayName("Debe crear un nodo hoja con el constructor de un argumento")
    void shouldCreateLeafNodeWithSingleArgConstructor() {
        BinaryTreeNode<Integer> leaf = new BinaryTreeNode<>(5);

        assertEquals(5, leaf.getVal());
        assertNull(leaf.getLeft(), "El hijo izquierdo debe ser null por defecto");
        assertNull(leaf.getRight(), "El hijo derecho debe ser null por defecto");
    }

    @Test
    @DisplayName("Debe construir un árbol con el constructor de todos los argumentos")
    void shouldBuildTreeWithAllArgsConstructor() {
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1, leftChild, rightChild);

        assertEquals(1, root.getVal());
        assertEquals(leftChild, root.getLeft());
        assertEquals(rightChild, root.getRight());
    }

    @Test
    @DisplayName("Debe validar la igualdad profunda cuando la estructura y valores coinciden")
    void shouldBeEqualWhenStructureAndValuesMatch() {
        // 1
        // / \
        // 2 3
        BinaryTreeNode<Integer> tree1 = new BinaryTreeNode<>(1,
                new BinaryTreeNode<>(2),
                new BinaryTreeNode<>(3));

        // 1
        // / \
        // 2 3
        BinaryTreeNode<Integer> tree2 = new BinaryTreeNode<>(1,
                new BinaryTreeNode<>(2),
                new BinaryTreeNode<>(3));

        assertEquals(tree1, tree2, "Lombok @Data debe validar la igualdad profunda del árbol");
        assertEquals(tree1.hashCode(), tree2.hashCode(), "El hashCode debe coincidir para estructuras idénticas");
    }

    @Test
    @DisplayName("No debe considerar iguales nodos con estructuras diferentes")
    void shouldNotBeEqualWhenStructureDiffers() {
        // 1
        // /
        // 2
        BinaryTreeNode<Integer> tree1 = new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), null);

        // 1
        // \
        // 2
        BinaryTreeNode<Integer> tree2 = new BinaryTreeNode<>(1, null, new BinaryTreeNode<>(2));

        assertNotEquals(tree1, tree2, "Nodos con la misma altura pero distinta rama no son iguales");
    }

    @Test
    @DisplayName("Debe permitir valores nulos en el nodo")
    void shouldAllowNullValues() {
        BinaryTreeNode<Integer> nodeWithNullVal = new BinaryTreeNode<>(null);
        assertNull(nodeWithNullVal.getVal());
    }
}