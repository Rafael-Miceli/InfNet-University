import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) {

        //1. REALIZAR UMA CONEXÃO COM O SERVIDOR
        try {
            Socket s = new Socket("localhost", 1000);
            PrintStream saida = new PrintStream(s.getOutputStream());

            //2. RECEBER MSGS - DELEGAR PARA UMA THREAD
            RecebeMsgThread reciver = new RecebeMsgThread(s);
            reciver.start();


            Scanner sc = new Scanner(System.in);

            String nick = null;
            System.out.println("Digite seu nickName: \n");

            while(sc.hasNextLine()){

                String input = sc.nextLine();

                //4. ENVIA PARA O SERVIDOR
                saida.println(input);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
