package Question2.Domain.Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 10:27
 * To change this template use File | Settings | File Templates.
 */
public class Contact implements Serializable
{
    private String _name;
    private Date _birth;
    private List<Phone> _phone = new ArrayList<Phone>();

    public Contact(String name, Date birth)
    {
        _name = name;
        _birth = birth;
    }

    @Override
    public String toString()
    {
        String phones = "";
        for(Phone phone: _phone)
        {
            if(phone != null)
                phones += phone + " ";
        }

        return _name + " " + new SimpleDateFormat("dd/MM/yyyy").format(_birth) + " " + phones;
    }

    public void AddPhone(String phone)
    {
        Phone phon = new Phone(phone);
        _phone.add(phon);
    }

}
