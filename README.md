# LibftJava ☕

Mi primera biblioteca de utilidades en **Java**, inspirada en el clásico proyecto `libft` de la escuela 42. Este proyecto marca mi transición de la programación imperativa y de bajo nivel en **C** hacia la Programación Orientada a Objetos (POO) y la robustez de **Java**.

## 📌 Contenido del Proyecto

El proyecto está dividido en tres áreas clave de aprendizaje:

### 1. Manipulación de Strings (`FtStrings`)
Desarrollo de lógica carácter a carácter sin librerías externas:
* `ft_strlen`, `ft_split`, `ft_strjoin`, `ft_stoi` y `ft_itos`.

### 2. Algoritmia y Arrays (`FtArrays`)
* `ft_sort_int` (Ordenación manual Bubble/Insertion).
* `ft_search_int` (Búsqueda binaria eficiente).

### 3. Gestión de Memoria y Listas (`FtLinkedList` y `FtLists`)
* **Bajo Nivel:** Implementación de nuestra propia estructura de nodos (`nodeLists`) recreando los punteros de C (`ft_lstnew`, `ft_lstadd_back`, `ft_lstsize`, `ft_lstclear`).
* **Alto Nivel:** Dominio de la API nativa de Java (`ArrayList`, `Iterator`) y funciones de conversión (`ft_list_push_back`, `ft_list_remove_if`, `ft_list_to_array`).

## 🛠️ Compilación y Ejecución

Todo el proyecto está desarrollado en Java puro, sin dependencias externas.

Para compilar desde la terminal:
```bash
javac d00_Libft/*.java LibftJava.java
java LibftJava
```

