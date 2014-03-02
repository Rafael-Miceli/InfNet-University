import javax.swing.*;
import java.io.*;
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
                /*if (input.startsWith("@")){
                    System.out.println("Enviando arquivo no caminho " + input.substring(1, input.length()));

                    File file = new File(input.substring(1, input.length()));

                    long length = file.length();
                    if (length > Integer.MAX_VALUE) {
                        System.out.println("Arquivo muito grande.");
                    }
                    byte[] bytes = new byte[(int) length];
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream());

                    int count;

                    while ((count = bis.read(bytes)) > 0) {
                        out.write(bytes, 0, count);
                    }
                }*/
                //else{
                    saida.println(input);
                //}
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
