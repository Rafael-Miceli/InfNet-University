import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            String message = "";
            ObjectInputStream entrada = null;

            try {
                entrada = new ObjectInputStream(_conexaoLeitura.getInputStream());


                try {
                    message =  entrada.readObject().toString();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                //PASSO 2: REALIZAR O BROADCAST
                for (Socket cliente : _listaBroadcast){
                    ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                    saida.writeObject(message);
                    saida.flush();
                }

                //_conexaoLeitura.close();

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }

}
