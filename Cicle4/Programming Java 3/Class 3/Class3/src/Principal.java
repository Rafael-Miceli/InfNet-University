import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Principal {


    public static void main(String[] args) {

        try {
            InetAddress ia = InetAddress.getByName("CSD016W");
            Socket s = new Socket (ia, 1000);


            ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());

            saida.writeUTF("Mensagem que o cliente mandou");
            saida.flush();

            ObjectInputStream entrada = new ObjectInputStream(s.getInputStream());

            try{
                String msg = entrada.readObject().toString();
                System.out.println(msg);
            }catch (Exception e){
                e.printStackTrace();
            }
            //System.out.println(s.getLocalPort());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
