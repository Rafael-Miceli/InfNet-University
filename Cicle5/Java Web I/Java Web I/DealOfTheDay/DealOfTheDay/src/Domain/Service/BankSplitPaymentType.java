package Service;

import Model.Payment;

public class BankSplitPaymentType extends ComonPaymentType{
	
	@Override
	public void Pay(Payment payment) {		
		super.Pay(payment);
		
		//Exibir boleto bancário
	}

}
