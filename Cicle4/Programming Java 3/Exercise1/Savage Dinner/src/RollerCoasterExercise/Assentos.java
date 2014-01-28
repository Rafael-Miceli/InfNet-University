package RollerCoasterExercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: rafael.miceli
 * Date: 28/01/14
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class Assentos
{
    private Queue<Integer> assentos = new LinkedList<Integer>();
    private int capacidade;

    public synchronized void set(int assento)throws InterruptedException
    {
        while (assentos.size() == capacidade)
        {
            System.out.println("Vagão em percurso");
            wait();
        }

        assentos.add(assento);
        System.out.println("Assento - " + assento + " preenchido");
        notify();
    }

    public synchronized int get()throws InterruptedException
    {
        while (assentos.isEmpty())
        {
            System.out.println("Vagão lotado");
        }
    }
}
