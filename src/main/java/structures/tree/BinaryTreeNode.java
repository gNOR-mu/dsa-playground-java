package structures.tree;

import lombok.*;

/**
 * Clase que representa un nodo en una estructura de árbol binario.
 * Cada nodo almacena un valor de tipo genérico y mantiene referencias a sus
 * nodos hijos izquierdo y derecho.
 *
 * @param <T> El tipo de dato que almacena el nodo.
 */
@Data
@NoArgsConstructor
public class BinaryTreeNode<T> {

    /** Valor almacenado en el nodo */
    private T val;

    /** Nodo hijo izquierdo */
    private BinaryTreeNode<T> left;

    /** Nodo hijo derecho */
    private BinaryTreeNode<T> right;

    /**
     * Construye un nuevo nodo estableciendo su valor. Tanto el nodo hijo izquierdo
     * como el derecho se inicializan como nulos.
     * 
     * @param val El valor del nodo.
     */
    public BinaryTreeNode(T val) {
        this.val = val;
    }

    /**
     * Construye un nuevo nodo estableciendo su valor y los nodos hijos.
     * 
     * @param val   El valor del nodo.
     * @param left  El nodo hijo izquierdo. Puede ser nulo.
     * @param right El nodo hijo derecho. Puede ser nulo.
     */
    public BinaryTreeNode(T val, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
