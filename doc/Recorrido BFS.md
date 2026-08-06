# Recorrido en Anchura (BFS - Breadth-First Search)

El recorrido en anchura (BFS), también conocido en el contexto de árboles binarios como **Recorrido por Niveles (Level-Order Traversal)**, es un algoritmo fundamental para explorar o buscar elementos en estructuras no lineales como árboles y grafos.

A diferencia de DFS (que avanza hacia lo profundo de una rama antes de retroceder), BFS explora de forma horizontal: **visita todos los nodos de un nivel actual antes de pasar a los nodos del siguiente nivel**.

---

## Concepto y Estructura

En árboles binarios, el recorrido comienza en la raíz (Nivel 0), luego visita todos los nodos del Nivel 1 (de izquierda a derecha), luego todos los del Nivel 2, y así sucesivamente.

Dado que la exploración requiere recordar los hijos de los nodos visitados para procesarlos en el orden correcto (Primero en Entrar, Primero en Salir), BFS se implementa de manera natural de forma iterativa utilizando una **Cola (Queue)**.

---

## Ejemplo Práctico

Dado el siguiente árbol binario:

```text
        1          <- Nivel 0
       / \
      2   3        <- Nivel 1
     / \
    4   5          <- Nivel 2
```

El recorrido BFS produce el siguiente resultado plano:
`[1, 2, 3, 4, 5]`

Si agrupamos el recorrido por niveles individuales (como es común en muchos problemas de algoritmos):
`[[1], [2, 3], [4, 5]]`

---

## Implementación en Java

A continuación se muestra la plantilla estándar en Java utilizando `java.util.Queue` y `java.util.ArrayDeque` para procesar el árbol nivel por nivel:

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import structures.tree.BinaryTreeNode;

public class TreeBFS {

    /**
     * Recorre un árbol binario nivel por nivel.
     *
     * @param <T>  El tipo de dato almacenado en el árbol.
     * @param root La raíz del árbol binario.
     * @return Una lista de listas conteniendo los valores agrupados por nivel.
     */
    public <T> List<List<T>> levelOrder(BinaryTreeNode<T> root) {
        List<List<T>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Cantidad de nodos en el nivel actual
            List<T> currentLevelValues = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<T> currentNode = queue.poll();
                currentLevelValues.add(currentNode.getVal());

                // Encolar hijos de izquierda a derecha para el siguiente nivel
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }

            result.add(currentLevelValues);
        }

        return result;
    }
}
```

---

## Usos Comunes de BFS

- **Camino más corto**: En grafos y árboles no ponderados, BFS garantiza encontrar la ruta más corta (con menos aristas) desde la raíz a cualquier otro nodo.
- **Serialización y Deserialización**: BFS es la estrategia estándar para convertir un árbol binario en un arreglo lineal y viceversa (por ejemplo, el formato BFS con representación de nulos usado en `utils.TreeUtils`).
- **Problemas por niveles**: Encontrar el valor promedio por nivel, el nodo con el valor más grande de cada nivel, o realizar una vista de perfil (Right/Left side view) del árbol.

---

## Complejidad

- **Complejidad Temporal:** $\mathcal{O}(N)$, donde $N$ es el número de nodos del árbol. Cada nodo entra y sale de la cola exactamente una vez.
- **Complejidad Espacial:** $\mathcal{O}(W)$, donde $W$ es el ancho máximo del árbol (el número máximo de nodos en un solo nivel). En el peor caso (un árbol binario completo y balanceado), el último nivel contiene aproximadamente $\lceil N/2 \rceil$ nodos, lo que resulta en una complejidad espacial de $\mathcal{O}(N)$ en el peor de los casos.
