import clientePack.Cliente;
import redPack.ClienteMain;

/**
 * <h1>Name.java</h1><hr>
 * <p>Esta clase represanta </p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 30-dic-2024
 */
public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("localhost", 8100);

        cliente.getRed().conectar();


    }


}
