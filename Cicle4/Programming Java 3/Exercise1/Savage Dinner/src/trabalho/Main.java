package trabalho;

public class Main {


	public static void main(String[] args) {

		Porcoes porcoes = new Porcoes(50);

		Runnable cozinheiro = new Cozinheiro(porcoes);
		Runnable canibal = new Canibal(porcoes);

        for (int i = 0; i < 10; i++)
        {
            Thread threadCozinheiro = new Thread(cozinheiro);
            threadCozinheiro.start();

            Thread threadCanibal1 = new Thread(canibal);
            threadCanibal1.start();

            Thread threadCanibal2 = new Thread(canibal);
            threadCanibal2.start();
        }



	}


}


