import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) {

        //1. REALIZAR UMA CONEXÃO COM O SERVIDOR
        try {
            Socket socket = new Socket("host", 1000);

            //2. RECEBER MSGS - DELEGAR PARA UMA THREAD
            RecebeMsgThread reciver = new RecebeMsgThread(socket);
            reciver.start();

            while(true){
                //3. LER DO TECLADO

                //4. ENVIA PARA O SERVIDOR
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
