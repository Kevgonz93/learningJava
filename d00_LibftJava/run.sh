#!/bin/bash

CARPETA_PROYECTO=$(pwd)

echo "Compilando..."

cd ..

javac d00_LibftJava/d00_Libft/*.java d00_LibftJava/LibftJava.java

if [ $? -eq 0 ]; then
    echo "Ejecutando la suite de pruebas..."
    echo "--------------------------------------"
    # -cp es para que busque el package desde la raiz del repo
    java -cp .:d00_LibftJava d00_LibftJava.LibftJava
    echo "--------------------------------------"
else
    echo "❌ Error de compilación. Abortando ejecución."
fi

find . -name "*.class" -delete

cd $CARPETA_PROYECTO
echo "¡Listo!"