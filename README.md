# dsa playground java

Proyecto personal creado para practicar problemas relacionados con estructuras de datos en Java.

# Requerimientos

- Java: JDK 25
- Maven (opcional), se incluye el wrapper
  
# Problemas

Cada problema se encuentra agrupado respecto a su respectiva estructura de datos (dsa), en donde la documentación de la clase corresponde a su respectivo problema y la documentación del método **solver** respecto a cómo se implementa.

Las soluciones de cada problema se implementan directamente en la misma clase del problema (dentro del método `solve`).

Cada problema tiene test para validarlo, en caso de que no se haya implementado una solución (y por ende lance `NotImplementedException`), se omite el test al verificar **UnsupportedOperationException** antes de cada test.

# Rutas

```text
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───problems    # Problemas propuestos
│   │   │   ├───structures  # Distintos tipos de dsa
│   │   │   └───utils       # Utilidades generales
│   └───test                # pruebas
```

### - Se ha añadido una carpeta **doc** con documentación sobre algoritmos/estrategias útiles.

# Pruebas

```shell
# Todos los tests
mvn test
```

```shell
# Ejecutar test específico
mvn test -Dtest="TestNombreClase" -DfailIfNoTests=false

# Ej: mvn test -Dtest="InvertListNodeTest" -DfailIfNoTests=false
```
