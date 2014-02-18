import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) {

        //1. REALIZAR UMA CONEXÃO COM O SERVIDOR
        try {
            Socket s = new Socket("CSD016W", 1000);

            //2. RECEBER MSGS - DELEGAR PARA UMA THREAD
            RecebeMsgThread reciver = new RecebeMsgThread(s);
            reciver.start();

            while(true){
                //3. LER DO TECLADO
                String input = JOptionPane.showInputDialog("Mensagem");

                //4. ENVIA PARA O SERVIDOR
                ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());

                saida.writeObject(input);
                saida.flush();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
