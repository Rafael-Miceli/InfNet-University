import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Servidor {

    public static void main(String[] args) {

        RepositorioClienteSocket _repositorioClienteSocket;

        //Aceita a conexão
        try {
            ServerSocket server = new ServerSocket(1000);
            _repositorioClienteSocket = new RepositorioClienteSocket();

            while(true){
                Socket socket = server.accept();

                SocketCliente socketCliente = new SocketCliente();
                socketCliente.setSocket(socket);

                _repositorioClienteSocket.AddSocket(socketCliente);

                //Tratamento do recebimento de msg e distribuição
                //AQUI EU DELEGO PARA THREAD
                BroadcastThread thread = new BroadcastThread(socketCliente, _repositorioClienteSocket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
