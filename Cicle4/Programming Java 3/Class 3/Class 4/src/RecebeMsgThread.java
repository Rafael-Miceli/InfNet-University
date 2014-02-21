import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class RecebeMsgThread extends Thread {

    private Socket socket;

    public RecebeMsgThread(Socket socket){
        this.socket = socket;
    }

    public void run(){

        try {
            Scanner s = new Scanner(socket.getInputStream());
            while(s.hasNextLine()){
                //1. LER DO SOCKET
                String msg = s.nextLine();
                //2. IMPRIMIR NO CONSOLE
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
