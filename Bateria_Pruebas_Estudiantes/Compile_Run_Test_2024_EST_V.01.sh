#!/bin/bash
# === Mensaje bienvenida
echo Se va a compilar la practica 2023\/2024 con las dependencias y restricciones


# === Inputs ===
SRC_DIR=$PWD/src
BIN_DIR=/bin
MAIN=es/uned/lsi/eped/pract2023_2024/Main
JAVA_HOME_JDK=/usr/lib/jvm/default-java
TMP_FOLDER=$PWD/juego_de_pruebas_2024/tmp

if [ -z "$JAVA_HOME_JDK" ] 
    then
        if [ -z "$JAVA_HOME" ] 
            then 
	        echo Modifica la variable del archivo .sh JAVA_HOME_JDK 
	        read -rsp $'Press any key to continue...\n' -n 1 key
	        exit
	 else
	    JAVA_HOME_JDK="$JAVA_HOME"
	 fi
fi


# === Mostramos variables ===
echo Carpeta codigo = $SRC_DIR
echo Carpeta bin = $BIN_DIR
echo Clase principal = $MAIN
echo JAVA_HOME_JDK = $JAVA_HOME_JDK
echo  
echo 


# === Clean and make temp dir ===
echo Limpiando compilacion anterior
rm -rf "$TMP_FOLDER"
read -rsp $'Press any key to continue...\n' -n 1 key
echo Copiando archivos
if [ ! -e "$TMP_FOLDER" ]
    then
        mkdir "$TMP_FOLDER" 
fi 
mkdir "$TMP_FOLDER$BIN_DIR"
mkdir "$TMP_FOLDER/src"
mkdir "$TMP_FOLDER/src/es"
mkdir "$TMP_FOLDER/src/es/uned"
mkdir "$TMP_FOLDER/src/es/uned/lsi"
mkdir "$TMP_FOLDER/src/es/uned/lsi/eped"
mkdir "$TMP_FOLDER/src/es/uned/lsi/eped/pract2023_2024"
cp -r "$SRC_DIR/es/uned/lsi/eped/pract2023_2024/"* "$TMP_FOLDER/src/es/uned/lsi/eped/pract2023_2024"
#cp -v "juego_de_pruebas_2024/lib/src/"* "$TMP_FOLDER/src/es/uned/lsi/eped/pract2023_2024"
echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===


# ===========================================
# === Comprobacion uso TAD equipo docente ===
# ===========================================
echo Comprobando el uso de estructuras de datos del equipo docente
cd "$TMP_FOLDER/src/es/uned/lsi/eped/pract2023_2024"
grep "import" PlayBackQueue.java PlayList.java | grep -v "es.uned.lsi.eped.DataStructures"
cd "../../../../../../../../"
echo Si se muestra algun \"import\" en el mensaje anterior es posible que no se este haciendo uso de las estructuras de datos del equipo docente
echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===


# =============================
# === Compile ===
# =============================
echo Compilando en carpeta temporal
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/javac" -d "$TMP_FOLDER$BIN_DIR" -sourcepath "$TMP_FOLDER/src" -cp "juego_de_pruebas_2024/lib/TAD_modified.jar" "$TMP_FOLDER/src/"$MAIN".java"

"$JAVA_HOME_JDK/bin/javac" -d "$TMP_FOLDER$BIN_DIR" -sourcepath "$TMP_FOLDER/src" -cp "juego_de_pruebas_2024/lib/TAD_modified.jar" "$TMP_FOLDER/src/"$MAIN".java"

if [ $? -eq 1 ] 
    then
	echo Compilacion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Compilacion sin errores
echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===




# ==========================================================================================
# =============================
# === Run Prueba Estudiantes Basica ===
# =============================
echo Ejecutando el programa con prueba básica
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_1.tsv" 300  > "juego_de_pruebas_2024/salida/Salida_EST_1.dat"

"$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_1.tsv" 300  > "juego_de_pruebas_2024/salida/Salida_EST_1.dat"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Ejecucion sin errores
read -rsp $'Press any key to continue...\n' -n 1 key

# === Comprobacion Estudiantes Basica ===
echo Comprobando bateria de pruebas para prueba básica
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/salida/Salida_EST_1.dat" "juego_de_pruebas_2024/salida/Salida_1.dat" "errores_1.txt"

"$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_1.dat" "juego_de_pruebas_2024/salida/Salida_1.dat" "errores_1.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===



# ==========================================================================================
# =============================
# === Run Prueba Estudiantes 2 ===
# =============================
echo Ejecutando el programa con prueba 2
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_2.tsv" 1202345  > "juego_de_pruebas_2024/salida/Salida_EST_2.dat"

"$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_2.tsv" 1202345  > "juego_de_pruebas_2024/salida/Salida_EST_2.dat"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Ejecucion sin errores
read -rsp $'Press any key to continue...\n' -n 1 key

# === Comprobacion Estudiantes 2 ===
echo Comprobando bateria de pruebas para prueba 2
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/salida/Salida_EST_2.dat" "juego_de_pruebas_2024/salida/Salida_2.dat" "errores_2.txt"

"$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_2.dat" "juego_de_pruebas_2024/salida/Salida_2.dat" "errores_2.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===



# ==========================================================================================
# =============================
# === Run Prueba Estudiantes 3 ===
# =============================
echo Ejecutando el programa con prueba 3
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 1234  > "juego_de_pruebas_2024/salida/Salida_EST_3.dat"

"$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 1234  > "juego_de_pruebas_2024/salida/Salida_EST_3.dat"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Ejecucion sin errores
read -rsp $'Press any key to continue...\n' -n 1 key

# === Comprobacion Estudiantes 3 ===
echo Comprobando bateria de pruebas para prueba 3
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_3.dat" "juego_de_pruebas_2024/salida/Salida_3.dat" "errores_3.txt"

"$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_3.dat" "juego_de_pruebas_2024/salida/Salida_3.dat" "errores_3.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===


# ==========================================================================================
# =============================
# === Run Prueba Estudiantes 4 ===
# =============================
echo Ejecutando el programa con prueba 4
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 0  > "juego_de_pruebas_2024/salida/Salida_EST_4.dat"

"$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas_2024/lib/TAD_modified.jar" "$MAIN" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 0  > "juego_de_pruebas_2024/salida/Salida_EST_4.dat"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Ejecucion sin errores
read -rsp $'Press any key to continue...\n' -n 1 key

# === Comprobacion Estudiantes 4 ===
echo Comprobando bateria de pruebas para prueba 4
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_4.dat" "juego_de_pruebas_2024/salida/Salida_4.dat" "errores_4.txt"


"$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_4.dat" "juego_de_pruebas_2024/salida/Salida_4.dat" "errores_4.txt"


if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===
