import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String[] args) {

        try {
            ServerSocket s = new ServerSocket(1000);

            while (true) {

                Socket socket = s.accept();


                ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

                String msgCliente =   entrada.readObject().toString();

                ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());

                saida.writeObject("Mensagem vinda do cliente: " + socket.getInetAddress() + "\n" + msgCliente + "\nmensagem enviada pela rede!!!");
                saida.flush();

                saida.close();
                socket.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

         /*
            saida.writeObject(msgCliente);
            saida.flush();

            saida.writeObject("mensagem enviada pela rede!!!");
            saida.flush();
            */
        //System.out.println("conectado!!!");
    }

}
