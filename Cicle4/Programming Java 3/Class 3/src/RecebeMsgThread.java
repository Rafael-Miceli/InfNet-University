import java.net.Socket;


public class RecebeMsgThread extends Thread {

    private Socket socket;

    public RecebeMsgThread(Socket socket){
        this.socket = socket;
    }

    public void run(){

        while(true){
            //1. LER DO SOCKET

            //2. IMPRIMIR NO CONSOLE
        }

    }

}
