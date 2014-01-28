package RollerCoasterExercise;

/**
 * Created with IntelliJ IDEA.
 * User: Rafael
 * Date: 27/01/14
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
public class Program {
    public static void main(String[] args)
    {
        int voltasNaMontanhaRussa = 10;

        Assentos assentos = new Assentos(10);

        Runnable vagao1 = new Vagao(assentos);
        Runnable passageiros = new Passageiro(assentos);

        for(int volta = 0; volta < voltasNaMontanhaRussa; volta++)
        {
            Thread threadVagao = new Thread(vagao1);
            threadVagao.start();

            Thread threadPassageiros = new Thread(passageiros);
            threadPassageiros.start();
        }
    }
}
