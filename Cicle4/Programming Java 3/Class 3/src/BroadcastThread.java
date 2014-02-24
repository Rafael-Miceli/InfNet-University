import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BroadcastThread extends Thread {

    private ArrayList<SocketCliente> _listaBroadcast;
    private SocketCliente _conexaoLeitura;
    private RepositorioClienteSocket _repositorioClienteSocket;

    public BroadcastThread(	SocketCliente conexaoLeitura, RepositorioClienteSocket repositorioClienteSocket){

        _conexaoLeitura = conexaoLeitura;
        _repositorioClienteSocket = repositorioClienteSocket;

    }

    //RECEBE A MSG E FAZ O BROADCAST
    public void run(){


        String message = "";

        try {

            Scanner entrada = new Scanner(_conexaoLeitura.getSocket().getInputStream());

            while(entrada.hasNextLine())
            {
                //LENDO DO SOCKET
                message = entrada.nextLine();
                System.out.println(message);

                if (_conexaoLeitura.getNickName() == null || _conexaoLeitura.getNickName() == "")
                {
                    _conexaoLeitura.setNickName(message);

                    for (SocketCliente cliente : _repositorioClienteSocket.GetSockets()){
                        if (cliente.getSocket().getInetAddress() == _conexaoLeitura.getSocket().getInetAddress())
                        {
                            cliente.setNickName(_conexaoLeitura.getNickName());
                            continue;
                        }

                        PrintStream ps = new PrintStream(cliente.getSocket().getOutputStream());
                        ps.println(_conexaoLeitura.getNickName() + " entrou na conversa");
                    }
                }
                else
                {
                    //REALIZANDO O BROADCAST COM O APELIDO
                    for (SocketCliente cliente : _repositorioClienteSocket.GetSockets()){
                        if (cliente.getSocket().getInetAddress() == _conexaoLeitura.getSocket().getInetAddress())
                            continue;

                        try {
                            cliente.getSocket().getOutputStream().write(1);
                        }
                        catch (IOException e) {

                            String exitMessage = "\n" + cliente.getNickName() + " saiu da conversa";
                            _repositorioClienteSocket.RemoverSocket(cliente);

                            for (SocketCliente clienteSaida : _repositorioClienteSocket.GetSockets()){
                                PrintStream ps = new PrintStream(clienteSaida.getSocket().getOutputStream());
                                ps.println(exitMessage);
                            }

                            continue;
                        }

                        PrintStream ps = new PrintStream(cliente.getSocket().getOutputStream());
                        ps.println(_conexaoLeitura.getNickName() + ": " + message);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
