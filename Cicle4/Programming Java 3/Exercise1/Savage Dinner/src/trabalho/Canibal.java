package trabalho;

public class Canibal implements Runnable {

	private Porcoes porcoes;

	public Canibal(Porcoes porcoes) {
		this.porcoes = porcoes;
	}

	@Override
	public void run() {

		try {
			porcoes.get();
            System.out.println();
		} catch (InterruptedException e) {
			System.out.println("Deu erro");
		}
	}

}
