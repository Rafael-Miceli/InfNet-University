package trabalho;

public class Cozinheiro implements Runnable {

    private Porcoes porcoes;
	
	public Cozinheiro(Porcoes porcoes) {
		this.porcoes = porcoes;
	}

	@Override
	public void run() {

		for (int i = 0; i < 50; i++) {
			try {
				porcoes.set(i);
			} catch (InterruptedException e) {
				System.out.println("Deu erro");
			}
		}
        //notify();
	}

}
