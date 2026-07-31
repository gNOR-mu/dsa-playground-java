package utils;

import java.util.StringJoiner;

/**
 * Clase de utilidad para operaciones relacionadas con arreglos.
 */
public class ArrayUtils {

    /**
     * Obtiene la representación en cadena de un arreglo en formato de secuencia conectada.
     *
     * @param <T>   El tipo de dato de los elementos del arreglo.
     * @param nodes El arreglo con los elementos.
     * @return La representación en cadena del arreglo (ej: "1->2->null->4").
     */
    public static <T> String getStringRepresentation(T[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return "";
        }
        StringJoiner joiner = new StringJoiner("->");
        for (T node : nodes) {
            joiner.add(String.valueOf(node));
        }
        return joiner.toString();
    }
}
