package Question1;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 08:57
 * To change this template use File | Settings | File Templates.
 */
public class LogExceptions {

    public static void main(String args[])
    {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try
        {
            fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            throw new Exception("Testing Exception");

        }
        catch(Exception ex)
        {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        try {
            throw new Exception("Testing Exception Again");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
