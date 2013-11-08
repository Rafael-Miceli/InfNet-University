package Question3;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 08/11/13
 * Time: 09:47
 * To change this template use File | Settings | File Templates.
 */
public class Autoboxing
{
    public static void main(String args[])
    {
        //Str To int
        String strtest = "12345";
        Integer num = Integer.getInteger(strtest);
        System.out.println(num);

        //int to Integer
        int numInt = 123;
        num = (Integer) numInt;
        System.out.println(num);

        //int to Float
        Float floatingNum;
        floatingNum = (Float.intBitsToFloat(numInt));
        System.out.println(floatingNum);

        //Float to Double
        Double doubleNum = Double.valueOf(floatingNum);
        System.out.println(doubleNum);

        //float to Float
        float flot = floatingNum;
        System.out.println(flot);

        //char to Character
        char ch = 'A';
        Character chara = ch;
        System.out.println(ch);

        //Character to char
        ch = chara;
        System.out.println(chara);

        //boolean to Boolean
        boolean bool = true;
        Boolean Boll = bool;
        System.out.println(Boll);

        //Boolean to boolean
        bool = Boll;
        System.out.println(bool);

        //Boolean to String
        strtest = Boll.toString();
        System.out.println(strtest);

        //byte to Byte
        byte by = 1;
        Byte By = 0;
        By = by;
        System.out.println(By);

        //Integer to byte
        by = num.byteValue();
        System.out.println(by);
    }
}
