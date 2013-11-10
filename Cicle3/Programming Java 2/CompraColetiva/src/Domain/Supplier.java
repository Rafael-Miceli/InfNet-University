package Domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 09/11/13
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class Supplier implements Serializable
{
    private String _razaoSocial;
    private String _cnpj;

    public String GetRazaoSocial()
    {
        return _razaoSocial;
    }

    public void SetRazaoSocial(String razaoSocial)
    {
        _razaoSocial = razaoSocial;
    }

    public String GetCnpj()
    {
        return _cnpj;
    }

    public void SetCnpj(String cnpj)
    {
        _cnpj = cnpj;
    }
}
