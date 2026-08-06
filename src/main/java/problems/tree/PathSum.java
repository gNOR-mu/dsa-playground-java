package problems.tree;

import exceptions.NotImplementedException;
import structures.tree.BinaryTreeNode;

/**
 * Dado la raíz de un árbol binario y un número entero targetSum, devuelve true
 * si el árbol tiene un camino desde la raíz hasta una hoja tal que sumar todos
 * los valores a lo largo del camino sea igual a targetSum.
 *
 * <pre>
 * Ejemplo:
 *        5
 *       / \
 *      4   8
 *     /   / \
 *    11  13  4
 *   /  \      \
 *  7    2      1
 *
 * targetSum: 22
 * Camino: 5 -> 4 -> 11 -> 2 (Suma = 22)
 * Retorno: true
 * </pre>
 */
public class PathSum {

    /**
     * Resuelve el problema.
     *
     * @param root      La raíz del árbol binario.
     * @param targetSum La suma objetivo.
     * @return true si existe un camino raíz-a-hoja con la suma objetivo, false de
     *         lo contrario.
     * @implSpec Se permite y asume el comportamiento del desbordamiento (overflow) estándar 
     *           de enteros de 32 bits en Java al sumar los valores del camino.
     */
    public boolean solve(BinaryTreeNode<Integer> root, int targetSum) {
        throw new NotImplementedException();
    }
}
