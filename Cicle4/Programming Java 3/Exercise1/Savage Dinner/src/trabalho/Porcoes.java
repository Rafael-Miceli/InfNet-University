package trabalho;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Porcoes{
	
	private Queue<Integer> porcoes = new LinkedList<Integer>();
	private int capacidade;
    private boolean servindo = true;
    private boolean comendo = false;
	
	public Porcoes(int capacidade){
		this.capacidade = capacidade;
	}

    public void setServindo(boolean servindo)
    {
        this.servindo = servindo;
    }

    public void setComendo(boolean comendo)
    {
        this.comendo = comendo;
    }

	public synchronized void set(int porcao)throws InterruptedException{
		
	    while(porcoes.size() == capacidade || comendo){
			System.out.println("Porções bloqueada");
            comendo = false;
			wait();
		}
		
		porcoes.add(porcao);
		System.out.println("Nova porção : " + porcao);
		notify();
	}
	
    public synchronized int get()throws InterruptedException{
    	
    	while(porcoes.isEmpty() || servindo){
    		System.out.println("Espere uma porção");
            System.out.println("Canibal : " + Thread.currentThread().getId());
            servindo = true;
    		wait();
    	}

        comendo = true;
        int porcao = porcoes.remove();
        System.out.println("Comeu porcao : " + porcao);
        System.out.println("Canibal : " + Thread.currentThread().getId());

        notify();

		return porcao;		
	}
	
	
	
	

}
