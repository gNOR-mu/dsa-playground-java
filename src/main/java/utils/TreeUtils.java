package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structures.tree.BinaryTreeNode;

public class TreeUtils {

    /**
     * Convierte un arreglo de elementos que representa un recorrido por niveles (BFS)
     * en un árbol binario (deserialización).
     *
     * @param <T>   El tipo de dato de los elementos del árbol.
     * @param nodes Un arreglo con los valores a deserializar. Puede ser nulo o vacío.
     * @return El nodo raíz (root) del árbol binario construido, o {@code null} si
     *         el arreglo de entrada es nulo, vacío o su primer elemento es nulo.
     */
    public static <T> BinaryTreeNode<T> deserializeBinaryTreeNode(T[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        BinaryTreeNode<T> root = new BinaryTreeNode<>(nodes[0]);
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            BinaryTreeNode<T> current = queue.poll();

            // Hijo izquierdo
            if (i < nodes.length) {
                if (nodes[i] != null) {
                    BinaryTreeNode<T> leftChild = new BinaryTreeNode<>(nodes[i]);
                    current.setLeft(leftChild);
                    queue.offer(leftChild);
                }
                i++;
            }

            // Hijo derecho
            if (i < nodes.length) {
                if (nodes[i] != null) {
                    BinaryTreeNode<T> rightChild = new BinaryTreeNode<>(nodes[i]);
                    current.setRight(rightChild);
                    queue.offer(rightChild);
                }
                i++;
            }
        }

        return root;
    }

    /**
     * Convierte un árbol binario en una lista de elementos que representa
     * un recorrido por niveles (BFS), omitiendo los valores nulos sobrantes al final.
     *
     * @param <T>  El tipo de dato de los elementos del árbol.
     * @param root El nodo raíz del árbol a serializar.
     * @return Una lista con los valores del recorrido por niveles. Nunca retorna null.
     */
    public static <T> List<T> serializeBinaryTreeNode(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (current != null) {
                result.add(current.getVal());
                queue.offer(current.getLeft());
                queue.offer(current.getRight());
            } else {
                result.add(null);
            }
        }

        // Eliminar valores nulos sobrantes al final de la lista
        int lastNonNullIndex = result.size() - 1;
        while (lastNonNullIndex >= 0 && result.get(lastNonNullIndex) == null) {
            lastNonNullIndex--;
        }

        if (lastNonNullIndex < 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(result.subList(0, lastNonNullIndex + 1));
    }
}
