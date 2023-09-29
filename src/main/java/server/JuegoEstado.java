package server;

/**
 * Enumeración que representa los estados posibles del juego.
 * Los estados son:
 *  - enEspera: El juego está en espera de clientes para conectarse.
 *  - iniciado: El juego ha comenzado y los clientes están jugando.
 *  - finalizado: El juego ha finalizado.
 */
public enum JuegoEstado {
    enEspera,
    iniciado,
    finalizado,

}
