package Question1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 09:29
 * To change this template use File | Settings | File Templates.
 */
public class LogExceptionsFormatted {

    public static void main(String args[])
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(new FileWriter("log.txt"));

            throw new Exception("Houston a problem");
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch(Exception ex)
        {
            if (writer != null)
            {
                Date date = new Date();
                String formattedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);

                writer.println("[" + formattedDate + "]" + ex.getMessage());
            }
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }
        }


    }

}
