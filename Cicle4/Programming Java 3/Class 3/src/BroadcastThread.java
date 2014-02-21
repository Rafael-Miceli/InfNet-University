import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class BroadcastThread extends Thread {

    private ArrayList<PrintStream> _listaBroadcast;

    private Socket _conexaoLeitura;

    public BroadcastThread(	Socket conexaoLeitura, ArrayList<PrintStream> listaBroadcast){

        _conexaoLeitura = conexaoLeitura;
        _listaBroadcast = listaBroadcast;

    }

    //RECEBE A MSG E FAZ O BROADCAST
    public void run(){

        //PASSO 1: LER DO SOCKET
        String message = "";
        ObjectInputStream entrada = null;

        try {

            entrada = new ObjectInputStream(_conexaoLeitura.getInputStream());

            try {
                message =  entrada.readObject().toString();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            System.out.println(message);

            //PASSO 2: REALIZAR O BROADCAST
            for (PrintStream cliente : _listaBroadcast){
                cliente.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
