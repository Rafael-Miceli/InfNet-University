package trabalho;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Porcoes{
	
	private Queue<Integer> porcoes = new LinkedList<Integer>();
	private int capacidade;
	
	public Porcoes(int capacidade){
		this.capacidade = capacidade;
	}

	public synchronized void set(int porcao)throws InterruptedException{
		
	    while(porcoes.size() == capacidade){
			System.out.println("Porções bloqueada");
			wait();
		}
		
		porcoes.add(porcao);
		System.out.println("Nova porção : " + porcao);
		notify();
		
	}
	
    public synchronized int get()throws InterruptedException{
    	
    	while(porcoes.isEmpty()){
    		System.out.println("Espere uma porção");
            System.out.println("Canibal : " + Thread.currentThread().getId());
    		wait();
    	}


        int porcao = porcoes.remove();
        System.out.println("Comeu porcao : " + porcao);
        System.out.println("Canibal : " + Thread.currentThread().getId());

        notify();

		return porcao;		
	}
	
	
	
	

}
