import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 24/02/14
 * Time: 08:41
 * To change this template use File | Settings | File Templates.
 */
public class SocketCliente {

    private String nickName;
    private Socket socket;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
