package problems.tree;

import exceptions.NotImplementedException;
import structures.tree.BinaryTreeNode;

/**
 * Dado la raíz de un árbol binario y un número entero targetSum, devuelve true
 * si existe un camino entre dos nodos cualesquiera del árbol tal que la suma de todos
 * los valores a lo largo del camino sea igual a targetSum.
 *
 * El camino puede ir en cualquier dirección (no solo hacia abajo) a través de sus
 * conexiones de padre e hijo, pasando por el ancestro común más bajo si es necesario.
 * El camino debe ser un camino simple (no repetir nodos).
 *
 * <pre>
 * Ejemplo:
 *        1
 *       / \
 *      2   3
 *
 * targetSum: 6
 * Camino: 2 -> 1 -> 3 (Suma = 6)
 * Retorno: true
 * </pre>
 */
public class PathSum2 {

    /**
     * Resuelve el problema.
     *
     * @param root La raíz del árbol binario.
     * @param targetSum La suma objetivo.
     * @return true si existe algún camino entre dos nodos con la suma objetivo, false de lo contrario.
     * @implSpec Se permite y asume el comportamiento del desbordamiento (overflow) estándar 
     *           de enteros de 32 bits en Java al sumar los valores del camino.
     */
    public boolean solve(BinaryTreeNode<Integer> root, int targetSum) {
        throw new NotImplementedException();
    }
}
