package problems.tree;

import java.util.ArrayList;
import java.util.List;
import structures.tree.BinaryTreeNode;

/**
 * Dada la raíz de un árbol binario, retorna el recorrido en post-orden de los valores de sus nodos.
 * (Izquierda -> Derecha -> Raíz)
 *
 * <pre>
 * Ejemplo:
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *
 * Recorrido Post-orden: [4, 5, 2, 3, 1]
 * </pre>
 */
public class PostOrderTraversal {

    /**
     * Resuelve el problema.
     *
     * @param <T> El tipo de dato almacenado en el árbol.
     * @param root La raíz del árbol binario.
     * @return Una lista con los valores del recorrido en post-orden.
     * @implNote Utiliza dfs para resolver el problema
     */
    public <T> List<T> solve(BinaryTreeNode<T> root) {
        List<T> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    /**
     * Utiliza dfs de forma recursiva añadiendo el valor actual una vez que ha
     * recorrido todos los nodos derechos
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
        dfs(node.getRight(), list);
        list.add(node.getVal());
    }
}
