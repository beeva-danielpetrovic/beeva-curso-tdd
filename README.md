# beeva-curso-tdd

La idea práctica del curso es realizar un ejemplo completo mediante la metodología TDD.

## Enunciado del problema

Queremos simular el juego de Dardos 501. El juego debe cumplir las siguientes condiciones:

* El juego se inicia con una puntuación inicial de 501.
* Todos los numeros de la diana puntuan.
  * La puntuación puede ser:
    * Simple
    * Doble
    * Triple
* Inicialmente el turno corresponde al jugador uno de la partica y debe tener los tres dardos activos por lanzar.
* Una vez lanzados los tres dardos por el jugador uno, debe cambiar el turno al jugador dos y tener tres dardos activos por lanzar.
* Si la puntuación se queda en 1 se debe incrementar el turno, activar tres dardos más y volver a la puntuación anterior al ultimo lanzamiento.
* Si la puntuación restante se queda en negativo al dar a un numero mayor se debe incrementar el turno, activar tres dardos más y volver a la puntuación anterior al ultimo lanzamiento.
* Para cerrar el juego se debe cerrar la puntuación restante con un doble.

### Autores

* Daniel Petrovic Galvez - daniel.petrovic@beeva.com
* Manuel Durán López - manuel.duran@beeva.com
