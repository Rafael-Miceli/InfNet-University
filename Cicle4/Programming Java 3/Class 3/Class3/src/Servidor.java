import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String[] args) {

        try {
            ServerSocket s = new ServerSocket(1000);
            Socket socket = s.accept();

            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());

            saida.writeObject("mensagem enviada pela rede!!!");
            saida.flush();
            saida.close();
            socket.close();

            System.out.println("conectado!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
