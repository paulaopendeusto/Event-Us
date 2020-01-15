# Proyecto Event Us

Este repositorio contiene el proyecto realizado por Paula Elosegui, Iñigo Peinado y Mayi Echeveste para la asignatura **Proceso de Software y Calidad**.
El proyecto consiste en un programa de gestión de eventos llamado Event Us. 

Mediante MySql se persisten todos los datos referentes a **eventos** y **espacios** donde se realizan estos eventos. Concretamente los espacios se componen de un *identificador único*, un *nombre*, una *ubicación*, una *capacidad* o *aforo* medida en número de personas y unos *recursos*. Por otro lado cada evento tiene también un *identificador único*, un *nombre*, una *tipología de evento*, un *precio*, unos *recursos*, una *fecha* y una *hora*. Además cada evento estará asociado a un *espacio* donde tendrá lugar.

Las **funcionalidades** principales de este programa son las siguientes:
1. Dar de alta, modificar, visualizar y eliminar espacios.
2. Dar de alta, modificar, visualizar y eliminar eventos.

Los requerimientos para poder usar la aplicación serán los siguientes:
1. Crear una base de datos en el servidor local llamada **eventus**
2. en la ruta "src/main/java/resources/datanucleus.properties" modificar el fichero:
  2.1 Linea 6 ConnectionUserName = "Nombre de usuario del localhost"
  2.2 Linea 7 ConnectionPassword = "Contraseña de localhost"
3. Disponer de maven instalado en el equipo, así como configurada en las variables de entorno.

Como **ejecutar** aplicación:
1. abrir el interprete de comandos en la raiz del proyecto (donde esta ubicado el fichero POM)
2. ejecutar la siguiente linea de comando que compilará el codigo fuente (mvn compile)
3. ejecutar la siguiente linea de comando para ejecutar el archivo compilado (mvn exec:java -Pclient)

Como ejecutar **tests**
1. abrir el interprete de comandos en la raiz del proyecto (donde esta ubicado el fichero POM)
2. ejectuar la siguiente linea de comando (mvn test)

Como generar documentación con **doxygen**
1. abrir el interprete de comandos en la raiz del proyecto (donde esta ubicado el fichero POM)
2. ejecutar la siguiente linea de comando(mvn doxygen:report)
