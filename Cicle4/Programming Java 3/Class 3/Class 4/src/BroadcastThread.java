import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class BroadcastThread extends Thread {

    private ArrayList<Socket> listaBroadcast;

    private Socket conexaoLeitura;

    public BroadcastThread(	Socket conexaoLeitura,
                               ArrayList<Socket> listaBroadcast){

        this.conexaoLeitura = conexaoLeitura;
        this.listaBroadcast = listaBroadcast;
    }

    //RECEBE A MSG E FAZ O BROADCAST
    public void run(){

        try {
            Scanner s = new Scanner(conexaoLeitura.getInputStream());
            while(s.hasNextLine()){
                //PASSO 1: LER DO SOCKET
                String msg = s.nextLine();

                //PASSO 2: REALIZAR O BROADCAST
                //for (PrintStream ps : listaBroadcast) {
                //    ps.println(msg);
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
