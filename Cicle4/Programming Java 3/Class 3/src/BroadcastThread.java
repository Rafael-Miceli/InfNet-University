import java.net.Socket;
import java.util.ArrayList;

public class BroadcastThread extends Thread {

    private ArrayList<Socket> _listaBroadcast;

    private Socket _conexaoLeitura;

    public BroadcastThread(	Socket conexaoLeitura, ArrayList<Socket> listaBroadcast){

        _conexaoLeitura = conexaoLeitura;
        _listaBroadcast = listaBroadcast;

    }

    //RECEBE A MSG E FAZ O BROADCAST
    public void run(){

        while(true){// até ele desconectar

            //PASSO 1: LER DO SOCKET


            //PASSO 2: REALIZAR O BROADCAST
        }

    }

}
