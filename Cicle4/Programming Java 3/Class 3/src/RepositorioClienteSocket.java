import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 24/02/14
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class RepositorioClienteSocket {
    private ArrayList<SocketCliente> _listaBroadcast = new ArrayList<SocketCliente>();

    public void AddSocket(SocketCliente socketCliente){
        _listaBroadcast.add(socketCliente);
    }

    public void RemoverSocket(SocketCliente socketCliente){
        _listaBroadcast.remove(socketCliente);
    }

    public ArrayList<SocketCliente> GetSockets(){
        return _listaBroadcast;
    }

}
