package Principal;

public class ObjetoCompartido {

    // Variables
    private int numero;      
    private boolean acabo;   
    private int ganador;     

    public ObjetoCompartido(int numero) {
        this.numero = numero;
        this.acabo = false;
        this.ganador = -1;
    }

    public boolean seAcabo() {
        return acabo;
    }

    public int getGanador() {
        return ganador;
    }

    public synchronized String nuevaJugada(int jugador, int suNumero) {
        if (acabo) {
            return "El juego ya ha terminado. Ganador: Jugador " + ganador;
        }

        if (suNumero == numero) {
            acabo = true;
            ganador = jugador;
            return "Jugador " + jugador + " gana, adivinó el número: " + numero;
        } else if (suNumero < numero) {
            return "Jugador " + jugador + ": tu número es menor que el número a adivinar.";
        } else {
            return "Jugador " + jugador + ": tu número es mayor que el número a adivinar.";
        }
    }
}
