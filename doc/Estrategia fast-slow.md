# Estrategia Fast-Slow (Punteros Rápidos y Lentos)

La estrategia **Fast-Slow** (también conocida como el algoritmo de la liebre y la tortuga de Floyd) es un patrón de diseño algorítmico que utiliza dos punteros que recorren una estructura de datos lineal (como una lista enlazada o un arreglo) a **diferentes velocidades**.

---

## ¿Cómo se usa?

Se inicializan dos punteros en la cabeza (`head`) de la lista:
1. **Slow (Lento):** Avanza un nodo a la vez (`slow = slow.next`).
2. **Fast (Rápido):** Avanza dos nodos a la vez (`fast = fast.next.next`).

### Plantilla básica en Java:
```java
ListNode<T> slow = head;
ListNode<T> fast = head;

while (fast != null && fast.getNext() != null) {
    slow = slow.getNext();             // 1 paso
    fast = fast.getNext().getNext();   // 2 pasos
}
```

---

## ¿Para qué sirve?

Este enfoque es sumamente eficiente porque nos permite resolver problemas complejos en **una sola pasada ($O(N)$)** y con **espacio constante ($O(1)$)**, sin necesidad de almacenar los nodos visitados en una estructura auxiliar como un `Set` o una lista.

Sus principales aplicaciones son:

### 1. Encontrar el punto medio de una lista enlazada
Como el puntero `fast` se desplaza al doble de velocidad que `slow`, cuando `fast` llegue al final de la lista, el puntero `slow` estará exactamente en la **mitad** de ella.
* **Lista impar (1 -> 2 -> 3 -> 4 -> 5):** `slow` terminará en `3` (el centro exacto).
* **Lista par (1 -> 2 -> 3 -> 4):** `slow` terminará en `3` (el segundo del centro, que suele ser el esperado en problemas tipo LeetCode).

### 2. Detección de ciclos
Determina si una lista tiene un ciclo (un bucle infinito donde un nodo apunta a un nodo anterior).

### 3. Encontrar el inicio de un ciclo
Si hay un ciclo, permite identificar con precisión cuál es el nodo donde comienza dicho ciclo.

---

## ¿Cómo ayuda a detectar ciclos?

Si una lista enlazada no tiene ciclos, el puntero rápido (`fast`) eventualmente llegará al final (`null`) y el bucle terminará. 

Sin embargo, **si existe un ciclo**, ambos punteros entrarán en el bucle y darán vueltas indefinidamente. Dado que el puntero `fast` se mueve más rápido, la distancia relativa entre ambos disminuye en $1$ en cada iteración. Tarde o temprano, **el puntero rápido alcanzará y se cruzará con el puntero lento** (`slow == fast`).

### Analogía física:
Imagina dos corredores en una pista de atletismo circular. Si uno corre al doble de velocidad que el otro, eventualmente el corredor más rápido le sacará una vuelta de ventaja al lento y se cruzarán en el mismo punto de la pista.

### Algoritmo de detección de ciclos:
```java
public boolean hasCycle(ListNode<T> head) {
    ListNode<T> slow = head;
    ListNode<T> fast = head;

    while (fast != null && fast.getNext() != null) {
        slow = slow.getNext();
        fast = fast.getNext().getNext();

        // Si se encuentran, hay un ciclo
        if (slow == fast) {
            return true; 
        }
    }
    return false; // Llegó al final, no hay ciclo
}
```

---

## ¿Cómo encontrar el inicio del ciclo?

Una vez que se ha detectado el ciclo (es decir, `slow == fast`), podemos encontrar el nodo de inicio del ciclo siguiendo estos pasos matemáticos de Floyd:

1. Deja uno de los punteros (por ejemplo, `slow`) en el punto de encuentro.
2. Mueve el otro puntero (por ejemplo, `fast`) de vuelta al inicio de la lista (`head`).
3. Avanza **ambos** punteros a la misma velocidad (un paso a la vez: `slow = slow.next` y `fast = fast.next`).
4. El punto donde se vuelvan a encontrar es el **nodo de inicio del ciclo**.

### Código para encontrar el inicio del ciclo:
```java
public ListNode<T> detectCycleStart(ListNode<T> head) {
    ListNode<T> slow = head;
    ListNode<T> fast = head;
    boolean hasCycle = false;

    // Paso 1: Detectar el ciclo
    while (fast != null && fast.getNext() != null) {
        slow = slow.getNext();
        fast = fast.getNext().getNext();
        if (slow == fast) {
            hasCycle = true;
            break;
        }
    }

    if (!hasCycle) {
        return null; // No hay ciclo
    }

    // Paso 2: Encontrar el inicio
    fast = head; // Mover fast al inicio
    while (slow != fast) {
        slow = slow.getNext();
        fast = fast.getNext(); // Ambos se mueven a velocidad 1
    }

    return slow; // O fast, ambos apuntan al inicio del ciclo
}
```


## Más info en [How does Floyd's slow and fast pointers approach work?](https://www.geeksforgeeks.org/dsa/how-does-floyds-slow-and-fast-pointers-approach-work/)