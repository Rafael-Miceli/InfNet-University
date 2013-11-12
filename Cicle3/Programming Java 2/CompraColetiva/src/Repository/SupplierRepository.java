package Repository;

import Domain.Supplier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 09/11/13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class SupplierRepository
{
    AppendableObjectOutputStream _aoos = null;
    ObjectOutputStream _oos = null;
    ObjectInputStream  _ois = null;

    public void InsertSupplier(Supplier supplier)
    {
        FileOutputStream fos = null;

        try
        {
            File file = new File("Suppliers.dat");

            if (file.exists())
            {
                fos = new FileOutputStream(file, true);
                _aoos = new AppendableObjectOutputStream(fos);
                _aoos.writeObject(supplier);
                System.out.println("Fornecedor cadastrado com sucesso!");
            }
            else
            {
                fos = new FileOutputStream(file);
                _oos = new ObjectOutputStream(fos);
                _oos.writeObject(supplier);
                System.out.println("Fornecedor cadastrado com sucesso!");
            }

        }
        catch(IOException ex)
        {
            System.out.println("Falha ao cadastrar fornecedor!");
            ex.getStackTrace();
        }
        finally {
            try
            {
                if (_aoos != null)
                    _aoos.close();
                if (_oos != null)
                    _oos.close();
                if (fos != null)
                    fos .close();
            }
            catch(IOException ex)
            {
                System.out.println("Falha ao cadastrar fornecedor!");
                ex.getStackTrace();
            }
        }
    }

    public List<Supplier> GetSuppliers()
    {
        FileInputStream fis = null;
        ObjectInputStream  ois = null;
        List<Supplier> suppliers = new ArrayList<Supplier>();

        try
        {
            fis = new FileInputStream("Suppliers.dat");
            ois = new ObjectInputStream(fis);

            while(true)
            {
                try
                {
                    suppliers.add((Supplier) ois.readObject());
                }
                catch(EOFException ex)
                {
                    break;
                }

            }
        }
        catch(IOException ex)
        {
            System.out.println("Falha ao Ler arquivo de fornecedores!");
            ex.getStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Falha ao Ler arquivo de fornecedores!");
            e.printStackTrace();
        } finally
        {
            try {
                if (ois != null)
                    ois.close();
                if (fis != null)
                    fis.close();
            }
            catch (IOException ex)
            {
                System.out.println("Falha ao Ler arquivo de fornecedores!");
                ex.getStackTrace();
            }
        }

        return suppliers;
    }
}
