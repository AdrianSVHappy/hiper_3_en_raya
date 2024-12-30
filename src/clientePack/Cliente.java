package clientePack;

import redPack.ClienteMain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Cliente.java</h1><hr>
 * <p>Esta clase represanta el main del cliente</p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 27-dic-2024
 */
public class Cliente {

    private Vista vistaPrincipal;
    private ClienteMain red;
    private String mensaje;

    static Scanner sc = new Scanner(System.in);

    public Cliente(String ipServer, int portServer) {
        this.vistaPrincipal = new Vista(this);
        this.vistaPrincipal.setVisible(true);
        this.red = new ClienteMain(ipServer, portServer);
    }

    public Vista getVistaPrincipal() {
        return vistaPrincipal;
    }

    public void setVistaPrincipal(Vista vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }

    public ClienteMain getRed() {
        return red;
    }

    public void setRed(ClienteMain red) {
        this.red = red;
    }

    /*
    public static void main(String[] args) {

        Thread esperar;
        vistaPrincipal.setVisible(true);

        //Hilo temporal, para probar que el controlador y los turnos funcionan correctamente
        esperar = new Thread(() -> {

            int posicion;

            while (true) {
                if(!vistaPrincipal.isTurno()){
                    System.out.print("\nC -> ");
                    posicion = Integer.parseInt(sc.nextLine());

                    if (vistaPrincipal.ocupar(posicion, new Ficha('O'))) {
                        System.out.println("C;O;" + posicion);
                        System.out.println("Turno del jugador");
                        vistaPrincipal.setTurno(true);
                    }
                }else {
                    try {
                        Thread.sleep(1000);
                        System.out.print(".");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        esperar.start();
    }
*/

    /**
     * Función que traduce la posición a comando, para enviarla al servidor
     * @param pos posición pulsada en el tablero
     */
    public void traducir(String pos){
        red.setMensaje("colocar;" + pos);

        System.out.println("Tradiccon -> " + this.red.getMensaje());
    }

}
