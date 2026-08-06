package problems.tree;

import java.util.ArrayList;
import java.util.List;

import structures.tree.BinaryTreeNode;

/**
 * Solución propuesta de {@link PreOrderTraversalSol}
 */
public class PreOrderTraversalSol extends PreOrderTraversal {

    /**
     * {@inheritDoc}
     * 
     * @implNote Utiliza dfs para resolver el problema
     */
    @Override
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
        list.add(node.getVal());
        dfs(node.getLeft(), list);
        dfs(node.getRight(), list);
    }

}
