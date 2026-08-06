package problems.tree;

import java.util.ArrayList;
import java.util.List;
import structures.tree.BinaryTreeNode;

/**
 * Dada la raíz de un árbol binario, retorna el recorrido en in-orden de los valores de sus nodos.
 * (Izquierda -> Raíz -> Derecha)
 *
 * <pre>
 * Ejemplo:
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *
 * Recorrido In-orden: [4, 2, 5, 1, 3]
 * </pre>
 */
public class InOrderTraversal {

    /**
     * Resuelve el problema.
     *
     * @param <T> El tipo de dato almacenado en el árbol.
     * @param root La raíz del árbol binario.
     * @return Una lista con los valores del recorrido en in-orden.
     * @implNote Utiliza dfs para resolver el problema
     */
    public <T> List<T> solve(BinaryTreeNode<T> root) {
        List<T> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    /**
     * Utiliza dfs de forma recursiva añadiendo el valor actual una vez que ha
     * recorrido todos los nodos izquierdos
     * 
     * @param <T>  El tipo de dato almacenado en el árbol
     * @param node Nodo del árbol
     * @param list Lista auxiliar que contiene los valores
     */
    private <T> void dfs(BinaryTreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        dfs(node.getLeft(), list);
        list.add(node.getVal());
        dfs(node.getRight(), list);
    }
}
