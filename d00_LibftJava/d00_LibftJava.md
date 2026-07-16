# PROYECTO 00 | libft_java: Los Fundamentos del Lenguaje y Estructuras de Datos

---

### 1. Introducción al Concepto

Con la filosofía de 42 aprendimos que antes de correr hay que aprender a andar.Java es un lenguaje fuertemente tipado, estructurado y gestionado por una Máquina Virtual (JVM). En este proyecto inicial, dejaremos de lado la gestión manual de memoria (malloc/free) para enfocarnos en dos áreas fundamentales: el control estricto de estructuras de datos fijas y la transición a la gestión dinámica de memoria gestionada por la máquina.

* **Fase Estática:** Dominar las estructuras de control nativas, el manejo de arrays fijos y la robustez del código mediante la captura y gestión de excepciones. Comprenderemos cómo compila Java, qué significa la palabra clave 'static' y cómo interactuar con el sistema a través de la terminal sin depender de la inmensa biblioteca estándar de utilidades.
* **Fase Dinámica:** Recrear la lógica de punteros de C mediante referencias y dar el salto a las colecciones dinámicas nativas de Java, comprendiendo cómo la JVM gestiona la memoria de forma automática y segura a través de su recolector de basura (Garbage Collector).

---

### 2. Especificaciones Obligatorias

Debe compilarse usando 'javac' y ejecutarse con 'java' desde la línea de comandos.

* **Estructura obligatoria:** Crear una clase principal llamada 'LibftJava' con un método 'public static void main(String[] args)' que sirva como suite de pruebas internas.
* **Clase 'FtStrings':** Implementar las siguientes funciones propias carácter a carácter: 'ft_strlen', 'ft_split', 'ft_strjoin', 'ft_stoi' (String a Integer) y 'ft_itos' (Integer a String).
* **Clase 'FtArrays':** Implementar las funciones de algoritmia lineal: 'ft_sort_int' (algoritmo de ordenación manual) y 'ft_search_int' (búsqueda binaria).
* **Clase 'nodeLists' (Estructura de Nodo):** Crear una clase de objeto propia que actúe como nodo de lista enlazada para simular el comportamiento de los punteros en C. Debe contener una variable entera `content` y una referencia al siguiente nodo `next`.
* **Clase 'FtLinkedLists' (Listas de Bajo Nivel):** Implementar las siguientes funciones de manipulación manual de nodos:
  * `ft_lstnew(int content)`: Inicializa y retorna un nuevo nodo.
  * `ft_lstadd_back(nodeLists head, nodeLists new_node)`: Añade un nodo al final de la lista enlazada.
  * `ft_lstsize(nodeLists head)`: Cuenta y retorna el número de elementos de la lista.
  * `ft_lstclear(nodeLists head)`: Vacía la lista y delega la liberación de los recursos de memoria en el Garbage Collector de la JVM.
* **Clase 'FtLists' (Colecciones de Alto Nivel):** Implementar utilidades utilizando las herramientas nativas de la API de colecciones de Java (`List<Integer>`):
  * `ft_list_push_back(List<Integer> list, int value)`: Añade un elemento al final de la lista.
  * `ft_list_remove_if(List<Integer> list, int target)`: Busca y elimina de forma segura todas las ocurrencias del valor objetivo en la lista en caliente.
  * `ft_list_to_array(List<Integer> list)`: Convierte la lista dinámica a un array nativo clásico de enteros primitivos (`int[]`).

> ⚠️ **Manejo de Errores y Excepciones Obligatorias:**
> * Si un método recibe un input inválido (ej. null o un formato numérico incorrecto), debe capturar la anomalía y lanzar una excepción adecuada sin romper la ejecución del programa completo.
> * **La Excepción de Concurrencia:** En `ft_list_remove_if`, intentar modificar el tamaño de la lista de forma directa mientras se recorre con un bucle clásico o *for-each* romperá el programa lanzando una excepción `ConcurrentModificationException`. **Es obligatorio** gestionar este recorrido de manera explícita utilizando la interfaz **`Iterator`** de Java para garantizar una eliminación en caliente segura y libre de crashes.

---

### 3. Restrictions y Prohibiciones

* **Para 'FtStrings' y 'FtArrays':** Prohibido el uso de la clase 'java.util.Arrays' o cualquier tipo de lista dinámica ('ArrayList', 'LinkedList'). Prohibido el uso de métodos nativos de String avanzados como 'String.split()', 'String.join()' o 'Integer.parseInt()'. Todo debe ser parseado carácter a carácter.
* **Para 'FtLists':** Queda estrictamente prohibido el uso de cualquier librería externa o de terceros (Maven, Gradle, etc.). Solo se permite el uso de la API estándar de colecciones nativas de Java (`java.util.List`, `java.util.ArrayList`, `java.util.Iterator`).Todo el código debe ser Java puro y nativo.

---

### 4. Evaluación de la IA

La Moulinette no existe fuera de 42. Por lo que nos ayudaremos de la IA para la evaluación del proyecto. Para ello se deberá darle las indicaciones redactadas anteriormente, y pedirle que ejecute las pruebas unitarias que considere.

Si la IA te sugiere optimización de código, no tendrá valor negativo de cara a la evaluación. No obstante, un error funcional o crash será motivo de suspensión de la misma.

---

### 5. Resumen del Aprendizaje

Este proyecto tiende el puente definitivo de C a Java. Al finalizar, entenderemos:
* La sintaxis básica, el comportamiento de las referencias frente a primitivos y la estructura de archivos, paquetes e importaciones en Java.
* El ciclo de vida de los objetos en memoria y el funcionamiento del Garbage Collector.
* El patrón de diseño **Iterator** para la manipulación segura de flujos de datos y colecciones dinámicas sin errores de concurrencia.