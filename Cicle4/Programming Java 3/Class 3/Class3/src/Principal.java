import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Principal {


    public static void main(String[] args) {

        try {

            String input = JOptionPane.showInputDialog("Mensagem");
            while(input != "Fim") {

                InetAddress ia = InetAddress.getByName("CSD016W");
                Socket s = new Socket (ia, 1000);


                ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());

                saida.writeObject(input);
                saida.flush();

                ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());

                try{
                    String msg = entrada.readObject().toString();
                    saida.close();
                    System.out.println(msg);

                    input = JOptionPane.showInputDialog("Mensagem");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //System.out.println(s.getLocalPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
