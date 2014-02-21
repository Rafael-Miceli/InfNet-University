import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;


public class RecebeMsgThread extends Thread {

    private Socket _socket;

    public RecebeMsgThread(Socket socket){
        _socket = socket;
    }

    public void run(){


        try {

            //1. LER DO SOCKET
            Scanner s = new Scanner(_socket.getInputStream());
            while(s.hasNextLine())
            {
                String msg = s.nextLine();

                //2. IMPRIMIR NO CONSOLE
                System.out.println(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
