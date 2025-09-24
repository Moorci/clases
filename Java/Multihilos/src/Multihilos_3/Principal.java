package Multihilos_3;

public class Principal {
    public static void main(String[] args) {
        Escritora hiloNumeros = new Escritora(true);
        Escritora hiloLetras = new Escritora(false);

        hiloNumeros.start();
        hiloLetras.start();
    }
}
