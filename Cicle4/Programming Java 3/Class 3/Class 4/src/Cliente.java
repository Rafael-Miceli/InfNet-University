import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) {

        try {
            //1. REALIZAR UMA CONEXÃO COM O SERVIDOR
            Socket socket = new Socket("127.0.0.1", 1000);
            PrintStream ps = new PrintStream(socket.getOutputStream());

            //2. RECEBER MSGS - DELEGAR PARA UMA THREAD
            RecebeMsgThread reciver = new RecebeMsgThread(socket);
            reciver.start();

            //3. LER DO TECLADO
            Scanner s = new Scanner(System.in);
            while(s.hasNextLine()){
                String msg = s.nextLine();

                //4. ENVIA PARA O SERVIDOR
                ps.println(msg);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
