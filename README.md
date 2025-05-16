<h1 align="center"> Conversor de monedas </h1>
Este proyecto es una aplicación de consola desarrollada en Java que permite convertir entre diferentes monedas latinoamericanas y el dólar estadounidense, utilizando datos en tiempo real desde una API externa.

## Funcionalidades:
Convierte entre las siguientes monedas:
- Dólar Estadounidense (USD)
- Peso Argentino (ARS)
- Real Brasileño (BRL)
- Peso Colombiano (COP)

Consulta las tasas de cambio actualizadas desde la API de ExchangeRate

Menú interactivo para que el usuario elija el tipo de conversión

Conversión bidireccional (por ejemplo: de USD a ARS y de ARS a USD)

## Estructura del Proyecto
El proyecto está dividido en 3 clases para mantener una estructura clara y organizada:

1. Principal.java
Contiene el método main y la lógica del menú de usuario. Se encarga de:
Mostrar las opciones disponibles
Leer la elección del usuario
Invocar el método convertir(...) según corresponda

2. ConversorApp.java
Se encarga de:
Hacer una petición HTTP a la API de tasas de cambio
Parsear la respuesta JSON
Filtrar solo las monedas necesarias
Retornar un Map con los datos encapsulados en objetos Moneda

3. Moneda.java
Clase simple que representa una moneda con:
Código (por ejemplo, "USD")
Tasa de cambio respecto al USD
