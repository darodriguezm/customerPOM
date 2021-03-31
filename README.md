# Proyecto de automatización
## Selenium webdriver en java

## Detalles

Proyecto de prueba funcional automatizada que realiza la validación del cuadro de detalles de un producto aleatorio dentro de una categoría particular definida en el escenario de prueba del script del proyecto.

## Portal utilizado:
https://www.sodimac.cl/sodimac-cl/

## Tecnologías involucradas
| Tecnología | versión | url |
| ------ | ------ |------ |
| Java | 1.8 |  |
| Selenium | 4.14.0 |https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java|
|Testng|7.1.0|https://mvnrepository.com/artifact/org.testng/testng|
|Cucumber|1.2.5|https://mvnrepository.com/artifact/info.cukes/cucumber-java|
|cucumber-testng|1.2.5|https://mvnrepository.com/artifact/info.cukes/cucumber-testng|
|maven compiler|3.8.1|https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin|
|maven-surfire|2.22.2|https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-surefire-plugin|
|log4j|1.2.17|https://mvnrepository.com/artifact/log4j/log4j|

> archivo [pom.xml](https://github.com/darodriguezm/customerPOM/blob/main/pom.xml) de la solución

## Requisitos
Instalar cliente maven:
[Apache Maven 3.6.3](https://maven.apache.org/download.cgi)

## proceso de ejecución
1. Descargar respositorio
2. Ingresar a la ruta raíz del proyecto descargado y lanzar el comando:
```mvn test```
