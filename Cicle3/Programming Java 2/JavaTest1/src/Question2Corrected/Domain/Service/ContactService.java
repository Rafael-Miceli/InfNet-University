package Question2Corrected.Domain.Service;

import Question2Corrected.Domain.Model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class ContactService
{
    private static List<Contact> _contacts = new ArrayList<Contact>();

    public void AddContact(Contact contact)
    {
        _contacts.add(contact);
    }

    public List<Contact> FindContactsByName(String name)
    {
        List<Contact> contactsToReturn = new ArrayList<Contact>();

        for(Contact contact: _contacts)
        {
            if(contact.GetName().contains(name))
                contactsToReturn.add(contact);
        }

        return contactsToReturn;
    }
}
