package problems.tree;

import exceptions.NotImplementedException;
import structures.tree.BinaryTreeNode;

/**
 * Determina si un árbol binario es un Árbol Binario de Búsqueda (BST) válido y estricto.
 *
 * Un BST válido se define de la siguiente manera:
 * <ul>
 *   <li>El subárbol izquierdo de un nodo contiene solo nodos con valores estrictamente menores que el valor del nodo.</li>
 *   <li>El subárbol derecho de un nodo contiene solo nodos con valores estrictamente mayores que el valor del nodo.</li>
 *   <li>Tanto el subárbol izquierdo como el derecho también deben ser árboles binarios de búsqueda.</li>
 * </ul>
 *
 * <pre>
 * Ejemplo 1:
 *        2
 *       / \
 *      1   3
 *
 * Retorno: true
 *
 * Ejemplo 2:
 *        5
 *       / \
 *      1   4
 *         / \
 *        3   6
 *
 * Retorno: false (el nodo con valor 4 tiene un subárbol derecho, pero el valor 3 no es mayor que 5)
 * </pre>
 */
public class ValidateBST {

    /**
     * Resuelve el problema.
     *
     * @param root La raíz del árbol binario.
     * @return true si el árbol es un BST válido, false de lo contrario.
     */
    public boolean solve(BinaryTreeNode<Integer> root) {
        throw new NotImplementedException();
    }
}
