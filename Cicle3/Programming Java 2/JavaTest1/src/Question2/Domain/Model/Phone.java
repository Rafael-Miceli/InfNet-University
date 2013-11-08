package Question2.Domain.Model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 11:40
 * To change this template use File | Settings | File Templates.
 */
public class Phone implements Serializable
{
    private String _number;

    public Phone(String number)
    {
        _number = number;
    }

    @Override
    public String toString()
    {
        if (_number != null)
            return _number;
        return "";
    }
}
