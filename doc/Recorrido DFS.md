# Recorrido en Profundidad (DFS - Depth-First Search)

El recorrido en profundidad (DFS) es un algoritmo clásico de búsqueda y recorrido sobre estructuras de datos no lineales como árboles y grafos. Su premisa fundamental es **explorar lo más profundo posible** a lo largo de cada rama antes de retroceder (hacer *backtracking*).

En el contexto de árboles binarios, DFS se implementa comúnmente mediante recursión (aprovechando la pila de llamadas del sistema) o de forma iterativa (utilizando una estructura de datos `Stack`).

---

## Tipos de Recorrido DFS en Árboles Binarios

Dependiendo del orden en que se visita el nodo raíz con respecto a sus hijos izquierdo y derecho, existen tres variantes de DFS:

### 1. Pre-orden (Pre-order)
Se procesa el nodo actual y luego se visitan sus subárboles.
* **Orden:** Raíz $\rightarrow$ Izquierda $\rightarrow$ Derecha
* **Uso común:** Copiar o clonar un árbol, serializar la estructura.

### 2. In-orden (In-order)
Se procesa primero el subárbol izquierdo, luego el nodo actual y finalmente el subárbol derecho.
* **Orden:** Izquierda $\rightarrow$ Raíz $\rightarrow$ Derecha
* **Uso común:** En árboles binarios de búsqueda (BST), este recorrido devuelve los valores en **orden estrictamente creciente**.

### 3. Post-orden (Post-order)
Se procesan primero los subárboles y luego se procesa el nodo actual.
* **Orden:** Izquierda $\rightarrow$ Derecha $\rightarrow$ Raíz
* **Uso común:** Eliminar o liberar memoria de un árbol (ya que procesas los hijos antes que el padre), evaluar expresiones aritméticas en árboles de expresión.

---

## Ejemplo Práctico

Dado el siguiente árbol binario:

```
        1
       / \
      2   3
     / \
    4   5
```

Los recorridos producirían los siguientes resultados:

* **Pre-orden:** `[1, 2, 4, 5, 3]`
* **In-orden:** `[4, 2, 5, 1, 3]`
* **Post-orden:** `[4, 5, 2, 3, 1]`

---

## Implementación Básica en Java (Recursiva)

A continuación se muestra una plantilla típica de DFS para los tres tipos de recorridos utilizando un método auxiliar acumulador:

```java
public class TreeTraversal {

    // 1. Pre-orden
    public <T> void preOrder(BinaryTreeNode<T> node, List<T> result) {
        if (node == null) return;
        
        result.add(node.getVal());            // Procesar Raíz
        preOrder(node.getLeft(), result);     // Visitar Izquierda
        preOrder(node.getRight(), result);    // Visitar Derecha
    }

    // 2. In-orden
    public <T> void inOrder(BinaryTreeNode<T> node, List<T> result) {
        if (node == null) return;
        
        inOrder(node.getLeft(), result);      // Visitar Izquierda
        result.add(node.getVal());            // Procesar Raíz
        inOrder(node.getRight(), result);     // Visitar Derecha
    }

    // 3. Post-orden
    public <T> void postOrder(BinaryTreeNode<T> node, List<T> result) {
        if (node == null) return;
        
        postOrder(node.getLeft(), result);     // Visitar Izquierda
        postOrder(node.getRight(), result);    // Visitar Derecha
        result.add(node.getVal());             // Procesar Raíz
    }
}
```

---

## Complejidad

* **Complejidad Temporal:** $O(N)$, donde $N$ es el número de nodos del árbol, ya que cada nodo es visitado exactamente una vez.
* **Complejidad Espacial:** $O(H)$, donde $H$ es la altura del árbol (en el peor caso $O(N)$ para árboles degenerados/tipo lista, y en el mejor caso $O(\log N)$ para árboles perfectamente balanceados). Este espacio corresponde a la memoria consumida por la pila de llamadas (*call stack*) de la recursión.
