# beeva-curso-tdd

La idea práctica del curso es realizar un ejemplo completo mediante la metodología TDD.

### Consideraciones

* La partida es de un solo jugador y no existe limite de turnos para finalizar la misma.

## Enunciado del problema

Queremos simular el juego de Dardos 501. El juego debe cumplir las siguientes condiciones:

* El juego se inicia con una puntuación inicial de 501.
* Todos los numeros de la diana puntuan.
  * La puntuación puede ser:
    * Simple
    * Doble
    * Triple
* Inicialmente el turno de la partida empieza por uno y deben estar los tres dardos activos.
* Una vez lanzados los tres dardos en un turno, debe incrementarse el turno y actiar de nuevo los tres dardos.
* Si la puntuación restante llegara a uno se debe incrementar el turno, activar los tres dardos y volver a la puntuación anterior al turno.
* Si la puntuación quedara en negativo al superar la puntuación restante se debe incrementar el turno, activar tres dardos y volver a la puntuación anterior al turno.
* Para cerrar el juego se debe cerrar la puntuación restante con un doble. Entonces la partida quedará finalizada, el turno empezará en uno y se activaran los tres dardos para el comienzo de otra partida.

### Autores

* Daniel Petrovic Galvez - daniel.petrovic@beeva.com
* Manuel Durán López - manuel.duran@beeva.com

### Vídeo

[Práctica Darts](https://drive.google.com/a/beeva.com/file/d/0B1joOb8Uxlk_dzJuMTN1Sld2T28/view)
