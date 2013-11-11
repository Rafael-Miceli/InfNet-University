package Repository;

import Domain.Promotion;
import Domain.Supplier;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 10/11/13
 * Time: 12:32
 * To change this template use File | Settings | File Templates.
 */
public class PromotionRepository
{
    AppendableObjectOutputStream _aoos = null;
    ObjectOutputStream _oos = null;

    public void InsertPromotion(Promotion promotion)
    {
        FileOutputStream fos = null;

        try
        {
            File file = new File("Promotions.dat");

            if (file.exists())
            {
                fos = new FileOutputStream(file, true);
                _aoos = new AppendableObjectOutputStream(fos);
                _aoos.writeObject(promotion);
            }
            else
            {
                fos = new FileOutputStream(file);
                _oos = new ObjectOutputStream(fos);
                _oos.writeObject(promotion);
            }

        }
        catch(IOException ex)
        {
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
                ex.getStackTrace();
            }
        }
    }

    public List<Promotion> GetPromotions()
    {
        FileInputStream fis = null;
        ObjectInputStream  ois = null;
        List<Promotion> promotions = new ArrayList<Promotion>();

        try
        {
            fis = new FileInputStream("Promotions.dat");
            ois = new ObjectInputStream(fis);

            while(true)
            {
                try
                {
                    promotions.add((Promotion) ois.readObject());
                }
                catch(EOFException ex)
                {
                    break;
                }

            }
        }
        catch(IOException ex)
        {
            ex.getStackTrace();
        } catch (ClassNotFoundException e) {
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
                ex.getStackTrace();
            }
        }

        return promotions;
    }
}
