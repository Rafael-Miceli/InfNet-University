package Question2.Presentation;

import Question2.Domain.Model.Contact;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class CreateContact
{
    public static void main(String args[])
    {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);

        System.out.println("Sistema Cadastro de contatos");

        String name = JOptionPane.showInputDialog("Insira um nome para o contato");
        String birth = JOptionPane.showInputDialog("Insira uma data de nascimento para o contato (DD/MM/YYYY)");
        String number = JOptionPane.showInputDialog("Insira um número para o contato");

        Date birthDate = null;

        try
        {
            birthDate = format.parse(birth);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        Contact contact = new Contact(name, birthDate);
        contact.AddPhone(number);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try
        {
            fos = new FileOutputStream("contact.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(contact);

            System.out.println("Contato Cadastrado com sucesso");
        }
        catch(Exception ex)
        {
            ex.getStackTrace();
        }
        finally
        {
            try
            {
                if(fos != null)
                    fos.close();
                if(oos != null)
                    oos.close();
            }
            catch(IOException ex)
            {
                ex.getStackTrace();
            }
        }

        System.out.println("Lendo contatos");

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try
        {
             fis = new FileInputStream("contact.dat");
             ois = new ObjectInputStream(fis);

            Contact registeredContact = (Contact)ois.readObject();

            System.out.println(registeredContact);
        }
        catch (Exception ex)
        {
            ex.getStackTrace();
        }
    }

}
