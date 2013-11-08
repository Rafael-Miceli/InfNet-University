package Question2Corrected.Domain.Model;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
public class Contact
{
    private String _name;
    private int _id;

    public int GetId()
    {
        return _id;
    }

    public String GetName()
    {
        return _name;
    }

    public Contact(String name)
    {
        _name = name;
    }
}
