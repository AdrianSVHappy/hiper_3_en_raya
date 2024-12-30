package redPack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <h1>ClienteMain.java</h1><hr>
 * <p>Esta clase represanta el comunicador con el servidor</p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 30-dic-2024
 */
public class ClienteMain {

    private final static String COD_TEXTO = "UTF-8";

    private String ipServer, mensaje;
    private int portServer;

    public ClienteMain(String ipServer, int portServer) {
        this.ipServer = ipServer;
        this.portServer = portServer;
        this.mensaje = "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Función princial, se conecta y se comunica con el servidor
     */
    public void conectar() {
        try (Socket socket = new Socket(ipServer, portServer)) {

            System.out.println("Conectando al servidor -> " + ipServer + ":" + portServer);

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), COD_TEXTO))) {

                System.out.println("Puente");
                while ((!this.mensaje.equals("\\e"))) {

                    Thread.sleep(10);

                    if (!this.mensaje.equals("")) {
                        System.out.println("Enviar mendaje: " + this.mensaje);
                        bw.write(this.mensaje);
                        bw.newLine();
                        bw.flush();
                        this.mensaje = "";
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
