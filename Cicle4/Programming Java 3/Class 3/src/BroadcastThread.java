import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BroadcastThread extends Thread {

    private ArrayList<Socket> _listaBroadcast;

    private Socket _conexaoLeitura;

    public BroadcastThread(	Socket conexaoLeitura, ArrayList<Socket> listaBroadcast){

        _conexaoLeitura = conexaoLeitura;
        _listaBroadcast = listaBroadcast;

    }

    //RECEBE A MSG E FAZ O BROADCAST
    public void run(){

        //PASSO 1: LER DO SOCKET
        String message = "";

        try {

            Scanner entrada = new Scanner(_conexaoLeitura.getInputStream());

            while(entrada.hasNextLine())
            {
                message = entrada.nextLine();
                System.out.println(message);

                //PASSO 2: REALIZAR O BROADCAST
                for (Socket cliente : _listaBroadcast){
                    if (cliente.getInetAddress() == _conexaoLeitura.getInetAddress())
                        continue;

                    PrintStream ps = new PrintStream(cliente.getOutputStream());
                    ps.println(message);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
