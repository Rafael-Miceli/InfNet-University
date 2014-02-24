import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor {

    public static void main(String[] args) {

        ArrayList<SocketCliente> listaBroadcast = new ArrayList<SocketCliente>();

        //Aceita a conexão
        try {
            ServerSocket server = new ServerSocket(1000);

            while(true){
                Socket socket = server.accept();

                SocketCliente socketCliente = new SocketCliente();
                socketCliente.setSocket(socket);

                listaBroadcast.add(socketCliente);

                //Tratamento do recebimento de msg e distribuição
                //AQUI EU DELEGO PARA THREAD
                BroadcastThread thread = new BroadcastThread(socketCliente, listaBroadcast);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
