package Domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 09/11/13
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class Promotion implements Serializable
{
    private String _title;
    private String _code;
    private Supplier _supplier;

    public String GetTitle()
    {
        return _title;
    }

    public void SetTitle(String title)
    {
        _title = title;
    }

    public String GetCode()
    {
        return _code;
    }

    public void SetCode(String code)
    {
        _code = code;
    }

    public Supplier GetSupplier()
    {
        return _supplier;
    }

    public void SetSupplier(Supplier supplier)
    {
        _supplier = supplier;
    }

}
