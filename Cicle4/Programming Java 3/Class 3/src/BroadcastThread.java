import java.io.*;
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
        InputStream is = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int bufferSize = 0;

        try {

            Scanner entrada = new Scanner(_conexaoLeitura.getSocket().getInputStream());

            ArrayList<SocketCliente> Clientes = _repositorioClienteSocket.GetSockets();

            while(entrada.hasNextLine())
            {
                //LENDO DO SOCKET
                message = entrada.nextLine();
                System.out.println(message);
                System.out.println(message.toString());
                System.out.println(message.toString().isEmpty());


                is = _conexaoLeitura.getSocket().getInputStream();
                bufferSize = _conexaoLeitura.getSocket().getReceiveBufferSize();

                System.out.println(is.read());

                if (_conexaoLeitura.getNickName() == null || _conexaoLeitura.getNickName() == "")
                {
                    _conexaoLeitura.setNickName(message);

                    for (SocketCliente cliente : Clientes){
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
                    for (SocketCliente cliente : Clientes){
                        if (cliente.getSocket().getInetAddress() == _conexaoLeitura.getSocket().getInetAddress())
                            continue;

                        if (message.isEmpty()) {

                            try {
                                is = _conexaoLeitura.getSocket().getInputStream();

                                bufferSize = _conexaoLeitura.getSocket().getReceiveBufferSize();
                                System.out.println("Buffer size: " + bufferSize);

                                try {
                                    fos = new FileOutputStream("C:\\Users\\rafael.miceli\\Downloads\\test2.txt");
                                    bos = new BufferedOutputStream(fos);

                                    byte[] bytes = new byte[bufferSize];

                                    int count;

                                    while ((count = is.read(bytes)) > 0) {
                                        bos.write(bytes, 0, count);
                                    }

                                    bos.flush();
                                    bos.close();

                                } catch (FileNotFoundException ex) {
                                    System.out.println("File not found. ");
                                }
                            } catch (IOException ex) {
                                System.out.println("Can't get socket input stream. ");
                            }

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
                        }
                        else{
                            PrintStream ps = new PrintStream(cliente.getSocket().getOutputStream());
                            ps.println(_conexaoLeitura.getNickName() + ": " + message);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
