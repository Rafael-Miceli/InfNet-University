package Repository;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 10/11/13
 * Time: 11:19
 * To change this template use File | Settings | File Templates.
 */
public class AppendableObjectOutputStream extends ObjectOutputStream
{

    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException
    {
        reset();
    }
}
