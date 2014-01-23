package trabalho;

public class Canibal implements Runnable {

	private Porcoes porcoes;

	public Canibal(Porcoes porcoes) {
		this.porcoes = porcoes;
	}

	@Override
	public void run() {

		try {
            for (int i = 0; i < 35; i++)
			    porcoes.get();
		} catch (InterruptedException e) {
			System.out.println("Deu erro");
		}
	}

}
