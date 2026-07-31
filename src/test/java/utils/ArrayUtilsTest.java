package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

    @Test
    @DisplayName("getStringRepresentation para T[] debe retornar la cadena formateada")
    void shouldReturnCorrectStringRepresentationForArray() {
        Integer[] array = { 1, 2, null, 4 };
        assertEquals("1->2->null->4", ArrayUtils.getStringRepresentation(array));
    }

    @Test
    @DisplayName("getStringRepresentation para T[] debe retornar una cadena vacía cuando el arreglo es nulo o vacío")
    void shouldReturnEmptyStringWhenArrayIsNull() {
        assertEquals("", ArrayUtils.getStringRepresentation((Integer[]) null));
        assertEquals("", ArrayUtils.getStringRepresentation(new Integer[] {}));
    }
}
