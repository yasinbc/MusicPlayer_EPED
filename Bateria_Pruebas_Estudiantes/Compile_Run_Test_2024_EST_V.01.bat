@echo off

REM === Mensaje bienvenida
echo Se va a compilar la practica 2023/2024 con las dependencias y restricciones


REM === Inputs ===
set SRC_DIR=%cd%\src
set BIN_DIR=\bin
set MAIN=es/uned/lsi/eped/pract2023_2024/Main
set JAVA_HOME_JDK=""
set TMP_FOLDER=%cd%\juego_de_pruebas_2024\tmp

IF %JAVA_HOME_JDK%=="" (

	IF "%JAVA_HOME%" == "" (
	    echo Modifica la variable del archivo bat JAVA_HOME_JDK 
	    pause
	    exit
	) ELSE (
	    set JAVA_HOME_JDK="%JAVA_HOME%"
	)
)


REM === Mostramos variables ===
echo Carpeta codigo = %SRC_DIR%
echo Carpeta bin = %BIN_DIR%
echo Clase principal = %MAIN%
echo JAVA_HOME_JDK = %JAVA_HOME_JDK%
echo. 
echo.


REM === Clean and make temp dir ===
echo Limpiando compilacion anterior 
rd /q /s "%TMP_FOLDER%"
pause
if not exist "%TMP_FOLDER%" mkdir "%TMP_FOLDER%" 
mkdir "%TMP_FOLDER%%BIN_DIR%"
mkdir "%TMP_FOLDER%\src"
mkdir "%TMP_FOLDER%\src\es"
mkdir "%TMP_FOLDER%\src\es\uned"
mkdir "%TMP_FOLDER%\src\es\uned\lsi"
mkdir "%TMP_FOLDER%\src\es\uned\lsi\eped"
mkdir "%TMP_FOLDER%\src\es\uned\lsi\eped\pract2023_2024"
xcopy /s/q "%SRC_DIR%\es\uned\lsi\eped\pract2023_2024" "%TMP_FOLDER%\src\es\uned\lsi\eped\pract2023_2024"
REM xcopy /s/y/q "juego_de_pruebas_2024\lib\src" "%TMP_FOLDER%\src\es\uned\lsi\eped\pract2023_2024"

echo.
echo.
pause


REM ===

REM ===========================================
REM === Comprobacion uso TAD equipo docente ===
REM ===========================================
echo Comprobando el uso de estructuras de datos del equipo docente
cd "%TMP_FOLDER%\src\es\uned\lsi\eped\pract2023_2024"
find "import" PlayBackQueue.java PlayList.java | find /v "es.uned.lsi.eped.DataStructures"
cd "../../../../../../../../"
echo Si se muestra algun "import" en el mensaje anterior es posible que no se este haciendo uso de las estructuras de datos del equipo docente
echo. 
echo.
pause


REM ===

REM ===============
REM === Compile ===
REM ===============
echo Compilando en carpeta temporal
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\javac" -d "%TMP_FOLDER%%BIN_DIR%" -sourcepath "%TMP_FOLDER%\src" -cp "juego_de_pruebas_2024/lib/TAD_modified.jar" "%TMP_FOLDER%\src\%MAIN%.java"

%JAVA_HOME_JDK%"\bin\javac" -d "%TMP_FOLDER%%BIN_DIR%" -sourcepath "%TMP_FOLDER%\src" -cp "juego_de_pruebas_2024/lib/TAD_modified.jar" "%TMP_FOLDER%\src\%MAIN%.java"
if errorlevel 1 (
	echo Compilacion con errores
	pause
	exit /B 1
)

echo Compilacion sin errores
echo.
echo.
pause


REM =============================
REM === Run Prueba Estudiantes Basica ===
REM =============================
echo Ejecutando el programa con prueba básica
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_1.tsv" 300  > "juego_de_pruebas_2024/salida/Salida_EST_1.dat"

%JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_1.tsv" 300  > "juego_de_pruebas_2024/salida/Salida_EST_1.dat"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)

echo Ejecucion sin errores
echo. 
echo.
pause


REM === Comprobacion Estudiantes Basica ===
echo Comprobando bateria de pruebas para prueba básica
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_1.dat" "juego_de_pruebas_2024/salida/Salida_1.dat" "errores_1.txt"

%JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_1.dat" "juego_de_pruebas_2024/salida/Salida_1.dat" "errores_1.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)
echo. 
echo.
pause


REM ==============================================================================



REM =============================
REM === Run Prueba Estudiantes 2 ===
REM =============================
echo Ejecutando el programa con prueba 2
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_2.tsv" 1202345  > "juego_de_pruebas_2024/salida/Salida_EST_2.dat"

%JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_2.tsv" 1202345  > "juego_de_pruebas_2024/salida/Salida_EST_2.dat"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)

echo Ejecucion sin errores
echo. 
echo.
pause


REM === Comprobacion Estudiantes Prueba 2 ===
echo Comprobando bateria de pruebas 2
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_2.dat" "juego_de_pruebas_2024/salida/Salida_2.dat" "errores_2.txt"

%JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_2.dat" "juego_de_pruebas_2024/salida/Salida_2.dat" "errores_2.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)
echo. 
echo.
pause


REM ==============================================================================


REM =============================
REM === Run Prueba Estudiantes 3 ===
REM =============================
echo Ejecutando el programa con prueba 3
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 1234  > "juego_de_pruebas_2024/salida/Salida_EST_3.dat"

%JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 1234  > "juego_de_pruebas_2024/salida/Salida_EST_3.dat"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)

echo Ejecucion sin errores
echo. 
echo.
pause


REM === Comprobacion Estudiantes Prueba 3 ===
echo Comprobando bateria de pruebas 3
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_3.dat" "juego_de_pruebas_2024/salida/Salida_3.dat" "errores_3.txt"

%JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_3.dat" "juego_de_pruebas_2024/salida/Salida_3.dat" "errores_3.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)
echo. 
echo.
pause


REM ==============================================================================

REM ==============================================================================


REM =============================
REM === Run Prueba Estudiantes 4 ===
REM =============================
echo Ejecutando el programa con prueba 4
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 0  > "juego_de_pruebas_2024/salida/Salida_EST_4.dat"

%JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas_2024/lib/TAD_modified.jar" "%MAIN%" "juego_de_pruebas_2024/pruebas/Repository.tsv" "juego_de_pruebas_2024/pruebas/JuegoPruebas_EST_3.tsv" 0  > "juego_de_pruebas_2024/salida/Salida_EST_4.dat"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)

echo Ejecucion sin errores
echo. 
echo.
pause


REM === Comprobacion Estudiantes Prueba 4 ===
echo Comprobando bateria de pruebas 4
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_4.dat" "juego_de_pruebas_2024/salida/Salida_4.dat" "errores_4.txt"

%JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas_2024/lib/Comparator.jar" "juego_de_pruebas_2024/salida/Salida_EST_4.dat" "juego_de_pruebas_2024/salida/Salida_4.dat" "errores_4.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)
echo. 
echo.
pause


REM ==============================================================================
