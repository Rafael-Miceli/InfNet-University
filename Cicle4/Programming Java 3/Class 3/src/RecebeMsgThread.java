import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class RecebeMsgThread extends Thread {

    private Socket _socket;

    public RecebeMsgThread(Socket socket){
        _socket = socket;
    }

    public void run(){

        while(true){
            //1. LER DO SOCKET
            ObjectInputStream entrada = null;
            try {
                entrada = new ObjectInputStream(_socket.getInputStream());
                String msg = entrada.readObject().toString();
                System.out.println(msg);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (ClassNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


            //2. IMPRIMIR NO CONSOLE
        }

    }

}
